package com.printf.kidsteacher.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.ReadBeen;
import com.printf.kidsteacher.other.Ease;
import com.printf.kidsteacher.other.EasingInterpolator;
import com.printf.kidsteacher.other.RecylerViewClick;

import java.util.ArrayList;

public class ReadAdapter extends RecyclerView.Adapter {
    ArrayList<ReadBeen> list;
    Context context;
    RecylerViewClick recylerViewClick;
    Animation animation;
    boolean isOpened = false;

    public ReadAdapter(Context context, ArrayList<ReadBeen> list, RecylerViewClick recylerViewClick) {
        this.recylerViewClick = recylerViewClick;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            MyViewHolder holder = (MyViewHolder) viewHolder;
            ReadBeen item = list.get(i);
            holder.tv_name.setText(item.getName());
            holder.iv_img.setImageResource(item.getImg());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_name;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_img = itemView.findViewById(R.id.iv_img);

            animation = AnimationUtils.loadAnimation(context, R.anim.bounce);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOpened)
                        return;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "translationY", 0, 50, 0);
                    animator.setInterpolator(new EasingInterpolator(Ease.BOUNCE_IN_OUT));
                    animator.setStartDelay(0);
                    animator.setDuration(1500);
                    animator.start();
                    isOpened = true;
                    animator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {

                            if(getAdapterPosition() >= list.size())
                                return;

                            isOpened = false;
//                            recylerViewClick.OnClick(list.get(getAdapterPosition()).getName());
                            if(getAdapterPosition() >= 0)
                                recylerViewClick.OnClick(list.get(getAdapterPosition()).getName());
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });

                }
            });
        }
    }
}
