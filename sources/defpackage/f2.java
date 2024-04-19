package defpackage;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
/* compiled from: AppCompatTextClassifierHelper.java */
/* renamed from: f2  reason: default package */
/* loaded from: classes.dex */
public final class f2 {
    public TextView a;
    public TextClassifier b;

    public f2(TextView textView) {
        this.a = (TextView) k9.d(textView);
    }

    public void b(TextClassifier textClassifier) {
        this.b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.b;
        if (textClassifier == null) {
            TextClassificationManager tcm = (TextClassificationManager) this.a.getContext().getSystemService(TextClassificationManager.class);
            if (tcm != null) {
                return tcm.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
