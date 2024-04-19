package defpackage;

import android.annotation.SuppressLint;
import com.xiaopeng.aiot.coreservice.model.BizRxHttpsModel;
import com.xiaopeng.lib.http.server.ServerBean;
/* compiled from: AiotHttpPresenter.kt */
/* renamed from: jm  reason: default package */
/* loaded from: classes.dex */
public final class jm {
    public final String a = "AiotHttpPresenter";

    @SuppressLint({"CheckResult"})
    public final void h(String vin, String groupId, String groupName, String dataType, String dataContent, Long reportTime, final km<ServerBean> kmVar) {
        kv.a(kmVar, "handler");
        BizRxHttpsModel.postIotDeviceReport(vin, groupId, groupName, dataType, dataContent, reportTime).A(jv.b()).r(1L).o(is.a()).x(new ys() { // from class: hm
            @Override // defpackage.ys
            public final void accept(Object obj) {
                jm.i(km.this, (ServerBean) obj);
            }
        }, new ys() { // from class: fm
            @Override // defpackage.ys
            public final void accept(Object obj) {
                jm.j(km.this, (Throwable) obj);
            }
        });
    }

    public static final void i(km $handler, ServerBean data) {
        kv.a($handler, "$handler");
        $handler.a(data);
    }

    public static final void j(km $handler, Throwable t) {
        kv.a($handler, "$handler");
        $handler.onFail(t.getMessage());
    }

    @SuppressLint({"CheckResult"})
    public final void e(String vin, String taskId, Boolean awakeResult, String failedReason, Long reportTime, final km<ServerBean> kmVar) {
        kv.a(kmVar, "handler");
        BizRxHttpsModel.postAppAwakeResultReport(vin, taskId, awakeResult, failedReason, reportTime).A(jv.b()).r(1L).o(is.a()).x(new ys() { // from class: im
            @Override // defpackage.ys
            public final void accept(Object obj) {
                jm.f(km.this, (ServerBean) obj);
            }
        }, new ys() { // from class: gm
            @Override // defpackage.ys
            public final void accept(Object obj) {
                jm.g(km.this, (Throwable) obj);
            }
        });
    }

    public static final void f(km $handler, ServerBean data) {
        kv.a($handler, "$handler");
        $handler.a(data);
    }

    public static final void g(km $handler, Throwable t) {
        kv.a($handler, "$handler");
        $handler.onFail(t.getMessage());
    }
}
