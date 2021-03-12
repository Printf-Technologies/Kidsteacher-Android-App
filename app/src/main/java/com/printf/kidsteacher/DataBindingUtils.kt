package com.printf.kidsteacher


import android.widget.ImageView
import androidx.databinding.BindingAdapter

class DataBindingUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("app:setImage")
        fun setImage(imageView: ImageView, res: Int) {
            imageView.setImageResource(res)
        }

    }
}