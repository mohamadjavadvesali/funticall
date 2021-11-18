package com.fntl.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.ResponseModel;
import com.fntl.app.model.Token;
import com.fntl.app.utils.Api.Repository;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivityViewModel extends ViewModel {
    private final CompositeDisposable disposable = new CompositeDisposable();

    public LiveData<List<PostModel>> getPosts(int page) {
        return Repository.getInstance().getPosts(page, disposable);
    }


    public LiveData<ResponseModel> get_Users(String number) {
        return Repository.getInstance().SignIn(number, disposable);

    }

    public LiveData<Token> get_verification(String number, String code, int platform, String version, String deviceid) {
        return Repository.getInstance().Verification(number, code, platform, version, deviceid, disposable);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
