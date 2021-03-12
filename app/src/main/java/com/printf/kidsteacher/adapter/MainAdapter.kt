package com.printf.kidsteacher.adapter

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.printf.kidsteacher.R
import com.printf.kidsteacher.been.MainBeen
import com.printf.kidsteacher.databinding.ItemMainBinding
import com.printf.kidsteacher.other.Ease
import com.printf.kidsteacher.other.EasingInterpolator
import com.printf.kidsteacher.other.RecyclerViewClick
import java.util.*

class MainAdapter(var list: ArrayList<MainBeen>, var recyclerViewClick: RecyclerViewClick) :
        RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    var isOpened = false

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MainAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_main,
                viewGroup,
                false
        ) as ItemMainBinding
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: MainAdapter.MyViewHolder, i: Int) {
        val dataModel = list[i]
        viewHolder.bind(dataModel, i)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var itemRowBinding: ItemMainBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

        fun bind(data: MainBeen, position : Int) {
            itemRowBinding.item = data
            itemRowBinding.executePendingBindings()

            itemRowBinding.root.setOnClickListener {
                if (isOpened) return@setOnClickListener

                isOpened = true
                val animator = ObjectAnimator.ofFloat(itemView, "translationY", 0f, 50f, 0f)
                animator.interpolator = EasingInterpolator(Ease.BOUNCE_IN_OUT)
                animator.startDelay = 0
                animator.duration = 1500
                animator.start()

                animator.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animator: Animator) {}
                    override fun onAnimationEnd(animator: Animator) {
                        isOpened = false
                        recyclerViewClick.OnClick(data.img,data.name,position)
                    }

                    override fun onAnimationCancel(animator: Animator) {
                        isOpened = false
                    }

                    override fun onAnimationRepeat(animator: Animator) {}
                })
            }
        }
    }
}