package defpackage;
/* compiled from: ColumnEntity.java */
/* renamed from: el  reason: default package */
/* loaded from: classes.dex */
public class el {
    public String a;
    public String b;
    public String[] c;
    public boolean d;
    public boolean e;
    public boolean f;

    public el(String... compositePrimaryKey) {
        this.c = compositePrimaryKey;
    }

    public el(String columnName, String columnType) {
        this(columnName, columnType, false, false, false);
    }

    public el(String columnName, String columnType, boolean isPrimary, boolean isNotNull) {
        this(columnName, columnType, isPrimary, isNotNull, false);
    }

    public el(String columnName, String columnType, boolean isPrimary, boolean isNotNull, boolean isAutoincrement) {
        this.a = columnName;
        this.b = columnType;
        this.d = isPrimary;
        this.e = isNotNull;
        this.f = isAutoincrement;
    }
}
