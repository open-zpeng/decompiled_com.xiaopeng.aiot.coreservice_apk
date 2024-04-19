package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import defpackage.m1;
import java.util.ArrayList;
/* compiled from: MenuAdapter.java */
/* renamed from: e1  reason: default package */
/* loaded from: classes.dex */
public class e1 extends BaseAdapter {
    public f1 a;
    public int b = -1;
    public boolean d;
    public final boolean f;
    public final LayoutInflater g;
    public final int h;

    public e1(f1 menu, LayoutInflater inflater, boolean overflowOnly, int itemLayoutRes) {
        this.f = overflowOnly;
        this.g = inflater;
        this.a = menu;
        this.h = itemLayoutRes;
        a();
    }

    public void d(boolean forceShow) {
        this.d = forceShow;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<h1> z = this.f ? this.a.z() : this.a.E();
        if (this.b < 0) {
            return z.size();
        }
        return z.size() - 1;
    }

    public f1 b() {
        return this.a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public h1 getItem(int position) {
        ArrayList<h1> z = this.f ? this.a.z() : this.a.E();
        int i = this.b;
        if (i >= 0 && position >= i) {
            position++;
        }
        return z.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.g.inflate(this.h, parent, false);
        }
        int currGroupId = getItem(position).getGroupId();
        int prevGroupId = position + (-1) >= 0 ? getItem(position - 1).getGroupId() : currGroupId;
        ((ListMenuItemView) convertView).setGroupDividerEnabled(this.a.F() && currGroupId != prevGroupId);
        m1.a itemView = (m1.a) convertView;
        if (this.d) {
            ((ListMenuItemView) convertView).setForceShowIcon(true);
        }
        itemView.i(getItem(position), 0);
        return convertView;
    }

    public void a() {
        h1 expandedItem = this.a.v();
        if (expandedItem != null) {
            ArrayList<h1> z = this.a.z();
            int count = z.size();
            for (int i = 0; i < count; i++) {
                h1 item = z.get(i);
                if (item == expandedItem) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
