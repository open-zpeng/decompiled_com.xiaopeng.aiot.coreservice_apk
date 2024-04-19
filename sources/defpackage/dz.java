package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* compiled from: HandlerPoster.java */
/* renamed from: dz  reason: default package */
/* loaded from: classes.dex */
public class dz extends Handler implements jz {
    public final iz a;
    public final int b;
    public final az d;
    public boolean f;

    public dz(az eventBus, Looper looper, int maxMillisInsideHandleMessage) {
        super(looper);
        this.d = eventBus;
        this.b = maxMillisInsideHandleMessage;
        this.a = new iz();
    }

    @Override // defpackage.jz
    public void a(oz subscription, Object event) {
        hz pendingPost = hz.a(subscription, event);
        synchronized (this) {
            this.a.a(pendingPost);
            if (!this.f) {
                this.f = true;
                if (!sendMessage(obtainMessage())) {
                    throw new cz("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        long timeInMethod;
        boolean rescheduled = false;
        try {
            long started = SystemClock.uptimeMillis();
            do {
                hz pendingPost = this.a.b();
                if (pendingPost == null) {
                    synchronized (this) {
                        pendingPost = this.a.b();
                        if (pendingPost == null) {
                            this.f = false;
                            return;
                        }
                    }
                }
                this.d.i(pendingPost);
                timeInMethod = SystemClock.uptimeMillis() - started;
            } while (timeInMethod < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new cz("Could not send handler message");
            }
            rescheduled = true;
        } finally {
            this.f = rescheduled;
        }
    }
}
