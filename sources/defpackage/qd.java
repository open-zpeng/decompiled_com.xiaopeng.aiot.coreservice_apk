package defpackage;
/* compiled from: ViewModelProvider.java */
/* renamed from: qd  reason: default package */
/* loaded from: classes.dex */
public class qd {
    public final a a;
    public final rd b;

    /* compiled from: ViewModelProvider.java */
    /* renamed from: qd$a */
    /* loaded from: classes.dex */
    public interface a {
        <T extends pd> T a(Class<T> cls);
    }

    /* compiled from: ViewModelProvider.java */
    /* renamed from: qd$c */
    /* loaded from: classes.dex */
    public static class c {
        public void b(pd viewModel) {
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* renamed from: qd$b */
    /* loaded from: classes.dex */
    public static abstract class b extends c implements a {
        public abstract <T extends pd> T c(String str, Class<T> cls);

        @Override // defpackage.qd.a
        public <T extends pd> T a(Class<T> modelClass) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    public qd(rd store, a factory) {
        this.a = factory;
        this.b = store;
    }

    public <T extends pd> T a(Class<T> modelClass) {
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public <T extends pd> T b(String key, Class<T> modelClass) {
        pd viewModel;
        T t = (T) this.b.b(key);
        if (modelClass.isInstance(t)) {
            a aVar = this.a;
            if (aVar instanceof c) {
                ((c) aVar).b(t);
            }
            return t;
        }
        a aVar2 = this.a;
        if (aVar2 instanceof b) {
            pd viewModel2 = ((b) aVar2).c(key, modelClass);
            viewModel = (T) viewModel2;
        } else {
            pd viewModel3 = aVar2.a(modelClass);
            viewModel = (T) viewModel3;
        }
        this.b.d(key, viewModel);
        return (T) viewModel;
    }
}
