package defpackage;

import android.os.Build;
import android.os.CancellationSignal;
/* compiled from: CancellationSignal.java */
/* renamed from: t8  reason: default package */
/* loaded from: classes.dex */
public final class t8 {
    public boolean a;
    public a b;
    public Object c;
    public boolean d;

    /* compiled from: CancellationSignal.java */
    /* renamed from: t8$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            a listener = this.b;
            Object obj = this.c;
            if (listener != null) {
                try {
                    listener.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public void c(a listener) {
        synchronized (this) {
            d();
            if (this.b == listener) {
                return;
            }
            this.b = listener;
            if (this.a && listener != null) {
                listener.a();
            }
        }
    }

    public final void d() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
