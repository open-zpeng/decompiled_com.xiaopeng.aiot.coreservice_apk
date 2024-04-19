package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
/* compiled from: FontsContractCompat.java */
/* renamed from: a9  reason: default package */
/* loaded from: classes.dex */
public class a9 {

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a9$c */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, y8 request, int style, boolean isBlockingFetch, int timeout, Handler handler, c callback) {
        v8 callbackWrapper = new v8(callback, handler);
        if (isBlockingFetch) {
            return z8.e(context, request, callbackWrapper, style, timeout);
        }
        return z8.d(context, request, style, null, callbackWrapper);
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a9$b */
    /* loaded from: classes.dex */
    public static class b {
        public final Uri a;
        public final int b;
        public final int c;
        public final boolean d;
        public final int e;

        @Deprecated
        public b(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            this.a = (Uri) k9.d(uri);
            this.b = ttcIndex;
            this.c = weight;
            this.d = italic;
            this.e = resultCode;
        }

        public static b a(Uri uri, int ttcIndex, int weight, boolean italic, int resultCode) {
            return new b(uri, ttcIndex, weight, italic, resultCode);
        }

        public Uri d() {
            return this.a;
        }

        public int c() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }

        public int b() {
            return this.e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: a9$a */
    /* loaded from: classes.dex */
    public static class a {
        public final int a;
        public final b[] b;

        @Deprecated
        public a(int statusCode, b[] fonts) {
            this.a = statusCode;
            this.b = fonts;
        }

        public int c() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }

        public static a a(int statusCode, b[] fonts) {
            return new a(statusCode, fonts);
        }
    }
}
