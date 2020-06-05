package com.printf.kidsteacher.other;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Helper
{
    public static int height = -1;
    public static int width = -1;
    public static int remove_width = 0;
    public static int remove_hight = 250;

    public static void getDeviceHightWidth(Context context)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;
        height = height - remove_hight;
        width= width-remove_width;//285;
    }
}
