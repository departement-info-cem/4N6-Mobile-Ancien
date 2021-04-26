package org.sabourin.swiperefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swiperefresh;
    ListView listeView;
    ArrayList<String> listeItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swiperefresh = findViewById(R.id.swiperefresh);
        listeView = findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listeItems);
        listeView.setAdapter(adapter);

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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
        return true;
    }

    public void myUpdateOperation() {

        // Utilise le thread UI et bloque l'animation
        // Thread.sleep(3000);
        listeItems.clear();
        for (int i = 0 ; i < 100 ; i ++){
            listeItems.add(i+ " ! ");
            adapter.notifyDataSetChanged();
        }

        //Arrête l'animation de loading
        swiperefresh.setRefreshing(false);
        listeView.smoothScrollToPosition(0);        // nécessaire si pas déjà en haut de la liste
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

}