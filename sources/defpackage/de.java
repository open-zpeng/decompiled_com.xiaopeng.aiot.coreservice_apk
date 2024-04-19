package defpackage;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import defpackage.ce;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MediaBrowserServiceCompatApi26.java */
/* renamed from: de  reason: default package */
/* loaded from: classes.dex */
public class de {
    public static Field a;

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* renamed from: de$c */
    /* loaded from: classes.dex */
    public interface c extends ce.b {
        void e(String str, b bVar, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w("MBSCompatApi26", e);
        }
    }

    public static Object a(Context context, c serviceProxy) {
        return new a(context, serviceProxy);
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* renamed from: de$b */
    /* loaded from: classes.dex */
    public static class b {
        public MediaBrowserService.Result a;

        public b(MediaBrowserService.Result result) {
            this.a = result;
        }

        public void b(List<Parcel> result, int flags) {
            try {
                de.a.setInt(this.a, flags);
            } catch (IllegalAccessException e) {
                Log.w("MBSCompatApi26", e);
            }
            this.a.sendResult(a(result));
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> parcelList) {
            if (parcelList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : parcelList) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi26.java */
    /* renamed from: de$a */
    /* loaded from: classes.dex */
    public static class a extends ce.a {
        public a(Context context, c serviceWrapper) {
            super(context, serviceWrapper);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String parentId, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle options) {
            MediaSessionCompat.ensureClassLoader(options);
            ((c) this.a).e(parentId, new b(result), options);
        }
    }
}
