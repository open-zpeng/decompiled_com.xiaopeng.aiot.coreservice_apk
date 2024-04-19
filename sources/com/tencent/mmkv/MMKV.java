package com.tencent.mmkv;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    public static final EnumMap<am, Integer> a;
    public static final EnumMap<zl, Integer> b;
    public static final zl[] c;
    public static final Set<Long> d;
    public static String e;
    public static boolean f;
    public static final HashMap<String, Parcelable.Creator<?>> g;
    public static yl h;
    public static boolean i;
    public static xl j;
    private final long nativeHandle;

    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    private native long actualSize(long j2);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, String str3);

    private static native boolean checkProcessMode(long j2);

    private native boolean containsKey(long j2, String str);

    private native long count(long j2);

    private static native long createNB(int i2);

    private native boolean decodeBool(long j2, String str, boolean z);

    private native byte[] decodeBytes(long j2, String str);

    private native double decodeDouble(long j2, String str, double d2);

    private native float decodeFloat(long j2, String str, float f2);

    private native int decodeInt(long j2, String str, int i2);

    private native long decodeLong(long j2, String str, long j3);

    private native String decodeString(long j2, String str, String str2);

    private native String[] decodeStringSet(long j2, String str);

    private static native void destroyNB(long j2, int i2);

    private native boolean encodeBool(long j2, String str, boolean z);

    private native boolean encodeBytes(long j2, String str, byte[] bArr);

    private native boolean encodeDouble(long j2, String str, double d2);

    private native boolean encodeFloat(long j2, String str, float f2);

    private native boolean encodeInt(long j2, String str, int i2);

    private native boolean encodeLong(long j2, String str, long j3);

    private native boolean encodeSet(long j2, String str, String[] strArr);

    private native boolean encodeString(long j2, String str, String str2);

    private static native long getDefaultMMKV(int i2, String str);

    private static native long getMMKVWithAshmemFD(String str, int i2, int i3, String str2);

    private static native long getMMKVWithID(String str, int i2, String str2, String str3);

    private static native long getMMKVWithIDAndSize(String str, int i2, int i3, String str2);

    public static native boolean isFileValid(String str, String str2);

    private static native void jniInitialize(String str, String str2, int i2);

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long j2, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i2);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j2);

    private native int valueSize(long j2, String str, boolean z);

    public static native String version();

    private native int writeValueToNB(long j2, String str, long j3, int i2);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String str);

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    static {
        EnumMap<am, Integer> enumMap = new EnumMap<>(am.class);
        a = enumMap;
        enumMap.put((EnumMap<am, Integer>) am.OnErrorDiscard, (am) 0);
        enumMap.put((EnumMap<am, Integer>) am.OnErrorRecover, (am) 1);
        EnumMap<zl, Integer> enumMap2 = new EnumMap<>(zl.class);
        b = enumMap2;
        zl zlVar = zl.LevelDebug;
        enumMap2.put((EnumMap<zl, Integer>) zlVar, (zl) 0);
        zl zlVar2 = zl.LevelInfo;
        enumMap2.put((EnumMap<zl, Integer>) zlVar2, (zl) 1);
        zl zlVar3 = zl.LevelWarning;
        enumMap2.put((EnumMap<zl, Integer>) zlVar3, (zl) 2);
        zl zlVar4 = zl.LevelError;
        enumMap2.put((EnumMap<zl, Integer>) zlVar4, (zl) 3);
        zl zlVar5 = zl.LevelNone;
        enumMap2.put((EnumMap<zl, Integer>) zlVar5, (zl) 4);
        c = new zl[]{zlVar, zlVar2, zlVar3, zlVar4, zlVar5};
        d = new HashSet();
        e = null;
        f = true;
        g = new HashMap<>();
        i = false;
    }

    public static String r(Context context) {
        String root = context.getFilesDir().getAbsolutePath() + "/mmkv";
        zl logLevel = zl.LevelInfo;
        return s(context, root, null, logLevel);
    }

    public static String s(Context context, String rootDir, b loader, zl logLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            g();
        } else {
            i();
        }
        String cacheDir = context.getCacheDir().getAbsolutePath();
        return h(rootDir, cacheDir, loader, logLevel);
    }

    public static String h(String rootDir, String cacheDir, b loader, zl logLevel) {
        if (loader != null) {
            if ("StaticCpp".equals("SharedCpp")) {
                loader.a("c++_shared");
            }
            loader.a("mmkv");
        } else {
            if ("StaticCpp".equals("SharedCpp")) {
                System.loadLibrary("c++_shared");
            }
            System.loadLibrary("mmkv");
        }
        jniInitialize(rootDir, cacheDir, t(logLevel));
        e = rootDir;
        return rootDir;
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[zl.values().length];
            a = iArr;
            try {
                iArr[zl.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[zl.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[zl.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[zl.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[zl.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static int t(zl level) {
        switch (a.a[level.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 1;
        }
    }

    public static MMKV v(Context context, String mmapID, int size, int mode, String cryptKey) throws RuntimeException {
        MMKV mmkv;
        if (e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String processName = MMKVContentProvider.b(context, Process.myPid());
        if (processName == null || processName.length() == 0) {
            x(zl.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (processName.contains(":")) {
            Uri uri = MMKVContentProvider.a(context);
            if (uri == null) {
                x(zl.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            zl zlVar = zl.LevelInfo;
            x(zlVar, "getting parcelable mmkv in process, Uri = " + uri);
            Bundle extras = new Bundle();
            extras.putInt("KEY_SIZE", size);
            extras.putInt("KEY_MODE", mode);
            if (cryptKey != null) {
                extras.putString("KEY_CRYPT", cryptKey);
            }
            ContentResolver resolver = context.getContentResolver();
            Bundle result = resolver.call(uri, "mmkvFromAshmemID", mmapID, extras);
            if (result != null) {
                result.setClassLoader(bm.class.getClassLoader());
                bm parcelableMMKV = (bm) result.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.a()) != null) {
                    x(zlVar, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        x(zl.LevelInfo, "getting mmkv in main process");
        long handle = getMMKVWithIDAndSize(mmapID, size, mode | 8, cryptKey);
        if (handle != 0) {
            return new MMKV(handle);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + mmapID + "]");
    }

    public static MMKV f() throws RuntimeException {
        if (e == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        long handle = getDefaultMMKV(1, null);
        return a(handle, "DefaultMMKV", 1);
    }

    public static MMKV a(long handle, String mmapID, int mode) throws RuntimeException {
        String message;
        if (handle == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + mmapID + "] in JNI");
        } else if (!f) {
            return new MMKV(handle);
        } else {
            Set<Long> set = d;
            synchronized (set) {
                if (!set.contains(Long.valueOf(handle))) {
                    if (!checkProcessMode(handle)) {
                        if (mode == 1) {
                            message = "Opening a multi-process MMKV instance [" + mmapID + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            String message2 = "Opening an MMKV instance [" + mmapID + "] with MULTI_PROCESS_MODE, ";
                            message = message2 + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(message);
                    }
                    set.add(Long.valueOf(handle));
                }
            }
            return new MMKV(handle);
        }
    }

    public static void i() {
        synchronized (d) {
            f = true;
        }
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    public static void g() {
        synchronized (d) {
            f = false;
        }
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    public boolean p(String key, boolean value) {
        return encodeBool(this.nativeHandle, key, value);
    }

    public boolean l(String key, int value) {
        return encodeInt(this.nativeHandle, key, value);
    }

    public boolean m(String key, long value) {
        return encodeLong(this.nativeHandle, key, value);
    }

    public boolean k(String key, float value) {
        return encodeFloat(this.nativeHandle, key, value);
    }

    public boolean j(String key, double value) {
        return encodeDouble(this.nativeHandle, key, value);
    }

    public boolean n(String key, String value) {
        return encodeString(this.nativeHandle, key, value);
    }

    public String c(String key, String defaultValue) {
        return decodeString(this.nativeHandle, key, defaultValue);
    }

    public boolean o(String key, Set<String> value) {
        return encodeSet(this.nativeHandle, key, value == null ? null : (String[]) value.toArray(new String[0]));
    }

    public Set<String> d(String key, Set<String> defaultValue) {
        return e(key, defaultValue, HashSet.class);
    }

    public Set<String> e(String key, Set<String> defaultValue, Class<? extends Set> cls) {
        String[] result = decodeStringSet(this.nativeHandle, key);
        if (result == null) {
            return defaultValue;
        }
        try {
            Set<String> a2 = cls.newInstance();
            a2.addAll(Arrays.asList(result));
            return a2;
        } catch (IllegalAccessException e2) {
            return defaultValue;
        } catch (InstantiationException e3) {
            return defaultValue;
        }
    }

    public boolean q(String key, byte[] value) {
        return encodeBytes(this.nativeHandle, key, value);
    }

    public boolean b(String key) {
        return containsKey(this.nativeHandle, key);
    }

    public void w(String key) {
        removeValueForKey(this.nativeHandle, key);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defValue) {
        return decodeString(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String key, String value) {
        encodeString(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return d(key, defValues);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
        o(key, values);
        return this;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        return decodeInt(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String key, int value) {
        encodeInt(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        return decodeLong(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String key, long value) {
        encodeLong(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        return decodeFloat(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String key, float value) {
        encodeFloat(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        return decodeBool(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        encodeBool(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String key) {
        w(key);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        return b(key);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public static MMKV u(String mmapID, int fd, int metaFD, String cryptKey) throws RuntimeException {
        long handle = getMMKVWithAshmemFD(mmapID, fd, metaFD, cryptKey);
        if (handle == 0) {
            throw new RuntimeException("Fail to create an ashmem MMKV instance [" + mmapID + "] in JNI");
        }
        return new MMKV(handle);
    }

    private static int onMMKVCRCCheckFail(String mmapID) {
        am strategic = am.OnErrorDiscard;
        yl ylVar = h;
        if (ylVar != null) {
            strategic = ylVar.c(mmapID);
        }
        zl zlVar = zl.LevelInfo;
        x(zlVar, "Recover strategic for " + mmapID + " is " + strategic);
        Integer value = a.get(strategic);
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    private static int onMMKVFileLengthError(String mmapID) {
        am strategic = am.OnErrorDiscard;
        yl ylVar = h;
        if (ylVar != null) {
            strategic = ylVar.a(mmapID);
        }
        zl zlVar = zl.LevelInfo;
        x(zlVar, "Recover strategic for " + mmapID + " is " + strategic);
        Integer value = a.get(strategic);
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    private static void mmkvLogImp(int level, String file, int line, String function, String message) {
        yl ylVar = h;
        if (ylVar != null && i) {
            ylVar.b(c[level], file, line, function, message);
            return;
        }
        switch (a.a[c[level].ordinal()]) {
            case 1:
                Log.d("MMKV", message);
                return;
            case 2:
                Log.w("MMKV", message);
                return;
            case 3:
                Log.e("MMKV", message);
                return;
            case 4:
            default:
                return;
            case 5:
                Log.i("MMKV", message);
                return;
        }
    }

    public static void x(zl level, String message) {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e2 = stacktrace[stacktrace.length - 1];
        Integer i2 = b.get(level);
        int intLevel = i2 == null ? 0 : i2.intValue();
        mmkvLogImp(intLevel, e2.getFileName(), e2.getLineNumber(), e2.getMethodName(), message);
    }

    private static void onContentChangedByOuterProcess(String mmapID) {
        xl xlVar = j;
        if (xlVar != null) {
            xlVar.a(mmapID);
        }
    }

    public MMKV(long handle) {
        this.nativeHandle = handle;
    }
}
