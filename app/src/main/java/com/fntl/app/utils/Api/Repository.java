package com.fntl.app.utils.Api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.RegisterModel;
import com.fntl.app.model.Response_Model;
import com.fntl.app.model.UserPhoneModel;
import com.fntl.app.model.VerificationCodeModel;
import com.fntl.app.utils.ErrorUtils;

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
        RetrofitInstance.getInstance().Post_Signin(new UserPhoneModel(number))
                .enqueue(new Callback<Response_Model>() {
                    @Override
                    public void onResponse(Call<Response_Model> call, Response<Response_Model> response) {
                        if (response.isSuccessful())
                            liveData.setValue(response.body());
                        else {
                            Response_Model error = ErrorUtils.parseError(response);
                            liveData.setValue(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<Response_Model> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.fillInStackTrace());
                    }
                });
        return liveData;
    }

    public LiveData<Response_Model> Register(String fullName, String email, String mobileNumber, Integer personType, String description, String companyName, String address, CompositeDisposable disposable) {
        MutableLiveData<Response_Model> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().Post_register(new RegisterModel(fullName, email, mobileNumber, personType, description, companyName, address))
                .enqueue(new Callback<Response_Model>() {
                    @Override
                    public void onResponse(Call<Response_Model> call, Response<Response_Model> response) {
                        if (response.isSuccessful())
                            liveData.setValue(response.body());
                        else {
                            Response_Model error = ErrorUtils.parseError(response);
                            liveData.setValue(error);
                        }
                    }

                    @Override
                    public void onFailure(Call<Response_Model> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.fillInStackTrace());
                    }
                });
        return liveData;
    }

    public LiveData<Response_Model> Verification(String number, String code, int platform, String version, String deviceid, CompositeDisposable disposable) {
        MutableLiveData<Response_Model> liveData = new MutableLiveData<>();

        VerificationCodeModel verificationCodeModel = new VerificationCodeModel(number, code, platform, version, deviceid);
        RetrofitInstance.getInstance().Post_Token(verificationCodeModel)
               .enqueue(new Callback<Response_Model>() {
                   @Override
                   public void onResponse(Call<Response_Model> call, Response<Response_Model> response) {
                       if (response.isSuccessful())
                           liveData.setValue(response.body());
                       else {
                           Response_Model error = ErrorUtils.parseError(response);
                           liveData.setValue(error);
                       }
                   }

                   @Override
                   public void onFailure(Call<Response_Model> call, Throwable t) {

                   }
               });
        return liveData;
    }


  /*  public LiveData<List<Response_post_Model>> get_Comment(CompositeDisposable disposable) {
        MutableLiveData<List<Response_post_Model>> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().get_Posts_comment(1, 0, 7).enqueue(new Callback<List<Response_post_Model>>() {
            @Override
            public void onResponse(Call<List<Response_post_Model>> call, Response<List<Response_post_Model>> response) {
                if (response.isSuccessful())
                    liveData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Response_post_Model>> call, Throwable t) {

            }
        });

        return liveData;
    }*/
}
