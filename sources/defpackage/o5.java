package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import defpackage.h5;
import defpackage.w4;
import defpackage.x4;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: Grouping.java */
/* renamed from: o5  reason: default package */
/* loaded from: classes.dex */
public class o5 {
    public static boolean d(x4.b layoutHorizontal, x4.b layoutVertical, x4.b widgetHorizontal, x4.b widgetVertical) {
        x4.b bVar;
        x4.b bVar2;
        x4.b bVar3 = x4.b.FIXED;
        boolean fixedHorizontal = widgetHorizontal == bVar3 || widgetHorizontal == (bVar2 = x4.b.WRAP_CONTENT) || (widgetHorizontal == x4.b.MATCH_PARENT && layoutHorizontal != bVar2);
        boolean fixedVertical = widgetVertical == bVar3 || widgetVertical == (bVar = x4.b.WRAP_CONTENT) || (widgetVertical == x4.b.MATCH_PARENT && layoutVertical != bVar);
        return fixedHorizontal || fixedVertical;
    }

    public static boolean c(y4 layout, h5.b measurer) {
        boolean z;
        ArrayList<x4> l1 = layout.l1();
        int count = l1.size();
        ArrayList<Guideline> verticalGuidelines = null;
        ArrayList<Guideline> horizontalGuidelines = null;
        ArrayList<HelperWidget> horizontalBarriers = null;
        ArrayList<HelperWidget> verticalBarriers = null;
        ArrayList<ConstraintWidget> isolatedHorizontalChildren = null;
        ArrayList<ConstraintWidget> isolatedVerticalChildren = null;
        for (int i = 0; i < count; i++) {
            x4 child = l1.get(i);
            if (!d(layout.A(), layout.Q(), child.A(), child.Q()) || (child instanceof z4)) {
                return false;
            }
        }
        if (layout.Q0 != null) {
            throw null;
        }
        for (int i2 = 0; i2 < count; i2++) {
            x4 child2 = l1.get(i2);
            if (!d(layout.A(), layout.Q(), child2.A(), child2.Q())) {
                y4.M1(0, child2, measurer, layout.p1, h5.a.a);
            }
            if (child2 instanceof a5) {
                a5 guideline = (a5) child2;
                if (guideline.m1() == 0) {
                    if (horizontalGuidelines == null) {
                        horizontalGuidelines = new ArrayList<>();
                    }
                    horizontalGuidelines.add(guideline);
                }
                if (guideline.m1() == 1) {
                    if (verticalGuidelines == null) {
                        verticalGuidelines = new ArrayList<>();
                    }
                    verticalGuidelines.add(guideline);
                }
            }
            if (child2 instanceof c5) {
                if (child2 instanceof t4) {
                    t4 barrier = (t4) child2;
                    if (barrier.r1() == 0) {
                        if (horizontalBarriers == null) {
                            horizontalBarriers = new ArrayList<>();
                        }
                        horizontalBarriers.add(barrier);
                    }
                    if (barrier.r1() == 1) {
                        if (verticalBarriers == null) {
                            verticalBarriers = new ArrayList<>();
                        }
                        verticalBarriers.add(barrier);
                    }
                } else {
                    c5 helper = (c5) child2;
                    if (horizontalBarriers == null) {
                        horizontalBarriers = new ArrayList<>();
                    }
                    horizontalBarriers.add(helper);
                    if (verticalBarriers == null) {
                        verticalBarriers = new ArrayList<>();
                    }
                    verticalBarriers.add(helper);
                }
            }
            if (child2.O.f == null && child2.Q.f == null && !(child2 instanceof a5) && !(child2 instanceof t4)) {
                if (isolatedHorizontalChildren == null) {
                    isolatedHorizontalChildren = new ArrayList<>();
                }
                isolatedHorizontalChildren.add(child2);
            }
            if (child2.P.f == null && child2.R.f == null && child2.S.f == null && !(child2 instanceof a5) && !(child2 instanceof t4)) {
                if (isolatedVerticalChildren == null) {
                    isolatedVerticalChildren = new ArrayList<>();
                }
                isolatedVerticalChildren.add(child2);
            }
        }
        ArrayList<u5> arrayList = new ArrayList<>();
        if (verticalGuidelines != null) {
            Iterator<Guideline> it = verticalGuidelines.iterator();
            while (it.hasNext()) {
                a5 guideline2 = (a5) it.next();
                a(guideline2, 0, arrayList, null);
            }
        }
        if (horizontalBarriers != null) {
            Iterator<HelperWidget> it2 = horizontalBarriers.iterator();
            while (it2.hasNext()) {
                c5 barrier2 = (c5) it2.next();
                ArrayList<Guideline> verticalGuidelines2 = verticalGuidelines;
                u5 group = a(barrier2, 0, arrayList, null);
                barrier2.l1(arrayList, 0, group);
                group.b(arrayList);
                verticalGuidelines = verticalGuidelines2;
            }
        }
        w4 left = layout.o(w4.b.LEFT);
        if (left.d() != null) {
            Iterator<w4> it3 = left.d().iterator();
            while (it3.hasNext()) {
                w4 first = it3.next();
                a(first.d, 0, arrayList, null);
                left = left;
            }
        }
        w4 right = layout.o(w4.b.RIGHT);
        if (right.d() != null) {
            Iterator<w4> it4 = right.d().iterator();
            while (it4.hasNext()) {
                w4 first2 = it4.next();
                a(first2.d, 0, arrayList, null);
                right = right;
            }
        }
        w4 center = layout.o(w4.b.CENTER);
        if (center.d() != null) {
            Iterator<w4> it5 = center.d().iterator();
            while (it5.hasNext()) {
                w4 first3 = it5.next();
                a(first3.d, 0, arrayList, null);
                center = center;
            }
        }
        if (isolatedHorizontalChildren != null) {
            Iterator<ConstraintWidget> it6 = isolatedHorizontalChildren.iterator();
            while (it6.hasNext()) {
                x4 widget = (x4) it6.next();
                a(widget, 0, arrayList, null);
            }
        }
        if (horizontalGuidelines != null) {
            Iterator<Guideline> it7 = horizontalGuidelines.iterator();
            while (it7.hasNext()) {
                a5 guideline3 = (a5) it7.next();
                a(guideline3, 1, arrayList, null);
            }
        }
        if (verticalBarriers != null) {
            Iterator<HelperWidget> it8 = verticalBarriers.iterator();
            while (it8.hasNext()) {
                c5 barrier3 = (c5) it8.next();
                u5 group2 = a(barrier3, 1, arrayList, null);
                barrier3.l1(arrayList, 1, group2);
                group2.b(arrayList);
            }
        }
        w4 top = layout.o(w4.b.TOP);
        if (top.d() != null) {
            Iterator<w4> it9 = top.d().iterator();
            while (it9.hasNext()) {
                w4 first4 = it9.next();
                a(first4.d, 1, arrayList, null);
                horizontalGuidelines = horizontalGuidelines;
            }
        }
        w4 baseline = layout.o(w4.b.BASELINE);
        if (baseline.d() != null) {
            Iterator<w4> it10 = baseline.d().iterator();
            while (it10.hasNext()) {
                w4 first5 = it10.next();
                a(first5.d, 1, arrayList, null);
                baseline = baseline;
            }
        }
        w4 bottom = layout.o(w4.b.BOTTOM);
        if (bottom.d() != null) {
            Iterator<w4> it11 = bottom.d().iterator();
            while (it11.hasNext()) {
                w4 first6 = it11.next();
                a(first6.d, 1, arrayList, null);
                bottom = bottom;
            }
        }
        w4 center2 = layout.o(w4.b.CENTER);
        if (center2.d() != null) {
            Iterator<w4> it12 = center2.d().iterator();
            while (it12.hasNext()) {
                w4 first7 = it12.next();
                a(first7.d, 1, arrayList, null);
                center2 = center2;
            }
        }
        if (isolatedVerticalChildren != null) {
            Iterator<ConstraintWidget> it13 = isolatedVerticalChildren.iterator();
            while (it13.hasNext()) {
                x4 widget2 = (x4) it13.next();
                a(widget2, 1, arrayList, null);
            }
        }
        for (int i3 = 0; i3 < count; i3++) {
            x4 child3 = l1.get(i3);
            if (child3.p0()) {
                u5 horizontalGroup = b(arrayList, child3.H0);
                u5 verticalGroup = b(arrayList, child3.I0);
                if (horizontalGroup != null && verticalGroup != null) {
                    horizontalGroup.g(0, verticalGroup);
                    verticalGroup.i(2);
                    arrayList.remove(horizontalGroup);
                }
            }
        }
        int i4 = arrayList.size();
        if (i4 <= 1) {
            return false;
        }
        u5 horizontalPick = null;
        u5 verticalPick = null;
        if (layout.A() == x4.b.WRAP_CONTENT) {
            int maxWrap = 0;
            u5 picked = null;
            Iterator<u5> it14 = arrayList.iterator();
            while (it14.hasNext()) {
                u5 list = it14.next();
                ArrayList<x4> arrayList2 = l1;
                if (list.d() == 1) {
                    l1 = arrayList2;
                } else {
                    list.h(false);
                    int wrap = list.f(layout.E1(), 0);
                    if (wrap > maxWrap) {
                        maxWrap = wrap;
                        picked = list;
                    }
                    l1 = arrayList2;
                }
            }
            if (picked != null) {
                layout.J0(x4.b.FIXED);
                layout.e1(maxWrap);
                picked.h(true);
                horizontalPick = picked;
            }
        }
        if (layout.Q() != x4.b.WRAP_CONTENT) {
            z = true;
        } else {
            int maxWrap2 = 0;
            u5 picked2 = null;
            Iterator<u5> it15 = arrayList.iterator();
            while (it15.hasNext()) {
                u5 list2 = it15.next();
                if (list2.d() != 0) {
                    list2.h(false);
                    int wrap2 = list2.f(layout.E1(), 1);
                    if (wrap2 > maxWrap2) {
                        picked2 = list2;
                        maxWrap2 = wrap2;
                    }
                }
            }
            if (picked2 != null) {
                layout.a1(x4.b.FIXED);
                layout.F0(maxWrap2);
                z = true;
                picked2.h(true);
                verticalPick = picked2;
            } else {
                z = true;
            }
        }
        if (horizontalPick == null && verticalPick == null) {
            return false;
        }
        return z;
    }

