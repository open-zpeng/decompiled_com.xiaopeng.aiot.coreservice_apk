package defpackage;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
/* compiled from: AutoScrollHelper.java */
/* renamed from: ya  reason: default package */
/* loaded from: classes.dex */
public abstract class ya implements View.OnTouchListener {
    public static final int a = ViewConfiguration.getTapTimeout();
    public final View f;
    public Runnable g;
    public int j;
    public int k;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final a b = new a();
    public final Interpolator d = new AccelerateInterpolator();
    public float[] h = {0.0f, 0.0f};
    public float[] i = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] l = {0.0f, 0.0f};
    public float[] m = {0.0f, 0.0f};
    public float[] n = {Float.MAX_VALUE, Float.MAX_VALUE};

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    public abstract void j(int i, int i2);

    public ya(View target) {
        this.f = target;
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float f = metrics.density;
        int maxVelocity = (int) ((1575.0f * f) + 0.5f);
        int minVelocity = (int) ((f * 315.0f) + 0.5f);
        o(maxVelocity, maxVelocity);
        p(minVelocity, minVelocity);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(a);
        r(IInputController.KEYCODE_KNOB_WIND_SPD_UP);
        q(IInputController.KEYCODE_KNOB_WIND_SPD_UP);
    }

    public ya m(boolean enabled) {
        if (this.s && !enabled) {
            i();
        }
        this.s = enabled;
        return this;
    }

    public ya o(float horizontalMax, float verticalMax) {
        float[] fArr = this.n;
        fArr[0] = horizontalMax / 1000.0f;
        fArr[1] = verticalMax / 1000.0f;
        return this;
    }

    public ya p(float horizontalMin, float verticalMin) {
        float[] fArr = this.m;
        fArr[0] = horizontalMin / 1000.0f;
        fArr[1] = verticalMin / 1000.0f;
        return this;
    }

    public ya t(float horizontal, float vertical) {
        float[] fArr = this.l;
        fArr[0] = horizontal / 1000.0f;
        fArr[1] = vertical / 1000.0f;
        return this;
    }

    public ya l(int type) {
        this.j = type;
        return this;
    }

    public ya s(float horizontal, float vertical) {
        float[] fArr = this.h;
        fArr[0] = horizontal;
        fArr[1] = vertical;
        return this;
    }

    public ya n(float horizontalMax, float verticalMax) {
        float[] fArr = this.i;
        fArr[0] = horizontalMax;
        fArr[1] = verticalMax;
        return this;
    }

    public ya k(int delayMillis) {
        this.k = delayMillis;
        return this;
    }

    public ya r(int durationMillis) {
        this.b.k(durationMillis);
        return this;
    }

    public ya q(int durationMillis) {
        this.b.j(durationMillis);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (this.s) {
            int action = event.getActionMasked();
            switch (action) {
                case 0:
                    this.q = true;
                    this.o = false;
                    float xTargetVelocity = d(0, event.getX(), v.getWidth(), this.f.getWidth());
                    float yTargetVelocity = d(1, event.getY(), v.getHeight(), this.f.getHeight());
                    this.b.l(xTargetVelocity, yTargetVelocity);
                    if (!this.r && u()) {
                        v();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    i();
                    break;
                case 2:
                    float xTargetVelocity2 = d(0, event.getX(), v.getWidth(), this.f.getWidth());
                    float yTargetVelocity2 = d(1, event.getY(), v.getHeight(), this.f.getHeight());
                    this.b.l(xTargetVelocity2, yTargetVelocity2);
                    if (!this.r) {
                        v();
                        break;
                    }
                    break;
            }
            return this.t && this.r;
        }
        return false;
    }

    public boolean u() {
        a scroller = this.b;
        int verticalDirection = scroller.f();
        int horizontalDirection = scroller.d();
        return (verticalDirection != 0 && b(verticalDirection)) || (horizontalDirection != 0 && a(horizontalDirection));
    }

    public final void v() {
        int i;
        if (this.g == null) {
            this.g = new b();
        }
        this.r = true;
        this.p = true;
        if (!this.o && (i = this.k) > 0) {
            ga.V(this.f, this.g, i);
        } else {
            this.g.run();
        }
        this.o = true;
    }

    public final void i() {
        if (this.p) {
            this.r = false;
        } else {
            this.b.i();
        }
    }

    public final float d(int direction, float coordinate, float srcSize, float dstSize) {
        float relativeEdge = this.h[direction];
        float maximumEdge = this.i[direction];
        float value = h(relativeEdge, srcSize, maximumEdge, coordinate);
        if (value == 0.0f) {
            return 0.0f;
        }
        float relativeVelocity = this.l[direction];
        float minimumVelocity = this.m[direction];
        float maximumVelocity = this.n[direction];
        float targetVelocity = relativeVelocity * dstSize;
        if (value > 0.0f) {
            return e(value * targetVelocity, minimumVelocity, maximumVelocity);
        }
        return -e((-value) * targetVelocity, minimumVelocity, maximumVelocity);
    }

    public final float h(float relativeValue, float size, float maxValue, float current) {
        float interpolated;
        float edgeSize = e(relativeValue * size, 0.0f, maxValue);
        float valueLeading = g(current, edgeSize);
        float valueTrailing = g(size - current, edgeSize);
        float value = valueTrailing - valueLeading;
        if (value < 0.0f) {
            interpolated = -this.d.getInterpolation(-value);
        } else if (value <= 0.0f) {
            return 0.0f;
        } else {
            interpolated = this.d.getInterpolation(value);
        }
        return e(interpolated, -1.0f, 1.0f);
    }

    public final float g(float current, float leading) {
        if (leading == 0.0f) {
            return 0.0f;
        }
        int i = this.j;
        switch (i) {
            case 0:
            case 1:
                if (current < leading) {
                    if (current >= 0.0f) {
                        return 1.0f - (current / leading);
                    }
                    if (this.r && i == 1) {
                        return 1.0f;
                    }
                }
                break;
            case 2:
                if (current < 0.0f) {
                    return current / (-leading);
                }
                break;
        }
        return 0.0f;
    }

    public static int f(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    public static float e(float value, float min, float max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    public void c() {
        long eventTime = SystemClock.uptimeMillis();
        MotionEvent cancel = MotionEvent.obtain(eventTime, eventTime, 3, 0.0f, 0.0f, 0);
        this.f.onTouchEvent(cancel);
        cancel.recycle();
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: ya$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ya yaVar = ya.this;
            if (!yaVar.r) {
                return;
            }
            if (yaVar.p) {
                yaVar.p = false;
                yaVar.b.m();
            }
            a scroller = ya.this.b;
            if (scroller.h() || !ya.this.u()) {
                ya.this.r = false;
                return;
            }
            ya yaVar2 = ya.this;
            if (yaVar2.q) {
                yaVar2.q = false;
                yaVar2.c();
            }
            scroller.a();
            int deltaX = scroller.b();
            int deltaY = scroller.c();
            ya.this.j(deltaX, deltaY);
            ga.U(ya.this.f, this);
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: ya$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public int b;
        public float c;
        public float d;
        public float j;
        public int k;
        public long e = Long.MIN_VALUE;
        public long i = -1;
        public long f = 0;
        public int g = 0;
        public int h = 0;

        public void k(int durationMillis) {
            this.a = durationMillis;
        }

        public void j(int durationMillis) {
            this.b = durationMillis;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.e = currentAnimationTimeMillis;
            this.i = -1L;
            this.f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        public void i() {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            this.k = ya.f((int) (currentTime - this.e), 0, this.b);
            this.j = e(currentTime);
            this.i = currentTime;
        }

        public boolean h() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public final float e(long currentTime) {
            long elapsedSinceEnd = this.e;
            if (currentTime < elapsedSinceEnd) {
                return 0.0f;
            }
            long j = this.i;
            if (j < 0 || currentTime < j) {
                long elapsedSinceStart = currentTime - elapsedSinceEnd;
                return ya.e(((float) elapsedSinceStart) / this.a, 0.0f, 1.0f) * 0.5f;
            }
            long elapsedSinceEnd2 = currentTime - j;
            float f = this.j;
            return (1.0f - f) + (f * ya.e(((float) elapsedSinceEnd2) / this.k, 0.0f, 1.0f));
        }

        public final float g(float value) {
            return ((-4.0f) * value * value) + (4.0f * value);
        }

        public void a() {
            if (this.f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            float value = e(currentTime);
            float scale = g(value);
            long elapsedSinceDelta = currentTime - this.f;
            this.f = currentTime;
            this.g = (int) (((float) elapsedSinceDelta) * scale * this.c);
            this.h = (int) (((float) elapsedSinceDelta) * scale * this.d);
        }

        public void l(float x, float y) {
            this.c = x;
            this.d = y;
        }

        public int d() {
            float f = this.c;
            return (int) (f / Math.abs(f));
        }

        public int f() {
            float f = this.d;
            return (int) (f / Math.abs(f));
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }
    }
}
