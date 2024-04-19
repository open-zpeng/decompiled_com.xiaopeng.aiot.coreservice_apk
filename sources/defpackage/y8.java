package defpackage;

import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* renamed from: y8  reason: default package */
/* loaded from: classes.dex */
public final class y8 {
    public final String a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e = 0;
    public final String f;

    public y8(String providerAuthority, String providerPackage, String query, List<List<byte[]>> certificates) {
        this.a = (String) k9.d(providerAuthority);
        this.b = (String) k9.d(providerPackage);
        this.c = (String) k9.d(query);
        this.d = (List) k9.d(certificates);
        this.f = a(providerAuthority, providerPackage, query);
    }

    public final String a(String providerAuthority, String providerPackage, String query) {
        return providerAuthority + "-" + providerPackage + "-" + query;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            builder.append(" [");
            List<byte[]> set = this.d.get(i);
            for (int j = 0; j < set.size(); j++) {
                builder.append(" \"");
                byte[] array = set.get(j);
                builder.append(Base64.encodeToString(array, 0));
                builder.append("\"");
            }
            builder.append(" ]");
        }
        builder.append("}");
        builder.append("mCertificatesArray: " + this.e);
        return builder.toString();
    }
}
