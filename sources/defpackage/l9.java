package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import defpackage.ra;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: l9  reason: default package */
/* loaded from: classes.dex */
public class l9 {
    public static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate b;
    public final View.AccessibilityDelegate c;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: l9$a */
    /* loaded from: classes.dex */
    public static final class a extends View.AccessibilityDelegate {
        public final l9 a;

        public a(l9 compat) {
            this.a = compat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.a.a(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.a.f(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            ra nodeInfoCompat = ra.P(info);
            nodeInfoCompat.L(ga.L(host));
            nodeInfoCompat.J(ga.H(host));
            nodeInfoCompat.K(ga.m(host));
            nodeInfoCompat.N(ga.B(host));
            this.a.g(host, nodeInfoCompat);
            nodeInfoCompat.c(info.getText(), host);
            List<ra.a> c = l9.c(host);
            for (int i = 0; i < c.size(); i++) {
                nodeInfoCompat.a(c.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.a.h(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.a.i(host, child, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View host, int eventType) {
            this.a.l(host, eventType);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.a.m(host, event);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            sa provider = this.a.b(host);
            if (provider != null) {
                return (AccessibilityNodeProvider) provider.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            return this.a.j(host, action, args);
        }
    }

    public l9() {
        this(a);
    }

    public l9(View.AccessibilityDelegate originalDelegate) {
        this.b = originalDelegate;
        this.c = new a(this);
    }

    public View.AccessibilityDelegate d() {
        return this.c;
    }

    public void l(View host, int eventType) {
        this.b.sendAccessibilityEvent(host, eventType);
    }

    public void m(View host, AccessibilityEvent event) {
        this.b.sendAccessibilityEventUnchecked(host, event);
    }

    public boolean a(View host, AccessibilityEvent event) {
        return this.b.dispatchPopulateAccessibilityEvent(host, event);
    }

    public void h(View host, AccessibilityEvent event) {
        this.b.onPopulateAccessibilityEvent(host, event);
    }

    public void f(View host, AccessibilityEvent event) {
        this.b.onInitializeAccessibilityEvent(host, event);
    }

    public void g(View host, ra info) {
        this.b.onInitializeAccessibilityNodeInfo(host, info.O());
    }

    public boolean i(ViewGroup host, View child, AccessibilityEvent event) {
        return this.b.onRequestSendAccessibilityEvent(host, child, event);
    }

    public sa b(View host) {
        Object provider;
        if (Build.VERSION.SDK_INT >= 16 && (provider = this.b.getAccessibilityNodeProvider(host)) != null) {
            return new sa(provider);
        }
        return null;
    }

    public boolean j(View host, int action, Bundle args) {
        boolean success = false;
        List<ra.a> c = c(host);
        int i = 0;
        while (true) {
            if (i >= c.size()) {
                break;
            }
            ra.a actionCompat = c.get(i);
            if (actionCompat.a() != action) {
                i++;
            } else {
                success = actionCompat.c(host, args);
                break;
            }
        }
        if (!success && Build.VERSION.SDK_INT >= 16) {
            success = this.b.performAccessibilityAction(host, action, args);
        }
        if (!success && action == x6.accessibility_action_clickable_span) {
            boolean success2 = k(args.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), host);
            return success2;
        }
        return success;
    }

    public final boolean k(int clickableSpanId, View host) {
        WeakReference<ClickableSpan> reference;
        SparseArray<WeakReference<ClickableSpan>> spans = (SparseArray) host.getTag(x6.tag_accessibility_clickable_spans);
        if (spans != null && (reference = spans.get(clickableSpanId)) != null) {
            ClickableSpan span = reference.get();
            if (e(span, host)) {
                span.onClick(host);
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean e(ClickableSpan span, View view) {
        if (span != null) {
            AccessibilityNodeInfo info = view.createAccessibilityNodeInfo();
            ClickableSpan[] spans = ra.l(info.getText());
            for (int i = 0; spans != null && i < spans.length; i++) {
                if (span.equals(spans[i])) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static List<ra.a> c(View view) {
        List<ra.a> list = (List) view.getTag(x6.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
