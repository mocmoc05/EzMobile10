package com.trang.ez_mobile.util.custormView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * Created by TraPTH on 2/28/2018.
 */
@SuppressLint("AppCompatCustomView")
public class AutoCompleteTextViewFont extends AutoCompleteTextView {
    Typeface tf;

    public AutoCompleteTextViewFont(Context context) {
        super(context);
        initView();
    }

    public AutoCompleteTextViewFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AutoCompleteTextViewFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @SuppressLint("NewApi")
    public AutoCompleteTextViewFont(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
