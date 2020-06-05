package com.printf.kidsteacher.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.been.ViewModel;
import com.printf.kidsteacher.other.OnListItemClick;

import java.util.ArrayList;

/**
 * Created by baps on 14-08-2018.
 */
public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<ViewModel> viewModels;
    LayoutInflater inflater;
    OnListItemClick onListItemClick;
    String from;

    public ViewPagerAdapter(Context context, ArrayList<ViewModel> viewModels, String from, OnListItemClick onListItemClick) {
        this.context = context;
        this.viewModels = viewModels;
        this.onListItemClick = onListItemClick;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.from = from;
    }

    @Override
    public int getCount() {
        return viewModels.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView txtrank, txtCap, textsmall;
        ImageView imgflag, iv_background;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView;
        /*if(from.equalsIgnoreCase(context.getString(R.string.fruits)))
        {
            itemView = inflater.inflate(R.layout.item_viepager_fruit, container, false);
        }
        else
        {
            itemView = inflater.inflate(R.layout.item_viepager, container, false);
        }*/
        itemView = inflater.inflate(R.layout.item_viepager, container, false);
        txtrank = itemView.findViewById(R.id.txt);
        txtCap = itemView.findViewById(R.id.txtCap);
        textsmall = itemView.findViewById(R.id.textsmall);
        imgflag = itemView.findViewById(R.id.img);
        iv_background = itemView.findViewById(R.id.iv_background);
        RelativeLayout relative_read = itemView.findViewById(R.id.relative_read);

        iv_background.setImageResource(viewModels.get(position).getBackground());
        imgflag.setImageResource(viewModels.get(position).getImage());
        //Glide.with(context).load(viewModels.get(position).getImage()).override(300,300).into(imgflag);

        if (viewModels.get(position).getName() != null) {
            txtrank.setText(viewModels.get(position).getName());
        }
        if (viewModels.get(position).getCapital() != null && !viewModels.get(position).getCapital().equalsIgnoreCase("")) {
            txtCap.setText(viewModels.get(position).getCapital());
        } else {
            txtCap.setVisibility(View.GONE);
        }
        if (viewModels.get(position).getSmall() != null && !viewModels.get(position).getSmall().equalsIgnoreCase("")) {
            textsmall.setText(viewModels.get(position).getSmall());
        } else {
            textsmall.setVisibility(View.GONE);
        }

        if (viewModels.get(position).getTextColor() != null) {
            txtCap.setTextColor(Color.parseColor(viewModels.get(position).getTextColor()));
        }
        if (viewModels.get(position).getTextColor() != null) {
            textsmall.setTextColor(Color.parseColor(viewModels.get(position).getTextColor()));
        }
        if (viewModels.get(position).getTextColor() != null) {
            txtrank.setTextColor(Color.parseColor(viewModels.get(position).getTextColor()));
        }

        if (from.equalsIgnoreCase(context.getString(R.string.alphabets))) {
            if (viewModels.get(position).getBackground() == R.drawable.background_5) {
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                txtrank.setLayoutParams(layoutParams1);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                //layoutParams.addRule(RelativeLayout.RIGHT_OF,R.id.img);
                imgflag.setLayoutParams(layoutParams);

            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);
            }
        } else if (from.equalsIgnoreCase(context.getString(R.string.numbers))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);
        } else if (from.equalsIgnoreCase(context.getString(R.string.shapes))) {
            txtrank.setTextSize(context.getResources().getDimension(R.dimen._10sdp));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);
        } else if (from.equalsIgnoreCase(context.getString(R.string.colors))) {
            txtrank.setTextSize(context.getResources().getDimension(R.dimen._11sdp));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);
        } else if (from.equalsIgnoreCase(context.getString(R.string.days)) || from.equalsIgnoreCase(context.getString(R.string.months))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);
        } else if (from.equalsIgnoreCase(context.getString(R.string.animals))) {
            txtrank.setTextSize(context.getResources().getDimension(R.dimen._11sdp));
            if (viewModels.get(position).getBackground() == R.drawable.background_5) {
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                txtrank.setLayoutParams(layoutParams1);

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                //layoutParams.addRule(RelativeLayout.RIGHT_OF,R.id.img);
                imgflag.setLayoutParams(layoutParams);

            } else if (viewModels.get(position).getBackground() == R.drawable.background_3) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);


                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.removeRule(RelativeLayout.LEFT_OF);
                layoutParams1.leftMargin = 35;
                //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
                txtrank.setLayoutParams(layoutParams1);
            }
        } else if (from.equalsIgnoreCase(context.getString(R.string.body_parts))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.leftMargin = 35;
            //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.fruits))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.leftMargin = 25;
            //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.transport))) {
            if (viewModels.get(position).getBackground() == R.drawable.background_3) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);

                txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.removeRule(RelativeLayout.LEFT_OF);
                layoutParams1.leftMargin = 25;
                //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
                txtrank.setLayoutParams(layoutParams1);
            }
        } else if (from.equalsIgnoreCase(context.getString(R.string.proffesion))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.leftMargin = 25;
            //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.sport))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.leftMargin = 25;
            //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.bird))) {
            if (viewModels.get(position).getName().equalsIgnoreCase("OWL") ||
                    viewModels.get(position).getName().equalsIgnoreCase("PARADISE")) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);

                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.removeRule(RelativeLayout.LEFT_OF);
                layoutParams1.addRule(RelativeLayout.RIGHT_OF, R.id.img);
                txtrank.setLayoutParams(layoutParams1);

                /*layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                layoutParams1.addRule(RelativeLayout.LEFT_OF, R.id.img);*/
            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM, RelativeLayout.TRUE);
                imgflag.setLayoutParams(layoutParams);

                txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
                layoutParams1.removeRule(RelativeLayout.LEFT_OF);
                layoutParams1.leftMargin = 25;
                //layoutParams1.addRule(RelativeLayout.ABOVE, R.id.img);
                txtrank.setLayoutParams(layoutParams1);
            }
        } else if (from.equalsIgnoreCase(context.getString(R.string.building))) {
            imgflag.setImageResource(0);
            iv_background.setImageResource(viewModels.get(position).getImage());
        } else if (from.equalsIgnoreCase(context.getString(R.string.flower))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));

            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.addRule(RelativeLayout.RIGHT_OF, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.fruit_tree))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.addRule(RelativeLayout.RIGHT_OF, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        } else if (from.equalsIgnoreCase(context.getString(R.string.vegetable))) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgflag.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
            layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            imgflag.setLayoutParams(layoutParams);

            txtrank.setTextSize(context.getResources().getDimension(R.dimen._14sdp));
            RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) txtrank.getLayoutParams();
            layoutParams1.removeRule(RelativeLayout.LEFT_OF);
            layoutParams1.addRule(RelativeLayout.RIGHT_OF, R.id.img);
            txtrank.setLayoutParams(layoutParams1);
        }

        txtCap.setTag(position);
        txtCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                if (onListItemClick != null)
                    onListItemClick.playThisMusic(viewModels.get(position).getNameMusic());
            }
        });

        textsmall.setTag(position);
        textsmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                if (onListItemClick != null)
                    onListItemClick.playThisMusic(viewModels.get(position).getNameMusic());
            }
        });


        imgflag.setTag(position);
        imgflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();

                if (onListItemClick != null)
                    onListItemClick.playThisMusic(viewModels.get(position).getInfoMusic());
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}