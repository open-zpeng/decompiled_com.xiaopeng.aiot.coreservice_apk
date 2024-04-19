package defpackage;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import defpackage.cd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
/* renamed from: zc  reason: default package */
/* loaded from: classes.dex */
public final class zc {
    public static zc a = new zc();
    public final Map<Class<?>, a> b = new HashMap();
    public final Map<Class<?>, Boolean> c = new HashMap();

    public boolean d(Class<?> klass) {
        Boolean hasLifecycleMethods = this.c.get(klass);
        if (hasLifecycleMethods != null) {
            return hasLifecycleMethods.booleanValue();
        }
        Method[] methods = b(klass);
        for (Method method : methods) {
            md annotation = (md) method.getAnnotation(md.class);
            if (annotation != null) {
                a(klass, methods);
                return true;
            }
        }
        this.c.put(klass, false);
        return false;
    }

    public final Method[] b(Class<?> klass) {
        try {
            return klass.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    public a c(Class<?> klass) {
        a existing = this.b.get(klass);
        if (existing != null) {
            return existing;
        }
        return a(klass, null);
    }

    public final void e(Map<b, cd.b> map, b newHandler, cd.b newEvent, Class<?> klass) {
        cd.b event = map.get(newHandler);
        if (event != null && newEvent != event) {
            Method method = newHandler.b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + klass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event + ", new value " + newEvent);
        } else if (event == null) {
            map.put(newHandler, newEvent);
        }
    }

    public final a a(Class<?> klass, Method[] declaredMethods) {
        a superInfo;
        Class<?> superclass = klass.getSuperclass();
        Map<ClassesInfoCache.MethodReference, Lifecycle.Event> handlerToEvent = new HashMap<>();
        if (superclass != null && (superInfo = c(superclass)) != null) {
            handlerToEvent.putAll(superInfo.b);
        }
        Class<?>[] interfaces = klass.getInterfaces();
        char c = 0;
        for (Class<?> intrfc : interfaces) {
            for (Map.Entry<b, cd.b> entry : c(intrfc).b.entrySet()) {
                e(handlerToEvent, entry.getKey(), entry.getValue(), klass);
            }
        }
        Method[] methods = declaredMethods != null ? declaredMethods : b(klass);
        boolean hasLifecycleMethods = false;
        int length = methods.length;
        int i = 0;
        while (i < length) {
            Method method = methods[i];
            md annotation = (md) method.getAnnotation(md.class);
            if (annotation != null) {
                hasLifecycleMethods = true;
                Class<?>[] params = method.getParameterTypes();
                int callType = 0;
                if (params.length > 0) {
                    callType = 1;
                    if (!params[c].isAssignableFrom(fd.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                }
                cd.b event = annotation.value();
                if (params.length > 1) {
                    callType = 2;
                    if (!params[1].isAssignableFrom(cd.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (event != cd.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (params.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b methodReference = new b(callType, method);
                e(handlerToEvent, methodReference, event, klass);
            }
            i++;
            c = 0;
        }
        a info = new a(handlerToEvent);
        this.b.put(klass, info);
        this.c.put(klass, Boolean.valueOf(hasLifecycleMethods));
        return info;
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: zc$a */
    /* loaded from: classes.dex */
    public static class a {
        public final Map<cd.b, List<b>> a = new HashMap();
        public final Map<b, cd.b> b;

        public a(Map<b, cd.b> map) {
            this.b = map;
            for (Map.Entry<b, cd.b> entry : map.entrySet()) {
                cd.b event = entry.getValue();
                List<b> list = this.a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        public void a(fd source, cd.b event, Object target) {
            b(this.a.get(event), source, event, target);
            b(this.a.get(cd.b.ON_ANY), source, event, target);
        }

        public static void b(List<b> list, fd source, cd.b event, Object mWrapped) {
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    list.get(i).a(source, event, mWrapped);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache.java */
    /* renamed from: zc$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final int a;
        public final Method b;

        public b(int callType, Method method) {
            this.a = callType;
            this.b = method;
            method.setAccessible(true);
        }

        public void a(fd source, cd.b event, Object target) {
            try {
                switch (this.a) {
                    case 0:
                        this.b.invoke(target, new Object[0]);
                        return;
                    case 1:
                        this.b.invoke(target, source);
                        return;
                    case 2:
                        this.b.invoke(target, source, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof b) {
                b that = (b) o;
                return this.a == that.a && this.b.getName().equals(that.b.getName());
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }
}
