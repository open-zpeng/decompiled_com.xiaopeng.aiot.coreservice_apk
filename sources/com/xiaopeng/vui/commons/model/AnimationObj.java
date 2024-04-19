package com.xiaopeng.vui.commons.model;
/* loaded from: classes.dex */
public class AnimationObj {
    private boolean effectOnly = false;
    private String effect = "waterRipple";

    public boolean isEffectOnly() {
        return this.effectOnly;
    }

    public void setEffectOnly(boolean effectOnly) {
        this.effectOnly = effectOnly;
    }

    public jo getEffect() {
        if ("waterRipple".equals(this.effect)) {
            return jo.WATERRIPPLE;
        }
        return jo.WATERRIPPLE;
    }

    public String toString() {
        return "AnimationObj{effectOnly=" + this.effectOnly + ", effect='" + this.effect + "'}";
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
