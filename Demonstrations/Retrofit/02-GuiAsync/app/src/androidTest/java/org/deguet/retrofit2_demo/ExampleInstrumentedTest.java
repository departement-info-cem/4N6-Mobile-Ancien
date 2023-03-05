package org.deguet.retrofit2_demo;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service;
import org.deguet.retrofit2_demo.transfer.Repo;
import org.deguet.retrofit2_demo.transfer.Utilisateur;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testSimple() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.listReposString("departement-info-cem");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testStructures() throws IOException {
        Service service = RetrofitUtil.get();
        Call<List<Repo>> call = service.listRepos("departement-info-cem");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }

    @Test
    public void testSimpleUtilisateur() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.utilisateurString("departement-info-cem");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testSimpleUtilisateurStructure() throws IOException {
        Service service = RetrofitUtil.get();
        Call<Utilisateur> call = service.utilisateur("departement-info-cem");
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}
