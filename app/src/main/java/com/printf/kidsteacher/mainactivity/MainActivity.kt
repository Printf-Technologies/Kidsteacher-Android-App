package com.printf.kidsteacher.mainactivity

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.category.ReadActivity
import com.printf.kidsteacher.adapter.MainAdapter
import com.printf.kidsteacher.been.MainBeen
import com.printf.kidsteacher.common.*
import com.printf.kidsteacher.databinding.ActivityMainBinding
import com.printf.kidsteacher.other.Ease
import com.printf.kidsteacher.other.EasingInterpolator
import com.printf.kidsteacher.other.Helper
import com.printf.kidsteacher.other.RecyclerViewClick
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.json.JSONObject
import java.util.*

class MainActivity : BaseActivity(), RecyclerViewClick {

    var binding: ActivityMainBinding? = null
    var adRequest: AdRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        PrintfGlobal.countryCode = PreferenceSession.getUserSession(this, "country_code")
        GetAndSaveUserCountryCode()
        init()

        var testDeviceIds = listOf("88006378043BFA148015652F08E56307")
        var configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)
        MobileAds.initialize(this) { }

    }

    private fun init() {
        ll_end.visibility = View.GONE
        ll_start.visibility = View.GONE

        adRequest = AdRequest.Builder().build()
        adView.visibility = View.GONE
        setAdapter()
        Helper.remove_width = dpToPx(114)
        Helper.getDeviceHightWidth(this)
        iv_share?.setOnClickListener(View.OnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Kids Teacher made simple, easy and offline application. A personal teacher for every kid. Download the application from play store. " +
                    "https://play.google.com/store/apps/details?id=com.printf.kidsteacher"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "App link : ")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
            val animator = ObjectAnimator.ofFloat(iv_share, "translationY", 0f, 50f, 0f)
            animator.interpolator = EasingInterpolator(Ease.BOUNCE_IN_OUT)
            animator.startDelay = 0
            animator.duration = 1500
            animator.start()
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {}
                override fun onAnimationEnd(animator: Animator) {}
                override fun onAnimationCancel(animator: Animator) {}
                override fun onAnimationRepeat(animator: Animator) {}
            })
        })
        iv_rate?.setOnClickListener(View.OnClickListener {
            val appPackageName = packageName // getPackageName() from Context or Activity object
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (anfe: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
            }
            val animator = ObjectAnimator.ofFloat(iv_rate, "translationY", 0f, 50f, 0f)
            animator.interpolator = EasingInterpolator(Ease.BOUNCE_IN_OUT)
            animator.startDelay = 0
            animator.duration = 1500
            animator.start()
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {}
                override fun onAnimationEnd(animator: Animator) {}
                override fun onAnimationCancel(animator: Animator) {}
                override fun onAnimationRepeat(animator: Animator) {}
            })
        })
        callApi()
    }

    private fun callApi() {
        if (!CheckInternet.networkAvailability(this)) {
            val layoutParams1 = ll_share!!.layoutParams as RelativeLayout.LayoutParams
            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END)
            ll_share!!.layoutParams = layoutParams1
            return
        }
        val layoutParams1 = ll_share!!.layoutParams as RelativeLayout.LayoutParams
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END)
        ApiCall.GetApi(false, false, this, WebServices.ADMOB_API, object : ApiResponce {
            override fun Responce(responce: String) {
                try {
                    val jsonObject = JSONObject(responce)
                    if (jsonObject.has("Data") && !jsonObject.getString("Data").equals("", ignoreCase = true)) {
                        showAd = jsonObject.getString("Data")
                        if (showAd.equals("1", ignoreCase = true)) {
                            adView!!.visibility = View.VISIBLE
                            adView!!.loadAd(adRequest)
                            val layoutParams1 = ll_share!!.layoutParams as RelativeLayout.LayoutParams
                            layoutParams1.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                            layoutParams1.addRule(RelativeLayout.ABOVE, R.id.adView)
                            ll_share!!.layoutParams = layoutParams1
                        } else {
                            val layoutParams1 = ll_share!!.layoutParams as RelativeLayout.LayoutParams
                            layoutParams1.removeRule(RelativeLayout.ALIGN_TOP)
                            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                            ll_share!!.layoutParams = layoutParams1
                            adView!!.visibility = View.GONE
                            Helper.remove_width = dpToPx(114)
                            Helper.remove_hight = resources.getDimension(R.dimen._40sdp).toInt() //dpToPx(40);//150;
                            Helper.getDeviceHightWidth(this@MainActivity)
                        }
                    }
                } catch (e: Exception) {
                }
            }

            override fun Error(error: String) {}
        })
    }

    private fun setAdapter() {
        var list = ArrayList<MainBeen>()
        list.add(MainBeen("Video", R.drawable.video_icon))
        list.add(MainBeen("Read", R.drawable.read_icon))
        list.add(MainBeen("Write", R.drawable.write_icon))
        val gridLayoutManager = GridLayoutManager(this, 3)
        rv_main.layoutManager = gridLayoutManager
        rv_main.adapter = MainAdapter(list, this)
    }



    private fun GetAndSaveUserCountryCode() {
        if (!CheckInternet.networkAvailability(this)) {
            return
        }
        ApiCall.GetApi(false, false, this, WebServices.LOCATION_API, object : ApiResponce {
            override fun Responce(response: String) {
                try {
                    val jsonObject = JSONObject(response)
                    if (jsonObject.has("Data") && !jsonObject.getString("Data").equals("", ignoreCase = true)) {
                        PrintfGlobal.countryCode = jsonObject.getString("Data")
                        PreferenceSession.saveUserSession(this@MainActivity, "country_code", PrintfGlobal.countryCode)
                    }
                } catch (e: Exception) {
                }
            }

            override fun Error(error: String) {}
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left)
    }

    public override fun onPause() {
        if (adView != null) {
            adView!!.pause()
        }
        super.onPause()
    }

    public override fun onResume() {
        super.onResume()
        if (adView != null) {
            adView!!.resume()
        }
    }

    public override fun onDestroy() {
        if (adView != null) {
            adView!!.destroy()
        }
        super.onDestroy()
        IsBrush = false
    }

    companion object {
        @JvmField
        var IsBrush = false

        @JvmField
        var showAd = "0"
    }

    override fun OnClick(img: Int, name: String?, position: Int) {
        val intent = Intent(this, ReadActivity::class.java)
        intent.putExtra("FragmentName", name)
        startActivity(intent)
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right)
    }
}