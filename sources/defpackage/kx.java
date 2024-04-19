package defpackage;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;
/* compiled from: Base64.java */
/* renamed from: kx  reason: default package */
/* loaded from: classes.dex */
public class kx {
    public static final kx a;
    public static final a b;

    static {
        kx kxVar = new kx();
        a = kxVar;
        kxVar.getClass();
        b = new a();
    }

    public static String a(String s) {
        a aVar = b;
        aVar.putByteArray("akey", s.getBytes());
        String result = aVar.a();
        return result;
    }

    public static String b(byte[] b2) {
        a aVar = b;
        aVar.putByteArray("aKey", b2);
        String result = aVar.a();
        return result;
    }

    /* compiled from: Base64.java */
    /* renamed from: kx$a */
    /* loaded from: classes.dex */
    public class a extends AbstractPreferences {
        public String a;

        public a() {
            super(null, "");
            this.a = null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void putSpi(String key, String value) {
            this.a = value;
        }

        public String a() {
            return this.a;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String getSpi(String key) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeSpi(String key) {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void removeNodeSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] keysSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public AbstractPreferences childSpi(String name) {
            return null;
        }

        @Override // java.util.prefs.AbstractPreferences
        public void syncSpi() throws BackingStoreException {
        }

        @Override // java.util.prefs.AbstractPreferences
        public void flushSpi() throws BackingStoreException {
        }
    }
}
