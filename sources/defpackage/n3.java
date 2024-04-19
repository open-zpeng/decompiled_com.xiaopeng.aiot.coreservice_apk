package defpackage;

import android.content.res.ColorStateList;
/* compiled from: CardViewApi21Impl.java */
/* renamed from: n3  reason: default package */
/* loaded from: classes.dex */
public class n3 implements q3 {
    @Override // defpackage.q3
    public void c(p3 cardView, float radius) {
        n(cardView).h(radius);
    }

    @Override // defpackage.q3
    public void e() {
    }

    @Override // defpackage.q3
    public void m(p3 cardView, float maxElevation) {
        n(cardView).g(maxElevation, cardView.e(), cardView.d());
        o(cardView);
    }

    @Override // defpackage.q3
    public float a(p3 cardView) {
        return n(cardView).c();
    }

    @Override // defpackage.q3
    public float h(p3 cardView) {
        return f(cardView) * 2.0f;
    }

    @Override // defpackage.q3
    public float g(p3 cardView) {
        return f(cardView) * 2.0f;
    }

    @Override // defpackage.q3
    public float f(p3 cardView) {
        return n(cardView).d();
    }

    @Override // defpackage.q3
    public void j(p3 cardView, float elevation) {
        cardView.a().setElevation(elevation);
    }

    @Override // defpackage.q3
    public float d(p3 cardView) {
        return cardView.a().getElevation();
    }

    public void o(p3 cardView) {
        if (!cardView.e()) {
            cardView.b(0, 0, 0, 0);
            return;
        }
        float elevation = a(cardView);
        float radius = f(cardView);
        int hPadding = (int) Math.ceil(s3.c(elevation, radius, cardView.d()));
        int vPadding = (int) Math.ceil(s3.d(elevation, radius, cardView.d()));
        cardView.b(hPadding, vPadding, hPadding, vPadding);
    }

    @Override // defpackage.q3
    public void i(p3 cardView) {
        m(cardView, a(cardView));
    }

    @Override // defpackage.q3
    public void k(p3 cardView) {
        m(cardView, a(cardView));
    }

    @Override // defpackage.q3
    public void l(p3 cardView, ColorStateList color) {
        n(cardView).f(color);
    }

    @Override // defpackage.q3
    public ColorStateList b(p3 cardView) {
        return n(cardView).b();
    }

    public final r3 n(p3 cardView) {
        return (r3) cardView.f();
    }
}
