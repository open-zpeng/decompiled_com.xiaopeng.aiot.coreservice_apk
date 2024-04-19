package defpackage;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.cd;
import defpackage.mc;
import java.util.ArrayList;
/* compiled from: BackStackState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: ub  reason: default package */
/* loaded from: classes.dex */
public final class ub implements Parcelable {
    public static final Parcelable.Creator<ub> CREATOR = new a();
    public final int[] a;
    public final ArrayList<String> b;
    public final int[] d;
    public final int[] f;
    public final int g;
    public final String h;
    public final int i;
    public final int j;
    public final CharSequence k;
    public final int l;
    public final CharSequence m;
    public final ArrayList<String> n;
    public final ArrayList<String> o;
    public final boolean p;

    public ub(tb bse) {
        int numOps = bse.c.size();
        this.a = new int[numOps * 5];
        if (!bse.i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList<>(numOps);
        this.d = new int[numOps];
        this.f = new int[numOps];
        int pos = 0;
        int opNum = 0;
        while (opNum < numOps) {
            mc.a op = bse.c.get(opNum);
            int pos2 = pos + 1;
            this.a[pos] = op.a;
            ArrayList<String> arrayList = this.b;
            Fragment fragment = op.b;
            arrayList.add(fragment != null ? fragment.i : null);
            int[] iArr = this.a;
            int pos3 = pos2 + 1;
            iArr[pos2] = op.c;
            int pos4 = pos3 + 1;
            iArr[pos3] = op.d;
            int pos5 = pos4 + 1;
            iArr[pos4] = op.e;
            iArr[pos5] = op.f;
            this.d[opNum] = op.g.ordinal();
            this.f[opNum] = op.h.ordinal();
            opNum++;
            pos = pos5 + 1;
        }
        int opNum2 = bse.h;
        this.g = opNum2;
        this.h = bse.k;
        this.i = bse.v;
        this.j = bse.l;
        this.k = bse.m;
        this.l = bse.n;
        this.m = bse.o;
        this.n = bse.p;
        this.o = bse.q;
        this.p = bse.r;
    }

    public ub(Parcel in) {
        this.a = in.createIntArray();
        this.b = in.createStringArrayList();
        this.d = in.createIntArray();
        this.f = in.createIntArray();
        this.g = in.readInt();
        this.h = in.readString();
        this.i = in.readInt();
        this.j = in.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.l = in.readInt();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.n = in.createStringArrayList();
        this.o = in.createStringArrayList();
        this.p = in.readInt() != 0;
    }

    public tb a(dc fm) {
        tb bse = new tb(fm);
        int pos = 0;
        int num = 0;
        while (pos < this.a.length) {
            mc.a op = new mc.a();
            int pos2 = pos + 1;
            op.a = this.a[pos];
            if (dc.F0(2)) {
                Log.v("FragmentManager", "Instantiate " + bse + " op #" + num + " base fragment #" + this.a[pos2]);
            }
            String fWho = this.b.get(num);
            if (fWho != null) {
                Fragment f = fm.g0(fWho);
                op.b = f;
            } else {
                op.b = null;
            }
            op.g = cd.c.values()[this.d[num]];
            op.h = cd.c.values()[this.f[num]];
            int[] iArr = this.a;
            int pos3 = pos2 + 1;
            int pos4 = iArr[pos2];
            op.c = pos4;
            int pos5 = pos3 + 1;
            int pos6 = iArr[pos3];
            op.d = pos6;
            int pos7 = pos5 + 1;
            int pos8 = iArr[pos5];
            op.e = pos8;
            int i = iArr[pos7];
            op.f = i;
            bse.d = pos4;
            bse.e = pos6;
            bse.f = pos8;
            bse.g = i;
            bse.d(op);
            num++;
            pos = pos7 + 1;
        }
        bse.h = this.g;
        bse.k = this.h;
        bse.v = this.i;
        bse.i = true;
        bse.l = this.j;
        bse.m = this.k;
        bse.n = this.l;
        bse.o = this.m;
        bse.p = this.n;
        bse.q = this.o;
        bse.r = this.p;
        bse.l(1);
        return bse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.a);
        dest.writeStringList(this.b);
        dest.writeIntArray(this.d);
        dest.writeIntArray(this.f);
        dest.writeInt(this.g);
        dest.writeString(this.h);
        dest.writeInt(this.i);
        dest.writeInt(this.j);
        TextUtils.writeToParcel(this.k, dest, 0);
        dest.writeInt(this.l);
        TextUtils.writeToParcel(this.m, dest, 0);
        dest.writeStringList(this.n);
        dest.writeStringList(this.o);
        dest.writeInt(this.p ? 1 : 0);
    }

    /* compiled from: BackStackState.java */
    /* renamed from: ub$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<ub> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ub createFromParcel(Parcel in) {
            return new ub(in);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ub[] newArray(int size) {
            return new ub[size];
        }
    }
}
