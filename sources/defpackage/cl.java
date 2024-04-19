package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
/* compiled from: BaseDao.java */
/* renamed from: cl  reason: default package */
/* loaded from: classes.dex */
public abstract class cl<T> {
    public static String a;
    public Lock b;
    public SQLiteOpenHelper c;
    public SQLiteDatabase d;

    public abstract ContentValues c(T t);

    public abstract String d();

    public abstract T f(Cursor cursor);

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public cl(SQLiteOpenHelper helper) {
        a = getClass().getSimpleName();
        this.b = fl.a;
        this.c = helper;
        this.d = e();
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public SQLiteDatabase e() {
        return this.c.getWritableDatabase();
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public final void a(SQLiteDatabase database, Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (database == null || !database.isOpen()) {
            return;
        }
        database.close();
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public boolean b(String whereClause, String[] whereArgs) {
        String str;
        long start = System.currentTimeMillis();
        this.b.lock();
        try {
            try {
                this.d.beginTransaction();
                this.d.delete(d(), whereClause, whereArgs);
                this.d.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                wl.a(e);
                this.d.endTransaction();
                this.b.unlock();
                String str2 = a;
                wl.b(str2, (System.currentTimeMillis() - start) + " delete");
                return false;
            }
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            str = a;
            wl.b(str, (System.currentTimeMillis() - start) + " delete");
        }
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public boolean i(T t) {
        String str;
        if (t == null) {
            return false;
        }
        long start = System.currentTimeMillis();
        this.b.lock();
        try {
            this.d.beginTransaction();
            this.d.replace(d(), null, c(t));
            this.d.setTransactionSuccessful();
            return true;
        } catch (Exception e) {
            wl.a(e);
            return false;
        } finally {
            this.d.endTransaction();
            this.b.unlock();
            str = a;
            wl.b(str, (System.currentTimeMillis() - start) + " replaceT");
        }
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public List<T> g(String selection, String[] selectionArgs) {
        return h(null, selection, selectionArgs, null, null, null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: cl != com.lzy.okgo.db.BaseDao<T> */
    public List<T> h(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        String str;
        StringBuilder sb;
        long start = System.currentTimeMillis();
        this.b.lock();
        List<T> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                this.d.beginTransaction();
                cursor = this.d.query(d(), columns, selection, selectionArgs, groupBy, having, orderBy, limit);
                while (!cursor.isClosed() && cursor.moveToNext()) {
                    list.add(f(cursor));
                }
                this.d.setTransactionSuccessful();
                a(null, cursor);
                this.d.endTransaction();
                this.b.unlock();
                str = a;
                sb = new StringBuilder();
            } catch (Exception e) {
                wl.a(e);
                a(null, cursor);
                this.d.endTransaction();
                this.b.unlock();
                str = a;
                sb = new StringBuilder();
            }
            sb.append(System.currentTimeMillis() - start);
            sb.append(" query");
            wl.b(str, sb.toString());
            return list;
        } catch (Throwable th) {
            a(null, cursor);
            this.d.endTransaction();
            this.b.unlock();
            String str2 = a;
            wl.b(str2, (System.currentTimeMillis() - start) + " query");
            throw th;
        }
    }
}
