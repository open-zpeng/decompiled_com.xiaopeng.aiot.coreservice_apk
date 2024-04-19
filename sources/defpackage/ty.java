package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
/* compiled from: MqttDefaultFilePersistence.java */
/* renamed from: ty  reason: default package */
/* loaded from: classes.dex */
public class ty implements fw {
    public static FilenameFilter a;
    public File b;
    public File c = null;
    public zw d = null;

    public static FilenameFilter b() {
        if (a == null) {
            a = new vy(".msg");
        }
        return a;
    }

    public ty(String directory) {
        this.b = new File(directory);
    }

    @Override // defpackage.fw
    public void open(String clientId, String theConnection) throws lw {
        if (this.b.exists() && !this.b.isDirectory()) {
            throw new lw();
        }
        if (!this.b.exists() && !this.b.mkdirs()) {
            throw new lw();
        }
        if (!this.b.canWrite()) {
            throw new lw();
        }
        StringBuffer keyBuffer = new StringBuffer();
        for (int i = 0; i < clientId.length(); i++) {
            char c = clientId.charAt(i);
            if (d(c)) {
                keyBuffer.append(c);
            }
        }
        keyBuffer.append("-");
        for (int i2 = 0; i2 < theConnection.length(); i2++) {
            char c2 = theConnection.charAt(i2);
            if (d(c2)) {
                keyBuffer.append(c2);
            }
        }
        synchronized (this) {
            if (this.c == null) {
                String key = keyBuffer.toString();
                File file = new File(this.b, key);
                this.c = file;
                if (!file.exists()) {
                    this.c.mkdir();
                }
            }
            try {
                this.d = new zw(this.c, ".lck");
            } catch (Exception e) {
            }
            e(this.c);
        }
    }

    public final void a() throws lw {
        if (this.c == null) {
            throw new lw();
        }
    }

    @Override // defpackage.fw
    public void close() throws lw {
        synchronized (this) {
            zw zwVar = this.d;
            if (zwVar != null) {
                zwVar.a();
            }
            if (c().length == 0) {
                this.c.delete();
            }
            this.c = null;
        }
    }

    @Override // defpackage.fw
    public void put(String key, kw message) throws lw {
        a();
        File file = this.c;
        File file2 = new File(file, String.valueOf(key) + ".msg");
        File file3 = this.c;
        File backupFile = new File(file3, String.valueOf(key) + ".msg.bup");
        if (file2.exists()) {
            boolean result = file2.renameTo(backupFile);
            if (!result) {
                backupFile.delete();
                file2.renameTo(backupFile);
            }
        }
        try {
            try {
                FileOutputStream fos = new FileOutputStream(file2);
                fos.write(message.e(), message.b(), message.f());
                if (message.c() != null) {
                    fos.write(message.c(), message.d(), message.a());
                }
                fos.getFD().sync();
                fos.close();
                if (backupFile.exists()) {
                    backupFile.delete();
                }
            } catch (IOException ex) {
                throw new lw(ex);
            }
        } finally {
            if (backupFile.exists()) {
                boolean result2 = backupFile.renameTo(file2);
                if (!result2) {
                    file2.delete();
                    backupFile.renameTo(file2);
                }
            }
        }
    }

    @Override // defpackage.fw
    public kw get(String key) throws lw {
        a();
        try {
            File file = new File(this.c, String.valueOf(key) + ".msg");
            FileInputStream fis = new FileInputStream(file);
            int size = fis.available();
            byte[] data = new byte[size];
            for (int read = 0; read < size; read += fis.read(data, read, size - read)) {
            }
            fis.close();
            kw result = new cx(key, data, 0, data.length, null, 0, 0);
            return result;
        } catch (IOException ex) {
            throw new lw(ex);
        }
    }

    @Override // defpackage.fw
    public void remove(String key) throws lw {
        a();
        File file = this.c;
        File file2 = new File(file, String.valueOf(key) + ".msg");
        if (file2.exists()) {
            file2.delete();
        }
    }

    @Override // defpackage.fw
    public Enumeration keys() throws lw {
        a();
        File[] files = c();
        Vector result = new Vector(files.length);
        for (File file : files) {
            String filename = file.getName();
            String key = filename.substring(0, filename.length() - ".msg".length());
            result.addElement(key);
        }
        return result.elements();
    }

    public final File[] c() throws lw {
        a();
        File[] files = this.c.listFiles(b());
        if (files == null) {
            throw new lw();
        }
        return files;
    }

    public final boolean d(char c) {
        return Character.isJavaIdentifierPart(c) || c == '-';
    }

    public final void e(File dir) throws lw {
        File[] files = dir.listFiles(new uy(".bup"));
        if (files == null) {
            throw new lw();
        }
        for (int i = 0; i < files.length; i++) {
            File originalFile = new File(dir, files[i].getName().substring(0, files[i].getName().length() - ".bup".length()));
            boolean result = files[i].renameTo(originalFile);
            if (!result) {
                originalFile.delete();
                files[i].renameTo(originalFile);
            }
        }
    }

    @Override // defpackage.fw
    public boolean containsKey(String key) throws lw {
        a();
        File file = this.c;
        File file2 = new File(file, String.valueOf(key) + ".msg");
        return file2.exists();
    }

    @Override // defpackage.fw
    public void clear() throws lw {
        a();
        File[] files = c();
        for (File file : files) {
            file.delete();
        }
        this.c.delete();
    }
}
