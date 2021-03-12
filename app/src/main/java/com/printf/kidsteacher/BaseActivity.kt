package com.printf.kidsteacher

import androidx.appcompat.app.AppCompatActivity
import com.printf.kidsteacher.BaseActivity
import com.roger.catloadinglibrary.CatLoadingView
import com.google.gson.Gson
import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.inputmethod.InputMethodManager

open class BaseActivity : AppCompatActivity() {
    @JvmField
    var activity: BaseActivity? = null
    var mView: CatLoadingView? = null
    var gson: Gson? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        mView = CatLoadingView()
        mView!!.setCanceledOnTouchOutside(false)
        //mView.setBackgroundColor(Color.parseColor("#000000"));
        gson = Gson()
    }

    companion object {
        @JvmStatic
        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun pxToDp(px: Int): Int {
            return (px / Resources.getSystem().displayMetrics.density).toInt()
        }

        @JvmStatic
        fun hideKeyboardFrom(context: Context, view: View, isOpen: Boolean) {
            val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            if (isOpen) imm.showSoftInput(view, InputMethodManager.SHOW_FORCED) else imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}