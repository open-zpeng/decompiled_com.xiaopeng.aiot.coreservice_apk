package com.xiaopeng.xui.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
@Deprecated
/* loaded from: classes.dex */
public class XFullscreenActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        M(this, 14);
    }

    public static void M(Activity activity, int feature) {
        if (feature > 0) {
            activity.requestWindowFeature(feature);
        }
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(5894);
    }
}
