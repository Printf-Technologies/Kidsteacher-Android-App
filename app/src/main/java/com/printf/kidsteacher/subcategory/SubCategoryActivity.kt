package com.printf.kidsteacher.subcategory

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.databinding.ActivitySubCategoryBinding
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.fragment.WriteFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_sub_category.*


class SubCategoryActivity : BaseActivity(){
    var binding: ActivitySubCategoryBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_category)

        ll_start.setOnClickListener{
            onBackPressed()
        }
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
            val mainCategory = intent.extras!!.getString("MainCategory")
            val subCategory = intent.extras!!.getString("SubCategory")

            var extra = Bundle()
            extra.putString("MainCategory", mainCategory)
            extra.putString("SubCategory", subCategory)
            extra.putString("FragmentType", "Read")
            writeFragment.arguments = extra

            replaceFragment(writeFragment, WriteFragment::class.java.simpleName)
        }
        rl_write.setOnClickListener {

            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.VISIBLE
            view_video.visibility = View.INVISIBLE

            var writeFragment = WriteFragment()
            val mainCategory = intent.extras!!.getString("MainCategory")
            val subCategory = intent.extras!!.getString("SubCategory")

            var extra = Bundle()
            extra.putString("MainCategory", mainCategory)
            extra.putString("SubCategory", subCategory)
            extra.putString("FragmentType", "Write")
            writeFragment.arguments = extra

            replaceFragment(writeFragment, WriteFragment::class.java.simpleName)

        }
        rl_video.setOnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.VISIBLE

            replaceFragment(VideoFragment(), VideoFragment::class.java.simpleName)
        }


        val fragmentName = intent.extras!!.getString("FragmentType")

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

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left)
        finish()
    }
}