package org.deguet.retrofit2_demo.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceCookie {

    @GET("exos/cookie/echo")
    Call<String> cookieEcho();
}
