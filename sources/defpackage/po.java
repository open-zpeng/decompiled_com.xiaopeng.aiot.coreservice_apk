package defpackage;

import com.xiaopeng.libconfig.settings.SettingsUtil;
/* compiled from: VuiFeedbackType.java */
/* renamed from: po  reason: default package */
/* loaded from: classes.dex */
public enum po {
    SOUND(SettingsUtil.PAGE_SOUND),
    TTS("Tts");
    
    public String f;

    po(String type) {
        this.f = type;
    }
}
