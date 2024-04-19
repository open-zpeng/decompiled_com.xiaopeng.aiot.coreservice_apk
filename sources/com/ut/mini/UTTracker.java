package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UTTracker {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private String g;
    private String am = null;
    private Map<String, String> D = new HashMap();

    public void p(String str) {
        this.am = str;
    }

    public synchronized void setGlobalProperty(String aKey, String aValue) {
        if (!TextUtils.isEmpty(aKey) && aValue != null) {
            this.D.put(aKey, aValue);
        } else {
            vj.a("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    public synchronized String getGlobalProperty(String aKey) {
        if (aKey != null) {
            return this.D.get(aKey);
        }
        return null;
    }

    public synchronized void removeGlobalProperty(String aKey) {
        if (aKey != null) {
            if (this.D.containsKey(aKey)) {
                this.D.remove(aKey);
            }
        }
    }

    private static String f(String str) {
        if (str != null && !"".equals(str)) {
            return a.matcher(str).replaceAll("");
        }
        return str;
    }

    private static String d(String str) {
        return f(str);
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = map.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        hashMap.put(next, d(map.get(next)));
                    }
                }
            }
            return hashMap;
        }
        return null;
    }

    public void send(Map<String, String> aLogMap) {
        if (aLogMap != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.D);
            hashMap.putAll(aLogMap);
            if (!TextUtils.isEmpty(this.g)) {
                hashMap.put(LogField.APPKEY.toString(), this.g);
            }
            Map<String, String> g = g((Map<String, String>) hashMap);
            if (!TextUtils.isEmpty(this.am)) {
                g.put(UTFields.TRACK_ID, this.am);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g);
            d(g);
            m47g(g);
            h(g);
            ej.d(g.remove(LogField.PAGE.toString()), g.remove(LogField.EVENTID.toString()), g.remove(LogField.ARG1.toString()), g.remove(LogField.ARG2.toString()), g.remove(LogField.ARG3.toString()), g);
        }
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            LogField logField = LogField.IMEI;
            if (map.containsKey(logField.toString())) {
                map.remove(logField.toString());
            }
            LogField logField2 = LogField.IMSI;
            if (map.containsKey(logField2.toString())) {
                map.remove(logField2.toString());
            }
            LogField logField3 = LogField.CARRIER;
            if (map.containsKey(logField3.toString())) {
                map.remove(logField3.toString());
            }
            LogField logField4 = LogField.ACCESS;
            if (map.containsKey(logField4.toString())) {
                map.remove(logField4.toString());
            }
            LogField logField5 = LogField.ACCESS_SUBTYPE;
            if (map.containsKey(logField5.toString())) {
                map.remove(logField5.toString());
            }
            LogField logField6 = LogField.CHANNEL;
            if (map.containsKey(logField6.toString())) {
                map.remove(logField6.toString());
            }
            LogField logField7 = LogField.LL_USERNICK;
            if (map.containsKey(logField7.toString())) {
                map.remove(logField7.toString());
            }
            LogField logField8 = LogField.USERNICK;
            if (map.containsKey(logField8.toString())) {
                map.remove(logField8.toString());
            }
            LogField logField9 = LogField.LL_USERID;
            if (map.containsKey(logField9.toString())) {
                map.remove(logField9.toString());
            }
            LogField logField10 = LogField.USERID;
            if (map.containsKey(logField10.toString())) {
                map.remove(logField10.toString());
            }
            LogField logField11 = LogField.SDKVERSION;
            if (map.containsKey(logField11.toString())) {
                map.remove(logField11.toString());
            }
            LogField logField12 = LogField.START_SESSION_TIMESTAMP;
            if (map.containsKey(logField12.toString())) {
                map.remove(logField12.toString());
            }
            LogField logField13 = LogField.UTDID;
            if (map.containsKey(logField13.toString())) {
                map.remove(logField13.toString());
            }
            LogField logField14 = LogField.SDKTYPE;
            if (map.containsKey(logField14.toString())) {
                map.remove(logField14.toString());
            }
            LogField logField15 = LogField.RESERVE2;
            if (map.containsKey(logField15.toString())) {
                map.remove(logField15.toString());
            }
            LogField logField16 = LogField.RESERVE3;
            if (map.containsKey(logField16.toString())) {
                map.remove(logField16.toString());
            }
            LogField logField17 = LogField.RESERVE4;
            if (map.containsKey(logField17.toString())) {
                map.remove(logField17.toString());
            }
            LogField logField18 = LogField.RESERVE5;
            if (map.containsKey(logField18.toString())) {
                map.remove(logField18.toString());
            }
            LogField logField19 = LogField.RESERVES;
            if (map.containsKey(logField19.toString())) {
                map.remove(logField19.toString());
            }
            LogField logField20 = LogField.RECORD_TIMESTAMP;
            if (map.containsKey(logField20.toString())) {
                map.remove(logField20.toString());
            }
        }
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(UTFields.OS)) {
                map.remove(UTFields.OS);
                map.put(LogField.OS.toString(), map.get(UTFields.OS));
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                map.remove(UTFields.OS_VERSION);
                map.put(LogField.OSVERSION.toString(), map.get(UTFields.OS_VERSION));
            }
        }
    }

    /* renamed from: g  reason: collision with other method in class */
    private static void m47g(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }

    private static void h(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(LogField.RESERVES.toString(), ck.c(hashMap));
        }
        LogField logField = LogField.PAGE;
        if (!map.containsKey(logField.toString())) {
            map.put(logField.toString(), "UT");
        }
    }

    public void pageAppear(Object aPageObject) {
        UTPageHitHelper.getInstance().pageAppear(aPageObject);
    }

    public void pageAppearDonotSkip(Object aPageObject) {
        UTPageHitHelper.getInstance().a(aPageObject, null, true);
    }

    public void pageAppearDonotSkip(Object aPageObject, String aCustomPageName) {
        UTPageHitHelper.getInstance().a(aPageObject, aCustomPageName, true);
    }

    public void pageAppear(Object aPageObject, String aCustomPageName) {
        UTPageHitHelper.getInstance().pageAppear(aPageObject, aCustomPageName);
    }

    public void pageDisAppear(Object aPageObject) {
        UTPageHitHelper.getInstance().pageDisAppear(aPageObject);
    }

    public void updateNextPageProperties(Map<String, String> aProperties) {
        UTPageHitHelper.getInstance().updateNextPageProperties(aProperties);
    }

    public void updatePageName(Object aPageObject, String aPageName) {
        UTPageHitHelper.getInstance().updatePageName(aPageObject, aPageName);
    }

    public void updatePageProperties(Object aPageObject, Map<String, String> aProperties) {
        UTPageHitHelper.getInstance().updatePageProperties(aPageObject, aProperties);
    }

    public void updatePageStatus(Object aPageObject, UTPageStatus aPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(aPageObject, aPageStatus);
    }

    public void updatePageUrl(Object aPageObject, Uri aUri) {
        UTPageHitHelper.getInstance().updatePageUrl(aPageObject, aUri);
    }

    public void skipPage(Object aPageObject) {
        UTPageHitHelper.getInstance().skipPage(aPageObject);
    }

    public void q(String str) {
        this.g = str;
    }
}
