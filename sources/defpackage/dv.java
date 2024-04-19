package defpackage;

import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* renamed from: dv  reason: default package */
/* loaded from: classes.dex */
public enum dv {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* renamed from: dv$b */
    /* loaded from: classes.dex */
    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable e) {
            this.a = e;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.a + "]";
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b n = (b) obj;
                return kt.c(this.a, n.a);
            }
            return false;
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: dv$a */
    /* loaded from: classes.dex */
    public static final class a implements Serializable {
        public final ls a;

        public String toString() {
            return "NotificationLite.Disposable[" + this.a + "]";
        }
    }

    public static <T> Object d(T value) {
        return value;
    }

    public static Object b() {
        return COMPLETE;
    }

    public static Object c(Throwable e) {
        return new b(e);
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    public static <T> boolean a(Object o, fs<? super T> fsVar) {
        if (o == COMPLETE) {
            fsVar.onComplete();
            return true;
        } else if (o instanceof b) {
            fsVar.onError(((b) o).a);
            return true;
        } else if (o instanceof a) {
            fsVar.onSubscribe(((a) o).a);
            return false;
        } else {
            fsVar.onNext(o);
            return false;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
