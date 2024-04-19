package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import defpackage.nv;
import java.util.Iterator;
import java.util.UUID;
import org.eclipse.paho.android.service.MqttService;
/* compiled from: DatabaseMessageStore.java */
/* renamed from: mv  reason: default package */
/* loaded from: classes.dex */
public class mv implements nv {
    public SQLiteDatabase a = null;
    public c b;
    public sv c;

    /* compiled from: DatabaseMessageStore.java */
    /* renamed from: mv$c */
    /* loaded from: classes.dex */
    public static class c extends SQLiteOpenHelper {
        public sv a;

        public c(sv traceHandler, Context context) {
            super(context, "mqttAndroidService.db", (SQLiteDatabase.CursorFactory) null, 1);
            this.a = null;
            this.a = traceHandler;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase database) {
            sv svVar = this.a;
            svVar.traceDebug("MQTTDatabaseHelper", "onCreate {CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);}");
            try {
                database.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.a.traceDebug("MQTTDatabaseHelper", "created the table");
            } catch (SQLException e) {
                this.a.traceException("MQTTDatabaseHelper", "onCreate", e);
                throw e;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            this.a.traceDebug("MQTTDatabaseHelper", "onUpgrade");
            try {
                db.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(db);
                this.a.traceDebug("MQTTDatabaseHelper", "onUpgrade complete");
            } catch (SQLException e) {
                this.a.traceException("MQTTDatabaseHelper", "onUpgrade", e);
                throw e;
            }
        }
    }

    public mv(MqttService service, Context context) {
        this.b = null;
        this.c = null;
        this.c = service;
        this.b = new c(service, context);
        this.c.traceDebug("DatabaseMessageStore", "DatabaseMessageStore<init> complete");
    }

    @Override // defpackage.nv
    public String c(String clientHandle, String topic, jw message) {
        this.a = this.b.getWritableDatabase();
        sv svVar = this.c;
        svVar.traceDebug("DatabaseMessageStore", "storeArrived{" + clientHandle + "}, {" + message.toString() + "}");
        byte[] payload = message.b();
        int qos = message.c();
        boolean retained = message.e();
        boolean duplicate = message.d();
        ContentValues values = new ContentValues();
        String id = UUID.randomUUID().toString();
        values.put("messageId", id);
        values.put("clientHandle", clientHandle);
        values.put("destinationName", topic);
        values.put("payload", payload);
        values.put("qos", Integer.valueOf(qos));
        values.put("retained", Boolean.valueOf(retained));
        values.put("duplicate", Boolean.valueOf(duplicate));
        values.put("mtimestamp", Long.valueOf(System.currentTimeMillis()));
        try {
            this.a.insertOrThrow("MqttArrivedMessageTable", null, values);
            int count = h(clientHandle);
            sv svVar2 = this.c;
            svVar2.traceDebug("DatabaseMessageStore", "storeArrived: inserted message with id of {" + id + "} - Number of messages in database for this clientHandle = " + count);
            return id;
        } catch (SQLException e) {
            this.c.traceException("DatabaseMessageStore", "onUpgrade", e);
            throw e;
        }
    }

    public final int h(String clientHandle) {
        int count = 0;
        String[] projection = {"messageId"};
        String[] selectionArgs = {clientHandle};
        Cursor c2 = this.a.query("MqttArrivedMessageTable", projection, "clientHandle=?", selectionArgs, null, null, null);
        if (c2.moveToFirst()) {
            count = c2.getInt(0);
        }
        c2.close();
        return count;
    }

