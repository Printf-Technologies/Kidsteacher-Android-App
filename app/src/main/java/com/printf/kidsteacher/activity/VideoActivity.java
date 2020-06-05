package com.printf.kidsteacher.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.fragment.ReadFragmet;
import com.printf.kidsteacher.fragment.VideoFragment;
import com.printf.kidsteacher.fragment.WriteFragment;


public class VideoActivity extends BaseActivity implements View.OnClickListener
{

    RecyclerView rv_video;
    AdView mAdView;
    LinearLayout ll_start;

    EditText et_search;
    ImageView iv_back;
    LinearLayout ll_search,ll_end;

    RelativeLayout rl_video,rl_read,rl_write;
    View view_video,view_read,view_write;

    VideoFragment videoFragment = new VideoFragment();
    WriteFragment writeFragment = new WriteFragment();
    ReadFragmet readFragmet = new ReadFragmet();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);
        init();
    }

    private void init()
    {
        ll_end = findViewById(R.id.ll_end);
        ll_search = findViewById(R.id.ll_search);
        iv_back = findViewById(R.id.iv_back);
        et_search = findViewById(R.id.et_search);
        ll_end.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        rv_video = findViewById(R.id.rv_video);
        ll_start = findViewById(R.id.ll_start);
        ll_start.setOnClickListener(this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        if(MainActivity.showAd.equalsIgnoreCase("1"))
        {
            mAdView.loadAd(adRequest);
        }
        else {mAdView.setVisibility(View.GONE);}

        view_write = findViewById(R.id.view_write);
        view_read = findViewById(R.id.view_read);
        view_video = findViewById(R.id.view_video);
        rl_video = findViewById(R.id.rl_video);
        rl_read = findViewById(R.id.rl_read);
        rl_write = findViewById(R.id.rl_write);

        addFragment();

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                Intent intetn = new Intent("android.intent.action.MAIN");
                intetn.putExtra("Search", et_search.getText().toString());
                activity.sendBroadcast(intetn);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboardFrom(activity, et_search,false);
                    return true;
                }
                return false;
            }
        });

        rl_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_read.setVisibility(View.VISIBLE);
                view_write.setVisibility(View.INVISIBLE);
                view_video.setVisibility(View.INVISIBLE);

                ll_end.setVisibility(View.GONE);

                FragmentTransaction transaction;
                transaction = getSupportFragmentManager().beginTransaction();
                if(!readFragmet.isAdded())
                {
                    transaction.add(R.id.frameLayout,readFragmet);
                    transaction.addToBackStack(null);
                }
                else
                {
                    transaction.show(readFragmet);
                    if(videoFragment.isAdded())
                    {
                        transaction.hide(videoFragment);
                    }
                    if(writeFragment.isAdded())
                    {
                        transaction.hide(writeFragment);
                    }
                }
                transaction.commitAllowingStateLoss();

            }
        });

        rl_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_read.setVisibility(View.INVISIBLE);
                view_write.setVisibility(View.VISIBLE);
                view_video.setVisibility(View.INVISIBLE);

                ll_end.setVisibility(View.GONE);

                FragmentTransaction transaction;
                transaction = getSupportFragmentManager().beginTransaction();
                if(!writeFragment.isAdded())
                {
                    transaction.add(R.id.frameLayout,writeFragment);
                    transaction.addToBackStack(null);
                }
                else
                {
                    transaction.show(writeFragment);
                    if(videoFragment.isAdded())
                    {
                        transaction.hide(videoFragment);
                    }
                    if(readFragmet.isAdded())
                    {
                        transaction.hide(readFragmet);
                    }
                }
                transaction.commitAllowingStateLoss();

            }
        });

        rl_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_read.setVisibility(View.INVISIBLE);
                view_write.setVisibility(View.INVISIBLE);
                view_video.setVisibility(View.VISIBLE);

                ll_end.setVisibility(View.VISIBLE);

                FragmentTransaction transaction;
                transaction = getSupportFragmentManager().beginTransaction();
                if(!videoFragment.isAdded())
                {
                    transaction.add(R.id.frameLayout,videoFragment);
                    transaction.addToBackStack(null);
                }
                else
                {
                    transaction.show(videoFragment);
                    if(writeFragment.isAdded())
                    {
                        transaction.hide(writeFragment);
                    }
                    if(readFragmet.isAdded())
                    {
                        transaction.hide(readFragmet);
                    }
                }
                transaction.commitAllowingStateLoss();

            }
        });
    }

    private void addFragment()
    {
        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,videoFragment);
        //transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view)
    {
        if(view == ll_start)
        {
            onBackPressed();
        }
        else if(view == ll_end)
        {
            ll_start.setClickable(false);
            ll_search.animate().alpha(1.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ll_search.setVisibility(View.VISIBLE);
                    ll_search.requestFocus();
                    hideKeyboardFrom(activity, et_search,true);
                }
            });
        }
        else if(view == iv_back)
        {
            ll_start.setClickable(true);
            et_search.setText("");
            ll_search.animate().alpha(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ll_search.setVisibility(View.GONE);
                    hideKeyboardFrom(activity, et_search,false);
                }
            });
        }
    }

    @Override
    public void onBackPressed()
    {
            super.onBackPressed();
            overridePendingTransition(R.anim.enter_right,R.anim.exit_left);
        finish();
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
    }

}
