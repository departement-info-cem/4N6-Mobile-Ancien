# Notice pour le prof pour le CTF:

- Cloner ou télécharger le projet https://github.com/departement-info-cem/KickMyB-Android
- Cloner ou télécharger le projet https://github.com/departement-info-cem/KickMyB-Server/tree/CTF
- Lancer le serveur en local
- Afficher au projecteur ou tableau l'URL du serveur du prof : http://xxx.xxx.xxx.xxx:8080/
- Ouvrir le projet Android et lancer les tests unitaires dans https://github.com/departement-info-cem/KickMyB-Android/blob/main/app/src/androidTest/java/org/kickmyb/TestServiceHTTP.java
- Il faut cacher le code du test car le mot de passe de l'utilisateur victime apparait en clair
- Afficher aux étudiant le Logcat avec le filtre CTF. Cela leur donne la tâche qu'ils doivent modifier et le pourcentage qu'ils doivent mettre
- Lancer l'application pour permettre de vérifier. Le login et le mot de passe du compte victime sont dans le test unitaire (attention que les étudiants ne le voient pas)
Quand un étudiant pense avoir réussi on peut refresh la liste pour valider.
