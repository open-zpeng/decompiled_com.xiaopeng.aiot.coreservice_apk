package defpackage;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: VersionedParcel.java */
/* renamed from: jf  reason: default package */
/* loaded from: classes.dex */
public abstract class jf {
    public final t3<String, Method> a;
    public final t3<String, Method> b;
    public final t3<String, Class> c;

    public abstract void A(byte[] bArr);

    public abstract void C(CharSequence charSequence);

    public abstract void E(int i);

    public abstract void G(Parcelable parcelable);

    public abstract void I(String str);

    public abstract void a();

    public abstract jf b();

    public abstract boolean g();

    public abstract byte[] i();

    public abstract CharSequence k();

    public abstract boolean m(int i);

    public abstract int o();

    public abstract <T extends Parcelable> T q();

    public abstract String s();

    public abstract void w(int i);

    public abstract void y(boolean z);

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.Class> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> */
    public jf(t3<String, Method> t3Var, t3<String, Method> t3Var2, t3<String, Class> t3Var3) {
        this.a = t3Var;
        this.b = t3Var2;
        this.c = t3Var3;
    }

    public boolean f() {
        return false;
    }

    public void x(boolean allowSerialization, boolean ignoreParcelables) {
    }

    public void z(boolean val, int fieldId) {
        w(fieldId);
        y(val);
    }

    public void B(byte[] b, int fieldId) {
        w(fieldId);
        A(b);
    }

    public void D(CharSequence val, int fieldId) {
        w(fieldId);
        C(val);
    }

    public void F(int val, int fieldId) {
        w(fieldId);
        E(val);
    }

    public void J(String val, int fieldId) {
        w(fieldId);
        I(val);
    }

    public void H(Parcelable p, int fieldId) {
        w(fieldId);
        G(p);
    }

    public boolean h(boolean def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return g();
    }

    public int p(int def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return o();
    }

    public String t(String def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return s();
    }

    public byte[] j(byte[] def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return i();
    }

    public <T extends Parcelable> T r(T def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return (T) q();
    }

    public CharSequence l(CharSequence def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return k();
    }

    public void M(lf p, int fieldId) {
        w(fieldId);
        L(p);
    }

    public void L(lf p) {
        if (p == null) {
            I(null);
            return;
        }
        N(p);
        jf subParcel = b();
        K(p, subParcel);
        subParcel.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(lf p) {
        try {
            Class name = c(p.getClass());
            I(name.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(p.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public <T extends lf> T v(T def, int fieldId) {
        if (!m(fieldId)) {
            return def;
        }
        return (T) u();
    }

    public <T extends lf> T u() {
        String name = s();
        if (name == null) {
            return null;
        }
        return (T) n(name, b());
    }

    public <T extends lf> T n(String parcelCls, jf versionedParcel) {
        try {
            Method m = d(parcelCls);
            return (T) m.invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public <T extends lf> void K(T val, jf versionedParcel) {
        try {
            Method m = e(val.getClass());
            m.invoke(null, val, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public final Method d(String parcelCls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method m = this.a.get(parcelCls);
        if (m == null) {
            System.currentTimeMillis();
            Class cls = Class.forName(parcelCls, true, jf.class.getClassLoader());
            Method m2 = cls.getDeclaredMethod("read", jf.class);
            this.a.put(parcelCls, m2);
            return m2;
        }
        return m;
    }

    public final Method e(Class baseCls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method m = this.b.get(baseCls.getName());
        if (m == null) {
            Class cls = c(baseCls);
            System.currentTimeMillis();
            Method m2 = cls.getDeclaredMethod("write", baseCls, jf.class);
            this.b.put(baseCls.getName(), m2);
            return m2;
        }
        return m;
    }

    public final Class c(Class<? extends lf> cls) throws ClassNotFoundException {
        Class ret = this.c.get(cls.getName());
        if (ret == null) {
            String pkg = cls.getPackage().getName();
            String c = String.format("%s.%sParcelizer", pkg, cls.getSimpleName());
            Class ret2 = Class.forName(c, false, cls.getClassLoader());
            this.c.put(cls.getName(), ret2);
            return ret2;
        }
        return ret;
    }
}
