package defpackage;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ActivityResultContracts.java */
/* renamed from: l  reason: default package */
/* loaded from: classes.dex */
public final class l extends k<String[], Map<String, Boolean>> {
    @Override // defpackage.k
    /* renamed from: b */
    public Map<String, Boolean> a(int resultCode, Intent intent) {
        if (resultCode == -1 && intent != null) {
            String[] permissions = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] grantResults = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (grantResults == null || permissions == null) {
                return Collections.emptyMap();
            }
            Map<String, Boolean> result = new HashMap<>();
            int size = permissions.length;
            for (int i = 0; i < size; i++) {
                result.put(permissions[i], Boolean.valueOf(grantResults[i] == 0));
            }
            return result;
        }
        return Collections.emptyMap();
    }
}
