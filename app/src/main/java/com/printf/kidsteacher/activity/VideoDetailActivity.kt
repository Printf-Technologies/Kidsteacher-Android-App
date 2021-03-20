package com.printf.kidsteacher.activity

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.been.videoData.Datum
import com.printf.kidsteacher.common.PreferencesManager
import com.printf.kidsteacher.databinding.ActivityVideoDetailBinding
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_video_detail.*
import java.util.*

class VideoDetailActivity : BaseActivity() {
    var binding: ActivityVideoDetailBinding? = null
    var list: List<Datum>? = ArrayList()
    var position = -1

    private var simpleExoPlayer: SimpleExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_detail)
        val bundle = intent.getBundleExtra("list")
        position = bundle.getInt("position")
        list = bundle.getSerializable("list") as List<Datum>?
        init()
    }

    private fun init() {
        playerView.setShutterBackgroundColor(Color.TRANSPARENT)
        playerView.requestFocus()

        val adRequest = AdRequest.Builder().build()
        if (PreferencesManager.instance(this).isShowBannerAd()) {
            mAdView.loadAd(adRequest)
        } else {
            mAdView.visibility = View.GONE
        }

        ivBack.setOnClickListener { finish() }
    }

    fun setupPlayer() {
        tvVideoTitle!!.text = list!![position].videoName
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this)
        val mediaDataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(this, Util.getUserAgent(this, "kids"))
        val mediaSource = ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(MediaItem.fromUri(Uri.parse(list!![position].videoUrl)))
        simpleExoPlayer!!.prepare(mediaSource)
        playerView!!.player = simpleExoPlayer
        simpleExoPlayer!!.playWhenReady = true
        simpleExoPlayer!!.repeatMode = Player.REPEAT_MODE_OFF
        simpleExoPlayer!!.addListener(object : Player.EventListener {
            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                if (playbackState == ExoPlayer.STATE_BUFFERING) {
                }
                if (playbackState == ExoPlayer.STATE_READY && playWhenReady) {
                }
                if (playbackState == ExoPlayer.STATE_ENDED) {
                    position = (position + 1) % list!!.size
                    setupPlayer()
                }
            }
        })
    }

    fun releasePlayer() {
        if (simpleExoPlayer == null) {
            return
        }
        simpleExoPlayer!!.playWhenReady = false
        simpleExoPlayer!!.stop()
        simpleExoPlayer!!.release()
        playerView!!.onPause()
        playerView!!.player = null
    }

    public override fun onResume() {
        super.onResume()
        setupPlayer()
    }

    public override fun onPause() {
        super.onPause()
        releasePlayer()
    }
}