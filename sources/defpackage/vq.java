package defpackage;

import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import defpackage.uq;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: XViewDelegateImpl.java */
/* renamed from: vq  reason: default package */
/* loaded from: classes.dex */
public class vq extends uq {
    public View a;
    public fo b;
    public yq c;
    public ArrayList<xq> d = new ArrayList<>();

    public vq(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes, Object extras) {
        xq font;
        this.a = view;
        if (cp.b() && (view instanceof TextView) && (font = xq.a((TextView) view, attrs, defStyleAttr, defStyleRes)) != null) {
            this.d.add(font);
        }
        if (!view.isInEditMode()) {
            this.b = fo.d(view.getContext(), attrs, defStyleAttr, defStyleRes, extras);
        }
    }

    @Override // defpackage.uq
    public void g(Configuration config) {
        Iterator<xq> it = this.d.iterator();
        while (it.hasNext()) {
            xq delegate = it.next();
            delegate.c(config);
        }
        fo foVar = this.b;
        if (foVar != null) {
            foVar.j(this.a, config);
        }
        yq yqVar = this.c;
        if (yqVar != null) {
            yqVar.c(config);
        }
    }

    @Override // defpackage.uq
    public void f() {
        Iterator<xq> it = this.d.iterator();
        while (it.hasNext()) {
            xq delegate = it.next();
            delegate.b();
        }
        fo foVar = this.b;
        if (foVar != null) {
            foVar.i(this.a);
        }
        yq yqVar = this.c;
        if (yqVar != null) {
            yqVar.b();
        }
    }

    @Override // defpackage.uq
    public void h() {
        Iterator<xq> it = this.d.iterator();
        while (it.hasNext()) {
            xq delegate = it.next();
            delegate.d();
        }
        fo foVar = this.b;
        if (foVar != null) {
            foVar.k(this.a);
        }
    }

    @Override // defpackage.uq
    public void i(uq.a callback) {
        if (callback != null && this.c == null) {
            this.c = new yq(this.a.getContext());
        }
        this.c.d(callback);
    }

    @Override // defpackage.uq
    public fo e() {
        return this.b;
    }
}
