package defpackage;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* compiled from: ZipUtils.java */
/* renamed from: xn  reason: default package */
/* loaded from: classes.dex */
public class xn {
    public static byte[] a = {80, 75, 3, 4};
    public static byte[] b = {80, 75, 5, 6};
    public static int c = 4;

    public static String a(byte[] encode, int flags) {
        if (encode == null || encode.length == 0) {
            return null;
        }
        return Base64.encodeToString(encode, flags);
    }

    public static void c(ZipOutputStream out, File fileOrDirectory, String curPath, boolean ignoreEmptyDir) throws IOException {
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            try {
                if (!fileOrDirectory.isDirectory()) {
                    byte[] buffer = new byte[4096];
                    fis = new FileInputStream(fileOrDirectory);
                    bis = new BufferedInputStream(fis);
                    ZipEntry entry = new ZipEntry(curPath + fileOrDirectory.getName());
                    out.putNextEntry(entry);
                    while (true) {
                        int bytes_read = bis.read(buffer);
                        if (bytes_read == -1) {
                            break;
                        }
                        out.write(buffer, 0, bytes_read);
                    }
                    out.flush();
                    out.closeEntry();
                } else {
                    File[] entries = fileOrDirectory.listFiles();
                    if (entries != null && entries.length > 0) {
                        for (File file : entries) {
                            c(out, file, curPath + fileOrDirectory.getName() + "/", ignoreEmptyDir);
                        }
                    } else if (!ignoreEmptyDir) {
                        ZipEntry entry2 = new ZipEntry(fileOrDirectory.getAbsolutePath() + "/");
                        out.putNextEntry(entry2);
                        out.closeEntry();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            on.a(null);
            on.a(null);
        }
    }

    public static File d(String dstFilePath, List<String> filePaths) throws IOException {
        return e(dstFilePath, filePaths, true);
    }

    public static File e(String dstFilePath, List<String> filePaths, boolean ignoreEmptyDir) throws IOException {
        try {
            return f(dstFilePath, filePaths, ignoreEmptyDir);
        } catch (Exception e) {
            e.printStackTrace();
            return new File(dstFilePath);
        }
    }

    public static File f(String dstFilePath, List<String> filePaths, boolean ignoreEmptyDir) throws IOException {
        File zipFile = new File(dstFilePath);
        if (zipFile.exists()) {
            zipFile.delete();
        }
        ZipOutputStream zipOutputStream = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(dstFilePath));
            zipOutputStream = new ZipOutputStream(fos);
            for (String filePath : filePaths) {
                File file = new File(filePath);
                String parent = file.getParent();
                if (parent == null) {
                    parent = "";
                }
                c(zipOutputStream, file, parent + "/", ignoreEmptyDir);
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
            on.a(zipOutputStream);
            on.a(fos);
            return new File(dstFilePath);
        } catch (Throwable th) {
            on.a(zipOutputStream);
            on.a(fos);
            throw th;
        }
    }

    public static String b(String unGzipStr) {
        if (TextUtils.isEmpty(unGzipStr)) {
            return null;
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(baos);
            gzip.write(unGzipStr.getBytes());
            gzip.close();
            byte[] encode = baos.toByteArray();
            baos.flush();
            baos.close();
            return a(encode, 2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
