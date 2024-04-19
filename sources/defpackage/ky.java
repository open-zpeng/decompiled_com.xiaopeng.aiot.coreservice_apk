package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttUnsubAck.java */
/* renamed from: ky  reason: default package */
/* loaded from: classes.dex */
public class ky extends tx {
    public ky(byte info, byte[] data) throws IOException {
        super((byte) 11);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        dis.close();
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return new byte[0];
    }
}
