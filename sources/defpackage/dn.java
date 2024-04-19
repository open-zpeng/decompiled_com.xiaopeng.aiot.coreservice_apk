package defpackage;

import android.content.Context;
import com.tencent.mmkv.MMKV;
/* compiled from: SpUtils.java */
/* renamed from: dn  reason: default package */
/* loaded from: classes.dex */
public class dn {
    public MMKV a;

    public String d(Context cx) {
        String path = MMKV.r(cx);
        this.a = MMKV.f();
        return path;
    }

    public dn() {
    }

    public static dn c() {
        return b.a;
    }

    /* compiled from: SpUtils.java */
    /* renamed from: dn$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final dn a = new dn();
    }

    public void b(String key, Object object) {
        if (object instanceof String) {
            this.a.n(key, (String) object);
        } else if (object instanceof Integer) {
            this.a.l(key, ((Integer) object).intValue());
        } else if (object instanceof Boolean) {
            this.a.p(key, ((Boolean) object).booleanValue());
        } else if (object instanceof Float) {
            this.a.k(key, ((Float) object).floatValue());
        } else if (object instanceof Long) {
            this.a.m(key, ((Long) object).longValue());
        } else if (object instanceof Double) {
            this.a.j(key, ((Double) object).doubleValue());
        } else if (object instanceof byte[]) {
            this.a.q(key, (byte[]) object);
        } else {
            this.a.n(key, object.toString());
        }
    }

    public String a(String key) {
        return this.a.c(key, "");
    }
}
