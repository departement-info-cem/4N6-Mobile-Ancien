package org.deguet.retrofit2_demo.http;

import org.deguet.retrofit2_demo.transfer.Repo;
import org.deguet.retrofit2_demo.transfer.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("users/{utilisateur}/repos")
    Call<String> listReposString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}/repos")
    Call<List<Repo>> listRepos(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<String> utilisateurString(@Path("utilisateur") String utilisateur);

    @GET("users/{utilisateur}")
    Call<Utilisateur> utilisateur(@Path("utilisateur") String utilisateur);
}
