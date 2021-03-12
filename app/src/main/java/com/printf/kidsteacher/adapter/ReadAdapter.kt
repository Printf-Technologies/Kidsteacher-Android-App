package com.printf.kidsteacher.adapter

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.printf.kidsteacher.R
import com.printf.kidsteacher.been.ReadBeen
import com.printf.kidsteacher.databinding.ItemCardBinding
import com.printf.kidsteacher.other.Ease
import com.printf.kidsteacher.other.EasingInterpolator
import com.printf.kidsteacher.other.RecyclerViewClick
import retrofit2.http.POST
import java.util.*

class ReadAdapter(var list: ArrayList<ReadBeen>, var recylerViewClick: RecyclerViewClick) :
        RecyclerView.Adapter<ReadAdapter.MyViewHolder>() {

    var isOpened = false

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ReadAdapter.MyViewHolder {

        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_card,
                viewGroup,
                false
        ) as ItemCardBinding
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ReadAdapter.MyViewHolder, i: Int) {

        val dataModel = list[i]
        viewHolder.bind(dataModel, i)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var itemRowBinding: ItemCardBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {

        fun bind(data: ReadBeen, position : Int) {
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
                        recylerViewClick.OnClick(data.img, data.name, position)
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