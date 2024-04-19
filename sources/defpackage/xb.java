package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentContainer.java */
/* renamed from: xb  reason: default package */
/* loaded from: classes.dex */
public abstract class xb {
    public abstract View f(int i);

    public abstract boolean h();

    @Deprecated
    public Fragment e(Context context, String className, Bundle arguments) {
        return Fragment.S(context, className, arguments);
    }
}
