package defpackage;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Lifecycling.java */
/* renamed from: id  reason: default package */
/* loaded from: classes.dex */
public class id {
    public static Map<Class<?>, Integer> a = new HashMap();
    public static Map<Class<?>, List<Constructor<? extends bd>>> b = new HashMap();

    public static dd f(Object object) {
        boolean isLifecycleEventObserver = object instanceof dd;
        boolean isFullLifecycleObserver = object instanceof ad;
        if (isLifecycleEventObserver && isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((ad) object, (dd) object);
        }
        if (isFullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((ad) object, null);
        }
        if (isLifecycleEventObserver) {
            return (dd) object;
        }
        Class<?> klass = object.getClass();
        int type = d(klass);
        if (type == 2) {
            List<Constructor<? extends bd>> list = b.get(klass);
            if (list.size() == 1) {
                bd generatedAdapter = a(list.get(0), object);
                return new SingleGeneratedAdapterObserver(generatedAdapter);
            }
            bd[] adapters = new bd[list.size()];
            for (int i = 0; i < list.size(); i++) {
                adapters[i] = a(list.get(i), object);
            }
            return new CompositeGeneratedAdaptersObserver(adapters);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }

    public static bd a(Constructor<? extends bd> constructor, Object object) {
        try {
            return constructor.newInstance(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static Constructor<? extends bd> b(Class<?> klass) {
        String str;
        try {
            Package aPackage = klass.getPackage();
            String name = klass.getCanonicalName();
            String fullPackage = aPackage != null ? aPackage.getName() : "";
            String adapterName = c(fullPackage.isEmpty() ? name : name.substring(fullPackage.length() + 1));
            if (fullPackage.isEmpty()) {
                str = adapterName;
            } else {
                str = fullPackage + "." + adapterName;
            }
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(klass);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int d(Class<?> klass) {
        Integer callbackCache = a.get(klass);
        if (callbackCache != null) {
            return callbackCache.intValue();
        }
        int type = g(klass);
        a.put(klass, Integer.valueOf(type));
        return type;
    }

    public static int g(Class<?> klass) {
        Class<?>[] interfaces;
        if (klass.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends bd> b2 = b(klass);
        if (b2 != null) {
            b.put(klass, Collections.singletonList(b2));
            return 2;
        }
        boolean hasLifecycleMethods = zc.a.d(klass);
        if (hasLifecycleMethods) {
            return 1;
        }
        Class<?> superclass = klass.getSuperclass();
        List<Constructor<? extends GeneratedAdapter>> adapterConstructors = null;
        if (e(superclass)) {
            if (d(superclass) == 1) {
                return 1;
            }
            adapterConstructors = new ArrayList<>(b.get(superclass));
        }
        for (Class<?> intrface : klass.getInterfaces()) {
            if (e(intrface)) {
                if (d(intrface) == 1) {
                    return 1;
                }
                if (adapterConstructors == null) {
                    adapterConstructors = new ArrayList<>();
                }
                adapterConstructors.addAll(b.get(intrface));
            }
        }
        if (adapterConstructors != null) {
            b.put(klass, adapterConstructors);
            return 2;
        }
        return 1;
    }

    public static boolean e(Class<?> klass) {
        return klass != null && ed.class.isAssignableFrom(klass);
    }

    public static String c(String className) {
        return className.replace(".", "_") + "_LifecycleAdapter";
    }
}
