package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* compiled from: AppCompatProgressBarHelper.java */
/* renamed from: c2  reason: default package */
/* loaded from: classes.dex */
public class c2 {
    public static final int[] a = {16843067, 16843068};
    public final ProgressBar b;
    public Bitmap c;

    public c2(ProgressBar view) {
        this.b = view;
    }

    public void c(AttributeSet attrs, int defStyleAttr) {
        z2 a2 = z2.u(this.b.getContext(), attrs, a, defStyleAttr, 0);
        Drawable drawable = a2.g(0);
        if (drawable != null) {
            this.b.setIndeterminateDrawable(e(drawable));
        }
        Drawable drawable2 = a2.g(1);
        if (drawable2 != null) {
            this.b.setProgressDrawable(d(drawable2, false));
        }
        a2.v();
    }

    public final Drawable d(Drawable drawable, boolean clip) {
        if (drawable instanceof k8) {
            Drawable inner = ((k8) drawable).b();
            if (inner != null) {
                ((k8) drawable).a(d(inner, clip));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable background = (LayerDrawable) drawable;
            int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            for (int i = 0; i < N; i++) {
                int id = background.getId(i);
                outDrawables[i] = d(background.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable newBg = new LayerDrawable(outDrawables);
            for (int i2 = 0; i2 < N; i2++) {
                newBg.setId(i2, background.getId(i2));
            }
            return newBg;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap tileBitmap = bitmapDrawable.getBitmap();
            if (this.c == null) {
                this.c = tileBitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            BitmapShader bitmapShader = new BitmapShader(tileBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            shapeDrawable.getPaint().setShader(bitmapShader);
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return clip ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable background = (AnimationDrawable) drawable;
            int N = background.getNumberOfFrames();
            AnimationDrawable newBg = new AnimationDrawable();
            newBg.setOneShot(background.isOneShot());
            for (int i = 0; i < N; i++) {
                Drawable frame = d(background.getFrame(i), true);
                frame.setLevel(10000);
                newBg.addFrame(frame, background.getDuration(i));
            }
            newBg.setLevel(10000);
            return newBg;
        }
        return drawable;
    }

    public final Shape a() {
        float[] roundedCorners = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
        return new RoundRectShape(roundedCorners, null, null);
    }

    public Bitmap b() {
        return this.c;
    }
}
