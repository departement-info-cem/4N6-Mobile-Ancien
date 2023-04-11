# Omnisus

J’ai trop de difficulté à utiliser Omnivox, alors j’ai décidé de développer ma propre version d’Omnivox : j’ai nommé Omnisus! C’est plus rapide et plus efficace que la vieille version d’Omnivox! Pour rendre le système plus rapide, j’ai décidé d’exécuter certaines requêtes SQL sans passer par le valideur.

L’examen 1 a vraiment mal été pour les étudiants, j’espère qu’ils ne vont pas essayer de pirater le système pour modifier leurs notes!

## Pour l’étudiant

Un compte a été créé pour vous dans le système. Si vous n’avez pas reçu votre nom d’utilisateur et votre mot de passe, demandez-le à votre enseignant.

1. Commencez par modifier le nom d’affichage de votre utilisateur. Votre nouveau nom devrait s’afficher dans le tableau des scores en avant de la classe.
2. Votre objectif est de modifier votre note de l’Examen 1 pour vous donner 100 %. Vous devez la modifier sur le serveur déployé.

> Indice pour connaitre l’adresse du serveur déployé : où est-ce qu’on définit l’URL du serveur dans un projet Android?

### Suggestions pour commencer

- Explorez l’application : connectez-vous, explorer les pages.
- Trouvez l’URL du serveur déployé.
- Créez un environnement Postman qui définit une variable d'environnement `addr` qui a pour valeur l'url du serveur déployé
- Familiarisez-vous avec les différentes requêtes Postman. Pas la peine d’essayer d’utiliser les requêtes Admin, elles sont pour la mise en place de l’exercice, ce n’est pas là que la vulnérabilité est située.
- Essayez d’identifier l’endroit dans le code du serveur qui vous semble vulnérable (vous pouvez confirmer avec votre enseignant quand vous pensez avoir trouvé).
- 

**Si vous bloquez pendant plus de 5-10 minutes, demandez de l’aide à votre enseignant.**

## Pour l’enseignant

Le serveur doit s'exécuter sur votre machine, de sorte que les étudiants s'y connecte, et les comptes utilisateur des étudiants doivent être créés. Les comptes utilisateur peuvent être créés à l’aide de la requête Postman «Create students». Un script python permet de générer rapidement le json pour la création des comptes étudiant. Il faut définir un header nommé `admin-password` ayant pour valeur un mot de passe prédéterminé lors du déploiement du serveur (dans application. properties).

Affichez la page principale principale de l’URL  en avant de la classe (ex: http://nom-de-votre-machine/). C’est un tableau des scores qui affiche qui a réussi l’exercice en premier pour qu’il y ait un peu de compétition entre les étudiants.

> Cliquez quelque part sur la page du tableau des scores et allumez le son de l’ordinateur. Il devrait y avoir un signal sonore lorsqu’un étudiant réussit un exercice.

### Déroulement de l'exercice

Puisque l'exercice est assez complexe, il est recommendé de donner environs une heure aux étudiants pour tenter de compléter l'exercice, pour ensuite le compléter avec eux.

De plus, il est recommendé de dessiner un schéma de la base de données au tableau pour les aider à progresser plus rapidement dans la création de leur requête.

### Utilisation du script

Le script s'attend à recevoir un fichier généré par Omnivox. 

Pour générer un fichier sous le bon format :

- Dans Omnivox, naviguer vers une classe dans LÉA
- Liste des étudiants -> Paramètres d'affichage
- Sélectionner les options suivantes
  - Cocher "Pour Excel" et sélectionner le séparateur ";"
  - Liste truée par: "Numéro d'étudiant"
  - Taille de la police: "Petite"
  - Sous les éléments à inclure dans la liste, cocher uniquement "Numéro d'étudiant"

Dans un terminal, la commande ressemble donc à `python generate_users.py ListeEtudiants_cours4204N6EM_gr1030.csv`
