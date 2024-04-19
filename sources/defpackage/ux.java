package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttConnack.java */
/* renamed from: ux  reason: default package */
/* loaded from: classes.dex */
public class ux extends tx {
    public int e;
    public boolean f;

    public ux(byte info, byte[] variableHeader) throws IOException {
        super((byte) 2);
        ByteArrayInputStream bais = new ByteArrayInputStream(variableHeader);
        DataInputStream dis = new DataInputStream(bais);
        this.f = (dis.readUnsignedByte() & 1) == 1;
        this.e = dis.readUnsignedByte();
        dis.close();
    }

    public int y() {
        return this.e;
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return new byte[0];
    }

    @Override // defpackage.my
    public boolean u() {
        return false;
    }

    @Override // defpackage.my
    public String o() {
        return "Con";
    }

    @Override // defpackage.tx, defpackage.my
    public String toString() {
        return String.valueOf(super.toString()) + " session present:" + this.f + " return code: " + this.e;
    }
}
