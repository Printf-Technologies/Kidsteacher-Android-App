package com.printf.kidsteacher.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.leinardi.android.speeddial.SpeedDialActionItem;
import com.leinardi.android.speeddial.SpeedDialView;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.adapter.ReadAdapter;
import com.printf.kidsteacher.been.ReadBeen;
import com.printf.kidsteacher.databinding.ActivityWriteBinding;
import com.printf.kidsteacher.fragment.ReadFragmet;
import com.printf.kidsteacher.fragment.VideoFragment;
import com.printf.kidsteacher.fragment.WriteFragment;
import com.printf.kidsteacher.other.RecylerViewClick;

import java.util.ArrayList;

public class WriteActivity extends BaseActivity implements View.OnClickListener
{
    public static WriteActivity activity;
    ActivityWriteBinding binding;
    LinearLayout ll_start;
    RecyclerView rv_write;
    AdView mAdView;
    SpeedDialView mSpeedDialView;
    ArrayList<ReadBeen> list;
    ReadAdapter readAdapter;

    RelativeLayout rl_video,rl_read,rl_write;
    View view_video,view_read,view_write;

    EditText et_search;
    ImageView iv_back;
    LinearLayout ll_search,ll_end;

    FrameLayout frameLayout;
    VideoFragment videoFragment = new VideoFragment();
    WriteFragment writeFragment = new WriteFragment();
    ReadFragmet readFragmet = new ReadFragmet();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_write);
        activity = WriteActivity.this;
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

        ll_start = findViewById(R.id.ll_start);
        rv_write = findViewById(R.id.rv_write);

        ll_start.setOnClickListener(this);


        view_write = findViewById(R.id.view_write);
        view_read = findViewById(R.id.view_read);
        view_video = findViewById(R.id.view_video);
        rl_video = findViewById(R.id.rl_video);
        rl_read = findViewById(R.id.rl_read);
        rl_write = findViewById(R.id.rl_write);


        mSpeedDialView = findViewById(R.id.speedDial);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        if(MainActivity.showAd.equalsIgnoreCase("1"))
        {
            mAdView.loadAd(adRequest);
        }
        else {mAdView.setVisibility(View.GONE);}

        //setAdapter();
        aadFragment();

        mSpeedDialView.inflate(R.menu.menu_base_use_case);


        mSpeedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch (actionItem.getId()) {
                    case R.id.action_video:
                        mSpeedDialView.close(); // To close the Speed Dial with animation
                        Intent intent = new Intent(activity,VideoActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter_left,R.anim.exit_right);
                        finish();
                        return true; // false will close it without animation
                    case R.id.action_read:
                        mSpeedDialView.close();
                        Intent intent_ = new Intent(activity,ReadActivity.class);
                        startActivity(intent_);
                        overridePendingTransition(R.anim.enter_left,R.anim.exit_right);
                        finish();
                        break;
                    case R.id.action_write:
                        mSpeedDialView.close();
                        return true; // closes without animation (same as mSpeedDialView.close(false); return false;)
                    default:
                        break;
                }
                return true; // To keep the Speed Dial open
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
                    //transaction.addToBackStack(null);
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
                    //transaction.addToBackStack(null);
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
                    //transaction.addToBackStack(null);
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

    }

    private void aadFragment()
    {
        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout,writeFragment);
        //transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    private void setAdapter()
    {
        list = new ArrayList<>();
        list.add(new ReadBeen(getString(R.string.alphabets),R.drawable.tile_alphabets));
        list.add(new ReadBeen(getString(R.string.numbers),R.drawable.tile_number));
        list.add(new ReadBeen(getString(R.string.shapes),R.drawable.tile_shape));
        //list.add(new ReadBeen(getString(R.string.colors),R.drawable.tile_color));
        list.add(new ReadBeen(getString(R.string.days),R.drawable.tile_day));
        list.add(new ReadBeen(getString(R.string.months),R.drawable.tile_month));
        list.add(new ReadBeen(getString(R.string.animals),R.drawable.tile_animals));
        list.add(new ReadBeen(getString(R.string.body_parts),R.drawable.tile_bodyparts));
        list.add(new ReadBeen(getString(R.string.fruits),R.drawable.tile_fruits));
        list.add(new ReadBeen(getString(R.string.transport),R.drawable.tile_transport));
        list.add(new ReadBeen(getString(R.string.proffesion),R.drawable.tile_profession));
        list.add(new ReadBeen(getString(R.string.sport),R.drawable.tile_sport));
        list.add(new ReadBeen(getString(R.string.bird),R.drawable.tile_bird));
        list.add(new ReadBeen(getString(R.string.building),R.drawable.tile_bulding));
        list.add(new ReadBeen(getString(R.string.flower),R.drawable.tile_flowers));
        list.add(new ReadBeen(getString(R.string.fruit_tree),R.drawable.tile_fruits_tree));
        list.add(new ReadBeen(getString(R.string.vegetable),R.drawable.tile_vegetable));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,4);
        rv_write.setLayoutManager(gridLayoutManager);
        readAdapter = new ReadAdapter(activity, list, new RecylerViewClick() {
            @Override
            public void OnClick(String name) {
                Intent intent = new Intent(activity,WriteDetailActivity.class);
                if (name.equalsIgnoreCase(getString(R.string.alphabets))) {
                    intent.putExtra("type",getString(R.string.alphabets));
                } else if (name.equalsIgnoreCase(getString(R.string.numbers))) {
                    intent.putExtra("type",getString(R.string.numbers));
                } else if (name.equalsIgnoreCase(getString(R.string.shapes))) {
                    intent.putExtra("type",getString(R.string.shapes));
                } else if (name.equalsIgnoreCase(getString(R.string.colors))) {
                    intent.putExtra("type",getString(R.string.colors));
                } else if (name.equalsIgnoreCase(getString(R.string.days))) {
                    intent.putExtra("type",getString(R.string.days));
                } else if (name.equalsIgnoreCase(getString(R.string.months))) {
                    intent.putExtra("type",getString(R.string.months));
                } else if (name.equalsIgnoreCase(getString(R.string.animals))) {
                    intent.putExtra("type",getString(R.string.animals));
                } else if (name.equalsIgnoreCase(getString(R.string.body_parts))) {
                    intent.putExtra("type",getString(R.string.body_parts));
                } else if (name.equalsIgnoreCase(getString(R.string.fruits))) {
                    intent.putExtra("type",getString(R.string.fruits));
                } else if (name.equalsIgnoreCase(getString(R.string.transport))) {
                    intent.putExtra("type",getString(R.string.transport));
                } else if (name.equalsIgnoreCase(getString(R.string.proffesion))) {
                    intent.putExtra("type",getString(R.string.proffesion));
                } else if (name.equalsIgnoreCase(getString(R.string.sport))) {
                    intent.putExtra("type",getString(R.string.sport));
                } else if (name.equalsIgnoreCase(getString(R.string.bird))) {
                    intent.putExtra("type", getString(R.string.bird));
                } else if (name.equalsIgnoreCase(getString(R.string.building))) {
                    intent.putExtra("type", getString(R.string.building));
                } else if (name.equalsIgnoreCase(getString(R.string.flower))) {
                    intent.putExtra("type", getString(R.string.flower));
                } else if (name.equalsIgnoreCase(getString(R.string.fruit_tree))) {
                    intent.putExtra("type", getString(R.string.fruit_tree));
                } else if (name.equalsIgnoreCase(getString(R.string.vegetable))) {
                    intent.putExtra("type", getString(R.string.vegetable));
                }
                startActivity(intent);
                overridePendingTransition(R.anim.enter_left,R.anim.exit_right);
            }
        });
        rv_write.setAdapter(readAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == ll_start)
        {
            onBackPressed();
        }
        else if(v == ll_end)
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
        else if(v == iv_back)
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
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_right,R.anim.exit_left);
        finish();
    }
}
