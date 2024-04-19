package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.ua;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: ra  reason: default package */
/* loaded from: classes.dex */
public class ra {
    public static int a = 0;
    public final AccessibilityNodeInfo b;
    public int c = -1;
    public int d = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: ra$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(IRadioController.TEF663x_PCHANNEL, null, ua.b.class);
        public static final a j = new a(IInputController.KEYCODE_BACK_BUTTON, null, ua.b.class);
        public static final a k = new a(1024, null, ua.c.class);
        public static final a l = new a(2048, null, ua.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(Http2.INITIAL_MAX_FRAME_SIZE, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(OSSConstants.DEFAULT_STREAM_BUFFER_SIZE, null, ua.g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, ua.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        public final Object N;
        public final int O;
        public final Class<? extends ua.a> P;
        public final ua Q;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            int i2 = Build.VERSION.SDK_INT;
            w = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            if (i2 >= 23) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
            } else {
                accessibilityAction = null;
            }
            x = new a(accessibilityAction, 16908343, null, null, ua.e.class);
            y = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            z = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            A = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            B = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            C = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            D = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            E = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            F = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            G = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            H = new a(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, ua.f.class);
            I = new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, ua.d.class);
            J = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            K = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            L = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            M = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int actionId, CharSequence label) {
            this(null, actionId, label, null, null);
        }

        public a(Object action) {
            this(action, 0, null, null, null);
        }

        public a(int actionId, CharSequence label, Class<? extends ua.a> cls) {
            this(null, actionId, label, null, cls);
        }

