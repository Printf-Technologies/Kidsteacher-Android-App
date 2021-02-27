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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.WriteBeen;
import com.printf.kidsteacher.other.Ease;
import com.printf.kidsteacher.other.EasingInterpolator;
import com.printf.kidsteacher.other.RecyclerImage;

import java.util.ArrayList;

public class WriteAdapter extends RecyclerView.Adapter<WriteAdapter.MyViewHolder>
{

    ArrayList<WriteBeen> list;
    Context context;
    RecyclerImage recylerViewClick;
    Animation animation;
    boolean isOpened = false;

    public WriteAdapter(Context context, ArrayList<WriteBeen> list, RecyclerImage recylerViewClick)
    {
        this.recylerViewClick = recylerViewClick;
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        WriteBeen item = list.get(i);
        myViewHolder.ll_back.setBackgroundResource(R.drawable.paint);
        myViewHolder.tv_name.setText(item.getName());
        myViewHolder.iv_img.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_img;
        TextView tv_name;
        LinearLayout ll_back;

        public MyViewHolder(@NonNull final View itemView)
        {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_img = itemView.findViewById(R.id.iv_img);
            ll_back = itemView.findViewById(R.id.ll_back);

            animation = AnimationUtils.loadAnimation(context,R.anim.bounce);

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
                            int pos = getAdapterPosition();
                            if(pos < 0 || pos >= list.size())
                                return;

                            isOpened = false;
                            recylerViewClick.onClickImg(list.get(pos).getImg(), list.get(pos).getName(), pos);
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
