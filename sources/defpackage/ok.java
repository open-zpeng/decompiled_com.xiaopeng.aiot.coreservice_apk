package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.lzy.okgo.model.HttpHeaders;
import java.io.Serializable;
/* compiled from: CacheEntity.java */
/* renamed from: ok  reason: default package */
/* loaded from: classes.dex */
public class ok<T> implements Serializable {
    public String a;
    public long b;
    public HttpHeaders d;
    public T f;
    public boolean g;

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public String d() {
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public void k(String key) {
        this.a = key;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public HttpHeaders f() {
        return this.d;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public void m(HttpHeaders responseHeaders) {
        this.d = responseHeaders;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public T c() {
        return this.f;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public void i(T data) {
        this.f = data;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public long e() {
        return this.b;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public void l(long localExpire) {
        this.b = localExpire;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public boolean g() {
        return this.g;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public void j(boolean expire) {
        this.g = expire;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public boolean a(pk cacheMode, long cacheTime, long baseTime) {
        return cacheMode == pk.DEFAULT ? e() < baseTime : cacheTime != -1 && e() + cacheTime < baseTime;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public static <T> ContentValues b(ok<T> okVar) {
        ContentValues values = new ContentValues();
        values.put("key", okVar.d());
        values.put("localExpire", Long.valueOf(okVar.e()));
        values.put("head", vl.c(okVar.f()));
        values.put("data", vl.c(okVar.c()));
        return values;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> ok<T> h(Cursor cursor) {
        ok<T> okVar = (ok<T>) new ok();
        okVar.k(cursor.getString(cursor.getColumnIndex("key")));
        okVar.l(cursor.getLong(cursor.getColumnIndex("localExpire")));
        okVar.m((HttpHeaders) vl.d(cursor.getBlob(cursor.getColumnIndex("head"))));
        okVar.i(vl.d(cursor.getBlob(cursor.getColumnIndex("data"))));
        return okVar;
    }

    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    public String toString() {
        return "CacheEntity{key='" + this.a + "', responseHeaders=" + this.d + ", data=" + this.f + ", localExpire=" + this.b + '}';
    }
}
