package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IResponse;
import java.util.Objects;
/* compiled from: HttpException.java */
/* renamed from: um  reason: default package */
/* loaded from: classes.dex */
public class um extends RuntimeException {
    public final int a;
    public final String b;
    public final transient IResponse d;

    public static String a(IResponse response) {
        Objects.requireNonNull(response, "response == null");
        return "HTTP " + response.code() + " " + response.message();
    }

    public um(IResponse response) {
        super(a(response));
        this.a = response.code();
        this.b = response.message();
        this.d = response;
    }
}
