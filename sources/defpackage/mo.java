package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: VuiActType.java */
/* renamed from: mo  reason: default package */
/* loaded from: classes.dex */
public enum mo {
    SEARCH("Search"),
    SELECT("Select"),
    EDIT("Edit"),
    OPEN("Open"),
    DELETE("Delete"),
    DETAIL("Detail"),
    EXPANDFOLD("ExpandFold"),
    ROLL("Roll"),
    TAB("Tab"),
    SELECTTAB("SelectTab"),
    SLIDE("Slide"),
    UP("Up"),
    DOWN("Down"),
    LEFT("Left"),
    RIGHT("Right"),
    SET("Set"),
    SORT("Sort"),
    EXPAND("Expand"),
    ADD("Add"),
    PLAY("Play"),
    NULL("Null");
    
    public String y;

    mo(String type) {
        this.y = type;
    }

    public String a() {
        return this.y;
    }

    public static List<String> b() {
        mo[] values;
        List<String> actTypeList = new ArrayList<>();
        for (mo actType : values()) {
            actTypeList.add(actType.a());
        }
        return actTypeList;
    }
}
