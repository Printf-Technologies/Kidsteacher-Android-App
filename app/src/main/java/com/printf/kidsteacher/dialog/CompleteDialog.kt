package com.printf.kidsteacher.dialog

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.printf.kidsteacher.R
import kotlinx.android.synthetic.main.dialog_restart.*

abstract class CompleteDialog(
        context: Context
) : Dialog(context) {
    var animation : Animation
    init {
        animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
        /*requestWindowFeature(Window.FEATURE_NO_TITLE)
        window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        setContentView(R.layout.dialog_restart)
        setCancelable(false)*/

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_restart)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(window?.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        getWindow()?.setAttributes(lp)


        animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
        //tv_title.setText(getEmoticon(0x1F476)+getString(R.string.app_name)+getEmoticon(0x1F60E));
        iv_close.setOnClickListener {
            iv_close.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    dismiss()
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }
        iv_startAgain.setOnClickListener {
            iv_startAgain.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    animation_view.cancelAnimation()
                    dismiss()
                    onStartAgain()
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
        }
        iv_goNext.setOnClickListener {
            iv_goNext.startAnimation(animation)
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    animation_view.cancelAnimation()
                    dismiss()
                    onGoToNext()

                }

                override fun onAnimationRepeat(animation: Animation) {}
            })
        }
        animation_view.playAnimation()

    }

    abstract fun onStartAgain()
    abstract fun onGoToNext()

}