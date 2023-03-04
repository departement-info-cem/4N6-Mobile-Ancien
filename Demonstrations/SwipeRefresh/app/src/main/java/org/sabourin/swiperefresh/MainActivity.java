package org.sabourin.swiperefresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swiperefresh;
    TrucAdapteur adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();

        swiperefresh = findViewById(R.id.swiperefresh);
        swiperefresh.setOnRefreshListener(
                () -> {
                    mettreAJour();
                }
        );

        // premier appel pour aller chercher la liste
        mettreAJour();
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TrucAdapteur();
        recyclerView.setAdapter(adapter);
    }

    private void remplirRecycler(List<Truc> body) {
        adapter.list.clear();
        adapter.list.addAll(body);
        adapter.notifyDataSetChanged();
    }




    private void mettreAJour() {
        swiperefresh.setRefreshing(true);
        RetrofitUtil.get().vaChercherLaListe().enqueue(new Callback<List<Truc>>() {
            @Override
            public void onResponse(Call<List<Truc>> call, Response<List<Truc>> response) {
                swiperefresh.setRefreshing(false);

                remplirRecycler(response.body());
            }

            @Override
            public void onFailure(Call<List<Truc>> call, Throwable t) {
                swiperefresh.setRefreshing(false);
            }
        });
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                mettreAJour();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
        return true;
    }

}