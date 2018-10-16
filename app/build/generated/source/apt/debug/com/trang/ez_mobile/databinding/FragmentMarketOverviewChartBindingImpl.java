package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMarketOverviewChartBindingImpl extends FragmentMarketOverviewChartBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.menu_tab, 1);
        sViewsWithIds.put(R.id.tab_one_day, 2);
        sViewsWithIds.put(R.id.tab_one_week, 3);
        sViewsWithIds.put(R.id.tab_one_month, 4);
        sViewsWithIds.put(R.id.tab_three_month, 5);
        sViewsWithIds.put(R.id.tab_six_month, 6);
        sViewsWithIds.put(R.id.tab_one_year, 7);
        sViewsWithIds.put(R.id.tab_two_year, 8);
        sViewsWithIds.put(R.id.tab_all, 9);
        sViewsWithIds.put(R.id.line_chart, 10);
        sViewsWithIds.put(R.id.candle_stick_chart, 11);
        sViewsWithIds.put(R.id.bar_chart, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMarketOverviewChartBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentMarketOverviewChartBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.mikephil.charting.charts.BarChart) bindings[12]
            , (com.github.mikephil.charting.charts.CandleStickChart) bindings[11]
            , (com.github.mikephil.charting.charts.LineChart) bindings[10]
            , (android.widget.LinearLayout) bindings[1]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[2]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[3]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[7]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[8]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}