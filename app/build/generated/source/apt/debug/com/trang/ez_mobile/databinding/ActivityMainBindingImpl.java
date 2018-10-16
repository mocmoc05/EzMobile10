package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(1, 
            new String[] {"nav_user_layout"},
            new int[] {3},
            new int[] {R.layout.nav_user_layout});
        sIncludes.setIncludes(0, 
            new String[] {"app_bar_main"},
            new int[] {2},
            new int[] {R.layout.app_bar_main});
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.trang.ez_mobile.databinding.AppBarMainBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[1]
            , (android.support.v4.widget.DrawerLayout) bindings[0]
            , (com.trang.ez_mobile.databinding.NavUserLayoutBinding) bindings[3]
            );
        this.drawerContainer.setTag(null);
        this.drawerLayout.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        appBarMain.invalidateAll();
        navUserLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (appBarMain.hasPendingBindings()) {
            return true;
        }
        if (navUserLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        appBarMain.setLifecycleOwner(lifecycleOwner);
        navUserLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeAppBarMain((com.trang.ez_mobile.databinding.AppBarMainBinding) object, fieldId);
            case 1 :
                return onChangeNavUserLayout((com.trang.ez_mobile.databinding.NavUserLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeAppBarMain(com.trang.ez_mobile.databinding.AppBarMainBinding AppBarMain, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNavUserLayout(com.trang.ez_mobile.databinding.NavUserLayoutBinding NavUserLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        executeBindingsOn(appBarMain);
        executeBindingsOn(navUserLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): appBarMain
        flag 1 (0x2L): navUserLayout
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}