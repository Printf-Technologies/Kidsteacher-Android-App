package com.printf.kidsteacher.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.adapter.VideoAdapter;
import com.printf.kidsteacher.been.videoData.VideoData;
import com.printf.kidsteacher.common.ApiCall;
import com.printf.kidsteacher.common.ApiResponce;
import com.printf.kidsteacher.common.CheckInternet;
import com.printf.kidsteacher.common.WebServices;
import com.printf.kidsteacher.view.CustomTextView;

public class VideoFragment extends BaseFragment {
    private BroadcastReceiver mReceiver;
    RecyclerView rv_video;
    VideoAdapter videoAdapter;
    VideoData videoData;
    LinearLayout ll_noInternet;
    ImageView iv_refresh;
    Animation animation;
    CustomTextView tv_message;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        rv_video = view.findViewById(R.id.rv_video);
        ll_noInternet = view.findViewById(R.id.ll_noInternet);
        tv_message = view.findViewById(R.id.tv_message);
        iv_refresh = view.findViewById(R.id.iv_refresh);
        callApi();
        //new Handler().postDelayed(new Runnable() {@Override public void run() { callApi(); }},1000);

        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               callApi();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_refresh.startAnimation(animation);
            }
        });
    }

    private void callApi() {
        if (!CheckInternet.networkAvailability(activity)) {
            tv_message.setText("No internet connection. Please connect to internet and try again.");
            ll_noInternet.setVisibility(View.VISIBLE);
            return;
        }
        ApiCall.GetApi(true, false, activity, WebServices.VIDEO_API, new ApiResponce() {
            @Override
            public void Responce(String responce) {

                if(isVisible() && isAdded()){
                    ll_noInternet.setVisibility(View.GONE);
                    videoData = new Gson().fromJson(responce, VideoData.class);
                    setAdapter(videoData);
                    if (videoData.getData().size() == 0) {
                        tv_message.setText("Awesome videos coming soon. We are creating awesome videos for you.");
                        ll_noInternet.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void Error(String error) {

            }
        });
    }

    private void setAdapter(VideoData videoData) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rv_video.setLayoutManager(gridLayoutManager);
        videoAdapter = new VideoAdapter(getActivity(), videoData.getData());
        rv_video.setAdapter(videoAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String tempSearchedText = intent.getStringExtra("Search");

                if (videoAdapter == null) {
                    return;
                }
                videoAdapter.filter(tempSearchedText);
            }
        };
        //registering our receiver
        getActivity().registerReceiver(mReceiver, intentFilter);

    }

       @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Activity a = getActivity();
            if (a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
