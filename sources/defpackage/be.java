package defpackage;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MediaBrowserServiceCompatApi21.java */
/* renamed from: be  reason: default package */
/* loaded from: classes.dex */
public class be {

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* renamed from: be$d */
    /* loaded from: classes.dex */
    public interface d {
        void a(String str, c<List<Parcel>> cVar);

        a f(String str, int i, Bundle bundle);
    }

    public static Object a(Context context, d serviceProxy) {
        return new b(context, serviceProxy);
    }

    public static void c(Object serviceObj) {
        ((MediaBrowserService) serviceObj).onCreate();
    }

    public static IBinder b(Object serviceObj, Intent intent) {
        return ((MediaBrowserService) serviceObj).onBind(intent);
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* renamed from: be$c */
    /* loaded from: classes.dex */
    public static class c<T> {
        public MediaBrowserService.Result a;

        /* JADX WARN: Generic types in debug info not equals: be$c != androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper<T> */
        public c(MediaBrowserService.Result result) {
            this.a = result;
        }

        /* JADX WARN: Generic types in debug info not equals: be$c != androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void b(T result) {
            if (result instanceof List) {
                this.a.sendResult(a((List) result));
            } else if (result instanceof Parcel) {
                Parcel parcel = (Parcel) result;
                parcel.setDataPosition(0);
                this.a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.a.sendResult(null);
            }
        }

        /* JADX WARN: Generic types in debug info not equals: be$c != androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper<T> */
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

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* renamed from: be$a */
    /* loaded from: classes.dex */
    public static class a {
        public final String a;
        public final Bundle b;

        public a(String rootId, Bundle extras) {
            this.a = rootId;
            this.b = extras;
        }
    }

    /* compiled from: MediaBrowserServiceCompatApi21.java */
    /* renamed from: be$b */
    /* loaded from: classes.dex */
    public static class b extends MediaBrowserService {
        public final d a;

        public b(Context context, d serviceWrapper) {
            attachBaseContext(context);
            this.a = serviceWrapper;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String clientPackageName, int clientUid, Bundle rootHints) {
            MediaSessionCompat.ensureClassLoader(rootHints);
            a browserRoot = this.a.f(clientPackageName, clientUid, rootHints == null ? null : new Bundle(rootHints));
            if (browserRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(browserRoot.a, browserRoot.b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String parentId, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.a.a(parentId, new c<>(result));
        }
    }
}
