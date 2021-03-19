package com.printf.kidsteacher.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.DetailViewModel
import com.printf.kidsteacher.adapter.VideoAdapter
import com.printf.kidsteacher.been.videoData.VideoData
import com.printf.kidsteacher.common.ApiCall
import com.printf.kidsteacher.common.ApiResponce
import com.printf.kidsteacher.common.CheckInternet
import com.printf.kidsteacher.common.WebServices
import kotlinx.android.synthetic.main.fragment_video.*

class VideoFragment : BaseFragment() {

    private lateinit var viewModel: DetailViewModel

    //private var mReceiver: BroadcastReceiver? = null
    var videoAdapter: VideoAdapter? = null
    var videoData: VideoData? = null
    var animation: Animation? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[DetailViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.searchObservable.observe(this, Observer<String> { search ->
            videoAdapter!!.filter(search)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        callApi()
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce)
        animation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                callApi()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        iv_refresh.setOnClickListener { iv_refresh?.startAnimation(animation) }
    }

    private fun callApi() {
        if (!CheckInternet.networkAvailability(requireContext())) {
            tv_message!!.text = "No internet connection. Please connect to internet and try again."
            ll_noInternet!!.visibility = View.VISIBLE
            return
        }
        ApiCall.GetApi(true, false, requireContext(), WebServices.VIDEO_API, object : ApiResponce {
            override fun Responce(responce: String) {
                if (isVisible && isAdded) {
                    ll_noInternet!!.visibility = View.GONE
                    videoData = Gson().fromJson(responce, VideoData::class.java)
                    setAdapter(videoData)
                    if (videoData?.data?.size == 0) {
                        tv_message!!.text = "Awesome videos coming soon. We are creating awesome videos for you."
                        ll_noInternet!!.visibility = View.VISIBLE
                    }
                }
            }

            override fun Error(error: String) {}
        })
    }

    private fun setAdapter(videoData: VideoData?) {
        val gridLayoutManager = GridLayoutManager(getActivity(), 3)
        rv_video!!.layoutManager = gridLayoutManager
        videoAdapter = VideoAdapter(requireContext(), videoData!!.data!!)
        rv_video!!.adapter = videoAdapter
    }

    override fun onResume() {
        super.onResume()
     /*   val intentFilter = IntentFilter("android.intent.action.MAIN")
        mReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val tempSearchedText = intent.getStringExtra("Search")
                if (videoAdapter == null) {
                    return
                }
                videoAdapter!!.filter(tempSearchedText)
            }
        }
        //registering our receiver
        getActivity()!!.registerReceiver(mReceiver, intentFilter)*/
    }
}