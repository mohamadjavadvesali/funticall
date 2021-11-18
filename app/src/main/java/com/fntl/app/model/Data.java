package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("personId")
    @Expose
    private float personId;


    // Getter Methods

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Setter Methods

    public float getPersonId() {
        return personId;
    }

    public void setPersonId(float personId) {
        this.personId = personId;
    }
}
