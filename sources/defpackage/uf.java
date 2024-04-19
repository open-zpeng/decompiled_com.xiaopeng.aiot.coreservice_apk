package defpackage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateTypeAdapter.java */
/* renamed from: uf  reason: default package */
/* loaded from: classes.dex */
public final class uf extends jh<Date> {
    public static final kh a = new a();
    public final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    public final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
    public final DateFormat d = f();

    /* compiled from: DateTypeAdapter.java */
    /* renamed from: uf$a */
    /* loaded from: classes.dex */
    public static class a implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() == Date.class) {
                return new uf();
            }
            return null;
        }
    }

    public static DateFormat f() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    @Override // defpackage.jh
    /* renamed from: d */
    public Date c(qg qgVar) throws IOException {
        if (qgVar.t() == rg.NULL) {
            qgVar.w();
            return null;
        }
        return g(qgVar.v());
    }

    @Override // defpackage.jh
    /* renamed from: e */
    public synchronized void a(sg sgVar, Date date) throws IOException {
        if (date == null) {
            sgVar.u();
        } else {
            sgVar.j(this.b.format(date));
        }
    }

    public final synchronized Date g(String str) {
        try {
        } catch (ParseException e) {
            try {
                return this.b.parse(str);
            } catch (ParseException e2) {
                try {
                    return this.d.parse(str);
                } catch (ParseException e3) {
                    throw new hh(str, e3);
                }
            }
        }
        return this.c.parse(str);
    }
}
