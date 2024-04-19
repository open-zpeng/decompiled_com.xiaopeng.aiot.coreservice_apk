package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* compiled from: XActivityUtils.java */
/* renamed from: oq  reason: default package */
/* loaded from: classes.dex */
public class oq {
    public static void a(Activity activity) {
        if (activity != null) {
            try {
                boolean isChild = activity.isChild();
                activity.finish();
                boolean isFinishing = activity.isFinishing();
                if (!isFinishing && !isChild) {
                    c(activity);
                }
            } catch (Exception e) {
                rq.k("ActivityUtils", "finish e=" + e);
            }
        }
    }

    public static boolean b(Activity activity, boolean nonRoot) {
        boolean ret = false;
        if (activity != null) {
            try {
                boolean isChild = activity.isChild();
                ret = activity.moveTaskToBack(nonRoot);
                if (!ret && !isChild) {
                    c(activity);
                }
            } catch (Exception e) {
                rq.k("ActivityUtils", "moveTaskToBack e=" + e);
            }
        }
        return ret;
    }

    public static void c(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addFlags(270532608);
            context.startActivity(intent);
        } catch (Exception e) {
            rq.k("ActivityUtils", "startHome e=" + e);
        }
    }
}
