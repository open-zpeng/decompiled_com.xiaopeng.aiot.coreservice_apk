package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.s3;
/* compiled from: CardViewBaseImpl.java */
/* renamed from: o3  reason: default package */
/* loaded from: classes.dex */
public class o3 implements q3 {
    public final RectF a = new RectF();

    /* compiled from: CardViewBaseImpl.java */
    /* renamed from: o3$a */
    /* loaded from: classes.dex */
    public class a implements s3.a {
        public a() {
        }

        @Override // defpackage.s3.a
        public void a(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
            float twoRadius = cornerRadius * 2.0f;
            float innerWidth = (bounds.width() - twoRadius) - 1.0f;
            float innerHeight = (bounds.height() - twoRadius) - 1.0f;
            if (cornerRadius >= 1.0f) {
                float roundedCornerRadius = cornerRadius + 0.5f;
                o3.this.a.set(-roundedCornerRadius, -roundedCornerRadius, roundedCornerRadius, roundedCornerRadius);
                int saved = canvas.save();
                canvas.translate(bounds.left + roundedCornerRadius, bounds.top + roundedCornerRadius);
                canvas.drawArc(o3.this.a, 180.0f, 90.0f, true, paint);
                canvas.translate(innerWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(o3.this.a, 180.0f, 90.0f, true, paint);
                canvas.translate(innerHeight, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(o3.this.a, 180.0f, 90.0f, true, paint);
                canvas.translate(innerWidth, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(o3.this.a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(saved);
                float f = bounds.top;
                canvas.drawRect((bounds.left + roundedCornerRadius) - 1.0f, f, (bounds.right - roundedCornerRadius) + 1.0f, f + roundedCornerRadius, paint);
                float f2 = bounds.bottom;
                canvas.drawRect((bounds.left + roundedCornerRadius) - 1.0f, f2 - roundedCornerRadius, (bounds.right - roundedCornerRadius) + 1.0f, f2, paint);
            }
            canvas.drawRect(bounds.left, bounds.top + cornerRadius, bounds.right, bounds.bottom - cornerRadius, paint);
        }
    }

    @Override // defpackage.q3
    public void e() {
        s3.b = new a();
    }

    public void o(p3 cardView) {
        Rect shadowPadding = new Rect();
        n(cardView).h(shadowPadding);
        cardView.c((int) Math.ceil(h(cardView)), (int) Math.ceil(g(cardView)));
        cardView.b(shadowPadding.left, shadowPadding.top, shadowPadding.right, shadowPadding.bottom);
    }

    @Override // defpackage.q3
    public void i(p3 cardView) {
    }

    @Override // defpackage.q3
    public void k(p3 cardView) {
        n(cardView).m(cardView.d());
        o(cardView);
    }

    @Override // defpackage.q3
    public void l(p3 cardView, ColorStateList color) {
        n(cardView).o(color);
    }

    @Override // defpackage.q3
    public ColorStateList b(p3 cardView) {
        return n(cardView).f();
    }

    @Override // defpackage.q3
    public void c(p3 cardView, float radius) {
        n(cardView).p(radius);
        o(cardView);
    }

    @Override // defpackage.q3
    public float f(p3 cardView) {
        return n(cardView).g();
    }

    @Override // defpackage.q3
    public void j(p3 cardView, float elevation) {
        n(cardView).r(elevation);
    }

    @Override // defpackage.q3
    public float d(p3 cardView) {
        return n(cardView).l();
    }

    @Override // defpackage.q3
    public void m(p3 cardView, float maxElevation) {
        n(cardView).q(maxElevation);
        o(cardView);
    }

    @Override // defpackage.q3
    public float a(p3 cardView) {
        return n(cardView).i();
    }

    @Override // defpackage.q3
    public float h(p3 cardView) {
        return n(cardView).k();
    }

    @Override // defpackage.q3
    public float g(p3 cardView) {
        return n(cardView).j();
    }

    public final s3 n(p3 cardView) {
        return (s3) cardView.f();
    }
}
