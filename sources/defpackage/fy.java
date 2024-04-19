package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubRel.java */
/* renamed from: fy  reason: default package */
/* loaded from: classes.dex */
public class fy extends zx {
    public fy(ey pubRec) {
        super((byte) 6);
        x(pubRec.p());
    }

    public fy(byte info, byte[] data) throws IOException {
        super((byte) 6);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        dis.close();
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return l();
    }

    @Override // defpackage.my
    public byte q() {
        return (byte) ((this.d ? 8 : 0) | 2);
    }

    @Override // defpackage.my
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.c;
    }
}
