package defpackage;

import androidx.fragment.app.Fragment;
/* compiled from: FragmentFactory.java */
/* renamed from: zb  reason: default package */
/* loaded from: classes.dex */
public class zb {
    public static final z3<ClassLoader, z3<String, Class<?>>> a = new z3<>();

    public Fragment a(ClassLoader classLoader, String str) {
        throw null;
    }

    /* JADX WARN: Generic types in debug info not equals: z3 != androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Class<?>> */
    public static Class<?> c(ClassLoader classLoader, String className) throws ClassNotFoundException {
        z3<ClassLoader, z3<String, Class<?>>> z3Var = a;
        z3<String, Class<?>> z3Var2 = z3Var.get(classLoader);
        if (z3Var2 == null) {
            z3Var2 = new z3<>();
            z3Var.put(classLoader, z3Var2);
        }
        Class<?> clazz = z3Var2.get(className);
        if (clazz == null) {
            Class<?> clazz2 = Class.forName(className, false, classLoader);
            z3Var2.put(className, clazz2);
            return clazz2;
        }
        return clazz;
    }

    public static boolean b(ClassLoader classLoader, String className) {
        try {
            Class<?> clazz = c(classLoader, className);
            return Fragment.class.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Class<? extends Fragment> d(ClassLoader classLoader, String className) {
        try {
            return c(classLoader, className);
        } catch (ClassCastException e) {
            throw new Fragment.f("Unable to instantiate fragment " + className + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.f("Unable to instantiate fragment " + className + ": make sure class name exists", e2);
        }
    }
}
