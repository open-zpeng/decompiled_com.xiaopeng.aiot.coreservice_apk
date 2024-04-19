package defpackage;

import com.xiaopeng.lib.http.server.ServerBean;
import java.util.Objects;
/* compiled from: BusinessException.java */
/* renamed from: tm  reason: default package */
/* loaded from: classes.dex */
public class tm extends RuntimeException {
    public final int a;
    public final String b;
    public final transient ServerBean d;

    public static String a(ServerBean response) {
        Objects.requireNonNull(response, "response == null");
        return "BUSINESS " + response.getCode() + " " + response.getMsg();
    }

    public tm(ServerBean response) {
        super(a(response));
        this.a = response.getCode();
        this.b = response.getMsg();
        this.d = response;
    }
}
