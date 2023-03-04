package org.deguet.retrofit2_demo.http;

import org.deguet.retrofit2_demo.transfer.Repo;
import org.deguet.retrofit2_demo.transfer.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service2 {

    @POST("create")
    Call<Utilisateur> creer(Utilisateur utilisateur);

    @GET("utilisateurs")
    Call<List<Utilisateur>> utilisateurs();

}
