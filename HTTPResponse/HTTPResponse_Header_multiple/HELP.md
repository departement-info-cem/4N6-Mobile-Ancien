# Getting Started

### How to start
Partir le projet dans IntelliJ trouver la classe ServerApplication
Clique sur la flèche verte pour le partir

Envoie une requête en post sur https://localhost:8787/api/addbaby

Console de données au 
https://localhost:8787/h2-console
Ensuite coller la valeur de url trouvée dans DataSourceConfig

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Deploiement sur Heroku
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku
* créer un compte heorku
* télécharger le cli
* en ligne de commandes : heroku login
* aller dans le dossier du projet : heroku create
*  heroku apps:rename kickmyb-server pour renommer appli  
* https://devcenter.heroku.com/articles/local-maven-dependencies local library fucks
* git push heroku HEAD:master
* not working because of java version. created system.properties file > java 11
* successful push but app crashes on request https://kickmyb-server.herokuapp.com/api/id/signup
* created Procfile to tell heroku how to run the app after building
* ./gradlew build -Dorg.gradle.java.home=/Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home
* heroku local web 