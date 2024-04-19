package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: SubscriberMethodFinder.java */
/* renamed from: nz  reason: default package */
/* loaded from: classes.dex */
public class nz {
    public static final Map<Class<?>, List<mz>> a = new ConcurrentHashMap();
    public static final a[] b = new a[4];
    public List<rz> c;
    public final boolean d;
    public final boolean e;

    public nz(List<rz> list, boolean strictMethodVerification, boolean ignoreGeneratedIndex) {
        this.c = list;
        this.d = strictMethodVerification;
        this.e = ignoreGeneratedIndex;
    }

    public List<mz> a(Class<?> subscriberClass) {
        List<mz> b2;
        Map<Class<?>, List<mz>> map = a;
        List<mz> list = map.get(subscriberClass);
        if (list != null) {
            return list;
        }
        if (this.e) {
            b2 = c(subscriberClass);
        } else {
            b2 = b(subscriberClass);
        }
        if (b2.isEmpty()) {
            throw new cz("Subscriber " + subscriberClass + " and its super classes have no public methods with the @Subscribe annotation");
        }
        map.put(subscriberClass, b2);
        return b2;
    }

    public final List<mz> b(Class<?> subscriberClass) {
        a findState = g();
        findState.c(subscriberClass);
        while (findState.f != null) {
            qz f = f(findState);
            findState.h = f;
            if (f != null) {
                mz[] array = f.a();
                for (mz subscriberMethod : array) {
                    if (findState.a(subscriberMethod.a, subscriberMethod.c)) {
                        findState.a.add(subscriberMethod);
                    }
                }
            } else {
                d(findState);
            }
            findState.d();
        }
        return e(findState);
    }

    public final List<mz> e(a findState) {
        List<SubscriberMethod> subscriberMethods = new ArrayList<>(findState.a);
        findState.e();
        synchronized (b) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                a[] aVarArr = b;
                if (aVarArr[i] != null) {
                    i++;
                } else {
                    aVarArr[i] = findState;
                    break;
                }
            }
        }
        return subscriberMethods;
    }

    public final a g() {
        synchronized (b) {
            for (int i = 0; i < 4; i++) {
                a[] aVarArr = b;
                a state = aVarArr[i];
                if (state != null) {
                    aVarArr[i] = null;
                    return state;
                }
            }
            return new a();
        }
    }

    public final qz f(a findState) {
        qz qzVar = findState.h;
        if (qzVar != null && qzVar.c() != null) {
            qz superclassInfo = findState.h.c();
            if (findState.f == superclassInfo.b()) {
                return superclassInfo;
            }
        }
        List<rz> list = this.c;
        if (list != null) {
            for (rz index : list) {
                qz info = index.a(findState.f);
                if (info != null) {
                    return info;
                }
            }
            return null;
        }
        return null;
    }

    public final List<mz> c(Class<?> subscriberClass) {
        a findState = g();
        findState.c(subscriberClass);
        while (findState.f != null) {
            d(findState);
            findState.d();
        }
        return e(findState);
    }

    public final void d(a findState) {
        String msg;
        Method[] methods;
        int i = 1;
        try {
            methods = findState.f.getDeclaredMethods();
        } catch (Throwable th) {
            try {
                methods = findState.f.getMethods();
                findState.g = true;
            } catch (LinkageError error) {
                String msg2 = "Could not inspect methods of " + findState.f.getName();
                if (this.e) {
                    msg = msg2 + ". Please consider using EventBus annotation processor to avoid reflection.";
                } else {
                    msg = msg2 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
                }
                throw new cz(msg, error);
            }
        }
        int length = methods.length;
        char c = 0;
        int i2 = 0;
        while (i2 < length) {
            Method method = methods[i2];
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == i) {
                    kz subscribeAnnotation = (kz) method.getAnnotation(kz.class);
                    if (subscribeAnnotation != null) {
                        Class<?> eventType = parameterTypes[c];
                        if (findState.a(method, eventType)) {
                            ThreadMode threadMode = subscribeAnnotation.threadMode();
                            findState.a.add(new mz(method, eventType, threadMode, subscribeAnnotation.priority(), subscribeAnnotation.sticky()));
                        }
                    }
                } else if (this.d && method.isAnnotationPresent(kz.class)) {
                    String methodName = method.getDeclaringClass().getName() + "." + method.getName();
                    throw new cz("@Subscribe method " + methodName + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.d && method.isAnnotationPresent(kz.class)) {
                String methodName2 = method.getDeclaringClass().getName() + "." + method.getName();
                throw new cz(methodName2 + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
            i2++;
            i = 1;
            c = 0;
        }
    }

    /* compiled from: SubscriberMethodFinder.java */
    /* renamed from: nz$a */
    /* loaded from: classes.dex */
    public static class a {
        public final List<mz> a = new ArrayList();
        public final Map<Class, Object> b = new HashMap();
        public final Map<String, Class> c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class<?> e;
        public Class<?> f;
        public boolean g;
        public qz h;

        public void c(Class<?> subscriberClass) {
            this.f = subscriberClass;
            this.e = subscriberClass;
            this.g = false;
            this.h = null;
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }

        public boolean a(Method method, Class<?> eventType) {
            Object existing = this.b.put(eventType, method);
            if (existing == null) {
                return true;
            }
            if (existing instanceof Method) {
                if (!b((Method) existing, eventType)) {
                    throw new IllegalStateException();
                }
                this.b.put(eventType, this);
            }
            return b(method, eventType);
        }

        public final boolean b(Method method, Class<?> eventType) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(eventType.getName());
            String methodKey = this.d.toString();
            Class<?> methodClass = method.getDeclaringClass();
            Class<?> methodClassOld = this.c.put(methodKey, methodClass);
            if (methodClassOld == null || methodClassOld.isAssignableFrom(methodClass)) {
                return true;
            }
            this.c.put(methodKey, methodClassOld);
            return false;
        }

        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class<? super Object> superclass = this.f.getSuperclass();
            this.f = superclass;
            String clazzName = superclass.getName();
            if (clazzName.startsWith("java.") || clazzName.startsWith("javax.") || clazzName.startsWith("android.") || clazzName.startsWith("androidx.")) {
                this.f = null;
            }
        }
    }
}