        public a(Object action, int id, CharSequence label, ua command, Class<? extends ua.a> cls) {
            this.O = id;
            this.Q = command;
            if (Build.VERSION.SDK_INT >= 21 && action == null) {
                this.N = new AccessibilityNodeInfo.AccessibilityAction(id, label);
            } else {
                this.N = action;
            }
            this.P = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.N).getLabel();
            }
            return null;
        }

        public boolean c(View view, Bundle arguments) {
            if (this.Q != null) {
                ua.a viewCommandArgument = null;
                Class<? extends ua.a> cls = this.P;
                if (cls != null) {
                    try {
                        viewCommandArgument = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        viewCommandArgument.a(arguments);
                    } catch (Exception e2) {
                        Class<? extends ua.a> cls2 = this.P;
                        String className = cls2 == null ? "null" : cls2.getName();
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + className, e2);
                    }
                }
                return this.Q.a(view, viewCommandArgument);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.N;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a other = (a) obj;
            Object obj2 = this.N;
            if (obj2 == null) {
                if (other.N != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(other.N)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public ra(AccessibilityNodeInfo info) {
        this.b = info;
    }

    public static ra P(AccessibilityNodeInfo info) {
        return new ra(info);
    }

    public AccessibilityNodeInfo O() {
        return this.b;
    }

    public int h() {
        return this.b.getActions();
    }

    public final List<Integer> e(String key) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> list = this.b.getExtras().getIntegerArrayList(key);
        if (list == null) {
            ArrayList<Integer> list2 = new ArrayList<>();
            this.b.getExtras().putIntegerArrayList(key, list2);
            return list2;
        }
        return list;
    }

    public void a(a action) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.addAction((AccessibilityNodeInfo.AccessibilityAction) action.N);
        }
    }

    public boolean F(int action, Bundle arguments) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.b.performAction(action, arguments);
        }
        return false;
    }

    @Deprecated
    public void i(Rect outBounds) {
        this.b.getBoundsInParent(outBounds);
    }

    public void j(Rect outBounds) {
        this.b.getBoundsInScreen(outBounds);
    }

    public boolean v() {
        return this.b.isCheckable();
    }

    public boolean w() {
        return this.b.isChecked();
    }

    public boolean z() {
        return this.b.isFocusable();
    }

    public boolean A() {
        return this.b.isFocused();
    }

    public boolean E() {
        return this.b.isSelected();
    }

    public boolean x() {
        return this.b.isClickable();
    }

    public boolean B() {
        return this.b.isLongClickable();
    }

    public boolean y() {
        return this.b.isEnabled();
    }

    public boolean C() {
        return this.b.isPassword();
    }

    public boolean D() {
        return this.b.isScrollable();
    }

    public void M(boolean scrollable) {
        this.b.setScrollable(scrollable);
    }

    public CharSequence p() {
        return this.b.getPackageName();
    }

    public CharSequence k() {
        return this.b.getClassName();
    }

    public void I(CharSequence className) {
        this.b.setClassName(className);
    }

    public CharSequence r() {
        if (t()) {
            List<Integer> starts = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> ends = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> flags = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> ids = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            Spannable spannable = new SpannableString(TextUtils.substring(this.b.getText(), 0, this.b.getText().length()));
            for (int i = 0; i < starts.size(); i++) {
                spannable.setSpan(new pa(ids.get(i).intValue(), this, n().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), starts.get(i).intValue(), ends.get(i).intValue(), flags.get(i).intValue());
            }
            return spannable;
        }
        return this.b.getText();
    }

    public void c(CharSequence text, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 26) {
            d();
            G(view);
            ClickableSpan[] spans = l(text);
            if (spans != null && spans.length > 0) {
                n().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", x6.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> tagSpans = o(view);
                for (int i2 = 0; i2 < spans.length; i2++) {
                    int id = u(spans[i2], tagSpans);
                    tagSpans.put(id, new WeakReference<>(spans[i2]));
                    b(spans[i2], (Spanned) text, id);
                }
            }
        }
    }

    public final SparseArray<WeakReference<ClickableSpan>> o(View host) {
        SparseArray<WeakReference<ClickableSpan>> spans = q(host);
        if (spans == null) {
            SparseArray<WeakReference<ClickableSpan>> spans2 = new SparseArray<>();
            host.setTag(x6.tag_accessibility_clickable_spans, spans2);
            return spans2;
        }
        return spans;
    }

    public final SparseArray<WeakReference<ClickableSpan>> q(View host) {
        return (SparseArray) host.getTag(x6.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] l(CharSequence text) {
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            return (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class);
        }
        return null;
    }

    public final int u(ClickableSpan span, SparseArray<WeakReference<ClickableSpan>> spans) {
        if (spans != null) {
            for (int i = 0; i < spans.size(); i++) {
                ClickableSpan aSpan = spans.valueAt(i).get();
                if (span.equals(aSpan)) {
                    return spans.keyAt(i);
                }
            }
        }
        int i2 = a;
        a = i2 + 1;
        return i2;
    }

    public final boolean t() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    public final void b(ClickableSpan span, Spanned spanned, int id) {
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(span)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(span)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(span)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(id));
    }

    public final void G(View view) {
        SparseArray<WeakReference<ClickableSpan>> spans = q(view);
        if (spans != null) {
            List<Integer> toBeRemovedIndices = new ArrayList<>();
            for (int i = 0; i < spans.size(); i++) {
                if (spans.valueAt(i).get() == null) {
                    toBeRemovedIndices.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < toBeRemovedIndices.size(); i2++) {
                spans.remove(toBeRemovedIndices.get(i2).intValue());
            }
        }
    }

    public CharSequence m() {
        return this.b.getContentDescription();
    }

    public void N(CharSequence stateDescription) {
        if (s8.a()) {
            this.b.setStateDescription(stateDescription);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", stateDescription);
        }
    }

    public String s() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.b.getViewIdResourceName();
        }
        return null;
    }

    public List<a> f() {
        List<Object> actions = null;
        if (Build.VERSION.SDK_INT >= 21) {
            actions = this.b.getActionList();
        }
        if (actions != null) {
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> result = new ArrayList<>();
            int actionCount = actions.size();
            for (int i = 0; i < actionCount; i++) {
                Object action = actions.get(i);
                result.add(new a(action));
            }
            return result;
        }
        return Collections.emptyList();
    }

    public Bundle n() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.b.getExtras();
        }
        return new Bundle();
    }

    public void K(CharSequence paneTitle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.b.setPaneTitle(paneTitle);
        } else if (i >= 19) {
            this.b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paneTitle);
        }
    }

    public void L(boolean screenReaderFocusable) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setScreenReaderFocusable(screenReaderFocusable);
        } else {
            H(1, screenReaderFocusable);
        }
    }

    public void J(boolean isHeading) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b.setHeading(isHeading);
        } else {
            H(2, isHeading);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ra)) {
            return false;
        }
        ra other = (ra) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.b;
        if (accessibilityNodeInfo == null) {
            if (other.b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(other.b)) {
            return false;
        }
        if (this.d == other.d && this.c == other.c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        Rect bounds = new Rect();
        i(bounds);
        builder.append("; boundsInParent: " + bounds);
        j(bounds);
        builder.append("; boundsInScreen: " + bounds);
        builder.append("; packageName: ");
        builder.append(p());
        builder.append("; className: ");
        builder.append(k());
        builder.append("; text: ");
        builder.append(r());
        builder.append("; contentDescription: ");
        builder.append(m());
        builder.append("; viewId: ");
        builder.append(s());
        builder.append("; checkable: ");
        builder.append(v());
        builder.append("; checked: ");
        builder.append(w());
        builder.append("; focusable: ");
        builder.append(z());
        builder.append("; focused: ");
        builder.append(A());
        builder.append("; selected: ");
        builder.append(E());
        builder.append("; clickable: ");
        builder.append(x());
        builder.append("; longClickable: ");
        builder.append(B());
        builder.append("; enabled: ");
        builder.append(y());
        builder.append("; password: ");
        builder.append(C());
        builder.append("; scrollable: " + D());
        builder.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> f = f();
            for (int i = 0; i < f.size(); i++) {
                a action = f.get(i);
                String actionName = g(action.a());
                if (actionName.equals("ACTION_UNKNOWN") && action.b() != null) {
                    actionName = action.b().toString();
                }
                builder.append(actionName);
                if (i != f.size() - 1) {
                    builder.append(", ");
                }
            }
        } else {
            int actionBits = h();
            while (actionBits != 0) {
                int action2 = 1 << Integer.numberOfTrailingZeros(actionBits);
                actionBits &= ~action2;
                builder.append(g(action2));
                if (actionBits != 0) {
                    builder.append(", ");
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public final void H(int property, boolean value) {
        Bundle extras = n();
        if (extras != null) {
            int booleanProperties = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", (value ? property : 0) | (booleanProperties & (~property)));
        }
    }

    public static String g(int action) {
        switch (action) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case IRadioController.TEF663x_PCHANNEL /* 256 */:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case OSSConstants.DEFAULT_STREAM_BUFFER_SIZE /* 131072 */:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908342:
                return "ACTION_SHOW_ON_SCREEN";
            case 16908343:
                return "ACTION_SCROLL_TO_POSITION";
            case 16908344:
                return "ACTION_SCROLL_UP";
            case 16908345:
                return "ACTION_SCROLL_LEFT";
            case 16908346:
                return "ACTION_SCROLL_DOWN";
            case 16908347:
                return "ACTION_SCROLL_RIGHT";
            case 16908348:
                return "ACTION_CONTEXT_CLICK";
            case 16908349:
                return "ACTION_SET_PROGRESS";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908356:
                return "ACTION_SHOW_TOOLTIP";
            case 16908357:
                return "ACTION_HIDE_TOOLTIP";
            case 16908358:
                return "ACTION_PAGE_UP";
            case 16908359:
                return "ACTION_PAGE_DOWN";
            case 16908360:
                return "ACTION_PAGE_LEFT";
            case 16908361:
                return "ACTION_PAGE_RIGHT";
            case 16908362:
                return "ACTION_PRESS_AND_HOLD";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
