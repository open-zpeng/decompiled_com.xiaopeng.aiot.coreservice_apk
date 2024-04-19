package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/* compiled from: MqttPublish.java */
/* renamed from: gy  reason: default package */
/* loaded from: classes.dex */
public class gy extends zx {
    public jw e;
    public String f;
    public byte[] g;

    public gy(String name, jw message) {
        super((byte) 3);
        this.g = null;
        this.f = name;
        this.e = message;
    }

    public gy(byte info, byte[] data) throws iw, IOException {
        super((byte) 3);
        this.g = null;
        hy hyVar = new hy();
        this.e = hyVar;
        hyVar.i(3 & (info >> 1));
        if ((info & 1) == 1) {
            this.e.j(true);
        }
        if ((info & 8) == 8) {
            ((hy) this.e).f(true);
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        sx counter = new sx(bais);
        DataInputStream dis = new DataInputStream(counter);
        this.f = j(dis);
        if (this.e.c() > 0) {
            this.c = dis.readUnsignedShort();
        }
        byte[] payload = new byte[data.length - counter.a()];
        dis.readFully(payload);
        dis.close();
        this.e.h(payload);
    }

    @Override // defpackage.my
    public String toString() {
        String string;
        StringBuffer hex = new StringBuffer();
        byte[] payload = this.e.b();
        int limit = Math.min(payload.length, 20);
        for (int i = 0; i < limit; i++) {
            byte b = payload[i];
            String ch = Integer.toHexString(b);
            if (ch.length() == 1) {
                ch = "0" + ch;
            }
            hex.append(ch);
        }
        try {
            string = new String(payload, 0, limit, XmartV1Constants.UTF8_ENCODING);
        } catch (Exception e) {
            string = "?";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append(" qos:");
        sb.append(this.e.c());
        if (this.e.c() > 0) {
            sb.append(" msgId:");
            sb.append(this.c);
        }
        sb.append(" retained:");
        sb.append(this.e.e());
        sb.append(" dup:");
        sb.append(this.d);
        sb.append(" topic:\"");
        sb.append(this.f);
        sb.append("\"");
        sb.append(" payload:[hex:");
        sb.append(hex);
        sb.append(" utf8:\"");
        sb.append(string);
        sb.append("\"");
        sb.append(" length:");
        sb.append(payload.length);
        sb.append("]");
        return sb.toString();
    }

    @Override // defpackage.my
    public byte q() {
        byte info = (byte) (this.e.c() << 1);
        if (this.e.e()) {
            info = (byte) (info | 1);
        }
        if (this.e.d() || this.d) {
            return (byte) (info | 8);
        }
        return info;
    }

    public String A() {
        return this.f;
    }

    public jw z() {
        return this.e;
    }

    public static byte[] y(jw message) {
        return message.b();
    }

    @Override // defpackage.my
    public byte[] r() throws iw {
        if (this.g == null) {
            this.g = y(this.e);
        }
        return this.g;
    }

    @Override // defpackage.zx, defpackage.kw
    public int a() {
        try {
            int length = r().length;
            return length;
        } catch (iw e) {
            return 0;
        }
    }

    @Override // defpackage.my
    public void x(int msgId) {
        super.x(msgId);
        jw jwVar = this.e;
        if (jwVar instanceof hy) {
            ((hy) jwVar).l(msgId);
        }
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            m(dos, this.f);
            if (this.e.c() > 0) {
                dos.writeShort(this.c);
            }
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new iw(ex);
        }
    }

    @Override // defpackage.my
    public boolean u() {
        return true;
    }
}
