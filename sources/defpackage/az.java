package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.Subscription;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: EventBus.java */
/* renamed from: az  reason: default package */
/* loaded from: classes.dex */
public class az {
    public static volatile az b;
    public final Map<Class<?>, CopyOnWriteArrayList<oz>> e;
    public final Map<Object, List<Class<?>>> f;
    public final Map<Class<?>, Object> g;
    public final ThreadLocal<c> h;
    public final fz i;
    public final jz j;
    public final zy k;
    public final yy l;
    public final nz m;
    public final ExecutorService n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final ez v;
    public static String a = "EventBus";
    public static final bz c = new bz();
    public static final Map<Class<?>, List<Class<?>>> d = new HashMap();

    /* compiled from: EventBus.java */
    /* renamed from: az$c */
    /* loaded from: classes.dex */
    public static final class c {
        public final List<Object> a = new ArrayList();
        public boolean b;
        public boolean c;
        public oz d;
        public Object e;
        public boolean f;
    }

    /* compiled from: EventBus.java */
    /* renamed from: az$a */
    /* loaded from: classes.dex */
    public class a extends ThreadLocal<c> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public c initialValue() {
            return new c();
        }
    }

    public static az d() {
        az instance = b;
        if (instance == null) {
            synchronized (az.class) {
                instance = b;
                if (instance == null) {
                    az azVar = new az();
                    b = azVar;
                    instance = azVar;
                }
            }
        }
        return instance;
    }

    public static bz b() {
        return new bz();
    }

    public az() {
        this(c);
    }

    public az(bz builder) {
        this.h = new a();
        this.v = builder.c();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        fz d2 = builder.d();
        this.i = d2;
        this.j = d2 != null ? d2.a(this) : null;
        this.k = new zy(this);
        this.l = new yy(this);
        List<rz> list = builder.k;
        this.u = list != null ? list.size() : 0;
        this.m = new nz(builder.k, builder.i, builder.h);
        this.p = builder.b;
        this.q = builder.c;
        this.r = builder.d;
        this.s = builder.e;
        this.o = builder.f;
        this.t = builder.g;
        this.n = builder.j;
    }

    public void s(Object subscriber) {
        Class<?> subscriberClass = subscriber.getClass();
        List<mz> a2 = this.m.a(subscriberClass);
        synchronized (this) {
            for (mz subscriberMethod : a2) {
                t(subscriber, subscriberMethod);
            }
        }
    }

    public final void t(Object subscriber, mz subscriberMethod) {
        Class<?> eventType = subscriberMethod.c;
        oz newSubscription = new oz(subscriber, subscriberMethod);
        CopyOnWriteArrayList<oz> copyOnWriteArrayList = this.e.get(eventType);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.e.put(eventType, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(newSubscription)) {
            throw new cz("Subscriber " + subscriber.getClass() + " already registered to event " + eventType);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.d > copyOnWriteArrayList.get(i).b.d) {
                copyOnWriteArrayList.add(i, newSubscription);
                break;
            }
        }
        List<Class<?>> subscribedEvents = this.f.get(subscriber);
        if (subscribedEvents == null) {
            subscribedEvents = new ArrayList();
            this.f.put(subscriber, subscribedEvents);
        }
        subscribedEvents.add(eventType);
        if (subscriberMethod.e) {
            if (this.t) {
                Set<Map.Entry<Class<?>, Object>> entries = this.g.entrySet();
                for (Map.Entry<Class<?>, Object> entry : entries) {
                    Class<?> candidateEventType = entry.getKey();
                    if (eventType.isAssignableFrom(candidateEventType)) {
                        Object stickyEvent = entry.getValue();
                        c(newSubscription, stickyEvent);
                    }
                }
                return;
            }
            Object stickyEvent2 = this.g.get(eventType);
            c(newSubscription, stickyEvent2);
        }
    }

    public final void c(oz newSubscription, Object stickyEvent) {
        if (stickyEvent != null) {
            r(newSubscription, stickyEvent, k());
        }
    }

    public final boolean k() {
        fz fzVar = this.i;
        return fzVar == null || fzVar.b();
    }

    public synchronized boolean l(Object subscriber) {
        return this.f.containsKey(subscriber);
    }

    public final void v(Object subscriber, Class<?> eventType) {
        List<Subscription> subscriptions = this.e.get(eventType);
        if (subscriptions != null) {
            int size = subscriptions.size();
            int i = 0;
            while (i < size) {
                oz subscription = subscriptions.get(i);
                if (subscription.a == subscriber) {
                    subscription.c = false;
                    subscriptions.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public synchronized void u(Object subscriber) {
        List<Class<?>> subscribedTypes = this.f.get(subscriber);
        if (subscribedTypes != null) {
            for (Class<?> eventType : subscribedTypes) {
                v(subscriber, eventType);
            }
            this.f.remove(subscriber);
        } else {
            ez ezVar = this.v;
            Level level = Level.WARNING;
            ezVar.a(level, "Subscriber to unregister was not registered before: " + subscriber.getClass());
        }
    }

    public void n(Object event) {
        c postingState = this.h.get();
        List<Object> eventQueue = postingState.a;
        eventQueue.add(event);
        if (!postingState.b) {
            postingState.c = k();
            postingState.b = true;
            if (postingState.f) {
                throw new cz("Internal error. Abort state was not reset");
            }
            while (true) {
                try {
                    if (!eventQueue.isEmpty()) {
                        o(eventQueue.remove(0), postingState);
                    } else {
                        return;
                    }
                } finally {
                    postingState.b = false;
                    postingState.c = false;
                }
            }
        }
    }

    public void q(Object event) {
        synchronized (this.g) {
            this.g.put(event.getClass(), event);
        }
        n(event);
    }

    public boolean h(Class<?> eventClass) {
        CopyOnWriteArrayList<oz> copyOnWriteArrayList;
        List<Class<?>> eventTypes = m(eventClass);
        if (eventTypes != null) {
            int countTypes = eventTypes.size();
            for (int h = 0; h < countTypes; h++) {
                Class<?> clazz = eventTypes.get(h);
                synchronized (this) {
                    copyOnWriteArrayList = this.e.get(clazz);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final void o(Object event, c postingState) throws Error {
        Class<?> eventClass = event.getClass();
        boolean subscriptionFound = false;
        if (this.t) {
            List<Class<?>> eventTypes = m(eventClass);
            int countTypes = eventTypes.size();
            for (int h = 0; h < countTypes; h++) {
                Class<?> clazz = eventTypes.get(h);
                subscriptionFound |= p(event, postingState, clazz);
            }
        } else {
            subscriptionFound = p(event, postingState, eventClass);
        }
        if (!subscriptionFound) {
            if (this.q) {
                ez ezVar = this.v;
                Level level = Level.FINE;
                ezVar.a(level, "No subscribers registered for event " + eventClass);
            }
            if (this.s && eventClass != gz.class && eventClass != lz.class) {
                n(new gz(this, event));
            }
        }
    }

    public final boolean p(Object event, c postingState, Class<?> eventClass) {
        CopyOnWriteArrayList<oz> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.e.get(eventClass);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<oz> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            oz subscription = it.next();
            postingState.e = event;
            postingState.d = subscription;
            try {
                r(subscription, event, postingState.c);
                boolean aborted = postingState.f;
                if (aborted) {
                    return true;
                }
            } finally {
                postingState.e = null;
                postingState.d = null;
                postingState.f = false;
            }
        }
        return true;
    }

    /* compiled from: EventBus.java */
    /* renamed from: az$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public final void r(oz subscription, Object event, boolean isMainThread) {
        switch (b.a[subscription.b.b.ordinal()]) {
            case 1:
                j(subscription, event);
                return;
            case 2:
                if (isMainThread) {
                    j(subscription, event);
                    return;
                } else {
                    this.j.a(subscription, event);
                    return;
                }
            case 3:
                jz jzVar = this.j;
                if (jzVar != null) {
                    jzVar.a(subscription, event);
                    return;
                } else {
                    j(subscription, event);
                    return;
                }
            case 4:
                if (isMainThread) {
                    this.k.a(subscription, event);
                    return;
                } else {
                    j(subscription, event);
                    return;
                }
            case 5:
                this.l.a(subscription, event);
                return;
            default:
                throw new IllegalStateException("Unknown thread mode: " + subscription.b.b);
        }
    }

    public static List<Class<?>> m(Class<?> eventClass) {
        List<Class<?>> eventTypes;
        Map<Class<?>, List<Class<?>>> map = d;
        synchronized (map) {
            eventTypes = map.get(eventClass);
            if (eventTypes == null) {
                eventTypes = new ArrayList();
                for (Class<?> clazz = eventClass; clazz != null; clazz = clazz.getSuperclass()) {
                    eventTypes.add(clazz);
                    a(eventTypes, clazz.getInterfaces());
                }
                d.put(eventClass, eventTypes);
            }
        }
        return eventTypes;
    }

    public static void a(List<Class<?>> eventTypes, Class<?>[] interfaces) {
        for (Class<?> interfaceClass : interfaces) {
            if (!eventTypes.contains(interfaceClass)) {
                eventTypes.add(interfaceClass);
                a(eventTypes, interfaceClass.getInterfaces());
            }
        }
    }

    public void i(hz pendingPost) {
        Object event = pendingPost.b;
        oz subscription = pendingPost.c;
        hz.b(pendingPost);
        if (subscription.c) {
            j(subscription, event);
        }
    }

    public void j(oz subscription, Object event) {
        try {
            subscription.b.a.invoke(subscription.a, event);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            g(subscription, event, e2.getCause());
        }
    }

    public final void g(oz subscription, Object event, Throwable cause) {
        if (event instanceof lz) {
            if (this.p) {
                ez ezVar = this.v;
                Level level = Level.SEVERE;
                ezVar.b(level, "SubscriberExceptionEvent subscriber " + subscription.a.getClass() + " threw an exception", cause);
                lz exEvent = (lz) event;
                ez ezVar2 = this.v;
                ezVar2.b(level, "Initial event " + exEvent.c + " caused exception in " + exEvent.d, exEvent.b);
            }
        } else if (this.o) {
            throw new cz("Invoking subscriber failed", cause);
        } else {
            if (this.p) {
                ez ezVar3 = this.v;
                Level level2 = Level.SEVERE;
                ezVar3.b(level2, "Could not dispatch event: " + event.getClass() + " to subscribing class " + subscription.a.getClass(), cause);
            }
            if (this.r) {
                n(new lz(this, cause, event, subscription.a));
            }
        }
    }

    public ExecutorService e() {
        return this.n;
    }

    public ez f() {
        return this.v;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.u + ", eventInheritance=" + this.t + "]";
    }
}
