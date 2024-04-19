package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import com.ta.utdid2.b.a.f;
import com.ta.utdid2.b.a.i;
import com.ta.utdid2.b.a.j;
/* compiled from: AidManager.java */
/* loaded from: classes.dex */
public class a {
    private Context mContext;
    private static a a = null;
    private static final String TAG = a.class.getName();

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    private a(Context context) {
        this.mContext = context;
    }

    public void a(String str, String str2, String str3, com.ut.device.a aVar) {
        if (aVar == null) {
            Log.e(TAG, "callback is null!");
        } else if (this.mContext == null || i.m35a(str) || i.m35a(str2)) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("mContext:");
            sb.append(this.mContext);
            sb.append("; callback:");
            sb.append(aVar);
            sb.append("; has appName:");
            sb.append(!i.m35a(str));
            sb.append("; has token:");
            sb.append(!i.m35a(str2));
            Log.e(str4, sb.toString());
            aVar.a(1002, "");
        } else {
            String m32a = c.m32a(this.mContext, str, str2);
            if (!i.m35a(m32a) && j.a(c.a(this.mContext, str, str2), 1)) {
                aVar.a(1001, m32a);
            } else if (f.m34a(this.mContext)) {
                b.a(this.mContext).a(str, str2, str3, m32a, aVar);
            } else {
                aVar.a(1003, m32a);
            }
        }
    }

    public String a(String str, String str2, String str3) {
        if (this.mContext == null || i.m35a(str) || i.m35a(str2)) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("mContext:");
            sb.append(this.mContext);
            sb.append("; has appName:");
            sb.append(!i.m35a(str));
            sb.append("; has token:");
            sb.append(!i.m35a(str2));
            Log.e(str4, sb.toString());
            return "";
        }
        String m32a = c.m32a(this.mContext, str, str2);
        if (!i.m35a(m32a) && j.a(c.a(this.mContext, str, str2), 1)) {
            return m32a;
        }
        if (f.m34a(this.mContext)) {
            return b(str, str2, str3);
        }
        return m32a;
    }

    private synchronized String b(String str, String str2, String str3) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String str4 = "";
        if (f.m34a(context)) {
            str4 = b.a(this.mContext).a(str, str2, str3, c.m32a(this.mContext, str, str2));
        }
        c.a(this.mContext, str, str4, str2);
        return str4;
    }
}
