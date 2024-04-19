package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* compiled from: AccessibilityClickableSpanCompat.java */
/* renamed from: pa  reason: default package */
/* loaded from: classes.dex */
public final class pa extends ClickableSpan {
    public final int a;
    public final ra b;
    public final int d;

    public pa(int originalClickableSpanId, ra nodeInfoCompat, int clickableSpanActionId) {
        this.a = originalClickableSpanId;
        this.b = nodeInfoCompat;
        this.d = clickableSpanActionId;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View unused) {
        Bundle arguments = new Bundle();
        arguments.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.F(this.d, arguments);
    }
}
