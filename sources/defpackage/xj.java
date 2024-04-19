package defpackage;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* compiled from: MutiProcessLock.java */
/* renamed from: xj  reason: default package */
/* loaded from: classes.dex */
public class xj {
    public static File a = null;
    public static FileChannel b;
    public static FileLock c;

    public static synchronized boolean a(Context context) {
        FileLock fileLock;
        synchronized (xj.class) {
            if (a == null) {
                a = new File(context.getFilesDir() + File.separator + "ap.Lock");
            }
            boolean exists = a.exists();
            if (!exists) {
                try {
                    exists = a.createNewFile();
                } catch (IOException e) {
                }
            }
            if (!exists) {
                return true;
            }
            if (b == null) {
                try {
                    b = new RandomAccessFile(a, "rw").getChannel();
                } catch (Exception e2) {
                    return false;
                }
            }
            try {
                fileLock = b.tryLock();
                if (fileLock != null) {
                    c = fileLock;
                    return true;
                }
            } catch (Throwable th) {
                fileLock = null;
            }
            Log.d("TAG", "mLock:" + fileLock);
            return false;
        }
    }

    public static synchronized void b() {
        synchronized (xj.class) {
            FileLock fileLock = c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    c = null;
                } catch (IOException e) {
                    c = null;
                }
            }
            FileChannel fileChannel = b;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                    b = null;
                } catch (Exception e2) {
                    b = null;
                }
            }
        }
    }
}
