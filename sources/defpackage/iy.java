package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/* compiled from: MqttSuback.java */
/* renamed from: iy  reason: default package */
/* loaded from: classes.dex */
public class iy extends tx {
    public int[] e;

    public iy(byte info, byte[] data) throws IOException {
        super((byte) 9);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        int index = 0;
        this.e = new int[data.length - 2];
        for (int qos = dis.read(); qos != -1; qos = dis.read()) {
            this.e[index] = qos;
            index++;
        }
        dis.close();
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return new byte[0];
    }

    @Override // defpackage.tx, defpackage.my
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(" granted Qos");
        for (int i = 0; i < this.e.length; i++) {
            sb.append(" ");
            sb.append(this.e[i]);
        }
        return sb.toString();
    }
}
