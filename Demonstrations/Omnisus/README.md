# Omnisus

J’ai trop de difficulté à utiliser Omnivox, alors j’ai décidé de développer ma propre version d’Omnivox, j’ai nommé Omnisus! C’est plus rapide, plus efficace que la vieille version d’Omnivox! Pour rendre le système plus rapide, j’ai décidé d’exécuter certaines requêtes SQL sans passer par le valideur.

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

Le serveur doit être déployé pour l’exercice, et les comptes utilisateur des étudiants doivent être créés. Les comptes utilisateur peuvent être créés à l’aide de la requête Postman «Create students». Il faut définir un header nommé `admin-password` ayant pour valeur un mot de passe prédéterminé lors du déploiement du serveur (dans application. properties).

Affichez la page principale principale de l’URL déployée en avant de la classe. C’est un tableau des scores qui affiche qui a réussi l’exercice en premier pour qu’il y ait un peu de compétition entre les étudiants.

> Cliquez quelque part sur la page du tableau des scores et allumez le son de l’ordinateur. Il devrait y avoir un signal sonore lorsqu’un étudiant réussit un exercice.
