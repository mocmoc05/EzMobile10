package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChartBindingImpl extends FragmentChartBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ln1, 1);
        sViewsWithIds.put(R.id.code, 2);
        sViewsWithIds.put(R.id.type, 3);
        sViewsWithIds.put(R.id.candle_stick, 4);
        sViewsWithIds.put(R.id.char2, 5);
        sViewsWithIds.put(R.id.barchart, 6);
        sViewsWithIds.put(R.id.char1, 7);
        sViewsWithIds.put(R.id.line_chart, 8);
        sViewsWithIds.put(R.id.menu_tab, 9);
        sViewsWithIds.put(R.id.tab_one_week, 10);
        sViewsWithIds.put(R.id.tab_one_month, 11);
        sViewsWithIds.put(R.id.tab_three_month, 12);
        sViewsWithIds.put(R.id.tab_six_month, 13);
        sViewsWithIds.put(R.id.tab_one_year, 14);
        sViewsWithIds.put(R.id.tab_all, 15);
        sViewsWithIds.put(R.id.load, 16);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentChartBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentChartBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.github.mikephil.charting.charts.BarChart) bindings[6]
            , (com.github.mikephil.charting.charts.CandleStickChart) bindings[4]
            , (com.github.mikephil.charting.charts.CombinedChart) bindings[7]
            , (com.github.mikephil.charting.charts.CombinedChart) bindings[5]
            , (com.trang.ez_mobile.util.custormView.AutoCompleteTextViewFont) bindings[2]
            , (com.github.mikephil.charting.charts.LineChart) bindings[8]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[16]
            , (android.widget.LinearLayout) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[15]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[11]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[13]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[12]
            , (com.trang.ez_mobile.util.custormView.SpinnerFont) bindings[3]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
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