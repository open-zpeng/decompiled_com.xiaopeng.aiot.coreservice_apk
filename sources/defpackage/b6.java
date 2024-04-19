package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.nio.CharBuffer;
/* compiled from: Debug.java */
@SuppressLint({"LogConditional"})
/* renamed from: b6  reason: default package */
/* loaded from: classes.dex */
public class b6 {
    public static String c(View view) {
        try {
            Context context = view.getContext();
            return context.getResources().getResourceEntryName(view.getId());
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }

    public static String b(Context context, int id) {
        if (id != -1) {
            try {
                return context.getResources().getResourceEntryName(id);
            } catch (Exception e) {
                return "?" + id;
            }
        }
        return "UNKNOWN";
    }

    public static String d(MotionLayout layout, int stateId) {
        return e(layout, stateId, -1);
    }

    public static String e(MotionLayout layout, int stateId, int len) {
        int n;
        if (stateId == -1) {
            return "UNDEFINED";
        }
        Context context = layout.getContext();
        String str = context.getResources().getResourceEntryName(stateId);
        if (len != -1) {
            if (str.length() > len) {
                str = str.replaceAll("([^_])[aeiou]+", "$1");
            }
            if (str.length() > len && (n = str.replaceAll("[^_]", "").length()) > 0) {
                int extra = (str.length() - len) / n;
                String reg = CharBuffer.allocate(extra).toString().replace((char) 0, '.') + "_";
                return str.replaceAll(reg, "_");
            }
            return str;
        }
        return str;
    }

    public static String a() {
        StackTraceElement s = new Throwable().getStackTrace()[1];
        return ".(" + s.getFileName() + ":" + s.getLineNumber() + ") " + s.getMethodName() + "()";
    }
}
