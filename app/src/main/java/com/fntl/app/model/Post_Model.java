package com.fntl.app.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post_Model extends BaseObservable {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errors")
    @Expose
    private Object errors;
    @SerializedName("metaData")
    @Expose
    private MetaData metaData;

    @Bindable
    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }

    @Bindable

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);

    }

    @Bindable

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
        notifyPropertyChanged(BR.errors);

    }

    @Bindable

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
        notifyPropertyChanged(BR.metaData);

    }

}
