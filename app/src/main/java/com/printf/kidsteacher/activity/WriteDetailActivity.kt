package com.printf.kidsteacher.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import android.widget.TextView.OnEditorActionListener
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.adapter.ReadAdapter
import com.printf.kidsteacher.been.ReadBeen
import com.printf.kidsteacher.common.PrintfGlobal
import com.printf.kidsteacher.databinding.ActivityWriteDetailBinding
import com.printf.kidsteacher.fragment.ReadFragmet
import com.printf.kidsteacher.fragment.VideoFragment
import com.printf.kidsteacher.mainactivity.MainActivity
import com.printf.kidsteacher.other.RecyclerViewClick
import kotlinx.android.synthetic.main.activity_write_detail.*
import java.util.*

class WriteDetailActivity : BaseActivity(), View.OnClickListener, RecyclerViewClick {
    var binding: ActivityWriteDetailBinding? = null
    var list = ArrayList<ReadBeen>()

    var videoFragment = VideoFragment()
    var readFragmet = ReadFragmet()
    var type = ""
    var title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_detail)
        init()
    }

    private fun init() {
        ll_start.setOnClickListener(this)
        ll_end.setOnClickListener(this)
        iv_back.setOnClickListener(this)

        val adRequest = AdRequest.Builder().build()
        if (MainActivity.showAd.equals("1", ignoreCase = true)) {
            mAdView.loadAd(adRequest)
        } else {
            mAdView.visibility = View.GONE
        }
        type = ""
        if (intent.extras != null) {
            type = intent.extras!!.getString("type")!!
            title = ""
            if (type.equals(getString(R.string.alphabets), ignoreCase = true)) {
                title = getString(R.string.alphabets)
                list.clear()
                list.addAll(PrintfGlobal.getAlphabet_())
            } else if (type.equals(getString(R.string.numbers), ignoreCase = true)) {
                title = getString(R.string.numbers)
                list.clear()
                list.addAll(PrintfGlobal.getFromNumbers_())
            } else if (type.equals(getString(R.string.shapes), ignoreCase = true)) {
                title = getString(R.string.shapes)
                list.addAll(PrintfGlobal.getFromShape_())
            } else if (type.equals(getString(R.string.colors), ignoreCase = true)) {
                title = getString(R.string.colors)
                list.clear()
                list.addAll(PrintfGlobal.getFromColors_())
            } else if (type.equals(getString(R.string.days), ignoreCase = true)) {
                title = getString(R.string.days)
                list.clear()
                list.addAll(PrintfGlobal.getFromDays_())
            } else if (type.equals(getString(R.string.months), ignoreCase = true)) {
                title = getString(R.string.months)
                list.clear()
                list.addAll(PrintfGlobal.getFromMonths_())
            } else if (type.equals(getString(R.string.animals), ignoreCase = true)) {
                title = getString(R.string.animals)
                list.clear()
                list.addAll(PrintfGlobal.getFromAnimals_())
            } else if (type.equals(getString(R.string.body_parts), ignoreCase = true)) {
                title = getString(R.string.body_parts)
                list.clear()
                list.addAll(PrintfGlobal.getFromBodyParts_())
            } else if (type.equals(getString(R.string.fruits), ignoreCase = true)) {
                title = getString(R.string.fruits)
                list.clear()
                list.addAll(PrintfGlobal.getFromFruits_())
            } else if (type.equals(getString(R.string.transport), ignoreCase = true)) {
                title = getString(R.string.transport)
                list.clear()
                list.addAll(PrintfGlobal.getFromTransport_())
            } else if (type.equals(getString(R.string.proffesion), ignoreCase = true)) {
                title = getString(R.string.proffesion)
                list.clear()
                list.addAll(PrintfGlobal.getFromProfession_())
            } else if (type.equals(getString(R.string.sport), ignoreCase = true)) {
                title = getString(R.string.sport)
                list.clear()
                list.addAll(PrintfGlobal.getFromSports_())
            } else if (type.equals(getString(R.string.bird), ignoreCase = true)) {
                title = getString(R.string.bird)
                list.clear()
                list.addAll(PrintfGlobal.getFromBirds_())
            } else if (type.equals(getString(R.string.building), ignoreCase = true)) {
                title = getString(R.string.building)
                list.clear()
                list.addAll(PrintfGlobal.getFromBuilding_())
            } else if (type.equals(getString(R.string.flower), ignoreCase = true)) {
                title = getString(R.string.flower)
                list.clear()
                list.addAll(PrintfGlobal.getFromFlower_())
            } else if (type.equals(getString(R.string.fruit_tree), ignoreCase = true)) {
                title = getString(R.string.fruit_tree)
                list.clear()
                list.addAll(PrintfGlobal.getFromFruitTree_())
            } else if (type.equals(getString(R.string.vegetable), ignoreCase = true)) {
                title = getString(R.string.vegetable)
                list.clear()
                list.addAll(PrintfGlobal.getFromVegetable_())
            }
        }
        rl_read.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.VISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.INVISIBLE
            ll_end.visibility = View.GONE
            binding!!.rvWriteDetail.visibility = View.GONE
            frameLayout.visibility = View.VISIBLE
            val transaction = supportFragmentManager.beginTransaction()
            if (!readFragmet.isAdded) {
                transaction.add(R.id.frameLayout, readFragmet)
            } else {
                transaction.show(readFragmet)
                if (videoFragment.isAdded) {
                    transaction.hide(videoFragment)
                }
            }
            transaction.commitAllowingStateLoss()
        })
        rl_write.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.VISIBLE
            view_video.visibility = View.INVISIBLE
            ll_end.visibility = View.GONE
            binding!!.rvWriteDetail.visibility = View.VISIBLE
            frameLayout.visibility = View.GONE
        })
        rl_video.setOnClickListener(View.OnClickListener {
            view_read.visibility = View.INVISIBLE
            view_write.visibility = View.INVISIBLE
            view_video.visibility = View.VISIBLE
            ll_end.visibility = View.VISIBLE
            binding!!.rvWriteDetail.visibility = View.GONE
            frameLayout.visibility = View.VISIBLE
            val transaction = supportFragmentManager.beginTransaction()
            if (!videoFragment.isAdded) {
                transaction.add(R.id.frameLayout, videoFragment)
            } else {
                transaction.show(videoFragment)
                if (readFragmet.isAdded) {
                    transaction.hide(readFragmet)
                }
            }
            transaction.commitAllowingStateLoss()
        })
        et_search.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboardFrom(activity!!, et_search, false)
                return@OnEditorActionListener true
            }
            false
        })

        setAdapter()
    }

    private fun setAdapter() {
        val gridLayoutManager = GridLayoutManager(activity, 4)
        binding!!.rvWriteDetail.layoutManager = gridLayoutManager
        binding!!.rvWriteDetail.adapter = ReadAdapter(list, this)
    }

    override fun onClick(v: View) {
        if (v === ll_start) {
            onBackPressed()
        } else if (v === ll_end) {
            ll_start!!.isClickable = false
        } else if (v === iv_back) {
            ll_start!!.isClickable = true
            et_search!!.setText("")
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left)
        finish()
    }

    override fun OnClick(img: Int, name: String, position: Int) {
        val intent = Intent(activity, DrawingActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("title", title)
        intent.putExtra("position", position)
        startActivity(intent)
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right)
    }
}