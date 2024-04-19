package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* compiled from: ActivityResultRegistry.java */
/* renamed from: i  reason: default package */
/* loaded from: classes.dex */
public abstract class i {
    public Random a = new Random();
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, c> d = new HashMap();
    public ArrayList<String> e = new ArrayList<>();
    public final transient Map<String, b<?>> f = new HashMap();
    public final Map<String, Object> g = new HashMap();
    public final Bundle h = new Bundle();

    /* JADX WARN: Generic types in debug info not equals: g != androidx.activity.result.ActivityResultCallback<O> */
    /* JADX WARN: Generic types in debug info not equals: k != androidx.activity.result.contract.ActivityResultContract<I, O> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> h<I> g(String key, k<I, O> kVar, g<O> gVar) {
        int requestCode = h(key);
        this.f.put(key, new b<>(gVar, kVar));
        if (this.g.containsKey(key)) {
            Object obj = this.g.get(key);
            this.g.remove(key);
            gVar.a(obj);
        }
        f pendingResult = (f) this.h.getParcelable(key);
        if (pendingResult != null) {
            this.h.remove(key);
            gVar.a(kVar.a(pendingResult.b(), pendingResult.a()));
        }
        return new a(key, requestCode, kVar);
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: i$a */
    /* loaded from: classes.dex */
    public class a<I> extends h<I> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ k c;

        public a(String str, int i, k kVar) {
            this.a = str;
            this.b = i;
            this.c = kVar;
        }

        @Override // defpackage.h
        public void a() {
            i.this.i(this.a);
        }
    }

    public final void i(String key) {
        Integer rc;
        if (!this.e.contains(key) && (rc = this.c.remove(key)) != null) {
            this.b.remove(rc);
        }
        this.f.remove(key);
        if (this.g.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.g.get(key));
            this.g.remove(key);
        }
        if (this.h.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.h.getParcelable(key));
            this.h.remove(key);
        }
        c lifecycleContainer = this.d.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.a();
            this.d.remove(key);
        }
    }

    public final void f(Bundle outState) {
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.c.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.c.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.e));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.h.clone());
        outState.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    public final void e(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        ArrayList<Integer> rcs = savedInstanceState.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> keys = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (keys == null || rcs == null) {
            return;
        }
        this.e = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.a = (Random) savedInstanceState.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.h.putAll(savedInstanceState.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if (this.c.containsKey(key)) {
                Integer newRequestCode = this.c.remove(key);
                if (!this.h.containsKey(key)) {
                    this.b.remove(newRequestCode);
                }
            }
            Integer newRequestCode2 = rcs.get(i);
            a(newRequestCode2.intValue(), keys.get(i));
        }
    }

    public final boolean b(int requestCode, int resultCode, Intent data) {
        String key = this.b.get(Integer.valueOf(requestCode));
        if (key == null) {
            return false;
        }
        this.e.remove(key);
        c(key, resultCode, data, this.f.get(key));
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: g != androidx.activity.result.ActivityResultCallback<O> */
    /* JADX WARN: Generic types in debug info not equals: i$b != androidx.activity.result.ActivityResultRegistry$CallbackAndContract<O> */
    /* JADX WARN: Generic types in debug info not equals: k != androidx.activity.result.contract.ActivityResultContract<?, O> */
    public final <O> void c(String key, int resultCode, Intent data, b<O> bVar) {
        if (bVar != null && bVar.a != null) {
            bVar.a.a(bVar.b.a(resultCode, data));
            return;
        }
        this.g.remove(key);
        this.h.putParcelable(key, new f(resultCode, data));
    }

    public final int h(String key) {
        Integer existing = this.c.get(key);
        if (existing != null) {
            return existing.intValue();
        }
        int rc = d();
        a(rc, key);
        return rc;
    }

    public final int d() {
        int number = this.a.nextInt(2147418112) + 65536;
        while (this.b.containsKey(Integer.valueOf(number))) {
            number = this.a.nextInt(2147418112) + 65536;
        }
        return number;
    }

    public final void a(int rc, String key) {
        this.b.put(Integer.valueOf(rc), key);
        this.c.put(key, Integer.valueOf(rc));
    }

    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: i$b */
    /* loaded from: classes.dex */
    public static class b<O> {
        public final g<O> a;
        public final k<?, O> b;

        /* JADX WARN: Generic types in debug info not equals: g != androidx.activity.result.ActivityResultCallback<O> */
        /* JADX WARN: Generic types in debug info not equals: i$b != androidx.activity.result.ActivityResultRegistry$CallbackAndContract<O> */
        /* JADX WARN: Generic types in debug info not equals: k != androidx.activity.result.contract.ActivityResultContract<?, O> */
        public b(g<O> gVar, k<?, O> kVar) {
            this.a = gVar;
            this.b = kVar;
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: i$c */
    /* loaded from: classes.dex */
    public static class c {
        public final cd a;
        public final ArrayList<dd> b;

        public void a() {
            Iterator<dd> it = this.b.iterator();
            while (it.hasNext()) {
                dd observer = it.next();
                this.a.c(observer);
            }
            this.b.clear();
        }
    }
}
