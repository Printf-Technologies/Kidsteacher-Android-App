package com.printf.kidsteacher.activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.printf.kidsteacher.BaseActivity;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.videoData.Datum;
import com.printf.kidsteacher.databinding.ActivityVideoDetailBinding;
import com.printf.kidsteacher.mainactivity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailActivity extends BaseActivity {
    ActivityVideoDetailBinding binding;

    AdView mAdView;
    List<Datum> list = new ArrayList<>();
    int position = -1;

    TextView tvVideoTitle;

    private SimpleExoPlayer simpleExoPlayer;
    private PlayerView playerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_detail);

        Bundle bundle = getIntent().getBundleExtra("list");
        position = bundle.getInt("position");
        list = (List<Datum>) bundle.getSerializable("list");

        init();
    }

    private void init() {

        tvVideoTitle = findViewById(R.id.tvVideoTitle);

        playerView = findViewById(R.id.video_view);
        playerView.setShutterBackgroundColor(Color.TRANSPARENT);
        playerView.requestFocus();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        if (MainActivity.showAd.equalsIgnoreCase("1")) {
            mAdView.loadAd(adRequest);
        } else {
            mAdView.setVisibility(View.GONE);
        }

        ImageView ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setupPlayer() {

        tvVideoTitle.setText(list.get(this.position).getVideoName());
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);

        DataSource.Factory mediaDataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "kids"));
        ProgressiveMediaSource mediaSource = new ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource( MediaItem.fromUri(Uri.parse(list.get(this.position).getVideoUrl())));
        simpleExoPlayer.prepare(mediaSource);

        playerView.setPlayer(simpleExoPlayer);


        simpleExoPlayer.setPlayWhenReady(true);

        simpleExoPlayer.setRepeatMode(Player.REPEAT_MODE_OFF);
        simpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == ExoPlayer.STATE_BUFFERING) {
                }
                if (playbackState == ExoPlayer.STATE_READY && playWhenReady) {
                }
                if (playbackState == ExoPlayer.STATE_ENDED) {
                    //releasePlayer();
                    position = (position + 1) % list.size();

                    setupPlayer();
                }
            }
        });

    }

    public void releasePlayer() {
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.stop();
        simpleExoPlayer.release();

        playerView.onPause();
        playerView.setPlayer(null);
    }


    @Override
    public void onResume() {
        super.onResume();
        setupPlayer();

        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        releasePlayer();

        if (mAdView != null) {
            mAdView.pause();
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
        super.onBackPressed();
    }
}
