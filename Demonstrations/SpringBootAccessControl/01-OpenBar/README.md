# Spring Boot Access Control
Sert de démo pour illustrer des failles de contrôle d'accès pour Spring Boot et les solutions

Illustrer avec 5 versions d'une application identiques en terme de fonctionnalités.


Pas de sécurité du tout, envoie l'id de l'utilisateur pour créer
EXPLOIT > envoyer une requête avec son ID

Token oui mais on utilise l'ID de l'utilisateur dans classe
EXPLOIT > mettre l'ID De qqun d'autre pour créer un Quiz dans son compte

Token et id pris dans l'utilisateur mais pas de test de propriété
EXPLOIT > envoie un ajout de question dans un quiz mais un quiz qui n'est pas à moi
Lecture écriture > vérifier propriétaire

Token, id du token, test de propriété au create mais pas au update
EXPLOIT > envoie une modif de question dans un quiz pas à moi.



Conclusion :  le contrôle d'accès ne change rien ... pour les gentils utilisateurs.
Ce qu'il change, c'est la protection des gentils contre les méchants, le côté obscur



