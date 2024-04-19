package defpackage;

import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
/* compiled from: Callback.java */
/* renamed from: yk  reason: default package */
/* loaded from: classes.dex */
public interface yk<T> extends al<T> {
    void onCacheSuccess(Response<T> response);

    void onError(Response<T> response);

    void onFinish();

    void onStart(sl<T, ? extends sl> slVar);

    void onSuccess(Response<T> response);

    void uploadProgress(Progress progress);
}
