package com.fntl.app.utils.Api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.Post_Model;
import com.fntl.app.model.RegisterModel;
import com.fntl.app.model.Response_Model;
import com.fntl.app.model.Token;
import com.fntl.app.model.UserPhoneModel;
import com.fntl.app.model.VerificationCodeModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static final String TAG = "repository_Log";
    private static Repository instance = null;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public LiveData<List<PostModel>> getPosts(int page, CompositeDisposable disposable) {
        MutableLiveData<List<PostModel>> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().getPosts(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<PostModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull List<PostModel> postModels) {
                        liveData.setValue(postModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

        return liveData;
    }

    public LiveData<Response_Model> SignIn(String number, CompositeDisposable disposable) {
        MutableLiveData<Response_Model> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().Post_Signin(new UserPhoneModel(number)).enqueue(new Callback<Response_Model>() {
            @Override
            public void onResponse(Call<Response_Model> call, Response<Response_Model> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Response_Model> call, Throwable t) {

            }
        });
        return liveData;
    }

    public LiveData<Response_Model> Register(String fullName, String email, String mobileNumber, Integer personType, String description, String companyName, String address, CompositeDisposable disposable) {
        MutableLiveData<Response_Model> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().Post_register(new RegisterModel(fullName, email, mobileNumber, personType, description, companyName, address))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response_Model>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Response_Model responseModel) {
                        liveData.setValue(responseModel);
                        Log.i(TAG, "onSuccess: " + responseModel.getMessage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
        return liveData;
    }

    public LiveData<Token> Verification(String number, String code, int platform, String version, String deviceid, CompositeDisposable disposable) {
        MutableLiveData<Token> liveData = new MutableLiveData<>();

        VerificationCodeModel verificationCodeModel = new VerificationCodeModel(number, code, platform, version, deviceid);
        RetrofitInstance.getInstance().Post_Token(verificationCodeModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Token>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull Token token) {
                        liveData.setValue(token);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "onError: " + e.fillInStackTrace());

                    }
                });
        return liveData;
    }


    public LiveData<List<Post_Model>> get_Comment(CompositeDisposable disposable) {
        MutableLiveData<List<Post_Model>> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().get_Posts_comment(1, 0, 7).enqueue(new Callback<List<Post_Model>>() {
            @Override
            public void onResponse(Call<List<Post_Model>> call, Response<List<Post_Model>> response) {
                liveData.setValue(response.body());
                Log.i(TAG, "onResponse: "+response.code());
            }

            @Override
            public void onFailure(Call<List<Post_Model>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.fillInStackTrace());
            }
        });

        return liveData;
    }
}
