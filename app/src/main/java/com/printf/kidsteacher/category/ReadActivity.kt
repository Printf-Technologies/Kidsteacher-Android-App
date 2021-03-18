package com.printf.kidsteacher.category

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.databinding.ActivityReadBinding
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.fragment.WriteFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_read.*


class ReadActivity : BaseActivity(), View.OnClickListener {
    var binding: ActivityReadBinding? = null

    var fragmentName = ""

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

        rl_read.setOnClickListener {
            view_read.visibility = View.VISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.INVISIBLE


            var writeFragment = WriteFragment()
            var extra = Bundle()
            extra.putString("MainCategory", fragmentName)
            extra.putString("SubCategory", "")
            extra.putString("FragmentType", "Read")
            writeFragment.arguments = extra

            replaceFragment(writeFragment, WriteFragment::class.java.simpleName)

        }

        rl_write.setOnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.VISIBLE
            view_video.visibility = View.INVISIBLE

            var writeFragment = WriteFragment()
            var extra = Bundle()
            extra.putString("MainCategory", fragmentName)
            extra.putString("SubCategory", "")
            extra.putString("FragmentType", "write")
            writeFragment.arguments = extra

            replaceFragment(writeFragment, WriteFragment::class.java.simpleName)

        }
        rl_video.setOnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.VISIBLE

            replaceFragment(VideoFragment(), VideoFragment::class.java.simpleName)
        }


        fragmentName = intent.extras!!.getString("FragmentName").toString()

        if (fragmentName.equals("Read", ignoreCase = true)) {
            rl_read.performClick()
        } else if (fragmentName.equals("write", ignoreCase = true)) {
            rl_write.performClick()
        } else if (fragmentName.equals("video", ignoreCase = true)) {
            rl_video.performClick()
        }


    }

    private fun replaceFragment(fragment: Fragment, fragmentTag: String) {
        val fragmentManager = activity?.supportFragmentManager
        val ft = fragmentManager?.beginTransaction()
        ft?.replace(R.id.frameLayout, fragment, fragmentTag)
        ft?.commit()
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