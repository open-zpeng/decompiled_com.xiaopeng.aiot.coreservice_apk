package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateService.java */
/* renamed from: io  reason: default package */
/* loaded from: classes.dex */
public class io implements ISystemDelegate {
    public Context a;

    public io(Context context) {
        this.a = context;
        Module.register(ho.class, new ho(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public String getCertificate() throws RemoteException {
        pn.a("SystemDelegateService", "start getCertificate!");
        Uri uri = Uri.parse("content://com.xiaopeng.system.delegate/cert/ssl");
        Cursor cursor = this.a.getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    String cert = cursor.getString(0);
                    pn.s("SystemDelegateService", "query result success");
                    cursor.close();
                    return cert;
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        pn.s("SystemDelegateService", "cursor is empty!");
        return null;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate
    public void setSystemProperty(String key, String value) throws RemoteException {
        pn.a("SystemDelegateService", "setSystemProperty " + key + ":" + value);
        Uri uri = Uri.parse("content://com.xiaopeng.system.delegate/sysprop/set");
        ContentValues values = new ContentValues();
        values.put(key, value);
        this.a.getContentResolver().update(uri, values, null, null);
    }
}
