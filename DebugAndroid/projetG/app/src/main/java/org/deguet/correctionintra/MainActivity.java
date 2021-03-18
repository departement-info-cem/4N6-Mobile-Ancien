package org.deguet.correctionintra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.deguet.correctionintra.http.Anniv;
import org.deguet.correctionintra.http.HTTPUtil;
import org.deguet.correctionintra.ui.Adapter;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();

        remplirRecycler();
    }

    private void remplirRecycler() {
        HTTPUtil.get().annivs(1981, 5,24).enqueue(new Callback<List<Anniv>>() {
            @Override
            public void onResponse(Call<List<Anniv>> call, Response<List<Anniv>> response) {
                adapter.list.clear();
                adapter.list.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Anniv>> call, Throwable t) {
            }
        });
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }
}