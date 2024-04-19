package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* compiled from: VersionedParcelParcel.java */
/* renamed from: kf  reason: default package */
/* loaded from: classes.dex */
public class kf extends jf {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public kf(Parcel p) {
        this(p, p.dataPosition(), p.dataSize(), "", new t3(), new t3(), new t3());
    }

    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.Class> */
    /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.reflect.Method> */
    public kf(Parcel p, int offset, int end, String prefix, t3<String, Method> t3Var, t3<String, Method> t3Var2, t3<String, Class> t3Var3) {
        super(t3Var, t3Var2, t3Var3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = p;
        this.f = offset;
        this.g = end;
        this.j = offset;
        this.h = prefix;
    }

    @Override // defpackage.jf
    public boolean m(int fieldId) {
        while (this.j < this.g) {
            int i = this.k;
            if (i == fieldId) {
                return true;
            }
            if (String.valueOf(i).compareTo(String.valueOf(fieldId)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int size = this.e.readInt();
            this.k = this.e.readInt();
            this.j += size;
        }
        return this.k == fieldId;
    }

    @Override // defpackage.jf
    public void w(int fieldId) {
        a();
        this.i = fieldId;
        this.d.put(fieldId, this.e.dataPosition());
        E(0);
        E(fieldId);
    }

    @Override // defpackage.jf
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int currentFieldPosition = this.d.get(i);
            int position = this.e.dataPosition();
            int size = position - currentFieldPosition;
            this.e.setDataPosition(currentFieldPosition);
            this.e.writeInt(size);
            this.e.setDataPosition(position);
        }
    }

    @Override // defpackage.jf
    public jf b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        int i2 = i;
        return new kf(parcel, dataPosition, i2, this.h + "  ", this.a, this.b, this.c);
    }

    @Override // defpackage.jf
    public void A(byte[] b) {
        if (b != null) {
            this.e.writeInt(b.length);
            this.e.writeByteArray(b);
            return;
        }
        this.e.writeInt(-1);
    }

    @Override // defpackage.jf
    public void E(int val) {
        this.e.writeInt(val);
    }

    @Override // defpackage.jf
    public void I(String val) {
        this.e.writeString(val);
    }

    @Override // defpackage.jf
    public void G(Parcelable p) {
        this.e.writeParcelable(p, 0);
    }

    @Override // defpackage.jf
    public void y(boolean val) {
        this.e.writeInt(val ? 1 : 0);
    }

    @Override // defpackage.jf
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // defpackage.jf
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // defpackage.jf
    public int o() {
        return this.e.readInt();
    }

    @Override // defpackage.jf
    public String s() {
        return this.e.readString();
    }

    @Override // defpackage.jf
    public byte[] i() {
        int len = this.e.readInt();
        if (len < 0) {
            return null;
        }
        byte[] bytes = new byte[len];
        this.e.readByteArray(bytes);
        return bytes;
    }

    @Override // defpackage.jf
    public <T extends Parcelable> T q() {
        return (T) this.e.readParcelable(getClass().getClassLoader());
    }

    @Override // defpackage.jf
    public boolean g() {
        return this.e.readInt() != 0;
    }
}
