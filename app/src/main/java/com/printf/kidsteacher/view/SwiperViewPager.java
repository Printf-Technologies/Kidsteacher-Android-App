package com.printf.kidsteacher.view;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;



public class SwiperViewPager extends ViewPager {

    SwiperListener mSwiperListener;
    private float downX;
    private float downY;
    private boolean isTouchCaptured;
    private float upX1;
    private float upY1;
    private float upX2;
    private float upY2;

    public SwiperViewPager(Context context) {
        super(context);
    }

    public SwiperViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private float x1, x2;
    static final int min_distance = 20;

    boolean eventSent = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                downX = event.getX();
                downY = event.getY();

                if (!isTouchCaptured) {
                    upX1 = event.getX();
                    upY1 = event.getY();
                    isTouchCaptured = true;
                } else {
                    upX2 = event.getX();
                    upY2 = event.getY();
                    float deltaX = upX1 - upX2;
                    float deltaY = upY1 - upY2;
                    //HORIZONTAL SCROLL
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        if (Math.abs(deltaX) > min_distance) {
                            // left or right
                            if (deltaX < 0) {
                                if(!eventSent && mSwiperListener!=null){
                                    mSwiperListener.onLeftSwipe();
                                    eventSent = true;
                                }
                            }
                            if (deltaX > 0) {
                                if(!eventSent && mSwiperListener!=null){
                                    if(mSwiperListener.onRightSwipe()){
                                        eventSent = true;
                                        return false;
                                    }
                                }
                            }
                        } else {
                            //not long enough swipe...
                        }
                    }
                    //VERTICAL SCROLL
                    else {
                        if (Math.abs(deltaY) > min_distance) {
                            // top or down
                            if (deltaY < 0) {

                            }
                            if (deltaY > 0) {

                            }
                        } else {
                            //not long enough swipe...
                        }
                    }
                }
            }
            break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:{
                isTouchCaptured = false;
                eventSent = false;
            }

        }
        return super.onTouchEvent(event);
    }

    public void setmSwiperListener(SwiperListener mSwiperListener) {
        this.mSwiperListener = mSwiperListener;
    }

    public interface SwiperListener {
        boolean onLeftSwipe();

        boolean onRightSwipe();
    }

}