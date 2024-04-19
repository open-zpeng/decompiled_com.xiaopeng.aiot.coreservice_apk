package defpackage;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
/* compiled from: MediaBrowserCompatUtils.java */
/* renamed from: ae  reason: default package */
/* loaded from: classes.dex */
public class ae {
    public static boolean a(Bundle options1, Bundle options2) {
        if (options1 == options2) {
            return true;
        }
        if (options1 == null) {
            if (options2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && options2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (options2 == null) {
            if (options1.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && options1.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1) {
                return true;
            }
            return false;
        } else if (options1.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == options2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && options1.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == options2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1)) {
            return true;
        } else {
            return false;
        }
    }
}
