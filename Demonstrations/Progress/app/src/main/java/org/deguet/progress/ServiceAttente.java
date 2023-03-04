package org.deguet.progress;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAttente {

    @GET("exos/waitaminute")
    Call<String> waitAMinute();

}
