# Server-Debug
Spring Boot Server for showing Server Debugging

## STEP 1 - Show students the bad file structure
## STEP 2 - Regroup exceptions, Spring boot classes and logic / code classes
## STEP 3 - Start sending HTTP request through Postman to find bugs

* GET - localhost:8080/test | Check if server is running properly

* POST - localhost:8080/req1 | Won't work. Need to change String by Testou (or send info in GET param)
["Tomate", "Jambon"] JSON Raw
--> Envoie une liste, mais s'attend à un String

--> Chaque fois nous appelle, avoir le breakpoint à la bonne ligne
--> Faire le premier avec eux
* GET - localhost:8080/req2 | Division by zero on line 28 (JaIme.java). The initial message says nothing. Caused by is not helpful. You have to use breakpoint for this one.

* GET - localhost:8080/req2 | Null pointer Exception et NFE on line 51 caused by line 47 (JaIme.java). You have to use breakpoint for this one.

* GET - localhost:8080/req2 | Number Format Exception on line 59 caused by line 57 (JaIme.java). You have to use breakpoint for this one.

--> Peaufiner énoncé pour lui
* GET - localhost:8080/req3 | Long overflow on line 27 (Comptes.java). The try/catch is at controller level. We sent back a success message when it's not. If the server was deployed, we would have no way to know it didn't work. We have no information on the exception