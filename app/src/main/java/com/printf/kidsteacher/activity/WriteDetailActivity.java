package com.printf.kidsteacher.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
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
import com.printf.kidsteacher.adapter.WriteAdapter;
import com.printf.kidsteacher.been.WriteBeen;
import com.printf.kidsteacher.databinding.ActivityWriteDetailBinding;
import com.printf.kidsteacher.fragment.ReadFragmet;
import com.printf.kidsteacher.fragment.VideoFragment;
import com.printf.kidsteacher.other.RecyclerImage;

import java.util.ArrayList;

public class WriteDetailActivity extends BaseActivity implements View.OnClickListener {
    ActivityWriteDetailBinding binding;
    AdView mAdView;
    SpeedDialView mSpeedDialView;
    LinearLayout ll_start;
    ArrayList<WriteBeen> list = new ArrayList<>();
    WriteAdapter writeAdapter;

    RelativeLayout rl_video, rl_read, rl_write;
    View view_video, view_read, view_write;

    EditText et_search;
    ImageView iv_back;
    LinearLayout ll_search, ll_end;

    FrameLayout frameLayout;
    VideoFragment videoFragment = new VideoFragment();
    ReadFragmet readFragmet = new ReadFragmet();

    String type = "", title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_detail);
        init();
    }

    private void init() {
        ll_end = findViewById(R.id.ll_end);
        ll_search = findViewById(R.id.ll_search);
        iv_back = findViewById(R.id.iv_back);
        et_search = findViewById(R.id.et_search);
        ll_end.setOnClickListener(this);
        iv_back.setOnClickListener(this);

        frameLayout = findViewById(R.id.frameLayout);
        ll_start = findViewById(R.id.ll_start);

        view_write = findViewById(R.id.view_write);
        view_read = findViewById(R.id.view_read);
        view_video = findViewById(R.id.view_video);
        rl_video = findViewById(R.id.rl_video);
        rl_read = findViewById(R.id.rl_read);
        rl_write = findViewById(R.id.rl_write);

        ll_start.setOnClickListener(this);

        mSpeedDialView = findViewById(R.id.speedDial);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        if (MainActivity.showAd.equalsIgnoreCase("1")) {
            mAdView.loadAd(adRequest);
        } else {
            mAdView.setVisibility(View.GONE);
        }

        mSpeedDialView.inflate(R.menu.menu_base_use_case);

        mSpeedDialView.setOnActionSelectedListener(new SpeedDialView.OnActionSelectedListener() {
            @Override
            public boolean onActionSelected(SpeedDialActionItem actionItem) {
                switch (actionItem.getId()) {
                    case R.id.action_video:
                        mSpeedDialView.close(); // To close the Speed Dial with animation
                        Intent intent = new Intent(activity, VideoActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
                        finish();
                        WriteActivity.activity.finish();
                        return true; // false will close it without animation
                    case R.id.action_read:
                        mSpeedDialView.close();
                        Intent intent_ = new Intent(activity, ReadActivity.class);
                        startActivity(intent_);
                        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
                        finish();
                        WriteActivity.activity.finish();
                        break;
                    case R.id.action_write:
                        mSpeedDialView.close();
                        onBackPressed();
                        return true; // closes without animation (same as mSpeedDialView.close(false); return false;)
                    default:
                        break;
                }
                return true; // To keep the Speed Dial open
            }
        });

        type = "";
        if (getIntent().getExtras() != null) {
            type = getIntent().getExtras().getString("type");

            title = "";
            if (type.equalsIgnoreCase(getString(R.string.alphabets))) {
                title = getString(R.string.alphabets);
                list.clear();
                list.addAll(getAlphabet());
            } else if (type.equalsIgnoreCase(getString(R.string.numbers))) {
                title = getString(R.string.numbers);
                list.clear();
                list.addAll(getFromNumbers());
            } else if (type.equalsIgnoreCase(getString(R.string.shapes))) {
                title = getString(R.string.shapes);
                list.addAll(getFromShape());
            } else if (type.equalsIgnoreCase(getString(R.string.colors))) {
                title = getString(R.string.colors);
                list.clear();
                list.addAll(getFromColors());
            } else if (type.equalsIgnoreCase(getString(R.string.days))) {
                title = getString(R.string.days);
                list.clear();
                list.addAll(getFromDays());
            } else if (type.equalsIgnoreCase(getString(R.string.months))) {
                title = getString(R.string.months);
                list.clear();
                list.addAll(getFromMonths());
            } else if (type.equalsIgnoreCase(getString(R.string.animals))) {
                title = getString(R.string.animals);
                list.clear();
                list.addAll(getFromAnimals());
            } else if (type.equalsIgnoreCase(getString(R.string.body_parts))) {
                title = getString(R.string.body_parts);
                list.clear();
                list.addAll(getFromBodyParts());
            } else if (type.equalsIgnoreCase(getString(R.string.fruits))) {
                title = getString(R.string.fruits);
                list.clear();
                list.addAll(getFromFruits());
            } else if (type.equalsIgnoreCase(getString(R.string.transport))) {
                title = getString(R.string.transport);
                list.clear();
                list.addAll(getFromTransport());
            } else if (type.equalsIgnoreCase(getString(R.string.proffesion))) {
                title = getString(R.string.proffesion);
                list.clear();
                list.addAll(getFromProfession());
            } else if (type.equalsIgnoreCase(getString(R.string.sport))) {
                title = getString(R.string.sport);
                list.clear();
                list.addAll(getFromSports());
            } else if (type.equalsIgnoreCase(getString(R.string.bird))) {
                title = getString(R.string.bird);
                list.clear();
                list.addAll(getFromBirds());
            } else if (type.equalsIgnoreCase(getString(R.string.building))) {
                title = getString(R.string.building);
                list.clear();
                list.addAll(getFromBuilding());
            } else if (type.equalsIgnoreCase(getString(R.string.flower))) {
                title = getString(R.string.flower);
                list.clear();
                list.addAll(getFromFlower());
            } else if (type.equalsIgnoreCase(getString(R.string.fruit_tree))) {
                title = getString(R.string.fruit_tree);
                list.clear();
                list.addAll(getFromFruitTree());
            } else if (type.equalsIgnoreCase(getString(R.string.vegetable))) {
                title = getString(R.string.vegetable);
                list.clear();
                list.addAll(getFromVegetable());
            }
            //tv_header.setText(title);
        }

        rl_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view_read.setVisibility(View.VISIBLE);
                view_write.setVisibility(View.INVISIBLE);
                view_video.setVisibility(View.INVISIBLE);

                ll_end.setVisibility(View.GONE);

                binding.rvWriteDetail.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);

                FragmentTransaction transaction;
                transaction = getSupportFragmentManager().beginTransaction();
                if (!readFragmet.isAdded()) {
                    transaction.add(R.id.frameLayout, readFragmet);
                    //transaction.addToBackStack(null);
                } else {
                    transaction.show(readFragmet);
                    if (videoFragment.isAdded()) {
                        transaction.hide(videoFragment);
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

                binding.rvWriteDetail.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
            }
        });

        rl_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_read.setVisibility(View.INVISIBLE);
                view_write.setVisibility(View.INVISIBLE);
                view_video.setVisibility(View.VISIBLE);

                ll_end.setVisibility(View.VISIBLE);

                binding.rvWriteDetail.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);

                FragmentTransaction transaction;
                transaction = getSupportFragmentManager().beginTransaction();
                if (!videoFragment.isAdded()) {
                    transaction.add(R.id.frameLayout, videoFragment);
                    //transaction.addToBackStack(null);
                } else {
                    transaction.show(videoFragment);
                    if (readFragmet.isAdded()) {
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
                    hideKeyboardFrom(activity, et_search, false);
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
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Intent intetn = new Intent("android.intent.action.MAIN");
                intetn.putExtra("Search", et_search.getText().toString());
                activity.sendBroadcast(intetn);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        setAdapter();
    }

    private void setAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 4);
        binding.rvWriteDetail.setLayoutManager(gridLayoutManager);
        writeAdapter = new WriteAdapter(activity, list, new RecyclerImage() {
            @Override
            public void onClickImg(int img, String name, int position) {
                Intent intent = new Intent(activity, DrawingActivity.class);
                intent.putExtra("type", type/*img*/);
                intent.putExtra("title", title/*name*/);
                intent.putExtra("position", position);
                startActivity(intent);
                overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
            }
        });

        binding.rvWriteDetail.setAdapter(writeAdapter);
    }

    private ArrayList<WriteBeen> getAlphabet() {
        ArrayList<WriteBeen> list = new ArrayList<>();
        list.add(new WriteBeen("A", R.drawable.alphabet_apple_write));
        list.add(new WriteBeen("B", R.drawable.alphabet_ball_write));
        list.add(new WriteBeen("C", R.drawable.alphabet_cat_write));
        list.add(new WriteBeen("D", R.drawable.alphabet_dog_write));
        list.add(new WriteBeen("E", R.drawable.alphabet_elephant_write));
        list.add(new WriteBeen("F", R.drawable.alphabet_fish_write));
        list.add(new WriteBeen("G", R.drawable.alphabet_got_write));
        list.add(new WriteBeen("H", R.drawable.alphabet_hourse_write));
        list.add(new WriteBeen("I", R.drawable.alphabet_icecreame_write));
        list.add(new WriteBeen("J", R.drawable.alphabet_jug_write));
        list.add(new WriteBeen("K", R.drawable.alphabet_kite_write));
        list.add(new WriteBeen("L", R.drawable.alphabet_line_write));
        list.add(new WriteBeen("M", R.drawable.alphabet_monkey_write));
        list.add(new WriteBeen("N", R.drawable.alphabet_hen_write));
        list.add(new WriteBeen("O", R.drawable.alphabet_owl_write));
        list.add(new WriteBeen("P", R.drawable.alphabet_parret_write));
        list.add(new WriteBeen("Q", R.drawable.alphabet_queen_write));
        list.add(new WriteBeen("R", R.drawable.alphabet_rabbit_write));
        list.add(new WriteBeen("S", R.drawable.alphabet_snack_write));
        list.add(new WriteBeen("T", R.drawable.alphabet_tiger_write));
        list.add(new WriteBeen("U", R.drawable.alphabet_umbrella_write));
        list.add(new WriteBeen("V", R.drawable.alphabet_van_write));
        list.add(new WriteBeen("W", R.drawable.alphabet_watch_write));
        list.add(new WriteBeen("X", R.drawable.alphabet_x_write));
        list.add(new WriteBeen("Y", R.drawable.alphabet_yark_write));
        list.add(new WriteBeen("Z", R.drawable.alphabet_zebra_write));
        return list;
    }

    private ArrayList<WriteBeen> getFromNumbers() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen("ONE", R.drawable.number_01_write));
        data.add(new WriteBeen("TWO", R.drawable.number_02_write));
        data.add(new WriteBeen("THREE", R.drawable.number_03_write));
        data.add(new WriteBeen("FOUR", R.drawable.number_04_write));
        data.add(new WriteBeen("FIVE", R.drawable.number_05_write));
        data.add(new WriteBeen("SIX", R.drawable.number_06_write));
        data.add(new WriteBeen("SEVEN", R.drawable.number_07_write));
        data.add(new WriteBeen("EIGHT", R.drawable.number_08_write));
        data.add(new WriteBeen("NINE", R.drawable.number_09_write));
        data.add(new WriteBeen("TEN", R.drawable.number_10_write));
        return data;
    }

    private ArrayList<WriteBeen> getFromShape() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.shape_circle_write, "CIRCLE"));
        data.add(new WriteBeen(R.drawable.shape_polygon_write, "OVAL"));
        data.add(new WriteBeen(R.drawable.shape_rectangle_write, "RECTANGLE"));
        data.add(new WriteBeen(R.drawable.shape_square_write, "SQUARE"));
        data.add(new WriteBeen(R.drawable.shape_triangle_write, "TRIANGLE"));
        return data;
    }

    private ArrayList<WriteBeen> getFromMonths() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.month_january_write, "JANUARY"));
        data.add(new WriteBeen(R.drawable.month_february_write, "FEBRUARY"));
        data.add(new WriteBeen(R.drawable.month_march_write, "MARCH"));
        data.add(new WriteBeen(R.drawable.month_april_write, "APRIL"));
        data.add(new WriteBeen(R.drawable.month_may_write, "MAY"));
        data.add(new WriteBeen(R.drawable.month_june_write, "JUNE"));
        data.add(new WriteBeen(R.drawable.month_july_write, "July"));
        data.add(new WriteBeen(R.drawable.month_august_write, "AUGUST"));
        data.add(new WriteBeen(R.drawable.month_september_write, "SEPTEMBER"));
        data.add(new WriteBeen(R.drawable.month_october_write, "OCTOBER"));
        data.add(new WriteBeen(R.drawable.month_november_write, "NOVEMBER"));
        data.add(new WriteBeen(R.drawable.month_december_write, "DECEMBER"));
        return data;
    }

    private ArrayList<WriteBeen> getFromTransport() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.transport_bicycle_write, "BICYCLE"));
        data.add(new WriteBeen(R.drawable.transport_airplane_write, "AIRPLANE"));
        data.add(new WriteBeen(R.drawable.transport_scooter_write, "SCOOTER"));
        data.add(new WriteBeen(R.drawable.transport_bus_write, "BUS"));
        data.add(new WriteBeen(R.drawable.transport_car_write, "CAR"));
        data.add(new WriteBeen(R.drawable.transport_boat_write, "BOAT"));
        data.add(new WriteBeen(R.drawable.transport_dump_truck_write, "TRUCK"));
        data.add(new WriteBeen(R.drawable.transport_train_write, "TRAIN"));
        data.add(new WriteBeen(R.drawable.transport_tractor_write, "TRACTOR"));
        data.add(new WriteBeen(R.drawable.transport_helicopter_write, "HELICOPTER"));
        data.add(new WriteBeen(R.drawable.transport_balloon_write, "BALLOON"));
        data.add(new WriteBeen(R.drawable.transport_cement_mixer_write, "CEMENT MIXER"));
        data.add(new WriteBeen(R.drawable.transport_crane_write, "CRANE"));
        data.add(new WriteBeen(R.drawable.transport_ferry_write, "FERRY"));
        data.add(new WriteBeen(R.drawable.transport_lorry_write, "LORRY"));
        data.add(new WriteBeen(R.drawable.transport_mimibus_write, "MINI BUS"));
        data.add(new WriteBeen(R.drawable.transport_motorcycle_write, "MOTOR CYCLE"));
        data.add(new WriteBeen(R.drawable.transport_rocket_write, "ROCKET"));
        data.add(new WriteBeen(R.drawable.transport_ship_write, "SHIP"));
        data.add(new WriteBeen(R.drawable.transport_van_write, "VAN"));
        return data;
    }

    private ArrayList<WriteBeen> getFromAnimals() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.animal_dog_write, "DOG"));
        data.add(new WriteBeen(R.drawable.animal_elephant_write, "ELEPHANT"));
        data.add(new WriteBeen(R.drawable.animal_horse_write, "HORSE"));
        data.add(new WriteBeen(R.drawable.animal_cheetah_write, "CHEETAH"));
        data.add(new WriteBeen(R.drawable.animal_lion_write, "LION"));
        data.add(new WriteBeen(R.drawable.animal_tiger_write, "TIGER"));
        data.add(new WriteBeen(R.drawable.animal_pig_write, "PIG"));
        data.add(new WriteBeen(R.drawable.animal_zebra_write, "ZEBRA"));
        data.add(new WriteBeen(R.drawable.animal_dear_write, "DEAR"));
        data.add(new WriteBeen(R.drawable.animal_donkey_write, "DONKEY"));
        data.add(new WriteBeen(R.drawable.animal_sheep_write, "SHEEP"));
        data.add(new WriteBeen(R.drawable.animal_cat_write, "CAT"));
        data.add(new WriteBeen(R.drawable.animal_giraffe_write, "GIRAFFE"));
        data.add(new WriteBeen(R.drawable.animal_hippopotamus_write, "HIPPOPOTAMUS"));
        data.add(new WriteBeen(R.drawable.animal_cawfill_write, "COW"));
        data.add(new WriteBeen(R.drawable.animal_bear_write, "BEAR"));
        data.add(new WriteBeen(R.drawable.animal_goat_write, "GOAT"));
        data.add(new WriteBeen(R.drawable.animal_monkey_write, "MONKEY"));
        data.add(new WriteBeen(R.drawable.animal_bluewhale_write, "BLUE WHALE"));
        data.add(new WriteBeen(R.drawable.animal_chimpanzee_write, "CHIMPANZEE"));
        data.add(new WriteBeen(R.drawable.animal_crocodile_write, "CROCODILE"));
        data.add(new WriteBeen(R.drawable.animal_dolphin_write, "DOLPHIN"));
        data.add(new WriteBeen(R.drawable.animal_fox_write, "FOX"));
        data.add(new WriteBeen(R.drawable.animal_jaguar_write, "JAGUAR"));
        data.add(new WriteBeen(R.drawable.animal_kangaroo_write, "KANGAROO"));
        data.add(new WriteBeen(R.drawable.animal_killer_whale_write, "KILLER WHALE"));
        data.add(new WriteBeen(R.drawable.animal_octopus_write, "OCTOPUS"));
        data.add(new WriteBeen(R.drawable.animal_otter_write, "OTTER"));
        data.add(new WriteBeen(R.drawable.animal_oyster_write, "OYSTER"));
        data.add(new WriteBeen(R.drawable.animal_rabbit_write, "RABBIT"));
        data.add(new WriteBeen(R.drawable.animal_raccoon_write, "RACCOON"));
        data.add(new WriteBeen(R.drawable.animal_sea_urchin_write, "SEA URCHIN"));
        data.add(new WriteBeen(R.drawable.animal_shark_write, "SHARK"));
        data.add(new WriteBeen(R.drawable.animal_shells_write, "SHELLS"));
        data.add(new WriteBeen(R.drawable.animal_snake_write, "SNACK"));
        return data;
    }

    private ArrayList<WriteBeen> getFromFruits() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.fruit_apple_write, "APPLE"));
        data.add(new WriteBeen(R.drawable.fruit_banana_write, "BANANA"));
        data.add(new WriteBeen(R.drawable.fruit_avocado_write, "AVOCADO"));
        data.add(new WriteBeen(R.drawable.fruit_mango_write, "MANGO"));
        data.add(new WriteBeen(R.drawable.fruit_orange_write, "ORANGE"));
        data.add(new WriteBeen(R.drawable.fruit_strawberry_write, "STRAWBERRY"));
        data.add(new WriteBeen(R.drawable.fruit_watermelon_write, "WATERMELON"));
        data.add(new WriteBeen(R.drawable.fruit_balckberry_write, "BLACKBERRY"));
        data.add(new WriteBeen(R.drawable.fruit_coconut_write, "COCONUT"));
        data.add(new WriteBeen(R.drawable.fruit_guava_write, "GUAVA"));
        data.add(new WriteBeen(R.drawable.fruit_lemon_write, "LEMON"));
        data.add(new WriteBeen(R.drawable.fruit_papaya_write, "PAPAYA"));
        data.add(new WriteBeen(R.drawable.fruit_pinaple_write, "PINEAPPLE"));
        data.add(new WriteBeen(R.drawable.fruit_star_write, "STAR"));
        data.add(new WriteBeen(R.drawable.fruit_sugar_apple_write, "SUGAR APPLE"));
        return data;
    }

    private ArrayList<WriteBeen> getFromProfession() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.profession_doctor_write, "DOCTOR"));
        data.add(new WriteBeen(R.drawable.profession_actors_write, "ACTOR"));
        data.add(new WriteBeen(R.drawable.profession_busdrives_write, "BUS DRIVER"));
        data.add(new WriteBeen(R.drawable.profession_engineers_write, "ENGINEER"));
        data.add(new WriteBeen(R.drawable.profession_farmers_write, "FARMER"));
        data.add(new WriteBeen(R.drawable.profession_fireman_write, "FIRE MAN"));
        data.add(new WriteBeen(R.drawable.profession_tailor_write, "TAILOR"));
        data.add(new WriteBeen(R.drawable.profession_massage_therapist_write, "MASSAGE THERAPIST"));
        data.add(new WriteBeen(R.drawable.profession_piloat_write, "PILOT"));
        data.add(new WriteBeen(R.drawable.profession_plumber_write, "PLUMBER"));
        data.add(new WriteBeen(R.drawable.profession_police_write, "POLICE"));
        data.add(new WriteBeen(R.drawable.profession_professor_write, "PROFESSOR"));
        data.add(new WriteBeen(R.drawable.profession_reporter_write, "REPORTER"));
        data.add(new WriteBeen(R.drawable.profession_teachers_write, "TEACHER"));
        data.add(new WriteBeen(R.drawable.profession_truckdrivers_write, "TRUCK DRIVER"));
        return data;
    }

    private ArrayList<WriteBeen> getFromSports() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.sport_cricket_write, "CRICKET"));
        data.add(new WriteBeen(R.drawable.sport_football_write, "FOOTBALL"));
        data.add(new WriteBeen(R.drawable.sport_polo_write, "POLO"));
        data.add(new WriteBeen(R.drawable.sport_archery_write, "ARCHERY"));
        data.add(new WriteBeen(R.drawable.sport_baseball_write, "BASEBALL"));
        data.add(new WriteBeen(R.drawable.sport_boxer_write, "BOXER"));
        data.add(new WriteBeen(R.drawable.sport_cycling_write, "CYCLING"));
        data.add(new WriteBeen(R.drawable.sport_golf_write, "GOLF"));
        data.add(new WriteBeen(R.drawable.sport_horse_raching_write, "HORSE RACING"));
        data.add(new WriteBeen(R.drawable.sport_surfing_write, "SURFING"));
        data.add(new WriteBeen(R.drawable.sport_swimming_write, "SWIMMING"));
        data.add(new WriteBeen(R.drawable.sport_tennis_write, "TENNIS"));
        data.add(new WriteBeen(R.drawable.sport_yoga_write, "YOGA"));
        return data;
    }

    private ArrayList<WriteBeen> getFromBirds() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.bird_albatross_write, "ALBATROSS"));
        data.add(new WriteBeen(R.drawable.bird_bulbul_write, "BULBUL"));
        data.add(new WriteBeen(R.drawable.bird_cormorant_write, "CORMORANT"));
        data.add(new WriteBeen(R.drawable.bird_duks_write, "DUCKS"));
        data.add(new WriteBeen(R.drawable.bird_finches_write, "FINCHES"));
        data.add(new WriteBeen(R.drawable.bird_fowl_write, "FOWL"));
        data.add(new WriteBeen(R.drawable.bird_goose_write, "GOOSE"));
        data.add(new WriteBeen(R.drawable.bird_heron_write, "HERON"));
        data.add(new WriteBeen(R.drawable.bird_hornbill_write, "HORNBILL"));
        data.add(new WriteBeen(R.drawable.bird_hummingbird_write, "HUMMINGBIRD"));
        data.add(new WriteBeen(R.drawable.bird_kingfisher_write, "KINGFISHER"));
        data.add(new WriteBeen(R.drawable.bird_lbis_write, "IBIS"));
        data.add(new WriteBeen(R.drawable.bird_moa_write, "MOA"));
        data.add(new WriteBeen(R.drawable.bird_owl_write, "OWL"));
        data.add(new WriteBeen(R.drawable.bird_paradise_write_write, "PARADISE"));
        data.add(new WriteBeen(R.drawable.bird_parrot_write, "PARROT"));
        data.add(new WriteBeen(R.drawable.bird_pigeons_and_doves_write, "DOVE"));
        return data;
    }

    private ArrayList<WriteBeen> getFromVegetable() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.vagitable_aubergines_write, "AUBERGINES"));
        data.add(new WriteBeen(R.drawable.vagitable_broccoli_write, "BROCCOLI"));
        data.add(new WriteBeen(R.drawable.vagitable_cabbage_write, "CABBAGE"));
        data.add(new WriteBeen(R.drawable.vagitable_carrot_write, "CARROT"));
        data.add(new WriteBeen(R.drawable.vagitable_cauliflower_write, "CAULIFLOWER"));
        data.add(new WriteBeen(R.drawable.vagitable_celery_write, "CELERY"));
        data.add(new WriteBeen(R.drawable.vagitable_corn_write, "CORN"));
        data.add(new WriteBeen(R.drawable.vagitable_green_bean_write, "GREEN BEAN"));
        data.add(new WriteBeen(R.drawable.vagitable_green_pepper_write, "GREEN PEPPER"));
        data.add(new WriteBeen(R.drawable.vagitable_lettuce_write, "LETTUCE"));
        data.add(new WriteBeen(R.drawable.vagitable_patatoes_write, "POTATOES"));
        data.add(new WriteBeen(R.drawable.vagitable_pumpkin_write, "PUMPKIN"));
        data.add(new WriteBeen(R.drawable.vagitable_radish_write, "RADISH"));
        data.add(new WriteBeen(R.drawable.vagitable_red_pepper_write, "RED PEPPER"));
        data.add(new WriteBeen(R.drawable.vagitable_sweet_patatoes_write, "SWEET POTATOES"));
        data.add(new WriteBeen(R.drawable.vagitable_tomatoes_write, "TOMATO"));
        return data;
    }

    private ArrayList<WriteBeen> getFromDays() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.day_monday_write, "MONDAY"));
        data.add(new WriteBeen(R.drawable.day_tuesday_write, "TUESDAY"));
        data.add(new WriteBeen(R.drawable.day_wednesday_write, "WEDNESDAY"));
        data.add(new WriteBeen(R.drawable.day_thursday_write, "THURSDAY"));
        data.add(new WriteBeen(R.drawable.day_friday_write, "FRIDAY"));
        data.add(new WriteBeen(R.drawable.day_saturday_write, "SATURDAY"));
        data.add(new WriteBeen(R.drawable.day_sunday_write, "SUNDAY"));
        return data;
    }

    private ArrayList<WriteBeen> getFromColors() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.color_apple_write, "RED"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "YELLOW"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "ORANGE"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "GREEN"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "BLUE"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "BLACK"));
        data.add(new WriteBeen(R.drawable.color_apple_write, "PINK"));
        return data;
    }

    private ArrayList<WriteBeen> getFromBodyParts() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.body_hair_write, "HAIR"));
        data.add(new WriteBeen(R.drawable.body_eye_write, "EYE"));
        data.add(new WriteBeen(R.drawable.body_hend_write, "HAND"));
        data.add(new WriteBeen(R.drawable.body_ear_write, "EAR"));
        data.add(new WriteBeen(R.drawable.body_lips_write, "LIP"));
        data.add(new WriteBeen(R.drawable.body_nose_write, "NOSE"));
        data.add(new WriteBeen(R.drawable.body_arm_write, "ARM"));
        data.add(new WriteBeen(R.drawable.body_foot_write, "FOOT"));
        data.add(new WriteBeen(R.drawable.body_shoulders_write, "SHOULDER"));
        data.add(new WriteBeen(R.drawable.body_finger_write, "FINGER"));
        data.add(new WriteBeen(R.drawable.body_mounth_write, "MOUTH"));
        data.add(new WriteBeen(R.drawable.body_leg_write, "LEG"));
        data.add(new WriteBeen(R.drawable.body_stomach_write, "STOMACH"));
        data.add(new WriteBeen(R.drawable.body_tongue_write, "TONGUE"));
        return data;
    }

    private ArrayList<WriteBeen> getFromFlower() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.flower_amaryllis_write, "AMARYLLIS"));
        data.add(new WriteBeen(R.drawable.flower_bellflowers_write, "BELL FLOWERS"));
        data.add(new WriteBeen(R.drawable.flower_crocus_write, "CROCUS"));
        data.add(new WriteBeen(R.drawable.flower_golden_rayed_lily_write, "GOLDEN RAYED LILY"));
        data.add(new WriteBeen(R.drawable.flower_jasmine_write, "JASMINE"));
        data.add(new WriteBeen(R.drawable.flower_marigold_write, "MARIGOLD"));
        data.add(new WriteBeen(R.drawable.flower_rose_write, "ROSE"));
        data.add(new WriteBeen(R.drawable.flower_sun_flowers_write, "SUN FLOWER"));
        return data;
    }

    private ArrayList<WriteBeen> getFromBuilding() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.building_bus_station_write, "BUS STATION"));
        data.add(new WriteBeen(R.drawable.building_fire_station_write, "FIRE STATION"));
        data.add(new WriteBeen(R.drawable.building_flat_write, "FLAT"));
        data.add(new WriteBeen(R.drawable.building_hospital_write, "HOSPITAL"));
        data.add(new WriteBeen(R.drawable.building_house_write, "HOUSE"));
        data.add(new WriteBeen(R.drawable.building_police_station_write, "POLICE STATION"));
        data.add(new WriteBeen(R.drawable.building_train_station_write, "TRAIN STATION"));
        return data;
    }

    private ArrayList<WriteBeen> getFromFruitTree() {
        ArrayList<WriteBeen> data = new ArrayList<>();
        data.add(new WriteBeen(R.drawable.tree_almond_write, "ALMOND"));
        data.add(new WriteBeen(R.drawable.tree_avocado_write, "AVOCADO"));
        data.add(new WriteBeen(R.drawable.tree_strawberry_write, "BLACKBERRY"));
        data.add(new WriteBeen(R.drawable.tree_banana_write, "BANANA"));
        data.add(new WriteBeen(R.drawable.tree_chiku_tree_write, "CHIKU"));
        data.add(new WriteBeen(R.drawable.tree_coconut_tree_write, "COCONUT"));
        data.add(new WriteBeen(R.drawable.tree_guava_write, "GUAVA"));
        data.add(new WriteBeen(R.drawable.tree_lemon_tree_write, "LEMON"));
        data.add(new WriteBeen(R.drawable.tree_mango_tree_write, "MANGO"));
        data.add(new WriteBeen(R.drawable.tree_orange_tree_write, "ORANGE"));
        data.add(new WriteBeen(R.drawable.tree_papaya_tree_write, "PAPAYA"));
        data.add(new WriteBeen(R.drawable.tree_pinaple_tree_write, "PINEAPPLE"));
        data.add(new WriteBeen(R.drawable.tree_star_fruit_write, "STAR FRUIT"));
        data.add(new WriteBeen(R.drawable.tree_strawberry_write, "STRAWBERRY"));
        data.add(new WriteBeen(R.drawable.tree_sugar_apple_write, "SUGAR APPLE"));
        return data;
    }

    @Override
    public void onClick(View v) {
        if (v == ll_start) {
            onBackPressed();
        } else if (v == ll_end) {
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
        finish();
    }
}
