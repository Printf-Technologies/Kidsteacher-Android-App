package com.printf.kidsteacher.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.databinding.ActivitySubCategoryBinding
import com.printf.kidsteacher.fragment.ReadDetailFragment
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.fragment.WriteDetailFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_sub_category.*
import kotlinx.android.synthetic.main.custom_header.*


class DetailActivity : BaseActivity() {
    var binding: ActivitySubCategoryBinding? = null
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_category)

        viewModel = ViewModelProviders.of(this)[DetailViewModel::class.java]

        viewModel.setSubCategory(intent.extras!!.getString("SubCategory").toString())
        viewModel.setPosition(intent.extras!!.getInt("Position"))

        llBackParent.setOnClickListener {
            onBackPressed()
        }

        ripple_repeat.setOnClickListener {
            viewModel.setRepeatPlay(true)
        }

        ripple_sound.setOnClickListener {
            viewModel.setIsSpeakerOn()
        }

        viewModel.isSpeakerOnObservable.observe(this, Observer<Boolean> { isSpeakerOn ->
            if (isSpeakerOn) {
                ivSpeaker.setImageResource(R.drawable.ic_aimg)
                ripple_repeat.visibility = View.VISIBLE
            } else {
                ivSpeaker.setImageResource(R.drawable.ic_bimg)
                ripple_repeat.visibility = View.GONE
            }
        })

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

            //extra button
            ripple_repeat.visibility = View.VISIBLE
            ripple_sound.visibility = View.VISIBLE
            llSearchIcon.visibility = View.GONE

            var readDetailFragment = ReadDetailFragment()


            var extra = Bundle()
            extra.putInt("Position", viewModel.positionObservable.value?.toInt()!!)
            extra.putString("SubCategory", viewModel.subCategoryObservable.value.toString())
            extra.putString("FragmentType", "Read")
            readDetailFragment.arguments = extra

            replaceFragment(readDetailFragment, ReadDetailFragment::class.java.simpleName)
        }
        rl_write.setOnClickListener {

            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.VISIBLE
            view_video.visibility = View.INVISIBLE

            //Extra button
            ripple_repeat.visibility = View.GONE
            ripple_sound.visibility = View.GONE
            llSearchIcon.visibility = View.GONE

            var writeFragment = WriteDetailFragment()


            var extra = Bundle()
            extra.putInt("Position", viewModel.positionObservable.value?.toInt()!!)
            extra.putString("SubCategory", viewModel.subCategoryObservable.value.toString())
            extra.putString("FragmentType", "Write")
            writeFragment.arguments = extra

            replaceFragment(writeFragment, WriteDetailFragment::class.java.simpleName)

        }
        rl_video.setOnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.VISIBLE

            //Extra button
            ripple_repeat.visibility = View.GONE
            ripple_sound.visibility = View.GONE
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
        etSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboardFrom(activity!!, etSearch, false)
                return@OnEditorActionListener true
            }
            false
        })


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