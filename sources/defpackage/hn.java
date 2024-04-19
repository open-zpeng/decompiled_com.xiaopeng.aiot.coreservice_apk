package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IPC.java */
/* renamed from: hn  reason: default package */
/* loaded from: classes.dex */
public interface hn extends IInterface {
    void J(String str, jn jnVar) throws RemoteException;

    void K(String str, in inVar) throws RemoteException;

    void m(String str, in inVar) throws RemoteException;

    /* compiled from: IPC.java */
    /* renamed from: hn$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements hn {
        public static hn W(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.xiaopeng.ipc.IPC");
            if (iin != null && (iin instanceof hn)) {
                return (hn) iin;
            }
            return new C0016a(obj);
        }

        /* compiled from: IPC.java */
        /* renamed from: hn$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0016a implements hn {
            public IBinder a;

            public C0016a(IBinder remote) {
                this.a = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.hn
            public void K(String appId, in client) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    _data.writeString(appId);
                    _data.writeStrongBinder(client != null ? client.asBinder() : null);
                    this.a.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // defpackage.hn
            public void m(String appId, in client) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    _data.writeString(appId);
                    _data.writeStrongBinder(client != null ? client.asBinder() : null);
                    this.a.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // defpackage.hn
            public void J(String appId, jn payloadData) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.ipc.IPC");
                    _data.writeString(appId);
                    if (payloadData != null) {
                        _data.writeInt(1);
                        payloadData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.a.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
