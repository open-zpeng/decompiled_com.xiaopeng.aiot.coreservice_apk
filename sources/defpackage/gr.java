package defpackage;
/* compiled from: VuiCommonUtils.java */
/* renamed from: gr  reason: default package */
/* loaded from: classes.dex */
public class gr {
    public static ro c(int priority) {
        switch (priority) {
            case 0:
                ro viewLeveEnum = ro.LEVEL1;
                return viewLeveEnum;
            case 1:
                ro viewLeveEnum2 = ro.LEVEL2;
                return viewLeveEnum2;
            case 2:
                ro viewLeveEnum3 = ro.LEVEL3;
                return viewLeveEnum3;
            case 3:
                ro viewLeveEnum4 = ro.LEVEL4;
                return viewLeveEnum4;
            default:
                ro viewLeveEnum5 = ro.LEVEL3;
                return viewLeveEnum5;
        }
    }

    public static qo d(int value) {
        switch (value) {
            case 1:
                qo vuiMode = qo.DISABLED;
                return vuiMode;
            case 2:
                qo vuiMode2 = qo.SILENT;
                return vuiMode2;
            case 3:
                qo vuiMode3 = qo.UNDERSTOOD;
                return vuiMode3;
            default:
                qo vuiMode4 = qo.NORMAL;
                return vuiMode4;
        }
    }

    public static po b(int value) {
        switch (value) {
            case 1:
                po vuiFeedbackType = po.SOUND;
                return vuiFeedbackType;
            case 2:
                po vuiFeedbackType2 = po.TTS;
                return vuiFeedbackType2;
            default:
                po vuiFeedbackType3 = po.SOUND;
                return vuiFeedbackType3;
        }
    }

    public static oo a(int value) {
        switch (value) {
            case 1:
                oo elementType = oo.BUTTON;
                return elementType;
            case 2:
                oo elementType2 = oo.LISTVIEW;
                return elementType2;
            case 3:
                oo elementType3 = oo.CHECKBOX;
                return elementType3;
            case 4:
                oo elementType4 = oo.RADIOBUTTON;
                return elementType4;
            case 5:
                oo elementType5 = oo.RADIOGROUP;
                return elementType5;
            case 6:
                oo elementType6 = oo.GROUP;
                return elementType6;
            case 7:
                oo elementType7 = oo.EDITTEXT;
                return elementType7;
            case 8:
                oo elementType8 = oo.PROGRESSBAR;
                return elementType8;
            case 9:
                oo elementType9 = oo.SEEKBAR;
                return elementType9;
            case 10:
                oo elementType10 = oo.TABHOST;
                return elementType10;
            case 11:
                oo elementType11 = oo.SEARCHVIEW;
                return elementType11;
            case 12:
                oo elementType12 = oo.RATINGBAR;
                return elementType12;
            case 13:
                oo elementType13 = oo.IMAGEBUTTON;
                return elementType13;
            case 14:
                oo elementType14 = oo.IMAGEVIEW;
                return elementType14;
            case 15:
                oo elementType15 = oo.SCROLLVIEW;
                return elementType15;
            case 16:
                oo elementType16 = oo.TEXTVIEW;
                return elementType16;
            case 17:
                oo elementType17 = oo.RECYCLEVIEW;
                return elementType17;
            case 18:
                oo elementType18 = oo.SWITCH;
                return elementType18;
            case 19:
                oo elementType19 = oo.CUSTOM;
                return elementType19;
            case 20:
                oo elementType20 = oo.XSLIDER;
                return elementType20;
            case 21:
                oo elementType21 = oo.XTABLAYOUT;
                return elementType21;
            case 22:
                oo elementType22 = oo.XGROUPHEADER;
                return elementType22;
            default:
                oo elementType23 = oo.UNKNOWN;
                return elementType23;
        }
    }
}
