package defpackage;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* compiled from: XTouchDelegate.java */
/* renamed from: ar  reason: default package */
/* loaded from: classes.dex */
public class ar extends TouchDelegate {
    public View a;

    public ar(Rect bounds, View delegateView) {
        super(bounds, delegateView);
        this.a = delegateView;
    }

    public View a() {
        return this.a;
    }
}
