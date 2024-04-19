package defpackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* compiled from: DBUtils.java */
/* renamed from: gl  reason: default package */
/* loaded from: classes.dex */
public class gl {
    public static boolean a(SQLiteDatabase db, hl table) {
        if (b(db, table.a)) {
            Cursor cursor = db.rawQuery("select * from " + table.a, null);
            if (cursor == null) {
                return false;
            }
            try {
                int columnCount = table.c();
                if (columnCount == cursor.getColumnCount()) {
                    for (int i = 0; i < columnCount; i++) {
                        if (table.d(cursor.getColumnName(i)) == -1) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            } finally {
                cursor.close();
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(android.database.sqlite.SQLiteDatabase r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L47
            if (r7 == 0) goto L47
            boolean r1 = r7.isOpen()
            if (r1 != 0) goto Lc
            goto L47
        Lc:
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = "SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.String r6 = "table"
            r5[r0] = r6     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r5[r3] = r8     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.database.Cursor r4 = r7.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r1 = r4
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            if (r4 != 0) goto L2a
        L26:
            r1.close()
            return r0
        L2a:
            int r4 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r2 = r4
        L30:
            r1.close()
            goto L3d
        L34:
            r0 = move-exception
            goto L41
        L36:
            r4 = move-exception
            defpackage.wl.a(r4)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L3d
            goto L30
        L3d:
            if (r2 <= 0) goto L40
            r0 = r3
        L40:
            return r0
        L41:
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl.b(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }
}
