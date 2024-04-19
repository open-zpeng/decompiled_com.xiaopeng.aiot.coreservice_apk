package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.irdeto.securesdk.core.SSUtils;
import com.lzy.okgo.model.Progress;
import com.xiaopeng.lib.apirouter.ClientConstants;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DBHelper.java */
/* renamed from: fl  reason: default package */
/* loaded from: classes.dex */
public class fl extends SQLiteOpenHelper {
    public static final Lock a = new ReentrantLock();
    public hl b;
    public hl c;
    public hl d;
    public hl e;

    public fl() {
        this(lk.h().f());
    }

    public fl(Context context) {
        super(context, "okgo.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.b = new hl(SSUtils.O00000o0);
        this.c = new hl("cookie");
        this.d = new hl("download");
        this.e = new hl("upload");
        this.b.a(new el("key", "VARCHAR", true, true)).a(new el("localExpire", "INTEGER")).a(new el("head", "BLOB")).a(new el("data", "BLOB"));
        this.c.a(new el("host", "VARCHAR")).a(new el(ClientConstants.ALIAS.P_NAME, "VARCHAR")).a(new el("domain", "VARCHAR")).a(new el("cookie", "BLOB")).a(new el("host", ClientConstants.ALIAS.P_NAME, "domain"));
        this.d.a(new el(Progress.TAG, "VARCHAR", true, true)).a(new el(Progress.URL, "VARCHAR")).a(new el(Progress.FOLDER, "VARCHAR")).a(new el(Progress.FILE_PATH, "VARCHAR")).a(new el(Progress.FILE_NAME, "VARCHAR")).a(new el(Progress.FRACTION, "VARCHAR")).a(new el(Progress.TOTAL_SIZE, "INTEGER")).a(new el(Progress.CURRENT_SIZE, "INTEGER")).a(new el(Progress.STATUS, "INTEGER")).a(new el(Progress.PRIORITY, "INTEGER")).a(new el(Progress.DATE, "INTEGER")).a(new el(Progress.REQUEST, "BLOB")).a(new el(Progress.EXTRA1, "BLOB")).a(new el(Progress.EXTRA2, "BLOB")).a(new el(Progress.EXTRA3, "BLOB"));
        this.e.a(new el(Progress.TAG, "VARCHAR", true, true)).a(new el(Progress.URL, "VARCHAR")).a(new el(Progress.FOLDER, "VARCHAR")).a(new el(Progress.FILE_PATH, "VARCHAR")).a(new el(Progress.FILE_NAME, "VARCHAR")).a(new el(Progress.FRACTION, "VARCHAR")).a(new el(Progress.TOTAL_SIZE, "INTEGER")).a(new el(Progress.CURRENT_SIZE, "INTEGER")).a(new el(Progress.STATUS, "INTEGER")).a(new el(Progress.PRIORITY, "INTEGER")).a(new el(Progress.DATE, "INTEGER")).a(new el(Progress.REQUEST, "BLOB")).a(new el(Progress.EXTRA1, "BLOB")).a(new el(Progress.EXTRA2, "BLOB")).a(new el(Progress.EXTRA3, "BLOB"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.b.b());
        db.execSQL(this.c.b());
        db.execSQL(this.d.b());
        db.execSQL(this.e.b());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (gl.a(db, this.b)) {
            db.execSQL("DROP TABLE IF EXISTS cache");
        }
        if (gl.a(db, this.c)) {
            db.execSQL("DROP TABLE IF EXISTS cookie");
        }
        if (gl.a(db, this.d)) {
            db.execSQL("DROP TABLE IF EXISTS download");
        }
        if (gl.a(db, this.e)) {
            db.execSQL("DROP TABLE IF EXISTS upload");
        }
        onCreate(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
