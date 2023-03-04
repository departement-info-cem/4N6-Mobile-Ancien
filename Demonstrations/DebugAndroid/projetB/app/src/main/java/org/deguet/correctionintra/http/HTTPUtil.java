package org.deguet.correctionintra.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HTTPUtil {


    public static EndPoints get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .baseUrl("https://exercises-web.herokuapp.com/")
                .build();

        EndPoints service = retrofit.create(EndPoints.class);
        return service;
    }

    private static OkHttpClient client() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;

    }

}
