package defpackage;

import android.util.SparseArray;
/* compiled from: SoundEffectFactory.java */
/* renamed from: hq  reason: default package */
/* loaded from: classes.dex */
public class hq {
    public static SparseArray<jq> a;
    public static SparseArray<jq> b;

    static {
        SparseArray<jq> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(-1, new a("CDU_touch.wav"));
        a.put(1, new a("CDU_touch.wav"));
        a.put(2, new a("CDU_wheel_scroll_7.wav"));
        a.put(3, new a("CDU_switch_on_2.wav"));
        a.put(4, new a("CDU_switch_off_2.wav"));
        a.put(5, new a("CDU_delete_4.wav"));
        b = a.clone();
    }

    /* compiled from: SoundEffectFactory.java */
    /* renamed from: hq$a */
    /* loaded from: classes.dex */
    public static class a extends jq {
        public a(String path) {
            super("system/media/audio/xiaopeng/cdu/wav/" + path, 1, 5);
        }
    }

    public static kq a(int resource) {
        return new iq(a.get(resource));
    }
}
