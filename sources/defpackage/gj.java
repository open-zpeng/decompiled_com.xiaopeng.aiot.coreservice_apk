package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ut.mini.UTAnalytics;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import java.io.UnsupportedEncodingException;
/* compiled from: UTMCStatConfig.java */
/* renamed from: gj  reason: default package */
/* loaded from: classes.dex */
public class gj {
    public static gj a = new gj();
    public Context b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public Application g = null;
    public String h = null;
    public IUTRequestAuthentication i = null;
    public boolean j = false;
    public boolean k = false;

    public static gj b() {
        return a;
    }

    public void i(String aAppVersion) {
        this.h = aAppVersion;
    }

    public String e() {
        return this.h;
    }

    public void k() {
        vj.e(true);
    }

    public final void c(String str) {
        Context context;
        this.c = str;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
        }
        if (!TextUtils.isEmpty(str) && (context = this.b) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_lun", new String(pj.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public final void d(String str) {
        Context context;
        this.e = str;
        if (!TextUtils.isEmpty(str)) {
            this.f = str;
        }
        if (!TextUtils.isEmpty(str) && (context = this.b) != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_luid", new String(pj.c(str.getBytes(XmartV1Constants.UTF8_ENCODING), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public void l(String aUsernick, String aUserid) {
        c(aUsernick);
        d(aUserid);
        if (!TextUtils.isEmpty(aUsernick)) {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("UT", IpcConfig.BTPhoneConfig.IPC_MSG_DIAL_NUMBER, aUsernick, aUserid, null, null).build());
        }
    }

    public void j(Context aContext) {
        if (aContext != null) {
            this.b = aContext;
            SharedPreferences sharedPreferences = aContext.getSharedPreferences("UTCommon", 0);
            String string = sharedPreferences.getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.d = new String(pj.a(string.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string2 = sharedPreferences.getString("_luid", "");
            if (!TextUtils.isEmpty(string2)) {
                try {
                    this.f = new String(pj.a(string2.getBytes(), 2), XmartV1Constants.UTF8_ENCODING);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        g();
    }

    public Context f() {
        return this.b;
    }

    public void h(Application aApplicationInstance) {
        this.g = aApplicationInstance;
        g();
    }

    public final void g() {
        if (!this.j && Build.VERSION.SDK_INT >= 14) {
            try {
                if (b().a() != null) {
                    UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(b().a());
                    this.j = true;
                } else {
                    UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application) b().f().getApplicationContext());
                    this.j = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("UTEngine", "You need set a application instance for UT.");
            }
        }
    }

    public Application a() {
        return this.g;
    }
}
