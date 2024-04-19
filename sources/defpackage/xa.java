package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputContentInfoCompat.java */
/* renamed from: xa  reason: default package */
/* loaded from: classes.dex */
public final class xa {
    public final c a;

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: xa$c */
    /* loaded from: classes.dex */
    public interface c {
        ClipDescription a();

        Object b();

        Uri c();

        void d();

        Uri e();
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: xa$b */
    /* loaded from: classes.dex */
    public static final class b implements c {
        public final Uri a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri contentUri, ClipDescription description, Uri linkUri) {
            this.a = contentUri;
            this.b = description;
            this.c = linkUri;
        }

        @Override // defpackage.xa.c
        public Uri c() {
            return this.a;
        }

        @Override // defpackage.xa.c
        public ClipDescription a() {
            return this.b;
        }

        @Override // defpackage.xa.c
        public Uri e() {
            return this.c;
        }

        @Override // defpackage.xa.c
        public Object b() {
            return null;
        }

        @Override // defpackage.xa.c
        public void d() {
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: xa$a */
    /* loaded from: classes.dex */
    public static final class a implements c {
        public final InputContentInfo a;

        public a(Object inputContentInfo) {
            this.a = (InputContentInfo) inputContentInfo;
        }

        public a(Uri contentUri, ClipDescription description, Uri linkUri) {
            this.a = new InputContentInfo(contentUri, description, linkUri);
        }

        @Override // defpackage.xa.c
        public Uri c() {
            return this.a.getContentUri();
        }

        @Override // defpackage.xa.c
        public ClipDescription a() {
            return this.a.getDescription();
        }

        @Override // defpackage.xa.c
        public Uri e() {
            return this.a.getLinkUri();
        }

        @Override // defpackage.xa.c
        public Object b() {
            return this.a;
        }

        @Override // defpackage.xa.c
        public void d() {
            this.a.requestPermission();
        }
    }

    public xa(Uri contentUri, ClipDescription description, Uri linkUri) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(contentUri, description, linkUri);
        } else {
            this.a = new b(contentUri, description, linkUri);
        }
    }

    public xa(c impl) {
        this.a = impl;
    }

    public Uri a() {
        return this.a.c();
    }

    public ClipDescription b() {
        return this.a.a();
    }

    public Uri c() {
        return this.a.e();
    }

    public static xa f(Object inputContentInfo) {
        if (inputContentInfo == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new xa(new a(inputContentInfo));
    }

    public Object e() {
        return this.a.b();
    }

    public void d() {
        this.a.d();
    }
}
