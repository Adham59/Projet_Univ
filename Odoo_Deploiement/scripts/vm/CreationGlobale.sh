#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

echo "& $SCRIPT_NAME Executing..."

# Exécuter le premier script
echo
~/sae-4b01-deploiement-odoo/scripts/vm/VmOdoo.sh

# Exécuter le deuxième script
echo
~/sae-4b01-deploiement-odoo/scripts/vm/VmDataBase.sh

# Exécuter le troisième script
echo
~/sae-4b01-deploiement-odoo/scripts/vm/VmSave.sh

# Fin du script principal
echo
echo "Fin de l'installation des VMs."