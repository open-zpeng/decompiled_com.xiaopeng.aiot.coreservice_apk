package defpackage;

import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: MD5Utils.java */
/* renamed from: qn  reason: default package */
/* loaded from: classes.dex */
public class qn {
    public static String a(String info) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes(XmartV1Constants.UTF8_ENCODING));
            byte[] encryption = md5.digest();
            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(encryption[i] & 255).length() == 1) {
                    strBuf.append("0");
                    strBuf.append(Integer.toHexString(encryption[i] & 255));
                } else {
                    strBuf.append(Integer.toHexString(encryption[i] & 255));
                }
            }
            return strBuf.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (NoSuchAlgorithmException e2) {
            return "";
        }
    }
}
