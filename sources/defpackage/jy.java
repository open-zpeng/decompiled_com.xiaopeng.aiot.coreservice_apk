package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttSubscribe.java */
/* renamed from: jy  reason: default package */
/* loaded from: classes.dex */
public class jy extends my {
    public String[] e;
    public int[] f;
    public int g;

    public jy(byte info, byte[] data) throws IOException {
        super((byte) 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        this.c = dis.readUnsignedShort();
        this.g = 0;
        this.e = new String[10];
        this.f = new int[10];
        boolean end = false;
        while (!end) {
            try {
                this.e[this.g] = j(dis);
                int[] iArr = this.f;
                int i = this.g;
                this.g = i + 1;
                iArr[i] = dis.readByte();
            } catch (Exception e) {
                end = true;
            }
        }
        dis.close();
    }

    public jy(String[] names, int[] qos) {
        super((byte) 8);
        this.e = names;
        this.f = qos;
        if (names.length != qos.length) {
            throw new IllegalArgumentException();
        }
        this.g = names.length;
        for (int i : qos) {
            jw.k(i);
        }
    }

    @Override // defpackage.my
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(" names:[");
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("\"");
            sb.append(this.e[i]);
            sb.append("\"");
        }
        sb.append("] qos:[");
        for (int i2 = 0; i2 < this.g; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(this.f[i2]);
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
                    dos.writeByte(this.f[i]);
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
