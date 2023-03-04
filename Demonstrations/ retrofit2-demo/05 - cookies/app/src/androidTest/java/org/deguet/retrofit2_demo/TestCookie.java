package org.deguet.retrofit2_demo;

import android.util.Log;

import androidx.test.runner.AndroidJUnit4;

import org.deguet.retrofit2_demo.http.RetrofitCookie;
import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service;
import org.deguet.retrofit2_demo.http.ServiceCookie;
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
public class TestCookie {
    @Test
    public void testSimple() throws IOException {
// service > retrofit > client okhttp > cookie Jar
        for (int i = 0 ; i < 10 ; i++) {
            ServiceCookie service = RetrofitCookie.get();
            Call<String> call = service.cookieEcho();
            Response<String> response = call.execute();
            String resultat = response.body();
            Log.i("RETROFIT", resultat);
        }
    }

}
