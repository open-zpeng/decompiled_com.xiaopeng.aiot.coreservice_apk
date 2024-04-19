package defpackage;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/* compiled from: AppInfoUtils.java */
/* renamed from: bo  reason: default package */
/* loaded from: classes.dex */
public class bo {
    public static String a = null;

    public static String a() {
        String str = a;
        if (str != null) {
            return str;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                File file = new File("/proc/" + Process.myPid() + "/cmdline");
                bufferedReader = new BufferedReader(new FileReader(file));
                String processName = bufferedReader.readLine().trim();
                a = processName;
            } catch (Exception e) {
                e.printStackTrace();
                a = "";
            }
            on.a(bufferedReader);
            return a;
        } catch (Throwable th) {
            on.a(bufferedReader);
            throw th;
        }
    }
}
