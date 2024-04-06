#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

VM_NAME=vm_save
VM_IP=10.42.101.3

~/sae-4b01-deploiement-odoo/scripts/vm/CreateVM.sh $VM_NAME $VM_IP
echo

# Mise en place de la sauvegarde

echo "& $SCRIPT_NAME : Mise en place de la sauvegarde..."

ssh root@$VM_IP "mkdir /root/Sauvegarde"
ssh root@$VM_IP "apt install -y rsync"

scp ~/sae-4b01-deploiement-odoo/scripts/remote/Host.sh root@$VM_IP:/usr/local/bin
ssh root@$VM_IP "/usr/local/bin/Host.sh debian $VM_NAME"

echo "& $SCRIPT_NAME : Fin de l'exécution."


