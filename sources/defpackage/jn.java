package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: IpcMessage.java */
/* renamed from: jn  reason: default package */
/* loaded from: classes.dex */
public class jn implements Parcelable {
    public static final Parcelable.Creator<jn> CREATOR = new a();
    public String a;
    public int b;
    public Bundle d;

    public jn() {
    }

    public jn(Parcel in) {
        this.a = in.readString();
        this.b = in.readInt();
        this.d = in.readBundle();
    }

    /* compiled from: IpcMessage.java */
    /* renamed from: jn$a */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<jn> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public jn createFromParcel(Parcel in) {
            return new jn(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public jn[] newArray(int size) {
            return new jn[size];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.a);
        dest.writeInt(this.b);
        dest.writeBundle(this.d);
    }

    public String b() {
        return this.a;
    }

    public void e(String packageName) {
        this.a = packageName;
    }

    public int a() {
        return this.b;
    }

    public void d(int msgId) {
        this.b = msgId;
    }

    public Bundle c() {
        return this.d;
    }

    public void f(Bundle payloadData) {
        this.d = payloadData;
    }
}
