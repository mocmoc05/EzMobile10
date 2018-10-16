package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWatchlistTradingBindingImpl extends FragmentWatchlistTradingBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.txtBMrkTitle, 1);
        sViewsWithIds.put(R.id.txtBVolTitle, 2);
        sViewsWithIds.put(R.id.txtSMrkTitle, 3);
        sViewsWithIds.put(R.id.txtSVolTitle, 4);
        sViewsWithIds.put(R.id.txtB1Title, 5);
        sViewsWithIds.put(R.id.txtB2Title, 6);
        sViewsWithIds.put(R.id.txtB3Title, 7);
        sViewsWithIds.put(R.id.txtB1MrkValue, 8);
        sViewsWithIds.put(R.id.txtB2MrkValue, 9);
        sViewsWithIds.put(R.id.txtB3MrkValue, 10);
        sViewsWithIds.put(R.id.txtB1VolValue, 11);
        sViewsWithIds.put(R.id.txtB2VolValue, 12);
        sViewsWithIds.put(R.id.txtB3VolValue, 13);
        sViewsWithIds.put(R.id.txtS1Title, 14);
        sViewsWithIds.put(R.id.txtS2Title, 15);
        sViewsWithIds.put(R.id.txtS3Title, 16);
        sViewsWithIds.put(R.id.txtS1MrkValue, 17);
        sViewsWithIds.put(R.id.txtS2MrkValue, 18);
        sViewsWithIds.put(R.id.txtS3MrkValue, 19);
        sViewsWithIds.put(R.id.txtS1VolValue, 20);
        sViewsWithIds.put(R.id.txtS2VolValue, 21);
        sViewsWithIds.put(R.id.txtS3VolValue, 22);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWatchlistTradingBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private FragmentWatchlistTradingBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[0]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[8]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[11]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[12]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[7]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[13]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[1]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[2]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[17]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[20]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[18]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[15]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[21]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[19]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[16]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[22]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[3]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[4]
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