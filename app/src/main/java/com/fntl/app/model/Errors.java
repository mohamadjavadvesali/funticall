package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Errors {
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("field")
    @Expose
    private String field;


    // Getter Methods

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    // Setter Methods

    public void setCode(String code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
