package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
/* compiled from: WebSocketFrame.java */
/* renamed from: nx  reason: default package */
/* loaded from: classes.dex */
public class nx {
    public byte a;
    public boolean b;
    public byte[] c;
    public boolean d;

    public byte[] f() {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public nx(byte opcode, boolean fin, byte[] payload) {
        this.d = false;
        this.a = opcode;
        this.b = fin;
        this.c = payload;
    }

    public final void h(byte incomingByte) {
        this.b = (incomingByte & 128) != 0;
        this.a = (byte) (incomingByte & 15);
    }

    public nx(InputStream input) throws IOException {
        this.d = false;
        byte firstByte = (byte) input.read();
        h(firstByte);
        byte b = this.a;
        if (b == 2) {
            byte maskLengthByte = (byte) input.read();
            boolean masked = (maskLengthByte & 128) != 0;
            int payloadLength = (byte) (maskLengthByte & Byte.MAX_VALUE);
            int byteCount = 0;
            if (payloadLength == 127) {
                byteCount = 8;
            } else if (payloadLength == 126) {
                byteCount = 2;
            }
            payloadLength = byteCount > 0 ? 0 : payloadLength;
            while (true) {
                byteCount--;
                if (byteCount < 0) {
                    break;
                }
                payloadLength |= (((byte) input.read()) & 255) << (byteCount * 8);
            }
            byte[] maskingKey = null;
            if (masked) {
                maskingKey = new byte[4];
                input.read(maskingKey, 0, 4);
            }
            this.c = new byte[payloadLength];
            int offsetIndex = 0;
            int tempLength = payloadLength;
            while (offsetIndex != payloadLength) {
                int bytesRead = input.read(this.c, offsetIndex, tempLength);
                offsetIndex += bytesRead;
                tempLength -= bytesRead;
            }
            if (masked) {
                int i = 0;
                while (true) {
                    byte[] bArr = this.c;
                    if (i < bArr.length) {
                        bArr[i] = (byte) (bArr[i] ^ maskingKey[i % 4]);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        } else if (b == 8) {
            this.d = true;
        } else {
            throw new IOException("Invalid Frame: Opcode: " + ((int) this.a));
        }
    }

    public byte[] d() {
        byte[] bArr = this.c;
        int length = bArr.length + 6;
        if (bArr.length > 65535) {
            length += 8;
        } else if (bArr.length >= 126) {
            length += 2;
        }
        ByteBuffer buffer = ByteBuffer.allocate(length);
        a(buffer, this.a, this.b);
        byte[] mask = e();
        c(buffer, this.c.length, mask);
        int i = 0;
        while (true) {
            byte[] bArr2 = this.c;
            if (i < bArr2.length) {
                byte b = (byte) (bArr2[i] ^ mask[i % 4]);
                bArr2[i] = b;
                buffer.put(b);
                i++;
            } else {
                buffer.flip();
                return buffer.array();
            }
        }
    }

    public static void c(ByteBuffer buffer, int length, byte[] mask) {
        if (mask != null) {
            b(buffer, length, true);
            buffer.put(mask);
            return;
        }
        b(buffer, length, false);
    }

    public static void b(ByteBuffer buffer, int length, boolean masked) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        byte b = masked ? Byte.MIN_VALUE : (byte) 0;
        if (length <= 65535) {
            if (length >= 126) {
                buffer.put((byte) (b | 126));
                buffer.put((byte) (length >> 8));
                buffer.put((byte) (length & 255));
                return;
            }
            buffer.put((byte) (b | length));
            return;
        }
        buffer.put((byte) (b | Byte.MAX_VALUE));
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        buffer.put((byte) 0);
        buffer.put((byte) ((length >> 24) & 255));
        buffer.put((byte) ((length >> 16) & 255));
        buffer.put((byte) ((length >> 8) & 255));
        buffer.put((byte) (length & 255));
    }

    public static void a(ByteBuffer buffer, byte opcode, boolean fin) {
        byte b = 0;
        if (fin) {
            b = (byte) (0 | 128);
        }
        buffer.put((byte) ((opcode & 15) | b));
    }

    public static byte[] e() {
        SecureRandom secureRandomGenerator = new SecureRandom();
        int a = secureRandomGenerator.nextInt(255);
        int b = secureRandomGenerator.nextInt(255);
        int c = secureRandomGenerator.nextInt(255);
        int d = secureRandomGenerator.nextInt(255);
        return new byte[]{(byte) a, (byte) b, (byte) c, (byte) d};
    }
}
