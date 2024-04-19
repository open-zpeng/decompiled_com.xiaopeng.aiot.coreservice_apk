package defpackage;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.SharedValues;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: SharedValues.java */
/* renamed from: s6  reason: default package */
/* loaded from: classes.dex */
public class s6 {
    public SparseIntArray a = new SparseIntArray();
    public HashMap<Integer, HashSet<WeakReference<a>>> b = new HashMap<>();

    /* compiled from: SharedValues.java */
    /* renamed from: s6$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    public void a(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.b.get(Integer.valueOf(key));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.b.put(Integer.valueOf(key), hashSet);
        }
        hashSet.add(new WeakReference<>(listener));
    }

    public void b(int key, a listener) {
        HashSet<WeakReference<a>> hashSet = this.b.get(Integer.valueOf(key));
        if (hashSet == null) {
            return;
        }
        List<WeakReference<SharedValues.SharedValuesListener>> toRemove = new ArrayList<>();
        Iterator<WeakReference<a>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            a l = next.get();
            if (l == null || l == listener) {
                toRemove.add(next);
            }
        }
        hashSet.removeAll(toRemove);
    }
}
