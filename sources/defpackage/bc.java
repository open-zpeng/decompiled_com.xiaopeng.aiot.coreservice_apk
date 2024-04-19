package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
/* compiled from: FragmentLayoutInflaterFactory.java */
/* renamed from: bc  reason: default package */
/* loaded from: classes.dex */
public class bc implements LayoutInflater.Factory2 {
    public final dc a;

    public bc(dc fragmentManager) {
        this.a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        kc fragmentStateManager;
        if (FragmentContainerView.class.getName().equals(name)) {
            return new FragmentContainerView(context, attrs, this.a);
        }
        if ("fragment".equals(name)) {
            String fname = attrs.getAttributeValue(null, "class");
            TypedArray a2 = context.obtainStyledAttributes(attrs, sb.d);
            if (fname == null) {
                fname = a2.getString(sb.e);
            }
            int id = a2.getResourceId(sb.f, -1);
            String tag = a2.getString(sb.g);
            a2.recycle();
            if (fname == null || !zb.b(context.getClassLoader(), fname)) {
                return null;
            }
            int containerId = parent != null ? parent.getId() : 0;
            if (containerId != -1 || id != -1 || tag != null) {
                Fragment fragment = id != -1 ? this.a.h0(id) : null;
                if (fragment == null && tag != null) {
                    fragment = this.a.i0(tag);
                }
                if (fragment == null && containerId != -1) {
                    fragment = this.a.h0(containerId);
                }
                if (fragment == null) {
                    fragment = this.a.q0().a(context.getClassLoader(), fname);
                    fragment.q = true;
                    fragment.z = id != 0 ? id : containerId;
                    fragment.A = containerId;
                    fragment.B = tag;
                    fragment.r = true;
                    dc dcVar = this.a;
                    fragment.v = dcVar;
                    fragment.w = dcVar.t0();
                    fragment.u0(this.a.t0().k(), attrs, fragment.d);
                    fragmentStateManager = this.a.g(fragment);
                    if (dc.F0(2)) {
                        Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(id));
                    }
                } else if (fragment.r) {
                    throw new IllegalArgumentException(attrs.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(id) + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId) + " with another fragment for " + fname);
                } else {
                    fragment.r = true;
                    dc dcVar2 = this.a;
                    fragment.v = dcVar2;
                    fragment.w = dcVar2.t0();
                    fragment.u0(this.a.t0().k(), attrs, fragment.d);
                    fragmentStateManager = this.a.v(fragment);
                    if (dc.F0(2)) {
                        Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(id));
                    }
                }
                fragment.J = (ViewGroup) parent;
                fragmentStateManager.m();
                fragmentStateManager.j();
                View view = fragment.K;
                if (view == null) {
                    throw new IllegalStateException("Fragment " + fname + " did not create a view.");
                }
                if (id != 0) {
                    view.setId(id);
                }
                if (fragment.K.getTag() == null) {
                    fragment.K.setTag(tag);
                }
                fragment.K.addOnAttachStateChangeListener(new a(fragmentStateManager));
                return fragment.K;
            }
            throw new IllegalArgumentException(attrs.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        }
        return null;
    }

    /* compiled from: FragmentLayoutInflaterFactory.java */
    /* renamed from: bc$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ kc a;

        public a(kc kcVar) {
            this.a = kcVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Fragment fragment = this.a.k();
            this.a.m();
            sc controller = sc.n((ViewGroup) fragment.K.getParent(), bc.this.a);
            controller.j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
        }
    }
}
