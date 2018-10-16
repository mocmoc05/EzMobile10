package com.trang.ez_mobile.util.custormView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by TraPTH on 2/28/2018.
 */

@SuppressLint("AppCompatCustomView")
public class TextViewFont extends TextView {
    Typeface tf;

    public TextViewFont(Context context) {
        super(context);
        initView();
    }

    public TextViewFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TextViewFont(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
    }


}
