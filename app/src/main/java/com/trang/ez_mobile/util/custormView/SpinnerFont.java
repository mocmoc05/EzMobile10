package com.trang.ez_mobile.util.custormView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Spinner;

/**
 * Created by TraPTH on 3/27/2018.
 */

@SuppressLint("AppCompatCustomView")
public class SpinnerFont extends Spinner {
    private Typeface mTypeface;

    public SpinnerFont(Context context) {
        super(context);
        init();
    }

    public SpinnerFont(Context context, int mode) {
        super(context, mode);
        init();
    }

    public SpinnerFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpinnerFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SpinnerFont(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        init();
    }

    private void init() {
        if (mTypeface == null)
            mTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/FreeSans.ttf");


    }

}
