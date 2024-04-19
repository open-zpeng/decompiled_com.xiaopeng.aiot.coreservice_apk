package defpackage;
/* compiled from: HttpException.java */
/* renamed from: jl  reason: default package */
/* loaded from: classes.dex */
public class jl extends RuntimeException {
    public jl(String message) {
        super(message);
    }

    public static jl b() {
        return new jl("network error! http response code is 404 or 5xx!");
    }

    public static jl a(String message) {
        return new jl(message);
    }
}
