package com.fntl.app.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageSetter {

    @BindingAdapter("setAvatar")
    public static void setDefaultImage(ImageView imageView, String imageUrl) {
        String url = "";

        if (imageUrl == null)
            url = "https://funtical.app/images/avatar_default.png";
        else
            url = "https://api.funtical.app/core/Download/" + imageUrl + "?sizeRatio=256&flipVertical=false";

        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("setImage")
    public static void setImage(ImageView imageView, String imageUrl) {
        String url = "https://api.funtical.app/core/Download/" + imageUrl + "?sizeRatio=512&flipVertical=false";

        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);

    }

}
