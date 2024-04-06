#!/bin/bash

SCRIPT_NAME=$(echo echo $0 | rev | cut -d "/" -f 1 | rev)

VM_NAME=$1
NEW_IP=$2

echo "&"
echo "& $VM_NAME"
echo "&"

echo "& $SCRIPT_NAME($VM_NAME) : Création et démarrage de la vm : $VM_NAME..."

# Création et Démarrage de la vm 
vmiut create $VM_NAME > /dev/null
vmiut start $VM_NAME

# Connection a la vm 

VM_INFO='vmiut info '$VM_NAME
OLD_IP=$( $VM_INFO | tail -n 2 | head -n 1 | cut -d '=' -f 2)

while [ ${#OLD_IP} -lt 4 ];
do
	echo "& $SCRIPT_NAME($VM_NAME) : En attente de l'addressage ip initial..."
    sleep 3
	VM_INFO='vmiut info '$VM_NAME
	OLD_IP=$( $VM_INFO | tail -n 2 | head -n 1 | cut -d '=' -f 2)
done

#Configuration de la VM
## Configuration du ssh

echo "& $SCRIPT_NAME($VM_NAME) : Transmission de la clé..."

CHEMIN_CLEF=~/.ssh/id_rsa

if ! [ -e $CHEMIN_CLEF ] ; then
	ssh-keygen -N "" -f ~/.ssh/id_rsa
fi

ssh-copy-id -i $CHEMIN_CLEF user@$OLD_IP > /dev/null

ssh user@$OLD_IP << EOF
echo root | su -c 'cp /home/user/.ssh/authorized_keys /root/.ssh/'
EOF

## Configuration du réseaux de la machine

echo
echo
echo "& $SCRIPT_NAME($VM_NAME) : Configuration du reseau de la machine..."

ssh root@$OLD_IP "hostnamectl set-hostname $VM_NAME"

ssh root@$OLD_IP << EOF_ROOT2 > /dev/null 2>&1
sed -i '/iface enp0s3 inet dhcp/c\iface enp0s3 inet static\n    address $NEW_IP/16\n    gateway 10.42.0.1' /etc/network/interfaces
echo root | su -c 'reboot'
EOF_ROOT2

echo "& $SCRIPT_NAME($VM_NAME) : Redémarrage de la Vm..."
vmiut restart $VM_NAME
sleep 20

# Installation des paquets necessaires

echo "& $SCRIPT_NAME($VM_NAME) : Installation des paquets necessaire..."

ssh root@$NEW_IP << EOF_MAJ > /dev/null 2>&1
apt-get update && apt-get -y upgrade
apt install -y sudo
usermod -aG sudo user
EOF_MAJ

echo "& $SCRIPT_NAME($VM_NAME) : Fin de script de base"