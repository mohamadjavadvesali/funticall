package com.fntl.app.utils.Api;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.ResponseModel;
import com.fntl.app.model.Token;
import com.fntl.app.model.UserPhoneModel;
import com.fntl.app.model.VerificationCodeModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @GET("Core/api/v1/Comment/GetPostsForApp")
    Single<List<PostModel>> getPosts(@Query("pageIndex") int page);

    @POST("Core/api/v1/Account/SignIn")
    Single<ResponseModel> get_Signin(@Body UserPhoneModel userPhoneModel);

    @POST("Core/api/v1/Account/SignInVerification")
    Single<Token> get_Token(@Body VerificationCodeModel verificationCodeModel);

}
