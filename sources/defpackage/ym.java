package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
/* compiled from: CallExecuteObservable.java */
/* renamed from: ym  reason: default package */
/* loaded from: classes.dex */
public final class ym extends bs<IResponse> {
    public final IRequest a;

    public ym(IRequest originalCall) {
        this.a = originalCall;
    }

    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse> */
    @Override // defpackage.bs
    public void z(fs<? super IResponse> fsVar) {
        IRequest call = this.a;
        a disposable = new a(call);
        fsVar.onSubscribe(disposable);
        if (disposable.b()) {
            return;
        }
        boolean terminated = false;
        try {
            IResponse response = call.execute();
            if (!disposable.b()) {
                fsVar.onNext(response);
            }
            if (!disposable.b()) {
                terminated = true;
                fsVar.onComplete();
            }
        } catch (Throwable t) {
            qs.b(t);
            if (terminated) {
                iv.m(t);
            } else if (!disposable.b()) {
                try {
                    fsVar.onError(t);
                } catch (Throwable inner) {
                    qs.b(inner);
                    iv.m(new ps(t, inner));
                }
            }
        }
    }

    /* compiled from: CallExecuteObservable.java */
    /* renamed from: ym$a */
    /* loaded from: classes.dex */
    public static final class a implements ls {
        public final IRequest a;
        public volatile boolean b;

        public a(IRequest call) {
            this.a = call;
            call.tag(this);
        }

        @Override // defpackage.ls
        public void a() {
            lk.h().a(this);
            this.b = true;
        }

        public boolean b() {
            return this.b;
        }
    }
}
