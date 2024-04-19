package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/* compiled from: IOUtils.java */
/* renamed from: vl  reason: default package */
/* loaded from: classes.dex */
public class vl {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            wl.a(e);
        }
    }

    public static byte[] c(Object input) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(input);
                oos.flush();
                return baos.toByteArray();
            } catch (IOException e) {
                wl.a(e);
                a(oos);
                a(baos);
                return null;
            }
        } finally {
            a(oos);
            a(baos);
        }
    }

    public static Object d(byte[] input) {
        if (input == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(input);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            wl.a(e);
            return null;
        } finally {
            a(ois);
            a(bais);
        }
    }

    public static byte[] b(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        e(input, output);
        output.close();
        return output.toByteArray();
    }

    public static void e(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[4096];
        while (true) {
            int len = inputStream.read(buffer);
            if (len == -1) {
                return;
            }
            outputStream.write(buffer, 0, len);
        }
    }
}
