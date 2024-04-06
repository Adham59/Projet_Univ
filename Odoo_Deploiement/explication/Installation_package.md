# Installation package #

## sudo ##

La commande **sudo** permet d’exécuter des commandes en tant qu'administrateur (ici **root**).
À la différence de la commande **su**, on a pas besoin de connaître le mot de passe de l’utilisateur destination (**root**).

Le principe est que l’utilisateur **root** configure **sudo** en donnant des droits d’accès à certains utilisateurs pour certaines commandes.

Installez la commande sudo à l'aide de cette commande : 
~~~
apt install sudo
~~~

Puis, depuis un compte administrateur, ajouter à un utilisateur les droits de sudo via la commande suivante :
~~~
adduser <utilisateur> sudo
~~~

Si la commande est correcte et que votre installation est correcte, vous devriez avoir un message de ce type :

~~~
Ajout de l'utilisateur << user >> au groupe << sudo >> ...
Fait.
~~~

## Postgresql ##

Il existe plusieurs maniere d'installer **Postgresql** sur une machine, la plus simple est d'utiliser la commande suivante :

Pour installer la derniere version de **Postgresql**, il suffit de taper la commande suivante :
~~~
apt-get -y install postgresql
~~~

Si vous voulez installer une version spécifique de **Postgresql**, il suffit de taper la commande suivante :
~~~
apt-get -y install postgresql-<version>
~~~

L'option -y permet de répondre automatiquement oui à toutes les questions posées, cela permet de facilité l'automatisation de l'installation.

## pg_dump ##

**pg_dump** est un utilitaire en ligne de commande pour sauvegarder une base de données PostgreSQL. Il permet de sauvegarder une base de données PostgreSQL dans un fichier texte ou autre format.
Il est installé par défaut lors de l'installation de **Postgresql**.

## rsync ##
**rsync** est un outil de synchronisation de fichiers en ligne de commande. Il est utilisé pour copier des fichiers et des répertoires de manière efficace d'un emplacement à un autre.
Cette commande fonction aussi bien pour des transferts locaux que pour des transferts distants.(donc entre deux machines via un tunnel ssh par exemple).
Pour installer **rsync**, il suffit d'exécuter la commande suivante :
~~~
apt install -y rsync
~~~


## docker ##

Docker est un logiciel libre permettant de lancer des applications dans des conteneurs logiciels, c'est-à-dire des paquets contenant une application et toutes les dépendances nécessaires à son fonctionnement.
Pour installer **docker**, il suffit d'exécuter la commande suivante :
~~~	
apt install -y docker.io && apt install -y docker-compose
~~~