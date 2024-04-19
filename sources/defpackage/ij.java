package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.lzy.okgo.model.Progress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: LogSqliteStore.java */
/* renamed from: ij  reason: default package */
/* loaded from: classes.dex */
public class ij implements hj {
    public String a = "SELECT * FROM %s ORDER BY %s ASC LIMIT %s";
    public String b = "SELECT count(*) FROM %s";
    public String c = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
    public a d;

    public ij(Context context) {
        this.d = new a(context);
    }

    @Override // defpackage.hj
    /* renamed from: a */
    public synchronized boolean mo50a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z = true;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase sQLiteDatabase = null;
                boolean z2 = false;
                try {
                    sQLiteDatabase = this.d.getWritableDatabase();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.beginTransaction();
                        int i = 0;
                        while (true) {
                            try {
                                if (i >= list.size()) {
                                    break;
                                }
                                com.alibaba.mtl.log.model.a aVar = list.get(i);
                                if (aVar != null) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("eventId", aVar.T);
                                    contentValues.put(Progress.PRIORITY, aVar.U);
                                    contentValues.put("content", aVar.l());
                                    contentValues.put("time", aVar.W);
                                    contentValues.put("_index", aVar.X);
                                    long insert = sQLiteDatabase.insert("log", "", contentValues);
                                    if (insert == -1) {
                                        z = false;
                                        break;
                                    }
                                    vj.c("UTSqliteLogStore", "[insert] ", aVar.X, " isSuccess:", true, "ret", Long.valueOf(insert));
                                }
                                i++;
                            } catch (Throwable th) {
                                th = th;
                                vj.b("UTSqliteLogStore", "insert error", th);
                                di.d(th);
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.setTransactionSuccessful();
                                    } catch (Throwable th2) {
                                    }
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable th3) {
                                    }
                                }
                                this.d.a(sQLiteDatabase);
                                z2 = z;
                                return z2;
                            }
                        }
                        z2 = z;
                    } else {
                        vj.c("UTSqliteLogStore", "db is null");
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable th4) {
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th5) {
                        }
                    }
                    this.d.a(sQLiteDatabase);
                } catch (Throwable th6) {
                    th = th6;
                    z = false;
                }
                return z2;
            }
        }
        return true;
    }

    @Override // defpackage.hj
    public synchronized int a(List<com.alibaba.mtl.log.model.a> list) {
        boolean z;
        int i;
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.beginTransaction();
                    i = 0;
                    z = true;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        long delete = writableDatabase.delete("log", "_id=?", new String[]{list.get(i2).id + ""});
                        if (delete <= 0) {
                            vj.c("UTSqliteLogStore", "[delete]  ", Integer.valueOf(list.get(i2).id), " ret:", Long.valueOf(delete));
                            z = false;
                        } else if (!"6005".equalsIgnoreCase(list.get(i2).T)) {
                            i++;
                        }
                    }
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable th) {
                    }
                    try {
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                    }
                    this.d.a(writableDatabase);
                } else {
                    vj.c("UTSqliteLogStore", "db is null");
                    z = false;
                    i = 0;
                }
                vj.c("UTSqliteLogStore", "delete ", Integer.valueOf(list.size()), " isSuccess:", Boolean.valueOf(z));
                return i;
            }
        }
        return 0;
    }

    @Override // defpackage.hj
    /* renamed from: e */
    public synchronized ArrayList<com.alibaba.mtl.log.model.a> a(String str, int i) {
        ArrayList<com.alibaba.mtl.log.model.a> arrayList = null;
        if (i <= 0) {
            return (ArrayList) Collections.EMPTY_LIST;
        }
        ArrayList<com.alibaba.mtl.log.model.a> arrayList2 = new ArrayList<>(i);
        try {
            SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
            if (writableDatabase != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM ");
                sb.append("log");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(" WHERE ");
                    sb.append(str);
                }
                sb.append(" ORDER BY ");
                sb.append("time");
                sb.append(" ASC ");
                sb.append(" LIMIT ");
                sb.append(i + "");
                String sb2 = sb.toString();
                vj.c("UTSqliteLogStore", "sql:" + sb2);
                Cursor rawQuery = writableDatabase.rawQuery(sb2, null);
                while (rawQuery != null && rawQuery.moveToNext()) {
                    com.alibaba.mtl.log.model.a aVar = new com.alibaba.mtl.log.model.a();
                    vj.c("UTSqliteLogStore", "pos", Integer.valueOf(rawQuery.getPosition()), "count", Integer.valueOf(rawQuery.getCount()));
                    aVar.id = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                    aVar.T = rawQuery.getString(rawQuery.getColumnIndex("eventId"));
                    aVar.U = rawQuery.getString(rawQuery.getColumnIndex(Progress.PRIORITY));
                    aVar.k(rawQuery.getString(rawQuery.getColumnIndex("content")));
                    aVar.W = rawQuery.getString(rawQuery.getColumnIndex("time"));
                    try {
                        aVar.X = rawQuery.getString(rawQuery.getColumnIndex("_index"));
                    } catch (Throwable th) {
                    }
                    arrayList2.add(aVar);
                }
                f(rawQuery);
                this.d.a(writableDatabase);
            } else {
                vj.c("UTSqliteLogStore", "db is null");
            }
        } catch (Throwable th2) {
            arrayList = arrayList2;
            arrayList2 = arrayList;
            return arrayList2;
        }
        return arrayList2;
    }

    @Override // defpackage.hj
    public synchronized int c() {
        int i;
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        i = 0;
        if (writableDatabase != null) {
            Cursor rawQuery = writableDatabase.rawQuery(String.format(this.b, "log"), null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            f(rawQuery);
            this.d.a(writableDatabase);
        } else {
            vj.c("UTSqliteLogStore", "db is null");
        }
        return i;
    }

    @Override // defpackage.hj
    public synchronized void clear() {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", null, null);
            this.d.a(writableDatabase);
        }
    }

    /* compiled from: LogSqliteStore.java */
    /* renamed from: ij$a */
    /* loaded from: classes.dex */
    public class a extends SQLiteOpenHelper {
        public AtomicInteger a;
        public SQLiteDatabase b;

        public a(Context context) {
            super(context, "ut.db", (SQLiteDatabase.CursorFactory) null, 2);
            this.a = new AtomicInteger();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            Cursor cursor = null;
            try {
                cursor = db.rawQuery("PRAGMA journal_mode=DELETE", null);
            } catch (Throwable th) {
            }
            ij.this.f(cursor);
            super.onOpen(db);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion == 1 && newVersion == 2) {
                try {
                    db.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
                } catch (Throwable th) {
                    vj.b("UTSqliteLogStore", "DB Upgrade Error", th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            try {
                if (this.a.incrementAndGet() == 1) {
                    this.b = super.getWritableDatabase();
                }
            }
            return this.b;
        }

        public synchronized void a(SQLiteDatabase sQLiteDatabase) {
            SQLiteDatabase sQLiteDatabase2;
            if (sQLiteDatabase == null) {
                return;
            }
            try {
                if (this.a.decrementAndGet() == 0 && (sQLiteDatabase2 = this.b) != null) {
                    sQLiteDatabase2.close();
                    this.b = null;
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // defpackage.hj
    public synchronized void b(String str, String str2) {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("log", str + " < ?", new String[]{String.valueOf(str2)});
            this.d.a(writableDatabase);
        } else {
            vj.c("UTSqliteLogStore", "db is null");
        }
    }

    @Override // defpackage.hj
    public void d(int i) {
        if (i <= 0) {
            return;
        }
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (writableDatabase != null) {
            try {
                writableDatabase.execSQL(String.format(this.c, Integer.valueOf(i)));
            } catch (Throwable th) {
            }
            this.d.a(writableDatabase);
            return;
        }
        vj.c("UTSqliteLogStore", "db is null");
    }

    public final void f(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
            }
        }
    }
}
