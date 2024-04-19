package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* renamed from: mn  reason: default package */
/* loaded from: classes.dex */
public interface mn extends IInterface {
    void P(List<String> list) throws RemoteException;

    void R(String str) throws RemoteException;

    void f(String str, String str2) throws RemoteException;

    void h(String str) throws RemoteException;

    void k(String str, String str2) throws RemoteException;

    void s(String str) throws RemoteException;

    /* compiled from: IDataUploadInterface.java */
    /* renamed from: mn$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements mn {
        public static mn W(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (iin != null && (iin instanceof mn)) {
                return (mn) iin;
            }
            return new C0018a(obj);
        }

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: mn$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0018a implements mn {
            public IBinder a;

            public C0018a(IBinder remote) {
                this.a = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // defpackage.mn
            public void s(String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeString(data);
                    this.a.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // defpackage.mn
            public void f(String eventName, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeString(eventName);
                    _data.writeString(data);
                    this.a.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // defpackage.mn
            public void h(String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeString(data);
                    this.a.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // defpackage.mn
            public void k(String eventName, String data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeString(eventName);
                    _data.writeString(data);
                    this.a.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // defpackage.mn
            public void P(List<String> filePaths) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeStringList(filePaths);
                    this.a.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // defpackage.mn
            public void R(String ossUrl) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    _data.writeString(ossUrl);
                    this.a.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
