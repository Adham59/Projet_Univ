#!/bin/bash

SCRIPT_NAME=$(echo $0 | rev | cut -d "/" -f 1 | rev)

echo "& $SCRIPT_NAME Execution..."

# Répertoire où sauvegarder les fichiers de sauvegarde


if ! [ -e $CHEMIN_CLEF ] ; then
	ssh-keygen -N "" -f ~/.ssh/id_rsa
fi

ssh-copy-id -i $CHEMIN_CLEF user@10.42.101.2 > /dev/null

ssh user@10.42.101.2 << EOF
echo root | su -c 'cp /home/user/.ssh/authorized_keys /root/.ssh/'
EOF

current_date=$(date +'%Y-%m-%d')
container_psql="cont_db"
name_save="backup_$current_date.sql"

# Exécutez pg_dumpall dans le conteneur PostgreSQL et sauvegardez le résultat dans un fichier avec la date d'aujourd'hui
docker exec cont_db pg_dumpall -U odoo > "$name_save"

mv "./$name_save" "/tmp/$name_save"
# Adresse IP et chemin vers le répertoire de sauvegarde sur le serveur distant
destination_directory="root@10.42.101.3:~/Sauvegarde/"
# Options rsync
rsync_options="-avz"

# Copie de la sauvegarde vers le serveur distant
rsync $rsync_options "/tmp/$name_save" "$destination_directory"