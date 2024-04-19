package defpackage;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* compiled from: VuiView.java */
/* renamed from: dr  reason: default package */
/* loaded from: classes.dex */
public interface dr {
    public static final SparseArray<a> e = new SparseArray<>();

    default void e(View view, AttributeSet attrs) {
        if (!cp.d() || view == null || attrs == null) {
            return;
        }
        a xAttr = new a();
        TypedArray ta = view.getContext().obtainStyledAttributes(attrs, bp.Q3);
        xAttr.a = ta.getString(bp.R3);
        xAttr.b = gr.a(ta.getInteger(bp.V3, -1));
        if (xAttr.b == oo.UNKNOWN) {
            xAttr.b = hr.a(view);
        }
        xAttr.k = Integer.valueOf(ta.getInteger(bp.d4, -1));
        xAttr.c = ta.getString(bp.X3);
        xAttr.d = ta.getString(bp.a4);
        xAttr.j = ta.getString(bp.Y3);
        xAttr.e = ta.getString(bp.U3);
        xAttr.f = ta.getBoolean(bp.b4, false);
        xAttr.g = gr.d(ta.getInteger(bp.c4, 4));
        xAttr.h = ta.getString(bp.S3);
        int priority = ta.getInt(bp.e4, 2);
        xAttr.i = gr.c(priority);
        xAttr.l = gr.b(ta.getInteger(bp.Z3, 1));
        xAttr.o = ta.getBoolean(bp.T3, false);
        xAttr.p = ta.getBoolean(bp.W3, false);
        ta.recycle();
        xAttr.s = view.getVisibility();
        xAttr.t = view.isSelected();
        SparseArray<a> sparseArray = e;
        synchronized (sparseArray) {
            sparseArray.put(hashCode(), xAttr);
        }
    }

    default a q() {
        a xAttr;
        SparseArray<a> sparseArray = e;
        synchronized (sparseArray) {
            xAttr = sparseArray.get(hashCode());
        }
        if (xAttr == null) {
            a("xAttr is null");
            a xAttr2 = new a();
            if (xAttr2.b == oo.UNKNOWN) {
                xAttr2.b = hr.a(this);
            }
            synchronized (sparseArray) {
                sparseArray.put(hashCode(), xAttr2);
            }
            return xAttr2;
        }
        return xAttr;
    }

    default boolean c() {
        a xAttr = q();
        return xAttr.f;
    }

    default void setVuiLayoutLoadable(boolean vuiLayoutLoadable) {
        a xAttr = q();
        xAttr.f = vuiLayoutLoadable;
    }

    default ro getVuiPriority() {
        a xAttr = q();
        return xAttr.i;
    }

    default void setVuiPriority(ro vuiPriority) {
        a xAttr = q();
        xAttr.i = vuiPriority;
    }

    default String getVuiAction() {
        a xAttr = q();
        return xAttr.a;
    }

    default void setVuiAction(String vuiAction) {
        a xAttr = q();
        xAttr.a = vuiAction;
    }

    default oo getVuiElementType() {
        a xAttr = q();
        return xAttr.b;
    }

    default void setVuiElementType(oo vuiElementType) {
        a xAttr = q();
        xAttr.b = vuiElementType;
    }

    default String getVuiFatherElementId() {
        a xAttr = q();
        return xAttr.c;
    }

    default void setVuiFatherElementId(String vuiFatherElementId) {
        a xAttr = q();
        xAttr.c = vuiFatherElementId;
    }

    default String getVuiFatherLabel() {
        a xAttr = q();
        return xAttr.j;
    }

    default void setVuiFatherLabel(String vuiFatherLabel) {
        a xAttr = q();
        xAttr.j = vuiFatherLabel;
    }

    default String getVuiLabel() {
        a xAttr = q();
        return xAttr.d;
    }

    default void setVuiLabel(String vuiLabel) {
        a xAttr = q();
        xAttr.d = vuiLabel;
        if (c() && (this instanceof View)) {
            m((View) this);
        }
    }

    default String getVuiElementId() {
        a xAttr = q();
        return xAttr.e;
    }

    default void setVuiElementId(String vuiElementId) {
        a xAttr = q();
        xAttr.e = vuiElementId;
    }

    default void setVuiPosition(int vuiPosition) {
        a xAttr = q();
        xAttr.k = Integer.valueOf(vuiPosition);
    }

