package com.fntl.app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fntl.app.model.PostModel;
import com.fntl.app.model.Response_Model;
import com.fntl.app.utils.Api.Repository;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivityViewModel extends ViewModel {
    private final CompositeDisposable disposable = new CompositeDisposable();

    public LiveData<List<PostModel>> getPosts(int page) {
        return Repository.getInstance().getPosts(page, disposable);
    }


    public LiveData<Response_Model> get_Users(String number) {
        return Repository.getInstance().SignIn(number, disposable);

    }

    public LiveData<Response_Model> get_verification(String number, String code, int platform, String version, String deviceid) {
        return Repository.getInstance().Verification(number, code, platform, version, deviceid, disposable);

    }

    public LiveData<Response_Model> post_register(String fullName, String email, String mobileNumber, Integer personType, String description, String companyName, String address) {
        return Repository.getInstance().Register(fullName, email, mobileNumber, personType, description, companyName, address, disposable);

    }

    public LiveData<List<PostModel>> get_Commment_Post() {
        return Repository.getInstance().get_Comment(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
