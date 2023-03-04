package org.deguet.retrofit2_demo.http.mock;

import org.deguet.retrofit2_demo.http.RetrofitUtil;
import org.deguet.retrofit2_demo.http.Service2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

public class RetrofitMock {

    static boolean reel = false;

    public static Service2 get(){
        if (reel) return getReel();
        else{return getMock(); }
    }

    public static Service2 getReel(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(RetrofitUtil.client())
                .baseUrl("https://api.github.com/")
                .build();

        return retrofit.create(Service2.class);
    }

    public static Service2 getMock(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(RetrofitUtil.client())
                .baseUrl("https://api.github.com/")
                .build();

        NetworkBehavior behviour = NetworkBehavior.create();
        MockRetrofit mock = new MockRetrofit.Builder(retrofit).networkBehavior(behviour).build();
        BehaviorDelegate<Service2> delegate = mock.create(Service2.class);

        return new MockService2(delegate);
    }

}
