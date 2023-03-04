# View Binding

Il existe 2 façons d'accéder aux éléments graphiques définis en XML dans Android : le [**Data Binding**](https://developer.android.com/topic/libraries/data-binding) et le [**View Binding**](https://developer.android.com/topic/libraries/view-binding). Les 2 approches sont comparées [ici](https://developer.android.com/topic/libraries/view-binding#data-binding).

Le **View Binding** génère une classe java par fichier XML de mise en page qui suit la nomenclature suivante : `nom_activite.xml` génère `NomActiviteBinding.java`.

La classe générée donne accès aux éléments graphiques qui possèdent un id.

Supposons le bouton suivant définit dans le XML :

```xml
<Button
    android:id="@+id/yo"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Yo" />
```

Une fois le binding initialisé dans le code de l'activité, le bouton ayant l'id `yo` devrait être accessible comme suit :

```java
binding.yo.setOnClickListener(...);
binding.yo.setText(...);
binding.yo.getText(...);
```

## Activer le View Binding

Afin d'activer le **View Binding** dans l'application, il faut ajouter le code suivant :

`app/build.gradle`

```groovy
android {
    ...
    // TODO Ajouter le code ici
}
```

## Exemple d'utilisation

On peut maintenant utiliser le **View Binding** dans nos activités. Si on considère le code de l'interface de l'activité suivante :

`app/src/main/res/layout/activity_main.xml`

```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/btn_salut"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Dire salut!" />

</LinearLayout>
```

On peut ajouter le code suivant pour afficher un Toast à l'appui du bouton.

`app/src/main/java/org/brillant/MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {

    // TODO Ajouter le code ici

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO Ajouter le code ici
    }
}
```

> Attention, si vous utilisez le View Binding, il faut que le `setContentView` utilise le binding. Si la forme `R.id.votre_activite` est utilisée, vous ne serez pas en mesure d'utiliser le View Binding.

## Avantages par rapport au Data Binding

- Évite d'avoir à utiliser `R.id.nom`
- Pas de cast à faire
- Accès aux éléments graphique plus rapide

## Références

- [Vidéo du cours](https://youtu.be/C0eWT0a2aM8?t=289)
- [Documentation Android](https://developer.android.com/topic/libraries/view-binding)
