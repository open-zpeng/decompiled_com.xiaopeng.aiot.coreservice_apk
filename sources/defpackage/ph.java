package defpackage;

import android.app.Application;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import defpackage.nh;
import defpackage.oh;
import java.util.Map;
/* compiled from: Monitor.java */
/* renamed from: ph  reason: default package */
/* loaded from: classes.dex */
public class ph extends oh.a {
    public Application a;

    public ph(Application application) {
        this.a = application;
    }

    @Override // defpackage.oh
    public void init() throws RemoteException {
        nh.c(this.a);
    }

    @Override // defpackage.oh
    public void destroy() throws RemoteException {
        nh.a();
    }

    @Override // defpackage.oh
    public void x() throws RemoteException {
        nh.m();
    }

    @Override // defpackage.oh
    public void c(int sampling) throws RemoteException {
        nh.j(sampling);
    }

    @Override // defpackage.oh
    public void i(boolean open) throws RemoteException {
        nh.b(open);
    }

    @Override // defpackage.oh
    public void I(int event, int statisticsInterval) throws RemoteException {
        nh.l(X(event), statisticsInterval);
    }

    @Override // defpackage.oh
    public void w(boolean isSecurity, String appkey, String secret, String authcode) throws RemoteException {
        nh.i(isSecurity, appkey, secret, authcode);
    }

    @Override // defpackage.oh
    public void A(String channel) throws RemoteException {
        nh.h(channel);
    }

    @Override // defpackage.oh
    public void H(Map params) throws RemoteException {
        nh.o(params);
    }

    @Override // defpackage.oh
    public void T() throws RemoteException {
        nh.n();
    }

    @Override // defpackage.oh
    public void b(int statisticsInterval) throws RemoteException {
        nh.b.e(statisticsInterval);
    }

    @Override // defpackage.oh
    public void S(int sampling) throws RemoteException {
        nh.b.d(sampling);
    }

    @Override // defpackage.oh
    public boolean d(String module, String monitorPoint) throws RemoteException {
        return nh.b.a(module, monitorPoint);
    }

    @Override // defpackage.oh
    public void E(String module, String monitorPoint, double value, Map exta) throws RemoteException {
        nh.b.b(module, monitorPoint, value, exta);
    }

    @Override // defpackage.oh
    public void F(String module, String monitorPoint, String arg, double value, Map exta) throws RemoteException {
        nh.b.c(module, monitorPoint, arg, value, exta);
    }

    @Override // defpackage.oh
    public void e(int statisticsInterval) throws RemoteException {
        nh.a.g(statisticsInterval);
    }

    @Override // defpackage.oh
    public void L(int sampling) throws RemoteException {
        nh.a.f(sampling);
    }

    @Override // defpackage.oh
    public boolean o(String module, String monitorPoint) throws RemoteException {
        return nh.a.a(module, monitorPoint);
    }

    @Override // defpackage.oh
    public void p(String module, String monitorPoint, Map exta) throws RemoteException {
        nh.a.e(module, monitorPoint, exta);
    }

    @Override // defpackage.oh
    public void g(String module, String monitorPoint, String arg, Map exta) throws RemoteException {
        nh.a.d(module, monitorPoint, arg, exta);
    }

    @Override // defpackage.oh
    public void D(String module, String monitorPoint, String errorCode, String errorMsg, Map exta) throws RemoteException {
        nh.a.c(module, monitorPoint, errorCode, errorMsg, exta);
    }

    @Override // defpackage.oh
    public void Q(String module, String monitorPoint, String arg, String errorCode, String errorMsg, Map exta) throws RemoteException {
        nh.a.b(module, monitorPoint, arg, errorCode, errorMsg, exta);
    }

    @Override // defpackage.oh
    public void u(int statisticsInterval) throws RemoteException {
        nh.c.d(statisticsInterval);
    }

    @Override // defpackage.oh
    public void G(int sampling) throws RemoteException {
        nh.c.c(sampling);
    }

    @Override // defpackage.oh
    public boolean U(String module, String monitorPoint) throws RemoteException {
        return nh.c.a(module, monitorPoint);
    }

    @Override // defpackage.oh
    public void a(String module, String monitorPoint, double value) throws RemoteException {
        nh.c.b(module, monitorPoint, value);
    }

    @Override // defpackage.oh
    public void N(int statisticsInterval) throws RemoteException {
        nh.k(statisticsInterval);
    }

    @Override // defpackage.oh
    public void C(String module, String monitorPoint, MeasureSet measures) throws RemoteException {
        nh.d(module, monitorPoint, measures);
    }

    @Override // defpackage.oh
    public void V(String module, String monitorPoint, MeasureSet measures, boolean isCommitDetail) throws RemoteException {
        nh.g(module, monitorPoint, measures, isCommitDetail);
    }

    @Override // defpackage.oh
    public void O(String module, String monitorPoint, MeasureSet measures, DimensionSet dimensions) throws RemoteException {
        nh.e(module, monitorPoint, measures, dimensions);
    }

    @Override // defpackage.oh
    public void l(String module, String monitorPoint, MeasureSet measures, DimensionSet dimensions, boolean isCommitDetail) throws RemoteException {
        nh.f(module, monitorPoint, measures, dimensions, isCommitDetail);
    }

    @Override // defpackage.oh
    public void n(String module, String monitorPoint, String measureName) throws RemoteException {
        nh.d.a(module, monitorPoint, measureName);
    }

    @Override // defpackage.oh
    public void t(String module, String monitorPoint, String measureName) throws RemoteException {
        nh.d.f(module, monitorPoint, measureName);
    }

    @Override // defpackage.oh
    public void v(int statisticsInterval) throws RemoteException {
        nh.d.h(statisticsInterval);
    }

    @Override // defpackage.oh
    public void z(int sampling) throws RemoteException {
        nh.d.g(sampling);
    }

    @Override // defpackage.oh
    public boolean q(String module, String monitorPoint) throws RemoteException {
        return nh.d.b(module, monitorPoint);
    }

    @Override // defpackage.oh
    public void B(String module, String monitorPoint, double value, Map exta) throws RemoteException {
        nh.d.c(module, monitorPoint, value, exta);
    }

    @Override // defpackage.oh
    public void M(String module, String monitorPoint, DimensionValueSet dimensionValues, double value, Map exta) throws RemoteException {
        nh.d.d(module, monitorPoint, dimensionValues, value, exta);
    }

    @Override // defpackage.oh
    public void y(String module, String monitorPoint, DimensionValueSet dimensionValues, MeasureValueSet measureValues, Map exta) throws RemoteException {
        vj.c("Monitor", "[stat_commit3]");
        nh.d.e(module, monitorPoint, dimensionValues, measureValues, exta);
    }

    public final zh X(int i) {
        return zh.b(i);
    }

    @Override // defpackage.oh
    public void r(rh transaction, String measureName) throws RemoteException {
        sh.b(transaction, measureName);
    }

    @Override // defpackage.oh
    public void j(rh transaction, String measureName) throws RemoteException {
        sh.c(transaction, measureName);
    }
}
