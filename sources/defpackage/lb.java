package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import defpackage.mb;
/* compiled from: CursorAdapter.java */
/* renamed from: lb  reason: default package */
/* loaded from: classes.dex */
public abstract class lb extends BaseAdapter implements Filterable, mb.a {
    public boolean a;
    public boolean b;
    public Cursor d;
    public Context f;
    public int g;
    public a h;
    public DataSetObserver i;
    public mb j;

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View c(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // defpackage.mb.a
    public abstract CharSequence convertToString(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    public lb(Context context, Cursor c, boolean autoRequery) {
        b(context, c, autoRequery ? 1 : 2);
    }

    public void b(Context context, Cursor c, int flags) {
        if ((flags & 1) == 1) {
            flags |= 2;
            this.b = true;
        } else {
            this.b = false;
        }
        boolean cursorPresent = c != null;
        this.d = c;
        this.a = cursorPresent;
        this.f = context;
        this.g = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        if ((flags & 2) == 2) {
            this.h = new a();
            this.i = new b();
        } else {
            this.h = null;
            this.i = null;
        }
        if (cursorPresent) {
            a aVar = this.h;
            if (aVar != null) {
                c.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.i;
            if (dataSetObserver != null) {
                c.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // defpackage.mb.a
    public Cursor getCursor() {
        return this.d;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.a && (cursor = this.d) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        Cursor cursor;
        if (this.a && (cursor = this.d) != null) {
            cursor.moveToPosition(position);
            return this.d;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        Cursor cursor;
        if (this.a && (cursor = this.d) != null && cursor.moveToPosition(position)) {
            return this.d.getLong(this.g);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.d.moveToPosition(position)) {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
        if (convertView == null) {
            v = d(this.f, this.d, parent);
        } else {
            v = convertView;
        }
        a(v, this.f, this.d);
        return v;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View v;
        if (this.a) {
            this.d.moveToPosition(position);
            if (convertView == null) {
                v = c(this.f, this.d, parent);
            } else {
                v = convertView;
            }
            a(v, this.f, this.d);
            return v;
        }
        return null;
    }

    @Override // defpackage.mb.a
    public void changeCursor(Cursor cursor) {
        Cursor old = f(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor f(Cursor newCursor) {
        if (newCursor == this.d) {
            return null;
        }
        Cursor oldCursor = this.d;
        if (oldCursor != null) {
            a aVar = this.h;
            if (aVar != null) {
                oldCursor.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.i;
            if (dataSetObserver != null) {
                oldCursor.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.d = newCursor;
        if (newCursor != null) {
            a aVar2 = this.h;
            if (aVar2 != null) {
                newCursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.i;
            if (dataSetObserver2 != null) {
                newCursor.registerDataSetObserver(dataSetObserver2);
            }
            this.g = newCursor.getColumnIndexOrThrow("_id");
            this.a = true;
            notifyDataSetChanged();
        } else {
            this.g = -1;
            this.a = false;
            notifyDataSetInvalidated();
        }
        return oldCursor;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.j == null) {
            this.j = new mb(this);
        }
        return this.j;
    }

    public void e() {
        Cursor cursor;
        if (this.b && (cursor = this.d) != null && !cursor.isClosed()) {
            this.a = this.d.requery();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: lb$a */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            lb.this.e();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: lb$b */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            lb lbVar = lb.this;
            lbVar.a = true;
            lbVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            lb lbVar = lb.this;
            lbVar.a = false;
            lbVar.notifyDataSetInvalidated();
        }
    }
}
