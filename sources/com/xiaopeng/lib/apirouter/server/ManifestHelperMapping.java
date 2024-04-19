package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ManifestHelperMapping {
    private static final String HELPER_CLASS_NAME = "com.xiaopeng.lib.apirouter.server.ManifestHelper";
    private static final String MAPPING = "mapping";

    public static HashMap<String, Pair<IBinder, String>> reflectMapping() {
        try {
            Class clazz = Class.forName(HELPER_CLASS_NAME);
            Field field = clazz.getField(MAPPING);
            if (field == null) {
                return null;
            }
            HashMap<String, Pair<IBinder, String>> mapping = (HashMap) field.get(clazz);
            return mapping;
        } catch (Exception e) {
            Log.e("AutoCodeMatcher", "reflectMapping", e);
            return null;
        }
    }
}
