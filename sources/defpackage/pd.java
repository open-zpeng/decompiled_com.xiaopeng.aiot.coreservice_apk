package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ViewModel.java */
/* renamed from: pd  reason: default package */
/* loaded from: classes.dex */
public abstract class pd {
    public final Map<String, Object> a = new HashMap();
    public volatile boolean b = false;

    public void d() {
    }

    public final void a() {
        this.b = true;
        Map<String, Object> map = this.a;
        if (map != null) {
            synchronized (map) {
                for (Object value : this.a.values()) {
                    b(value);
                }
            }
        }
        d();
    }

    public <T> T c(String key) {
        T t;
        Map<String, Object> map = this.a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.a.get(key);
        }
        return t;
    }

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
