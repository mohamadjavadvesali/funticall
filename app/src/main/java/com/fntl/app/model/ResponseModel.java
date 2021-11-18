package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("ErrorsObject")
    @Expose
    Errors ErrorsObject;
    @SerializedName("data")
    @Expose
    private String data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("metaData")
    @Expose
    private String metaData = null;


    // Getter Methods

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Setter Methods

    public Errors getErrors() {
        return ErrorsObject;
    }

    public void setErrors(Errors errorsObject) {
        this.ErrorsObject = errorsObject;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
