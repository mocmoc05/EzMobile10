package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogFragmentBuyBindingImpl extends DialogFragmentBuyBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_value_stock_balance, 1);
        sViewsWithIds.put(R.id.tv_ma_ck, 2);
        sViewsWithIds.put(R.id.tv_gia_tran, 3);
        sViewsWithIds.put(R.id.tv_gia_tham_chieu, 4);
        sViewsWithIds.put(R.id.tv_gia_san, 5);
        sViewsWithIds.put(R.id.tv_gia_mua_tot_nhat, 6);
        sViewsWithIds.put(R.id.tv_khoi_luong_mua, 7);
        sViewsWithIds.put(R.id.tv_gia_ban_tot_nhat, 8);
        sViewsWithIds.put(R.id.tv_khoi_luong_ban, 9);
        sViewsWithIds.put(R.id.tv_value_ma_ck, 10);
        sViewsWithIds.put(R.id.tv_value_san_gd, 11);
        sViewsWithIds.put(R.id.tv_value_so_luong, 12);
        sViewsWithIds.put(R.id.spn_value_loai_lenh, 13);
        sViewsWithIds.put(R.id.tv_value_gia_mua, 14);
        sViewsWithIds.put(R.id.tv_value_mat_khau, 15);
        sViewsWithIds.put(R.id.btn_xac_nhan_mua, 16);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogFragmentBuyBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private DialogFragmentBuyBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.trang.ez_mobile.util.custormView.ButtonFont) bindings[16]
            , (com.trang.ez_mobile.util.custormView.SpinnerFont) bindings[13]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[8]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[3]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[7]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[2]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[10]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[15]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[11]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[12]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[1]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
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