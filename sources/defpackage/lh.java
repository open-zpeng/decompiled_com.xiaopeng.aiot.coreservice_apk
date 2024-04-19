package defpackage;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* renamed from: lh  reason: default package */
/* loaded from: classes.dex */
public abstract class lh {
    public boolean a() {
        return this instanceof dh;
    }

    public boolean b() {
        return this instanceof zg;
    }

    public boolean c() {
        return this instanceof ch;
    }

    public boolean d() {
        return this instanceof fh;
    }

    public dh e() {
        if (a()) {
            return (dh) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public zg f() {
        if (b()) {
            return (zg) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public fh g() {
        if (d()) {
            return (fh) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            sg sgVar = new sg(stringWriter);
            sgVar.l(true);
            mg.b(this, sgVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
