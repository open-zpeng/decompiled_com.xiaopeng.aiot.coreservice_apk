package defpackage;

import android.graphics.Typeface;
import android.os.Handler;
import defpackage.a9;
import defpackage.z8;
/* compiled from: CallbackWithHandler.java */
/* renamed from: v8  reason: default package */
/* loaded from: classes.dex */
public class v8 {
    public final a9.c a;
    public final Handler b;

    public v8(a9.c callback, Handler callbackHandler) {
        this.a = callback;
        this.b = callbackHandler;
    }

    /* compiled from: CallbackWithHandler.java */
    /* renamed from: v8$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ a9.c a;
        public final /* synthetic */ Typeface b;

        public a(a9.c cVar, Typeface typeface) {
            this.a = cVar;
            this.b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    public final void c(Typeface typeface) {
        a9.c callback = this.a;
        this.b.post(new a(callback, typeface));
    }

    /* compiled from: CallbackWithHandler.java */
    /* renamed from: v8$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ a9.c a;
        public final /* synthetic */ int b;

        public b(a9.c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public final void a(int reason) {
        a9.c callback = this.a;
        this.b.post(new b(callback, reason));
    }

    public void b(z8.e typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.a);
        } else {
            a(typefaceResult.b);
        }
    }
}
