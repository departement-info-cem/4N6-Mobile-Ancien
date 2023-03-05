package org.deguet.retrofit2_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service;
import org.deguet.retrofit2_demo.transfer.Repo;
import org.deguet.retrofit2_demo.transfer.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // appeler un service de liste et afficher dans le log
        final Service service = RetrofitUtil.get();
        service.listRepos("jorisdeguet").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    // http 200 http tout s'est bien passé
                    List<Repo> resultat = response.body();
                    Log.i("RETROFIT", resultat.size()+"");

                } else {
                    // cas d'erreur http 400 404
                    Log.i("RETROFIT", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                // erreur accès réseau ou alors GSON
                Log.i("RETROFIT", t.getMessage());
            }
        });


        // appeler un service et mettre l'interface graphique
        final EditText et = findViewById(R.id.et);
        final Button btn = findViewById(R.id.btn);
        final TextView tv = findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = et.getText().toString();
                service.utilisateur(nom).enqueue(new Callback<Utilisateur>() {
                    @Override
                    public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                        if (response.isSuccessful()) {
                            tv.setText(response.body().id+"");
                        } else {
                            Log.i("RETROFIT", response.code()+"");
                        }
                    }

                    @Override
                    public void onFailure(Call<Utilisateur> call, Throwable t) {
                        Log.i("RETROFIT", t.getMessage());
                    }
                });
            }
        });
    }
}
