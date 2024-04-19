package defpackage;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
/* compiled from: NotificationCompat.java */
/* renamed from: f7  reason: default package */
/* loaded from: classes.dex */
public class f7 {

    /* compiled from: NotificationCompat.java */
    /* renamed from: f7$d */
    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void a(Bundle bundle);

        public abstract void b(e7 e7Var);

        public abstract RemoteViews c(e7 e7Var);

        public abstract RemoteViews d(e7 e7Var);

        public abstract RemoteViews e(e7 e7Var);
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: f7$c */
    /* loaded from: classes.dex */
    public static class c {
        public boolean A;
        public boolean B;
        public String C;
        public Bundle D;
        public Notification G;
        public RemoteViews H;
        public RemoteViews I;
        public RemoteViews J;
        public String K;
        public String M;
        public n7 N;
        public long O;
        public boolean Q;
        public b R;
        public Notification S;
        public boolean T;
        public Icon U;
        @Deprecated
        public ArrayList<String> V;
        public Context a;
        public CharSequence e;
        public CharSequence f;
        public PendingIntent g;
        public PendingIntent h;
        public RemoteViews i;
        public Bitmap j;
        public CharSequence k;
        public int l;
        public int m;
        public boolean o;
        public d p;
        public CharSequence q;
        public CharSequence r;
        public CharSequence[] s;
        public int t;
        public int u;
        public boolean v;
        public String w;
        public boolean x;
        public String y;
        public ArrayList<a> b = new ArrayList<>();
        public ArrayList<i7> c = new ArrayList<>();
        public ArrayList<a> d = new ArrayList<>();
        public boolean n = true;
        public boolean z = false;
        public int E = 0;
        public int F = 0;
        public int L = 0;
        public int P = 0;

        public c(Context context, String channelId) {
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = channelId;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        public c h(int icon) {
            this.S.icon = icon;
            return this;
        }

        public c f(CharSequence title) {
            this.e = c(title);
            return this;
        }

        public c e(CharSequence text) {
            this.f = c(text);
            return this;
        }

        public c d(String category) {
            this.C = category;
            return this;
        }

        public c g(int pri) {
            this.m = pri;
            return this;
        }

        public Bundle b() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public Notification a() {
            return new g7(this).b();
        }

        public static CharSequence c(CharSequence cs) {
            if (cs == null) {
                return cs;
            }
            if (cs.length() > 5120) {
                return cs.subSequence(0, 5120);
            }
            return cs;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: f7$a */
    /* loaded from: classes.dex */
    public static class a {
        public final Bundle a;
        public IconCompat b;
        public final j7[] c;
        public final j7[] d;
        public boolean e;
        public boolean f;
        public final int g;
        public final boolean h;
        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;

        public IconCompat e() {
            int i;
            if (this.b == null && (i = this.i) != 0) {
                this.b = IconCompat.b(null, "", i);
            }
            return this.b;
        }

        public CharSequence i() {
            return this.j;
        }

        public PendingIntent a() {
            return this.k;
        }

        public Bundle d() {
            return this.a;
        }

        public boolean b() {
            return this.e;
        }

        public j7[] f() {
            return this.c;
        }

        public int g() {
            return this.g;
        }

        public boolean j() {
            return this.h;
        }

        public j7[] c() {
            return this.d;
        }

        public boolean h() {
            return this.f;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: f7$b */
    /* loaded from: classes.dex */
    public static final class b {
        public boolean a() {
            throw null;
        }

        public PendingIntent b() {
            throw null;
        }

        public int c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        @SuppressLint({"InvalidNullConversion"})
        public IconCompat e() {
            throw null;
        }

        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent f() {
            throw null;
        }

        public String g() {
            throw null;
        }

        public boolean h() {
            throw null;
        }

        public static Notification.BubbleMetadata i(b compatMetadata) {
            if (compatMetadata == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return C0015b.a(compatMetadata);
            }
            if (i != 29) {
                return null;
            }
            return a.a(compatMetadata);
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: f7$b$a */
        /* loaded from: classes.dex */
        public static class a {
            public static Notification.BubbleMetadata a(b compatMetadata) {
                if (compatMetadata == null || compatMetadata.f() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder platformMetadataBuilder = new Notification.BubbleMetadata.Builder().setIcon(compatMetadata.e().l()).setIntent(compatMetadata.f()).setDeleteIntent(compatMetadata.b()).setAutoExpandBubble(compatMetadata.a()).setSuppressNotification(compatMetadata.h());
                if (compatMetadata.c() != 0) {
                    platformMetadataBuilder.setDesiredHeight(compatMetadata.c());
                }
                if (compatMetadata.d() != 0) {
                    platformMetadataBuilder.setDesiredHeightResId(compatMetadata.d());
                }
                return platformMetadataBuilder.build();
            }
        }

        /* compiled from: NotificationCompat.java */
        /* renamed from: f7$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0015b {
            public static Notification.BubbleMetadata a(b compatMetadata) {
                Notification.BubbleMetadata.Builder platformMetadataBuilder;
                if (compatMetadata == null) {
                    return null;
                }
                if (compatMetadata.g() != null) {
                    platformMetadataBuilder = new Notification.BubbleMetadata.Builder(compatMetadata.g());
                } else {
                    platformMetadataBuilder = new Notification.BubbleMetadata.Builder(compatMetadata.f(), compatMetadata.e().l());
                }
                platformMetadataBuilder.setDeleteIntent(compatMetadata.b()).setAutoExpandBubble(compatMetadata.a()).setSuppressNotification(compatMetadata.h());
                if (compatMetadata.c() != 0) {
                    platformMetadataBuilder.setDesiredHeight(compatMetadata.c());
                }
                if (compatMetadata.d() != 0) {
                    platformMetadataBuilder.setDesiredHeightResId(compatMetadata.d());
                }
                return platformMetadataBuilder.build();
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return h7.c(notification);
        }
        return null;
    }
}
