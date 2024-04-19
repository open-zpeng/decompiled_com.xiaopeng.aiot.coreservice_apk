package defpackage;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import defpackage.cd;
/* compiled from: ReportFragment.java */
/* renamed from: nd  reason: default package */
/* loaded from: classes.dex */
public class nd extends Fragment {
    public a a;

    /* compiled from: ReportFragment.java */
    /* renamed from: nd$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager manager = activity.getFragmentManager();
        if (manager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            manager.beginTransaction().add(new nd(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            manager.executePendingTransactions();
        }
    }

    public static void a(Activity activity, cd.b event) {
        if (activity instanceof hd) {
            ((hd) activity).a().h(event);
        } else if (activity instanceof fd) {
            cd lifecycle = ((fd) activity).a();
            if (lifecycle instanceof gd) {
                ((gd) lifecycle).h(event);
            }
        }
    }

    public final void c(a listener) {
        if (listener != null) {
            listener.b();
        }
    }

    public final void e(a listener) {
        if (listener != null) {
            listener.a();
        }
    }

    public final void d(a listener) {
        if (listener != null) {
            listener.c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        c(this.a);
        b(cd.b.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(this.a);
        b(cd.b.ON_START);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.a);
        b(cd.b.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        b(cd.b.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        b(cd.b.ON_STOP);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b(cd.b.ON_DESTROY);
        this.a = null;
    }

    public final void b(cd.b event) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), event);
        }
    }

    /* compiled from: ReportFragment.java */
    /* renamed from: nd$b */
    /* loaded from: classes.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle savedInstanceState) {
            nd.a(activity, cd.b.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            nd.a(activity, cd.b.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            nd.a(activity, cd.b.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            nd.a(activity, cd.b.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            nd.a(activity, cd.b.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            nd.a(activity, cd.b.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }
    }
}
