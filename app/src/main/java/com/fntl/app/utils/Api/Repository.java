package com.fntl.app.utils.Api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.ResponseModel;
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

    public LiveData<ResponseModel> SignIn(String number, CompositeDisposable disposable) {
        MutableLiveData<ResponseModel> liveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().get_Signin(new UserPhoneModel(number))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ResponseModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onSuccess(@NonNull ResponseModel responseModel) {
                        liveData.setValue(responseModel);
                        Log.i(TAG, "onSuccess: " + responseModel.getMessage());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                    }
                });
        return liveData;
    }

    public LiveData<Token> Verification(String number, String code, int platform, String version, String deviceid, CompositeDisposable disposable) {
        MutableLiveData<Token> liveData = new MutableLiveData<>();

        VerificationCodeModel verificationCodeModel = new VerificationCodeModel(number, code, platform, version, deviceid);
        RetrofitInstance.getInstance().get_Token(verificationCodeModel)
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
}
