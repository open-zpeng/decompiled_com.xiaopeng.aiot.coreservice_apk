package defpackage;
/* compiled from: MqttMessage.java */
/* renamed from: jw  reason: default package */
/* loaded from: classes.dex */
public class jw {
    public byte[] b;
    public int h;
    public boolean a = true;
    public int d = 1;
    public boolean f = false;
    public boolean g = false;

    public static void k(int qos) {
        if (qos < 0 || qos > 2) {
            throw new IllegalArgumentException();
        }
    }

    public jw() {
        h(new byte[0]);
    }

    public jw(byte[] payload) {
        h(payload);
    }

    public byte[] b() {
        return this.b;
    }

    public void h(byte[] payload) {
        a();
        if (payload == null) {
            throw new NullPointerException();
        }
        this.b = payload;
    }

    public boolean e() {
        return this.f;
    }

    public void j(boolean retained) {
        a();
        this.f = retained;
    }

    public int c() {
        return this.d;
    }

    public void i(int qos) {
        a();
        k(qos);
        this.d = qos;
    }

    public String toString() {
        return new String(this.b);
    }

    public void a() throws IllegalStateException {
        if (!this.a) {
            throw new IllegalStateException();
        }
    }

    public void f(boolean dup) {
        this.g = dup;
    }

    public boolean d() {
        return this.g;
    }

    public void g(int messageId) {
        this.h = messageId;
    }
}
