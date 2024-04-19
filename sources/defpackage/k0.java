package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import com.irdeto.securesdk.core.SSUtils;
import defpackage.l0;
import defpackage.n0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: k0  reason: default package */
/* loaded from: classes.dex */
public class k0 extends n0 implements j8 {
    public static final String q = k0.class.getSimpleName();
    public c r;
    public g s;
    public int t;
    public int u;
    public boolean v;

    @Override // defpackage.n0, defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable, defpackage.j8
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable, defpackage.j8
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public k0() {
        this(null, null);
    }

    public k0(c state, Resources res) {
        super(null);
        this.t = -1;
        this.u = -1;
        c newState = new c(state, this, res);
        g(newState);
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static k0 l(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = parser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        k0 asl = new k0();
        asl.m(context, resources, parser, attrs, theme);
        return asl;
    }

    public void m(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = w7.k(resources, theme, attrs, p0.a);
        setVisible(a2.getBoolean(p0.c, true), true);
        s(a2);
        h(resources);
        a2.recycle();
        n(context, resources, parser, attrs, theme);
        o();
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        g gVar = this.s;
        if (gVar != null && (changed || restart)) {
            if (visible) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return changed;
    }

    @Override // defpackage.n0, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // defpackage.l0, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.s;
        if (gVar != null) {
            gVar.d();
            this.s = null;
            f(this.t);
            this.t = -1;
            this.u = -1;
        }
    }

    @Override // defpackage.n0, defpackage.l0, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        int targetIndex = this.r.G(stateSet);
        boolean changed = targetIndex != c() && (r(targetIndex) || f(targetIndex));
        Drawable current = getCurrent();
        if (current != null) {
            return changed | current.setState(stateSet);
        }
        return changed;
    }

