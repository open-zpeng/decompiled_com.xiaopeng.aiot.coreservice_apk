package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
/* compiled from: ContentInfoCompat.java */
/* renamed from: n9  reason: default package */
/* loaded from: classes.dex */
public final class n9 {
    public final ClipData a;
    public final int b;
    public final int c;
    public final Uri d;
    public final Bundle e;

    public static String e(int source) {
        switch (source) {
            case 0:
                return "SOURCE_APP";
            case 1:
                return "SOURCE_CLIPBOARD";
            case 2:
                return "SOURCE_INPUT_METHOD";
            case 3:
                return "SOURCE_DRAG_AND_DROP";
            default:
                return String.valueOf(source);
        }
    }

    public static String a(int flags) {
        if ((flags & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(flags);
    }

    public n9(a b) {
        this.a = (ClipData) k9.d(b.a);
        this.b = k9.a(b.b, 0, 3, "source");
        this.c = k9.c(b.c, 1);
        this.d = b.d;
        this.e = b.e;
    }

    public String toString() {
        return "ContentInfoCompat{clip=" + this.a + ", source=" + e(this.b) + ", flags=" + a(this.c) + ", linkUri=" + this.d + ", extras=" + this.e + "}";
    }

    public ClipData b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    /* compiled from: ContentInfoCompat.java */
    /* renamed from: n9$a */
    /* loaded from: classes.dex */
    public static final class a {
        public ClipData a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public a(ClipData clip, int source) {
            this.a = clip;
            this.b = source;
        }

        public a c(int flags) {
            this.c = flags;
            return this;
        }

        public a d(Uri linkUri) {
            this.d = linkUri;
            return this;
        }

        public a b(Bundle extras) {
            this.e = extras;
            return this;
        }

        public n9 a() {
            return new n9(this);
        }
    }
}
