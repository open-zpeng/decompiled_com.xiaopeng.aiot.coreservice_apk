package com.ut.mini.core.sign;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes.dex */
public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private String Z;
    private String g;
    private Object b = null;
    private Object c = null;
    private Class a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f92a = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f94b = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f95c = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f93a = null;
    private int z = 1;
    private boolean E = false;

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public UTSecuritySDKRequestAuthentication(String aAppkey, String authCode) {
        this.g = null;
        this.g = aAppkey;
        this.Z = authCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[Catch: all -> 0x00d5, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:41:0x00e1, B:15:0x0046, B:17:0x0051, B:23:0x008d, B:36:0x00b9, B:18:0x0077, B:26:0x009d), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void E() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication.E():void");
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String toBeSignedStr) {
        Class cls;
        if (!this.E) {
            E();
        }
        if (this.g == null) {
            vj.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        } else if (toBeSignedStr == null || this.b == null || (cls = this.a) == null || this.f92a == null || this.f94b == null || this.f95c == null || this.f93a == null || this.c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f92a.set(newInstance, this.g);
                ((Map) this.f94b.get(newInstance)).put("INPUT", toBeSignedStr);
                this.f95c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f93a.invoke(this.c, newInstance, this.Z);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                return null;
            }
        }
    }

    public String getAuthCode() {
        return this.Z;
    }
}
