package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;
/* compiled from: IMonitor.java */
/* renamed from: oh  reason: default package */
/* loaded from: classes.dex */
public interface oh extends IInterface {
    void A(String str) throws RemoteException;

    void B(String str, String str2, double d, Map map) throws RemoteException;

    void C(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void D(String str, String str2, String str3, String str4, Map map) throws RemoteException;

    void E(String str, String str2, double d, Map map) throws RemoteException;

    void F(String str, String str2, String str3, double d, Map map) throws RemoteException;

    void G(int i) throws RemoteException;

    void H(Map map) throws RemoteException;

    void I(int i, int i2) throws RemoteException;

    void L(int i) throws RemoteException;

    void M(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map map) throws RemoteException;

    void N(int i) throws RemoteException;

    void O(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void Q(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException;

    void S(int i) throws RemoteException;

    void T() throws RemoteException;

    boolean U(String str, String str2) throws RemoteException;

    void V(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void a(String str, String str2, double d) throws RemoteException;

    void b(int i) throws RemoteException;

    void c(int i) throws RemoteException;

    boolean d(String str, String str2) throws RemoteException;

    void destroy() throws RemoteException;

    void e(int i) throws RemoteException;

    void g(String str, String str2, String str3, Map map) throws RemoteException;

    void i(boolean z) throws RemoteException;

    void init() throws RemoteException;

    void j(rh rhVar, String str) throws RemoteException;

    void l(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void n(String str, String str2, String str3) throws RemoteException;

    boolean o(String str, String str2) throws RemoteException;

    void p(String str, String str2, Map map) throws RemoteException;

    boolean q(String str, String str2) throws RemoteException;

    void r(rh rhVar, String str) throws RemoteException;

    void t(String str, String str2, String str3) throws RemoteException;

    void u(int i) throws RemoteException;

    void v(int i) throws RemoteException;

    void w(boolean z, String str, String str2, String str3) throws RemoteException;

    void x() throws RemoteException;

    void y(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException;

    void z(int i) throws RemoteException;

    /* compiled from: IMonitor.java */
    /* renamed from: oh$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements oh {
        public a() {
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        public static oh W(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof oh)) {
                return (oh) queryLocalInterface;
            }
            return new C0020a(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            MeasureSet measureSet;
            MeasureSet measureSet2;
            DimensionSet dimensionSet;
            DimensionValueSet dimensionValueSet;
            DimensionValueSet dimensionValueSet2;
            MeasureValueSet measureValueSet;
            switch (code) {
                case 1:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    init();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    i(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    w(data.readInt() != 0, data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    A(data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    x();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    c(data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    N(data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    I(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    C(data.readString(), data.readString(), data.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    V(data.readString(), data.readString(), data.readInt() != 0 ? MeasureSet.CREATOR.createFromParcel(data) : null, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        measureSet = MeasureSet.CREATOR.createFromParcel(data);
                    } else {
                        measureSet = null;
                    }
                    O(readString, readString2, measureSet, data.readInt() != 0 ? DimensionSet.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    String readString3 = data.readString();
                    String readString4 = data.readString();
                    if (data.readInt() != 0) {
                        measureSet2 = MeasureSet.CREATOR.createFromParcel(data);
                    } else {
                        measureSet2 = null;
                    }
                    if (data.readInt() != 0) {
                        dimensionSet = DimensionSet.CREATOR.createFromParcel(data);
                    } else {
                        dimensionSet = null;
                    }
                    l(readString3, readString4, measureSet2, dimensionSet, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    H(data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    T();
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    b(data.readInt());
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    S(data.readInt());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean d = d(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(d ? 1 : 0);
                    return true;
                case 19:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    E(data.readString(), data.readString(), data.readDouble(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    F(data.readString(), data.readString(), data.readString(), data.readDouble(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    u(data.readInt());
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    G(data.readInt());
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean U = U(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(U ? 1 : 0);
                    return true;
                case 24:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    a(data.readString(), data.readString(), data.readDouble());
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    e(data.readInt());
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    L(data.readInt());
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean o = o(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(o ? 1 : 0);
                    return true;
                case 28:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    p(data.readString(), data.readString(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    g(data.readString(), data.readString(), data.readString(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    D(data.readString(), data.readString(), data.readString(), data.readString(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    Q(data.readString(), data.readString(), data.readString(), data.readString(), data.readString(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    n(data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    t(data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    v(data.readInt());
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    z(data.readInt());
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    boolean q = q(data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(q ? 1 : 0);
                    return true;
                case 37:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    B(data.readString(), data.readString(), data.readDouble(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    String readString5 = data.readString();
                    String readString6 = data.readString();
                    if (data.readInt() != 0) {
                        dimensionValueSet = DimensionValueSet.CREATOR.createFromParcel(data);
                    } else {
                        dimensionValueSet = null;
                    }
                    M(readString5, readString6, dimensionValueSet, data.readDouble(), data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    String readString7 = data.readString();
                    String readString8 = data.readString();
                    if (data.readInt() != 0) {
                        dimensionValueSet2 = DimensionValueSet.CREATOR.createFromParcel(data);
                    } else {
                        dimensionValueSet2 = null;
                    }
                    if (data.readInt() != 0) {
                        measureValueSet = MeasureValueSet.CREATOR.createFromParcel(data);
                    } else {
                        measureValueSet = null;
                    }
                    y(readString7, readString8, dimensionValueSet2, measureValueSet, data.readHashMap(getClass().getClassLoader()));
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    r(data.readInt() != 0 ? rh.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.alibaba.mtl.appmonitor.IMonitor");
                    j(data.readInt() != 0 ? rh.CREATOR.createFromParcel(data) : null, data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.alibaba.mtl.appmonitor.IMonitor");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* compiled from: IMonitor.java */
        /* renamed from: oh$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0020a implements oh {
            public IBinder a;

            public C0020a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.oh
            public void init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void w(boolean isSecurity, String appkey, String secret, String authcode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(isSecurity ? 1 : 0);
                    obtain.writeString(appkey);
                    obtain.writeString(secret);
                    obtain.writeString(authcode);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void A(String channel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(channel);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void x() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void l(String module, String monitorPoint, MeasureSet measures, DimensionSet dimensions, boolean isCommitDetail) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(module);
                    obtain.writeString(monitorPoint);
                    int i = 1;
                    if (measures != null) {
                        obtain.writeInt(1);
                        measures.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensions != null) {
                        obtain.writeInt(1);
                        dimensions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!isCommitDetail) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void H(Map params) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeMap(params);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // defpackage.oh
            public void T() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
