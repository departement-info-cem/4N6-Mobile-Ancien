# Recycler View

Le **Recycler View** premet d'afficher une liste d'éléments dans votre interface graphique.

> Note : Le View Binding est utilisé ici. Vous pouvez vous référer à la recette sur le sujet pour l'ajouter à votre application.

## Mise en place

Plusieurs étapes et composantes sont nécessaires pour mettre en place un **Recycler View**

### Ajout de la dépendance maven

Le Recycler View n'est pas disponible par défaut dans la librairie d'Android : il faut l'ajouter comme dépendance. La dernière version est disponible sur le site de la [documentation d'Android](https://developer.android.com/jetpack/androidx/releases/recyclerview?hl=fr#declaring_dependencies).

```groovy
dependencies {
    ...
    // TODO Ajouter l'importation des dépendances ici
    ...
}
```

### Ajout dans l'activité

Comme pour les autres éléments graphiques (bouton, champs texte, etc), le **Recycler View** doit être ajouté dans le fichier XML qui définit l'interface de chaque activité.

`activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- TODO Ajouter le code pour afficher un Recycler View. Il doit :
         - Faire toute la largeur de l'écran
         - Faire toute la hauteur de l'écran
         - Avoir un id "monRecycleur"
         - Avoir une couleur de fond rose nanane -->

</LinearLayout>
```

> Note : À ce point, c'est normal que le **Recycler View** ne s'affiche pas lorsqu'on exécute l'application sur un téléphone puisqu'il n'y a pas de encore d'éléments qui ont été ajoutés dans la liste. 

### Interface d'un élément

Jusqu'à présent, l'emplacement où la liste va apparaitre dans l'interface a été définit, mais il faut aussi définir à quoi ressemblera chacun des éléments de la liste.

Le fichier XML ci-dessous permet de définir à quoi resemble un élément de la liste.

Il doit être ajouté au même niveau qu'une activité, soit dans `app/src/main/res/layout`.

`mes_secrets.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:layout_marginBottom="30dp">

    <!-- TODO Ajouter le code pour afficher 3 TextView empilés les uns sur les autres ayant des id txtNom, txtDate, txtNbr
         Chaque TextView doit prendre toute la largeur de l'écran, un texte par défaut et avoir une taille de texte de 25sp -->

</LinearLayout>
```

### Classe d'un item

Afin de contenir les données d'un item de liste à afficher et de les communiquer entre les différentes composantes, une classe doit être définie.

`Secret.java`

```java
public class Secret {
    // TODO Ajouter le code pour définir les propriétés de la classe
    // 3 propriétés de types différents doivent être disponibles :
    //   - Une String
    //   - Un LocalDateTime
    //   - Un Long
}

```

### Classe de l'adapteur

L'adaptateur gère chacun des éléments visuels de la liste qui se retrouvent dans l'interface. Il permet donc de lier le fichier xml définit plus haut (`mes_secrets.xml`) pour chaque élément à afficher avec un **RecyclerView**.

`SecretAdapter.java`

```java
public class SecretAdapter extends RecyclerView.Adapter<SecretAdapter.MyViewHolder> {

    /**
     * Liste qui contient l'ensemble des éléments à afficher dans la liste
     */
    public List<Secret> localDataSet;

    /**
     * Chaque élément à afficher est un MyViewHolder
     */
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        
        public MyViewHolder(SecretItemBinding binding) {
            super(binding.getRoot());
            // TODO Ajouter le code pour créer le View Holder
            // Le View Holder doit gérer les 3 champs créés dans l'interface et dans la classe Secret
        }
    }

    /**
     * Initialiser la liste de données de l'adapteur
     */
    public SecretAdapter() {
        // TODO Ajouter le code pour initialiser la liste qui contient les éléments à afficher
    }

    /**
     * Créer un élément de liste.
     * Attention : Cette méthode n'est pas appellée pour chaque élément de la liste,
     * mais seulement ceux qui sont visible à l'écran.
     * Android est assez intelligent pour détecter si un élément ne s'affiche plus à l'écran et
     * pour le remplacer par un autre (recycler).
     *
     * @param viewGroup The ViewGroup into which the new View will be added after it is bound to
     *                  an adapter position.
     * @return L'élément de liste créé
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // TODO Ajouter le code pour créer un élément à afficher
    }

    /**
     * Mettre du contenu dans un item de la liste
     *
     * @param myViewHolder View Holder créé dans onCreateViewHolder sur lequel on veut mettre du contenu
     * @param position     Position de l'item à mettre qui se trouve dans notre jeu de données
     */
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        // TODO Ajouter le code pour ajouter du contenu dans l'élément à afficher
    }

    /**
     * Renvoie la taille de la liste
     *
     * @return Taille de la liste
     */
    @Override
    public int getItemCount() {
        // TODO Ajouter le code pour obtenir le nombre d'éléments dans la liste
    }

}
```

### Lier l'adaptateur à l'activité

Afin d'être en mesure de remplir notre **Recycler View**, du code doit être ajouté dans la classe Java de l'activité.

`MainActivity.java`

```java
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SecretAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeRecycler();
        remplirRecycler();
        remplacer();
    }

    /**
        * Obtenir une référence au Recycler View dans le layout et le connecter au SecretAdapter.
        */
    private void initialiserRecycler() {
        // TODO Compléter le code
    }

    /**
    * Remplir le Recycler View créé avec 1000 éléments 
    */
    private void remplirRecycler() {
        // TODO Compléter le code
    }

    /**
     * Remplacer les 1000 éléments précédement créés par 1000 autres.
     */
    private void remplacer() {
        // TODO Compléter le code
        // ATTENTION : Ne jamais créer de nouvelle liste dans l'adapteur (Ex : adapter.localDataSet = new ArrayList<>()
        // On risque de perdre le lien entre la liste et l'adapteur. Plutôt vider la liste et la repeupler.
    }
}
```

## Problèmes fréquents et comment les déboguer

Le meilleur moyen de détecter rapidement un problème est de tester aussi souvent que possible l'application développée. Il peut être difficile de le faire avec un Recycler View puisque plusieurs étapes sont nécessaires avant d'avoir un résultat. 

### Les éléments de la liste ne s'affichent pas

Il peut être complexe de trouver la source du problème puisque plusieurs éléments peuvent causer le problème.

1. Essayer d'exécuter l'application en mode debug, avec des points de débug dans les différentes méthodes de l'adapeteur
2. Si les points de débug dans l'adaptateur **ne sont pas** atteints, il est probable que le problème provienne du code qui configure l'adaptateur dans l'activité.
3. Si les points de débug dans l'adaptateur **sont** atteints, il est probable que le problème provienne du code xml qui définit l'interface graphique. 

### Tout s'affiche, mais l'interface est lente pour gérer un grand nombre d'éléments

Lors de l'initialisation du Recycler View (voir la méthode `initialiserRecycler` dans [cette étape](#lier-linterface-à-lactivité)), il faut ajouter cette ligne : `recyclerView.setHasFixedSize(true);`. 

Cela indique à Android qu'il n'est pas nécessaire de recalculer chaque éléments graphique lorsqu'on se déplace dans la liste.

## Pour quoi ça s'appelle un **Recycler View**?

- Supposons que notre appareil a la capacité d'afficher 6 éléments à la fois, comme sur l'image ci-dessous.
- Rappelons nous aussi que chaque élément graphique de la liste s'appellent un **ViewHolder**.

À chaque fois qu'un **ViewHolder** doit être rendu à l'écran, la méthode `onCreateViewHolder` est appellée pour créer l'interface graphique du **ViewHolder**. Elle devrait donc être appelée 6 fois. Notez que la méthode `onCreateViewHolder` est assez coûteuse au niveau des performances.

La méthode `onBindViewHolder` est ensuite appelée pour mettre l'information voulue les **ViewHolder**. Elle devrait donc être appelée 6 fois.

Il n'y a toujours que 6 **ViewHolder** qui sont affichés à la fois dans l'interface. L'idée est donc de réutiliser (Recycler) les différents éléments en mettant à jour les informations à afficher pour éviter de toujours supprimer / recréer des **ViewHolder**.

À mesure qu'on fait défiler les éléments, la méthode `onBindViewHolder` va être appelée plusieurs fois pour remplacer le contenu des éléments à afficher. Cependant, la méthode `onCreateViewHolder` qui créée les ViewHolder ne va être appelée que 6 fois.

> Truc : pour mieux comprendre exécuter votre application contenant le Recycler View, et regardez dans le Layout Inspector d'Android Studio. Vous verrez comment se comportent les éléments de la liste lorsqu'on fait défiler les différents éléments  

![Recycler View](images/05%20-%20Recycler.png)

## Références

- [Vidéo du cours 1/2 - layout, adapteur et initialisation](https://www.youtube.com/watch?v=nkGseYC3QAw)
- [Vidéo du cours 2/2 - fonctionnement et débogage](https://www.youtube.com/watch?v=gtHix80YUx0)
- [Documentation Android](https://developer.android.com/jetpack/androidx/releases/recyclerview?hl=fr)
- [Guide Android](https://developer.android.com/develop/ui/views/layout/recyclerview#java)