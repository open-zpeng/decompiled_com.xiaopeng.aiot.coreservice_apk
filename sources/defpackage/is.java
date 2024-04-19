package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* renamed from: is  reason: default package */
/* loaded from: classes.dex */
public final class is {
    public static final gs a = hs.d(new a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: is$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static final gs a = new js(new Handler(Looper.getMainLooper()), false);
    }

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: is$a */
    /* loaded from: classes.dex */
    public static class a implements Callable<gs> {
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public gs call() throws Exception {
            return b.a;
        }
    }

    public static gs a() {
        return hs.e(a);
    }

    public is() {
        throw new AssertionError("No instances.");
    }
}
