package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSellBindingImpl extends FragmentSellBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_available_cash, 1);
        sViewsWithIds.put(R.id.ll_tt_ck, 2);
        sViewsWithIds.put(R.id.tv_ma_ck, 3);
        sViewsWithIds.put(R.id.tv_gia_tran, 4);
        sViewsWithIds.put(R.id.tv_gia_tham_chieu, 5);
        sViewsWithIds.put(R.id.tv_gia_san, 6);
        sViewsWithIds.put(R.id.gia_mua_max, 7);
        sViewsWithIds.put(R.id.tv_khoi_luong_mua, 8);
        sViewsWithIds.put(R.id.tv_gia_ban_min, 9);
        sViewsWithIds.put(R.id.tv_khoi_luong_ban, 10);
        sViewsWithIds.put(R.id.edt_value_ma_ck, 11);
        sViewsWithIds.put(R.id.img_ma_ck, 12);
        sViewsWithIds.put(R.id.tv_value_san_gd, 13);
        sViewsWithIds.put(R.id.edt_value_so_luong, 14);
        sViewsWithIds.put(R.id.spn_value_loai_lenh, 15);
        sViewsWithIds.put(R.id.edt_value_gia_mua, 16);
        sViewsWithIds.put(R.id.edt_value_mat_khau, 17);
        sViewsWithIds.put(R.id.btn_xac_nhan_mua, 18);
        sViewsWithIds.put(R.id.ll_progress_fragment_sell, 19);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSellBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FragmentSellBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.trang.ez_mobile.util.custormView.ButtonFont) bindings[18]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[16]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[11]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[17]
            , (com.trang.ez_mobile.util.custormView.EditTextFont) bindings[14]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[7]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[2]
            , (com.trang.ez_mobile.util.custormView.SpinnerFont) bindings[15]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[1]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[9]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[6]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[5]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[4]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[10]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[8]
            , (com.trang.ez_mobile.util.custormView.TextViewFontBold) bindings[3]
            , (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[13]
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