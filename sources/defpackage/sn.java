package defpackage;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* compiled from: ProcessUtils.java */
/* renamed from: sn  reason: default package */
/* loaded from: classes.dex */
public class sn {
    public static String a() {
        FileReader fileReader = null;
        try {
            try {
                File file = new File("/proc/" + Process.myPid() + "/cmdline");
                fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String processName = bufferedReader.readLine().trim();
                bufferedReader.close();
                fileReader.close();
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return processName;
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                fileReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }
}
