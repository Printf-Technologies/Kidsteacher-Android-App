package com.printf.kidsteacher


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class DataBindingUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("app:setImage")
        fun setImage(imageView: ImageView, res: Int) {
            imageView.setImageResource(res)
        }

        @JvmStatic
        @BindingAdapter("app:loadImage")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context).load(url).into(imageView)
        }

    }
}