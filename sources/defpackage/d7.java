package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* compiled from: NavUtils.java */
/* renamed from: d7  reason: default package */
/* loaded from: classes.dex */
public final class d7 {
    public static boolean f(Activity sourceActivity, Intent targetIntent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return sourceActivity.shouldUpRecreateTask(targetIntent);
        }
        String action = sourceActivity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    public static void e(Activity sourceActivity, Intent upIntent) {
        if (Build.VERSION.SDK_INT >= 16) {
            sourceActivity.navigateUpTo(upIntent);
            return;
        }
        upIntent.addFlags(67108864);
        sourceActivity.startActivity(upIntent);
        sourceActivity.finish();
    }

    public static Intent a(Activity sourceActivity) {
        Intent result;
        if (Build.VERSION.SDK_INT >= 16 && (result = sourceActivity.getParentActivityIntent()) != null) {
            return result;
        }
        String parentName = c(sourceActivity);
        if (parentName == null) {
            return null;
        }
        ComponentName target = new ComponentName(sourceActivity, parentName);
        try {
            String grandparent = d(sourceActivity, target);
            if (grandparent == null) {
                return Intent.makeMainActivity(target);
            }
            return new Intent().setComponent(target);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentName + "' in manifest");
            return null;
        }
    }

    public static Intent b(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivity = d(context, componentName);
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(componentName.getPackageName(), parentActivity);
        String grandparent = d(context, target);
        if (grandparent == null) {
            Intent parentIntent = Intent.makeMainActivity(target);
            return parentIntent;
        }
        Intent parentIntent2 = new Intent().setComponent(target);
        return parentIntent2;
    }

    public static String c(Activity sourceActivity) {
        try {
            return d(sourceActivity, sourceActivity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String d(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        int flags;
        String parentActivity;
        String result;
        PackageManager pm = context.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            flags = 128 | IInputController.KEYCODE_BACK_BUTTON;
        } else {
            flags = 128 | IInputController.KEYCODE_BACK_BUTTON;
        }
        if (i >= 29) {
            flags |= 269221888;
        } else if (i >= 24) {
            flags |= 786432;
        }
        ActivityInfo info = pm.getActivityInfo(componentName, flags);
        if (i >= 16 && (result = info.parentActivityName) != null) {
            return result;
        }
        Bundle bundle = info.metaData;
        if (bundle == null || (parentActivity = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (parentActivity.charAt(0) == '.') {
            return context.getPackageName() + parentActivity;
        }
        return parentActivity;
    }
}
