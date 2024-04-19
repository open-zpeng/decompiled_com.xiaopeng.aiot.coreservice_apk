package defpackage;

import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.dc;
import defpackage.mc;
import java.io.PrintWriter;
import java.util.ArrayList;
/* compiled from: BackStackRecord.java */
/* renamed from: tb  reason: default package */
/* loaded from: classes.dex */
public final class tb extends mc implements dc.o {
    public final dc t;
    public boolean u;
    public int v;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.v >= 0) {
            sb.append(" #");
            sb.append(this.v);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void n(String prefix, PrintWriter writer) {
        o(prefix, writer, true);
    }

    public void o(String prefix, PrintWriter writer, boolean full) {
        String cmdStr;
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.k);
            writer.print(" mIndex=");
            writer.print(this.v);
            writer.print(" mCommitted=");
            writer.println(this.u);
            if (this.h != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.h));
            }
            if (this.d != 0 || this.e != 0) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.d));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.e));
            }
            if (this.f != 0 || this.g != 0) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.f));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.g));
            }
            if (this.l != 0 || this.m != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.l));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.m);
            }
            if (this.n != 0 || this.o != null) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.n));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.o);
            }
        }
        if (!this.c.isEmpty()) {
            writer.print(prefix);
            writer.println("Operations:");
            int numOps = this.c.size();
            for (int opNum = 0; opNum < numOps; opNum++) {
                mc.a op = this.c.get(opNum);
                switch (op.a) {
                    case 0:
                        cmdStr = "NULL";
                        break;
                    case 1:
                        cmdStr = "ADD";
                        break;
                    case 2:
                        cmdStr = "REPLACE";
                        break;
                    case 3:
                        cmdStr = "REMOVE";
                        break;
                    case 4:
                        cmdStr = "HIDE";
                        break;
                    case 5:
                        cmdStr = "SHOW";
                        break;
                    case 6:
                        cmdStr = "DETACH";
                        break;
                    case 7:
                        cmdStr = "ATTACH";
                        break;
                    case 8:
                        cmdStr = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        cmdStr = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        cmdStr = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        cmdStr = "cmd=" + op.a;
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(opNum);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.b);
                if (full) {
                    if (op.c != 0 || op.d != 0) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.c));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.d));
                    }
                    if (op.e != 0 || op.f != 0) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.e));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.f));
                    }
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public tb(defpackage.dc r3) {
        /*
            r2 = this;
            zb r0 = r3.q0()
            ac r1 = r3.t0()
            if (r1 == 0) goto L17
            ac r1 = r3.t0()
            android.content.Context r1 = r1.k()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L18
        L17:
            r1 = 0
        L18:
            r2.<init>(r0, r1)
            r0 = -1
            r2.v = r0
            r2.t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tb.<init>(dc):void");
    }

    @Override // defpackage.mc
    public void j(int containerViewId, Fragment fragment, String tag, int opcmd) {
        super.j(containerViewId, fragment, tag, opcmd);
        fragment.v = this.t;
    }

    @Override // defpackage.mc
    public mc h(Fragment fragment) {
        dc dcVar = fragment.v;
        if (dcVar != null && dcVar != this.t) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.h(fragment);
    }

    public void l(int amt) {
        if (!this.i) {
            return;
        }
        if (dc.F0(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + amt);
        }
        int numOps = this.c.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            mc.a op = this.c.get(opNum);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.u += amt;
                if (dc.F0(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + op.b + " to " + op.b.u);
                }
            }
        }
    }

    public void x() {
        if (this.s != null) {
            for (int i = 0; i < this.s.size(); i++) {
                this.s.get(i).run();
            }
            this.s = null;
        }
    }

    @Override // defpackage.mc
    public int f() {
        return m(false);
    }

    @Override // defpackage.mc
    public void g() {
        i();
        this.t.b0(this, true);
    }

    public int m(boolean allowStateLoss) {
        if (this.u) {
            throw new IllegalStateException("commit already called");
        }
        if (dc.F0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            rc logw = new rc("FragmentManager");
            PrintWriter pw = new PrintWriter(logw);
            n("  ", pw);
            pw.close();
        }
        this.u = true;
        if (this.i) {
            this.v = this.t.i();
        } else {
            this.v = -1;
        }
        this.t.Y(this, allowStateLoss);
        return this.v;
    }

    @Override // defpackage.dc.o
    public boolean a(ArrayList<tb> arrayList, ArrayList<Boolean> isRecordPop) {
        if (dc.F0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        isRecordPop.add(false);
        if (this.i) {
            this.t.e(this);
            return true;
        }
        return true;
    }

    public boolean t(int containerId) {
        int numOps = this.c.size();
        int opNum = 0;
        while (true) {
            if (opNum >= numOps) {
                return false;
            }
            mc.a op = this.c.get(opNum);
            Fragment fragment = op.b;
            int fragContainer = fragment != null ? fragment.A : 0;
            if (fragContainer == 0 || fragContainer != containerId) {
                opNum++;
            } else {
                return true;
            }
        }
    }

    public boolean u(ArrayList<tb> arrayList, int startIndex, int endIndex) {
        int thatContainer;
        if (endIndex == startIndex) {
            return false;
        }
        int numOps = this.c.size();
        int lastContainer = -1;
        for (int opNum = 0; opNum < numOps; opNum++) {
            mc.a op = this.c.get(opNum);
            Fragment fragment = op.b;
            int container = fragment != null ? fragment.A : 0;
            if (container != 0 && container != lastContainer) {
                lastContainer = container;
                for (int i = startIndex; i < endIndex; i++) {
                    tb record = arrayList.get(i);
                    int numThoseOps = record.c.size();
                    for (int thoseOpIndex = 0; thoseOpIndex < numThoseOps; thoseOpIndex++) {
                        mc.a thatOp = record.c.get(thoseOpIndex);
                        Fragment fragment2 = thatOp.b;
                        if (fragment2 == null) {
                            thatContainer = 0;
                        } else {
                            thatContainer = fragment2.A;
                        }
                        if (thatContainer == container) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
        return false;
    }

    public void p() {
        int numOps = this.c.size();
        for (int opNum = 0; opNum < numOps; opNum++) {
            mc.a op = this.c.get(opNum);
            Fragment f = op.b;
            if (f != null) {
                f.v1(false);
                f.t1(this.h);
                f.x1(this.p, this.q);
            }
            switch (op.a) {
                case 1:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, false);
                    this.t.g(f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.a);
                case 3:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.Y0(f);
                    break;
                case 4:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.C0(f);
                    break;
                case 5:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, false);
                    this.t.j1(f);
                    break;
                case 6:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.x(f);
                    break;
                case 7:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, false);
                    this.t.k(f);
                    break;
                case 8:
                    this.t.h1(f);
                    break;
                case 9:
                    this.t.h1(null);
                    break;
                case 10:
                    this.t.g1(f, op.h);
                    break;
            }
            if (!this.r && op.a != 1 && f != null && !dc.b) {
                this.t.M0(f);
            }
        }
        if (!this.r && !dc.b) {
            dc dcVar = this.t;
            dcVar.N0(dcVar.s, true);
        }
    }

    public void q(boolean moveToState) {
        for (int opNum = this.c.size() - 1; opNum >= 0; opNum--) {
            mc.a op = this.c.get(opNum);
            Fragment f = op.b;
            if (f != null) {
                f.v1(true);
                f.t1(dc.c1(this.h));
                f.x1(this.q, this.p);
            }
            switch (op.a) {
                case 1:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, true);
                    this.t.Y0(f);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.a);
                case 3:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.g(f);
                    break;
                case 4:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.j1(f);
                    break;
                case 5:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, true);
                    this.t.C0(f);
                    break;
                case 6:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.k(f);
                    break;
                case 7:
                    f.o1(op.c, op.d, op.e, op.f);
                    this.t.f1(f, true);
                    this.t.x(f);
                    break;
                case 8:
                    this.t.h1(null);
                    break;
                case 9:
                    this.t.h1(f);
                    break;
                case 10:
                    this.t.g1(f, op.g);
                    break;
            }
            if (!this.r && op.a != 3 && f != null && !dc.b) {
                this.t.M0(f);
            }
        }
        if (!this.r && moveToState && !dc.b) {
            dc dcVar = this.t;
            dcVar.N0(dcVar.s, true);
        }
    }

    public Fragment r(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        int opNum = 0;
        while (opNum < this.c.size()) {
            mc.a op = this.c.get(opNum);
            switch (op.a) {
                case 1:
                case 7:
                    added.add(op.b);
                    break;
                case 2:
                    Fragment f = op.b;
                    int containerId = f.A;
                    boolean alreadyAdded = false;
                    for (int i = added.size() - 1; i >= 0; i--) {
                        Fragment old = added.get(i);
                        if (old.A == containerId) {
                            if (old == f) {
                                alreadyAdded = true;
                            } else {
                                if (old == oldPrimaryNav) {
                                    this.c.add(opNum, new mc.a(9, old));
                                    opNum++;
                                    oldPrimaryNav = null;
                                }
                                mc.a removeOp = new mc.a(3, old);
                                removeOp.c = op.c;
                                removeOp.e = op.e;
                                removeOp.d = op.d;
                                removeOp.f = op.f;
                                this.c.add(opNum, removeOp);
                                added.remove(old);
                                opNum++;
                            }
                        }
                    }
                    if (alreadyAdded) {
                        this.c.remove(opNum);
                        opNum--;
                        break;
                    } else {
                        op.a = 1;
                        added.add(f);
                        break;
                    }
                case 3:
                case 6:
                    added.remove(op.b);
                    Fragment fragment = op.b;
                    if (fragment == oldPrimaryNav) {
                        this.c.add(opNum, new mc.a(9, fragment));
                        opNum++;
                        oldPrimaryNav = null;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    this.c.add(opNum, new mc.a(9, oldPrimaryNav));
                    opNum++;
                    oldPrimaryNav = op.b;
                    break;
            }
            opNum++;
        }
        return oldPrimaryNav;
    }

    public Fragment z(ArrayList<Fragment> added, Fragment oldPrimaryNav) {
        for (int opNum = this.c.size() - 1; opNum >= 0; opNum--) {
            mc.a op = this.c.get(opNum);
            switch (op.a) {
                case 1:
                case 7:
                    added.remove(op.b);
                    break;
                case 3:
                case 6:
                    added.add(op.b);
                    break;
                case 8:
                    oldPrimaryNav = null;
                    break;
                case 9:
                    oldPrimaryNav = op.b;
                    break;
                case 10:
                    op.h = op.g;
                    break;
            }
        }
        return oldPrimaryNav;
    }

    public boolean w() {
        for (int opNum = 0; opNum < this.c.size(); opNum++) {
            mc.a op = this.c.get(opNum);
            if (v(op)) {
                return true;
            }
        }
        return false;
    }

    public void y(Fragment.h listener) {
        for (int opNum = 0; opNum < this.c.size(); opNum++) {
            mc.a op = this.c.get(opNum);
            if (v(op)) {
                op.b.u1(listener);
            }
        }
    }

    public static boolean v(mc.a op) {
        Fragment fragment = op.b;
        return (fragment == null || !fragment.o || fragment.K == null || fragment.D || fragment.C || !fragment.X()) ? false : true;
    }

    public String s() {
        return this.k;
    }
}
