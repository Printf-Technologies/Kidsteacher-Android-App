package com.printf.kidsteacher.adapter

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.VideoDetailActivity
import com.printf.kidsteacher.been.videoData.Datum
import com.printf.kidsteacher.databinding.ItemVideoBinding
import com.printf.kidsteacher.other.Ease
import com.printf.kidsteacher.other.EasingInterpolator
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class VideoAdapter(var context: Context, var list: ArrayList<Datum>) :
        RecyclerView.Adapter<VideoAdapter.MyViewHolder>() {
    var arraylist: ArrayList<Datum> = ArrayList()
    var isOpened = false
    fun filter(charText: String) {
        list.clear()
        if (charText.isEmpty()) {
            list.addAll(arraylist)
        } else {
            for (wp in arraylist) {
                if (wp.videoName!!.toLowerCase().contains(charText.toLowerCase())) {
                    list.add(wp)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VideoAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_video,
                viewGroup,
                false
        ) as ItemVideoBinding
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: VideoAdapter.MyViewHolder, i: Int) {
        val dataModel = list[i]
        viewHolder.bind(dataModel, i)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var itemRowBinding: ItemVideoBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

        fun bind(data: Datum, position: Int) {
            itemRowBinding.item = data
            itemRowBinding.executePendingBindings()

            itemRowBinding.root.setOnClickListener {

                if (isOpened) return@setOnClickListener

                isOpened = false
                val animator = ObjectAnimator.ofFloat(itemView, "translationY", 0f, 50f, 0f)
                animator.interpolator = EasingInterpolator(Ease.BOUNCE_IN_OUT)
                animator.startDelay = 0
                animator.duration = 1500
                animator.start()

                animator.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animator: Animator) {}
                    override fun onAnimationEnd(animator: Animator) {
                        isOpened = false
                        val intent = Intent(context, VideoDetailActivity::class.java)
                        val bundle = Bundle()
                        bundle.putSerializable("list", list as Serializable)
                        bundle.putInt("position", position)
                        intent.putExtra("list", bundle)
                        context.startActivity(intent)
                        (context as Activity).overridePendingTransition(R.anim.enter_left, R.anim.exit_right)
                    }

                    override fun onAnimationCancel(animator: Animator) {
                        isOpened = false
                    }

                    override fun onAnimationRepeat(animator: Animator) {}
                })
            }
        }

    }

    init {
        arraylist.addAll(list)
    }
}