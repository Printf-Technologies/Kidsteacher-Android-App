package com.printf.kidsteacher.category

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.databinding.ActivityReadBinding
import com.printf.kidsteacher.fragment.ReadFragmet
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.fragment.WriteFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : BaseActivity(), View.OnClickListener {
    var binding: ActivityReadBinding? = null

    var videoFragment = VideoFragment()
    var writeFragment = WriteFragment()
    var readFragment = ReadFragmet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_read)

        ll_start.setOnClickListener(this)
        val adRequest = AdRequest.Builder().build()
        if (MainActivity.showAd.equals("1", ignoreCase = true)) {
            mAdView.loadAd(adRequest)
        } else {
            mAdView.visibility = View.GONE
        }

        rl_read.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.VISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.INVISIBLE
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (!readFragment.isAdded) {
                transaction.add(R.id.frameLayout, readFragment)
            } else {
                transaction.show(readFragment)
                if (videoFragment.isAdded) {
                    transaction.hide(videoFragment)
                }
                if (writeFragment.isAdded) {
                    transaction.hide(writeFragment)
                }
            }
            transaction.commitAllowingStateLoss()
        })
        rl_write.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.VISIBLE
            view_video.visibility = View.INVISIBLE
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (!writeFragment.isAdded) {
                transaction.add(R.id.frameLayout, writeFragment)
            } else {
                transaction.show(writeFragment)
                if (videoFragment.isAdded) {
                    transaction.hide(videoFragment)
                }
                if (readFragment.isAdded) {
                    transaction.hide(readFragment)
                }
            }
            transaction.commitAllowingStateLoss()
        })
        rl_video.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.VISIBLE
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            if (!videoFragment.isAdded) {
                transaction.add(R.id.frameLayout, videoFragment)
                //transaction.addToBackStack(null);
            } else {
                transaction.show(videoFragment)
                if (writeFragment.isAdded) {
                    transaction.hide(writeFragment)
                }
                if (readFragment.isAdded) {
                    transaction.hide(readFragment)
                }
            }
            transaction.commitAllowingStateLoss()
        })


        val fName = intent.extras!!.getString("FragmentName")
        if (fName.equals("Read", ignoreCase = true)) {
            rl_read.performClick()
        } else if (fName.equals("write", ignoreCase = true)) {
            rl_write.performClick()
        } else if (fName.equals("video", ignoreCase = true)) {
            rl_video.performClick()
        }
    }

    override fun onClick(v: View) {
        if (v === ll_start) {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left)
        finish()
    }

    public override fun onPause() {
        if (mAdView != null) {
            mAdView!!.pause()
        }
        super.onPause()
    }

    public override fun onResume() {
        super.onResume()
        if (mAdView != null) {
            mAdView!!.resume()
        }
    }

    public override fun onDestroy() {
        if (mAdView != null) {
            mAdView!!.destroy()
        }
        super.onDestroy()
    }
}