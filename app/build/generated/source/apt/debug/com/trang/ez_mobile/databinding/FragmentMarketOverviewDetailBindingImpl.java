package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMarketOverviewDetailBindingImpl extends FragmentMarketOverviewDetailBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relative_layout_content_view, 1);
        sViewsWithIds.put(R.id.relative_layout, 2);
        sViewsWithIds.put(R.id.linear_layout1, 3);
        sViewsWithIds.put(R.id.textview_match_price, 4);
        sViewsWithIds.put(R.id.textview_change, 5);
        sViewsWithIds.put(R.id.textview_price_quantity, 6);
        sViewsWithIds.put(R.id.textview_price_value, 7);
        sViewsWithIds.put(R.id.linear_layout, 8);
        sViewsWithIds.put(R.id.textview_price_up, 9);
        sViewsWithIds.put(R.id.textview_price_average, 10);
        sViewsWithIds.put(R.id.textview_price_down, 11);
        sViewsWithIds.put(R.id.textview_foreign_qty, 12);
        sViewsWithIds.put(R.id.textview_foreign_val, 13);
        sViewsWithIds.put(R.id.tablayout, 14);
        sViewsWithIds.put(R.id.view1, 15);
        sViewsWithIds.put(R.id.viewpager, 16);
        sViewsWithIds.put(R.id.progress_bar, 17);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMarketOverviewDetailBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentMarketOverviewDetailBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.ProgressBar) bindings[17]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[1]
            , (com.trang.ez_mobile.util.custormView.TabLayoutFont) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[12]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[13]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[11]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[7]
            , (android.view.View) bindings[15]
            , (android.support.v4.view.ViewPager) bindings[16]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
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