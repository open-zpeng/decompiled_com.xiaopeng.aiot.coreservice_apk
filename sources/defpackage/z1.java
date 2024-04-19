package defpackage;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
/* compiled from: AppCompatHintHelper.java */
/* renamed from: z1  reason: default package */
/* loaded from: classes.dex */
public class z1 {
    public static InputConnection a(InputConnection ic, EditorInfo outAttrs, View view) {
        if (ic != null && outAttrs.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof g3) {
                    outAttrs.hintText = ((g3) parent).a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return ic;
    }
}
