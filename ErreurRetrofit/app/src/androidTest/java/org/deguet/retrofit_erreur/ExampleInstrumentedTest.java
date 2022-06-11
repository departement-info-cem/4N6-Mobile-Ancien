package org.deguet.retrofit_erreur;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.deguet.retrofit_erreur.http.RetrofitUtil;
import org.deguet.retrofit_erreur.http.Service;
import org.deguet.retrofit_erreur.transfer.Repo;
import org.junit.Assert;
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
    public void testSucces() throws IOException {
        Service service = RetrofitUtil.get();
        Repo repo = new Repo();
        repo.nom = "pipo pipo";
        Call<String> call = service.erreurOuPas(repo);
        Response<String> response = call.execute();
        String resultat = response.body();
        Assert.assertTrue(response.isSuccessful());
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testErreur() throws IOException {
        Service service = RetrofitUtil.get();
        Repo repo = new Repo();
        repo.nom = "pi";
        Call<String> call = service.erreurOuPas(repo);
        Response<String> response = call.execute();
        Assert.assertFalse(response.isSuccessful());
    }

}
