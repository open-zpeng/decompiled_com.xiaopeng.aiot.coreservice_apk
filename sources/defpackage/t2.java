package defpackage;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* compiled from: SuggestionsAdapter.java */
/* renamed from: t2  reason: default package */
/* loaded from: classes.dex */
public class t2 extends nb implements View.OnClickListener {
    public int A;
    public final SearchView n;
    public final SearchableInfo o;
    public final Context p;
    public final WeakHashMap<String, Drawable.ConstantState> q;
    public final int r;
    public boolean s;
    public int t;
    public ColorStateList u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public t2(Context context, SearchView searchView, SearchableInfo searchable, WeakHashMap<String, Drawable.ConstantState> outsideDrawablesCache) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.s = false;
        this.t = 1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.n = searchView;
        this.o = searchable;
        this.r = searchView.getSuggestionCommitIconResId();
        this.p = context;
        this.q = outsideDrawablesCache;
    }

    public void t(int refineWhat) {
        this.t = refineWhat;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // defpackage.mb.a
    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        String query = constraint == null ? "" : constraint.toString();
        if (this.n.getVisibility() == 0 && this.n.getWindowVisibility() == 0) {
            try {
                Cursor cursor = r(this.o, query, 50);
                if (cursor != null) {
                    cursor.getCount();
                    return cursor;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
            return null;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        x(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        x(getCursor());
    }

    public final void x(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // defpackage.lb, defpackage.mb.a
    public void changeCursor(Cursor c) {
        if (this.s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (c != null) {
                c.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(c);
            if (c != null) {
                this.v = c.getColumnIndex("suggest_text_1");
                this.w = c.getColumnIndex("suggest_text_2");
                this.x = c.getColumnIndex("suggest_text_2_url");
                this.y = c.getColumnIndex("suggest_icon_1");
                this.z = c.getColumnIndex("suggest_icon_2");
                this.A = c.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // defpackage.nb, defpackage.lb
    public View d(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.d(context, cursor, parent);
        v.setTag(new a(v));
        ImageView iconRefine = (ImageView) v.findViewById(s.q);
        iconRefine.setImageResource(this.r);
        return v;
    }

    /* compiled from: SuggestionsAdapter.java */
    /* renamed from: t2$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View v) {
            this.a = (TextView) v.findViewById(16908308);
            this.b = (TextView) v.findViewById(16908309);
            this.c = (ImageView) v.findViewById(16908295);
            this.d = (ImageView) v.findViewById(16908296);
            this.e = (ImageView) v.findViewById(s.q);
        }
    }

    @Override // defpackage.lb
    public void a(View view, Context context, Cursor cursor) {
        CharSequence text2;
        a views = (a) view.getTag();
        int flags = 0;
        int i = this.A;
        if (i != -1) {
            flags = cursor.getInt(i);
        }
        if (views.a != null) {
            String text1 = s(cursor, this.v);
            v(views.a, text1);
        }
        if (views.b != null) {
            CharSequence text22 = s(cursor, this.x);
            if (text22 != null) {
                text2 = h(text22);
            } else {
                text2 = s(cursor, this.w);
            }
            if (TextUtils.isEmpty(text2)) {
                TextView textView = views.a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    views.a.setMaxLines(2);
                }
            } else {
                TextView textView2 = views.a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    views.a.setMaxLines(1);
                }
            }
            v(views.b, text2);
        }
        ImageView imageView = views.c;
        if (imageView != null) {
            u(imageView, p(cursor), 4);
        }
        ImageView imageView2 = views.d;
        if (imageView2 != null) {
            u(imageView2, q(cursor), 8);
        }
        int i2 = this.t;
        if (i2 == 2 || (i2 == 1 && (flags & 1) != 0)) {
            views.e.setVisibility(0);
            views.e.setTag(views.a.getText());
            views.e.setOnClickListener(this);
            return;
        }
        views.e.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof CharSequence) {
            this.n.S((CharSequence) tag);
        }
    }

    public final CharSequence h(CharSequence url) {
        if (this.u == null) {
            TypedValue colorValue = new TypedValue();
            this.p.getTheme().resolveAttribute(n.K, colorValue, true);
            this.u = this.p.getResources().getColorStateList(colorValue.resourceId);
        }
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, this.u, null), 0, url.length(), 33);
        return text;
    }

    public final void v(TextView v, CharSequence text) {
        v.setText(text);
        if (TextUtils.isEmpty(text)) {
            v.setVisibility(8);
        } else {
            v.setVisibility(0);
        }
    }

    public final Drawable p(Cursor cursor) {
        int i = this.y;
        if (i == -1) {
            return null;
        }
        String value = cursor.getString(i);
        Drawable drawable = o(value);
        if (drawable != null) {
            return drawable;
        }
        return l();
    }

    public final Drawable q(Cursor cursor) {
        int i = this.z;
        if (i == -1) {
            return null;
        }
        String value = cursor.getString(i);
        return o(value);
    }

    public final void u(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        if (drawable == null) {
            v.setVisibility(nullVisibility);
            return;
        }
        v.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    @Override // defpackage.lb, defpackage.mb.a
    public CharSequence convertToString(Cursor cursor) {
        String text1;
        String data;
        if (cursor == null) {
            return null;
        }
        String query = k(cursor, "suggest_intent_query");
        if (query != null) {
            return query;
        }
        if (this.o.shouldRewriteQueryFromData() && (data = k(cursor, "suggest_intent_data")) != null) {
            return data;
        }
        if (!this.o.shouldRewriteQueryFromText() || (text1 = k(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return text1;
    }

    @Override // defpackage.lb, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = d(this.p, getCursor(), parent);
            if (v != null) {
                a views = (a) v.getTag();
                TextView tv = views.a;
                tv.setText(e.toString());
            }
            return v;
        }
    }

    @Override // defpackage.lb, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        try {
            return super.getDropDownView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View v = c(this.p, getCursor(), parent);
            if (v != null) {
                a views = (a) v.getTag();
                TextView tv = views.a;
                tv.setText(e.toString());
            }
            return v;
        }
    }

    public final Drawable o(String drawableId) {
        if (drawableId == null || drawableId.isEmpty() || "0".equals(drawableId)) {
            return null;
        }
        try {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = "android.resource://" + this.p.getPackageName() + "/" + resourceId;
            Drawable drawable = g(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            Drawable drawable2 = m7.d(this.p, resourceId);
            w(drawableUri, drawable2);
            return drawable2;
        } catch (Resources.NotFoundException e) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + drawableId);
            return null;
        } catch (NumberFormatException e2) {
            Drawable drawable3 = g(drawableId);
            if (drawable3 != null) {
                return drawable3;
            }
            Uri uri = Uri.parse(drawableId);
            Drawable drawable4 = m(uri);
            w(drawableId, drawable4);
            return drawable4;
        }
    }

    public final Drawable m(Uri uri) {
        try {
            String scheme = uri.getScheme();
            if ("android.resource".equals(scheme)) {
                try {
                    return n(uri);
                } catch (Resources.NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream stream = this.p.getContentResolver().openInputStream(uri);
            if (stream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(stream, null);
            try {
                stream.close();
            } catch (IOException ex) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, ex);
            }
            return createFromStream;
        } catch (FileNotFoundException fnfe) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + fnfe.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + fnfe.getMessage());
        return null;
    }

    public final Drawable g(String resourceUri) {
        Drawable.ConstantState cached = this.q.get(resourceUri);
        if (cached == null) {
            return null;
        }
        return cached.newDrawable();
    }

    public final void w(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            this.q.put(resourceUri, drawable.getConstantState());
        }
    }

    public final Drawable l() {
        Drawable drawable = j(this.o.getSearchActivity());
        if (drawable != null) {
            return drawable;
        }
        return this.p.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable j(ComponentName component) {
        String componentIconKey = component.flattenToShortString();
        if (this.q.containsKey(componentIconKey)) {
            Drawable.ConstantState cached = this.q.get(componentIconKey);
            if (cached == null) {
                return null;
            }
            return cached.newDrawable(this.p.getResources());
        }
        Drawable drawable = i(component);
        Drawable.ConstantState toCache = drawable != null ? drawable.getConstantState() : null;
        this.q.put(componentIconKey, toCache);
        return drawable;
    }

    public final Drawable i(ComponentName component) {
        PackageManager pm = this.p.getPackageManager();
        try {
            ActivityInfo activityInfo = pm.getActivityInfo(component, 128);
            int iconId = activityInfo.getIconResource();
            if (iconId == 0) {
                return null;
            }
            String pkg = component.getPackageName();
            Drawable drawable = pm.getDrawable(pkg, iconId, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconId + " for " + component.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException ex) {
            Log.w("SuggestionsAdapter", ex.toString());
            return null;
        }
    }

    public static String k(Cursor cursor, String columnName) {
        int col = cursor.getColumnIndex(columnName);
        return s(cursor, col);
    }

    public static String s(Cursor cursor, int col) {
        if (col == -1) {
            return null;
        }
        try {
            return cursor.getString(col);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public Drawable n(Uri uri) throws FileNotFoundException {
        int id;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources r = this.p.getPackageManager().getResourcesForApplication(authority);
            List<String> path = uri.getPathSegments();
            if (path == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int len = path.size();
            if (len == 1) {
                try {
                    id = Integer.parseInt(path.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (len == 2) {
                id = r.getIdentifier(path.get(1), path.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (id == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return r.getDrawable(id);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public Cursor r(SearchableInfo searchable, String query, int limit) {
        String authority;
        String[] selArgs;
        if (searchable == null || (authority = searchable.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder uriBuilder = new Uri.Builder().scheme("content").authority(authority).query("").fragment("");
        String contentPath = searchable.getSuggestPath();
        if (contentPath != null) {
            uriBuilder.appendEncodedPath(contentPath);
        }
        uriBuilder.appendPath("search_suggest_query");
        String selection = searchable.getSuggestSelection();
        if (selection != null) {
            String[] selArgs2 = {query};
            selArgs = selArgs2;
        } else {
            uriBuilder.appendPath(query);
            selArgs = null;
        }
        if (limit > 0) {
            uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
        }
        Uri uri = uriBuilder.build();
        return this.p.getContentResolver().query(uri, null, selection, selArgs, null);
    }
}
