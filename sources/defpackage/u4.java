package defpackage;

import java.util.ArrayList;
/* compiled from: Chain.java */
/* renamed from: u4  reason: default package */
/* loaded from: classes.dex */
public class u4 {
    public static void b(y4 constraintWidgetContainer, e4 system, ArrayList<x4> arrayList, int orientation) {
        int offset;
        int chainsSize;
        v4[] chainsArray;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.W0;
            chainsArray = constraintWidgetContainer.Z0;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.X0;
            chainsArray = constraintWidgetContainer.Y0;
        }
        for (int i = 0; i < chainsSize; i++) {
            v4 first = chainsArray[i];
            first.a();
            if (arrayList == null || arrayList.contains(first.a)) {
                a(constraintWidgetContainer, system, orientation, offset, first);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:315:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0690  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.y4 r45, defpackage.e4 r46, int r47, int r48, defpackage.v4 r49) {
        /*
            Method dump skipped, instructions count: 1735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u4.a(y4, e4, int, int, v4):void");
    }
}
