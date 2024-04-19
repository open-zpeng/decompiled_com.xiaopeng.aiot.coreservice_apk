package defpackage;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ReuseJSONObject.java */
/* renamed from: ji  reason: default package */
/* loaded from: classes.dex */
public class ji extends JSONObject implements gi {
    @Override // defpackage.gi
    public void clean() {
        Iterator<String> keys = keys();
        if (keys != null) {
            while (keys.hasNext()) {
                try {
                    Object obj = get(keys.next());
                    if (obj != null && (obj instanceof gi)) {
                        fi.a().d((gi) obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // defpackage.gi
    public void fill(Object... params) {
    }
}
