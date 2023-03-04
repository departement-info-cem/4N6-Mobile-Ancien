package org.deguet.progress;

import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    ProgressBar progress;
    TextView stuff;

    ProgressDialog progressD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        progress = (ProgressBar) findViewById(R.id.progress);
        stuff = (TextView) findViewById(R.id.stuff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
                RetrofitUtil.get().waitAMinute().enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        endDownload();
                        Toast.makeText(getApplicationContext(), "Yes bouton", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        endDownload();
                        Toast.makeText(getApplicationContext(), "Ouch bouton", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // On affiche le dialogue avant de lancer la requete
        progressD = ProgressDialog.show(MainActivity.this, "Please wait",
                "Long operation starts...", true);
        RetrofitUtil.get().waitAMinute().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // si on recoit une reponse du serveur, premier truc : on ferme le dialogue
                progressD.dismiss();
                Toast.makeText(getApplicationContext(), "Yes chargement", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // attention on ferme aussi le dialogue sur erreur, sinon il ne part jamais
                progressD.dismiss();
                Toast.makeText(getApplicationContext(), "Ouch chargement", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startDownload(){
        progress.setVisibility(View.VISIBLE);
        stuff.setVisibility(View.GONE);
    }

    private void endDownload(){
        progress.setVisibility(View.GONE);//INVISIBLE occupe de l'espace GONE non
        stuff.setVisibility(View.VISIBLE);
    }
}
