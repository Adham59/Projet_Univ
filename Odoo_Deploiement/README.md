# **_SAE-4B01-Deploiement-Odoo_**
<img src="./ressources_md/Odoo.png" alt="Logo_Odoo" width="400"/>

**Développés par Hocine CHEBOUT, Adham BERRAKANE & Théo CATTANEO**

<!-- TABLE DES MATIÈRES -->
<details open="open">
  <summary><h2 style="display: inline-block">Table des matières</h2></summary>
  <ol>
    <li><a href="#Contacts">Contatcs</a></li>
    <ul>
      <li><a href="#Répartition des taches">Répartition des taches</a></li>
    </ul>
    <li>
      <a href="#Présentation-du-projet">Présentation du projet</a>
      <ul>
        <li><a href="#Description">Description</a></li>
        <li><a href="#Sujet">Sujet</a></li>
      </ul>
    </li>
    <li>
      <a href="#Utilisation">Utilisation</a>
      <ul>
        <li><a href="#Prérequis">Prérequis</a></li>
      </ul>
  </ol>
</details>

## Contacts
* <hocine.chebout.etu@univ-lille.fr>
* <adham.berrakane.etu@univ-lille.fr>
* <theo.cattaneo.etu@univ-lille.fr>

### Répartition des taches
#### Hocine CHEBOUT
* Recherche sur l'utilisation de [pg_dump](https://docs.postgresql.fr/10/app-pgdump.html), de [rsync](https://doc.ubuntu-fr.org/rsync) et de [cron](https://doc.ubuntu-fr.org/cron) pour la sauvegarde des données
* Gestion de la sauvegarde coté serveur
* Rédaction du rapport

#### Adham BERRAKANE
* Recherche sur l'utilisation de [PostgreSQL](https://www.postgresql.org/) pour la gestion de la base de données
* Rédaction des scripts
* Gestion du débuggage général des scripts

#### Théo CATTANEO
* Recherche sur l'utilisation de [Traefik](https://traefik.io/traefik/) pour le reverse proxy
* Gestion des conteneurs Docker
* Gestion de [Traefik](https://traefik.io/traefik/) comme reverse proxy

## Présentation du projet

### Description
Nous devons mettre en place une infrastructure permettant de réaliser l’hébergement de différents serveurs [Odoo](https://www.odoo.com/fr_FR) pour des clients.
Ce déploiement devra être automatiser via la production de [scripts shell](https://doc.ubuntu-fr.org/tutoriel/script_shell) permettant un déploiment automatique.

### Sujet
Le sujet complet et détaillé est disponible [ici](./ressources_md/Sujet_SAÉ_B.pdf).

## Utilisation

### Prérequis

>**Vous n'avez pas besoin de les installés manuellement, les scripts s'en chargent pour vous.**

Pour ce projet nous avons du installer/paramétrer et/ou utiliser différentes technologies, en voici la liste :

* L'image [Odoo](https://hub.docker.com/_/odoo/)  
<img src="./ressources_md/Odoo.png" alt="Logo_Odoo" width="100"/>

* [Traefik](https://traefik.io/traefik/) comme reverse proxy  
<img src="./ressources_md/traefik_proxy.png" alt="Logo_Traefik" width="100"/>

* Le système de gestion de base de données relationnelle et d'objet [PostgreSQL](https://www.postgresql.org/)  
<img src="./ressources_md/Postgresql.png" alt="Logo_Postgresql" width="100"/>  

* Le package [pg_dump](https://docs.postgresql.fr/10/app-pgdump.html)

* Le package [rsync](https://doc.ubuntu-fr.org/rsync)  
<img src="./ressources_md/rsync.png" alt="Logo_Rsync" width="100"/>

* Le programme d'exécution automatique de scripts [Cron](https://doc.ubuntu-fr.org/cron)

La plupart de ces technologies sont expliqué [ici](./procédures/Installation_package.md).

## Fonctionnement

Pour lancer le projet, il suffit de lancer le script [`CreationGlobal.sh`](./scripts/vm/CreationGlobale.sh) avec la commande suivante :
~~~
./vm/CreationGlobal.sh
~~~

Ce script va exécuter dans l'ordre les scripts suivants :

* [`VmOdoo.sh`](./scripts/vm/VmOdoo.sh) :
Création / configuration de la machine virtuelle et installation d'Odoo

* [`VmDataBase.sh`](./scripts/vm/VmDataBase.sh) :
Création / configuration de la machine virtuelle et installation de PostgreSQL

* [`VmSave.sh`](./scripts/vm/VmSave.sh) :
Création / configuration de la machine virtuelle et installation de rsync

## Procédures

### [Création / Configuration de VM](./procédures/Configuration_machine.md)
### [Création / Configuration client](./procédures/Configuration_client.md)
