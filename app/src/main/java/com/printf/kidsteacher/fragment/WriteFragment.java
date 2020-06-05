package com.printf.kidsteacher.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.activity.WriteDetailActivity;
import com.printf.kidsteacher.adapter.ReadAdapter;
import com.printf.kidsteacher.been.ReadBeen;
import com.printf.kidsteacher.other.RecylerViewClick;

import java.util.ArrayList;

public class WriteFragment extends BaseFragment
{
    RecyclerView rv_write;
    ArrayList<ReadBeen> list;
    ReadAdapter readAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_write,container,false);
        init(view);
        return view;
    }

    private void init(View view)
    {
        rv_write = view.findViewById(R.id.rv_write);

        setAdapter();
    }

    private void setAdapter()
    {
        list = new ArrayList<>();
        list.add(new ReadBeen(getString(R.string.alphabets),R.drawable.tile_alphabets));
        list.add(new ReadBeen(getString(R.string.numbers),R.drawable.tile_number));
        list.add(new ReadBeen(getString(R.string.shapes),R.drawable.tile_shape));
        list.add(new ReadBeen(getString(R.string.colors),R.drawable.tile_color));
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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),4);
        rv_write.setLayoutManager(gridLayoutManager);
        readAdapter = new ReadAdapter(getActivity(), list, new RecylerViewClick() {
            @Override
            public void OnClick(String name) {
                Intent intent = new Intent(getActivity(), WriteDetailActivity.class);
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
                getActivity().overridePendingTransition(R.anim.enter_left,R.anim.exit_right);
            }
        });
        rv_write.setAdapter(readAdapter);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
