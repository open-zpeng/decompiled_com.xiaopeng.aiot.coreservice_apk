package defpackage;

import android.os.Bundle;
import android.util.Log;
import defpackage.qd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManagerImpl.java */
/* renamed from: xd  reason: default package */
/* loaded from: classes.dex */
public class xd extends wd {
    public static boolean a = false;
    public final fd b;
    public final c c;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: xd$b */
    /* loaded from: classes.dex */
    public static class b<D> implements ld<D> {
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: xd$a */
    /* loaded from: classes.dex */
    public static class a<D> extends kd<D> {
        public final int l;
        public final Bundle m;
        public final yd<D> n;
        public fd o;
        public b<D> p;
        public yd<D> q;

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // androidx.lifecycle.LiveData
        public void f() {
            if (xd.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.d();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // androidx.lifecycle.LiveData
        public void g() {
            if (xd.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.e();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        /* JADX WARN: Generic types in debug info not equals: xd$b != androidx.loader.app.LoaderManagerImpl$LoaderObserver<D> */
        public void l() {
            fd lifecycleOwner = this.o;
            b<D> bVar = this.p;
            if (lifecycleOwner != null && bVar != null) {
                super.h(bVar);
                e(lifecycleOwner, bVar);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: ld != androidx.lifecycle.Observer<? super D> */
        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void h(ld<? super D> ldVar) {
            super.h(ldVar);
            this.o = null;
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public yd<D> j(boolean reset) {
            boolean reset2 = xd.a;
            if (reset2) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.a();
            throw null;
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        @Override // defpackage.kd, androidx.lifecycle.LiveData
        public void i(D value) {
            super.i(value);
            yd<D> ydVar = this.q;
            if (ydVar != null) {
                ydVar.c();
                throw null;
            }
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            e9.a(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX WARN: Generic types in debug info not equals: xd$a != androidx.loader.app.LoaderManagerImpl$LoaderInfo<D> */
        public void k(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.print(prefix);
            writer.print("mId=");
            writer.print(this.l);
            writer.print(" mArgs=");
            writer.println(this.m);
            writer.print(prefix);
            writer.print("mLoader=");
            writer.println(this.n);
            yd<D> ydVar = this.n;
            ydVar.b(prefix + "  ", fd, writer, args);
            throw null;
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: xd$c */
    /* loaded from: classes.dex */
    public static class c extends pd {
        public static final qd.a c = new a();
        public a4<a> d = new a4<>();
        public boolean e = false;

        /* compiled from: LoaderManagerImpl.java */
        /* renamed from: xd$c$a */
        /* loaded from: classes.dex */
        public static class a implements qd.a {
            @Override // defpackage.qd.a
            public <T extends pd> T a(Class<T> modelClass) {
                return new c();
            }
        }

        public static c f(rd viewModelStore) {
            return (c) new qd(viewModelStore, c).a(c.class);
        }

        public void g() {
            int size = this.d.i();
            for (int index = 0; index < size; index++) {
                a info = this.d.j(index);
                info.l();
            }
        }

        @Override // defpackage.pd
        public void d() {
            super.d();
            int size = this.d.i();
            for (int index = 0; index < size; index++) {
                a info = this.d.j(index);
                info.j(true);
            }
            this.d.b();
        }

        public void e(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            if (this.d.i() > 0) {
                writer.print(prefix);
                writer.println("Loaders:");
                String innerPrefix = prefix + "    ";
                for (int i = 0; i < this.d.i(); i++) {
                    a info = this.d.j(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(this.d.g(i));
                    writer.print(": ");
                    writer.println(info.toString());
                    info.k(innerPrefix, fd, writer, args);
                }
            }
        }
    }

    public xd(fd lifecycleOwner, rd viewModelStore) {
        this.b = lifecycleOwner;
        this.c = c.f(viewModelStore);
    }

    @Override // defpackage.wd
    public void c() {
        this.c.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        e9.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // defpackage.wd
    @Deprecated
    public void a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        this.c.e(prefix, fd, writer, args);
    }
}
