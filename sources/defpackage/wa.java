package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputConnectionCompat.java */
/* renamed from: wa  reason: default package */
/* loaded from: classes.dex */
public final class wa {

    /* compiled from: InputConnectionCompat.java */
    /* renamed from: wa$c */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(xa xaVar, int i, Bundle bundle);
    }

    public static boolean b(String action, Bundle data, c onCommitContentListener) {
        boolean interop;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (data == null) {
            return false;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
            interop = false;
        } else if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
            return false;
        } else {
            interop = true;
        }
        ResultReceiver resultReceiver = null;
        boolean result = false;
        if (interop) {
            str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        } else {
            str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        }
        try {
            resultReceiver = (ResultReceiver) data.getParcelable(str);
            if (interop) {
                str2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            } else {
                str2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            }
            Uri contentUri = (Uri) data.getParcelable(str2);
            if (interop) {
                str3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            } else {
                str3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            }
            ClipDescription description = (ClipDescription) data.getParcelable(str3);
            if (interop) {
                str4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            } else {
                str4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            }
            Uri linkUri = (Uri) data.getParcelable(str4);
            if (interop) {
                str5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            } else {
                str5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            }
            int flags = data.getInt(str5);
            if (interop) {
                str6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            } else {
                str6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            }
            Bundle opts = (Bundle) data.getParcelable(str6);
            if (contentUri != null && description != null) {
                xa inputContentInfo = new xa(contentUri, description, linkUri);
                result = onCommitContentListener.a(inputContentInfo, flags, opts);
            }
            if (resultReceiver != null) {
                resultReceiver.send(result ? 1 : 0, null);
            }
            return result;
        } catch (Throwable th) {
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
            throw th;
        }
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, c onCommitContentListener) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        }
        if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        if (onCommitContentListener == null) {
            throw new IllegalArgumentException("onCommitContentListener must be non-null");
        }
        if (Build.VERSION.SDK_INT >= 25) {
            return new a(inputConnection, false, onCommitContentListener);
        }
        String[] contentMimeTypes = va.a(editorInfo);
        if (contentMimeTypes.length == 0) {
            return inputConnection;
        }
        return new b(inputConnection, false, onCommitContentListener);
    }

    /* compiled from: InputConnectionCompat.java */
    /* renamed from: wa$a */
    /* loaded from: classes.dex */
    public class a extends InputConnectionWrapper {
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InputConnection target, boolean mutable, c cVar) {
            super(target, mutable);
            this.a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
            if (this.a.a(xa.f(inputContentInfo), flags, opts)) {
                return true;
            }
            return super.commitContent(inputContentInfo, flags, opts);
        }
    }

    /* compiled from: InputConnectionCompat.java */
    /* renamed from: wa$b */
    /* loaded from: classes.dex */
    public class b extends InputConnectionWrapper {
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InputConnection target, boolean mutable, c cVar) {
            super(target, mutable);
            this.a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(String action, Bundle data) {
            if (wa.b(action, data, this.a)) {
                return true;
            }
            return super.performPrivateCommand(action, data);
        }
    }
}
