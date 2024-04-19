package defpackage;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* compiled from: UnsafeAllocator.java */
/* renamed from: lg  reason: default package */
/* loaded from: classes.dex */
public abstract class lg {

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: lg$a */
    /* loaded from: classes.dex */
    public static class a extends lg {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Object b;

        public a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // defpackage.lg
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(this.b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: lg$b */
    /* loaded from: classes.dex */
    public static class b extends lg {
        public final /* synthetic */ Method a;

        public b(Method method) {
            this.a = method;
        }

        @Override // defpackage.lg
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: lg$c */
    /* loaded from: classes.dex */
    public static class c extends lg {
        public final /* synthetic */ Method a;
        public final /* synthetic */ int b;

        public c(Method method, int i) {
            this.a = method;
            this.b = i;
        }

        @Override // defpackage.lg
        public <T> T b(Class<T> cls) throws Exception {
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: lg$d */
    /* loaded from: classes.dex */
    public static class d extends lg {
        @Override // defpackage.lg
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static lg a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new b(declaredMethod);
            } catch (Exception e2) {
                try {
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod2.setAccessible(true);
                    int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                    Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3, intValue);
                } catch (Exception e3) {
                    return new d();
                }
            }
        }
    }

    public abstract <T> T b(Class<T> cls) throws Exception;
}
