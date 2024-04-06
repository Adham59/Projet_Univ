#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

VM_NAME=vm_odoo
VM_IP=10.42.101.1

~/sae-4b01-deploiement-odoo/scripts/vm/CreateVM.sh $VM_NAME $VM_IP
echo

# Installation de docker

echo "& $SCRIPT_NAME : Installation de docker..."

ssh root@10.42.101.1 << EOF_MAJ > /dev/null 2>&1
apt install -y docker.io && apt install -y docker-compose
EOF_MAJ

# Installation des scripts

echo "& $SCRIPT_NAME : Copie des scripts..."

scp ~/sae-4b01-deploiement-odoo/scripts/client/Client.sh root@$VM_IP:~
scp ~/sae-4b01-deploiement-odoo/scripts/remote/Docker.sh root@$VM_IP:/usr/local/bin
scp ~/sae-4b01-deploiement-odoo/scripts/remote/Host.sh root@$VM_IP:/usr/local/bin

# Lancement des scripts

echo "& $SCRIPT_NAME : Lancement des scripts..."

ssh root@$VM_IP "/usr/local/bin/Host.sh debian $VM_NAME"
ssh root@$VM_IP "/usr/local/bin/Docker.sh"

echo "& $SCRIPT_NAME : Configuration de la VM $VM_NAME terminée"
