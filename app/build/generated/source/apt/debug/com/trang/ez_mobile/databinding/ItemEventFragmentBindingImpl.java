package com.trang.ez_mobile.databinding;
import com.trang.ez_mobile.R;
import com.trang.ez_mobile.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemEventFragmentBindingImpl extends ItemEventFragmentBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.trang.ez_mobile.util.custormView.TextViewFont mboundView1;
    @NonNull
    private final com.trang.ez_mobile.util.custormView.TextViewFont mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemEventFragmentBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ItemEventFragmentBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.trang.ez_mobile.util.custormView.TextViewFont) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.event == variableId) {
            setEvent((com.trang.ez_mobile.view.events.Event) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setEvent(@Nullable com.trang.ez_mobile.view.events.Event Event) {
        this.mEvent = Event;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.event);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeEventContentEvent((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeEventNameStock((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeEventContentEvent(android.databinding.ObservableField<java.lang.String> EventContentEvent, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeEventNameStock(android.databinding.ObservableField<java.lang.String> EventNameStock, int fieldId) {
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
        java.lang.String eventNameStockGet = null;
        android.databinding.ObservableField<java.lang.String> eventContentEvent = null;
        com.trang.ez_mobile.view.events.Event event = mEvent;
        android.databinding.ObservableField<java.lang.String> eventNameStock = null;
        java.lang.String eventContentEventGet = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (event != null) {
                        // read event.contentEvent
                        eventContentEvent = event.contentEvent;
                    }
                    updateRegistration(0, eventContentEvent);


                    if (eventContentEvent != null) {
                        // read event.contentEvent.get()
                        eventContentEventGet = eventContentEvent.get();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (event != null) {
                        // read event.nameStock
                        eventNameStock = event.nameStock;
                    }
                    updateRegistration(1, eventNameStock);


                    if (eventNameStock != null) {
                        // read event.nameStock.get()
                        eventNameStockGet = eventNameStock.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, eventNameStockGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, eventContentEventGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): event.contentEvent
        flag 1 (0x2L): event.nameStock
        flag 2 (0x3L): event
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}