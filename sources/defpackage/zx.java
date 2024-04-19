package defpackage;
/* compiled from: MqttPersistableWireMessage.java */
/* renamed from: zx  reason: default package */
/* loaded from: classes.dex */
public abstract class zx extends my implements kw {
    public zx(byte type) {
        super(type);
    }

    @Override // defpackage.kw
    public byte[] e() throws lw {
        try {
            return n();
        } catch (iw ex) {
            throw new lw(ex.getCause());
        }
    }

    @Override // defpackage.kw
    public int f() throws lw {
        return e().length;
    }

    @Override // defpackage.kw
    public int b() throws lw {
        return 0;
    }

    @Override // defpackage.kw
    public byte[] c() throws lw {
        try {
            return r();
        } catch (iw ex) {
            throw new lw(ex.getCause());
        }
    }

    public int a() throws lw {
        return 0;
    }

    @Override // defpackage.kw
    public int d() throws lw {
        return 0;
    }
}
