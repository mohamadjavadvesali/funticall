package com.fntl.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_post_Model {

    @SerializedName("data")
    @Expose
    private List<PostModel> post_data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errors")
    @Expose
    private List<Error> errors;
    @SerializedName("metaData")
    @Expose
    public MetaData metaData;

    public List<PostModel> getPost_data() {
        return post_data;
    }

    public void setPost_data(List<PostModel> post_data) {
        this.post_data = post_data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}

