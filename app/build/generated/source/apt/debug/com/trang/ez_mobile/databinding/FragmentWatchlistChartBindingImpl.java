package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWatchlistChartBindingImpl extends FragmentWatchlistChartBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.candle_stick, 1);
        sViewsWithIds.put(R.id.line_chart, 2);
        sViewsWithIds.put(R.id.barchart, 3);
        sViewsWithIds.put(R.id.menu_tab, 4);
        sViewsWithIds.put(R.id.oday, 5);
        sViewsWithIds.put(R.id.tab_one_week, 6);
        sViewsWithIds.put(R.id.tab_one_month, 7);
        sViewsWithIds.put(R.id.tab_three_month, 8);
        sViewsWithIds.put(R.id.tab_six_month, 9);
        sViewsWithIds.put(R.id.tab_one_year, 10);
        sViewsWithIds.put(R.id.tab_all, 11);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWatchlistChartBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentWatchlistChartBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.mikephil.charting.charts.BarChart) bindings[3]
            , (com.github.mikephil.charting.charts.CandleStickChart) bindings[1]
            , (android.widget.FrameLayout) bindings[0]
            , (com.github.mikephil.charting.charts.LineChart) bindings[2]
            , (android.widget.LinearLayout) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[11]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[7]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[8]
            );
        this.contentview.setTag(null);
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