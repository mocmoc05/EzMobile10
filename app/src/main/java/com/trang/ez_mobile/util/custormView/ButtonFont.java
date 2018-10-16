package com.trang.ez_mobile.util.custormView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by TraPTH on 2/28/2018.
 */
@SuppressLint("AppCompatCustomView")
public class ButtonFont extends Button {
    Typeface tf;

    public ButtonFont(Context context) {
        super(context);
        initView();
    }

    public ButtonFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ButtonFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @SuppressLint("NewApi")
    public ButtonFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }


    private void initView() {
        try {
            if (tf == null)
                tf = Typeface.createFromAsset(getContext().getAssets(), "font/FreeSans.ttf");
            setTypeface(tf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMaxLines(1);
    }


}
