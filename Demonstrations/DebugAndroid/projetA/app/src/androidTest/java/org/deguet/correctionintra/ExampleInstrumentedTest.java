package org.deguet.correctionintra;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.deguet.correctionintra.http.Anniv;
import org.deguet.correctionintra.http.EndPoints;
import org.deguet.correctionintra.http.HTTPUtil;
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
        EndPoints service = HTTPUtil.get();
        Call<String> call = service.anniversaires(1981,5,24);
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testAnniv() throws IOException {
        EndPoints service = HTTPUtil.get();
        Call<List<Anniv>> call = service.annivs(1981,5,24);
        Response<List<Anniv>> response = call.execute();
        List<Anniv> resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}