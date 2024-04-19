package defpackage;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: ag  reason: default package */
/* loaded from: classes.dex */
public final class ag extends jh<Date> {
    public static final kh a = new a();
    public final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: ag$a */
    /* loaded from: classes.dex */
    public static class a implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() == Date.class) {
                return new ag();
            }
            return null;
        }
    }

    @Override // defpackage.jh
    /* renamed from: d */
    public synchronized Date c(qg qgVar) throws IOException {
        if (qgVar.t() == rg.NULL) {
            qgVar.w();
            return null;
        }
        try {
            return new Date(this.b.parse(qgVar.v()).getTime());
        } catch (ParseException e) {
            throw new hh(e);
        }
    }

    @Override // defpackage.jh
    /* renamed from: e */
    public synchronized void a(sg sgVar, Date date) throws IOException {
        sgVar.j(date == null ? null : this.b.format((java.util.Date) date));
    }
}
