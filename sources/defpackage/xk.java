package defpackage;

import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
/* compiled from: AbsCallback.java */
/* renamed from: xk  reason: default package */
/* loaded from: classes.dex */
public abstract class xk<T> implements yk<T> {
    /* JADX WARN: Generic types in debug info not equals: sl != com.lzy.okgo.request.base.Request<T, ? extends com.lzy.okgo.request.base.Request> */
    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    @Override // defpackage.yk
    public void onStart(sl<T, ? extends sl> slVar) {
    }

    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    @Override // defpackage.yk
    public void onCacheSuccess(Response<T> response) {
    }

    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    @Override // defpackage.yk
    public void onError(Response<T> response) {
        wl.a(response.getException());
    }

    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    @Override // defpackage.yk
    public void onFinish() {
    }

    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    @Override // defpackage.yk
    public void uploadProgress(Progress progress) {
    }

    /* JADX WARN: Generic types in debug info not equals: xk != com.lzy.okgo.callback.AbsCallback<T> */
    public void downloadProgress(Progress progress) {
    }
}
