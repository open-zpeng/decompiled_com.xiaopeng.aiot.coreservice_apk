package defpackage;

import java.util.HashMap;
import java.util.Map;
/* compiled from: UTEvent.java */
/* renamed from: bi  reason: default package */
/* loaded from: classes.dex */
public class bi implements gi {
    public String a;
    public int b;
    public String d;
    public String f;
    public String g;
    public Map<String, String> h;

    @Override // defpackage.gi
    public void clean() {
        this.a = null;
        this.b = 0;
        this.d = null;
        this.f = null;
        this.g = null;
        Map<String, String> map = this.h;
        if (map != null) {
            map.clear();
        }
    }

    @Override // defpackage.gi
    public void fill(Object... params) {
        if (this.h == null) {
            this.h = new HashMap();
        }
    }
}
