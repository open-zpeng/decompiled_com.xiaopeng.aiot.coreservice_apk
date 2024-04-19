package defpackage;

import org.json.JSONArray;
/* compiled from: ReuseJSONArray.java */
/* renamed from: ii  reason: default package */
/* loaded from: classes.dex */
public class ii extends JSONArray implements gi {
    @Override // defpackage.gi
    public void clean() {
        for (int i = 0; i < length(); i++) {
            Object opt = opt(i);
            if (opt != null && (opt instanceof gi)) {
                fi.a().d((gi) opt);
            }
        }
    }

    @Override // defpackage.gi
    public void fill(Object... params) {
    }
}
