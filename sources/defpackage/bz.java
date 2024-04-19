package defpackage;

import android.os.Looper;
import defpackage.ez;
import defpackage.fz;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: EventBusBuilder.java */
/* renamed from: bz  reason: default package */
/* loaded from: classes.dex */
public class bz {
    public static final ExecutorService a = Executors.newCachedThreadPool();
    public boolean f;
    public boolean h;
    public boolean i;
    public List<rz> k;
    public ez l;
    public fz m;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public boolean g = true;
    public ExecutorService j = a;

    public bz g(boolean logSubscriberExceptions) {
        this.b = logSubscriberExceptions;
        return this;
    }

    public bz f(boolean logNoSubscriberMessages) {
        this.c = logNoSubscriberMessages;
        return this;
    }

    public bz h(boolean sendNoSubscriberEvent) {
        this.e = sendNoSubscriberEvent;
        return this;
    }

    public ez c() {
        ez ezVar = this.l;
        if (ezVar != null) {
            return ezVar;
        }
        return ez.a.a();
    }

    public fz d() {
        Object looperOrNull;
        fz fzVar = this.m;
        if (fzVar != null) {
            return fzVar;
        }
        if (!pz.c() || (looperOrNull = b()) == null) {
            return null;
        }
        return new fz.a((Looper) looperOrNull);
    }

    public static Object b() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public az e() {
        az azVar;
        synchronized (az.class) {
            if (az.b != null) {
                throw new cz("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            az.b = a();
            azVar = az.b;
        }
        return azVar;
    }

    public az a() {
        return new az(this);
    }
}
