package com.printf.kidsteacher.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.roger.catloadinglibrary.CatLoadingView;

public class BaseActivity extends AppCompatActivity
{

    public BaseActivity activity;
    public CatLoadingView mView;
    Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        mView = new CatLoadingView();
        mView.setCanceledOnTouchOutside(false);
        //mView.setBackgroundColor(Color.parseColor("#000000"));
        gson = new Gson();
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static void hideKeyboardFrom(Context context, View view, boolean isOpen) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (isOpen)imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
        else
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
