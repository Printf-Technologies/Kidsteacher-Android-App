package com.printf.kidsteacher.category

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.activity.DetailViewModel
import com.printf.kidsteacher.databinding.ActivitySubCategoryBinding
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.fragment.WriteFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_sub_category.*
import kotlinx.android.synthetic.main.custom_header.*


class ReadActivity : BaseActivity() {
    var binding: ActivitySubCategoryBinding? = null

    var fragmentName = ""
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_category)
        viewModel = ViewModelProviders.of(this)[DetailViewModel::class.java]

        llBackParent.setOnClickListener{
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

            llSearchIcon.visibility = View.GONE

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

            llSearchIcon.visibility = View.GONE

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

            llSearchIcon.visibility = View.VISIBLE

            replaceFragment(VideoFragment(), VideoFragment::class.java.simpleName)
        }


        llSearchIcon.setOnClickListener {
            llSearch.animate().alpha(1.0f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    llSearch.visibility = View.VISIBLE
                    llSearch.requestFocus()
                    hideKeyboardFrom(activity!!, etSearch, true)
                }
            })
        }
        ivBackFromSearch.setOnClickListener {
            etSearch.setText("")
            llSearch.animate().alpha(0.0f).setDuration(300).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    llSearch.visibility = View.GONE
                    hideKeyboardFrom(activity!!, etSearch, false)
                }
            })
        }
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int,
                                       before: Int, count: Int) {
                viewModel.setOnSearch(etSearch.text.toString())
            }
        })
        etSearch.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboardFrom(activity!!, etSearch, false)
                return@OnEditorActionListener true
            }
            false
        })

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