package com.xiaopeng.datalog.bean;

import androidx.annotation.Keep;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class LogEvent {
    private String dbcVer;
    private String device;
    private String iccid;
    private String model;
    private List<Object> msg;
    private int packageId;
    private int ref;
    private String sid;
    private String sysVer;
    private long t;
    private long uid;
    private int v = 3;
    private int vid;
    private String vin;

    private LogEvent() {
    }

    public String getDevice() {
        return this.device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getVid() {
        return this.vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getSysVer() {
        return this.sysVer;
    }

    public void setSysVer(String sysVer) {
        this.sysVer = sysVer;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public long getUid() {
        return this.uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getT() {
        return this.t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public int getRef() {
        return this.ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getV() {
        return this.v;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public List<Object> getMsg() {
        return this.msg;
    }

    public void setMsg(List<Object> msg) {
        this.msg = msg;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDbcVer() {
        return this.dbcVer;
    }

    public void setDbcVer(String dbcVer) {
        this.dbcVer = dbcVer;
    }

    public String getIccid() {
        return this.iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public static LogEvent create(RefType refType) {
        LogEvent log = new LogEvent();
        log.setDevice(un.c());
        log.setVin(un.f());
        log.setSysVer(getSystemVersion());
        log.setSid(un.e());
        log.setUid(un.a());
        log.setT(System.currentTimeMillis());
        log.setRef(refType.getRefType());
        log.setModel(Cdo.a());
        log.setDbcVer(un.b());
        log.setIccid(un.d());
        return log;
    }

    /* loaded from: classes.dex */
    public enum RefType {
        CAN(2),
        CDU(1);
        
        private int refType;

        RefType(int refType) {
            this.refType = refType;
        }

        public int getRefType() {
            return this.refType;
        }
    }

    /* loaded from: classes.dex */
    public enum LogType {
        TIME(1),
        EXCEPTION(2),
        CUSTOMIZED(3);
        
        private int logType;

        LogType(int logType) {
            this.logType = logType;
        }

        public int getLogType() {
            return this.logType;
        }
    }

    /* loaded from: classes.dex */
    public enum SrcType {
        XMART_ROM(1),
        XMART_APP(2),
        XMART_THIRD_APP(3),
        ANDROID_APP(4);
        
        private int srcType;

        SrcType(int srcType) {
            this.srcType = srcType;
        }

        public int getSrcType() {
            return this.srcType;
        }

        public static SrcType from(int i) {
            switch (i) {
                case 1:
                    return XMART_ROM;
                case 2:
                    return XMART_APP;
                case 3:
                    return XMART_THIRD_APP;
                case 4:
                    return ANDROID_APP;
                default:
                    throw new IllegalArgumentException("Invalid arg:" + i);
            }
        }
    }

    public static SrcType from(int srcType) {
        switch (srcType) {
            case 1:
                return SrcType.XMART_ROM;
            case 2:
                return SrcType.XMART_APP;
            case 3:
                return SrcType.XMART_THIRD_APP;
            case 4:
                return SrcType.ANDROID_APP;
            default:
                throw new IllegalArgumentException("invalid type " + srcType + ", must be [1, 4]");
        }
    }

    public static String getSystemVersion() {
        String software = un.e();
        String[] split = software.split("_");
        if (split.length > 1) {
            return split[1];
        }
        return "unknown";
    }
}
