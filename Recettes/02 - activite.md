# Activité

Une [activité](https://developer.android.com/reference/android/app/Activity) représente un écran qui s'affiche à l'utilisateur avec lequel il peut interragir.

## Composition d'une activité

### Interface graphique

L'interface graphique de l'activité est définit dans un fichier XML qui décrit les différents éléments graphiques à afficher.

### Logique applicative

Le comportement et les interactions avec l'interface graphique sont définits dans une classe Java.

La classe doit étendre (`extends`) la classe `AppCompatActivity` qui contient les comportements de base d'une activité

## Ajout d'une activité

### Logique applicative

- Emplacement : `app/src/main/java/votre_nom_de_package`.
- Nom du fichier : `NomActivity.java`

Squelette d'une activité qui gère des banjos.

`BanjoActivity.java`

```java
public class BanjoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banjo);
    }
}
```

> Astuce : Une fois que le `extends AppCompatActivity` a été ajouté, appuyer sur `Ctrl + o` pour ouvrir un menu qui propose d'implémenter la méthode onCreate. 

### Interface graphique

- Emplacement : `app/src/main/res/layout`.
- Nom du fichier : `activity_nom.xml`

`activity_banjo.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- TODO Ajouter un LinearLayout qui contient un TextView qui affiche le texte "Banjos à vendre" -->
```


### Mise en place

Afin qu'Android sache que l'activité a été ajoutée, il faut la déclarer dans `AndroidManifest.xml`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        ...
        <!-- TODO Ajouter le code ici -->
        ...
    </application>

</manifest>
```

#### Activité par défaut

Pour faire en sorte que l'activité soit celle qui est lancée au démarrage de l'application, il faut ajouter le code suivant dans la déclaration de l'activité :

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application>
        ...
        <!-- TODO Ajouter le code ici -->
        ...
    </application>
</manifest>
```

## Erreurs fréquentes

### ActivityNotFoundException

```txt
android.content.ActivityNotFoundException: Unable to find explicit activity class {XActivity}; have you declared this activity in your AndroidManifest.xml, or does your intent not match its declared <intent-filter>?
```

Votre activité n'a pas été déclarée dans `AndroidManifes.xml`. Référez vous à l'étape de [mise en place](#mise-en-place).

## Références

- [Vidéo du cours](https://www.youtube.com/watch?v=qvty1jwEj-4)
- [Documentation Android](https://developer.android.com/guide/components/activities/intro-activities)
