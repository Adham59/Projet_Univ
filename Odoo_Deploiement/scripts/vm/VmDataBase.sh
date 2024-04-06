#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

VM_NAME=vm_db
VM_IP=10.42.101.2

DB_USER=odoo
DB_PASSWORD=odoo
CONTAINER_PSQL=cont_db

~/sae-4b01-deploiement-odoo/scripts/vm/CreateVM.sh $VM_NAME $VM_IP
echo

# Installation de docker

echo "& $SCRIPT_NAME : Installation de docker..."

ssh root@$VM_IP << EOF_MAJ > /dev/null 2>&1
apt install -y rsync
apt install -y docker.io && apt install -y docker-compose
EOF_MAJ

# Connexion au serveur PostgreSQL et création de la base de données et de l'utilisateur
## Création de la base de données
echo "& $SCRIPT_NAME : Configuration de la base de données en cours"

scp ~/sae-4b01-deploiement-odoo/config/docker-compose-psql.yml root@10.42.101.2:~/
ssh -t root@10.42.101.2 "mv ~/docker-compose-psql.yml ~/docker-compose.yml"
echo
ssh -t root@10.42.101.2 "docker-compose up -d"
echo

#QUERY="CREATE USER $DB_USER WITH PASSWORD '\''$DB_PASSWORD'\'';"
#echo "$QUERY"
#ssh -t root@10.42.101.2 "docker exec -it $CONTAINER_PSQL psql -U postgres -c '$QUERY'"

echo

echo "& $SCRIPT_NAME : Configuration de la base de données terminée"

# Systeme de sauvegarde de la base de donnée vers la base de sauvegarde

echo "& $SCRIPT_NAME : Mise en place du systeme de sauvegarde..."

scp ~/sae-4b01-deploiement-odoo/scripts/remote/Sauvegarde.sh root@$VM_IP:/usr/local/bin/
scp ~/sae-4b01-deploiement-odoo/scripts/remote/Docker.sh root@$VM_IP:/usr/local/bin
scp ~/sae-4b01-deploiement-odoo/scripts/remote/Host.sh root@$VM_IP:/usr/local/bin

ssh root@$VM_IP << EOF_SAVE > /dev/null 2>&1
sleep 3
chmod u+x Sauvegarde.sh
mv Sauvegarde.sh /usr/bin/
(crontab -l 2>/dev/null; echo "0 1 * * * /usr/bin/Sauvegarde.sh") | crontab -
EOF_SAVE

ssh root@$VM_IP "/usr/local/bin/Host.sh debian $VM_NAME"
ssh root@$VM_IP "/usr/local/bin/Docker.sh"

echo "& $SCRIPT_NAME : Fin de l'exécution."



