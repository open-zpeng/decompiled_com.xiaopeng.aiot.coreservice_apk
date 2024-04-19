package defpackage;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* renamed from: zf  reason: default package */
/* loaded from: classes.dex */
public final class zf extends jh<Time> {
    public static final kh a = new a();
    public final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* renamed from: zf$a */
    /* loaded from: classes.dex */
    public static class a implements kh {
        @Override // defpackage.kh
        public <T> jh<T> a(xg xgVar, ug<T> ugVar) {
            if (ugVar.a() == Time.class) {
                return new zf();
            }
            return null;
        }
    }

    @Override // defpackage.jh
    /* renamed from: d */
    public synchronized Time c(qg qgVar) throws IOException {
        if (qgVar.t() == rg.NULL) {
            qgVar.w();
            return null;
        }
        try {
            return new Time(this.b.parse(qgVar.v()).getTime());
        } catch (ParseException e) {
            throw new hh(e);
        }
    }

    @Override // defpackage.jh
    /* renamed from: e */
    public synchronized void a(sg sgVar, Time time) throws IOException {
        sgVar.j(time == null ? null : this.b.format((Date) time));
    }
}
