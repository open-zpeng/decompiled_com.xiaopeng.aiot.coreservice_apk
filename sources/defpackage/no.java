package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: VuiAction.java */
/* renamed from: no  reason: default package */
/* loaded from: classes.dex */
public enum no {
    CLICK("Click"),
    SETVALUE("SetValue"),
    SCROLLBYX("ScrollByX"),
    SCROLLBYY("ScrollByY"),
    SETCHECK("SetCheck"),
    ITEMCLICK("ItemClick"),
    SELECTTAB("SelectTab"),
    SCROLLTO("ScrollTo"),
    SETSELECTED("SetSelected");
    
    public String m;

    no(String name) {
        this.m = name;
    }

    public String a() {
        return this.m;
    }

    public static List<String> b() {
        no[] values;
        List<String> actionList = new ArrayList<>();
        for (no action : values()) {
            actionList.add(action.a());
        }
        return actionList;
    }
}
