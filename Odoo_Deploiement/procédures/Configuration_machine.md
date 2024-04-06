# Création / Configuration de VM #

Les scripts excécutés par ['CreationGlobal.sh'](../scripts/vm/CreationGlobale.sh) excécutent eux même le script ['CreateVm.sh'](../scripts/vm/CreateVm.sh) qui excécute les étape suivante :

* Création d'une machine virtuelle avec la commande suivante :
~~~
vmiut create <nom_de_machine>
~~~
(remplacer <nom_de_machine> par le nom que vous voulez donner à votre machine, à noter que la création de la machine peut prendre un certain temps).

* Démarrage de la machine virtuelle avec la commande suivante :
~~~
vmiut start <nom_de_machine>
~~~

* Configuration d'un pont ssh pour se connecter à la machine virtuelle :
    * Génération de clé ssh avec la commande suivante :
    ~~~
    ssh-keygen -N "" -f ~/.ssh/id_rsa
    ~~~
    * Copie de la clé ssh sur la machine virtuelle avec la commande suivante :
    ~~~
    ssh-copy-id -i ~/.ssh/id_rsa.pub user@<adresse_ip>
    ~~~
* mise à jour de la machine virtuelle avec la commande suivante :
~~~
apt-get update && apt-get -y upgrade
~~~
* Installation et gestion de sudo avec la commande suivante :
~~~
apt-get install -y sudo
usermod -aG sudo user
~~~
    
