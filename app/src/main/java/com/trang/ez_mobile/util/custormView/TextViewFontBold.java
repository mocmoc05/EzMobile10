package com.trang.ez_mobile.util.custormView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by TraPTH on 2/28/2018.
 */

@SuppressLint("AppCompatCustomView")
public class TextViewFontBold extends TextView {
    Typeface tf;

    public TextViewFontBold(Context context) {
        super(context);
        initView();
    }

    public TextViewFontBold(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TextViewFontBold(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //font

        try {
            if (tf == null)
                tf = Typeface.createFromAsset(getContext().getAssets(), "font/FreeSansBold.ttf");
            setTypeface(tf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMaxLines(1);
    }


}
