package com.fntl.app.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterModel extends BaseObservable {

    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("personType")
    @Expose
    private Integer personType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("companyName")
    @Expose
    private String companyName;
    @SerializedName("address")
    @Expose
    private String address;

    public RegisterModel(String fullName, String email, String mobileNumber, Integer personType, String description, String companyName, String address) {
        this.fullName = fullName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.personType = personType;
        this.description = description;
        this.companyName = companyName;
        this.address = address;
    }

    @Bindable
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

    }

    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);

    }

    @Bindable
    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
        notifyPropertyChanged(BR.personType);

    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);

    }

    @Bindable
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        notifyPropertyChanged(BR.address);

    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

}