    public static u5 b(ArrayList<u5> arrayList, int groupId) {
        int count = arrayList.size();
        for (int i = 0; i < count; i++) {
            u5 group = arrayList.get(i);
            if (groupId == group.c) {
                return group;
            }
        }
        return null;
    }

    public static u5 a(x4 constraintWidget, int orientation, ArrayList<u5> arrayList, u5 group) {
        int groupId;
        if (orientation == 0) {
            groupId = constraintWidget.H0;
        } else {
            groupId = constraintWidget.I0;
        }
        if (groupId != -1 && (group == null || groupId != group.c)) {
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                u5 widgetGroup = arrayList.get(i);
                if (widgetGroup.c() != groupId) {
                    i++;
                } else {
                    if (group != null) {
                        group.g(orientation, widgetGroup);
                        arrayList.remove(group);
                    }
                    group = widgetGroup;
                }
            }
        } else if (groupId != -1) {
            return group;
        }
        if (group == null) {
            if (constraintWidget instanceof c5) {
                c5 helper = (c5) constraintWidget;
                int groupId2 = helper.m1(orientation);
                if (groupId2 != -1) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        u5 widgetGroup2 = arrayList.get(i2);
                        if (widgetGroup2.c() != groupId2) {
                            i2++;
                        } else {
                            group = widgetGroup2;
                            break;
                        }
                    }
                }
            }
            if (group == null) {
                group = new u5(orientation);
            }
            arrayList.add(group);
        }
        if (group.a(constraintWidget)) {
            if (constraintWidget instanceof a5) {
                a5 guideline = (a5) constraintWidget;
                guideline.l1().c(guideline.m1() == 0 ? 1 : 0, arrayList, group);
            }
            if (orientation == 0) {
                constraintWidget.H0 = group.c();
                constraintWidget.O.c(orientation, arrayList, group);
                constraintWidget.Q.c(orientation, arrayList, group);
            } else {
                constraintWidget.I0 = group.c();
                constraintWidget.P.c(orientation, arrayList, group);
                constraintWidget.S.c(orientation, arrayList, group);
                constraintWidget.R.c(orientation, arrayList, group);
            }
            constraintWidget.V.c(orientation, arrayList, group);
        }
        return group;
    }
}
