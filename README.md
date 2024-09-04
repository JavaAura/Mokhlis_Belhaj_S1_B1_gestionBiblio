# Application de Gestion d'une Bibliothèque Municipale

## Contexte du Projet

Ce projet consiste à automatiser les tâches d'une bibliothèque municipale à travers une application console en Java 8. L'application permet de gérer l'inventaire des livres et magazines ainsi que les emprunts et retours.

## Fonctionnalités Principales

- **Ajouter un document** (livre ou magazine)
- **Emprunter un document**
- **Retourner un document**
- **Afficher tous les documents**
- **Rechercher un document**
- **Quitter l'application**

## Structure de l'Application

L'application suit une architecture en couches, divisée en trois parties principales :

1. **Couche de présentation :**
   - **ConsoleUI :** Gère l'interface utilisateur en console.

2. **Couche métier :**
   - **Document (classe abstraite) :** Représente un document générique avec des attributs tels que `id`, `titre`, `auteur`, `datePublication`, `nombreDePages`.
   - **Livre :** Hérite de `Document` et ajoute un attribut `isbn`.
   - **Magazine :** Hérite de `Document` et ajoute un attribut `numero`.
   - **Bibliotheque :** Gère l'inventaire des documents (ajout, recherche, emprunt, retour).

3. **Couche utilitaire :**
   - **DateUtils :** Fournit des méthodes pour la manipulation des dates.

## Spécifications Techniques

- **Stockage des documents :** Utilisation d'`ArrayList` pour stocker les documents.
- **Recherche rapide :** Utilisation de `HashMap<String, Document>` pour une recherche efficace des documents.
- **Gestion des dates :** Intégration de l'API `Java Time` pour la gestion des dates.
- **Expressions lambda :** Utilisation des expressions lambda pour optimiser certaines opérations.

## Menu Interactif

L'application propose un menu interactif pour permettre à l'utilisateur de sélectionner l'une des actions suivantes :

1. Ajouter un document
2. Emprunter un document
3. Retourner un document
4. Afficher tous les documents
5. Rechercher un document
6. Quitter l'application

L'utilisateur est invité à entrer son choix (1-6).



## Technologies Utilisées

- **Java 8**
- **git** pour le contrôle de version
- **Github project** pour la gestion de projet

## Prérequis

Avant d'exécuter l'application, assurez-vous que les éléments suivants sont installés sur votre machine :

1. **Java Development Kit (JDK) 8 :**  
   L'application est développée avec Java 8. Vous pouvez télécharger et installer le JDK depuis le site officiel d'Oracle ou utiliser une distribution alternative comme OpenJDK.

2. **Variable d'environnement JAVA_HOME :**  
   Assurez-vous que la variable d'environnement JAVA_HOME pointe vers le répertoire d'installation du JDK.

3. **Mise à jour du PATH :**  
   Ajoutez le répertoire `bin` du JDK à votre variable d'environnement PATH pour pouvoir exécuter les commandes Java à partir du terminal.


## Installation

Pour exécuter l'application de gestion de bibliothèque, suivez les étapes ci-dessous :

1. **Cloner le dépôt :**

   Clonez le dépôt Git en utilisant la commande suivante :
   ```bash
   git clone https://github.com/JavaAura/Mokhlis_Belhaj_S1_B1_gestionBiblio.git
   ```
2. **Exécuter l'application :**

Ouvrez l'invite de commande (CMD) ou un terminal et Exécutez l'application en utilisant la commande suivante :

```bash
java -jar <chemin_vers_le_fichier_biblio.jar>
```

## Auteur

Mokhlis Belhaj
