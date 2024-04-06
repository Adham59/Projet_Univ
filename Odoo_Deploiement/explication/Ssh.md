# Installation et configuration d'un pont ssh #

## Installation de ssh ##
### Création de clé ssh ###

Pour fabriquer une paire de clé, vous allez utiliser la commande `ssh-keygen` sur votre machine physique avec les paramètres par défaut.
Lors de l’utilisation, la commande vous demandera deux choses:

> **un nom de fichier :** vous pouvez laisser le nom de fichier par défaut. Notez le. Il est bon de le connaître pour la suite.

> **une passphrase :** c’est un mot de passe qui permet de chiffrer le fichier contenant votre clé privé. Il est très important d’utiliser un mot de passe pertinent et de ne pas le partager à d'autre personne que vous.
Ainsi, si on vous vole le fichier, le voleur ne pourra pas se servir de votre clé.

Pour générer une paire de clé, il suffit de taper la commande suivante :
~~~
ssh-keygen
~~~

**emplacement du fichier ssh** : /home/infoetu/login/.ssh

**clé ssh générée** : SHA256:<la clé généré> <utilisateur>

Maintenant pour pouvoir vous connecter à la machine virtuelle voulue :
~~~
ssh <utilisateur>@<adresse ip>
~~~
Pour la machine virtuelle liée à la base de données par exemple :
~~~
ssh root@10.42.101.2
~~~