package defpackage;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.f7;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* compiled from: NotificationCompatJellybean.java */
/* renamed from: h7  reason: default package */
/* loaded from: classes.dex */
public class h7 {
    public static Field b;
    public static boolean c;
    public static final Object a = new Object();
    public static final Object d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> actionExtrasList) {
        SparseArray<Bundle> actionExtrasMap = null;
        int count = actionExtrasList.size();
        for (int i = 0; i < count; i++) {
            Bundle actionExtras = actionExtrasList.get(i);
            if (actionExtras != null) {
                if (actionExtrasMap == null) {
                    actionExtrasMap = new SparseArray<>();
                }
                actionExtrasMap.put(i, actionExtras);
            }
        }
        return actionExtrasMap;
    }

    public static Bundle c(Notification notif) {
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field extrasField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(extrasField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    extrasField.setAccessible(true);
                    b = extrasField;
                }
                Bundle extras = (Bundle) b.get(notif);
                if (extras == null) {
                    extras = new Bundle();
                    b.set(notif, extras);
                }
                return extras;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    public static Bundle f(Notification.Builder builder, f7.a action) {
        IconCompat iconCompat = action.e();
        builder.addAction(iconCompat != null ? iconCompat.c() : 0, action.i(), action.a());
        Bundle actionExtras = new Bundle(action.d());
        if (action.f() != null) {
            actionExtras.putParcelableArray("android.support.remoteInputs", e(action.f()));
        }
        if (action.c() != null) {
            actionExtras.putParcelableArray("android.support.dataRemoteInputs", e(action.c()));
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.b());
        return actionExtras;
    }

    public static Bundle b(f7.a action) {
        Bundle actionExtras;
        Bundle bundle = new Bundle();
        IconCompat icon = action.e();
        bundle.putInt("icon", icon != null ? icon.c() : 0);
        bundle.putCharSequence("title", action.i());
        bundle.putParcelable("actionIntent", action.a());
        if (action.d() != null) {
            actionExtras = new Bundle(action.d());
        } else {
            actionExtras = new Bundle();
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.b());
        bundle.putBundle("extras", actionExtras);
        bundle.putParcelableArray("remoteInputs", e(action.f()));
        bundle.putBoolean("showsUserInterface", action.h());
        bundle.putInt("semanticAction", action.g());
        return bundle;
    }

    public static Bundle d(j7 remoteInput) {
        Bundle data = new Bundle();
        data.putString("resultKey", remoteInput.i());
        data.putCharSequence("label", remoteInput.h());
        data.putCharSequenceArray("choices", remoteInput.e());
        data.putBoolean("allowFreeFormInput", remoteInput.c());
        data.putBundle("extras", remoteInput.g());
        Set<String> allowedDataTypes = remoteInput.d();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> allowedDataTypesAsList = new ArrayList<>(allowedDataTypes.size());
            for (String type : allowedDataTypes) {
                allowedDataTypesAsList.add(type);
            }
            data.putStringArrayList("allowedDataTypes", allowedDataTypesAsList);
        }
        return data;
    }

    public static Bundle[] e(j7[] remoteInputs) {
        if (remoteInputs == null) {
            return null;
        }
        Bundle[] bundles = new Bundle[remoteInputs.length];
        for (int i = 0; i < remoteInputs.length; i++) {
            bundles[i] = d(remoteInputs[i]);
        }
        return bundles;
    }
}
