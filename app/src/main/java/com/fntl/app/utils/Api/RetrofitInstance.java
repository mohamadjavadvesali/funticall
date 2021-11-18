package com.fntl.app.utils.Api;

import java.io.IOException;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "https://api.funtical.app/";
    public static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorize", "Bearer " + "2772a432-bb00-4d9d-a41c-28da6d954914")
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();
    private static Retrofit instance = null;

    public static synchronized Api getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance.create(Api.class);
    }


}
