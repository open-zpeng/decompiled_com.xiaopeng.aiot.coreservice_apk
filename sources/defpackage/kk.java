package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
/* compiled from: SecurityRequestAuth.java */
/* renamed from: kk  reason: default package */
/* loaded from: classes.dex */
public class kk implements jk {
    public String a;
    public String b;
    public Object c = null;
    public Object d = null;
    public Class e = null;
    public Field f = null;
    public Field g = null;
    public Field h = null;
    public Method i = null;
    public int j = 1;
    public boolean k = false;

    @Override // defpackage.jk
    public String getAppkey() {
        return this.a;
    }

    public kk(String aAppkey, String authCode) {
        this.a = null;
        this.a = aAppkey;
        this.b = authCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[Catch: all -> 0x00cb, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:41:0x00d5, B:15:0x0042, B:17:0x004b, B:23:0x0085, B:36:0x00af, B:29:0x009d, B:21:0x007b), top: B:47:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kk.a():void");
    }

    @Override // defpackage.jk
    public String getSign(String toBeSignedStr) {
        Class cls;
        if (!this.k) {
            a();
        }
        if (this.a == null) {
            vj.c("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (toBeSignedStr == null || this.c == null || (cls = this.e) == null || this.f == null || this.g == null || this.h == null || this.i == null || this.d == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f.set(newInstance, this.a);
                ((Map) this.g.get(newInstance)).put("INPUT", toBeSignedStr);
                this.h.set(newInstance, Integer.valueOf(this.j));
                return (String) this.i.invoke(this.d, newInstance, this.b);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
