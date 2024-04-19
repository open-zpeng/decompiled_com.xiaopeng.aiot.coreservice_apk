package defpackage;
/* compiled from: DisconnectedBufferOptions.java */
/* renamed from: wv  reason: default package */
/* loaded from: classes.dex */
public class wv {
    public int a = 5000;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;

    public int a() {
        return this.a;
    }

    public void f(int bufferSize) {
        if (bufferSize < 1) {
            throw new IllegalArgumentException();
        }
        this.a = bufferSize;
    }

    public boolean b() {
        return this.b;
    }

    public void e(boolean bufferEnabled) {
        this.b = bufferEnabled;
    }

    public boolean d() {
        return this.c;
    }

    public void h(boolean persistBuffer) {
        this.c = persistBuffer;
    }

    public boolean c() {
        return this.d;
    }

    public void g(boolean deleteOldestMessages) {
        this.d = deleteOldestMessages;
    }
}
