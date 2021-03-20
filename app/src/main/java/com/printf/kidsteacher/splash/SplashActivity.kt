package com.printf.kidsteacher.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ProcessLifecycleOwner
import com.printf.kidsteacher.BaseActivity
import com.printf.kidsteacher.R
import com.printf.kidsteacher.common.PreferencesManager
import com.printf.kidsteacher.mainactivity.MainActivity


class SplashActivity : BaseActivity(), LifecycleObserver {

    private lateinit var splashViewModel: SplashViewModel

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 1000
    private val mRunnable: Runnable = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashViewModel = SplashViewModel(application)

        splashViewModel.getAppAdSettings()
        setupObservers()

    }


    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

    private fun setupObservers() {
        splashViewModel.dataObservable?.observe(this, Observer {
            if (it.status!!) {

                var preferencesManager = PreferencesManager.instance(this)

                preferencesManager.setGEOLocation(it.data?.geoLocation.toString())
                preferencesManager.setIsShowBannerAd(it.data?.showBannerAd!! == 1)

                for (ad in it.data?.adSettings!!) {
                    if (ad.screenName.equals("HomeScreen")) {
                        if (ad.action.equals("OnOpen")) {
                            preferencesManager.setIsShowVideoAdHomeScreenOnOpen(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdHomeScreenOnOpen(ad.interAd!!)
                        } else if (ad.action.equals("OnClose")) {
                            preferencesManager.setIsShowVideoAdHomeScreenOnClose(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdHomeScreenOnClose(ad.interAd!!)
                        }
                    } else if (ad.screenName.equals("VideoListScreen")) {
                        if (ad.action.equals("OnOpen")) {
                            preferencesManager.setIsShowVideoAdCategoryScreenOnOpen(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdCategoryScreenOnOpen(ad.interAd!!)
                        } else if (ad.action.equals("OnClose")) {
                            preferencesManager.setIsShowVideoAdCategoryScreenOnClose(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdCategoryScreenOnClose(ad.interAd!!)
                        }
                    } else if (ad.screenName.equals("VideoScreen")) {
                        if (ad.action.equals("OnOpen")) {
                            preferencesManager.setIsShowVideoAdVideoScreenOnOpen(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdVideoScreenOnOpen(ad.interAd!!)
                        } else if (ad.action.equals("OnClose")) {
                            preferencesManager.setIsShowVideoAdVideoScreenOnClose(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdVideoScreenOnClose(ad.interAd!!)
                        }
                    } else if (ad.screenName.equals("WriteInnerListScreen")) {
                        if (ad.action.equals("OnOpen")) {
                            preferencesManager.setIsShowVideoAdSubCategoryScreenOnOpen(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdSubCategoryScreenOnOpen(ad.interAd!!)
                        } else if (ad.action.equals("OnClose")) {
                            preferencesManager.setIsShowVideoAdSubCategoryScreenOnClose(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdSubCategoryScreenOnClose(ad.interAd!!)
                        }
                    } else if (ad.screenName.equals("WriteScreen")) {
                        if (ad.action.equals("OnOpen")) {
                            preferencesManager.setIsShowVideoAdDetailScreenOnOpen(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdDetailScreenOnOpen(ad.interAd!!)
                        } else if (ad.action.equals("OnClose")) {
                            preferencesManager.setIsShowVideoAdDetailScreenOnClose(ad.videoAd!!)
                            preferencesManager.setIsShowInterAdDetailScreenOnClose(ad.interAd!!)
                        }
                    }
                }
            }
            mDelayHandler = Handler()
            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        })

        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

}