package defpackage;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: SubscriberMethod.java */
/* renamed from: mz  reason: default package */
/* loaded from: classes.dex */
public class mz {
    public final Method a;
    public final ThreadMode b;
    public final Class<?> c;
    public final int d;
    public final boolean e;
    public String f;

    public mz(Method method, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        this.a = method;
        this.b = threadMode;
        this.c = eventType;
        this.d = priority;
        this.e = sticky;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof mz) {
            a();
            mz otherSubscriberMethod = (mz) other;
            otherSubscriberMethod.a();
            return this.f.equals(otherSubscriberMethod.f);
        }
        return false;
    }

    public final synchronized void a() {
        if (this.f == null) {
            StringBuilder builder = new StringBuilder(64);
            builder.append(this.a.getDeclaringClass().getName());
            builder.append('#');
            builder.append(this.a.getName());
            builder.append('(');
            builder.append(this.c.getName());
            this.f = builder.toString();
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
