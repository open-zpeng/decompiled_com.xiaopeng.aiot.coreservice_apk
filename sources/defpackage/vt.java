package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCreate.java */
/* renamed from: vt  reason: default package */
/* loaded from: classes.dex */
public final class vt<T> extends bs<T> {
    public final ds<T> a;

    /* JADX WARN: Generic types in debug info not equals: ds != io.reactivex.ObservableOnSubscribe<T> */
    /* JADX WARN: Generic types in debug info not equals: vt != io.reactivex.internal.operators.observable.ObservableCreate<T> */
    public vt(ds<T> dsVar) {
        this.a = dsVar;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
    /* JADX WARN: Generic types in debug info not equals: vt != io.reactivex.internal.operators.observable.ObservableCreate<T> */
    /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
    @Override // defpackage.bs
    public void z(fs<? super T> fsVar) {
        a aVar = new a(fsVar);
        fsVar.onSubscribe(aVar);
        try {
            this.a.subscribe(aVar);
        } catch (Throwable ex) {
            qs.b(ex);
            aVar.onError(ex);
        }
    }

    /* compiled from: ObservableCreate.java */
    /* renamed from: vt$a */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<ls> implements cs<T>, ls {
        public final fs<? super T> a;

        /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super T> */
        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        public a(fs<? super T> fsVar) {
            this.a = fsVar;
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // defpackage.zr
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!c()) {
                this.a.onNext(t);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // defpackage.zr
        public void onError(Throwable t) {
            if (!e(t)) {
                iv.m(t);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        public boolean e(Throwable t) {
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!c()) {
                try {
                    this.a.onError(t);
                    a();
                    return true;
                } catch (Throwable th) {
                    a();
                    throw th;
                }
            }
            return false;
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        public void d(ls d) {
            et.f(this, d);
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // defpackage.cs
        public void b(xs c) {
            d(new ct(c));
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // defpackage.ls
        public void a() {
            et.b(this);
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // defpackage.cs
        public boolean c() {
            return et.c(get());
        }

        /* JADX WARN: Generic types in debug info not equals: vt$a != io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter<T> */
        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}
