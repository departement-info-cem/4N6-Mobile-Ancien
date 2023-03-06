package org.sabourin.swiperefresh;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    // https://4n6.azurewebsites.net/exos/truc/list
    @GET("exos/truc/list")
    Call<List<Truc>> vaChercherLaListe();

}
