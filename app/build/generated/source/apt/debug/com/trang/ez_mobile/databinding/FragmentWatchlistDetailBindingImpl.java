package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWatchlistDetailBindingImpl extends FragmentWatchlistDetailBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.la1, 1);
        sViewsWithIds.put(R.id.textview_tran, 2);
        sViewsWithIds.put(R.id.textview_tc, 3);
        sViewsWithIds.put(R.id.textview_san, 4);
        sViewsWithIds.put(R.id.icon, 5);
        sViewsWithIds.put(R.id.la2, 6);
        sViewsWithIds.put(R.id.textview_gia, 7);
        sViewsWithIds.put(R.id.textview_thaydoi, 8);
        sViewsWithIds.put(R.id.textview_khoiluong, 9);
        sViewsWithIds.put(R.id.op, 10);
        sViewsWithIds.put(R.id.textview_open, 11);
        sViewsWithIds.put(R.id.textview_cn, 12);
        sViewsWithIds.put(R.id.textview_max, 13);
        sViewsWithIds.put(R.id.textview_tn, 14);
        sViewsWithIds.put(R.id.textview_min, 15);
        sViewsWithIds.put(R.id.textview_nmua, 16);
        sViewsWithIds.put(R.id.nnmua, 17);
        sViewsWithIds.put(R.id.textview_nban, 18);
        sViewsWithIds.put(R.id.nnban, 19);
        sViewsWithIds.put(R.id.tablayout, 20);
        sViewsWithIds.put(R.id.viewpager, 21);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWatchlistDetailBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentWatchlistDetailBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[19]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[17]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TabLayoutFont) bindings[20]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[12]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[7]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[13]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[15]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[18]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[16]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[11]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[3]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[8]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[2]
            , (android.support.v4.view.ViewPager) bindings[21]
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