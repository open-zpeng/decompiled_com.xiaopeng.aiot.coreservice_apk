package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: Lifecycle.java */
/* renamed from: cd  reason: default package */
/* loaded from: classes.dex */
public abstract class cd {
    public AtomicReference<Object> a = new AtomicReference<>();

    public abstract void a(ed edVar);

    public abstract c b();

    public abstract void c(ed edVar);

    /* compiled from: Lifecycle.java */
    /* renamed from: cd$b */
    /* loaded from: classes.dex */
    public enum b {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static b a(c state) {
            switch (a.a[state.ordinal()]) {
                case 1:
                    return ON_DESTROY;
                case 2:
                    return ON_STOP;
                case 3:
                    return ON_PAUSE;
                default:
                    return null;
            }
        }

        public static b c(c state) {
            switch (a.a[state.ordinal()]) {
                case 1:
                    return ON_START;
                case 2:
                    return ON_RESUME;
                case 3:
                case 4:
                default:
                    return null;
                case 5:
                    return ON_CREATE;
            }
        }

        public c b() {
            switch (a.b[ordinal()]) {
                case 1:
                case 2:
                    return c.CREATED;
                case 3:
                case 4:
                    return c.STARTED;
                case 5:
                    return c.RESUMED;
                case 6:
                    return c.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: cd$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* compiled from: Lifecycle.java */
    /* renamed from: cd$c */
    /* loaded from: classes.dex */
    public enum c {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(c state) {
            return compareTo(state) >= 0;
        }
    }
}
