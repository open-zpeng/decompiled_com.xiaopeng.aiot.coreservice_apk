package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.Map;
/* compiled from: Transaction.java */
/* renamed from: rh  reason: default package */
/* loaded from: classes.dex */
public class rh implements Parcelable {
    public static final Parcelable.Creator<rh> CREATOR = new a();
    public Integer a;
    public String b;
    public String d;
    public DimensionValueSet f;
    public String g;
    public Map<String, String> h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.f, flags);
        dest.writeInt(this.a.intValue());
        dest.writeString(this.b);
        dest.writeString(this.d);
        dest.writeString(this.g);
        dest.writeMap(this.h);
    }

    public static rh a(Parcel parcel) {
        rh rhVar = new rh();
        try {
            rhVar.f = (DimensionValueSet) parcel.readParcelable(rh.class.getClassLoader());
            rhVar.a = Integer.valueOf(parcel.readInt());
            rhVar.b = parcel.readString();
            rhVar.d = parcel.readString();
            rhVar.g = parcel.readString();
            rhVar.h = parcel.readHashMap(rh.class.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return rhVar;
    }

    /* compiled from: Transaction.java */
    /* renamed from: rh$a */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<rh> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public rh createFromParcel(Parcel parcel) {
            return rh.a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public rh[] newArray(int i) {
            return new rh[i];
        }
    }
}
