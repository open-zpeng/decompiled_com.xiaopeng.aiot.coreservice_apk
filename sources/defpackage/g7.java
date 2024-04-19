package defpackage;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import defpackage.f7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: NotificationCompatBuilder.java */
/* renamed from: g7  reason: default package */
/* loaded from: classes.dex */
public class g7 implements e7 {
    public final Context a;
    public final Notification.Builder b;
    public final f7.c c;
    public RemoteViews d;
    public RemoteViews e;
    public final List<Bundle> f = new ArrayList();
    public final Bundle g = new Bundle();
    public int h;
    public RemoteViews i;

    public g7(f7.c b) {
        Icon icon;
        List<String> people;
        List<String> people2;
        this.c = b;
        Context context = b.a;
        this.a = context;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.b = new Notification.Builder(context, b.K);
        } else {
            this.b = new Notification.Builder(context);
        }
        Notification n = b.S;
        this.b.setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, b.i).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS).setOngoing((n.flags & 2) != 0).setOnlyAlertOnce((n.flags & 8) != 0).setAutoCancel((n.flags & 16) != 0).setDefaults(n.defaults).setContentTitle(b.e).setContentText(b.f).setContentInfo(b.k).setContentIntent(b.g).setDeleteIntent(n.deleteIntent).setFullScreenIntent(b.h, (n.flags & 128) != 0).setLargeIcon(b.j).setNumber(b.l).setProgress(b.t, b.u, b.v);
        if (i < 21) {
            this.b.setSound(n.sound, n.audioStreamType);
        }
        if (i >= 16) {
            this.b.setSubText(b.q).setUsesChronometer(b.o).setPriority(b.m);
            Iterator<f7.a> it = b.b.iterator();
            while (it.hasNext()) {
                f7.a action = it.next();
                a(action);
            }
            Bundle bundle = b.D;
            if (bundle != null) {
                this.g.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (b.z) {
                    this.g.putBoolean("android.support.localOnly", true);
                }
                String str = b.w;
                if (str != null) {
                    this.g.putString("android.support.groupKey", str);
                    if (b.x) {
                        this.g.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.g.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = b.y;
                if (str2 != null) {
                    this.g.putString("android.support.sortKey", str2);
                }
            }
            this.d = b.H;
            this.e = b.I;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            this.b.setShowWhen(b.n);
        }
        if (i2 >= 19 && i2 < 21 && (people2 = d(e(b.c), b.V)) != null && !people2.isEmpty()) {
            this.g.putStringArray("android.people", (String[]) people2.toArray(new String[people2.size()]));
        }
        if (i2 >= 20) {
            this.b.setLocalOnly(b.z).setGroup(b.w).setGroupSummary(b.x).setSortKey(b.y);
            this.h = b.P;
        }
        if (i2 >= 21) {
            this.b.setCategory(b.C).setColor(b.E).setVisibility(b.F).setPublicVersion(b.G).setSound(n.sound, n.audioAttributes);
            if (i2 < 28) {
                people = d(e(b.c), b.V);
            } else {
                people = b.V;
            }
            if (people != null && !people.isEmpty()) {
                for (String person : people) {
                    this.b.addPerson(person);
                }
            }
            this.i = b.J;
            if (b.d.size() > 0) {
                Bundle carExtenderBundle = b.b().getBundle("android.car.EXTENSIONS");
                carExtenderBundle = carExtenderBundle == null ? new Bundle() : carExtenderBundle;
                Bundle extenderBundleCopy = new Bundle(carExtenderBundle);
                Bundle listBundle = new Bundle();
                for (int i3 = 0; i3 < b.d.size(); i3++) {
                    listBundle.putBundle(Integer.toString(i3), h7.b(b.d.get(i3)));
                }
                carExtenderBundle.putBundle("invisible_actions", listBundle);
                extenderBundleCopy.putBundle("invisible_actions", listBundle);
                b.b().putBundle("android.car.EXTENSIONS", carExtenderBundle);
                this.g.putBundle("android.car.EXTENSIONS", extenderBundleCopy);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23 && (icon = b.U) != null) {
            this.b.setSmallIcon(icon);
        }
        if (i4 >= 24) {
            this.b.setExtras(b.D).setRemoteInputHistory(b.s);
            RemoteViews remoteViews = b.H;
            if (remoteViews != null) {
                this.b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = b.I;
            if (remoteViews2 != null) {
                this.b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = b.J;
            if (remoteViews3 != null) {
                this.b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i4 >= 26) {
            this.b.setBadgeIconType(b.L).setSettingsText(b.r).setShortcutId(b.M).setTimeoutAfter(b.O).setGroupAlertBehavior(b.P);
            if (b.B) {
                this.b.setColorized(b.A);
            }
            if (!TextUtils.isEmpty(b.K)) {
                this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i4 >= 28) {
            Iterator<i7> it2 = b.c.iterator();
            while (it2.hasNext()) {
                i7 p = it2.next();
                this.b.addPerson(p.h());
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(b.Q);
            this.b.setBubbleMetadata(f7.b.i(b.R));
            n7 n7Var = b.N;
            if (n7Var != null) {
                n7Var.a();
                throw null;
            }
        }
        if (b.T) {
            if (this.c.x) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate(null);
            this.b.setSound(null);
            int i6 = n.defaults & (-2);
            n.defaults = i6;
            int i7 = i6 & (-3);
            n.defaults = i7;
            this.b.setDefaults(i7);
            if (i5 >= 26) {
                if (TextUtils.isEmpty(this.c.w)) {
                    this.b.setGroup("silent");
                }
                this.b.setGroupAlertBehavior(this.h);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: u3 != androidx.collection.ArraySet<java.lang.String> */
    public static List<String> d(List<String> first, List<String> second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        u3 u3Var = new u3(first.size() + second.size());
        u3Var.addAll(first);
        u3Var.addAll(second);
        return new ArrayList(u3Var);
    }

    public static List<String> e(List<i7> list) {
        if (list == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>(list.size());
        for (i7 person : list) {
            result.add(person.g());
        }
        return result;
    }

    public Notification b() {
        RemoteViews styleContentView;
        Bundle extras;
        RemoteViews styleBigContentView;
        f7.d style = this.c.p;
        if (style != null) {
            style.b(this);
        }
        if (style != null) {
            styleContentView = style.d(this);
        } else {
            styleContentView = null;
        }
        Notification n = c();
        if (styleContentView != null) {
            n.contentView = styleContentView;
        } else {
            RemoteViews remoteViews = this.c.H;
            if (remoteViews != null) {
                n.contentView = remoteViews;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && style != null && (styleBigContentView = style.c(this)) != null) {
            n.bigContentView = styleBigContentView;
        }
        if (i >= 21 && style != null) {
            this.c.p.e(this);
            throw null;
        }
        if (i >= 16 && style != null && (extras = f7.a(n)) != null) {
            style.a(extras);
        }
        return n;
    }

    public final void a(f7.a action) {
        Notification.Action.Builder actionBuilder;
        Bundle actionExtras;
        RemoteInput[] b;
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            IconCompat iconCompat = action.e();
            if (i >= 23) {
                actionBuilder = new Notification.Action.Builder(iconCompat != null ? iconCompat.l() : null, action.i(), action.a());
            } else {
                actionBuilder = new Notification.Action.Builder(iconCompat != null ? iconCompat.c() : 0, action.i(), action.a());
            }
            if (action.f() != null) {
                for (RemoteInput remoteInput : j7.b(action.f())) {
                    actionBuilder.addRemoteInput(remoteInput);
                }
            }
            if (action.d() != null) {
                actionExtras = new Bundle(action.d());
            } else {
                actionExtras = new Bundle();
            }
            actionExtras.putBoolean("android.support.allowGeneratedReplies", action.b());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                actionBuilder.setAllowGeneratedReplies(action.b());
            }
            actionExtras.putInt("android.support.action.semanticAction", action.g());
            if (i2 >= 28) {
                actionBuilder.setSemanticAction(action.g());
            }
            if (i2 >= 29) {
                actionBuilder.setContextual(action.j());
            }
            actionExtras.putBoolean("android.support.action.showsUserInterface", action.h());
            actionBuilder.addExtras(actionExtras);
            this.b.addAction(actionBuilder.build());
        } else if (i >= 16) {
            this.f.add(h7.f(this.b, action));
        }
    }

    public Notification c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.b.build();
        }
        if (i >= 24) {
            Notification notification = this.b.build();
            if (this.h != 0) {
                if (notification.getGroup() != null && (notification.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.h == 2) {
                    f(notification);
                }
                if (notification.getGroup() != null && (notification.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.h == 1) {
                    f(notification);
                }
            }
            return notification;
        } else if (i >= 21) {
            this.b.setExtras(this.g);
            Notification notification2 = this.b.build();
            RemoteViews remoteViews = this.d;
            if (remoteViews != null) {
                notification2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                notification2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.i;
            if (remoteViews3 != null) {
                notification2.headsUpContentView = remoteViews3;
            }
            if (this.h != 0) {
                if (notification2.getGroup() != null && (notification2.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.h == 2) {
                    f(notification2);
                }
                if (notification2.getGroup() != null && (notification2.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.h == 1) {
                    f(notification2);
                }
            }
            return notification2;
        } else if (i >= 20) {
            this.b.setExtras(this.g);
            Notification notification3 = this.b.build();
            RemoteViews remoteViews4 = this.d;
            if (remoteViews4 != null) {
                notification3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.e;
            if (remoteViews5 != null) {
                notification3.bigContentView = remoteViews5;
            }
            if (this.h != 0) {
                if (notification3.getGroup() != null && (notification3.flags & IInputController.KEYCODE_BACK_BUTTON) != 0 && this.h == 2) {
                    f(notification3);
                }
                if (notification3.getGroup() != null && (notification3.flags & IInputController.KEYCODE_BACK_BUTTON) == 0 && this.h == 1) {
                    f(notification3);
                }
            }
            return notification3;
        } else if (i >= 19) {
            SparseArray<Bundle> actionExtrasMap = h7.a(this.f);
            if (actionExtrasMap != null) {
                this.g.putSparseParcelableArray("android.support.actionExtras", actionExtrasMap);
            }
            this.b.setExtras(this.g);
            Notification notification4 = this.b.build();
            RemoteViews remoteViews6 = this.d;
            if (remoteViews6 != null) {
                notification4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.e;
            if (remoteViews7 != null) {
                notification4.bigContentView = remoteViews7;
            }
            return notification4;
        } else if (i >= 16) {
            Notification notification5 = this.b.build();
            Bundle extras = f7.a(notification5);
            Bundle mergeBundle = new Bundle(this.g);
            for (String key : this.g.keySet()) {
                if (extras.containsKey(key)) {
                    mergeBundle.remove(key);
                }
            }
            extras.putAll(mergeBundle);
            SparseArray<Bundle> actionExtrasMap2 = h7.a(this.f);
            if (actionExtrasMap2 != null) {
                f7.a(notification5).putSparseParcelableArray("android.support.actionExtras", actionExtrasMap2);
            }
            RemoteViews remoteViews8 = this.d;
            if (remoteViews8 != null) {
                notification5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.e;
            if (remoteViews9 != null) {
                notification5.bigContentView = remoteViews9;
            }
            return notification5;
        } else {
            return this.b.getNotification();
        }
    }

    public final void f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }
}
