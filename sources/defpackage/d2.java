package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.TextView;
import defpackage.n9;
import defpackage.wa;
/* compiled from: AppCompatReceiveContentHelper.java */
/* renamed from: d2  reason: default package */
/* loaded from: classes.dex */
public final class d2 {
    public static boolean c(TextView view, int menuItemId) {
        int i = 0;
        if ((menuItemId != 16908322 && menuItemId != 16908337) || ga.y(view) == null) {
            return false;
        }
        ClipboardManager cm = (ClipboardManager) view.getContext().getSystemService("clipboard");
        ClipData clip = cm == null ? null : cm.getPrimaryClip();
        if (clip != null && clip.getItemCount() > 0) {
            n9.a aVar = new n9.a(clip, 1);
            if (menuItemId != 16908322) {
                i = 1;
            }
            n9 payload = aVar.c(i).a();
            ga.R(view, payload);
        }
        return true;
    }

    public static boolean b(View view, DragEvent event) {
        if (Build.VERSION.SDK_INT < 24 || event.getLocalState() != null || ga.y(view) == null) {
            return false;
        }
        Activity activity = d(view);
        if (activity == null) {
            Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + view);
            return false;
        } else if (event.getAction() == 1) {
            return !(view instanceof TextView);
        } else {
            if (event.getAction() == 3) {
                if (view instanceof TextView) {
                    return b.a(event, (TextView) view, activity);
                }
                return b.b(event, view, activity);
            }
            return false;
        }
    }

    /* compiled from: AppCompatReceiveContentHelper.java */
    /* renamed from: d2$b */
    /* loaded from: classes.dex */
    public static final class b {
        public static boolean a(DragEvent event, TextView view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            int offset = view.getOffsetForPosition(event.getX(), event.getY());
            view.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) view.getText(), offset);
                n9 payload = new n9.a(event.getClipData(), 3).a();
                ga.R(view, payload);
                view.endBatchEdit();
                return true;
            } catch (Throwable th) {
                view.endBatchEdit();
                throw th;
            }
        }

        public static boolean b(DragEvent event, View view, Activity activity) {
            activity.requestDragAndDropPermissions(event);
            n9 payload = new n9.a(event.getClipData(), 3).a();
            ga.R(view, payload);
            return true;
        }
    }

    public static Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* compiled from: AppCompatReceiveContentHelper.java */
    /* renamed from: d2$a */
    /* loaded from: classes.dex */
    public class a implements wa.c {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // defpackage.wa.c
        public boolean a(xa inputContentInfo, int flags, Bundle opts) {
            Bundle extras = opts;
            if (Build.VERSION.SDK_INT >= 25 && (flags & 1) != 0) {
                try {
                    inputContentInfo.d();
                    InputContentInfo inputContentInfoFmk = (InputContentInfo) inputContentInfo.e();
                    extras = opts == null ? new Bundle() : new Bundle(opts);
                    extras.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfoFmk);
                } catch (Exception e) {
                    Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                    return false;
                }
            }
            ClipData clip = new ClipData(inputContentInfo.b(), new ClipData.Item(inputContentInfo.a()));
            n9 payload = new n9.a(clip, 2).d(inputContentInfo.c()).b(extras).a();
            return ga.R(this.a, payload) == null;
        }
    }

    public static wa.c a(View view) {
        return new a(view);
    }
}
