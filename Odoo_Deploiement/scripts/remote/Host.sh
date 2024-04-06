#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

ancien_nom=$1
nouveau_nom=$2

nouveaux_hosts=(
    "vm_odoo 10.42.101.1"
    "vm_db 10.42.101.2"
    "vm_save 10.42.101.3"
)

if grep -q "$ancien_nom" /etc/hosts; then
    # Remplacement du nom dans le fichier /etc/hosts
    sudo sed -i "s/$ancien_nom/$nouveau_nom/g" /etc/hosts
    echo "& $SCRIPT_NAME($nouveau_nom) : Le nom $ancien_nom a été remplacé par $nouveau_nom dans /etc/hosts."
else
    echo "& $SCRIPT_NAME($nouveau_nom) : Le nom $ancien_nom n'a pas été trouvé dans /etc/hosts."
fi

echo
for entry in "${nouveaux_hosts[@]}"; do

    host=$(echo "$entry" | awk '{print $1}')
    ip=$(echo "$entry" | awk '{print $2}')
    echo "& $0($nouveau_nom) : "
    echo "$ip $host" | sudo tee -a /etc/hosts >/dev/null
done
echo