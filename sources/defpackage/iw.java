package defpackage;
/* compiled from: MqttException.java */
/* renamed from: iw  reason: default package */
/* loaded from: classes.dex */
public class iw extends Exception {
    public int a;
    public Throwable b;

    public iw(int reasonCode) {
        this.a = reasonCode;
    }

    public iw(Throwable cause) {
        this.a = 0;
        this.b = cause;
    }

    public iw(int reason, Throwable cause) {
        this.a = reason;
        this.b = cause;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return bx.b(this.a);
    }

    @Override // java.lang.Throwable
    public String toString() {
        String result = String.valueOf(getMessage()) + " (" + this.a + ")";
        if (this.b != null) {
            return String.valueOf(result) + " - " + this.b.toString();
        }
        return result;
    }
}
