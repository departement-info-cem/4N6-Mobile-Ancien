package org.deguet.retrofit_erreur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.deguet.retrofit_erreur.http.RetrofitUtil;
import org.deguet.retrofit_erreur.http.Service;
import org.deguet.retrofit_erreur.transfer.Repo;

import java.io.IOException;

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

        // appeler un service et mettre l'interface graphique
        final EditText et = findViewById(R.id.et);
        final Button btn = findViewById(R.id.btn);
        final TextView tv = findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = et.getText().toString();
                Repo repo = new Repo();
                repo.nom = nom;
                service.erreurOuPas(repo).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            tv.setText(response.body());
                        } else {
                            // ERROR ERROR ERROR
                            try {
                                String corpsErreur = response.errorBody().string();
                                Log.i("RETROFIT", "le code " + response.code());
                                Log.i("RETROFIT", "le message " + response.message());
                                Log.i("RETROFIT", "le corps " + corpsErreur);
                                if (corpsErreur.contains("TropCourt")) {
                                    // TODO remplacer par un objet graphique mieux qu'un toast
                                    Toast.makeText(MainActivity.this, "Ce message est trop court", Toast.LENGTH_SHORT).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        // TODO ici aussi il va falloir avoir un message d'erreur
                        int a = 0;
                    }
                });
            }
        });
    }
}
