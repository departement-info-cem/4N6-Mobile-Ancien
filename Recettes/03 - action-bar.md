# Action bar (Barre de menu)

La barre d'action permet d'afficher du texte pour donner du contexte à l'activité courante et d'ajouter des bouton

## Ajouter une barre de menu

Le modèle d'ctivité "Empty Activity" contient une barre de menu par défaut. Nous allons voir comment la configurer.

### Titre

Par défaut, la barre de menu va chercher la valeur qui correspond à la clé `android:label`. On commence donc par s'assurer que la clé contient le bonne valeur.

`AndroidManifest.xml`

```xml
<application
       android:label="@string/app_name">
</application>
```

Noter qu'ici la valeur fait référence à une chaîne de caractère qui est extraite dans les ressources de l'application sous la clé `app_name`. On aurait aussi pu spécifier directement la chaîne de caractère comme suis, mais pour des raisons de maintenabilité on préfère se référer aux ressources de l'application.

`AndroidManifest.xml`

```xml
<application
       android:label="MultiMulti">
</application>
```

![Titre](./images/03%20-%20Titre.png)

### Ajouter un bouton

On peut ajouter des boutons cliquables dans la barre de tâches.

Dans le répertoire `app/src/main/res`, créer un nouveau répertoire nommé `menu` s'il n'existe pas déjà.

Sur le nouveau répertoire créé (`app/src/main/res/menu`)

- Effectuer un clic droit
- Sélectionner l'option `Menu > Menu Resource File`
- Dans le champ `File name`, entrer le nom du menu. Ex : `main`
- Cliquer sur Ok

Dans le fichier créé, ajouter le code pour ajouter un bouton simple. Chaque item de menu doit comporter certains champs pour qu'il soit valide. Une liste exhaustive des champs est disponible dans la [documentation](https://developer.android.com/guide/topics/resources/menu-resource#item-element).

`main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <!-- TODO Ajouter un item qui affiche "Bonjour". Il doit avoir un id. -->
</menu>
```

On doit maintenant ajouter le menu à l'activité et définir ce que chaque bouton fait.

`MainActivity.java`

```java
@Override
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Ajouter le code pour ajouter le menu à l'activité  
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId(); // On obtient le id de l'élément qui a été sélectionné
       //  TODO Si l'élément sélectionné est celui qui a été définit dans main.xml, afficher un Toast qui dit "YO"
        return super.onOptionsItemSelected(item); // Comportement par défaut
    }
```

#### Options de `showAsAction`

- `never` : Mettre le bouton dans un menu compressé
- `always` : Toujours montrer le bouton, même s'il ne reste plus de place dans l'action bar
- `ifRoom` : Montrer le bouton s'il y a de la place dans l'action bar. Sinon le mettre dans un menu (voir `never`)
- Autres options disponibles [ici](https://developer.android.com/guide/topics/resources/menu-resource#item-element)

Ici, BANJO est à `always` et Main et Piano sont à `never`.

![Menu](images/03%20-%20Menu.png)

## Références

- [Geeks for geeks](https://www.geeksforgeeks.org/actionbar-in-android-with-example/)
- [Documentation Android](https://developer.android.com/develop/ui/views/components/appbar)
