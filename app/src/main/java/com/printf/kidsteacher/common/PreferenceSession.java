package com.printf.kidsteacher.common;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceSession {

    public static String USER_PREFERENCES = "user_preference";

    public static void saveUserSession(Context context,String key, String value)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE).edit();
        editor.putString(key,value);
        editor.apply();
        editor.commit();
    }

    public static String getUserSession(Context context,String key)
    {
        SharedPreferences preferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }

    public static void clearUserSession(Context context)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }
}