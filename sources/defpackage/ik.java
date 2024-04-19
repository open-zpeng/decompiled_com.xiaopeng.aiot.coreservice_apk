package defpackage;
/* compiled from: BaseRequestAuth.java */
/* renamed from: ik  reason: default package */
/* loaded from: classes.dex */
public class ik implements jk {
    public String a;
    public String b;
    public boolean c;

    @Override // defpackage.jk
    public String getAppkey() {
        return this.a;
    }

    public ik(String aAppkey, String aAppSecret, boolean isEncode) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = aAppkey;
        this.b = aAppSecret;
        this.c = isEncode;
    }

    public boolean a() {
        return this.c;
    }

    @Override // defpackage.jk
    public String getSign(String toBeSignedStr) {
        if (this.a == null || this.b == null) {
            vj.c("BaseRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (toBeSignedStr == null) {
            return null;
        } else {
            return wj.a(wj.b((toBeSignedStr + this.b).getBytes()));
        }
    }
}
