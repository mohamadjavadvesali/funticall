package com.fntl.app.utils.Api;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.RegisterModel;
import com.fntl.app.model.Response_Model;
import com.fntl.app.model.UserPhoneModel;
import com.fntl.app.model.VerificationCodeModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("Core/api/v1/Comment/GetPostsForApp")
    Single<List<PostModel>> getPosts(@Query("pageIndex") int page);

    @POST("Core/api/v1/Account/SignIn")
    Call<Response_Model> Post_Signin(@Body UserPhoneModel userPhoneModel);

    @POST("Core/api/v1/Account/SignInVerification")
    Call<Response_Model> Post_Token(@Body VerificationCodeModel verificationCodeModel);


    @POST("Core/api/v1/Account/Register")
    Single<Response_Model> Post_register(@Body RegisterModel registerModel);


    @GET("Core/api/v{version}/Comment/Global/{id}")
    Call<List<PostModel>> get_Posts_comment(@Path("version") int version,
                                             @Path("id") int id,
                                             @Query("relatedTableEnum") int relatedTableEnum);
}