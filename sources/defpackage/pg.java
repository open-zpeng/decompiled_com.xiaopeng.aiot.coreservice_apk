package defpackage;

import java.lang.reflect.Field;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: pg  reason: default package */
/* loaded from: classes.dex */
public abstract class pg implements wg {
    public static final pg a;
    public static final pg b;
    public static final pg d;
    public static final pg f;
    public static final pg g;
    public static final /* synthetic */ pg[] h;

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: pg$a */
    /* loaded from: classes.dex */
    public enum a extends pg {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.wg
        public String a(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        a = aVar;
        pg pgVar = new pg("UPPER_CAMEL_CASE", 1) { // from class: pg.b
            @Override // defpackage.wg
            public String a(Field field) {
                return pg.e(field.getName());
            }
        };
        b = pgVar;
        pg pgVar2 = new pg("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: pg.c
            @Override // defpackage.wg
            public String a(Field field) {
                return pg.e(pg.f(field.getName(), " "));
            }
        };
        d = pgVar2;
        pg pgVar3 = new pg("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: pg.d
            @Override // defpackage.wg
            public String a(Field field) {
                return pg.f(field.getName(), "_").toLowerCase();
            }
        };
        f = pgVar3;
        pg pgVar4 = new pg("LOWER_CASE_WITH_DASHES", 4) { // from class: pg.e
            @Override // defpackage.wg
            public String a(Field field) {
                return pg.f(field.getName(), "-").toLowerCase();
            }
        };
        g = pgVar4;
        h = new pg[]{aVar, pgVar, pgVar2, pgVar3, pgVar4};
    }

    public pg(String str, int i) {
    }

    public /* synthetic */ pg(String str, int i, a aVar) {
        this(str, i);
    }

    public static String b(char c2, String str, int i) {
        if (i < str.length()) {
            return c2 + str.substring(i);
        }
        return String.valueOf(c2);
    }

    public static String e(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            charAt = str.charAt(i);
            if (i >= str.length() - 1 || Character.isLetter(charAt)) {
                break;
            }
            sb.append(charAt);
            i++;
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(b(Character.toUpperCase(charAt), str, i + 1));
        return sb.toString();
    }

    public static String f(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static pg valueOf(String str) {
        return (pg) Enum.valueOf(pg.class, str);
    }

    public static pg[] values() {
        return (pg[]) h.clone();
    }
}
