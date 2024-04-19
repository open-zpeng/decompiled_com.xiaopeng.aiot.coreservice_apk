package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* renamed from: w0  reason: default package */
/* loaded from: classes.dex */
public class w0 extends MenuInflater {
    public static final Class<?>[] a;
    public static final Class<?>[] b;
    public final Object[] c;
    public final Object[] d;
    public Context e;
    public Object f;

    static {
        Class<?>[] clsArr = {Context.class};
        a = clsArr;
        b = clsArr;
    }

    public w0(Context context) {
        super(context);
        this.e = context;
        Object[] objArr = {context};
        this.c = objArr;
        this.d = objArr;
    }

    @Override // android.view.MenuInflater
    public void inflate(int menuRes, Menu menu) {
        if (!(menu instanceof o8)) {
            super.inflate(menuRes, menu);
            return;
        }
        XmlResourceParser parser = null;
        try {
            try {
                parser = this.e.getResources().getLayout(menuRes);
                AttributeSet attrs = Xml.asAttributeSet(parser);
                parseMenu(parser, attrs, menu);
            } catch (IOException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r4 != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        switch(r1) {
            case 1: goto L56;
            case 2: goto L40;
            case 3: goto L11;
            default: goto L60;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        r8 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r8.equals(r3) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        r2 = false;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r8.equals("group") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
        if (r8.equals("item") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r0.d() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
        r6 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
        if (r6 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
        if (r6.a() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        if (r8.equals("menu") == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
        if (r2 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        r8 = r11.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0094, code lost:
        if (r8.equals("group") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
        r0.f(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r8.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a0, code lost:
        r0.g(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
        if (r8.equals("menu") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
        r6 = r0.b();
        parseMenu(r11, r12, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
        r2 = true;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bc, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bd, code lost:
        r1 = r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c3, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void parseMenu(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            w0$b r0 = new w0$b
            r0.<init>(r13)
            int r1 = r11.getEventType()
            r2 = 0
            r3 = 0
        Lb:
            r4 = 2
            java.lang.String r5 = "menu"
            if (r1 != r4) goto L36
            java.lang.String r4 = r11.getName()
            boolean r6 = r4.equals(r5)
            if (r6 == 0) goto L1f
            int r1 = r11.next()
            goto L3d
        L1f:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Expecting menu, got "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L36:
            int r1 = r11.next()
            r4 = 1
            if (r1 != r4) goto Lb
        L3d:
            r4 = 0
        L3e:
            if (r4 != 0) goto Lc3
            java.lang.String r6 = "item"
            java.lang.String r7 = "group"
            switch(r1) {
                case 1: goto Lb5;
                case 2: goto L89;
                case 3: goto L49;
                default: goto L47;
            }
        L47:
            goto Lbd
        L49:
            java.lang.String r8 = r11.getName()
            if (r2 == 0) goto L59
            boolean r9 = r8.equals(r3)
            if (r9 == 0) goto L59
            r2 = 0
            r3 = 0
            goto Lbd
        L59:
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L63
            r0.h()
            goto Lbd
        L63:
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L81
            boolean r6 = r0.d()
            if (r6 != 0) goto Lbd
            m9 r6 = r0.A
            if (r6 == 0) goto L7d
            boolean r6 = r6.a()
            if (r6 == 0) goto L7d
            r0.b()
            goto Lbd
        L7d:
            r0.a()
            goto Lbd
        L81:
            boolean r6 = r8.equals(r5)
            if (r6 == 0) goto Lbd
            r4 = 1
            goto Lbd
        L89:
            if (r2 == 0) goto L8c
            goto Lbd
        L8c:
            java.lang.String r8 = r11.getName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L9a
            r0.f(r12)
            goto Lbd
        L9a:
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto La4
            r0.g(r12)
            goto Lbd
        La4:
            boolean r6 = r8.equals(r5)
            if (r6 == 0) goto Lb2
            android.view.SubMenu r6 = r0.b()
            r10.parseMenu(r11, r12, r6)
            goto Lbd
        Lb2:
            r2 = 1
            r3 = r8
            goto Lbd
        Lb5:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Unexpected end of document"
            r5.<init>(r6)
            throw r5
        Lbd:
            int r1 = r11.next()
            goto L3e
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.parseMenu(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    public Object getRealOwner() {
        if (this.f == null) {
            this.f = findRealOwner(this.e);
        }
        return this.f;
    }

    public final Object findRealOwner(Object owner) {
        if (owner instanceof Activity) {
            return owner;
        }
        if (owner instanceof ContextWrapper) {
            return findRealOwner(((ContextWrapper) owner).getBaseContext());
        }
        return owner;
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: w0$a */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] a = {MenuItem.class};
        public Object b;
        public Method c;

        public a(Object realOwner, String methodName) {
            this.b = realOwner;
            Class<?> c = realOwner.getClass();
            try {
                this.c = c.getMethod(methodName, a);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, item)).booleanValue();
                }
                this.c.invoke(this.b, item);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: w0$b */
    /* loaded from: classes.dex */
    public class b {
        public m9 A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public Menu a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.a = menu;
            h();
        }

        public void h() {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public void f(AttributeSet attrs) {
            TypedArray a = w0.this.e.obtainStyledAttributes(attrs, w.r1);
            this.b = a.getResourceId(w.t1, 0);
            this.c = a.getInt(w.v1, 0);
            this.d = a.getInt(w.w1, 0);
            this.e = a.getInt(w.x1, 0);
            this.f = a.getBoolean(w.u1, true);
            this.g = a.getBoolean(w.s1, true);
            a.recycle();
        }

        public void g(AttributeSet attrs) {
            z2 a = z2.t(w0.this.e, attrs, w.y1);
            this.i = a.m(w.B1, 0);
            int category = a.j(w.E1, this.c);
            int order = a.j(w.F1, this.d);
            this.j = ((-65536) & category) | (65535 & order);
            this.k = a.o(w.G1);
            this.l = a.o(w.H1);
            this.m = a.m(w.z1, 0);
            this.n = c(a.n(w.I1));
            this.o = a.j(w.P1, 4096);
            this.p = c(a.n(w.J1));
            this.q = a.j(w.T1, 4096);
            int i = w.K1;
            if (a.r(i)) {
                this.r = a.a(i, false) ? 1 : 0;
            } else {
                this.r = this.e;
            }
            this.s = a.a(w.C1, false);
            this.t = a.a(w.D1, this.f);
            this.u = a.a(w.A1, this.g);
            this.v = a.j(w.U1, -1);
            this.z = a.n(w.L1);
            this.w = a.m(w.M1, 0);
            this.x = a.n(w.O1);
            String n = a.n(w.N1);
            this.y = n;
            boolean hasActionProvider = n != null;
            if (hasActionProvider && this.w == 0 && this.x == null) {
                this.A = (m9) e(n, w0.b, w0.this.d);
            } else {
                if (hasActionProvider) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = a.o(w.Q1);
            this.C = a.o(w.V1);
            int i2 = w.S1;
            if (a.r(i2)) {
                this.E = k2.e(a.j(i2, -1), this.E);
            } else {
                this.E = null;
            }
            int i3 = w.R1;
            if (a.r(i3)) {
                this.D = a.c(i3);
            } else {
                this.D = null;
            }
            a.v();
            this.h = false;
        }

        public final char c(String shortcutString) {
            if (shortcutString == null) {
                return (char) 0;
            }
            return shortcutString.charAt(0);
        }

        public final void i(MenuItem item) {
            item.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                item.setShowAsAction(i);
            }
            if (this.z != null) {
                if (w0.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new a(w0.this.getRealOwner(), this.z));
            }
            if (this.r >= 2) {
                if (item instanceof h1) {
                    ((h1) item).s(true);
                } else if (item instanceof i1) {
                    ((i1) item).h(true);
                }
            }
            boolean actionViewSpecified = false;
            String str = this.x;
            if (str != null) {
                View actionView = (View) e(str, w0.a, w0.this.c);
                item.setActionView(actionView);
                actionViewSpecified = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!actionViewSpecified) {
                    item.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            m9 m9Var = this.A;
            if (m9Var != null) {
                t9.a(item, m9Var);
            }
            t9.c(item, this.B);
            t9.g(item, this.C);
            t9.b(item, this.n, this.o);
            t9.f(item, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                t9.e(item, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                t9.d(item, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            i(subMenu.getItem());
            return subMenu;
        }

        public boolean d() {
            return this.h;
        }

        public final <T> T e(String className, Class<?>[] constructorSignature, Object[] arguments) {
            try {
                Class<?> clazz = Class.forName(className, false, w0.this.e.getClassLoader());
                Constructor<?> constructor = clazz.getConstructor(constructorSignature);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(arguments);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + className, e);
                return null;
            }
        }
    }
}
