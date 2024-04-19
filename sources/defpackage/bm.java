package defpackage;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.mmkv.MMKV;
import java.io.IOException;
/* compiled from: ParcelableMMKV.java */
/* renamed from: bm  reason: default package */
/* loaded from: classes.dex */
public final class bm implements Parcelable {
    public static final Parcelable.Creator<bm> CREATOR = new a();
    public final String a;
    public int b;
    public int d;
    public String f;

    public /* synthetic */ bm(String x0, int x1, int x2, String x3, a x4) {
        this(x0, x1, x2, x3);
    }

    public bm(MMKV mmkv) {
        this.b = -1;
        this.d = -1;
        this.f = null;
        this.a = mmkv.mmapID();
        this.b = mmkv.ashmemFD();
        this.d = mmkv.ashmemMetaFD();
        this.f = mmkv.cryptKey();
    }

    public bm(String id, int fd, int metaFD, String key) {
        this.b = -1;
        this.d = -1;
        this.f = null;
        this.a = id;
        this.b = fd;
        this.d = metaFD;
        this.f = key;
    }

    public MMKV a() {
        int i;
        int i2 = this.b;
        if (i2 >= 0 && (i = this.d) >= 0) {
            return MMKV.u(this.a, i2, i, this.f);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeString(this.a);
            ParcelFileDescriptor fd = ParcelFileDescriptor.fromFd(this.b);
            ParcelFileDescriptor metaFD = ParcelFileDescriptor.fromFd(this.d);
            int flags2 = flags | 1;
            fd.writeToParcel(dest, flags2);
            metaFD.writeToParcel(dest, flags2);
            String str = this.f;
            if (str != null) {
                dest.writeString(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* compiled from: ParcelableMMKV.java */
    /* renamed from: bm$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<bm> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public bm createFromParcel(Parcel source) {
            String mmapID = source.readString();
            ParcelFileDescriptor fd = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            ParcelFileDescriptor metaFD = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            String cryptKey = source.readString();
            if (fd != null && metaFD != null) {
                return new bm(mmapID, fd.detachFd(), metaFD.detachFd(), cryptKey, null);
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public bm[] newArray(int size) {
            return new bm[size];
        }
    }
}
