package org.deguet.correctionintra.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndPoints {

    @GET("exam/{annee}/{mois}/{jour}")
    Call<String> anniversaires(@Path("annee") int annee, @Path("mois") int mois, @Path("jour") int jour);

    @GET("exam/{annee}/{mois}/{jour}")
    Call<List<Anniv>> annivs(@Path("annee") int annee, @Path("mois") int mois, @Path("jour") int jour);
}
