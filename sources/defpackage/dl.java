package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.irdeto.securesdk.core.SSUtils;
import java.util.List;
/* compiled from: CacheManager.java */
/* renamed from: dl  reason: default package */
/* loaded from: classes.dex */
public class dl extends cl<ok<?>> {
    public static dl l() {
        return b.a;
    }

    /* compiled from: CacheManager.java */
    /* renamed from: dl$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final dl a = new dl();
    }

    public dl() {
        super(new fl());
    }

    @Override // defpackage.cl
    /* renamed from: m */
    public ok<?> f(Cursor cursor) {
        return ok.h(cursor);
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<?> */
    @Override // defpackage.cl
    /* renamed from: k */
    public ContentValues c(ok<?> okVar) {
        return ok.b(okVar);
    }

    @Override // defpackage.cl
    public String d() {
        return SSUtils.O00000o0;
    }

    public ok<?> j(String key) {
        if (key == null) {
            return null;
        }
        List<ok<?>> g = g("key=?", new String[]{key});
        if (g.size() > 0) {
            return g.get(0);
        }
        return null;
    }

    public boolean n(String key) {
        if (key == null) {
            return false;
        }
        return b("key=?", new String[]{key});
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public <T> ok<T> o(String key, ok<T> okVar) {
        okVar.k(key);
        i(okVar);
        return okVar;
    }
}
