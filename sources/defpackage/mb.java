package defpackage;

import android.database.Cursor;
import android.widget.Filter;
/* compiled from: CursorFilter.java */
/* renamed from: mb  reason: default package */
/* loaded from: classes.dex */
public class mb extends Filter {
    public a a;

    /* compiled from: CursorFilter.java */
    /* renamed from: mb$a */
    /* loaded from: classes.dex */
    public interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    public mb(a client) {
        this.a = client;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object resultValue) {
        return this.a.convertToString((Cursor) resultValue);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = this.a.runQueryOnBackgroundThread(constraint);
        Filter.FilterResults results = new Filter.FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence constraint, Filter.FilterResults results) {
        Cursor oldCursor = this.a.getCursor();
        Object obj = results.values;
        if (obj != null && obj != oldCursor) {
            this.a.changeCursor((Cursor) obj);
        }
    }
}
