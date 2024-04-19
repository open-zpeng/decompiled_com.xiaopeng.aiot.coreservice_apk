package defpackage;

import java.util.Map;
/* compiled from: UTMCVariables.java */
/* renamed from: kj  reason: default package */
/* loaded from: classes.dex */
public class kj {
    public static final kj a = new kj();
    public boolean b = false;
    public boolean c = false;
    public String d = null;
    public Map<String, String> e = null;
    public boolean f = false;
    public boolean g = false;
    public String h = null;
    public String i = null;
    public String j = null;
    public boolean k = false;

    public static kj a() {
        return a;
    }

    public synchronized void e(String str) {
        this.h = str;
    }

    public synchronized void f() {
        this.g = true;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public synchronized void c(Map<String, String> map) {
        this.e = map;
    }

    public synchronized Map<String, String> b() {
        return this.e;
    }
}
