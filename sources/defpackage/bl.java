package defpackage;

import okhttp3.Response;
import okhttp3.ResponseBody;
/* compiled from: StringConvert.java */
/* renamed from: bl  reason: default package */
/* loaded from: classes.dex */
public class bl implements al<String> {
    @Override // defpackage.al
    /* renamed from: a */
    public String convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return body.string();
    }
}