    public final boolean r(int toIndex) {
        int fromIndex;
        int transitionIndex;
        g transition;
        g currentTransition = this.s;
        if (currentTransition != null) {
            if (toIndex == this.t) {
                return true;
            }
            if (toIndex == this.u && currentTransition.a()) {
                currentTransition.b();
                this.t = this.u;
                this.u = toIndex;
                return true;
            }
            fromIndex = this.t;
            currentTransition.d();
        } else {
            fromIndex = c();
        }
        this.s = null;
        this.u = -1;
        this.t = -1;
        c state = this.r;
        int fromId = state.F(fromIndex);
        int toId = state.F(toIndex);
        if (toId == 0 || fromId == 0 || (transitionIndex = state.H(fromId, toId)) < 0) {
            return false;
        }
        boolean hasReversibleFlag = state.J(fromId, toId);
        f(transitionIndex);
        Drawable d2 = getCurrent();
        if (d2 instanceof AnimationDrawable) {
            boolean reversed = state.I(fromId, toId);
            transition = new e((AnimationDrawable) d2, reversed, hasReversibleFlag);
        } else if (d2 instanceof cf) {
            transition = new d((cf) d2);
        } else if (!(d2 instanceof Animatable)) {
            return false;
        } else {
            transition = new b((Animatable) d2);
        }
        transition.c();
        this.s = transition;
        this.u = fromIndex;
        this.t = toIndex;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$g */
    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void c();

        public abstract void d();

        public g() {
        }

        public void b() {
        }

        public boolean a() {
            return false;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$b */
    /* loaded from: classes.dex */
    public static class b extends g {
        public final Animatable a;

        public b(Animatable a) {
            super();
            this.a = a;
        }

        @Override // defpackage.k0.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.k0.g
        public void d() {
            this.a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$e */
    /* loaded from: classes.dex */
    public static class e extends g {
        public final ObjectAnimator a;
        public final boolean b;

        public e(AnimationDrawable ad, boolean reversed, boolean hasReversibleFlag) {
            super();
            int frameCount = ad.getNumberOfFrames();
            int fromFrame = reversed ? frameCount - 1 : 0;
            int toFrame = reversed ? 0 : frameCount - 1;
            f interp = new f(ad, reversed);
            ObjectAnimator anim = ObjectAnimator.ofInt(ad, SSUtils.O00oOooO, fromFrame, toFrame);
            if (Build.VERSION.SDK_INT >= 18) {
                anim.setAutoCancel(true);
            }
            anim.setDuration(interp.a());
            anim.setInterpolator(interp);
            this.b = hasReversibleFlag;
            this.a = anim;
        }

        @Override // defpackage.k0.g
        public boolean a() {
            return this.b;
        }

        @Override // defpackage.k0.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.k0.g
        public void b() {
            this.a.reverse();
        }

        @Override // defpackage.k0.g
        public void d() {
            this.a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$d */
    /* loaded from: classes.dex */
    public static class d extends g {
        public final cf a;

        public d(cf avd) {
            super();
            this.a = avd;
        }

        @Override // defpackage.k0.g
        public void c() {
            this.a.start();
        }

        @Override // defpackage.k0.g
        public void d() {
            this.a.stop();
        }
    }

    public final void s(TypedArray a2) {
        c state = this.r;
        if (Build.VERSION.SDK_INT >= 21) {
            state.d |= a2.getChangingConfigurations();
        }
        state.y(a2.getBoolean(p0.d, state.i));
        state.u(a2.getBoolean(p0.e, state.l));
        state.v(a2.getInt(p0.f, state.A));
        state.w(a2.getInt(p0.g, state.B));
        setDither(a2.getBoolean(p0.b, state.x));
    }

    public final void o() {
        onStateChange(getState());
    }

    public final void n(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int innerDepth = parser.getDepth() + 1;
        while (true) {
            int type = parser.next();
            if (type != 1) {
                int depth = parser.getDepth();
                if (depth >= innerDepth || type != 3) {
                    if (type == 2 && depth <= innerDepth) {
                        if (parser.getName().equals("item")) {
                            p(context, resources, parser, attrs, theme);
                        } else if (parser.getName().equals("transition")) {
                            q(context, resources, parser, attrs, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final int q(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int type;
        TypedArray a2 = w7.k(resources, theme, attrs, p0.k);
        int fromId = a2.getResourceId(p0.n, -1);
        int toId = a2.getResourceId(p0.m, -1);
        Drawable dr = null;
        int drawableId = a2.getResourceId(p0.l, -1);
        if (drawableId > 0) {
            dr = q2.h().j(context, drawableId);
        }
        boolean reversible = a2.getBoolean(p0.o, false);
        a2.recycle();
        if (dr == null) {
            do {
                type = parser.next();
            } while (type == 4);
            if (type != 2) {
                throw new XmlPullParserException(parser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (parser.getName().equals("animated-vector")) {
                dr = cf.a(context, resources, parser, attrs, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                dr = Drawable.createFromXmlInner(resources, parser, attrs, theme);
            } else {
                dr = Drawable.createFromXmlInner(resources, parser, attrs);
            }
        }
        if (dr == null) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (fromId == -1 || toId == -1) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        } else {
            return this.r.D(fromId, toId, dr, reversible);
        }
    }

    public final int p(Context context, Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int type;
        TypedArray a2 = w7.k(resources, theme, attrs, p0.h);
        int keyframeId = a2.getResourceId(p0.i, 0);
        Drawable dr = null;
        int drawableId = a2.getResourceId(p0.j, -1);
        if (drawableId > 0) {
            dr = q2.h().j(context, drawableId);
        }
        a2.recycle();
        int[] states = j(attrs);
        if (dr == null) {
            do {
                type = parser.next();
            } while (type == 4);
            if (type != 2) {
                throw new XmlPullParserException(parser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (parser.getName().equals("vector")) {
                dr = Cif.c(resources, parser, attrs, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                dr = Drawable.createFromXmlInner(resources, parser, attrs, theme);
            } else {
                dr = Drawable.createFromXmlInner(resources, parser, attrs);
            }
        }
        if (dr == null) {
            throw new XmlPullParserException(parser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.r.C(states, dr, keyframeId);
    }

    @Override // defpackage.n0, defpackage.l0, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.v && super.mutate() == this) {
            this.r.s();
            this.v = true;
        }
        return this;
    }

    @Override // defpackage.n0
    /* renamed from: k */
    public c i() {
        return new c(this.r, this, null);
    }

    @Override // defpackage.n0, defpackage.l0
    public void clearMutated() {
        super.clearMutated();
        this.v = false;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$c */
    /* loaded from: classes.dex */
    public static class c extends n0.a {
        public w3<Long> K;
        public a4<Integer> L;

        public c(c orig, k0 owner, Resources res) {
            super(orig, owner, res);
            if (orig != null) {
                this.K = orig.K;
                this.L = orig.L;
                return;
            }
            this.K = new w3<>();
            this.L = new a4<>();
        }

        @Override // defpackage.n0.a, defpackage.l0.d
        public void s() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int D(int fromId, int toId, Drawable anim, boolean reversible) {
            int pos = super.a(anim);
            long keyFromTo = E(fromId, toId);
            long reversibleBit = 0;
            if (reversible) {
                reversibleBit = 8589934592L;
            }
            this.K.a(keyFromTo, Long.valueOf(pos | reversibleBit));
            if (reversible) {
                long keyToFrom = E(toId, fromId);
                this.K.a(keyToFrom, Long.valueOf(pos | 4294967296L | reversibleBit));
            }
            return pos;
        }

        public int C(int[] stateSet, Drawable drawable, int id) {
            int index = super.A(stateSet, drawable);
            this.L.h(index, Integer.valueOf(id));
            return index;
        }

        public int G(int[] stateSet) {
            int index = super.B(stateSet);
            if (index >= 0) {
                return index;
            }
            return super.B(StateSet.WILD_CARD);
        }

        public int F(int index) {
            if (index < 0) {
                return 0;
            }
            return this.L.f(index, 0).intValue();
        }

        public int H(int fromId, int toId) {
            long keyFromTo = E(fromId, toId);
            return (int) this.K.f(keyFromTo, -1L).longValue();
        }

        public boolean I(int fromId, int toId) {
            long keyFromTo = E(fromId, toId);
            return (this.K.f(keyFromTo, -1L).longValue() & 4294967296L) != 0;
        }

        public boolean J(int fromId, int toId) {
            long keyFromTo = E(fromId, toId);
            return (this.K.f(keyFromTo, -1L).longValue() & 8589934592L) != 0;
        }

        @Override // defpackage.n0.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k0(this, null);
        }

        @Override // defpackage.n0.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new k0(this, res);
        }

        public static long E(int fromId, int toId) {
            return (fromId << 32) | toId;
        }
    }

    @Override // defpackage.n0, defpackage.l0
    public void g(l0.d state) {
        super.g(state);
        if (state instanceof c) {
            this.r = (c) state;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: k0$f */
    /* loaded from: classes.dex */
    public static class f implements TimeInterpolator {
        public int[] a;
        public int b;
        public int c;

        public f(AnimationDrawable d, boolean reversed) {
            b(d, reversed);
        }

        public int b(AnimationDrawable d, boolean reversed) {
            int frameCount = d.getNumberOfFrames();
            this.b = frameCount;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < frameCount) {
                this.a = new int[frameCount];
            }
            int[] frameTimes = this.a;
            int totalDuration = 0;
            for (int i = 0; i < frameCount; i++) {
                int duration = d.getDuration(reversed ? (frameCount - i) - 1 : i);
                frameTimes[i] = duration;
                totalDuration += duration;
            }
            this.c = totalDuration;
            return totalDuration;
        }

        public int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            float frameElapsed;
            int elapsed = (int) ((this.c * input) + 0.5f);
            int frameCount = this.b;
            int[] frameTimes = this.a;
            int remaining = elapsed;
            int i = 0;
            while (i < frameCount && remaining >= frameTimes[i]) {
                remaining -= frameTimes[i];
                i++;
            }
            if (i < frameCount) {
                frameElapsed = remaining / this.c;
            } else {
                frameElapsed = 0.0f;
            }
            return (i / frameCount) + frameElapsed;
        }
    }
}
