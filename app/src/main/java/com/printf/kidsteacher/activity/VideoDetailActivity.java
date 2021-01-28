package com.printf.kidsteacher.activity;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.videoData.Datum;
import com.printf.kidsteacher.databinding.ActivityVideoDetailBinding;

import java.util.ArrayList;
import java.util.List;

import tcking.github.com.giraffeplayer2.VideoView;

public class VideoDetailActivity extends BaseActivity {
    ActivityVideoDetailBinding binding;
    Activity activity;
    AdView mAdView;
    List<Datum> list = new ArrayList<>();
    int position = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_detail);
        activity = VideoDetailActivity.this;
        init();
    }

    private void init() {
        VideoView videoView = findViewById(R.id.video_view);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        if (MainActivity.showAd.equalsIgnoreCase("1")) {
            mAdView.loadAd(adRequest);
        } else {
            mAdView.setVisibility(View.GONE);
        }

        Bundle bundle = getIntent().getBundleExtra("list");
        position = bundle.getInt("position");
        list = (List<Datum>) bundle.getSerializable("list");
        //this.position=Integer.parseInt(position);

        if(position >= list.size())
            finish();

        String url = list.get(this.position).getVideoUrl();//"/*http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";*///getIntent().getStringExtra("url");
        videoView.setVideoPath(url).getPlayer().start();
        videoView.getVideoInfo().setTitle(list.get(this.position).getVideoName());
        videoView.getVideoInfo().setFullScreenAnimation(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdView != null) {
            mAdView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAdView != null) {
            mAdView.destroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
//        if (player != null && player.onBackPressed()) {
//            return;
//        }
        super.onBackPressed();
    }
}
