# Configurations de machine #

## Création d'une machine virtuelle ##
Pour créer une machine virtuelle, il faut utiliser la commande suivante :
~~~
vmiut creer <nom_de_machine>
~~~
(remplacer <nom_de_machine> par le nom que vous voulez donner à votre machine, à noter que la création de la machine peut prendre un certain temps).

Après la création de la machine, il faut la démarrer avec la commande suivante :
~~~
vmiut start <nom_de_machine>
~~~
(Pour arrêter la machine, il suffit de remplacer `start` par `stop`).

## Changement de nom de machine ##
En vous situant pour savoir si le nom de la machine est correctement changé, il suffit de regarder le prompt de votre utilisateur après redémarrage.

Avant changement, votre prompt devrait ressembler à :
~~~
user@debian:~$
~~~

Pour changer le nom de la machine, il faut modifier le fichier `/etc/hosts`.
dans ce fichier remplacer **debian** par ce que vous voulez.

Après changement, votre prompt est:
~~~
user@<nouveau_nom>:~$
~~~

Puis ajouter cette ligne, qui permettra d'ajouter l'adresse de la machine virtuelle : 
~~~
<adresse_ip_machine>     <nouveau_nom>
~~~

Une fois cela fait vous pouvez vérifier vos changements avec la commande suivante :
~~~
ping <nouveau_nom> -c 2
~~~
La commande `ping` permet de vérifier si la machine est joignable, et le `-c 2` permet de limiter le nombre de ping à 2.

Si tout est correct, vous devriez avoir un résultat de ce type :
~~~
PING <nouveau_nom> (<adresse_ip_machine>) 56(84) bytes of data.
64 bytes from matrix (<adresse_ip_machine>): icmp_seq=1 ttl=64 time=0.158 ms
64 bytes from matrix (<adresse_ip_machine>): icmp_seq=2 ttl=64 time=0.063 ms
--- <nouveau_nom> ping statistics ---
2 packets transmitted, 2 received, 0% packet loss, time 1019ms
rtt min/avg/max/mdev = 0.063/0.110/0.158/0.047 ms
~~~