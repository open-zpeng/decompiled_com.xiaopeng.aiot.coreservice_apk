package defpackage;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: ih  reason: default package */
/* loaded from: classes.dex */
public abstract class ih {
    public static final ih a;
    public static final ih b;
    public static final /* synthetic */ ih[] d;

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: ih$a */
    /* loaded from: classes.dex */
    public enum a extends ih {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        a = aVar;
        ih ihVar = new ih("STRING", 1) { // from class: ih.b
        };
        b = ihVar;
        d = new ih[]{aVar, ihVar};
    }

    public ih(String str, int i) {
    }

    public /* synthetic */ ih(String str, int i, a aVar) {
        this(str, i);
    }

    public static ih valueOf(String str) {
        return (ih) Enum.valueOf(ih.class, str);
    }

    public static ih[] values() {
        return (ih[]) d.clone();
    }
}