    default int getVuiPosition() {
        a xAttr = q();
        return xAttr.k.intValue();
    }

    default void k() {
        SparseArray<a> sparseArray = e;
        synchronized (sparseArray) {
            sparseArray.remove(hashCode());
        }
    }

    default po getVuiFeedbackType() {
        a xAttr = q();
        return xAttr.l;
    }

    default void setVuiFeedbackType(po vuiFeedbackType) {
        a xAttr = q();
        xAttr.l = vuiFeedbackType;
    }

    default void setPerformVuiAction(boolean performVuiAction) {
        a xAttr = q();
        xAttr.m = performVuiAction;
    }

    default void setVuiProps(JSONObject vuiProps) {
        a xAttr = q();
        xAttr.n = vuiProps;
    }

    default JSONObject getVuiProps() {
        a xAttr = q();
        return xAttr.n;
    }

    default qo getVuiMode() {
        a xAttr = q();
        return xAttr.g;
    }

    default void setVuiMode(qo vuiMode) {
        a xAttr = q();
        xAttr.g = vuiMode;
    }

    default void setVuiBizId(String vuiBizId) {
        a xAttr = q();
        xAttr.h = vuiBizId;
    }

    default String getVuiBizId() {
        a xAttr = q();
        return xAttr.h;
    }

    default void setVuiDisableHitEffect(boolean vuiDisableHitEffect) {
        a xAttr = q();
        xAttr.o = vuiDisableHitEffect;
    }

    default boolean getVuiDisableHitEffect() {
        a xAttr = q();
        if (!xAttr.o && (no.SCROLLBYY.a().equals(xAttr.a) || no.SCROLLBYX.a().equals(xAttr.a))) {
            return true;
        }
        return xAttr.o;
    }

    default void setVuiValue(Object obj) {
        a xAttr = q();
        xAttr.q = obj;
    }

    default Object getVuiValue() {
        a xAttr = q();
        return xAttr.q;
    }

    default void setVuiElementChangedListener(ko listener) {
        a xAttr = q();
        xAttr.r = new WeakReference(listener);
    }

    default ko getVuiElementChangedListener() {
        a xAttr = q();
        if (xAttr.r != null) {
            synchronized (e) {
                if (xAttr.r == null) {
                    return null;
                }
                return (ko) xAttr.r.get();
            }
        }
        return null;
    }

    default void b(View view, int visibility) {
        a xAttr = q();
        if (xAttr.s != visibility) {
            if (rq.g(2)) {
                a("setVuiVisibility; xAttr.mVuiVisibility : " + tq.d(xAttr.s) + ",visibility " + tq.d(visibility));
            }
            xAttr.s = visibility;
            try {
                JSONObject props = getVuiProps();
                if (props != null && props.has("canVoiceControl")) {
                    boolean canVoiceControl = props.getBoolean("canVoiceControl");
                    if (canVoiceControl) {
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            m(view);
        }
    }

    default void l(View view, boolean selected) {
        a xAttr = q();
        if (xAttr.t == selected) {
            return;
        }
        xAttr.t = selected;
        String type = getVuiElementType().a();
        if (oo.CHECKBOX.a().equals(type) || oo.SWITCH.a().equals(type) || oo.RADIOBUTTON.a().equals(type)) {
            m(view);
        }
    }

    default void m(View view) {
        g(view, so.UPDATE_VIEW_ATTRIBUTE);
    }

    default void g(View view, so updateType) {
        ko listener = getVuiElementChangedListener();
        if (listener != null) {
            hr.b(listener, view, updateType);
        } else if (rq.g(2)) {
            a("listener is null");
        }
    }

    default void a(String msg) {
        rq.b("xpui", "%s %s hashCode:%s", getClass().getSimpleName(), msg, Integer.valueOf(hashCode()));
    }

    /* compiled from: VuiView.java */
    /* renamed from: dr$a */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public String h;
        public String j;
        public po l;
        public boolean m;
        public boolean o;
        public Object q;
        public volatile WeakReference<ko> r;
        public int s;
        public boolean t = false;
        public oo b = gr.a(-1);
        public Integer k = -1;
        public qo g = qo.NORMAL;
        public boolean p = false;
        public ro i = gr.c(2);
        public JSONObject n = null;
    }
}
