package defpackage;

import android.app.Activity;
import android.os.Bundle;
/* compiled from: XActivityTemplateExtend.java */
/* renamed from: qp  reason: default package */
/* loaded from: classes.dex */
public abstract class qp implements pp {
    public abstract void k(op opVar);

    public abstract void l(np npVar);

    public abstract void m(rp rpVar);

    public abstract void n(sp spVar);

    public static qp f(Activity activity, int type) {
        switch (type) {
            case 1:
                return new e(activity);
            case 2:
                return new c(activity);
            case 3:
                return new b(activity);
            case 4:
                return new f(activity);
            default:
                return new d(activity);
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$a */
    /* loaded from: classes.dex */
    public static class a extends qp {
        public Activity a;
        public op b;

        public a(Activity mActivity) {
            this.a = mActivity;
        }

        @Override // defpackage.pp
        public void j(Bundle var1) {
        }

        @Override // defpackage.qp
        public void m(rp mBuilder) {
        }

        @Override // defpackage.qp
        public void l(np causeGroup) {
            causeGroup.k();
        }

        @Override // defpackage.qp
        public void n(sp activityWindowVisible) {
        }

        @Override // defpackage.qp
        public void k(op dismiss) {
            this.b = dismiss;
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$d */
    /* loaded from: classes.dex */
    public static class d extends a {
        public d(Activity mActivity) {
            super(mActivity);
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$f */
    /* loaded from: classes.dex */
    public static class f extends a {
        public f(Activity mActivity) {
            super(mActivity);
        }

        @Override // defpackage.qp.a, defpackage.pp
        public void j(Bundle var1) {
            super.j(var1);
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$c */
    /* loaded from: classes.dex */
    public static class c extends a {
        public c(Activity mActivity) {
            super(mActivity);
        }

        @Override // defpackage.qp.a, defpackage.pp
        public void j(Bundle var1) {
            super.j(var1);
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$b */
    /* loaded from: classes.dex */
    public static class b extends a {
        public b(Activity mActivity) {
            super(mActivity);
        }

        @Override // defpackage.qp.a, defpackage.pp
        public void j(Bundle var1) {
            super.j(var1);
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void l(np causeGroup) {
            super.l(causeGroup);
            causeGroup.l();
            causeGroup.m();
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void m(rp builder) {
            builder.e(-2).d(-2).c(17);
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void n(sp windowVisible) {
            super.n(windowVisible);
            windowVisible.k(true);
        }
    }

    /* compiled from: XActivityTemplateExtend.java */
    /* renamed from: qp$e */
    /* loaded from: classes.dex */
    public static class e extends a {
        public e(Activity mActivity) {
            super(mActivity);
        }

        @Override // defpackage.qp.a, defpackage.pp
        public void j(Bundle var1) {
            super.j(var1);
            this.a.requestWindowFeature(14);
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void l(np causeGroup) {
            super.l(causeGroup);
            causeGroup.l();
            causeGroup.m();
            causeGroup.n();
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void m(rp mBuilder) {
            int orientation = this.a.getResources().getConfiguration().orientation;
            int x = tq.b(this.a, vo.x_compat_app_panel_x);
            int y = tq.b(this.a, vo.x_compat_app_panel_y);
            int width = tq.b(this.a, vo.x_compat_app_panel_width);
            int height = tq.b(this.a, vo.x_compat_app_panel_height);
            switch (orientation) {
                case 1:
                    mBuilder.f(x).g(y).e(width).d(height).c(80);
                    return;
                case 2:
                    mBuilder.f(x).g(y).e(width).d(height).c(8388627);
                    return;
                default:
                    return;
            }
        }

        @Override // defpackage.qp.a, defpackage.qp
        public void n(sp windowVisible) {
            super.n(windowVisible);
            windowVisible.k(true);
        }
    }
}
