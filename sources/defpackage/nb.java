package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* renamed from: nb  reason: default package */
/* loaded from: classes.dex */
public abstract class nb extends lb {
    public int k;
    public int l;
    public LayoutInflater m;

    @Deprecated
    public nb(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.l = layout;
        this.k = layout;
        this.m = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // defpackage.lb
    public View d(Context context, Cursor cursor, ViewGroup parent) {
        return this.m.inflate(this.k, parent, false);
    }

    @Override // defpackage.lb
    public View c(Context context, Cursor cursor, ViewGroup parent) {
        return this.m.inflate(this.l, parent, false);
    }
}
