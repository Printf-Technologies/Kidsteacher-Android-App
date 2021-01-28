package com.printf.kidsteacher.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.adapter.MainAdpter;
import com.printf.kidsteacher.been.MainBeen;
import com.printf.kidsteacher.common.ApiCall;
import com.printf.kidsteacher.common.ApiResponce;
import com.printf.kidsteacher.common.CheckInternet;
import com.printf.kidsteacher.common.PreferenceSession;
import com.printf.kidsteacher.common.PrintfGlobal;
import com.printf.kidsteacher.common.WebServices;
import com.printf.kidsteacher.databinding.ActivityMainBinding;
import com.printf.kidsteacher.other.Ease;
import com.printf.kidsteacher.other.EasingInterpolator;
import com.printf.kidsteacher.other.Helper;
import com.printf.kidsteacher.other.RecylerViewClick;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements RecylerViewClick {
    public MainActivity activity;
    ActivityMainBinding binding;
    RecyclerView rv_main;
    ArrayList<MainBeen> list;
    MainAdpter mainAdpter;
    AdView mAdView;
    LinearLayout ll_start, ll_end, ll_share;
    TextView tv_header;

    ImageView iv_share, iv_rate;
    AdRequest adRequest;

    public static boolean IsBrush = false;
    public static String showAd = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fabric.with(this, new Crashlytics());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        PrintfGlobal.countryCode = PreferenceSession.getUserSession(activity, "country_code");
        GetAndSaveUserCountryCode();
        init();

        /*List<String> testDeviceIds = Arrays.asList("88006378043BFA148015652F08E56307");
        RequestConfiguration configuration = new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);*/

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

    }

    private void init() {
        rv_main = findViewById(R.id.rv_main);
        tv_header = findViewById(R.id.tv_header);
        ll_start = findViewById(R.id.ll_start);
        ll_end = findViewById(R.id.ll_end);
        iv_share = findViewById(R.id.iv_share);
        iv_rate = findViewById(R.id.iv_rate);
        ll_share = findViewById(R.id.ll_share);

        ll_end.setVisibility(View.GONE);
        ll_start.setVisibility(View.GONE);
        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.setVisibility(View.GONE);

        setAdapter();

        Helper.remove_width = dpToPx(114);
        Helper.getDeviceHightWidth(activity);

        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Kids Teacher made simple, easy and offline application. A personal teacher for every kid. Download the application from play store. " +
                        "https://play.google.com/store/apps/details?id=com.printf.kidsteacher";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "App link : ");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

                ObjectAnimator animator = ObjectAnimator.ofFloat(iv_share, "translationY", 0, 50, 0);
                animator.setInterpolator(new EasingInterpolator(Ease.BOUNCE_IN_OUT));
                animator.setStartDelay(0);
                animator.setDuration(1500);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
            }
        });

        iv_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }

                ObjectAnimator animator = ObjectAnimator.ofFloat(iv_rate, "translationY", 0, 50, 0);
                animator.setInterpolator(new EasingInterpolator(Ease.BOUNCE_IN_OUT));
                animator.setStartDelay(0);
                animator.setDuration(1500);
                animator.start();
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
            }
        });

        callApi();
    }

    private void callApi() {
        if (!CheckInternet.networkAvailability(activity)) {
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) ll_share.getLayoutParams();
            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END);
            ll_share.setLayoutParams(layoutParams1);
            return;
        }

        final RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) ll_share.getLayoutParams();
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END);

        ApiCall.GetApi(false, false, activity, WebServices.ADMOB_API, new ApiResponce() {
            @Override
            public void Responce(String responce) {
                try {
                    JSONObject jsonObject = new JSONObject(responce);
                    if (jsonObject.has("Data") && !jsonObject.getString("Data").equalsIgnoreCase("")) {
                        showAd = jsonObject.getString("Data");
                        if (showAd.equalsIgnoreCase("1")) {
                           mAdView.setVisibility(View.VISIBLE);
                            mAdView.loadAd(adRequest);

                            final RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) ll_share.getLayoutParams();
                            layoutParams1.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                            layoutParams1.addRule(RelativeLayout.ABOVE, R.id.adView);
                            ll_share.setLayoutParams(layoutParams1);
                        } else {
                            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) ll_share.getLayoutParams();
                            layoutParams1.removeRule(RelativeLayout.ALIGN_TOP);
                            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                            ll_share.setLayoutParams(layoutParams1);

                           mAdView.setVisibility(View.GONE);
                            Helper.remove_width = dpToPx(114);
                            Helper.remove_hight = (int) getResources().getDimension(R.dimen._40sdp);//dpToPx(40);//150;
                            Helper.getDeviceHightWidth(activity);
                        }
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void Error(String error) {

            }
        });
    }

    private void setAdapter() {
        list = new ArrayList<>();

        list.add(new MainBeen("Video", R.drawable.video_icon));
        list.add(new MainBeen("Read", R.drawable.read_icon));
        list.add(new MainBeen("Write", R.drawable.write_icon));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        rv_main.setLayoutManager(gridLayoutManager);
        mainAdpter = new MainAdpter(activity, list, this);
        rv_main.setAdapter(mainAdpter);
    }

    @Override
    public void OnClick(String name) {
        if (name.equalsIgnoreCase("Read")) {
            Intent intent = new Intent(activity, ReadActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
        } else if (name.equalsIgnoreCase("write")) {
            Intent intent = new Intent(activity, WriteActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
        } else if (name.equalsIgnoreCase("video")) {
            Intent intent = new Intent(activity, VideoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
        }
    }

    private void GetAndSaveUserCountryCode() {
        if (!CheckInternet.networkAvailability(activity)) {
            return;
        }
        ApiCall.GetApi(false, false, activity, WebServices.LOCATION_API, new ApiResponce() {
            @Override
            public void Responce(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.has("Data") && !jsonObject.getString("Data").equalsIgnoreCase("")) {
                        PrintfGlobal.countryCode = jsonObject.getString("Data");
                        PreferenceSession.saveUserSession(activity, "country_code", PrintfGlobal.countryCode);
                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void Error(String error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
        MainActivity.IsBrush = false;
    }
}
