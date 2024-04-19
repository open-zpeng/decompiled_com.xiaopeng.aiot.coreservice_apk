package defpackage;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
/* compiled from: TransactionDelegate.java */
/* renamed from: sh  reason: default package */
/* loaded from: classes.dex */
public class sh {
    public static void b(rh transaction, String measureName) {
        try {
            if (!nh.c || transaction == null) {
                return;
            }
            vj.c("TransactionDelegate", "statEvent begin. module: ", transaction.b, " monitorPoint: ", transaction.d, " measureName: ", measureName);
            zh zhVar = zh.STAT;
            if (zhVar.k() && (nh.a || ui.d(zhVar, transaction.b, transaction.d))) {
                yh.b().n(transaction.g, transaction.a, transaction.b, transaction.d, measureName);
                a(transaction);
                return;
            }
            vj.c("TransactionDelegate", "log discard", transaction.b, " monitorPoint: ", transaction.d, " measureName: ", measureName);
        } catch (Throwable th) {
            di.d(th);
        }
    }

    public static void a(rh rhVar) {
        if (rhVar != null && rhVar.f != null) {
            yh.b().m(rhVar.g, rhVar.a, rhVar.b, rhVar.d, DimensionValueSet.create().addValues(rhVar.f));
        }
    }

    public static void c(rh transaction, String measureName) {
        try {
            if (!nh.c || transaction == null) {
                return;
            }
            vj.c("TransactionDelegate", "statEvent end. module: ", transaction.b, " monitorPoint: ", transaction.d, " measureName: ", measureName);
            zh zhVar = zh.STAT;
            if (zhVar.k() && (nh.a || ui.d(zhVar, transaction.b, transaction.d))) {
                a(transaction);
                yh.b().p(transaction.g, measureName, false, transaction.h);
                return;
            }
            vj.c("TransactionDelegate", "log discard", transaction.b, " monitorPoint: ", transaction.d, " measureName: ", measureName);
        } catch (Throwable th) {
            di.d(th);
        }
    }
}
