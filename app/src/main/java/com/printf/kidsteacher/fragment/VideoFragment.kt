package com.printf.kidsteacher.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.DetailViewModel
import com.printf.kidsteacher.activity.VideoDetailActivity
import com.printf.kidsteacher.adapter.VideoAdapter
import com.printf.kidsteacher.been.videoData.VideoData
import com.printf.kidsteacher.common.CheckInternet
import com.printf.kidsteacher.other.RecyclerViewClick
import com.printf.kidsteacher.video.VideoViewModel
import com.roger.catloadinglibrary.CatLoadingView
import kotlinx.android.synthetic.main.fragment_video.*
import java.io.Serializable

class VideoFragment : BaseFragment(), LifecycleObserver, RecyclerViewClick {

    private lateinit var viewModel: DetailViewModel
    var videoAdapter: VideoAdapter? = null
    var animation: Animation? = null

    private lateinit var videoViewModel: VideoViewModel

    private lateinit var mView: CatLoadingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[DetailViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        viewModel.searchObservable.observe(this, Observer<String> { search ->
            if(videoAdapter != null)
                videoAdapter!!.filter(search)
        })

        mView = CatLoadingView()
        mView.setCanceledOnTouchOutside(false)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videoViewModel = VideoViewModel(requireActivity().application)
        setupObservers()

        init()
    }

    private fun init() {
        callApi()
        animation = AnimationUtils.loadAnimation(activity, R.anim.bounce)
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
            ll_noInternet.visibility = View.VISIBLE
            rv_video.visibility = View.GONE
            return
        }
        videoViewModel.getVideo()
    }

    private fun setAdapter(videoData: VideoData?) {
        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        rv_video!!.layoutManager = gridLayoutManager
        videoAdapter = VideoAdapter(requireContext(), videoData!!.data!!, this)
        rv_video!!.adapter = videoAdapter
    }

    private fun setupObservers() {
        videoViewModel.dataObservable.observe(viewLifecycleOwner, Observer {
            ll_noInternet!!.visibility = View.GONE
            if (it.data.isNullOrEmpty() || it.data?.size == 0) {
                ll_noInternet.visibility = View.VISIBLE
                rv_video.visibility = View.GONE
            } else {
                ll_noInternet.visibility = View.GONE
                rv_video.visibility = View.VISIBLE
                setAdapter(it)
            }
        })
        videoViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                mView.show(requireActivity().supportFragmentManager, "")
            } else {
                mView.dismiss()
            }
        })

        videoViewModel.errorObservable.observe(viewLifecycleOwner, Observer {
            ll_noInternet.visibility = View.VISIBLE
            rv_video.visibility = View.GONE
        })

        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    override fun OnClick(img: Int, name: String?, position: Int) {
        val intent = Intent(context, VideoDetailActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("list", videoViewModel.dataObservable.value?.data!! as Serializable)
        bundle.putInt("position", position)
        intent.putExtra("list", bundle)

        viewModel.setIntent(intent)
    }
}