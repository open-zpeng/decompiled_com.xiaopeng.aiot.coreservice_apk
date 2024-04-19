package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: XCircularProgressBgDrawable.java */
/* renamed from: xp  reason: default package */
/* loaded from: classes.dex */
public class xp extends Drawable {
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public Drawable h;
    public int i;
    public float j;
    public float l;
    public Rect a = new Rect();
    public Paint b = new Paint();
    public Rect c = getBounds();
    public RectF d = new RectF(getBounds());
    public boolean k = true;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public xp() {
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setColor(this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs, theme);
        h(r, attrs, theme);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws IOException, XmlPullParserException {
        super.inflate(r, parser, attrs);
        h(r, attrs, null);
    }

    public final void h(Resources resources, AttributeSet attrs, Resources.Theme theme) {
        TypedArray ta;
        if (theme != null) {
            ta = theme.obtainStyledAttributes(attrs, bp.Y0, 0, 0);
        } else {
            ta = resources.obtainAttributes(attrs, bp.Y0);
        }
        int color = ta.getColor(bp.Z0, resources.getColor(uo.x_circular_progress_circle_bg_color, theme));
        this.i = color;
        this.b.setColor(color);
        this.j = ta.getDimension(bp.b1, 0.0f);
        this.l = ta.getDimensionPixelSize(bp.a1, 0);
        this.e = ta.getDrawable(bp.d1);
        this.g = ta.getDrawable(bp.c1);
        this.f = ta.getDrawable(bp.f1);
        this.h = ta.getDrawable(bp.e1);
        ta.recycle();
    }

    public void g(float strokeWidth) {
        this.j = strokeWidth;
    }

    public void f(float inset) {
        this.l = inset;
    }

    public void c(Drawable indicatorPlay) {
        this.e = indicatorPlay;
    }

    public void e(Drawable indicatorStop) {
        this.f = indicatorStop;
    }

    public void b(Drawable indicatorPause) {
        this.g = indicatorPause;
    }

    public void d(Drawable indicatorStart) {
        this.h = indicatorStart;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        int count = canvas.save();
        canvas.drawArc(this.d, 0.0f, 360.0f, false, this.b);
        canvas.restoreToCount(count);
        if (this.k) {
            if (this.m) {
                Drawable drawable2 = this.f;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            } else if (this.n) {
                Drawable drawable3 = this.g;
                if (drawable3 != null) {
                    drawable3.draw(canvas);
                }
            } else if (this.o) {
                Drawable drawable4 = this.e;
                if (drawable4 != null) {
                    drawable4.draw(canvas);
                }
            } else if (this.p && (drawable = this.h) != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.b.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        a(this.e, this.a);
        a(this.g, this.a);
        a(this.f, this.a);
        a(this.h, this.a);
        if (this.j == 0.0f) {
            this.j = (this.c.width() * 1.0f) / 10.0f;
        }
        float borderInset = this.j / 2.0f;
        this.d.set(bounds);
        RectF rectF = this.d;
        float f = this.l;
        rectF.inset(f + borderInset, f + borderInset);
        this.b.setStrokeWidth(this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] state) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setState(state);
        }
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setState(state);
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null) {
            drawable3.setState(state);
        }
        Drawable drawable4 = this.f;
        if (drawable4 != null) {
            drawable4.setState(state);
        }
        boolean playingStop = false;
        boolean playingPause = false;
        boolean paused = false;
        boolean startDownload = false;
        int length = state.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int s = state[i];
            if (s == to.progress_state_playing_stop) {
                playingStop = true;
                break;
            } else if (s == to.progress_state_playing_pause) {
                playingPause = true;
                break;
            } else if (s == to.progress_state_paused) {
                paused = true;
                break;
            } else {
                if (s == to.progress_state_start_download) {
                    startDownload = true;
                }
                i++;
            }
        }
        boolean changed = false;
        if (playingStop != this.m) {
            this.m = playingStop;
            changed = true;
        }
        if (playingPause != this.n) {
            this.n = playingPause;
            changed = true;
        }
        if (paused != this.o) {
            this.o = paused;
            changed = true;
        }
        if (startDownload != this.p) {
            this.p = startDownload;
            changed = true;
        }
        if (changed) {
            if (this.m || this.n || this.o || this.p) {
                z = true;
            }
            this.k = z;
            return true;
        }
        return super.onStateChange(state);
    }

    public final void a(Drawable drawable, Rect outBounds) {
        if (drawable == null || outBounds == null) {
            return;
        }
        Rect bounds = getBounds();
        float totalWidth = bounds.width();
        float totalHeight = bounds.height();
        float width = drawable.getIntrinsicWidth();
        float height = drawable.getIntrinsicHeight();
        if (width >= totalWidth || height >= totalHeight) {
            outBounds.set(bounds);
            drawable.setBounds(outBounds);
            return;
        }
        int left = Math.round(bounds.left + ((totalWidth - width) / 2.0f));
        int top = Math.round(bounds.top + ((totalHeight - height) / 2.0f));
        int right = Math.round(width) + left;
        int bottom = Math.round(height) + top;
        outBounds.set(left, top, right, bottom);
        drawable.setBounds(outBounds);
    }
}
