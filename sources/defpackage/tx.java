package defpackage;
/* compiled from: MqttAck.java */
/* renamed from: tx  reason: default package */
/* loaded from: classes.dex */
public abstract class tx extends my {
    public tx(byte type) {
        super(type);
    }

    @Override // defpackage.my
    public byte q() {
        return (byte) 0;
    }

    @Override // defpackage.my
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.c;
    }
}
