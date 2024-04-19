package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubAck.java */
/* renamed from: cy  reason: default package */
/* loaded from: classes.dex */
public class cy extends tx {
    public cy(byte info, byte[] data) throws IOException {
        super((byte) 4);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        dis.close();
    }

    public cy(gy publish) {
        super((byte) 4);
        this.c = publish.p();
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return l();
    }
}
