package defpackage;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import defpackage.gs;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* renamed from: js  reason: default package */
/* loaded from: classes.dex */
public final class js extends gs {
    public final Handler b;
    public final boolean c;

    public js(Handler handler, boolean async) {
        this.b = handler;
        this.c = async;
    }

    @Override // defpackage.gs
    @SuppressLint({"NewApi"})
    public ls c(Runnable run, long delay, TimeUnit unit) {
        if (run == null) {
            throw new NullPointerException("run == null");
        }
        if (unit == null) {
            throw new NullPointerException("unit == null");
        }
        b scheduled = new b(this.b, iv.o(run));
        Message message = Message.obtain(this.b, scheduled);
        if (this.c) {
            message.setAsynchronous(true);
        }
        this.b.sendMessageDelayed(message, unit.toMillis(delay));
        return scheduled;
    }

    @Override // defpackage.gs
    public gs.b a() {
        return new a(this.b, this.c);
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: js$a */
    /* loaded from: classes.dex */
    public static final class a extends gs.b {
        public final Handler a;
        public final boolean b;
        public volatile boolean d;

        public a(Handler handler, boolean async) {
            this.a = handler;
            this.b = async;
        }

        @Override // defpackage.gs.b
        @SuppressLint({"NewApi"})
        public ls d(Runnable run, long delay, TimeUnit unit) {
            if (run == null) {
                throw new NullPointerException("run == null");
            }
            if (unit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.d) {
                return ms.a();
            }
            b scheduled = new b(this.a, iv.o(run));
            Message message = Message.obtain(this.a, scheduled);
            message.obj = this;
            if (this.b) {
                message.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(message, unit.toMillis(delay));
            if (this.d) {
                this.a.removeCallbacks(scheduled);
                return ms.a();
            }
            return scheduled;
        }

        @Override // defpackage.ls
        public void a() {
            this.d = true;
            this.a.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: js$b */
    /* loaded from: classes.dex */
    public static final class b implements Runnable, ls {
        public final Handler a;
        public final Runnable b;
        public volatile boolean d;

        public b(Handler handler, Runnable delegate) {
            this.a = handler;
            this.b = delegate;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable t) {
                iv.m(t);
            }
        }

        @Override // defpackage.ls
        public void a() {
            this.a.removeCallbacks(this);
            this.d = true;
        }
    }
}
