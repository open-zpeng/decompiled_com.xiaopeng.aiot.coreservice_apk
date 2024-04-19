package defpackage;

import android.content.Context;
import com.xiaopeng.lib.framework.module.IModuleEntry;
import com.xiaopeng.lib.framework.moduleinterface.systemdelegate.ISystemDelegate;
/* compiled from: SystemDelegateModuleEntry.java */
/* renamed from: ho  reason: default package */
/* loaded from: classes.dex */
public class ho implements IModuleEntry {
    public volatile ISystemDelegate a;
    public Context b;

    public ho(Context context) {
        this.b = context;
    }

    @Override // com.xiaopeng.lib.framework.module.IModuleEntry
    public Object get(Class interfaceClass) {
        if (interfaceClass == ISystemDelegate.class) {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = new io(this.b);
                    }
                }
            }
            return this.a;
        }
        return null;
    }
}
