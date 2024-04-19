package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.xiaopeng.lib.apirouter.ClientConstants;
import defpackage.z7;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* renamed from: if  reason: invalid class name and default package */
/* loaded from: classes.dex */
public class Cif extends hf {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public h d;
    public PorterDuffColorFilter f;
    public ColorFilter g;
    public boolean h;
    public boolean i;
    public Drawable.ConstantState j;
    public final float[] k;
    public final Matrix l;
    public final Rect m;

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

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
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
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
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // defpackage.hf, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public Cif() {
        this.i = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.d = new h();
    }

    public Cif(h state) {
        this.i = true;
        this.k = new float[9];
        this.l = new Matrix();
        this.m = new Rect();
        this.d = state;
        this.f = updateTintFilter(this.f, state.c, state.d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.h && super.mutate() == this) {
            this.d = new h(this.d);
            this.h = true;
        }
        return this;
    }

    public Object d(String name) {
        return this.d.b.q.get(name);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new i(drawable.getConstantState());
        }
        this.d.a = getChangingConfigurations();
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.m);
        if (this.m.width() <= 0 || this.m.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.g;
        if (colorFilter == null) {
            colorFilter = this.f;
        }
        canvas.getMatrix(this.l);
        this.l.getValues(this.k);
        float canvasScaleX = Math.abs(this.k[0]);
        float canvasScaleY = Math.abs(this.k[4]);
        float canvasSkewX = Math.abs(this.k[1]);
        float canvasSkewY = Math.abs(this.k[3]);
        if (canvasSkewX != 0.0f || canvasSkewY != 0.0f) {
            canvasScaleX = 1.0f;
            canvasScaleY = 1.0f;
        }
        int scaledWidth = Math.min(2048, (int) (this.m.width() * canvasScaleX));
        int scaledHeight = Math.min(2048, (int) (this.m.height() * canvasScaleY));
        if (scaledWidth <= 0 || scaledHeight <= 0) {
            return;
        }
        int saveCount = canvas.save();
        Rect rect = this.m;
        canvas.translate(rect.left, rect.top);
        boolean needMirroring = f();
        if (needMirroring) {
            canvas.translate(this.m.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.m.offsetTo(0, 0);
        this.d.c(scaledWidth, scaledHeight);
        if (!this.i) {
            this.d.j(scaledWidth, scaledHeight);
        } else if (!this.d.b()) {
            this.d.j(scaledWidth, scaledHeight);
            this.d.i();
        }
        this.d.d(canvas, colorFilter, this.m);
        canvas.restoreToCount(saveCount);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.c(drawable);
        }
        return this.d.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        } else if (this.d.b.getRootAlpha() != alpha) {
            this.d.b.setRootAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.g = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.d(drawable);
        }
        return this.g;
    }

    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter tintFilter, ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(getState(), 0);
        return new PorterDuffColorFilter(color, tintMode);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTint(int tint) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.m(drawable, tint);
        } else {
            setTintList(ColorStateList.valueOf(tint));
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.n(drawable, tint);
            return;
        }
        h state = this.d;
        if (state.c != tint) {
            state.c = tint;
            this.f = updateTintFilter(this.f, tint, state.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, defpackage.j8
    public void setTintMode(PorterDuff.Mode tintMode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.o(drawable, tintMode);
            return;
        }
        h state = this.d;
        if (state.d != tintMode) {
            state.d = tintMode;
            this.f = updateTintFilter(this.f, state.c, tintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.d) != null && (hVar.g() || ((colorStateList = this.d.c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        PorterDuff.Mode mode;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(stateSet);
        }
        boolean changed = false;
        h state = this.d;
        ColorStateList colorStateList = state.c;
        if (colorStateList != null && (mode = state.d) != null) {
            this.f = updateTintFilter(this.f, colorStateList, mode);
            invalidateSelf();
            changed = true;
        }
        if (state.g() && state.h(stateSet)) {
            invalidateSelf();
            return true;
        }
        return changed;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.d.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.d.b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.b(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return i8.g(drawable);
        }
        return this.d.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.i(drawable, mirrored);
        } else {
            this.d.e = mirrored;
        }
    }

    public static Cif b(Resources res, int resId, Resources.Theme theme) {
        int type;
        if (Build.VERSION.SDK_INT >= 24) {
            Cif drawable = new Cif();
            Drawable a2 = v7.a(res, resId, theme);
            drawable.a = a2;
            drawable.j = new i(a2.getConstantState());
            return drawable;
        }
        try {
            XmlPullParser parser = res.getXml(resId);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            while (true) {
                type = parser.next();
                if (type == 2 || type == 1) {
                    break;
                }
            }
            if (type != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return c(res, parser, attrs, theme);
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    public static Cif c(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        Cif drawable = new Cif();
        drawable.inflate(r, parser, attrs, theme);
        return drawable;
    }

    public static int a(int color, float alpha) {
        int alphaBytes = Color.alpha(color);
        return (color & 16777215) | (((int) (alphaBytes * alpha)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(res, parser, attrs);
        } else {
            inflate(res, parser, attrs, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            i8.f(drawable, res, parser, attrs, theme);
            return;
        }
        h state = this.d;
        g pathRenderer = new g();
        state.b = pathRenderer;
        TypedArray a2 = w7.k(res, theme, attrs, bf.a);
        i(a2, parser, theme);
        a2.recycle();
        state.a = getChangingConfigurations();
        state.k = true;
        e(res, parser, attrs, theme);
        this.f = updateTintFilter(this.f, state.c, state.d);
    }

    public static PorterDuff.Mode g(int value, PorterDuff.Mode defaultMode) {
        switch (value) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return defaultMode;
        }
    }

    public final void i(TypedArray a2, XmlPullParser parser, Resources.Theme theme) throws XmlPullParserException {
        h state = this.d;
        g pathRenderer = state.b;
        int mode = w7.g(a2, parser, "tintMode", 6, -1);
        state.d = g(mode, PorterDuff.Mode.SRC_IN);
        ColorStateList tint = w7.c(a2, parser, theme, "tint", 1);
        if (tint != null) {
            state.c = tint;
        }
        state.e = w7.a(a2, parser, "autoMirrored", 5, state.e);
        pathRenderer.l = w7.f(a2, parser, "viewportWidth", 7, pathRenderer.l);
        float f2 = w7.f(a2, parser, "viewportHeight", 8, pathRenderer.m);
        pathRenderer.m = f2;
        if (pathRenderer.l <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f2 <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            pathRenderer.j = a2.getDimension(3, pathRenderer.j);
            float dimension = a2.getDimension(2, pathRenderer.k);
            pathRenderer.k = dimension;
            if (pathRenderer.j <= 0.0f) {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension <= 0.0f) {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                float alphaInFloat = w7.f(a2, parser, "alpha", 4, pathRenderer.getAlpha());
                pathRenderer.setAlpha(alphaInFloat);
                String name = a2.getString(0);
                if (name != null) {
                    pathRenderer.o = name;
                    pathRenderer.q.put(name, pathRenderer);
                }
            }
        }
    }

    public final void e(Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        h state = this.d;
        g pathRenderer = state.b;
        boolean noPathTag = true;
        ArrayDeque<VectorDrawableCompat.VGroup> groupStack = new ArrayDeque<>();
        groupStack.push(pathRenderer.i);
        int eventType = parser.getEventType();
        int innerDepth = parser.getDepth() + 1;
        for (int i2 = 1; eventType != i2 && (parser.getDepth() >= innerDepth || eventType != 3); i2 = 1) {
            if (eventType == 2) {
                String tagName = parser.getName();
                d currentGroup = (d) groupStack.peek();
                if (ClientConstants.ALIAS.PATH.equals(tagName)) {
                    c path = new c();
                    path.g(res, attrs, theme, parser);
                    currentGroup.b.add(path);
                    if (path.getPathName() != null) {
                        pathRenderer.q.put(path.getPathName(), path);
                    }
                    noPathTag = false;
                    state.a |= path.d;
                } else if ("clip-path".equals(tagName)) {
                    b path2 = new b();
                    path2.e(res, attrs, theme, parser);
                    currentGroup.b.add(path2);
                    if (path2.getPathName() != null) {
                        pathRenderer.q.put(path2.getPathName(), path2);
                    }
                    state.a |= path2.d;
                } else if ("group".equals(tagName)) {
                    d newChildGroup = new d();
                    newChildGroup.c(res, attrs, theme, parser);
                    currentGroup.b.add(newChildGroup);
                    groupStack.push(newChildGroup);
                    if (newChildGroup.getGroupName() != null) {
                        pathRenderer.q.put(newChildGroup.getGroupName(), newChildGroup);
                    }
                    state.a |= newChildGroup.k;
                }
            } else if (eventType == 3 && "group".equals(parser.getName())) {
                groupStack.pop();
            }
            eventType = parser.next();
        }
        if (noPathTag) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public void h(boolean allowCaching) {
        this.i = allowCaching;
    }

    public final boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && i8.e(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable what, long when) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(what, when);
        } else {
            super.scheduleSelf(what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(visible, restart);
        }
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable what) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(what);
        } else {
            super.unscheduleSelf(what);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$i */
    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public i(Drawable.ConstantState state) {
            this.a = state;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            Cif drawableCompat = new Cif();
            drawableCompat.a = (VectorDrawable) this.a.newDrawable();
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            Cif drawableCompat = new Cif();
            drawableCompat.a = (VectorDrawable) this.a.newDrawable(res);
            return drawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res, Resources.Theme theme) {
            Cif drawableCompat = new Cif();
            drawableCompat.a = (VectorDrawable) this.a.newDrawable(res, theme);
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

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$h */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        public int a;
        public g b;
        public ColorStateList c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h(h copy) {
            this.c = null;
            this.d = Cif.b;
            if (copy != null) {
                this.a = copy.a;
                g gVar = new g(copy.b);
                this.b = gVar;
                Paint paint = copy.b.f;
                if (paint != null) {
                    gVar.f = new Paint(paint);
                }
                Paint paint2 = copy.b.e;
                if (paint2 != null) {
                    this.b.e = new Paint(paint2);
                }
                this.c = copy.c;
                this.d = copy.d;
                this.e = copy.e;
            }
        }

        public void d(Canvas canvas, ColorFilter filter, Rect originalBounds) {
            Paint p = e(filter);
            canvas.drawBitmap(this.f, (Rect) null, originalBounds, p);
        }

        public boolean f() {
            return this.b.getRootAlpha() < 255;
        }

        public Paint e(ColorFilter filter) {
            if (!f() && filter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(filter);
            return this.l;
        }

        public void j(int width, int height) {
            this.f.eraseColor(0);
            Canvas tmpCanvas = new Canvas(this.f);
            this.b.b(tmpCanvas, width, height, null);
        }

        public void c(int width, int height) {
            if (this.f == null || !a(width, height)) {
                this.f = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean a(int width, int height) {
            if (width == this.f.getWidth() && height == this.f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void i() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public h() {
            this.c = null;
            this.d = Cif.b;
            this.b = new g();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new Cif(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new Cif(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        public boolean g() {
            return this.b.f();
        }

        public boolean h(int[] stateSet) {
            boolean changed = this.b.g(stateSet);
            this.k |= changed;
            return changed;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$g */
    /* loaded from: classes.dex */
    public static class g {
        public static final Matrix a = new Matrix();
        public final Path b;
        public final Path c;
        public final Matrix d;
        public Paint e;
        public Paint f;
        public PathMeasure g;
        public int h;
        public final d i;
        public float j;
        public float k;
        public float l;
        public float m;
        public int n;
        public String o;
        public Boolean p;
        public final t3<String, Object> q;

        public g() {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new t3<>();
            this.i = new d();
            this.b = new Path();
            this.c = new Path();
        }

        public void setRootAlpha(int alpha) {
            this.n = alpha;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public void setAlpha(float alpha) {
            setRootAlpha((int) (255.0f * alpha));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public g(g copy) {
            this.d = new Matrix();
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            t3<String, Object> t3Var = new t3<>();
            this.q = t3Var;
            this.i = new d(copy.i, t3Var);
            this.b = new Path(copy.b);
            this.c = new Path(copy.c);
            this.j = copy.j;
            this.k = copy.k;
            this.l = copy.l;
            this.m = copy.m;
            this.h = copy.h;
            this.n = copy.n;
            this.o = copy.o;
            String str = copy.o;
            if (str != null) {
                t3Var.put(str, this);
            }
            this.p = copy.p;
        }

        public final void c(d currentGroup, Matrix currentMatrix, Canvas canvas, int w, int h, ColorFilter filter) {
            currentGroup.a.set(currentMatrix);
            currentGroup.a.preConcat(currentGroup.j);
            canvas.save();
            for (int i = 0; i < currentGroup.b.size(); i++) {
                e child = currentGroup.b.get(i);
                if (child instanceof d) {
                    d childGroup = (d) child;
                    c(childGroup, currentGroup.a, canvas, w, h, filter);
                } else if (child instanceof f) {
                    f childPath = (f) child;
                    d(currentGroup, childPath, canvas, w, h, filter);
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int w, int h, ColorFilter filter) {
            c(this.i, a, canvas, w, h, filter);
        }

        public final void d(d vGroup, f vPath, Canvas canvas, int w, int h, ColorFilter filter) {
            float len;
            float scaleX = w / this.l;
            float scaleY = h / this.m;
            float minScale = Math.min(scaleX, scaleY);
            Matrix groupStackedMatrix = vGroup.a;
            this.d.set(groupStackedMatrix);
            this.d.postScale(scaleX, scaleY);
            float matrixScale = e(groupStackedMatrix);
            if (matrixScale == 0.0f) {
                return;
            }
            vPath.d(this.b);
            Path path = this.b;
            this.c.reset();
            if (vPath.c()) {
                this.c.setFillType(vPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.c.addPath(path, this.d);
                canvas.clipPath(this.c);
                return;
            }
            c fullPath = (c) vPath;
            float f = fullPath.k;
            if (f != 0.0f || fullPath.l != 1.0f) {
                float f2 = fullPath.m;
                float start = (f + f2) % 1.0f;
                float end = (fullPath.l + f2) % 1.0f;
                if (this.g == null) {
                    this.g = new PathMeasure();
                }
                this.g.setPath(this.b, false);
                float len2 = this.g.getLength();
                float start2 = start * len2;
                float end2 = end * len2;
                path.reset();
                if (start2 <= end2) {
                    len = 0.0f;
                    this.g.getSegment(start2, end2, path, true);
                } else {
                    this.g.getSegment(start2, len2, path, true);
                    len = 0.0f;
                    this.g.getSegment(0.0f, end2, path, true);
                }
                path.rLineTo(len, len);
            }
            this.c.addPath(path, this.d);
            if (fullPath.h.l()) {
                r7 fill = fullPath.h;
                if (this.f == null) {
                    Paint paint = new Paint(1);
                    this.f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint fillPaint = this.f;
                if (fill.h()) {
                    Shader shader = fill.f();
                    shader.setLocalMatrix(this.d);
                    fillPaint.setShader(shader);
                    fillPaint.setAlpha(Math.round(fullPath.j * 255.0f));
                } else {
                    fillPaint.setShader(null);
                    fillPaint.setAlpha(255);
                    fillPaint.setColor(Cif.a(fill.e(), fullPath.j));
                }
                fillPaint.setColorFilter(filter);
                this.c.setFillType(fullPath.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.c, fillPaint);
            }
            if (fullPath.f.l()) {
                r7 strokeColor = fullPath.f;
                if (this.e == null) {
                    Paint paint2 = new Paint(1);
                    this.e = paint2;
                    paint2.setStyle(Paint.Style.STROKE);
                }
                Paint strokePaint = this.e;
                Paint.Join join = fullPath.o;
                if (join != null) {
                    strokePaint.setStrokeJoin(join);
                }
                Paint.Cap cap = fullPath.n;
                if (cap != null) {
                    strokePaint.setStrokeCap(cap);
                }
                strokePaint.setStrokeMiter(fullPath.p);
                if (strokeColor.h()) {
                    Shader shader2 = strokeColor.f();
                    shader2.setLocalMatrix(this.d);
                    strokePaint.setShader(shader2);
                    strokePaint.setAlpha(Math.round(fullPath.i * 255.0f));
                } else {
                    strokePaint.setShader(null);
                    strokePaint.setAlpha(255);
                    strokePaint.setColor(Cif.a(strokeColor.e(), fullPath.i));
                }
                strokePaint.setColorFilter(filter);
                float finalStrokeScale = minScale * matrixScale;
                strokePaint.setStrokeWidth(fullPath.g * finalStrokeScale);
                canvas.drawPath(this.c, strokePaint);
            }
        }

        public static float a(float v1x, float v1y, float v2x, float v2y) {
            return (v1x * v2y) - (v1y * v2x);
        }

        public final float e(Matrix groupStackedMatrix) {
            float[] unitVectors = {0.0f, 1.0f, 1.0f, 0.0f};
            groupStackedMatrix.mapVectors(unitVectors);
            float scaleX = (float) Math.hypot(unitVectors[0], unitVectors[1]);
            float scaleY = (float) Math.hypot(unitVectors[2], unitVectors[3]);
            float crossProduct = a(unitVectors[0], unitVectors[1], unitVectors[2], unitVectors[3]);
            float maxScale = Math.max(scaleX, scaleY);
            if (maxScale <= 0.0f) {
                return 0.0f;
            }
            float matrixScale = Math.abs(crossProduct) / maxScale;
            return matrixScale;
        }

        public boolean f() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.i.a());
            }
            return this.p.booleanValue();
        }

        public boolean g(int[] stateSet) {
            return this.i.b(stateSet);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$e */
    /* loaded from: classes.dex */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] stateSet) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$d */
    /* loaded from: classes.dex */
    public static class d extends e {
        public final Matrix a;
        public final ArrayList<e> b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        /* JADX WARN: Generic types in debug info not equals: t3 != androidx.collection.ArrayMap<java.lang.String, java.lang.Object> */
        public d(d copy, t3<String, Object> t3Var) {
            super();
            f newPath;
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.c = copy.c;
            this.d = copy.d;
            this.e = copy.e;
            this.f = copy.f;
            this.g = copy.g;
            this.h = copy.h;
            this.i = copy.i;
            this.l = copy.l;
            String str = copy.m;
            this.m = str;
            this.k = copy.k;
            if (str != null) {
                t3Var.put(str, this);
            }
            matrix.set(copy.j);
            ArrayList<e> arrayList = copy.b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object copyChild = arrayList.get(i);
                if (copyChild instanceof d) {
                    d copyGroup = (d) copyChild;
                    this.b.add(new d(copyGroup, t3Var));
                } else {
                    if (copyChild instanceof c) {
                        newPath = new c((c) copyChild);
                    } else if (copyChild instanceof b) {
                        newPath = new b((b) copyChild);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(newPath);
                    String str2 = newPath.b;
                    if (str2 != null) {
                        t3Var.put(str2, newPath);
                    }
                }
            }
        }

        public d() {
            super();
            this.a = new Matrix();
            this.b = new ArrayList<>();
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public void c(Resources res, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            TypedArray a = w7.k(res, theme, attrs, bf.b);
            e(a, parser);
            a.recycle();
        }

        public final void e(TypedArray a, XmlPullParser parser) {
            this.l = null;
            this.c = w7.f(a, parser, "rotation", 5, this.c);
            this.d = a.getFloat(1, this.d);
            this.e = a.getFloat(2, this.e);
            this.f = w7.f(a, parser, "scaleX", 3, this.f);
            this.g = w7.f(a, parser, "scaleY", 4, this.g);
            this.h = w7.f(a, parser, "translateX", 6, this.h);
            this.i = w7.f(a, parser, "translateY", 7, this.i);
            String groupName = a.getString(0);
            if (groupName != null) {
                this.m = groupName;
            }
            d();
        }

        public final void d() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public float getRotation() {
            return this.c;
        }

        public void setRotation(float rotation) {
            if (rotation != this.c) {
                this.c = rotation;
                d();
            }
        }

        public float getPivotX() {
            return this.d;
        }

        public void setPivotX(float pivotX) {
            if (pivotX != this.d) {
                this.d = pivotX;
                d();
            }
        }

        public float getPivotY() {
            return this.e;
        }

        public void setPivotY(float pivotY) {
            if (pivotY != this.e) {
                this.e = pivotY;
                d();
            }
        }

        public float getScaleX() {
            return this.f;
        }

        public void setScaleX(float scaleX) {
            if (scaleX != this.f) {
                this.f = scaleX;
                d();
            }
        }

        public float getScaleY() {
            return this.g;
        }

        public void setScaleY(float scaleY) {
            if (scaleY != this.g) {
                this.g = scaleY;
                d();
            }
        }

        public float getTranslateX() {
            return this.h;
        }

        public void setTranslateX(float translateX) {
            if (translateX != this.h) {
                this.h = translateX;
                d();
            }
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setTranslateY(float translateY) {
            if (translateY != this.i) {
                this.i = translateY;
                d();
            }
        }

        @Override // defpackage.Cif.e
        public boolean a() {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.Cif.e
        public boolean b(int[] stateSet) {
            boolean changed = false;
            for (int i = 0; i < this.b.size(); i++) {
                changed |= this.b.get(i).b(stateSet);
            }
            return changed;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$f */
    /* loaded from: classes.dex */
    public static abstract class f extends e {
        public z7.b[] a;
        public String b;
        public int c;
        public int d;

        public f() {
            super();
            this.a = null;
            this.c = 0;
        }

        public f(f copy) {
            super();
            this.a = null;
            this.c = 0;
            this.b = copy.b;
            this.d = copy.d;
            this.a = z7.f(copy.a);
        }

        public void d(Path path) {
            path.reset();
            z7.b[] bVarArr = this.a;
            if (bVarArr != null) {
                z7.b.e(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.b;
        }

        public boolean c() {
            return false;
        }

        public z7.b[] getPathData() {
            return this.a;
        }

        public void setPathData(z7.b[] nodes) {
            if (!z7.b(this.a, nodes)) {
                this.a = z7.f(nodes);
            } else {
                z7.j(this.a, nodes);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$b */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public b(b copy) {
            super(copy);
        }

        public void e(Resources r, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            boolean hasPathData = w7.j(parser, "pathData");
            if (!hasPathData) {
                return;
            }
            TypedArray a = w7.k(r, theme, attrs, bf.d);
            f(a, parser);
            a.recycle();
        }

        public final void f(TypedArray a, XmlPullParser parser) {
            String pathName = a.getString(0);
            if (pathName != null) {
                this.b = pathName;
            }
            String pathData = a.getString(1);
            if (pathData != null) {
                this.a = z7.d(pathData);
            }
            this.c = w7.g(a, parser, "fillType", 2, 0);
        }

        @Override // defpackage.Cif.f
        public boolean c() {
            return true;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: if$c */
    /* loaded from: classes.dex */
    public static class c extends f {
        public int[] e;
        public r7 f;
        public float g;
        public r7 h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c copy) {
            super(copy);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.e = copy.e;
            this.f = copy.f;
            this.g = copy.g;
            this.i = copy.i;
            this.h = copy.h;
            this.c = copy.c;
            this.j = copy.j;
            this.k = copy.k;
            this.l = copy.l;
            this.m = copy.m;
            this.n = copy.n;
            this.o = copy.o;
            this.p = copy.p;
        }

        public final Paint.Cap e(int id, Paint.Cap defValue) {
            switch (id) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return defValue;
            }
        }

        public final Paint.Join f(int id, Paint.Join defValue) {
            switch (id) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return defValue;
            }
        }

        public void g(Resources r, AttributeSet attrs, Resources.Theme theme, XmlPullParser parser) {
            TypedArray a = w7.k(r, theme, attrs, bf.c);
            h(a, parser, theme);
            a.recycle();
        }

        public final void h(TypedArray a, XmlPullParser parser, Resources.Theme theme) {
            this.e = null;
            boolean hasPathData = w7.j(parser, "pathData");
            if (!hasPathData) {
                return;
            }
            String pathName = a.getString(0);
            if (pathName != null) {
                this.b = pathName;
            }
            String pathData = a.getString(2);
            if (pathData != null) {
                this.a = z7.d(pathData);
            }
            this.h = w7.e(a, parser, theme, "fillColor", 1, 0);
            this.j = w7.f(a, parser, "fillAlpha", 12, this.j);
            int lineCap = w7.g(a, parser, "strokeLineCap", 8, -1);
            this.n = e(lineCap, this.n);
            int lineJoin = w7.g(a, parser, "strokeLineJoin", 9, -1);
            this.o = f(lineJoin, this.o);
            this.p = w7.f(a, parser, "strokeMiterLimit", 10, this.p);
            this.f = w7.e(a, parser, theme, "strokeColor", 3, 0);
            this.i = w7.f(a, parser, "strokeAlpha", 11, this.i);
            this.g = w7.f(a, parser, "strokeWidth", 4, this.g);
            this.l = w7.f(a, parser, "trimPathEnd", 6, this.l);
            this.m = w7.f(a, parser, "trimPathOffset", 7, this.m);
            this.k = w7.f(a, parser, "trimPathStart", 5, this.k);
            this.c = w7.g(a, parser, "fillType", 13, this.c);
        }

        @Override // defpackage.Cif.e
        public boolean a() {
            return this.h.i() || this.f.i();
        }

        @Override // defpackage.Cif.e
        public boolean b(int[] stateSet) {
            boolean changed = this.h.j(stateSet);
            return changed | this.f.j(stateSet);
        }

        public int getStrokeColor() {
            return this.f.e();
        }

        public void setStrokeColor(int strokeColor) {
            this.f.k(strokeColor);
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public void setStrokeWidth(float strokeWidth) {
            this.g = strokeWidth;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public void setStrokeAlpha(float strokeAlpha) {
            this.i = strokeAlpha;
        }

        public int getFillColor() {
            return this.h.e();
        }

        public void setFillColor(int fillColor) {
            this.h.k(fillColor);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public void setFillAlpha(float fillAlpha) {
            this.j = fillAlpha;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setTrimPathStart(float trimPathStart) {
            this.k = trimPathStart;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public void setTrimPathEnd(float trimPathEnd) {
            this.l = trimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public void setTrimPathOffset(float trimPathOffset) {
            this.m = trimPathOffset;
        }
    }
}
