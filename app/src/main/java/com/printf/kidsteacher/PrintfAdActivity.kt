package com.printf.kidsteacher

import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class PrintfAdActivity : BaseActivity() {

    var adCount = 1
    var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adCount = 1
        setContentView(R.layout.activity_printf_ad)

        /*var testDeviceIds = listOf("88006378043BFA148015652F08E56307")
        var configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
        MobileAds.setRequestConfiguration(configuration)*/

        MobileAds.initialize(this) {
            var isNoAdsToShow = true

            intent.extras.let {
                if (it?.getBoolean("InterAd")!!) {
                    isNoAdsToShow = false
                    interstitialAds()
                }
                if (it?.getBoolean("InterAdVideo")!!) {
                    isNoAdsToShow = false
                    interstitialVideoAds()
                }
            }

            if (isNoAdsToShow)
                navigateScreen()
        }
    }

    private fun interstitialAds() {
        InterstitialAd.load(
            this,
            getString(R.string.interstitial_text_image_ads_unit),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    navigateScreen()
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    interstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                navigateScreen()
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                navigateScreen()
                            }

                            override fun onAdShowedFullScreenContent() {
                                adCount++;
                            }
                        }

                    interstitialAd.show(this@PrintfAdActivity)
                }
            })
    }

    private fun interstitialVideoAds() {
        InterstitialAd.load(
            this,
                getString(R.string.interstitial_video_ads_unit),
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    navigateScreen()
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                navigateScreen()
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                navigateScreen()
                            }

                            override fun onAdShowedFullScreenContent() {
                                adCount++;
                            }
                        }

                    interstitialAd.show(this@PrintfAdActivity)
                }
            })
    }


    private fun navigateScreen() {
        adCount--
        if (adCount <= 1) {
            val intent = intent
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}