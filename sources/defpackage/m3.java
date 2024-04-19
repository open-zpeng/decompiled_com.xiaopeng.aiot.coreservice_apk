package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import defpackage.s3;
/* compiled from: CardViewApi17Impl.java */
/* renamed from: m3  reason: default package */
/* loaded from: classes.dex */
public class m3 extends o3 {

    /* compiled from: CardViewApi17Impl.java */
    /* renamed from: m3$a */
    /* loaded from: classes.dex */
    public class a implements s3.a {
        public a() {
        }

        @Override // defpackage.s3.a
        public void a(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
            canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
        }
    }

    @Override // defpackage.o3, defpackage.q3
    public void e() {
        s3.b = new a();
    }
}
