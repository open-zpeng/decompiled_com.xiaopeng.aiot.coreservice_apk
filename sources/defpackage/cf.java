package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* renamed from: cf  reason: default package */
/* loaded from: classes.dex */
public class cf extends hf implements Animatable {
    public b b;
    public Context d;
    public ArgbEvaluator f;
    public Animator.AnimatorListener g;
    public ArrayList<?> h;
    public final Drawable.Callback i;

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect x0) {
        return super.getPadding(x0);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int x0) {
        super.setChangingConfigurations(x0);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int x0, PorterDuff.Mode x1) {
        super.setColorFilter(x0, x1);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean x0) {
        super.setFilterBitmap(x0);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float x0, float x1) {
        super.setHotspot(x0, x1);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int x0, int x1, int x2, int x3) {
        super.setHotspotBounds(x0, x1, x2, x3);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] x0) {
        return super.setState(x0);
    }

    public cf() {
        this(null, null, null);
    }

    public cf(Context context) {
        this(context, null, null);
    }

    public cf(Context context, b state, Resources res) {
        this.f = null;
        this.g = null;
        this.h = null;
        a aVar = new a();
        this.i = aVar;
        this.d = context;
        if (state != null) {
            this.b = state;
        } else {
            this.b = new b(context, state, aVar, res);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public static cf a(Context context, Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        cf drawable = new cf(context);
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new c(drawable.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (this.b.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(bounds);
        } else {
            this.b.b.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(state);
        }
        return this.b.b.setState(state);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        return this.b.b.setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.c(drawable);
        }
        return this.b.b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        } else {
            this.b.b.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.b.b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.d(drawable);
        }
        return this.b.b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTint(int tint) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.m(drawable, tint);
        } else {
            this.b.b.setTint(tint);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.n(drawable, tint);
        } else {
            this.b.b.setTintList(tint);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintMode(PorterDuff.Mode tintMode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.o(drawable, tintMode);
        } else {
            this.b.b.setTintMode(tintMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        this.b.b.setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.b.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.b.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.b.b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.b.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.g(drawable);
        }
        return this.b.b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.i(drawable, mirrored);
        } else {
            this.b.b.setAutoMirrored(mirrored);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.f(drawable, res, parser, attrs, theme);
            return;
        }
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        while (eventType != 1 && (parser.getDepth() >= innerDepth || eventType != 3)) {
            if (eventType == 2) {
                String tagName = parser.getName();
                if ("animated-vector".equals(tagName)) {
                    TypedArray a2 = w7.k(res, theme, attrs, bf.e);
                    int drawableRes = a2.getResourceId(0, 0);
                    if (drawableRes != 0) {
                        Cif vectorDrawable = Cif.b(res, drawableRes, theme);
                        vectorDrawable.h(false);
                        vectorDrawable.setCallback(this.i);
                        Cif cif = this.b.b;
                        if (cif != null) {
                            cif.setCallback(null);
                        }
                        this.b.b = vectorDrawable;
                    }
                    a2.recycle();
                } else if ("target".equals(tagName)) {
                    TypedArray a3 = res.obtainAttributes(attrs, bf.f);
                    String target = a3.getString(0);
                    int id = a3.getResourceId(1, 0);
                    if (id != 0) {
                        Context context = this.d;
                        if (context != null) {
                            Animator objectAnimator = ef.i(context, id);
                            b(target, objectAnimator);
                        } else {
                            a3.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a3.recycle();
                } else {
                    continue;
                }
            }
            eventType = parser.next();
        }
        this.b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        inflate(res, parser, attrs, null);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme t) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.a(drawable, t);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.b(drawable);
        }
        return false;
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: cf$c */
    /* loaded from: classes.dex */
    public static class c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public c(Drawable.ConstantState state) {
            this.a = state;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            cf drawableCompat = new cf();
            Drawable newDrawable = this.a.newDrawable();
            drawableCompat.a = newDrawable;
            newDrawable.setCallback(drawableCompat.i);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            cf drawableCompat = new cf();
            Drawable newDrawable = this.a.newDrawable(res);
            drawableCompat.a = newDrawable;
            newDrawable.setCallback(drawableCompat.i);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res, Resources.Theme theme) {
            cf drawableCompat = new cf();
            Drawable newDrawable = this.a.newDrawable(res, theme);
            drawableCompat.a = newDrawable;
            newDrawable.setCallback(drawableCompat.i);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: cf$b */
    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {
        public int a;
        public Cif b;
        public AnimatorSet c;
        public ArrayList<Animator> d;
        public t3<Animator, String> e;

        public b(Context context, b copy, Drawable.Callback owner, Resources res) {
            if (copy != null) {
                this.a = copy.a;
                Cif cif = copy.b;
                if (cif != null) {
                    Drawable.ConstantState cs = cif.getConstantState();
                    if (res != null) {
                        this.b = (Cif) cs.newDrawable(res);
                    } else {
                        this.b = (Cif) cs.newDrawable();
                    }
                    Cif cif2 = (Cif) this.b.mutate();
                    this.b = cif2;
                    cif2.setCallback(owner);
                    this.b.setBounds(copy.b.getBounds());
                    this.b.h(false);
                }
                ArrayList<Animator> arrayList = copy.d;
                if (arrayList != null) {
                    int numAnimators = arrayList.size();
                    this.d = new ArrayList<>(numAnimators);
                    this.e = new t3<>(numAnimators);
                    for (int i = 0; i < numAnimators; i++) {
                        Animator anim = copy.d.get(i);
                        Animator animClone = anim.clone();
                        String targetName = copy.e.get(anim);
                        Object targetObject = this.b.d(targetName);
                        animClone.setTarget(targetObject);
                        this.d.add(animClone);
                        this.e.put(animClone, targetName);
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }
    }

    public final void c(Animator animator) {
        List<Animator> childAnimators;
        if ((animator instanceof AnimatorSet) && (childAnimators = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimators.size(); i++) {
                c(childAnimators.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnim = (ObjectAnimator) animator;
            String propertyName = objectAnim.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f == null) {
                    this.f = new ArgbEvaluator();
                }
                objectAnim.setEvaluator(this.f);
            }
        }
    }

    public final void b(String name, Animator animator) {
        Object target = this.b.b.d(name);
        animator.setTarget(target);
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.b;
        if (bVar.d == null) {
            bVar.d = new ArrayList<>();
            this.b.e = new t3<>();
        }
        this.b.d.add(animator);
        this.b.e.put(animator, name);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.b.c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.b.c.isStarted()) {
        } else {
            this.b.c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.b.c.end();
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: cf$a */
    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            cf.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            cf.this.scheduleSelf(what, when);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            cf.this.unscheduleSelf(what);
        }
    }
}
