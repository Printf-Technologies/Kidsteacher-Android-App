package com.printf.kidsteacher.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.printf.kidsteacher.R;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView
{
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs)
    {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFont);
        String font = typedArray.getString(R.styleable.CustomFont_customText);
        if(font != null && !font.equalsIgnoreCase(""))
        {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(),"font/"+font);
            setTypeface(typeface);
            typedArray.recycle();
        }
    }
}
