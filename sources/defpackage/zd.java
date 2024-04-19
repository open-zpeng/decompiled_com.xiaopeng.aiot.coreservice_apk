package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* renamed from: zd  reason: default package */
/* loaded from: classes.dex */
public final class zd {
    public static final Object a = new Object();
    public static zd b;
    public final Context c;
    public final HashMap<BroadcastReceiver, ArrayList<c>> d = new HashMap<>();
    public final HashMap<String, ArrayList<c>> e = new HashMap<>();
    public final ArrayList<b> f = new ArrayList<>();
    public final Handler g;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: zd$c */
    /* loaded from: classes.dex */
    public static final class c {
        public final IntentFilter a;
        public final BroadcastReceiver b;
        public boolean c;
        public boolean d;

        public c(IntentFilter _filter, BroadcastReceiver _receiver) {
            this.a = _filter;
            this.b = _receiver;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder(128);
            builder.append("Receiver{");
            builder.append(this.b);
            builder.append(" filter=");
            builder.append(this.a);
            if (this.d) {
                builder.append(" DEAD");
            }
            builder.append("}");
            return builder.toString();
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: zd$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final Intent a;
        public final ArrayList<c> b;

        public b(Intent _intent, ArrayList<c> arrayList) {
            this.a = _intent;
            this.b = arrayList;
        }
    }

    public static zd b(Context context) {
        zd zdVar;
        synchronized (a) {
            if (b == null) {
                b = new zd(context.getApplicationContext());
            }
            zdVar = b;
        }
        return zdVar;
    }

    public zd(Context context) {
        this.c = context;
        this.g = new a(context.getMainLooper());
    }

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: zd$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper x0) {
            super(x0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zd.this.a();
                    return;
                default:
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    public void c(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (this.d) {
            c entry = new c(filter, receiver);
            ArrayList<c> arrayList = this.d.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.d.put(receiver, arrayList);
            }
            arrayList.add(entry);
            for (int i = 0; i < filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(entry);
            }
        }
    }

    public void e(BroadcastReceiver receiver) {
        synchronized (this.d) {
            ArrayList<c> remove = this.d.remove(receiver);
            if (remove == null) {
                return;
            }
            for (int i = remove.size() - 1; i >= 0; i--) {
                c filter = remove.get(i);
                filter.d = true;
                for (int j = 0; j < filter.a.countActions(); j++) {
                    String action = filter.a.getAction(j);
                    ArrayList<c> arrayList = this.e.get(action);
                    if (arrayList != null) {
                        for (int k = arrayList.size() - 1; k >= 0; k--) {
                            c rec = arrayList.get(k);
                            if (rec.b == receiver) {
                                rec.d = true;
                                arrayList.remove(k);
                            }
                        }
                        int k2 = arrayList.size();
                        if (k2 <= 0) {
                            this.e.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean d(Intent intent) {
        int i;
        String type;
        ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
        String reason;
        synchronized (this.d) {
            String action = intent.getAction();
            String type2 = intent.resolveTypeIfNeeded(this.c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean debug = (intent.getFlags() & 8) != 0;
            if (debug) {
                Log.v("LocalBroadcastManager", "Resolving type " + type2 + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList = this.e.get(intent.getAction());
            if (arrayList != null) {
                if (debug) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                }
                ArrayList<LocalBroadcastManager.ReceiverRecord> receivers2 = null;
                int i2 = 0;
                while (i2 < arrayList.size()) {
                    c receiver = arrayList.get(i2);
                    if (debug) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiver.a);
                    }
                    if (receiver.c) {
                        if (!debug) {
                            type = type2;
                            i = i2;
                            receivers = receivers2;
                        } else {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            type = type2;
                            i = i2;
                            receivers = receivers2;
                        }
                    } else {
                        String str = type2;
                        i = i2;
                        type = type2;
                        receivers = receivers2;
                        int match = receiver.a.match(action, str, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (debug) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            if (receivers != null) {
                                receivers2 = receivers;
                            } else {
                                receivers2 = new ArrayList<>();
                            }
                            receivers2.add(receiver);
                            receiver.c = true;
                            i2 = i + 1;
                            type2 = type;
                        } else if (debug) {
                            switch (match) {
                                case -4:
                                    reason = "category";
                                    break;
                                case -3:
                                    reason = "action";
                                    break;
                                case -2:
                                    reason = "data";
                                    break;
                                case -1:
                                    reason = "type";
                                    break;
                                default:
                                    reason = "unknown reason";
                                    break;
                            }
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + reason);
                        }
                    }
                    receivers2 = receivers;
                    i2 = i + 1;
                    type2 = type;
                }
                ArrayList<LocalBroadcastManager.ReceiverRecord> receivers3 = receivers2;
                if (receivers3 != null) {
                    for (int i3 = 0; i3 < receivers3.size(); i3++) {
                        ((c) receivers3.get(i3)).c = false;
                    }
                    this.f.add(new b(intent, receivers3));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0049 -> B:24:0x0047). Please submit an issue!!! */
    public void a() {
        b[] brs;
        while (true) {
            synchronized (this.d) {
                try {
                    int N = this.f.size();
                    if (N <= 0) {
                        return;
                    }
                    brs = new b[N];
                    try {
                        this.f.toArray(brs);
                        this.f.clear();
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            for (b br : brs) {
                int nbr = br.b.size();
                for (int j = 0; j < nbr; j++) {
                    c rec = br.b.get(j);
                    if (!rec.d) {
                        rec.b.onReceive(this.c, br.a);
                    }
                }
            }
        }
    }
}
