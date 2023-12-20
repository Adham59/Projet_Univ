
# Rapport Sae d'installation de services réseaux.

## Prépartion d'un machine virtuelle Debian

### Questions de vocabulaire et de culture informatique


**Que signifie “64-bit” dans “Debian 64-bit ?**

 Nous avons opté pour l'installation de la version Debian 64-bit car l'architecture de la machine virtuelle est en 64 bits. 

 En raison de la nature du processeur 64 bits de notre ordinateur virtuel, il est important de sélectionner la version appropriée de Debian. La notation 64-bit fait référence à la quantité d'informations que le processeur peut traiter simultanément. ([source](https://fr.wikipedia.org/wiki/Processeur_64_bits))

**Quelle est la configuration réseau utilisée par défaut ?**

 La configuration réseau par défaut est celle de l'IUT.

**Quel est le nom du fichier XML contenant la configuration de votre machine ?**

 Le fichier XML se trouve dans le fichier vbox sous le nom de sae203.vbox  (dans notre situation) ([source](https://forums.virtualbox.org/viewtopic.php?f=6&t=90311))

**Sauriez-vous le modifier directement ce fichier pour mettre 2 processeurs à votre machine ?**

 Il suffit de remplacer le chiffre entre gillemet par "2" pour mettre 2 CPU = 2 processeurs.

**Qu’est-ce qu’un fichier iso bootable ?**

Un fichier ISO bootable est un fichier image d'un disque optique qui contient l'ensemble des données nécessairespour démarrer un ordinateur à partir d'un périphérique de stockage, tel qu'un CD, un DVD ou une clé USB.([source](https://www.malekal.com/les-fichiers-iso/))

**Qu’est-ce que MATE ? GNOME ?**

MATE et GNOME sont deux environnements de bureau pour les systèmes d'exploitation basés sur Linux et Unix.([source](https://mate-desktop.org/fr/#:~:text=MATE%20est%20un%20fork%20de,d'exploitation%20similaires%20%C3%A0%20Unix.))

**Qu’est-ce qu’un serveur web ?**

Un serveur web est un logiciel qui permet de gérer et de diffuser des pages web à travers Internet ou un réseau local. Il est généralement installé sur un ordinateur spécialement dédié à cet usage, appelé serveur web, qui est connecté à Internet en permanence.([source](https://developer.mozilla.org/fr/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server))


**Qu’est-ce qu’un serveur ssh ?**

Un serveur SSH est un programme qui permet à un utilisateur distant de se connecter de manière sécurisée à un serveur ou à un ordinateur, en utilisant le protocole de communication Secure Shell (SSH).([source](https://www.it-connect.fr/chapitres/quest-ce-que-ssh/))



**Qu’est-ce qu’un serveur mandataire ?**

Un serveur mandataire (ou "proxy server" en anglais) est un serveur intermédiaire situé entre un utilisateur et Internet.Lorsqu'un utilisateur demande une ressource sur Internet (par exemple, une page web), cette requête est d'abord envoyée au serveur mandataire, qui se charge de la transmettre à Internet.([source](https://www.techno-science.net/definition/3812.html))

**Qu’est-ce qu’un fichier iso bootable ?**

Sur un système d'exploitation basé sur Unix ou Linux, il est possible de savoir à quels groupes appartient un utilisateur en utilisant la commande "groups". Cette commande affiche la liste des groupes auxquels appartient un utilisateur spécifique.([source](https://www.ionos.fr/digitalguide/serveur/know-how/quest-ce-quun-fichier-iso/))


**Comment peux-ton savoir à quels groupes appartient l’utilisateur user ?**

Sur un système d'exploitation basé sur Unix ou Linux, il est possible de savoir à quels groupes appartient un utilisateur en utilisant la commande "groups". Cette commande affiche la liste des groupes auxquels appartient un utilisateur spécifique.([source](http://manpagesfr.free.fr/man/man1/groups.1.html))


**Quel est la version du noyau Linux utilisé par votre VM ?**

La version utiliser par notre vm est 5.10.0-21-amd64.

**À quoi servent les suppléments invités ? Donner 2 principales raisons de les installer.**

Les suppléments invités (ou "Guest Additions" en anglais) sont un ensemble de logiciels et de pilotes qui peuvent être installés dans une machine virtuelle pour améliorer ses performances et ses fonctionnalités. ([source](https://lecrabeinfo.net/virtualbox-installer-les-additions-invite-guest-additions.html#:~:text=Les%20additions%20invit%C3%A9%20(guest%20additions,h%C3%B4te%20et%20la%20machine%20invit%C3%A9.)))

**Voici deux raisons principales pour lesquelles il est recommandé d'installer les suppléments invités dans une machine virtuelle :**

* Meilleure intégration de la machine virtuelle avec l'hôte :
 L'installation des suppléments invités permet de faciliter l'intégration de la machine virtuelle avec l'hôte.
 
* Meilleures performances :
 Les suppléments invités comprennent également des pilotes optimisés pour les composants virtuels de la machine, ce qui peut améliorer les performances globales de la machine virtuelle.


### Rapport sur l'installation d'une machine virtuelle [Debian](https://www.debian.org/index.fr.html)

**Installation de l'OS:**

*L'installation de la machine virutelle se fera sur [Oracle VM VirtualBox](https://www.virtualbox.org/)*

**L'installation de l'iso bootable se fera sur le site  [Debian](https://www.debian.org/index.fr.html)**

>![](./images/1.png)

**Caractéristiques à respecter :**
Il faut nommée correctement la machine, choisir le bon systeme d'exploitation et aussi son emplacement.

>![](./images/2.png)

Mémoire vive (RAM) : 2048 Mo pour être à l’aise à l’usage. 

>![](./images/3.png)

Disque dur : 20 Go entier (une seule partition), laisser le reste par défaut.

>![](./images/4.png)

**Une fois la configuration de la machine terminée vous pouvez la lancer.**

Vous tomberai normalement sur cette interface:

>![](./images/5.png)



De notre coter l'installation se fera sans interface graphique[^graphique].


Des le debut le nom de la machine nous a été demandé et on a dut la nommée sae203.

>![](./images/6.png)

**Juste apres il nous ai demander de choisir un miroir :**

On choisira entrée le miroir[^miroir] de polyctech:

>![](./images/7.png)


**Le proxy nous a été demandée.**

On a donc mis celui de l'université comme demandée: `http://cache.univ-lille.fr:3128`

>![](./images/8.png)

**Nom d'utilisateur:**

Ici celui-ci sera `User`

>![](./images/9.png)

**Identifiant du compte:**

Ici celui-ci sera `user`

>![](./images/10.png)

A noter[^noter].

**Le mot de passe:**

Ici celui-ci sera `user`


**Le mot de passe de root:**
* Comme toute bonne machine virtuelle on nous propose de donner un mot de passe au super utilisateur `root`.

>![](./images/11.png)

Ici le mot de passe sera bien evidemment *root*

**Arrive le moment du partitionnage du disque.**

Dans le tp il nous ai demander de choisir une seul partition pour l'ensemble du disque.

>![](./images/12.png)

**Dernières ajustement:**

* Sélection des logiciels de démarrage
   - environnement de bureau Debian
   - MATE (penser à décocher Gnome)
   - Serveur web
   - Serveur ssh
   - utilitaire usuels du système
   
>![](./images/13.png)

*Maintenant que l'installation de l'os est terminée nous allons procéder a une preparation du systeme.*

### Préparation du système

Nous nous sommes connecter en tant qu'utlisateur root et ajouter le groupe sudo à notre compte principal grace a la commande:
`sudo usermod -aG sudo user`
Cette commande permet d'ajouter l'utilisateur `user` au groupe `sudo`

>![](./images/14.png)

**Installation des suppléments invités**

Vien maintenant l'installation des supplément invités:

Pour debuter nous avons insérer le cd des suppléments:

>![](./images/15.png)

**1. Nous allons monter le cd en tapant cette commande dans le terminale :** [^sudo]`sudo mount /dev/cdrom /mnt`

>![](./images/16.png)

**2. Nous allons monter installer les suplléments grace a la commande  :** `sudo /mnt/VBoxLinuxAdditions.run`

>![](./images/17.png)

**Précision sur le Proxy**

Pour se qui est du proxy on a le choix entre les entrées a la main a chaque connexion comme ici:

>![](./images/18.png)

Ou de les insérer dans le bashrc pour qu'il y reste indefiniment:
Pour cela on va taper la commande `nano .bashrc`

>![](./images/19.png)

Apres avoir rentrée les 2 commande dans la bashrc ne pas oublié le `Ctrl` + `S` pour sauvegarder.


## Installation Debian automatisé par préconfiguration.

### Question et reponses sur la distribution Debian.

**Origine de Debian:**

**Combien de version au minimum sont activement maintenues par Debian ? Donnez leur nom générique (= les types de distribution).**

* Le projet `Debian` est un projet communautaire de développement de logiciels open source qui vise a créer un systeme d'exploitation GNU/Linux entièrement libre.

* Le nom `Debian` provient du nom des ces fondateur Ian Murdock et Debra Lynn qui on combiné leur 2 nom pour créer le mot Debian.([source](https://www.debian.org/doc/manuals/project-history/intro.fr.html))

**Il existe 3 durées de prise en charge (support) de ces versions : la durée minimale, la durée en support long terme (LTS) et la durée en support long terme étendue (ELTS). Quelle sont les durées de ces prises en charge ?**([source](https://wiki.debian.org/fr/LTS))

* Pour la prise en charge a long terme etendue (ELTS) : En generale 10 ans.
* Pour la prise en charge long terme : En generale environ 5 ans.
* Pour la pris en chargge minimale : En genrale environ 2 ans .



**Pendant combien de temps les mises à jour de sécurité seront-elles fournies ?**

Environ une année aprèes que la version stable suivante a été publiée, sauf loqu'une autre distribution stable et publiée la meme année.([source](https://forums.virtualbox.org/viewtopic.php?f=6&t=90311))


**Combien de version au minimum sont activement maintenues par Debian ? Donnez leur nom générique (= les types de distribution).**([source](https://www.debian.org/doc/manuals/debian-faq/getting-debian.fr.html#version))

* Debian maintient activemment 3 version qui sont :

 - Stable: C'est la version principale de Debian et est destinée au utilisateur qui on besoin d'un systeme stable et avec des mise a jour reguliere.

 - Testing: C'est une version qui permet au utilisateur de pouvoir utliser les dernieres fonctinnalitée et mise a jour avant leur sortit officiel et tout sa sur un systeme stable .

 - Unstable: C'est C'est une version qui permet au utilisateur de pouvoir utliser les dernieres fonctinnalitée et mise a jour avant leur sortit officiel mais au contraire du Testing cette version contient peut contenir de nombreux bug et est donc generalement instable.

**Chaque distribution majeur possède un nom de code différent. Par exemple, la version majeur actuelle (Debian 11) se nomme Bullseye. D’où viennent les noms de code données aux distributions ?**

Les  nom des distribution que propose Debian viennent en generale de la licence  toy story en effet on peut retrouver nom de personnage de toy story comme ([source](https://www.debian.org/doc/manuals/debian-faq/ftparchives.fr.html#codenames)) :

    - Buzz
    - Hamm
    - Woody
    - Bullseye

**L’un des atouts de Debian fut le nombre d’architecture (≈ processeurs) officiellement prises en charge. Combien et lesquelles sont prises en charge par la version Bullseye ?**([source](https://www.debian.org/doc/manuals/debian-faq/compatibility.fr.html#arches))

**La version de Bulleye prend a charges pas moins de 11 architectures :**

    - 32 bits PC (i386)
    - 64 bits PC (amd64)
    - 64 bits ARM (arm64)
    - ARM EABI (arm64)
    - ARMv7 (EABI hard-float ABI )
    - MIPS (mips (big-endian) et mipsel (little-endian))
    - MIPS 64 bits (mips64el)
    - IBM System z (s390x)
    - PowerPC (powerpc)
    - IBM POWER(ppc64el)
    - RISC-V (riscv64)



**Première version avec un nom de code ([source](https://wiki.debian.org/fr/DebianBuzz)):**

**Quelle a était le premier nom de code utilisé ?**

Le premier nom de code utlisé a été Buzz.

**Quand a-t-il été annoncé ?**

Il a été publier en juin 1996.

**Quelle était le numéro de version de cette distribution ?**

Le numero de la version de cette distribution est la 1.1.

**Dernière nom de code attribué([source](https://www.debian.org/releases/bookworm/)):**

**Quel est le dernier nom de code annoncée à ce jour ?**

A ce jour le dernier nom de code annoncée à ce jour est `Bookworm`.

**Quand a-t-il été annoncé ?**

Celui ci a étéé annoncé le 15 aout 2021.

**Quelle est la version de cette distribution ?**

Celui-ci sera donc la 12 version de Debian.



## Rapport d'installation automatique d'une machine virtuelle Debian.

### Recuperation et preparation des fichier necessaire:

**Il nous ai mis a disposition un paketage a extraire dans le fichier de la machine virtuelle**

Ici le chemin de la machine est *usr/local/virtual_machine/infoetu/saeb/adham.berrakane.etu*

>![](./images/20.png)

**Il nous ai ensuite demander de remplacer la chaîne @@UUID@@ par un identifiant unique universel.**


Nous allons nous rendre dans le dossier de la machine virtuelle ou se trouve normalement notre fichier extrait plutot : `S203-Debian11.viso`.

Et maintenant taper cette commande dans le terminale.

`sed -i -E "s/(--iprt-iso-maker-file-marker-bourne-sh).*$/\1=$(cat /proc/sys/kernel/random/uuid)/" S203-Debian11.viso`

**Voila l'iso d'instalation automatique est pret il suffie de l'inserer dans la vm.**

>![](./images/21.png)

**Une fois l'installation terminé on arrive sur la machine celle ci ne dispose d'aune interface graphique.Quand on test les utilisateur on voit que le user et root sont accessible a la connexion.**

>![](./images/22.png)

On pourrait executer la commande `tasksel` en sudo pour remedier au manque de l'interface graphique mais ici l'installation complete nous ai demander sans aucune intervention.

### Modification de la configuration de la vm.

**C'est maintenant que vien le moment de donner une interface graphique a notre vm mais aussi l'ajout de paquets qui nous serons utile pour la suite des sceances**

Pour cela nous allons nous penchez sur le fichier qui s'occupe de tout les installation sur la vm , le fichier : `preseed-fr.cfg`

Grace a se fichier nous allons pouvoir ajouter les droit `sudo`

>![](./images/23.png)

Ajouter l'interface `Mate`:

>![](./images/24.png)

Et les paketages necessaire a la prochaine partie :  `git`,`sqlite3`,`curl` `bash-completion` et `neofetch`.

>![](./images/25.png) 

# Gitea

## Configuration globale de git:

Tout d'abord nous avons ouvert un terminale et ecrit ces lignes de commande:

> ![](./images/26.png)

Bien sur il faut changer les information demander par les nôtres.

*A noté :*

> `Cette initialisation permet d’éviter le warning concernant la création d'une branche par défaut.`

## Git-gui/Gitk

Vien maintenant l'installation de git-gui et pour cela rein de plus simple il nous a suffie de taper sur le terminale `sudo apt-get install git-gui`.

**Mais qu’est-ce que le logiciel git-gui ?**

Git GUI est un logiciel open-source qui fournit une interface graphique pour Git, un système de contrôle de version de code source. Il permet aux utilisateurs de visualiser et de gérer les modifications apportées aux fichiers, de créer et de fusionner des branches de code, de gérer les conflits et de collaborer avec d'autres développeurs.([source](http://codeur-pro.fr/git-gui-guide-complet/.))

Pour le lancer rien de plus simple il suffit de taper la commande git gui.

**Qu’est-ce que le logiciel gitk ?**

Gitk est un outil graphique open-source pour Git, qui fournit une interface utilisateur graphique pour visualiser l'historique des commits, les branches de code et les différences entre les commits. Il permet de visualiser facilement les modifications apportées aux fichiers d'un projet, ainsi que les relations entre les différents commits.([source](https://github.com/virtix/git-htmldocs/wiki/gitk))

Pour le lancer rien de plus simple il suffit de taper la commande gitk.

**Mais quelle est la différence entre les deux?**

Gitk va nous permettre d’accéder a l'historique des modification et des commits alors que Git GUI lui va permettre d'effectuer les commit et les différentes modification.

**Quelle sera la ligne de commande git pour utiliser par défaut le proxy de l’université sur tous vos projets git ?**

Afin d’utiliser par défaut le proxy de l'université il faudrait taper cette commande dans le terminale([source](https://wet-boew.github.io/v4.0-ci/docs/proxy-fr.html)):

`git config --global http.proxy http://nom-utilisateur:mot-de-passe@adresse-du-proxy:port`

Bien sur il faudra changer les informations demandée dans la ligne de commande par ceux qui nous conviendront.

## Accéder au port 3000

Comme Gitea utilise par défaut le port 3000 il va falloir rediriger les messages arrivant sur le port 3000 de la machine physique vers le port 3000 de la machine virtuelle.

Pour cela nous allons faire des modification directement sur la machine virtuelle dans la section: `Configurer/réseaux`, dans la section `Avancé`.

Dans cette section nous allons crée une nouvelle redirection de port qui se nommera `Gitea` et qui aura comme port hôte et port invité la valeur 3000.

> ![](./images/27.png)

## Installation et lancement de Gitea

L'installation du binaire se fera grace au [guide d'installation](https://docs.gitea.io/en-us/install-from-binary/)


> ![](./images/28.png)


Le demarrage quand a lui se fera depuis le [guide de demarage](https://docs.gitea.io/en-us/linux-service/)

> ![](./images/29.png)

## Parametrage de Gitea

Pour verifier que le systeme est bien démarré il suffie de taper la commande : `$ systemctl status gitea.service`

Nous pourrons ensuite sur notre machine physique nous rendre sur l'url :  http://localhost:3000 

Vous tomberai sur cette page afin de faire la configuration initiale.

> ![](./images/30.png)

Les parametres a respecter serons les suivants : 

        - La base de données sera SQLite3
        - Le nom : gitea
        - Le password : gitea
        - L'email : git@localhost

Afin de proteger `/etc/gitea` et `/etc/gitea/app.ini` les ligne de commande nous on été donnée dans la [documentation](https://docs.gitea.io/en-us/install-from-binary/).

> ![](./images/31.png)


On pourrait se demnder comment faire pour la mettre a jour sans devoir tout reconfigurer?

Pour cela essayons de la mettre a jour a la version 1.19 .

En nous rendant sur le site de la doc de gitea nous somme tombai sur la partie qui nous guide pour [upgrade depuis une version plus vieille](https://docs.gitea.io/en-us/upgrade-from-gitea/).

On choisis la maniere d'upgrade depuis le binaire :

> ![](./images/32.png)


En suivant ces etapes dans l'ordre:

        - Installer le fichier binaire grace a la commande wget -O gitea https://dl.gitea.com/1.19.0/gitea-1.19.0-linux-amd64
        - Arreter completement gitea grace a la commande sudo systemctl enable gitea
        - Remplacer la version binaire de nos fichier par celle telecharger plutot et donc la mettre dans le repertoire gitea/app.ini
        - Relancer Gitea

Apres avoir suivis ces etape votre gitea sera a la nouvelle version.


## Utilisation basique 

Voici quelques projet introduit grace a l'interface web de Gitea :

> ![](./images/33.png)







[^graphique]: Libre avous a vous de choisir si vous voulez faire l'installation avec une interface graphique ou non. 
[^sudo]: La commande sudo permet d'executer les commande en tant que super utilisateur.
[^miroir]: Le miroir de base est celui de debian : deb.debian.org.
[^noter]: Si vous mettez une majuscule dans le nom de l'identifiant de compte un message d'erreur vous sera envoyer pour vous demander d'enlever la majuscule. 
