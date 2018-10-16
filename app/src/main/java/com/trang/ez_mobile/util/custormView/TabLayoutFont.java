package com.trang.ez_mobile.util.custormView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by TraPTH on 2/28/2018.
 */

public class TabLayoutFont extends TabLayout {
    private Typeface mTypeface;

    public TabLayoutFont(Context context) {
        super(context);
        init();
    }

    public TabLayoutFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabLayoutFont(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (mTypeface == null)
            mTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/FreeSansBold.ttf");
    }

    @Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        super.addTab(tab, position, setSelected);
        ViewGroup mainView = (ViewGroup) getChildAt(0);
        ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());
        int tabChildCount = tabView.getChildCount();
        for (int i = 0; i < tabChildCount; i++) {
            View tabViewChild = tabView.getChildAt(i);
            if (tabViewChild instanceof TextView) {
                ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
            }
        }
    }
}
