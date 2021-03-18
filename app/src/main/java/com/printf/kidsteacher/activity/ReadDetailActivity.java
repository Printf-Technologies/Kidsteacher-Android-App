package com.printf.kidsteacher.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.androidnetworking.AndroidNetworking;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.printf.kidsteacher.BaseActivity;
import com.printf.kidsteacher.R;
import com.printf.kidsteacher.adapter.ViewPagerAdapter;
import com.printf.kidsteacher.been.ViewModel;
import com.printf.kidsteacher.common.PrintfGlobal;
import com.printf.kidsteacher.databinding.ActivityReadDetailBinding;
import com.printf.kidsteacher.fragment.VideoFragment;
import com.printf.kidsteacher.mainactivity.MainActivity;
import com.printf.kidsteacher.other.OnListItemClick;
import com.printf.kidsteacher.view.DrawViewKids;
import com.printf.kidsteacher.view.DrawingView;
import com.printf.kidsteacher.view.SwiperViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import top.defaults.colorpicker.ColorPickerPopup;

public class ReadDetailActivity extends BaseActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    ReadDetailActivity activity;
    Dialog dialog;
    ActivityReadDetailBinding binding;
    AdView mAdView;
    ArrayList<ViewModel> viewModels = new ArrayList<>();
    LinearLayout ll_start, ll_end, ll_repeat;
    TextView tv_header, tv_count;
    ImageView iv_end;
    ImageView imgBack, ivStarAutoSlide, imgPrevious, iv_clear;
    SwiperViewPager viewPager;
    boolean isEraser = false;
    RelativeLayout rl_video, rl_read, rl_write;
    View view_video, view_read, view_write;

    private boolean isAutoSouffle = false;
    private boolean isSpeakerOn = true;
    int currentPage = 0;

    private MediaPlayer mp;
    private AudioManager audioManager;
    ViewPagerAdapter viewPagerAdapter;

    Timer timer;
    final long DELAY_MS = 2200;
    final long PERIOD_MS = 2200;
    Handler handler;

    String[] reads;

    LottieAnimationView animation_view;

    RelativeLayout rl_drawingview, rl_viewpager;
    //ArrayList<WriteBeen> list = new ArrayList<>();

    ImageView smallBtn;
    ImageView mediumBtn;
    ImageView largeBtn;

    //custom drawing view
    private DrawingView drawView;
    DrawViewKids drawingView;
    //buttons
    private ImageView currPaint, drawBtn, eraseBtn, btn_brush, iv_picker;
    //sizes
    private float smallBrush, mediumBrush, largeBrush;

    int tabSelected = -1;
    FrameLayout frameLayout;
    VideoFragment videoFragment = new VideoFragment();
    FragmentTransaction transaction;

    EditText et_search;
    ImageView iv_back;
    LinearLayout ll_search, ll_search_icon;
    MaterialRippleLayout ripple_sound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_read_detail);
        activity = ReadDetailActivity.this;
        AndroidNetworking.initialize(activity);
        dialog = new Dialog(activity);
        init();
    }

    private void init() {
        MainActivity.IsBrush = false;

        ll_search_icon = findViewById(R.id.ll_search_icon);
        ll_search = findViewById(R.id.ll_search);
        iv_back = findViewById(R.id.iv_back);
        et_search = findViewById(R.id.et_search);
        ll_search_icon.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        tv_header = findViewById(R.id.tv_header);
        tv_count = findViewById(R.id.tv_count);
        mAdView = findViewById(R.id.adView);
        iv_end = findViewById(R.id.iv_end);
        ll_start = findViewById(R.id.ll_start);
        ll_end = findViewById(R.id.ll_end);
        viewPager = findViewById(R.id.Viewpager);
        imgBack = findViewById(R.id.imgBack);
        ivStarAutoSlide = findViewById(R.id.ivStarAutoSlide);
        imgPrevious = findViewById(R.id.imgPrevious);
        rl_viewpager = findViewById(R.id.rl_viewpager);
        rl_drawingview = findViewById(R.id.rl_drawingview);
        ll_repeat = findViewById(R.id.ll_repeat);

        view_write = findViewById(R.id.view_write);
        view_read = findViewById(R.id.view_read);
        view_video = findViewById(R.id.view_video);
        rl_video = findViewById(R.id.rl_video);
        rl_read = findViewById(R.id.rl_read);
        rl_write = findViewById(R.id.rl_write);

        iv_picker = findViewById(R.id.iv_picker);
        smallBtn = findViewById(R.id.small_brush);
        mediumBtn = findViewById(R.id.medium_brush);
        largeBtn = findViewById(R.id.large_brush);

        frameLayout = findViewById(R.id.frameLayout);
        ripple_sound = findViewById(R.id.ripple_sound);

        smallBtn.setOnClickListener(this);
        mediumBtn.setOnClickListener(this);
        largeBtn.setOnClickListener(this);
        iv_picker.setOnClickListener(this);
        ll_repeat.setOnClickListener(this);
        ripple_sound.setOnClickListener(this);


        imgBack.setOnClickListener(this);
        ivStarAutoSlide.setOnClickListener(this);
        imgPrevious.setOnClickListener(this);
        iv_end.setOnClickListener(this);
        ll_start.setOnClickListener(this);

        //iv_end.setImageResource(R.drawable.ic_speaker_on);
        iv_end.setImageResource(R.drawable.ic_aimg);
        iv_clear = findViewById(R.id.iv_clear);

        //get the palette and first color button
        LinearLayout paintLayout = findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));

        //sizes from dimensions
        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);

        //draw button
        drawBtn = findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);

        //set initial size

        //erase button
        eraseBtn = findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        btn_brush = findViewById(R.id.btn_brush);
        btn_brush.setOnClickListener(this);

        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        if (MainActivity.showAd.equalsIgnoreCase("1")) {
            mAdView.loadAd(adRequest);
        } else {
            mAdView.setVisibility(View.GONE);
        }

        reads = new String[]{getString(R.string.alphabets), getString(R.string.numbers), getString(R.string.shapes), getString(R.string.colors),
                getString(R.string.days), getString(R.string.months), getString(R.string.animals), getString(R.string.body_parts),
                getString(R.string.fruits), getString(R.string.transport), getString(R.string.proffesion), getString(R.string.sport),
                getString(R.string.bird), getString(R.string.building), getString(R.string.flower), getString(R.string.fruit_tree),
                getString(R.string.vegetable)};

        String title = "";
        String type = "";
        if (getIntent().getExtras() != null) {
            type = getIntent().getExtras().getString("type");

            if (type.equalsIgnoreCase(getString(R.string.alphabets))) {
                title = getString(R.string.alphabets);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromAlphabets());
               /* list.clear();
                list.addAll(PrintfGlobal.getAlphabet_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.numbers))) {
                title = getString(R.string.numbers);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromNumbers());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromNumbers_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.shapes))) {
                title = getString(R.string.shapes);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromShape());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromShape_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.colors))) {
                title = getString(R.string.colors);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromColors());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromColors_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.days))) {
                title = getString(R.string.days);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromDays());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromDays_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.months))) {
                title = getString(R.string.months);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromMonths());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromMonths_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.animals))) {
                title = getString(R.string.animals);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromAnimals());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromAnimals_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.body_parts))) {
                title = getString(R.string.body_parts);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromBodyParts());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromBodyParts_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.fruits))) {
                title = getString(R.string.fruits);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromFruits());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromFruits_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.transport))) {
                title = getString(R.string.transport);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromTransport());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromTransport_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.proffesion))) {
                title = getString(R.string.proffesion);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromProfession());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromProfession_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.sport))) {
                title = getString(R.string.sport);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromSports());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromSports_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.bird))) {
                title = getString(R.string.bird);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromBirds());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromBirds_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.building))) {
                title = getString(R.string.building);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromBuilding());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromBuilding_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.flower))) {
                title = getString(R.string.flower);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromFlower());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromFlower_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.fruit_tree))) {
                title = getString(R.string.fruit_tree);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromFruitTree());
               /* list.clear();
                list.addAll(PrintfGlobal.getFromFruitTree_());*/
            } else if (type.equalsIgnoreCase(getString(R.string.vegetable))) {
                title = getString(R.string.vegetable);
                viewModels.clear();
                viewModels.addAll(PrintfGlobal.getFromVegetable());
                /*list.clear();
                list.addAll(PrintfGlobal.getFromVegetable_());*/
            }
            tv_header.setText(title);
        }

        mp = new MediaPlayer();
        mp.setLooping(false);
        mp.setVolume(100, 100);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        setAdapter(title);
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.clearCanvas();
                drawingView.resetView();

                Bitmap icon = BitmapFactory.decodeResource(activity.getResources(), viewModels.get(currentPage).getImage());
                drawingView.setForeGroundBitmap(icon);
                drawingView.setBackGroundBitmap(icon);
            }
        });
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
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
                    hideKeyboardFrom(activity, et_search, false);
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

                rl_drawingview.setVisibility(View.GONE);
                rl_viewpager.setVisibility(View.VISIBLE);
                ll_search_icon.setVisibility(View.GONE);

                frameLayout.setVisibility(View.GONE);

                if (iv_end.getTag().equals("yes")) {
                    ll_repeat.setVisibility(View.VISIBLE);
                }

                ll_end.setVisibility(View.VISIBLE);
            }
        });

        rl_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_read.setVisibility(View.INVISIBLE);
                view_write.setVisibility(View.VISIBLE);
                view_video.setVisibility(View.INVISIBLE);

                ll_end.setVisibility(View.INVISIBLE);
                ll_repeat.setVisibility(View.INVISIBLE);
                ll_search_icon.setVisibility(View.GONE);

                frameLayout.setVisibility(View.GONE);

                stopAutoSouffle();
                rl_drawingview.setVisibility(View.VISIBLE);
                rl_viewpager.setVisibility(View.GONE);

                if (tabSelected == currentPage) {
                    return;
                }
                if (tabSelected != -1) {
                    drawingView.clearCanvas();
                    drawingView.resetView();
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                    LinearLayout paintLayout = findViewById(R.id.paint_colors);
                    currPaint = (ImageButton) paintLayout.getChildAt(0);
                    currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
                }
                tabSelected = currentPage;
                drawView = findViewById(R.id.drawing);
                drawingView = findViewById(R.id.drawingView);
                drawView.setBrushSize(mediumBrush);
                drawView.setBitmap(activity, viewModels.get(currentPage).getImage(), 0, 250);
                drawView.invalidate();


                Bitmap icon = BitmapFactory.decodeResource(activity.getResources(), viewModels.get(currentPage).getImage());
                //drawingView.clearCanvas();
                drawingView.setForeGroundBitmap(icon);
                drawingView.setBackGroundBitmap(icon);

                drawingView.setColor(Color.parseColor("#FF660000"));
                drawingView.setBrushMode(4);
                smallBtn.setBackgroundResource(R.drawable.slected_tool_bg);
                mediumBtn.setBackgroundResource(R.color.mediumBrusg);
                largeBtn.setBackgroundResource(R.color.largeBrusg);
                eraseBtn.setBackgroundResource(R.color.app_color);
                btn_brush.setBackgroundResource(R.color.colorAccent);

            }
        });

        rl_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_read.setVisibility(View.INVISIBLE);
                view_write.setVisibility(View.INVISIBLE);
                view_video.setVisibility(View.VISIBLE);

                ll_end.setVisibility(View.INVISIBLE);
                ll_repeat.setVisibility(View.INVISIBLE);
                ll_search_icon.setVisibility(View.VISIBLE);

                frameLayout.setVisibility(View.VISIBLE);

                if (!videoFragment.isAdded()) {
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, videoFragment);
                    transaction.addToBackStack(null);
                    transaction.commitAllowingStateLoss();
                }

            }
        });
    }

    private void setAdapter(String title) {
        viewPagerAdapter = new ViewPagerAdapter(this, viewModels, title, new OnListItemClick() {
            @Override
            public void playThisMusic(Integer music) {
                if (music != -1) {
                    stopAutoSouffle();
                    playMusic(music);
                }
            }

            @Override
            public void playThisMusic(byte[] music) {

            }
        });

        setProgress();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);

        currentPage = 0;
        if (viewModels.get(currentPage).getMusic() != -1) {
            playMusic(viewModels.get(currentPage).getMusic());
        }

        viewPager.setmSwiperListener(new SwiperViewPager.SwiperListener() {
            @Override
            public boolean onLeftSwipe() {
                stopAutoSouffle();
                return false;
            }

            @Override
            public boolean onRightSwipe() {
                if (currentPage == viewModels.size() - 1) {
                    if (dialog != null && !dialog.isShowing())
                        openDialog();
                }
                stopAutoSouffle();
                return false;
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                if (viewModels.get(currentPage).getMusic() != -1) {
                    playMusic(viewModels.get(currentPage).getMusic());
                    setProgress();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setProgress() {
        tv_count.setText((currentPage + 1) + " / " + viewModels.size());
    }

    private void playMusic(Integer music) {
        if (!isSpeakerOn)
            return;
        if (viewPager == null)
            return;
        if (viewModels == null || viewModels.size() == 0)
            return;
        if (mp == null) {
            mp = new MediaPlayer();
        }
        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), music);
        mp.start(); // starting mediaplayer

        mp.setOnCompletionListener(this);
    }

    private void stopAutoSouffle() {
        ivStarAutoSlide.setImageResource(R.drawable.ic_play);
        isAutoSouffle = false;
        if (timer != null) {
            timer.cancel();
        }
    }

    //user clicked paint
    public void paintClicked(View view) {

        if (isEraser) {
            Toast.makeText(activity, "Eraser is selected. You can not select color.", Toast.LENGTH_LONG).show();
            return;
        }
        //use chosen color

        //set erase false
        drawView.setErase(false);
        drawView.setPaintAlpha(100);
        drawView.setBrushSize(drawView.getLastBrushSize());

        if (view != currPaint) {
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            //update ui
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint = (ImageButton) view;

            drawingView.setColor(Color.parseColor(color));
        }
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI);
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == ll_start) {
            onBackPressed();
        } else if (v == iv_end || v == ll_end || v == ripple_sound) {
            isSpeakerOn = !isSpeakerOn;
            if (isSpeakerOn) {
                iv_end.setTag("yes");
                //iv_end.setImageResource(R.drawable.ic_speaker_on);
                iv_end.setImageResource(R.drawable.ic_aimg);
                ll_repeat.setVisibility(View.VISIBLE);
            } else {
                //iv_end.setImageResource(R.drawable.ic_speaker_off);
                iv_end.setTag("no");
                iv_end.setImageResource(R.drawable.ic_bimg);
                ll_repeat.setVisibility(View.GONE);
                stopMusic();
            }
            if (isAutoSouffle && isSpeakerOn == false) {
                callMuteInAutoSuffle();
            } else {
                if (timer != null) {
                    timer.cancel();
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            nextMusic();
                        }
                    };
                    handler = new Handler();
                    handler.postDelayed(runnable, 300);
                }
            }
        } else if (v == ll_repeat) {
            if (viewModels.get(currentPage).getMusic() != -1) {
                stopAutoSouffle();
                playMusic(viewModels.get(currentPage).getMusic());
            }
        } else if (v == imgBack) {
            if (currentPage > 0) {
                currentPage--;
            }
            viewPager.setCurrentItem(currentPage);
            stopAutoSouffle();
        } else if (v == imgPrevious) {
            if (currentPage == viewModels.size() - 1) {
                openDialog();
                return;
            }
            if (currentPage < viewModels.size() - 1)
                currentPage++;
            viewPager.setCurrentItem(currentPage);
            stopAutoSouffle();
        } else if (v == ivStarAutoSlide) {
            if (isAutoSouffle)
                stopAutoSouffle();
            else {
                if (currentPage == viewModels.size() - 1) {
                    currentPage = -1;
                }
                autoSouffle();
            }
        } else if (v.getId() == R.id.small_brush) {
            brushType(4);
            isEraser = false;
            MainActivity.IsBrush = false;
            drawView.setErase(false);
            drawView.setBrushSize(smallBrush);
            drawView.setLastBrushSize(smallBrush);

            smallBtn.setBackgroundResource(R.drawable.slected_tool_bg);
            mediumBtn.setBackgroundResource(R.color.mediumBrusg);
            largeBtn.setBackgroundResource(R.color.largeBrusg);
            eraseBtn.setBackgroundResource(R.color.app_color);
            btn_brush.setBackgroundResource(R.color.colorAccent);
        } else if (v.getId() == R.id.medium_brush) {
            brushType(6);
            isEraser = false;
            MainActivity.IsBrush = false;
            drawView.setErase(false);
            drawView.setBrushSize(mediumBrush);
            drawView.setLastBrushSize(mediumBrush);

            smallBtn.setBackgroundResource(R.color.smallBrusg);
            mediumBtn.setBackgroundResource(R.drawable.slected_tool_bg);
            largeBtn.setBackgroundResource(R.color.largeBrusg);
            eraseBtn.setBackgroundResource(R.color.app_color);
            btn_brush.setBackgroundResource(R.color.colorAccent);
        } else if (v.getId() == R.id.large_brush) {
            brushType(5);
            isEraser = false;
            MainActivity.IsBrush = false;
            drawView.setErase(false);
            drawView.setBrushSize(largeBrush);
            drawView.setLastBrushSize(largeBrush);

            smallBtn.setBackgroundResource(R.color.smallBrusg);
            mediumBtn.setBackgroundResource(R.color.mediumBrusg);
            largeBtn.setBackgroundResource(R.drawable.slected_tool_bg);
            eraseBtn.setBackgroundResource(R.color.app_color);
            btn_brush.setBackgroundResource(R.color.colorAccent);
        } else if (v.getId() == R.id.erase_btn) {

            brushType(1);
            isEraser = true;
            MainActivity.IsBrush = false;
            drawView.setErase(true);
            drawView.setBrushSize(mediumBrush);

            smallBtn.setBackgroundResource(R.color.smallBrusg);
            mediumBtn.setBackgroundResource(R.color.mediumBrusg);
            largeBtn.setBackgroundResource(R.color.largeBrusg);
            eraseBtn.setBackgroundResource(R.drawable.slected_eraser_bg);
            btn_brush.setBackgroundResource(R.color.colorAccent);
            return;
        } else if (v == btn_brush) {
            brushType(7);
            isEraser = false;
            MainActivity.IsBrush = true;

            smallBtn.setBackgroundResource(R.color.smallBrusg);
            mediumBtn.setBackgroundResource(R.color.mediumBrusg);
            largeBtn.setBackgroundResource(R.color.largeBrusg);
            eraseBtn.setBackgroundResource(R.color.app_color);
            btn_brush.setBackgroundResource(R.drawable.slected_fill_bg);
        } else if (v == iv_picker) {
            new ColorPickerPopup.Builder(this)
                    .initialColor(Color.RED) // Set initial color
                    .enableBrightness(false) // Enable brightness slider or not
                    .enableAlpha(false) // Enable alpha slider or not
                    .okTitle(getString(R.string.done))
                    .cancelTitle("Cancel")
                    .showIndicator(false)
                    .showValue(false)
                    .build()
                    .show(new ColorPickerPopup.ColorPickerObserver() {
                        @Override
                        public void onColorPicked(int color) {
                            Log.e("TAG", "color = " + color);
                            isEraser = false;
                            drawView.setErase(false);
                            drawView.setPaintAlpha(100);
                            drawView.setBrushSize(drawView.getLastBrushSize());

                            String strColor = String.format("#%06X", 0xFFFFFF & color);
                            Log.e("TAG", "strColor = " + strColor);
                            drawView.setColor(strColor);
                            drawingView.setColor(color);

                            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
                        }
                    });
        } else if (v == ll_search_icon) {
            ll_start.setClickable(false);
            ll_search.animate().alpha(1.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ll_search.setVisibility(View.VISIBLE);
                    ll_search.requestFocus();
                    hideKeyboardFrom(activity, et_search, true);
                }
            });
        } else if (v == iv_back) {
            ll_start.setClickable(true);
            et_search.setText("");
            ll_search.animate().alpha(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    ll_search.setVisibility(View.GONE);
                    hideKeyboardFrom(activity, et_search, false);
                }
            });
        }
    }

    void brushType(int type) {
        drawingView.setBrushMode(type);
    }

    private void autoSouffle() {
        ivStarAutoSlide.setImageResource(R.drawable.ic_musicstop);
        isAutoSouffle = true;
        nextMusic();

        if (!isSpeakerOn) {
            handler = new Handler();

            final Runnable Update = new Runnable() {
                public void run() {
                    if (!isSpeakerOn)
                        nextMusic();
                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                }
            }, DELAY_MS, PERIOD_MS);
        }
    }

    //during auto suffle mute
    private void callMuteInAutoSuffle() {
        handler = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {
                if (!isSpeakerOn)
                    nextMusic();
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if (isSpeakerOn && isAutoSouffle) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isSpeakerOn && isAutoSouffle) {
                        nextMusic();
                    }
                }
            }, 800);
        }
    }

    private void nextMusic() {
        if (currentPage == viewModels.size() - 1) {
            stopAutoSouffle();
            openDialog();
        } else {
            currentPage++;
        }
        viewPager.setCurrentItem(currentPage, true);
    }


    private void openDialog() {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_restart);
        //dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(lp);

        final ImageView iv_close, iv_startAgain, iv_goNext;
        iv_goNext = dialog.findViewById(R.id.iv_goNext);
        iv_startAgain = dialog.findViewById(R.id.iv_startAgain);
        iv_close = dialog.findViewById(R.id.iv_close);
        animation_view = dialog.findViewById(R.id.animation_view);

        final Animation animation = AnimationUtils.loadAnimation(activity, R.anim.bounce);
        //tv_title.setText(getEmoticon(0x1F476)+getString(R.string.app_name)+getEmoticon(0x1F60E));
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_close.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        dialog.dismiss();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        iv_startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_startAgain.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        dialog.dismiss();
                        currentPage = -1;
                        autoSouffle();
                        animation_view.cancelAnimation();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        iv_goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_goNext.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        dialog.dismiss();
                        String next = "";
                        for (int i = 0; i < reads.length; i++) {
                            if (reads[i].equalsIgnoreCase(tv_header.getText().toString())) {
                                if (i == reads.length - 1) {
                                    next = reads[0];
                                } else {
                                    next = reads[i + 1];
                                }
                                break;
                            }
                        }
                        animation_view.cancelAnimation();
                        
                        Intent intent = new Intent(activity, ReadDetailActivity.class);
                        intent.putExtra("type", next);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
        });

        animation_view.playAnimation();
        dialog.show();
    }

    private void stopMusic() {
        mp.stop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopMusic();
        if (timer != null) {
            timer.cancel();
        }
        MainActivity.IsBrush = false;
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
        finish();
    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        if (mp != null) {
            mp.pause();
        }
        stopAutoSouffle();
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
        if (mp != null) {
            mp.release();
        }
        super.onDestroy();
        MainActivity.IsBrush = false;
    }
}
