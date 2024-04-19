package defpackage;

import java.io.IOException;
/* compiled from: MqttPingReq.java */
/* renamed from: ay  reason: default package */
/* loaded from: classes.dex */
public class ay extends my {
    public ay() {
        super((byte) 12);
    }

    public ay(byte info, byte[] variableHeader) throws IOException {
        super((byte) 12);
    }

    @Override // defpackage.my
    public boolean u() {
        return false;
    }

    @Override // defpackage.my
    public byte[] t() throws iw {
        return new byte[0];
    }

    @Override // defpackage.my
    public byte q() {
        return (byte) 0;
    }

    @Override // defpackage.my
    public String o() {
        return "Ping";
    }
}
