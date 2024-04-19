package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* compiled from: TintableImageSourceView.java */
/* renamed from: kb  reason: default package */
/* loaded from: classes.dex */
public interface kb {
    ColorStateList getSupportImageTintList();

    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(ColorStateList colorStateList);

    void setSupportImageTintMode(PorterDuff.Mode mode);
}
