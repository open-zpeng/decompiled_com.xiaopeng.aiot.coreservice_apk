package defpackage;
/* compiled from: CacheCall.java */
/* renamed from: mk  reason: default package */
/* loaded from: classes.dex */
public class mk<T> implements nk<T> {
    public rk<T> a;
    public sl<T, ? extends sl> b;

    /* JADX WARN: Generic types in debug info not equals: mk != com.lzy.okgo.adapter.CacheCall<T> */
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    public mk(sl<T, ? extends sl> slVar) {
        this.a = null;
        this.b = slVar;
        this.a = c();
    }

    /* JADX WARN: Generic types in debug info not equals: mk != com.lzy.okgo.adapter.CacheCall<T> */
    /* JADX WARN: Generic types in debug info not equals: ok != com.lzy.okgo.cache.CacheEntity<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    @Override // defpackage.nk
    public void a(yk<T> ykVar) {
        ul.b(ykVar, "callback == null");
        this.a.b(this.a.a(), ykVar);
    }

    /* compiled from: CacheCall.java */
    /* renamed from: mk$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[pk.values().length];
            a = iArr;
            try {
                iArr[pk.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[pk.NO_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[pk.IF_NONE_CACHE_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[pk.FIRST_CACHE_THEN_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[pk.REQUEST_FAILED_READ_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: mk != com.lzy.okgo.adapter.CacheCall<T> */
    public final rk<T> c() {
        switch (a.a[this.b.j().ordinal()]) {
            case 1:
                this.a = new sk(this.b);
                break;
            case 2:
                this.a = new uk(this.b);
                break;
            case 3:
                this.a = new vk(this.b);
                break;
            case 4:
                this.a = new tk(this.b);
                break;
            case 5:
                this.a = new wk(this.b);
                break;
        }
        if (this.b.k() != null) {
            this.a = this.b.k();
        }
        ul.b(this.a, "policy == null");
        return this.a;
    }

    /* JADX WARN: Generic types in debug info not equals: mk != com.lzy.okgo.adapter.CacheCall<T> */
    /* renamed from: b */
    public nk<T> clone() {
        return new mk(this.b);
    }
}
