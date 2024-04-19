package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttConnect.java */
/* renamed from: vx  reason: default package */
/* loaded from: classes.dex */
public class vx extends my {
    public String e;
    public boolean f;
    public jw g;
    public String h;
    public char[] i;
    public int j;
    public String k;
    public int l;

    public vx(byte info, byte[] data) throws IOException, iw {
        super((byte) 1);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        j(dis);
        dis.readByte();
        dis.readByte();
        this.j = dis.readUnsignedShort();
        this.e = j(dis);
        dis.close();
    }

    public vx(String clientId, int MqttVersion, boolean cleanSession, int keepAliveInterval, String userName, char[] password, jw willMessage, String willDestination) {
        super((byte) 1);
        this.e = clientId;
        this.f = cleanSession;
        this.j = keepAliveInterval;
        this.h = userName;
        this.i = password;
        this.g = willMessage;
        this.k = willDestination;
        this.l = MqttVersion;
    }

    @Override // defpackage.my
    public String toString() {
        String rc = super.toString();
        return String.valueOf(rc) + " clientId " + this.e + " keepAliveInterval " + this.j;
    }

    @Override // defpackage.my
    public byte q() {
        return (byte) 0;
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            int i = this.l;
            if (i == 3) {
                m(dos, "MQIsdp");
            } else if (i == 4) {
                m(dos, "MQTT");
            }
            dos.write(this.l);
            byte connectFlags = 0;
            if (this.f) {
                connectFlags = (byte) (0 | 2);
            }
            jw jwVar = this.g;
            if (jwVar != null) {
                connectFlags = (byte) ((jwVar.c() << 3) | ((byte) (connectFlags | 4)));
                if (this.g.e()) {
                    connectFlags = (byte) (connectFlags | 32);
                }
            }
            if (this.h != null) {
                connectFlags = (byte) (connectFlags | 128);
                if (this.i != null) {
                    connectFlags = (byte) (connectFlags | 64);
                }
            }
            dos.write(connectFlags);
            dos.writeShort(this.j);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new iw(ioe);
        }
    }

    @Override // defpackage.my
    public byte[] r() throws iw {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            m(dos, this.e);
            if (this.g != null) {
                m(dos, this.k);
                dos.writeShort(this.g.b().length);
                dos.write(this.g.b());
            }
            String str = this.h;
            if (str != null) {
                m(dos, str);
                if (this.i != null) {
                    m(dos, new String(this.i));
                }
            }
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new iw(ex);
        }
    }

    @Override // defpackage.my
    public boolean u() {
        return false;
    }

    @Override // defpackage.my
    public String o() {
        return "Con";
    }
}
