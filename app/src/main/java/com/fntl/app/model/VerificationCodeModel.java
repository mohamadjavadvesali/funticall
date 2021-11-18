package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificationCodeModel {

    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("verificationCode")
    @Expose
    private String verificationCode;
    @SerializedName("platform")
    @Expose
    private Integer platform;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;

    public VerificationCodeModel(String mobileNumber, String verificationCode, Integer platform, String version, String deviceId) {
        this.mobileNumber = mobileNumber;
        this.verificationCode = verificationCode;
        this.platform = platform;
        this.version = version;
        this.deviceId = deviceId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}