#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

# Script pour déployer une nouvelle instance Odoo pour un client avec serveur PostgreSQL distant

#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#Partis Odoo container
## Définition des variables

IP_VM_ODOO=10.42.101.1
CONTAINER_PSQL=cont_db
DB_USER=odoo
DB_PASSWORD=odoo

echo "& $SCRIPT_NAME : Execution..."

##Déploiement du conteneur Odoo pour le client
### Creation du docker-compose.yml

echo
echo "& $SCRIPT_NAME : Supression des fichiers de configuration locaux..."

rm -f ~/sae-4b01-deploiement-odoo/config/docker-compose-odoo-traefik.yml
rm -f ~/sae-4b01-deploiement-odoo/config/odoo.conf.*

echo "& $SCRIPT_NAME : Supression des contenairs distants..."

scp ~/sae-4b01-deploiement-odoo/scripts/remote/PurgeContainers.sh root@$IP_VM_ODOO:~/
ssh -t root@$IP_VM_ODOO "~/PurgeContainers.sh"

echo "& $SCRIPT_NAME : Supression des fichiers de configuration distants..."

ssh -t root@$IP_VM_ODOO "rm -f ~/docker-compose.yml"
ssh -t root@$IP_VM_ODOO "rm -f ~/odoo.conf.*"

echo

echo "& $SCRIPT_NAME : Initialization du docker-compose..."
~/sae-4b01-deploiement-odoo/scripts/generator/InitializeComposeOdooTraefik.sh
echo

redirected_port=8069
while true; do

    read -p "Saisissez le nom de l'instance (ou 'fini' pour quitter) : " instance_name

    if [ "$instance_name" = "fini" ]; then
        break
    fi

    read -p "Saisissez le numero de version : " version
    echo

    echo "& $SCRIPT_NAME : Mise à jour du docker-compose..."
    ~/sae-4b01-deploiement-odoo/scripts/generator/UpdateComposeOdooTraefik.sh $instance_name $version $redirected_port
    ((redirected_port++))

    echo "& $SCRIPT_NAME : Création du odoo.conf"
    ~/sae-4b01-deploiement-odoo/scripts/generator/CreateConfOdoo.sh $instance_name

    echo "& $SCRIPT_NAME : Transfert du odoo.conf..."
    scp ~/sae-4b01-deploiement-odoo/config/odoo.conf.$instance_name root@$IP_VM_ODOO:~/
    echo

done

scp ~/sae-4b01-deploiement-odoo/config/docker-compose-odoo-traefik.yml root@$IP_VM_ODOO:~/

echo "& $SCRIPT_NAME : Transfert du docker-compose..."
ssh -t root@$IP_VM_ODOO "mv ~/docker-compose-odoo-traefik.yml ~/docker-compose.yml"
echo

echo "& $SCRIPT_NAME : Execution du docker-compose..."
ssh -t root@$IP_VM_ODOO "docker-compose up -d"
echo

echo "& $SCRIPT_NAME : Déploiement d'odoo terminé"
