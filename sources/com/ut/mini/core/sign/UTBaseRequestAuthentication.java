package com.ut.mini.core.sign;
/* loaded from: classes.dex */
public class UTBaseRequestAuthentication implements IUTRequestAuthentication {
    private boolean D;
    private String Y;
    private String g;

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public String getAppSecret() {
        return this.Y;
    }

    public UTBaseRequestAuthentication(String aAppkey, String aAppSecret) {
        this.g = null;
        this.Y = null;
        this.D = false;
        this.g = aAppkey;
        this.Y = aAppSecret;
    }

    public UTBaseRequestAuthentication(String aAppkey, String aAppSecret, boolean isEncode) {
        this.g = null;
        this.Y = null;
        this.D = false;
        this.g = aAppkey;
        this.Y = aAppSecret;
        this.D = isEncode;
    }

    public boolean isEncode() {
        return this.D;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String toBeSignedStr) {
        if (this.g == null || this.Y == null) {
            vj.a("UTBaseRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (toBeSignedStr == null) {
            return null;
        } else {
            return wj.a(wj.b((toBeSignedStr + this.Y).getBytes()));
        }
    }
}
