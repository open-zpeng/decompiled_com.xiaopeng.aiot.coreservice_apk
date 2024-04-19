package defpackage;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: NestedScrollingParentHelper.java */
/* renamed from: aa  reason: default package */
/* loaded from: classes.dex */
public class aa {
    public int a;
    public int b;

    public aa(ViewGroup viewGroup) {
    }

    public void b(View child, View target, int axes) {
        c(child, target, axes, 0);
    }

    public void c(View child, View target, int axes, int type) {
        if (type == 1) {
            this.b = axes;
        } else {
            this.a = axes;
        }
    }

    public int a() {
        return this.a | this.b;
    }

    public void d(View target) {
        e(target, 0);
    }

    public void e(View target, int type) {
        if (type == 1) {
            this.b = 0;
        } else {
            this.a = 0;
        }
    }
}
