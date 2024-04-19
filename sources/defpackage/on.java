package defpackage;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
/* compiled from: FileUtils.java */
/* renamed from: on  reason: default package */
/* loaded from: classes.dex */
public class on {
    public static void b(String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    return;
                }
                File[] files = file.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        b(files[i].getAbsolutePath());
                        if (files[i].isDirectory()) {
                            files[i].delete();
                        }
                    }
                }
                new File(path).delete();
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
