package org.sabourin.swiperefresh;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    // https://exercices-web.herokuapp.com/exos/truc/list
    @GET("exos/truc/list")
    Call<List<Truc>> vaChercherLaListe();

}
