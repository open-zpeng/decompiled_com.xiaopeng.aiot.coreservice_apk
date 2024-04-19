package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.dc;
import java.util.ArrayList;
/* compiled from: FragmentManagerState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: fc  reason: default package */
/* loaded from: classes.dex */
public final class fc implements Parcelable {
    public static final Parcelable.Creator<fc> CREATOR = new a();
    public ArrayList<jc> a;
    public ArrayList<String> b;
    public ub[] d;
    public int f;
    public String g;
    public ArrayList<String> h;
    public ArrayList<Bundle> i;
    public ArrayList<dc.m> j;

    public fc() {
        this.g = null;
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    public fc(Parcel in) {
        this.g = null;
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.a = in.createTypedArrayList(jc.CREATOR);
        this.b = in.createStringArrayList();
        this.d = (ub[]) in.createTypedArray(ub.CREATOR);
        this.f = in.readInt();
        this.g = in.readString();
        this.h = in.createStringArrayList();
        this.i = in.createTypedArrayList(Bundle.CREATOR);
        this.j = in.createTypedArrayList(dc.m.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.a);
        dest.writeStringList(this.b);
        dest.writeTypedArray(this.d, flags);
        dest.writeInt(this.f);
        dest.writeString(this.g);
        dest.writeStringList(this.h);
        dest.writeTypedList(this.i);
        dest.writeTypedList(this.j);
    }

    /* compiled from: FragmentManagerState.java */
    /* renamed from: fc$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<fc> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public fc createFromParcel(Parcel in) {
            return new fc(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public fc[] newArray(int size) {
            return new fc[size];
        }
    }
}
