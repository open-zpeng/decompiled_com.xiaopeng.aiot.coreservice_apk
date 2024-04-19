package defpackage;

import android.util.Base64;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: AESUtils.java */
/* renamed from: ao  reason: default package */
/* loaded from: classes.dex */
public class ao {
    public static boolean c(File sourceFile, File encryptFile, String sKey) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            try {
                try {
                    try {
                        Cipher cipher = d(sKey, 1);
                        inputStream = new FileInputStream(sourceFile);
                        outputStream = new FileOutputStream(encryptFile);
                        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
                        byte[] buffer = new byte[1048576];
                        while (true) {
                            int r = inputStream.read(buffer);
                            if (r < 0) {
                                break;
                            }
                            cipherOutputStream.write(buffer, 0, r);
                        }
                        cipherOutputStream.close();
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            outputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return false;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return false;
                }
            } catch (OutOfMemoryError error) {
                error.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] e(String hexStr) {
        int len = hexStr.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexStr.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return result;
    }

    public static String a(String content, String password) {
        try {
            byte[] keyBytes = password.getBytes(Charset.forName(XmartV1Constants.UTF8_ENCODING));
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            byte[] result = cipher.doFinal(e(content));
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cipher d(String sKey, int cipherMode) {
        Cipher cipher = null;
        try {
            byte[] codeFormat = sKey.getBytes();
            SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, key);
            return cipher;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return cipher;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return cipher;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return cipher;
        }
    }

    public static String b(String content, String password) {
        try {
            byte[] keyBytes = password.getBytes(Charset.forName(XmartV1Constants.UTF8_ENCODING));
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            byte[] result = cipher.doFinal(Base64.decode(content, 0));
            return new String(result);
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}
