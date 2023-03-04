package org.deguet.retrofit2_demo;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service;
import org.deguet.retrofit2_demo.http.Service2;
import org.deguet.retrofit2_demo.http.mock.RetrofitMock;
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
public class TestService2 {
    @Test
    public void testSimpleService2() throws IOException {
        Service2 service = RetrofitMock.get();
        Call<Utilisateur> call = service.creer(new Utilisateur());
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("RETROFIT", resultat.toString());

        List<Utilisateur> list = service.utilisateurs().execute().body();
        Log.i("RETROFIT", list.size()+"");
    }

}
