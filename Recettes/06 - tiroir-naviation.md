# Tiroir de Navigation (Navigation Drawer)

Un tiroir de navigation permet à l'utilisateur d'accéder rapidement à des fonctionnalités de l'application en encombrant minimalement l'interface visuelle.

## Mise en place

### Dépendances

Le tiroir de navigation n'est pas disponible par défaut dans Android, il faut ajouter les librairies qui y correspondent.

`build.gradle`

```groovy
dependencies {
    // TODO Ajouter les dépendances ici
    ...
}
```

### Ajout du tiroir dans l'activitié

Rappel des différentes balises :

- `DrawerLayout` : Pour ajouter un tiroir, la balise à ajouter doit englober l'ensemble de ce qui se retrouvera dans l'activité. Notez que le `DrawerLayout` ne définit pas ce qui se retrouve dans le tiroir de navigation, il s'agit davantage d'un conteneur.
- `CoordinatorLayout` : Coordoner les comportements de différents éléments de niveau supérieur. Dans le contexte présent, c'est le conteneur de ce qui doit être affiché dans l'activité.
- `NavigationView` : Définit le contenu du tiroir de navigation. Le attributs suivants du `NavigationView` sont particulièrement importants :
  - `app:menu` : Définit le menu à afficher dans la partie principale du tiroir de navigation. La valeur associée devrait faire référence à un fichier XML situé dans `res/menu`, semblable à celui vu dans un ActionBar.
  - `app:headerLayout` : Définit l'apparence de l'en-tête du navigation layout. La valeur associée devrait faire référnece à un fichier XML situé dans `res/layout`. Si cet attribut est omis, il n'y aura simplement pas d'en-tête sur le tiroir de navigation.

`main_activity.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- TODO Ajouter le code pour afficher le tiroir de navigation. Le contenu princiap de l'activité doit être un simple TextView -->
```

> Info : À ce stade, si vous n'avez pas encore lié votre XML à votre code Java, rien ne devrait apparaitre.
> Truc : Donner des couleurs d'arrière-plan aux différentes composantes pour s'assurer que chaque élément apparait comme prévu.
> Attention : Votre application ne compilera pas si les attributs du `NavigationView`, `app:menu` et / ou `app:headerLayout` ont été définis mais que les fichier sur lesquels ils pointent sont innexistants. Vous trouverez comment définir ces fichiers plus bas dans ce document. En attendant, vous pouvez omettre ces options pour tester votre application.

### Définition du menu

Tel que mentionné à l'étape précédente le menu à afficher, qui est référé dans l'attribut `app:menu` de `NavigationView` doit être définit dans `res/menu`.

`navigation_drawer.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- TODO Ajouter le code pour 3 items. Chaque item doit au moins avoir un id et un titre -->
</menu>
```

> Info : À ce stade, si vous n'avez pas encore lié votre XML à votre code Java, rien ne devrait apparaitre.

### Lier le XML du tiroir au code Java

Pour simplement afficher le tiroir de navigation, simplement faire comme avec n'importe quelle activité. Il ny a donc rien de spécifique au tiroir de navigation pour le moment.

`MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {

    // TODO Ajouter le code pour le ViewBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Ajouter le code pour le ViewBinding
    }
}
```

### Réagir aux boutons de menu du tiroir de navigation

Une référence au NavigationView est nécessaire pour réagir à l'appuis sur les différentes options de navigation.

Une référence au Drawer layout est aussi nécessaire pour demander au tiroir de navigation de se fermer.

`MainActivity.java`

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    // TODO Ajouter le code pour obtenir le NavigationView et le DrawerLayout

    // TODO Ajouter le code pour réagir au différents items du menu
}
```

Les fonctionnalités minimales afin de faire fonctionner le tiroir de navigation ont maintenant été implémentées. Pour afficher le tiroir de navigation, vous pouvez glisser votre doigt à partir d'un rebord à gauche de l'écran, vers le centre de l'écran.

Les prochaines étapes servent à le rendre plus polyvalent, plus robuste aux changements dans l'interface et à ajouter un menu hamburger.

> Vous remarquerez que l'interaction avec les éléments de menu sont semblable à celles qui ont été vues dans le ActionBar.

### Ajout d'un en-tête au tiroir de navigation

L'en-tête permet de donner un style personnalisé à notre application, et donne le contrôle sur l'apparence du tiroir de navigation.

Une fois le XML de l'en-tête définit, il faut simplement s'assurer que l'attribut `app:headerLayout` est définit sur le `NavigationView` dans `activity_main.xml`.

`header_layout.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- TODO Ajouter un TextView qui a les attributs suivants :
         - Couleur de fond mauve
         - Texte "Mon super en-tête
         - Taille du texte de 30sp  -->
</LinearLayout>
```

### Menu hamburger

Dans l'état actuel de l'application, il est uniquement possible d'afficher le tiroir de navigation en balayant son doigt de gauche à droite.

Nous allons ajouter bouton à gauche de l'ActionBar afin d'afficher ou de cacher le tiroir de navigation.

`MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    
    // Mis dans un variable d'instance pour être réutilisé plus tard
    private ActionBarDrawerToggle actionBarToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO Ajouter le code pour afficher le bouton hamburger

        // TODO Ajouter le code pour créer l'objet qui définit le comportement du bouton hamburger
        // On doit aussi afficher "Ouvert" lorsque le tiroir s'ouvre, et le titre de l'activité doit afficher "Ouvert"
        // On doit aussi afficher "Fermé" lorsque le tiroir se ferme, et le titre de l'activité doit afficher "Fermé"

        // TODO Associer le comportement définit au DrawerLayout

        // TODO Synchronise avec l'état du tiroir
        
        // Reste du code définit précédement
    }

    // TODO Ajouter le code pour Ouvrir / fermer le menu au clic sur le bouton hamburger

    // TODO Ajouter le code pour assurer le fonctionnement lorsque l'appareil effectue une rotation
}
```

Deux string doivent être ajoutées dans les ressources (`res/values/strings.xml`). Ces chaînes de caractère servent à améliorer l'expérience des personnes mal voyantes qui utilisent votre application.

`strings.xml`

```xml
<resources>
    ...
    <!-- Ajouter les 2 chaines de caractère nécessaire pour créer l'objet qui définit le comportement du bouton hamburger -->
</resources>
```

## Références

- [Vidéo du cours - Tiroir de navigation](https://www.youtube.com/watch?v=T2upKap9Jic)
- [Vidéo du cours - Menu hamburger](https://www.youtube.com/watch?v=W3EjsclJ6nQ)
