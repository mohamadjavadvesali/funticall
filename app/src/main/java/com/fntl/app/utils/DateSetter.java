package com.fntl.app.utils;

import android.util.Log;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class DateSetter {
    private static final String TAG = "DateSetter";

    @BindingAdapter("setDate")
    public static void setDate(TextView textView, String createdDate) {
        createdDate = createdDate.substring(0, 18);
        createdDate = createdDate + 'Z';
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Date date = new Date();

        try {
            date = format.parse(createdDate);
        } catch (ParseException e) {
            Log.i(TAG, "setDate: ERROR");
        }

        PersianDate pdate = new PersianDate(date);
        PersianDateFormat pdformater = new PersianDateFormat();

        textView.setText(pdformater.format(pdate));
    }
}
