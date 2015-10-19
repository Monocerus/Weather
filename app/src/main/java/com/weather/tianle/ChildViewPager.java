package com.weather.tianle;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by tianle on 2015/10/17.
 */

public class ChildViewPager extends ViewPager {
    private float mTouchStartY;
    private float mTouchCurY;
    private float mTouchStartX;
    private float mTouchCurX;
    OnSingleTouchListener onSingleTouchListener;

    public ChildViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public ChildViewPager(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mTouchStartY = ev.getY();
                mTouchCurY = mTouchStartY;
                mTouchStartX = ev.getX();
                mTouchCurX = mTouchStartX;
                break;
            case MotionEvent.ACTION_MOVE:
                float curY = ev.getY();
                float dy = curY - mTouchStartY;
                float curX = ev.getX();
                float dx = curX - mTouchStartX;
                if (Math.abs(dy) < 5 && Math.abs(dx)>25 ) {
                    return true;
                }
                ;
        }
        return super.onInterceptTouchEvent(ev);
    }

  //  @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // TODO Auto-generated method stub
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                mTouchCurY = event.getY();
//
//                return true;
//        return super.onTouchEvent(arg0);
//    }

    /**
     * 单击
     */
    public void onSingleTouch() {
        if (onSingleTouchListener!= null) {

            onSingleTouchListener.onSingleTouch();
        }
    }

    /**
     * 创建点击事件接口
     * @author wanpg
     *
     */
    public interface OnSingleTouchListener {
        public void onSingleTouch();
    }

    public void setOnSingleTouchListener(OnSingleTouchListener onSingleTouchListener) {
        this.onSingleTouchListener = onSingleTouchListener;
    }

}