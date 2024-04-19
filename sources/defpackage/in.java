package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPCCallback.java */
/* renamed from: in  reason: default package */
/* loaded from: classes.dex */
public interface in extends IInterface {
    void onReceive(jn jnVar) throws RemoteException;

    /* compiled from: IPCCallback.java */
    /* renamed from: in$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements in {
        private static final String DESCRIPTOR = "com.xiaopeng.ipc.IPCCallback";
        public static final int TRANSACTION_onReceive = 1;

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static in asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof in)) {
                return (in) iin;
            }
            return new C0017a(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            jn _arg0;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = jn.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    onReceive(_arg0);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* compiled from: IPCCallback.java */
        /* renamed from: in$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0017a implements in {
            public IBinder a;

            public C0017a(IBinder remote) {
                this.a = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }
    }
}
