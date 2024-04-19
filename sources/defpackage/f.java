package defpackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ActivityResult.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: f  reason: default package */
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    public final int a;
    public final Intent b;

    public f(int resultCode, Intent data) {
        this.a = resultCode;
        this.b = data;
    }

    public f(Parcel in) {
        this.a = in.readInt();
        this.b = in.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(in);
    }

    public int b() {
        return this.a;
    }

    public Intent a() {
        return this.b;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.a) + ", data=" + this.b + '}';
    }

    public static String c(int resultCode) {
        switch (resultCode) {
            case -1:
                return "RESULT_OK";
            case 0:
                return "RESULT_CANCELED";
            default:
                return String.valueOf(resultCode);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.a);
        dest.writeInt(this.b == null ? 0 : 1);
        Intent intent = this.b;
        if (intent != null) {
            intent.writeToParcel(dest, flags);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ActivityResult.java */
    /* renamed from: f$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<f> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel in) {
            return new f(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int size) {
            return new f[size];
        }
    }
}
