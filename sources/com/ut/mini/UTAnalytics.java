package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.cache.DiskLruCache;
/* loaded from: classes.dex */
public class UTAnalytics {
    private static UTAnalytics a = null;
    private boolean L;
    private boolean M;

    /* renamed from: a  reason: collision with other field name */
    private UTTracker f87a;
    private Map<String, UTTracker> w = new HashMap();
    private Map<String, UTTracker> x = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    @Deprecated
    public void setContext(Context aContext) {
        gj.b().j(aContext);
        if (aContext != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    @Deprecated
    public void setAppApplicationInstance(Application aApplicationInstance) {
        gj.b().h(aApplicationInstance);
        mh.p(aApplicationInstance);
    }

    public void setAppApplicationInstance(Application application, IUTApplication utCallback) {
        try {
            if (this.L) {
                return;
            }
            if (application != null && utCallback != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (utCallback.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(utCallback.getUTChannel());
                getInstance().setAppVersion(utCallback.getUTAppVersion());
                getInstance().setRequestAuthentication(utCallback.getUTRequestAuthInstance());
                this.M = true;
                this.L = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                vj.a(null, th);
            } catch (Throwable th2) {
            }
        }
    }

    public void setAppApplicationInstance4sdk(Application application, IUTApplication utCallback) {
        try {
            if (this.M) {
                return;
            }
            if (application != null && utCallback != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (utCallback.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(utCallback.getUTChannel());
                getInstance().setAppVersion(utCallback.getUTAppVersion());
                getInstance().setRequestAuthentication(utCallback.getUTRequestAuthInstance());
                this.M = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                vj.a(null, th);
            } catch (Throwable th2) {
            }
        }
    }

    public static synchronized UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            if (a == null) {
                a = new UTAnalytics();
            }
            uTAnalytics = a;
        }
        return uTAnalytics;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f87a == null) {
            this.f87a = new UTTracker();
        }
        if (this.f87a == null) {
            vj.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f87a;
    }

    @Deprecated
    public void setRequestAuthentication(IUTRequestAuthentication aRequestAuthenticationInstance) {
        if (aRequestAuthenticationInstance == null) {
            vj.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (aRequestAuthenticationInstance instanceof UTBaseRequestAuthentication) {
            mh.s(false, aRequestAuthenticationInstance.getAppkey(), ((UTBaseRequestAuthentication) aRequestAuthenticationInstance).getAppSecret(), ((UTBaseRequestAuthentication) aRequestAuthenticationInstance).isEncode() ? DiskLruCache.VERSION_1 : "0");
        } else {
            mh.s(true, aRequestAuthenticationInstance.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) aRequestAuthenticationInstance).getAuthCode());
        }
    }

    @Deprecated
    public void setAppVersion(String aAppVersion) {
        gj.b().i(aAppVersion);
    }

    public synchronized UTTracker getTracker(String aTrackId) {
        if (!TextUtils.isEmpty(aTrackId)) {
            if (this.w.containsKey(aTrackId)) {
                return this.w.get(aTrackId);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.p(aTrackId);
            this.w.put(aTrackId, uTTracker);
            return uTTracker;
        }
        vj.a("getTracker", "TrackId is null.");
        return null;
    }

    public synchronized UTTracker getTrackerByAppkey(String appkey) {
        if (!TextUtils.isEmpty(appkey)) {
            if (this.x.containsKey(appkey)) {
                return this.x.get(appkey);
            }
            UTTracker uTTracker = new UTTracker();
            uTTracker.q(appkey);
            this.x.put(appkey, uTTracker);
            return uTTracker;
        }
        vj.a("getTracker", "TrackId is null.");
        return null;
    }

    @Deprecated
    public void setChannel(String aChannel) {
        mh.r(aChannel);
    }

    @Deprecated
    public void turnOnDebug() {
        gj.b().k();
    }

    public void updateUserAccount(String aUsernick, String aUserid) {
        gj.b().l(aUsernick, aUserid);
    }

    public void userRegister(String aUsernick) {
        if (!TextUtils.isEmpty(aUsernick)) {
            UTTracker defaultTracker = getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, aUsernick, null, null, null).build());
                return;
            } else {
                vj.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
                return;
            }
        }
        vj.a("userRegister", "Fatal Error,usernick can not be null or empty!");
    }

    public void updateSessionProperties(Map<String, String> aMap) {
        Map<String, String> b = kj.a().b();
        HashMap hashMap = new HashMap();
        if (b != null) {
            hashMap.putAll(b);
        }
        hashMap.putAll(aMap);
        kj.a().c(hashMap);
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }
}
