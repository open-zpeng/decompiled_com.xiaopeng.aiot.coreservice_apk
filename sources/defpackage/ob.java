package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* renamed from: ob  reason: default package */
/* loaded from: classes.dex */
public abstract class ob implements Parcelable {
    public final Parcelable b;
    public static final ob a = new a();
    public static final Parcelable.Creator<ob> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: ob$a */
    /* loaded from: classes.dex */
    public static class a extends ob {
        public a() {
            super((a) null);
        }
    }

    public /* synthetic */ ob(a x0) {
        this();
    }

    public ob() {
        this.b = null;
    }

    public ob(Parcelable superState) {
        if (superState == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.b = superState != a ? superState : null;
    }

    public ob(Parcel source, ClassLoader loader) {
        Parcelable superState = source.readParcelable(loader);
        this.b = superState != null ? superState : a;
    }

    public final Parcelable a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.b, flags);
    }

    /* compiled from: AbsSavedState.java */
    /* renamed from: ob$b */
    /* loaded from: classes.dex */
    public static class b implements Parcelable.ClassLoaderCreator<ob> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public ob createFromParcel(Parcel in, ClassLoader loader) {
            Parcelable superState = in.readParcelable(loader);
            if (superState != null) {
                throw new IllegalStateException("superState must be null");
            }
            return ob.a;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ob createFromParcel(Parcel in) {
            return createFromParcel(in, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public ob[] newArray(int size) {
            return new ob[size];
        }
    }
}
