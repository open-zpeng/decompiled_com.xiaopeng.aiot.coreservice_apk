package defpackage;

import android.text.TextUtils;
import java.util.Set;
/* compiled from: AccurateSampleCondition.java */
/* renamed from: mi  reason: default package */
/* loaded from: classes.dex */
public class mi {
    public Set<String> a;
    public a b;

    /* compiled from: AccurateSampleCondition.java */
    /* renamed from: mi$a */
    /* loaded from: classes.dex */
    public enum a {
        IN,
        NOT_IN
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.a.contains(str);
        if (this.b == a.IN) {
            return contains;
        }
        return !contains;
    }
}
