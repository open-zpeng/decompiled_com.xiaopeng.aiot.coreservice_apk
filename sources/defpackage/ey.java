package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubRec.java */
/* renamed from: ey  reason: default package */
/* loaded from: classes.dex */
public class ey extends tx {
    public ey(byte info, byte[] data) throws IOException {
        super((byte) 5);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        dis.close();
    }

    public ey(gy publish) {
        super((byte) 5);
        this.c = publish.p();
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return l();
    }
}
