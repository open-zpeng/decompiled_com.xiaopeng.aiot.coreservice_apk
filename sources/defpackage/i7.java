package defpackage;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
/* compiled from: Person.java */
/* renamed from: i7  reason: default package */
/* loaded from: classes.dex */
public class i7 {
    public CharSequence a;
    public IconCompat b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().l() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }

    public CharSequence c() {
        return this.a;
    }

    public IconCompat a() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String g() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        if (this.a != null) {
            return "name:" + ((Object) this.a);
        }
        return "";
    }
}
