package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttUnsubscribe.java */
/* renamed from: ly  reason: default package */
/* loaded from: classes.dex */
public class ly extends my {
    public String[] e;
    public int f;

    public ly(byte info, byte[] data) throws IOException {
        super((byte) 10);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        this.f = 0;
        this.e = new String[10];
        boolean end = false;
        while (!end) {
            try {
                this.e[this.f] = j(dis);
            } catch (Exception e) {
                end = true;
            }
        }
        dis.close();
    }

    @Override // defpackage.my
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(" names:[");
        for (int i = 0; i < this.f; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("\"" + this.e[i] + "\"");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // defpackage.my
    public byte q() {
        return (byte) ((this.d ? 8 : 0) | 2);
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeShort(this.c);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new iw(ex);
        }
    }

    @Override // defpackage.my
    public byte[] r() throws iw {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            int i = 0;
            while (true) {
                String[] strArr = this.e;
                if (i < strArr.length) {
                    m(dos, strArr[i]);
                    i++;
                } else {
                    dos.flush();
                    return baos.toByteArray();
                }
            }
        } catch (IOException ex) {
            throw new iw(ex);
        }
    }
}
