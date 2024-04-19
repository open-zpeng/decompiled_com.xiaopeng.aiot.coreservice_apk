package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttPubComp.java */
/* renamed from: dy  reason: default package */
/* loaded from: classes.dex */
public class dy extends tx {
    public dy(byte info, byte[] data) throws IOException {
        super((byte) 7);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        dis.close();
    }

    public dy(gy publish) {
        super((byte) 7);
        this.c = publish.p();
    }

    public dy(int msgId) {
        super((byte) 7);
        this.c = msgId;
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return l();
    }
}
