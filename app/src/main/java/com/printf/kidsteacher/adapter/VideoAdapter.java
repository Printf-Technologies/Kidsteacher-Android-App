package com.printf.kidsteacher.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.activity.BaseActivity;
import com.printf.kidsteacher.activity.VideoActivity;
import com.printf.kidsteacher.activity.VideoDetailActivity;
import com.printf.kidsteacher.been.videoData.Datum;
import com.printf.kidsteacher.other.Ease;
import com.printf.kidsteacher.other.EasingInterpolator;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter
{
    Context context;
    List<Datum> list;
    ArrayList<Datum> arraylist;
    Animation animation;
    boolean isOpened = false;

    public VideoAdapter(Context activity, List<Datum> data)
    {
        context = activity;
        list = data;
        arraylist = new ArrayList<>();
        arraylist.addAll(list);
    }

    public void filter(String charText)
    {
        list.clear();////main list
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        else
        {
            for (Datum wp : arraylist)
            {
                if (wp.getVideoName().toLowerCase().contains(charText.toLowerCase()))
                {
                    list.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i)
    {
        if(viewHolder instanceof MyViewHolder)
        {
            MyViewHolder holder = (MyViewHolder)viewHolder;
            holder.view.setVisibility(View.VISIBLE);
            holder.iv_temp.setVisibility(View.VISIBLE);
            holder.iv_img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(context).load(list.get(i).getThumbnailUrl()).into(holder.iv_img);
            if(list.get(i).getVideoName() != null && !list.get(i).getVideoName().equalsIgnoreCase(""))
            {
                holder.tv_name.setText(list.get(i).getVideoName());
                holder.tv_name.setTextSize(context.getResources().getDimension(R.dimen._6sdp));
                holder.tv_name.setGravity(Gravity.START);
                holder.tv_name.setMaxLines(2);
                holder.tv_name.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv_img,iv_temp;
        TextView tv_name;
        View view;

        public MyViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            iv_img = itemView.findViewById(R.id.iv_img);
            view = itemView.findViewById(R.id.view);
            iv_temp = itemView.findViewById(R.id.iv_temp);

            animation = AnimationUtils.loadAnimation(context,R.anim.bounce);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
                            isOpened = false;
                            Intent intent = new Intent(context, VideoDetailActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("list",(Serializable) list);
                            bundle.putInt("position",getAdapterPosition());
                            intent.putExtra("list",bundle);
                            context.startActivity(intent);
                            ((Activity)context).overridePendingTransition(R.anim.enter_left,R.anim.exit_right);
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
