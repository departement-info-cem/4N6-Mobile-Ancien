package org.depinfo.omnisus.http;

import org.depinfo.omnisus.http.dto.SigninRequest;
import org.depinfo.omnisus.http.dto.UserDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Service {

    @POST("api/id/signin")
    Call<String> signIn(@Body SigninRequest utilisateur);

    @GET("api/grade")
    Call<UserDetailsResponse> getGrade();

    @PUT("api/student")
    Call<String> editUser(@Body String publicName);

}
