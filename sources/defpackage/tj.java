package defpackage;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: KeyArraySorter.java */
/* renamed from: tj  reason: default package */
/* loaded from: classes.dex */
public class tj {
    public static tj a = new tj();
    public c b = new c();
    public b c = new b();

    public static tj a() {
        return a;
    }

    public String[] b(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.c;
        } else {
            comparator = this.b;
        }
        if (comparator != null && strArr != null && strArr.length > 0) {
            Arrays.sort(strArr, comparator);
            return strArr;
        }
        return null;
    }

    /* compiled from: KeyArraySorter.java */
    /* renamed from: tj$c */
    /* loaded from: classes.dex */
    public class c implements Comparator<String> {
        public c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String o1, String o2) {
            if (!TextUtils.isEmpty(o1) && !TextUtils.isEmpty(o2)) {
                return o1.compareTo(o2) * (-1);
            }
            return 0;
        }
    }

    /* compiled from: KeyArraySorter.java */
    /* renamed from: tj$b */
    /* loaded from: classes.dex */
    public class b implements Comparator<String> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String o1, String o2) {
            if (!TextUtils.isEmpty(o1) && !TextUtils.isEmpty(o2)) {
                return o1.compareTo(o2);
            }
            return 0;
        }
    }
}
