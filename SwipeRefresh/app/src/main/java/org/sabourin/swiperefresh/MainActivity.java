package org.sabourin.swiperefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swiperefresh;
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();

        swiperefresh = findViewById(R.id.swiperefresh);

        swiperefresh.setOnRefreshListener(
                () -> {
                    Toast.makeText(MainActivity.this, "REFRESH", Toast.LENGTH_LONG).show();
                    //Part l'animation de loading
                    swiperefresh.setRefreshing(true);

                    new DummyBackgroundTask().execute();
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                Toast.makeText(MainActivity.this, "REFRESH AVEC MENU", Toast.LENGTH_LONG).show();

                //Part l'animation de loading
                swiperefresh.setRefreshing(true);

                new DummyBackgroundTask().execute();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void myUpdateOperation() {

        // Utilise le thread UI et bloque l'animation
        // Thread.sleep(3000);
        adapter.maListe.clear();
        for (int i = 0 ; i < 100 ; i ++){
            adapter.maListe.add("Valeur " + i+ " ! ");
        }
        adapter.notifyDataSetChanged();

        //Arrête l'animation de loading
        swiperefresh.setRefreshing(false);
        recyclerView.smoothScrollToPosition(0);        // nécessaire si pas déjà en haut de la liste
    }

    private class DummyBackgroundTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {

            try {
                Thread.sleep(3 * 1000); // 3 secondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(List<String> result) {
            super.onPostExecute(result);
            myUpdateOperation();
        }
    }

    private void initRecycler(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
        return true;
    }
}