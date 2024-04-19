package defpackage;

import okhttp3.Response;
/* compiled from: StringCallback.java */
/* renamed from: zk  reason: default package */
/* loaded from: classes.dex */
public abstract class zk extends xk<String> {
    private bl convert = new bl();

    @Override // defpackage.al
    public String convertResponse(Response response) throws Throwable {
        String s = this.convert.convertResponse(response);
        response.close();
        return s;
    }
}
