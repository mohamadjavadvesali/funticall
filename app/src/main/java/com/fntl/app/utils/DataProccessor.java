package com.fntl.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class DataProccessor {

    public final static String PREFS_NAME = "appname_prefs";
    private static Context context;

    public DataProccessor(Context context) {
        DataProccessor.context = context;
    }

    public static void setInt(String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getInt(key, 0);
    }

    public static void setStr(String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStr(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getString(key, "DNF");
    }

    public static void setBool(String key, boolean value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBool(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return prefs.getBoolean(key, false);
    }

    public boolean sharedPreferenceExist(String key) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        return !prefs.contains(key);
    }
}