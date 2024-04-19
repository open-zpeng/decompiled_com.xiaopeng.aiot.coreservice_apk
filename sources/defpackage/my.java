package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
/* compiled from: MqttWireMessage.java */
/* renamed from: my  reason: default package */
/* loaded from: classes.dex */
public abstract class my {
    public static final String[] a = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    public byte b;
    public boolean d = false;
    public int c = 0;

    public abstract byte q();

    public abstract byte[] t() throws iw;

    public my(byte type) {
        this.b = type;
    }

    public byte[] r() throws iw {
        return new byte[0];
    }

    public byte s() {
        return this.b;
    }

    public int p() {
        return this.c;
    }

    public void x(int msgId) {
        this.c = msgId;
    }

    public String o() {
        return new Integer(p()).toString();
    }

    public byte[] n() throws iw {
        try {
            int first = ((s() & 15) << 4) ^ (q() & 15);
            byte[] varHeader = t();
            int remLen = varHeader.length + r().length;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeByte(first);
            dos.write(k(remLen));
            dos.write(varHeader);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new iw(ioe);
        }
    }

    public boolean u() {
        return true;
    }

    public static my h(kw data) throws iw {
        byte[] payload = data.c();
        if (payload == null) {
            payload = new byte[0];
        }
        ny mbais = new ny(data.e(), data.b(), data.f(), payload, data.d(), data.a());
        return g(mbais);
    }

    public static my i(byte[] bytes) throws iw {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return g(bais);
    }

    public static my g(InputStream inputStream) throws iw {
        try {
            sx counter = new sx(inputStream);
            DataInputStream in = new DataInputStream(counter);
            int first = in.readUnsignedByte();
            byte type = (byte) (first >> 4);
            byte info = (byte) (first & 15);
            long remLen = v(in).a();
            long totalToRead = counter.a() + remLen;
            long remainder = totalToRead - counter.a();
            byte[] data = new byte[0];
            if (remainder > 0) {
                data = new byte[(int) remainder];
                in.readFully(data, 0, data.length);
            }
            if (type == 1) {
                my result = new vx(info, data);
                return result;
            } else if (type == 3) {
                my result2 = new gy(info, data);
                return result2;
            } else if (type == 4) {
                my result3 = new cy(info, data);
                return result3;
            } else if (type == 7) {
                my result4 = new dy(info, data);
                return result4;
            } else if (type == 2) {
                my result5 = new ux(info, data);
                return result5;
            } else if (type == 12) {
                my result6 = new ay(info, data);
                return result6;
            } else if (type == 13) {
                my result7 = new by(info, data);
                return result7;
            } else if (type == 8) {
                my result8 = new jy(info, data);
                return result8;
            } else if (type == 9) {
                my result9 = new iy(info, data);
                return result9;
            } else if (type == 10) {
                my result10 = new ly(info, data);
                return result10;
            } else if (type == 11) {
                my result11 = new ky(info, data);
                return result11;
            } else if (type == 6) {
                my result12 = new fy(info, data);
                return result12;
            } else if (type == 5) {
                my result13 = new ey(info, data);
                return result13;
            } else if (type == 14) {
                my result14 = new wx(info, data);
                return result14;
            } else {
                throw yw.a(6);
            }
        } catch (IOException io) {
            throw new iw(io);
        }
    }

    public static byte[] k(long number) {
        int numBytes = 0;
        long no = number;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        do {
            byte digit = (byte) (no % 128);
            no /= 128;
            if (no > 0) {
                digit = (byte) (digit | 128);
            }
            bos.write(digit);
            numBytes++;
            if (no <= 0) {
                break;
            }
        } while (numBytes < 4);
        return bos.toByteArray();
    }

    public static oy v(DataInputStream in) throws IOException {
        byte digit;
        long msgLength = 0;
        int multiplier = 1;
        int count = 0;
        do {
            digit = in.readByte();
            count++;
            msgLength += (digit & Byte.MAX_VALUE) * multiplier;
            multiplier *= 128;
        } while ((digit & 128) != 0);
        return new oy(msgLength, count);
    }

    public byte[] l() throws iw {
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

    public void w(boolean duplicate) {
        this.d = duplicate;
    }

    public void m(DataOutputStream dos, String stringToEncode) throws iw {
        try {
            byte[] encodedString = stringToEncode.getBytes(XmartV1Constants.UTF8_ENCODING);
            byte byte1 = (byte) ((encodedString.length >>> 8) & 255);
            byte byte2 = (byte) ((encodedString.length >>> 0) & 255);
            dos.write(byte1);
            dos.write(byte2);
            dos.write(encodedString);
        } catch (UnsupportedEncodingException ex) {
            throw new iw(ex);
        } catch (IOException ex2) {
            throw new iw(ex2);
        }
    }

    public String j(DataInputStream input) throws iw {
        try {
            int encodedLength = input.readUnsignedShort();
            byte[] encodedString = new byte[encodedLength];
            input.readFully(encodedString);
            return new String(encodedString, XmartV1Constants.UTF8_ENCODING);
        } catch (IOException ex) {
            throw new iw(ex);
        }
    }

    public String toString() {
        return a[this.b];
    }
}
