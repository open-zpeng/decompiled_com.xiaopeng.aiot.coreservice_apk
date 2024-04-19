package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
/* compiled from: DrawableContainer.java */
/* renamed from: l0  reason: default package */
/* loaded from: classes.dex */
public class l0 extends Drawable implements Drawable.Callback {
    public d a;
    public Rect b;
    public Drawable d;
    public Drawable f;
    public boolean h;
    public boolean j;
    public Runnable k;
    public long l;
    public long m;
    public c n;
    public int g = 255;
    public int i = -1;

    public d b() {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.getChangingConfigurations();
    }

    public final boolean e() {
        return isAutoMirrored() && i8.e(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        boolean result;
        Rect r = this.a.m();
        if (r != null) {
            padding.set(r);
            result = (((r.left | r.top) | r.bottom) | r.right) != 0;
        } else {
            Drawable drawable = this.d;
            if (drawable != null) {
                result = drawable.getPadding(padding);
            } else {
                result = super.getPadding(padding);
            }
        }
        if (e()) {
            int left = padding.left;
            padding.left = padding.right;
            padding.right = left;
        }
        return result;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.d;
        if (drawable != null) {
            b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (!this.h || this.g != alpha) {
            this.h = true;
            this.g = alpha;
            Drawable drawable = this.d;
            if (drawable != null) {
                if (this.l == 0) {
                    drawable.setAlpha(alpha);
                } else {
                    a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        d dVar = this.a;
        if (dVar.x != dither) {
            dVar.x = dither;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setDither(dither);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintList(ColorStateList tint) {
        d dVar = this.a;
        dVar.H = true;
        if (dVar.F != tint) {
            dVar.F = tint;
            i8.n(this.d, tint);
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintMode(PorterDuff.Mode tintMode) {
        d dVar = this.a;
        dVar.I = true;
        if (dVar.G != tintMode) {
            dVar.G = tintMode;
            i8.o(this.d, tintMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        d dVar = this.a;
        if (dVar.C != mirrored) {
            dVar.C = mirrored;
            Drawable drawable = this.d;
            if (drawable != null) {
                i8.i(drawable, mirrored);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean changed = false;
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f = null;
            changed = true;
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.h) {
                this.d.setAlpha(this.g);
            }
        }
        if (this.m != 0) {
            this.m = 0L;
            changed = true;
        }
        if (this.l != 0) {
            this.l = 0L;
            changed = true;
        }
        if (changed) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y) {
        Drawable drawable = this.d;
        if (drawable != null) {
            i8.j(drawable, x, y);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        Rect rect = this.b;
        if (rect == null) {
            this.b = new Rect(left, top, right, bottom);
        } else {
            rect.set(left, top, right, bottom);
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            i8.k(drawable, left, top, right, bottom);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect outRect) {
        Rect rect = this.b;
        if (rect != null) {
            outRect.set(rect);
        } else {
            super.getHotspotBounds(outRect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(state);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            return drawable2.setState(state);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setLevel(level);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            return drawable2.setLevel(level);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return this.a.x(layoutDirection, c());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.a.r()) {
            return this.a.n();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.a.r()) {
            return this.a.j();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.a.r()) {
            return this.a.l();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.a.r()) {
            return this.a.k();
        }
        Drawable drawable = this.d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable who) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.q();
        }
        if (who == this.d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (who == this.d && getCallback() != null) {
            getCallback().scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (who == this.d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, what);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setVisible(visible, restart);
        }
        Drawable drawable2 = this.d;
        if (drawable2 != null) {
            drawable2.setVisible(visible, restart);
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.a.o();
    }

    public int c() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(int r10) {
        /*
            r9 = this;
            int r0 = r9.i
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            l0$d r0 = r9.a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.d
            if (r0 == 0) goto L29
            r9.f = r0
            l0$d r0 = r9.a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.m = r0
            goto L35
        L29:
            r9.f = r4
            r9.m = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.d
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            l0$d r0 = r9.a
            int r1 = r0.h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.h(r10)
            r9.d = r0
            r9.i = r10
            if (r0 == 0) goto L54
            l0$d r1 = r9.a
            int r1 = r1.A
            if (r1 <= 0) goto L51
            long r7 = (long) r1
            long r7 = r7 + r2
            r9.l = r7
        L51:
            r9.d(r0)
        L54:
            goto L5a
        L55:
            r9.d = r4
            r0 = -1
            r9.i = r0
        L5a:
            long r0 = r9.l
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r1 = 1
            if (r0 != 0) goto L67
            long r7 = r9.m
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.k
            if (r0 != 0) goto L73
            l0$a r0 = new l0$a
            r0.<init>()
            r9.k = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r1)
        L79:
            r9.invalidateSelf()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l0.f(int):boolean");
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: l0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.a(true);
            l0.this.invalidateSelf();
        }
    }

    public final void d(Drawable d2) {
        if (this.n == null) {
            this.n = new c();
        }
        d2.setCallback(this.n.b(d2.getCallback()));
        try {
            if (this.a.A <= 0 && this.h) {
                d2.setAlpha(this.g);
            }
            d dVar = this.a;
            if (dVar.E) {
                d2.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    i8.n(d2, dVar.F);
                }
                d dVar2 = this.a;
                if (dVar2.I) {
                    i8.o(d2, dVar2.G);
                }
            }
            d2.setVisible(isVisible(), true);
            d2.setDither(this.a.x);
            d2.setState(getState());
            d2.setLevel(getLevel());
            d2.setBounds(getBounds());
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                i8.l(d2, i8.e(this));
            }
            if (i >= 19) {
                i8.i(d2, this.a.C);
            }
            Rect hotspotBounds = this.b;
            if (i >= 21 && hotspotBounds != null) {
                i8.k(d2, hotspotBounds.left, hotspotBounds.top, hotspotBounds.right, hotspotBounds.bottom);
            }
        } finally {
            d2.setCallback(this.n.a());
        }
    }

    public void a(boolean schedule) {
        this.h = true;
        long now = SystemClock.uptimeMillis();
        boolean animating = false;
        Drawable drawable = this.d;
        if (drawable != null) {
            long j = this.l;
            if (j != 0) {
                if (j <= now) {
                    drawable.setAlpha(this.g);
                    this.l = 0L;
                } else {
                    int animAlpha = ((int) ((j - now) * 255)) / this.a.A;
                    drawable.setAlpha(((255 - animAlpha) * this.g) / 255);
                    animating = true;
                }
            }
        } else {
            this.l = 0L;
        }
        Drawable drawable2 = this.f;
        if (drawable2 != null) {
            long j2 = this.m;
            if (j2 != 0) {
                if (j2 <= now) {
                    drawable2.setVisible(false, false);
                    this.f = null;
                    this.m = 0L;
                } else {
                    int animAlpha2 = ((int) ((j2 - now) * 255)) / this.a.B;
                    drawable2.setAlpha((this.g * animAlpha2) / 255);
                    animating = true;
                }
            }
        } else {
            this.m = 0L;
        }
        if (schedule && animating) {
            scheduleSelf(this.k, 16 + now);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.d;
    }

    public final void h(Resources res) {
        this.a.z(res);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.a.b(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.a.c()) {
            this.a.d = getChangingConfigurations();
            return this.a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.j && super.mutate() == this) {
            d clone = b();
            clone.s();
            g(clone);
            this.j = true;
        }
        return this;
    }

    public void clearMutated() {
        this.a.d();
        this.j = false;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: l0$d */
    /* loaded from: classes.dex */
    public static abstract class d extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;
        public final l0 a;
        public Resources b;
        public int c;
        public int d;
        public int e;
        public SparseArray<Drawable.ConstantState> f;
        public Drawable[] g;
        public int h;
        public boolean i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public abstract void s();

        public d(d orig, l0 owner, Resources res) {
            Resources resources;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = owner;
            if (res != null) {
                resources = res;
            } else {
                resources = orig != null ? orig.b : null;
            }
            this.b = resources;
            int resolveDensity = l0.resolveDensity(res, orig != null ? orig.c : 0);
            this.c = resolveDensity;
            if (orig != null) {
                this.d = orig.d;
                this.e = orig.e;
                this.v = true;
                this.w = true;
                this.i = orig.i;
                this.l = orig.l;
                this.x = orig.x;
                this.y = orig.y;
                this.z = orig.z;
                this.A = orig.A;
                this.B = orig.B;
                this.C = orig.C;
                this.D = orig.D;
                this.E = orig.E;
                this.F = orig.F;
                this.G = orig.G;
                this.H = orig.H;
                this.I = orig.I;
                if (orig.c == resolveDensity) {
                    if (orig.j) {
                        Rect rect = orig.k;
                        this.k = rect != null ? new Rect(rect) : null;
                        this.j = true;
                    }
                    if (orig.m) {
                        this.n = orig.n;
                        this.o = orig.o;
                        this.p = orig.p;
                        this.q = orig.q;
                        this.m = true;
                    }
                }
                if (orig.r) {
                    this.s = orig.s;
                    this.r = true;
                }
                if (orig.t) {
                    this.u = orig.u;
                    this.t = true;
                }
                Drawable[] origDr = orig.g;
                this.g = new Drawable[origDr.length];
                int i = orig.h;
                this.h = i;
                SparseArray<Drawable.ConstantState> origDf = orig.f;
                if (origDf != null) {
                    this.f = origDf.clone();
                } else {
                    this.f = new SparseArray<>(i);
                }
                int count = this.h;
                for (int i2 = 0; i2 < count; i2++) {
                    if (origDr[i2] != null) {
                        Drawable.ConstantState cs = origDr[i2].getConstantState();
                        if (cs != null) {
                            this.f.put(i2, cs);
                        } else {
                            this.g[i2] = origDr[i2];
                        }
                    }
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        public final int a(Drawable dr) {
            int pos = this.h;
            if (pos >= this.g.length) {
                p(pos, pos + 10);
            }
            dr.mutate();
            dr.setVisible(false, true);
            dr.setCallback(this.a);
            this.g[pos] = dr;
            this.h++;
            this.e |= dr.getChangingConfigurations();
            q();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return pos;
        }

        public void q() {
            this.r = false;
            this.t = false;
        }

        public final int g() {
            return this.g.length;
        }

        public final void f() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int futureCount = sparseArray.size();
                for (int keyIndex = 0; keyIndex < futureCount; keyIndex++) {
                    int index = this.f.keyAt(keyIndex);
                    Drawable.ConstantState cs = this.f.valueAt(keyIndex);
                    this.g[index] = t(cs.newDrawable(this.b));
                }
                this.f = null;
            }
        }

        public final Drawable t(Drawable child) {
            if (Build.VERSION.SDK_INT >= 23) {
                i8.l(child, this.z);
            }
            Drawable child2 = child.mutate();
            child2.setCallback(this.a);
            return child2;
        }

        public final int i() {
            return this.h;
        }

        public final Drawable h(int index) {
            int keyIndex;
            Drawable result = this.g[index];
            if (result != null) {
                return result;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray == null || (keyIndex = sparseArray.indexOfKey(index)) < 0) {
                return null;
            }
            Drawable.ConstantState cs = this.f.valueAt(keyIndex);
            Drawable prepared = t(cs.newDrawable(this.b));
            this.g[index] = prepared;
            this.f.removeAt(keyIndex);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return prepared;
        }

        public final boolean x(int layoutDirection, int currentIndex) {
            boolean changed = false;
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i] != null) {
                    boolean childChanged = false;
                    if (Build.VERSION.SDK_INT >= 23) {
                        childChanged = i8.l(drawables[i], layoutDirection);
                    }
                    if (i == currentIndex) {
                        changed = childChanged;
                    }
                }
            }
            this.z = layoutDirection;
            return changed;
        }

        public final void z(Resources res) {
            if (res != null) {
                this.b = res;
                int targetDensity = l0.resolveDensity(res, this.c);
                int sourceDensity = this.c;
                this.c = targetDensity;
                if (sourceDensity != targetDensity) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public final void b(Resources.Theme theme) {
            if (theme != null) {
                f();
                int count = this.h;
                Drawable[] drawables = this.g;
                for (int i = 0; i < count; i++) {
                    if (drawables[i] != null && i8.b(drawables[i])) {
                        i8.a(drawables[i], theme);
                        this.e |= drawables[i].getChangingConfigurations();
                    }
                }
                z(b.c(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                Drawable d = drawables[i];
                if (d != null) {
                    if (i8.b(d)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState future = this.f.get(i);
                    if (future != null && b.a(future)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void d() {
            this.y = false;
        }

        public final void y(boolean variable) {
            this.i = variable;
        }

        public final Rect m() {
            if (this.i) {
                return null;
            }
            Rect r = this.k;
            if (r != null || this.j) {
                return r;
            }
            f();
            Rect r2 = null;
            Rect t = new Rect();
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i].getPadding(t)) {
                    if (r2 == null) {
                        r2 = new Rect(0, 0, 0, 0);
                    }
                    int i2 = t.left;
                    if (i2 > r2.left) {
                        r2.left = i2;
                    }
                    int i3 = t.top;
                    if (i3 > r2.top) {
                        r2.top = i3;
                    }
                    int i4 = t.right;
                    if (i4 > r2.right) {
                        r2.right = i4;
                    }
                    int i5 = t.bottom;
                    if (i5 > r2.bottom) {
                        r2.bottom = i5;
                    }
                }
            }
            this.j = true;
            this.k = r2;
            return r2;
        }

        public final void u(boolean constant) {
            this.l = constant;
        }

        public final boolean r() {
            return this.l;
        }

        public final int n() {
            if (!this.m) {
                e();
            }
            return this.n;
        }

        public final int j() {
            if (!this.m) {
                e();
            }
            return this.o;
        }

        public final int l() {
            if (!this.m) {
                e();
            }
            return this.p;
        }

        public final int k() {
            if (!this.m) {
                e();
            }
            return this.q;
        }

        public void e() {
            this.m = true;
            f();
            int count = this.h;
            Drawable[] drawables = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i = 0; i < count; i++) {
                Drawable dr = drawables[i];
                int s = dr.getIntrinsicWidth();
                if (s > this.n) {
                    this.n = s;
                }
                int s2 = dr.getIntrinsicHeight();
                if (s2 > this.o) {
                    this.o = s2;
                }
                int s3 = dr.getMinimumWidth();
                if (s3 > this.p) {
                    this.p = s3;
                }
                int s4 = dr.getMinimumHeight();
                if (s4 > this.q) {
                    this.q = s4;
                }
            }
        }

        public final void v(int duration) {
            this.A = duration;
        }

        public final void w(int duration) {
            this.B = duration;
        }

        public final int o() {
            if (this.r) {
                return this.s;
            }
            f();
            int count = this.h;
            Drawable[] drawables = this.g;
            int op = count > 0 ? drawables[0].getOpacity() : -2;
            for (int i = 1; i < count; i++) {
                op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            }
            this.s = op;
            this.r = true;
            return op;
        }

        public void p(int oldSize, int newSize) {
            Drawable[] newDrawables = new Drawable[newSize];
            Drawable[] drawableArr = this.g;
            if (drawableArr != null) {
                System.arraycopy(drawableArr, 0, newDrawables, 0, oldSize);
            }
            this.g = newDrawables;
        }

        public boolean c() {
            if (this.v) {
                return this.w;
            }
            f();
            this.v = true;
            int count = this.h;
            Drawable[] drawables = this.g;
            for (int i = 0; i < count; i++) {
                if (drawables[i].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    public void g(d state) {
        this.a = state;
        int i = this.i;
        if (i >= 0) {
            Drawable h = state.h(i);
            this.d = h;
            if (h != null) {
                d(h);
            }
        }
        this.f = null;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: l0$c */
    /* loaded from: classes.dex */
    public static class c implements Drawable.Callback {
        public Drawable.Callback a;

        public c b(Drawable.Callback callback) {
            this.a = callback;
            return this;
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.a;
            this.a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.scheduleDrawable(who, what, when);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.unscheduleDrawable(who, what);
            }
        }
    }

    public static int resolveDensity(Resources r, int parentDensity) {
        int densityDpi = r == null ? parentDensity : r.getDisplayMetrics().densityDpi;
        if (densityDpi == 0) {
            return 160;
        }
        return densityDpi;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: l0$b */
    /* loaded from: classes.dex */
    public static class b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
