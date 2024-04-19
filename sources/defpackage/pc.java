package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* renamed from: pc  reason: default package */
/* loaded from: classes.dex */
public abstract class pc {
    public abstract void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object g(Object obj);

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public abstract void z(Object obj, View view, ArrayList<View> arrayList);

    public void k(View view, Rect epicenter) {
        if (!ga.I(view)) {
            return;
        }
        RectF rect = new RectF();
        rect.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getMatrix().mapRect(rect);
        rect.offset(view.getLeft(), view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View parentView = (View) parent;
            rect.offset(-parentView.getScrollX(), -parentView.getScrollY());
            parentView.getMatrix().mapRect(rect);
            rect.offset(parentView.getLeft(), parentView.getTop());
            parent = parentView.getParent();
        }
        int[] loc = new int[2];
        view.getRootView().getLocationOnScreen(loc);
        rect.offset(loc[0], loc[1]);
        epicenter.set(Math.round(rect.left), Math.round(rect.top), Math.round(rect.right), Math.round(rect.bottom));
    }

    public ArrayList<String> o(ArrayList<View> sharedElementsIn) {
        ArrayList<String> names = new ArrayList<>();
        int numSharedElements = sharedElementsIn.size();
        for (int i = 0; i < numSharedElements; i++) {
            View view = sharedElementsIn.get(i);
            names.add(ga.C(view));
            ga.j0(view, null);
        }
        return names;
    }

    public void y(View sceneRoot, ArrayList<View> sharedElementsOut, ArrayList<View> sharedElementsIn, ArrayList<String> inNames, Map<String, String> nameOverrides) {
        int numSharedElements = sharedElementsIn.size();
        ArrayList<String> outNames = new ArrayList<>();
        for (int i = 0; i < numSharedElements; i++) {
            View view = sharedElementsOut.get(i);
            String name = ga.C(view);
            outNames.add(name);
            if (name != null) {
                ga.j0(view, null);
                String inName = nameOverrides.get(name);
                int j = 0;
                while (true) {
                    if (j < numSharedElements) {
                        if (!inName.equals(inNames.get(j))) {
                            j++;
                        } else {
                            ga.j0(sharedElementsIn.get(j), name);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        ea.a(sceneRoot, new a(numSharedElements, sharedElementsIn, inNames, sharedElementsOut, outNames));
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: pc$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ ArrayList g;

        public a(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.a = i;
            this.b = arrayList;
            this.d = arrayList2;
            this.f = arrayList3;
            this.g = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.a; i++) {
                ga.j0((View) this.b.get(i), (String) this.d.get(i));
                ga.j0((View) this.f.get(i), (String) this.g.get(i));
            }
        }
    }

    public void f(ArrayList<View> transitioningViews, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ia.a(viewGroup)) {
                    transitioningViews.add(viewGroup);
                    return;
                }
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    f(transitioningViews, child);
                }
                return;
            }
            transitioningViews.add(view);
        }
    }

    public void j(Map<String, View> namedViews, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = ga.C(view);
            if (transitionName != null) {
                namedViews.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int count = viewGroup.getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = viewGroup.getChildAt(i);
                    j(namedViews, child);
                }
            }
        }
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: pc$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ Map b;

        public b(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int numSharedElements = this.a.size();
            for (int i = 0; i < numSharedElements; i++) {
                View view = (View) this.a.get(i);
                String name = ga.C(view);
                if (name != null) {
                    String inName = pc.i(this.b, name);
                    ga.j0(view, inName);
                }
            }
        }
    }

    public void x(View sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        ea.a(sceneRoot, new b(sharedElementsIn, nameOverrides));
    }

    public void w(Fragment outFragment, Object transition, t8 signal, Runnable transitionCompleteRunnable) {
        transitionCompleteRunnable.run();
    }

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: pc$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ Map b;

        public c(ArrayList arrayList, Map map) {
            this.a = arrayList;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int numSharedElements = this.a.size();
            for (int i = 0; i < numSharedElements; i++) {
                View view = (View) this.a.get(i);
                String name = ga.C(view);
                String inName = (String) this.b.get(name);
                ga.j0(view, inName);
            }
        }
    }

    public void s(ViewGroup sceneRoot, ArrayList<View> sharedElementsIn, Map<String, String> nameOverrides) {
        ea.a(sceneRoot, new c(sharedElementsIn, nameOverrides));
    }

    public static void d(List<View> views, View startView) {
        int startIndex = views.size();
        if (h(views, startView, startIndex)) {
            return;
        }
        if (ga.C(startView) != null) {
            views.add(startView);
        }
        for (int index = startIndex; index < views.size(); index++) {
            View view = views.get(index);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int childIndex = 0; childIndex < childCount; childIndex++) {
                    View child = viewGroup.getChildAt(childIndex);
                    if (!h(views, child, startIndex) && ga.C(child) != null) {
                        views.add(child);
                    }
                }
            }
        }
    }

    public static boolean h(List<View> views, View view, int maxIndex) {
        for (int i = 0; i < maxIndex; i++) {
            if (views.get(i) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public static String i(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