    @Override // defpackage.nv
    public boolean b(String clientHandle, String id) {
        this.a = this.b.getWritableDatabase();
        sv svVar = this.c;
        svVar.traceDebug("DatabaseMessageStore", "discardArrived{" + clientHandle + "}, {" + id + "}");
        String[] selectionArgs = {id, clientHandle};
        try {
            int rows = this.a.delete("MqttArrivedMessageTable", "messageId=? AND clientHandle=?", selectionArgs);
            if (rows != 1) {
                sv svVar2 = this.c;
                svVar2.traceError("DatabaseMessageStore", "discardArrived - Error deleting message {" + id + "} from database: Rows affected = " + rows);
                return false;
            }
            int count = h(clientHandle);
            sv svVar3 = this.c;
            svVar3.traceDebug("DatabaseMessageStore", "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + count);
            return true;
        } catch (SQLException e) {
            this.c.traceException("DatabaseMessageStore", "discardArrived", e);
            throw e;
        }
    }

    /* compiled from: DatabaseMessageStore.java */
    /* renamed from: mv$a */
    /* loaded from: classes.dex */
    public class a implements Iterator<nv.a> {
        public Cursor a;
        public boolean b;
        public final String[] d;
        public final /* synthetic */ String f;

        public a(String str) {
            this.f = str;
            String[] strArr = {str};
            this.d = strArr;
            mv.this.a = mv.this.b.getWritableDatabase();
            if (str == null) {
                this.a = mv.this.a.query("MqttArrivedMessageTable", null, null, null, null, null, "mtimestamp ASC");
            } else {
                this.a = mv.this.a.query("MqttArrivedMessageTable", null, "clientHandle=?", strArr, null, null, "mtimestamp ASC");
            }
            this.b = this.a.moveToFirst();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.b) {
                this.a.close();
            }
            return this.b;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public nv.a next() {
            Cursor cursor = this.a;
            String messageId = cursor.getString(cursor.getColumnIndex("messageId"));
            Cursor cursor2 = this.a;
            String clientHandle = cursor2.getString(cursor2.getColumnIndex("clientHandle"));
            Cursor cursor3 = this.a;
            String topic = cursor3.getString(cursor3.getColumnIndex("destinationName"));
            Cursor cursor4 = this.a;
            byte[] payload = cursor4.getBlob(cursor4.getColumnIndex("payload"));
            Cursor cursor5 = this.a;
            int qos = cursor5.getInt(cursor5.getColumnIndex("qos"));
            Cursor cursor6 = this.a;
            boolean retained = Boolean.parseBoolean(cursor6.getString(cursor6.getColumnIndex("retained")));
            Cursor cursor7 = this.a;
            boolean dup = Boolean.parseBoolean(cursor7.getString(cursor7.getColumnIndex("duplicate")));
            d message = new d(payload);
            message.i(qos);
            message.j(retained);
            message.f(dup);
            this.b = this.a.moveToNext();
            return new b(messageId, clientHandle, topic, message);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void finalize() throws Throwable {
            this.a.close();
            super.finalize();
        }
    }

    @Override // defpackage.nv
    public Iterator<nv.a> a(String clientHandle) {
        return new a(clientHandle);
    }

    @Override // defpackage.nv
    public void d(String clientHandle) {
        int rows;
        this.a = this.b.getWritableDatabase();
        String[] selectionArgs = {clientHandle};
        if (clientHandle == null) {
            this.c.traceDebug("DatabaseMessageStore", "clearArrivedMessages: clearing the table");
            rows = this.a.delete("MqttArrivedMessageTable", null, null);
        } else {
            sv svVar = this.c;
            svVar.traceDebug("DatabaseMessageStore", "clearArrivedMessages: clearing the table of " + clientHandle + " messages");
            rows = this.a.delete("MqttArrivedMessageTable", "clientHandle=?", selectionArgs);
        }
        sv svVar2 = this.c;
        svVar2.traceDebug("DatabaseMessageStore", "clearArrivedMessages: rows affected = " + rows);
    }

    /* compiled from: DatabaseMessageStore.java */
    /* renamed from: mv$b */
    /* loaded from: classes.dex */
    public class b implements nv.a {
        public String a;
        public String b;
        public jw c;

        public b(String messageId, String clientHandle, String topic, jw message) {
            this.a = messageId;
            this.b = topic;
            this.c = message;
        }

        @Override // defpackage.nv.a
        public String a() {
            return this.a;
        }

        @Override // defpackage.nv.a
        public String b() {
            return this.b;
        }

        @Override // defpackage.nv.a
        public jw getMessage() {
            return this.c;
        }
    }

    /* compiled from: DatabaseMessageStore.java */
    /* renamed from: mv$d */
    /* loaded from: classes.dex */
    public class d extends jw {
        public d(byte[] payload) {
            super(payload);
        }

        @Override // defpackage.jw
        public void f(boolean dup) {
            super.f(dup);
        }
    }

    @Override // defpackage.nv
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
