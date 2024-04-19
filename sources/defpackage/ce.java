package defpackage;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import defpackage.be;
/* compiled from: MediaBrowserServiceCompatApi23.java */
/* renamed from: ce  reason: default package */
/* loaded from: classes.dex */
public class ce {

    /* compiled from: MediaBrowserServiceCompatApi23.java */
    /* renamed from: ce$b */
    /* loaded from: classes.dex */
    public interface b extends be.d {
        void c(String str, be.c<Parcel> cVar);
    }

    public static Object a(Context context, b serviceProxy) {
        return new a(context, serviceProxy);
    }

    /* compiled from: MediaBrowserServiceCompatApi23.java */
    /* renamed from: ce$a */
    /* loaded from: classes.dex */
    public static class a extends be.b {
        public a(Context context, b serviceWrapper) {
            super(context, serviceWrapper);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String itemId, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
            ((b) this.a).c(itemId, new be.c<>(result));
        }
    }
}
