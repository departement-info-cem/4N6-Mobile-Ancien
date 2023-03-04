# i18n

L'[i18n](https://en.wikipedia.org/wiki/Internationalization_and_localization) est une pratique où l'on tente de rendre accessible une application en la traduisant dans diverse langue, parfois selon des régions.

Dans le contexte d'une application Android, on souhaite que les textes affichés dans l'application s'affichent dans la langue définie sur l'appareil sur lequel l'application s'exécute. Un téléphone configuré en français devrait donc afficher des textes en français, idem pour l'anglais si l'appareil est configuré en anglais.

## Ressources

Dans une composante visuelle, en XML, il est parfois possible de spécifier un texte. Par exemple, avec l'attribut `android:text` de la composante `TextView`.

`activity_main.xml`

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="To go to" />
```

Pour éventuellement traduire le texte **Bienvenue**, il faut extraire le texte dans un fichier de ressources.

Le fichier `strings.xml` situé dans `res/values` permet de stocker des textes auquels on peu faire référence au travers de l'application. Chaque texte à stocker est stocké dans une balise `string`. On peut ajouter le texte du `TextView` comme contenu de la balise `string`, et lui définir une clé à l'aide de l'attribut `name`.

`strings.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="to_goto">To go to</string>
</resources>
```

> Truc : En positionnant son curseur sur le texte **Bienvenue**, et en tapant le raccourci `Alt + Enter`, Android Studio nous propose d'extraire automatiquement le texte dans les ressources.

## Référencer une ressource

Il est maintenant possible de se référer au texte définit dans `strings.xml` en faisant référence à la clé `greeting` définit.

`activity_main.xml`

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/to_goto" />
```

## Traduire une ressource

Maintenant que le texte fait référence à un fichier de ressource (`strings.xml`), il faut ajouter une fichire de ressource par langue supportée par l'application. Chaque fichier de ressource doit contenir les même entrées ayant les même clés que celles définies plus haut, mais dont le contenu des balise correspond au texte traduit.

Ajouter un fichier de ressource pour une langue dans Android Studio :

- Clic droit sur `res/values`
- New -> Values Resource File
- File name : `strings.xml`
- Dans le menu de gauche
  - Sélectionner `Locale`
  - Appuyer sur la flèche "`>>`"
- Dans "Languages:", chercher la langue de traduction souhaité
- (Optionnel) : Si la langue doit être taduite pour une région spécifique (Ex : français de France vs québécois), sélectionner la région dans la liste "Specific Region Only", sinon laisser à "Any Region".

Ajouter les traductions dans le fichier ajouté.

Exemple pour un fichier `strings.xml` dont on a définit la langue comme québécois.

`strings.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="to_goto">Arsoudre</string>
</resources>
```

Maintenant le texte du `TextView` devrait toujours afficher "To go to", à moins que l'appareil soit configué en québécois. Alors, le texte affichera "[Arsoudre](https://www.cordial.fr/dictionnaire/definition/arsoudre.php)".

> Remarque Android tente toujours de traduire avec autant de spécificité que possible. Par exemple, s'il existe un fichier pour le français du Québec et un fichier pour la langue française toute culture confondue. Un appareil configuré pour le Québec recevra les traductions spécifiques au Québec, alors qu'un appareil configuré pour le français de la Martinique recevra des traduction pour la langue française toute culture confondue. Sinon le fichier `strings.xml` de base est utilisé.

## i18n dans le code Java

Il est aussi possible de faire référence à un fichier de ressource à partir du code Java d'une activité.

Si on ajoute une `id` à note `TextView` utilisé plus haut.

`activity_main.xml`

```xml
<TextView
    android:id="@+id/mon_to_goto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/to_goto" />
```

`MainActivity.java`

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView monToGoTo = (TextView) findViewById(R.id.mon_to_goto);
    // monToGoTo.setText("To go to");    // Afficher directement un texte
    monToGoTo.setText(R.string.to_goto); // Se référer au fichier de ressource
}
```

> Attention : si on fait un `monToGoTo.setText(12)`, le chiffre 12 ne va pas s'afficher à l'écran comme on pourait s'y attendre. Android va plutôt essayer de chercher à l'interne s'il existe une ressource dont le id généré est 12, et risque de ne rien trouver et de faire crasher l'application. Si on veut vraiment afficher 12, on peut s'assurer que Java traite le contenu de `setText` comme une `String` en ajouter `+ ""` après le nombre, comme suit : `monToGoTo.setText(12 + "")`.

## Références

- [Vidéo du cours](https://www.youtube.com/watch?v=kP1o8F9qWfs)
