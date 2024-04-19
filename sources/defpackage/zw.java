package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
/* compiled from: FileLock.java */
/* renamed from: zw  reason: default package */
/* loaded from: classes.dex */
public class zw {
    public File a;
    public RandomAccessFile b;
    public Object c;

    public zw(File clientDir, String lockFilename) throws Exception {
        this.a = new File(clientDir, lockFilename);
        if (yw.c("java.nio.channels.FileLock")) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.a, "rw");
                this.b = randomAccessFile;
                Method m = randomAccessFile.getClass().getMethod("getChannel", new Class[0]);
                Object channel = m.invoke(this.b, new Object[0]);
                Method m2 = channel.getClass().getMethod("tryLock", new Class[0]);
                this.c = m2.invoke(channel, new Object[0]);
            } catch (IllegalAccessException e) {
                this.c = null;
            } catch (IllegalArgumentException e2) {
                this.c = null;
            } catch (NoSuchMethodException e3) {
                this.c = null;
            }
            if (this.c == null) {
                a();
                throw new Exception("Problem obtaining file lock");
            }
        }
    }

    public void a() {
        try {
            Object obj = this.c;
            if (obj != null) {
                Method m = obj.getClass().getMethod("release", new Class[0]);
                m.invoke(this.c, new Object[0]);
                this.c = null;
            }
        } catch (Exception e) {
        }
        RandomAccessFile randomAccessFile = this.b;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
            }
            this.b = null;
        }
        File file = this.a;
        if (file != null && file.exists()) {
            this.a.delete();
        }
        this.a = null;
    }
}
