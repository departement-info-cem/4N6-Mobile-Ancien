package org.sabourin.swiperefresh;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    public static Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://exercices-web.herokuapp.com/")
                .build();

        Service service = retrofit.create(Service.class);
        return service;
    }

}