package defpackage;
/* compiled from: MqttPersistentData.java */
/* renamed from: cx  reason: default package */
/* loaded from: classes.dex */
public class cx implements kw {
    public String a;
    public byte[] b;
    public int c;
    public int d;
    public byte[] e;
    public int f;
    public int g;

    public cx(String key, byte[] header, int hOffset, int hLength, byte[] payload, int pOffset, int pLength) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.a = key;
        this.b = header;
        this.c = hOffset;
        this.d = hLength;
        this.e = payload;
        this.f = pOffset;
        this.g = pLength;
    }

    @Override // defpackage.kw
    public byte[] e() {
        return this.b;
    }

    @Override // defpackage.kw
    public int f() {
        return this.d;
    }

    @Override // defpackage.kw
    public int b() {
        return this.c;
    }

    @Override // defpackage.kw
    public byte[] c() {
        return this.e;
    }

    @Override // defpackage.kw
    public int a() {
        if (this.e == null) {
            return 0;
        }
        return this.g;
    }

    @Override // defpackage.kw
    public int d() {
        return this.f;
    }
}
