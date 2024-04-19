package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.core.provider.FontRequestWorker;
import defpackage.a9;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* compiled from: FontRequestWorker.java */
/* renamed from: z8  reason: default package */
/* loaded from: classes.dex */
public class z8 {
    public static final x3<String, Typeface> a = new x3<>(16);
    public static final ExecutorService b = b9.a("fonts-androidx", 10, 10000);
    public static final Object c = new Object();
    public static final z3<String, ArrayList<d9<e>>> d = new z3<>();

    public static Typeface e(Context context, y8 request, v8 callback, int style, int timeoutInMillis) {
        String id = a(request, style);
        Typeface cached = a.c(id);
        if (cached != null) {
            callback.b(new e(cached));
            return cached;
        } else if (timeoutInMillis == -1) {
            e typefaceResult = c(id, context, request, style);
            callback.b(typefaceResult);
            return typefaceResult.a;
        } else {
            Callable<FontRequestWorker.TypefaceResult> fetcher = new a(id, context, request, style);
            try {
                e typefaceResult2 = (e) b9.c(b, fetcher, timeoutInMillis);
                callback.b(typefaceResult2);
                return typefaceResult2.a;
            } catch (InterruptedException e2) {
                callback.b(new e(-3));
                return null;
            }
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: z8$a */
    /* loaded from: classes.dex */
    public class a implements Callable<e> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ y8 d;
        public final /* synthetic */ int f;

        public a(String str, Context context, y8 y8Var, int i) {
            this.a = str;
            this.b = context;
            this.d = y8Var;
            this.f = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public e call() {
            return z8.c(this.a, this.b, this.d, this.f);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: d9 != androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult> */
    public static Typeface d(Context context, y8 request, int style, Executor executor, v8 callback) {
        String id = a(request, style);
        Typeface cached = a.c(id);
        if (cached != null) {
            callback.b(new e(cached));
            return cached;
        }
        b bVar = new b(callback);
        synchronized (c) {
            z3<String, ArrayList<d9<e>>> z3Var = d;
            ArrayList<d9<e>> arrayList = z3Var.get(id);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<d9<e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            z3Var.put(id, arrayList2);
            Callable<FontRequestWorker.TypefaceResult> fetcher = new c(id, context, request, style);
            Executor finalExecutor = executor == null ? b : executor;
            b9.b(finalExecutor, fetcher, new d(id));
            return null;
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: z8$b */
    /* loaded from: classes.dex */
    public class b implements d9<e> {
        public final /* synthetic */ v8 a;

        public b(v8 v8Var) {
            this.a = v8Var;
        }

        @Override // defpackage.d9
        /* renamed from: a */
        public void accept(e typefaceResult) {
            this.a.b(typefaceResult);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: z8$c */
    /* loaded from: classes.dex */
    public class c implements Callable<e> {
        public final /* synthetic */ String a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ y8 d;
        public final /* synthetic */ int f;

        public c(String str, Context context, y8 y8Var, int i) {
            this.a = str;
            this.b = context;
            this.d = y8Var;
            this.f = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public e call() {
            e typeface = z8.c(this.a, this.b, this.d, this.f);
            return typeface;
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: z8$d */
    /* loaded from: classes.dex */
    public class d implements d9<e> {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // defpackage.d9
        /* renamed from: a */
        public void accept(e typefaceResult) {
            synchronized (z8.c) {
                z3<String, ArrayList<d9<e>>> z3Var = z8.d;
                ArrayList<d9<e>> arrayList = z3Var.get(this.a);
                if (arrayList == null) {
                    return;
                }
                z3Var.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).accept(typefaceResult);
                }
            }
        }
    }

    public static String a(y8 request, int style) {
        return request.d() + "-" + style;
    }

    public static e c(String cacheId, Context context, y8 request, int style) {
        x3<String, Typeface> x3Var = a;
        Typeface cached = x3Var.c(cacheId);
        if (cached != null) {
            return new e(cached);
        }
        try {
            a9.a result = x8.d(context, request, null);
            int fontFamilyResultStatus = b(result);
            if (fontFamilyResultStatus != 0) {
                return new e(fontFamilyResultStatus);
            }
            Typeface typeface = a8.b(context, null, result.b(), style);
            if (typeface != null) {
                x3Var.d(cacheId, typeface);
                return new e(typeface);
            }
            return new e(-3);
        } catch (PackageManager.NameNotFoundException e2) {
            return new e(-1);
        }
    }

    @SuppressLint({"WrongConstant"})
    public static int b(a9.a fontFamilyResult) {
        if (fontFamilyResult.c() != 0) {
            switch (fontFamilyResult.c()) {
                case 1:
                    return -2;
                default:
                    return -3;
            }
        }
        a9.b[] fonts = fontFamilyResult.b();
        if (fonts == null || fonts.length == 0) {
            return 1;
        }
        for (a9.b font : fonts) {
            int resultCode = font.b();
            if (resultCode != 0) {
                if (resultCode < 0) {
                    return -3;
                } else {
                    return resultCode;
                }
            }
        }
        return 0;
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: z8$e */
    /* loaded from: classes.dex */
    public static final class e {
        public final Typeface a;
        public final int b;

        public e(int result) {
            this.a = null;
            this.b = result;
        }

        @SuppressLint({"WrongConstant"})
        public e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }

        @SuppressLint({"WrongConstant"})
        public boolean a() {
            return this.b == 0;
        }
    }
}
