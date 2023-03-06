package org.deguet.progress;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {

    public static ServiceAttente get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://4n6.azurewebsites.net/")
                .build();

        ServiceAttente service = retrofit.create(ServiceAttente.class);
        return service;
    }

}
