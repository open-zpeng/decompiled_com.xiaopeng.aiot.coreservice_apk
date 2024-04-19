package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ParcelableMqttMessage.java */
/* renamed from: tv  reason: default package */
/* loaded from: classes.dex */
public class tv extends jw implements Parcelable {
    public static final Parcelable.Creator<tv> CREATOR = new a();
    public String i;

    public tv(jw original) {
        super(original.b());
        this.i = null;
        i(original.c());
        j(original.e());
        f(original.d());
    }

    public tv(Parcel parcel) {
        super(parcel.createByteArray());
        this.i = null;
        i(parcel.readInt());
        boolean[] flags = parcel.createBooleanArray();
        j(flags[0]);
        f(flags[1]);
        this.i = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeByteArray(b());
        parcel.writeInt(c());
        parcel.writeBooleanArray(new boolean[]{e(), d()});
        parcel.writeString(this.i);
    }

    /* compiled from: ParcelableMqttMessage.java */
    /* renamed from: tv$a */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<tv> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public tv createFromParcel(Parcel parcel) {
            return new tv(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public tv[] newArray(int size) {
            return new tv[size];
        }
    }
}
