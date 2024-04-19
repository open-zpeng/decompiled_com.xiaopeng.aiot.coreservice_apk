package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: jc  reason: default package */
/* loaded from: classes.dex */
public final class jc implements Parcelable {
    public static final Parcelable.Creator<jc> CREATOR = new a();
    public final String a;
    public final String b;
    public final boolean d;
    public final int f;
    public final int g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final Bundle l;
    public final boolean m;
    public final int n;
    public Bundle o;

    public jc(Fragment frag) {
        this.a = frag.getClass().getName();
        this.b = frag.i;
        this.d = frag.q;
        this.f = frag.z;
        this.g = frag.A;
        this.h = frag.B;
        this.i = frag.E;
        this.j = frag.p;
        this.k = frag.D;
        this.l = frag.j;
        this.m = frag.C;
        this.n = frag.U.ordinal();
    }

    public jc(Parcel in) {
        this.a = in.readString();
        this.b = in.readString();
        this.d = in.readInt() != 0;
        this.f = in.readInt();
        this.g = in.readInt();
        this.h = in.readString();
        this.i = in.readInt() != 0;
        this.j = in.readInt() != 0;
        this.k = in.readInt() != 0;
        this.l = in.readBundle();
        this.m = in.readInt() != 0;
        this.o = in.readBundle();
        this.n = in.readInt();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.b);
        sb.append(")}:");
        if (this.d) {
            sb.append(" fromLayout");
        }
        if (this.g != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.g));
        }
        String str = this.h;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.h);
        }
        if (this.i) {
            sb.append(" retainInstance");
        }
        if (this.j) {
            sb.append(" removing");
        }
        if (this.k) {
            sb.append(" detached");
        }
        if (this.m) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
        dest.writeString(this.b);
        dest.writeInt(this.d ? 1 : 0);
        dest.writeInt(this.f);
        dest.writeInt(this.g);
        dest.writeString(this.h);
        dest.writeInt(this.i ? 1 : 0);
        dest.writeInt(this.j ? 1 : 0);
        dest.writeInt(this.k ? 1 : 0);
        dest.writeBundle(this.l);
        dest.writeInt(this.m ? 1 : 0);
        dest.writeBundle(this.o);
        dest.writeInt(this.n);
    }

    /* compiled from: FragmentState.java */
    /* renamed from: jc$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<jc> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public jc createFromParcel(Parcel in) {
            return new jc(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public jc[] newArray(int size) {
            return new jc[size];
        }
    }
}
