package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import defpackage.eo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* compiled from: ThemeViewModel.java */
/* renamed from: fo  reason: default package */
/* loaded from: classes.dex */
public class fo {
    public int a;
    public a b;
    public List<a> c = new ArrayList();
    public HashMap<String, Integer> d;

    /* compiled from: ThemeViewModel.java */
    /* renamed from: fo$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public fo(Context context, HashMap<String, Integer> attributes) {
        this.a = context.getResources().getConfiguration().uiMode;
        this.d = attributes != null ? attributes : new HashMap<>();
    }

    public static fo d(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Object extras) {
        HashMap<String, Integer> map = eo.d(context, attrs, defStyleAttr, defStyleRes, f(extras));
        return new fo(context, map);
    }

    public static HashMap<String, List<String>> c(String key, String... value) {
        if (!TextUtils.isEmpty(key) && value != null) {
            HashMap<String, List<String>> map = new HashMap<>();
            map.put(key, Arrays.asList(value));
            return map;
        }
        return null;
    }

    public static HashMap<String, List<String>> b(String key, List<String> list) {
        if (!TextUtils.isEmpty(key) && list != null && !list.isEmpty()) {
            HashMap<String, List<String>> map = new HashMap<>();
            map.put(key, list);
            return map;
        }
        return null;
    }

    public static HashMap<String, List<String>> f(Object extras) {
        if (extras != null) {
            try {
                if (extras instanceof List) {
                    return b("extra_append", (List) extras);
                }
                if (extras instanceof HashMap) {
                    return (HashMap) extras;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public void m(a callback) {
        this.b = callback;
    }

    public void a(a callback) {
        List<a> list;
        if (callback != null && (list = this.c) != null) {
            list.add(callback);
        }
    }

    public void i(View view) {
        Context context = view.getContext();
        int uiMode = eo.a(context);
        if (eo.b) {
            eo.b.a("ThemeViewModel onAttachedToWindow newMode=" + uiMode + " oldMode=" + this.a + " view=" + g(view));
        }
        if (h(uiMode)) {
            o(view);
        }
        this.a = uiMode;
    }

    public void k(View view) {
    }

    public void j(View view, Configuration newConfig) {
        int uiMode = newConfig != null ? newConfig.uiMode : 0;
        boolean isThemeChanged = eo.c(newConfig);
        if (eo.b) {
            eo.b.a("ThemeViewModel onConfigurationChanged isThemeChanged=" + isThemeChanged + " uiMode=" + uiMode + " view=" + g(view));
        }
        if (isThemeChanged) {
            o(view);
            this.a = newConfig != null ? newConfig.uiMode : this.a;
        }
    }

    public void l(int resid) {
        this.d.put("background", Integer.valueOf(resid));
    }

    public void n(int resid) {
        this.d.put("src", Integer.valueOf(resid));
    }

    public final boolean h(int uiMode) {
        return uiMode != this.a;
    }

    public final void o(View view) {
        if (eo.b) {
            eo.b.a("ThemeViewModel updateThemeResource view=" + g(view) + " attr=" + e());
        }
        eo.f(view, this.d);
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
        List<a> list = this.c;
        if (list != null && list.size() > 0) {
            for (a callback : this.c) {
                if (callback != null) {
                    callback.a();
                }
            }
        }
    }

    public final String e() {
        try {
            HashMap<String, Integer> hashMap = this.d;
            if (hashMap != null && hashMap.keySet() != null) {
                return Arrays.toString(this.d.keySet().toArray());
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public final String g(View view) {
        return view != null ? view.toString() : "view null";
    }
}
