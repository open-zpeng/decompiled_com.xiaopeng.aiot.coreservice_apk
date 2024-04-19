package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss;

import android.os.SystemProperties;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage.IRemoteStorage;
/* loaded from: classes.dex */
public class Bucket {
    public static String BUCKET_AND_ENDPOINT = null;
    public static String END_POINT = null;
    public static final String END_POINT_DOMAIN = "oss-cn-hangzhou.aliyuncs.com/";
    public static final String END_POINT_DOMAIN_INT = "oss-eu-central-1.aliyuncs.com/";
    private static final long MAX_LOG_LENGTH = 20971520;
    private static final String SCHEMA = "https://";
    public static String TOKEN_URL_V5;
    private String mRootName;
    private String mUrl;

    static {
        TOKEN_URL_V5 = yn.d + "/v5/aliyun/token";
        END_POINT = "https://oss-cn-hangzhou.aliyuncs.com/";
        BUCKET_AND_ENDPOINT = "https://%s.oss-cn-hangzhou.aliyuncs.com/";
        try {
            boolean international = !getVersionInCountryCode().contains("ZH");
            pn.l("Bucket", "Version = " + getVersionInCountryCode() + ", international = " + international);
            if (international) {
                TOKEN_URL_V5 = "https://xmart-eu.xiaopeng.com/biz/v5/aliyun/token";
                END_POINT = "https://oss-eu-central-1.aliyuncs.com/";
                BUCKET_AND_ENDPOINT = "https://%s.oss-eu-central-1.aliyuncs.com/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.xiaopeng.lib.framework.netchannelmodule.remotestorage.oss.Bucket$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY;

        static {
            int[] iArr = new int[IRemoteStorage.CATEGORY.values().length];
            $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY = iArr;
            try {
                iArr[IRemoteStorage.CATEGORY.CAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY[IRemoteStorage.CATEGORY.CDU.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static Bucket get(IRemoteStorage.CATEGORY item) {
        switch (AnonymousClass1.$SwitchMap$com$xiaopeng$lib$framework$moduleinterface$netchannelmodule$remotestorage$IRemoteStorage$CATEGORY[item.ordinal()]) {
            case 1:
                return new CanBucket(null);
            case 2:
                return new CduBucket(null);
            default:
                throw new RuntimeException("Wrong bucket was specified!");
        }
    }

    public Bucket(String rootName) {
        this.mRootName = rootName;
        this.mUrl = String.format(BUCKET_AND_ENDPOINT, rootName);
    }

    private Bucket() {
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getRootName() {
        return this.mRootName;
    }

    public long getMaxObjectSize() {
        return MAX_LOG_LENGTH;
    }

    public String generateObjectKey(String moduleName) {
        long timeStamp = System.currentTimeMillis();
        return this.mRootName + "/" + moduleName + "/" + co.e() + "/" + nn.c(timeStamp) + "/" + un.g() + "/" + timeStamp + ".zip";
    }

    /* loaded from: classes.dex */
    public static final class CduBucket extends Bucket {
        private static final String CDU_BUCKET_NAME = "xmart-cdu-service-log";

        public /* synthetic */ CduBucket(AnonymousClass1 x0) {
            this();
        }

        private CduBucket() {
            super(CDU_BUCKET_NAME);
        }
    }

    /* loaded from: classes.dex */
    public static final class CanBucket extends Bucket {
        private static final String CAN_BUCKET_NAME = "xmart-can-service-log";

        public /* synthetic */ CanBucket(AnonymousClass1 x0) {
            this();
        }

        private CanBucket() {
            super(CAN_BUCKET_NAME);
        }
    }

    public static String getVersionInCountryCode() throws Exception {
        String versionFinger = SystemProperties.get("ro.xiaopeng.software", "");
        if (!"".equals(versionFinger) && versionFinger != null && versionFinger.length() >= 9) {
            String countryCode = versionFinger.substring(7, 9);
            return countryCode;
        }
        return versionFinger;
    }
}
