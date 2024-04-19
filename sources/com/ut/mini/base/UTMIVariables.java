package com.ut.mini.base;

import com.ut.mini.sdkevents.UTMI1010_2001Event;
/* loaded from: classes.dex */
public class UTMIVariables {
    private static UTMIVariables a = new UTMIVariables();
    private String an = null;
    private String ak = null;
    private String ao = null;

    /* renamed from: a  reason: collision with other field name */
    private UTMI1010_2001Event f90a = null;
    private boolean R = false;

    public synchronized void setToAliyunOSPlatform() {
        this.R = true;
    }

    public synchronized boolean isAliyunOSPlatform() {
        return this.R;
    }

    public synchronized void setUTMI1010_2001EventInstance(UTMI1010_2001Event aInstance) {
        this.f90a = aInstance;
    }

    public synchronized UTMI1010_2001Event getUTMI1010_2001EventInstance() {
        return this.f90a;
    }

    public static UTMIVariables getInstance() {
        return a;
    }

    public String getH5Url() {
        return this.ao;
    }

    public void setH5Url(String aH5Url) {
        this.ao = aH5Url;
    }

    public String getRefPage() {
        return this.ak;
    }

    public void setRefPage(String aRefPage) {
        this.ak = aRefPage;
    }

    public String getH5RefPage() {
        return this.an;
    }

    public void setH5RefPage(String aH5PrePage) {
        this.an = aH5PrePage;
    }
}
