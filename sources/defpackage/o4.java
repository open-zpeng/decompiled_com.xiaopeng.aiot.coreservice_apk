package defpackage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: KeyCycleOscillator.java */
/* renamed from: o4  reason: default package */
/* loaded from: classes.dex */
public abstract class o4 {
    public a a;
    public String b;
    public int c = 0;
    public String d = null;
    public int e = 0;
    public ArrayList<b> f = new ArrayList<>();

    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: o4$a */
    /* loaded from: classes.dex */
    public static class a {
        public double a(float f) {
            throw null;
        }

        public double b(float f) {
            throw null;
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: o4$b */
    /* loaded from: classes.dex */
    public static class b {
        public int a;
        public float b;
    }

    public String toString() {
        String str = this.b;
        DecimalFormat df = new DecimalFormat("##.##");
        Iterator<b> it = this.f.iterator();
        while (it.hasNext()) {
            b wp = it.next();
            str = str + "[" + wp.a + " , " + df.format(wp.b) + "] ";
        }
        return str;
    }

    public float a(float t) {
        return (float) this.a.b(t);
    }

    public float b(float position) {
        return (float) this.a.a(position);
    }
}
