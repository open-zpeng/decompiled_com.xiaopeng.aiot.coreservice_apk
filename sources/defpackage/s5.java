package defpackage;

import java.util.ArrayList;
/* compiled from: RunGroup.java */
/* renamed from: s5  reason: default package */
/* loaded from: classes.dex */
public class s5 {
    public static int a;
    public v5 d;
    public v5 e;
    public int g;
    public int h;
    public int b = 0;
    public boolean c = false;
    public ArrayList<v5> f = new ArrayList<>();

    public s5(v5 run, int dir) {
        this.d = null;
        this.e = null;
        this.g = 0;
        int i = a;
        this.g = i;
        a = i + 1;
        this.d = run;
        this.e = run;
        this.h = dir;
    }

    public void a(v5 run) {
        this.f.add(run);
        this.e = run;
    }

    public final long d(l5 node, long startPosition) {
        v5 run = node.d;
        if (run instanceof q5) {
            return startPosition;
        }
        long position = startPosition;
        int count = node.k.size();
        for (int i = 0; i < count; i++) {
            j5 dependency = node.k.get(i);
            if (dependency instanceof l5) {
                l5 nextNode = (l5) dependency;
                if (nextNode.d != run) {
                    position = Math.max(position, d(nextNode, nextNode.f + startPosition));
                }
            }
        }
        if (node == run.h) {
            long dimension = run.j();
            return Math.max(Math.max(position, d(run.i, startPosition + dimension)), (startPosition + dimension) - run.i.f);
        }
        return position;
    }

    public final long c(l5 node, long startPosition) {
        v5 run = node.d;
        if (run instanceof q5) {
            return startPosition;
        }
        long position = startPosition;
        int count = node.k.size();
        for (int i = 0; i < count; i++) {
            j5 dependency = node.k.get(i);
            if (dependency instanceof l5) {
                l5 nextNode = (l5) dependency;
                if (nextNode.d != run) {
                    position = Math.min(position, c(nextNode, nextNode.f + startPosition));
                }
            }
        }
        if (node == run.i) {
            long dimension = run.j();
            return Math.min(Math.min(position, c(run.h, startPosition - dimension)), (startPosition - dimension) - run.h.f);
        }
        return position;
    }

    public long b(y4 container, int orientation) {
        v5 v5Var;
        l5 l5Var;
        l5 l5Var2;
        v5 v5Var2;
        v5 v5Var3 = this.d;
        if (v5Var3 instanceof i5) {
            i5 chainRun = (i5) v5Var3;
            if (chainRun.f != orientation) {
                return 0L;
            }
        } else if (orientation == 0) {
            if (!(v5Var3 instanceof r5)) {
                return 0L;
            }
        } else if (!(v5Var3 instanceof t5)) {
            return 0L;
        }
        l5 containerStart = (orientation == 0 ? container.f : container.g).h;
        l5 containerEnd = (orientation == 0 ? container.f : container.g).i;
        boolean runWithStartTarget = v5Var3.h.l.contains(containerStart);
        boolean runWithEndTarget = this.d.i.l.contains(containerEnd);
        long dimension = this.d.j();
        if (runWithStartTarget && runWithEndTarget) {
            long maxPosition = d(this.d.h, 0L);
            long minPosition = c(this.d.i, 0L);
            long endGap = maxPosition - dimension;
            v5 v5Var4 = this.d;
            int i = v5Var4.i.f;
            long maxPosition2 = -i;
            if (endGap >= maxPosition2) {
                endGap += i;
            }
            int i2 = v5Var4.h.f;
            long startGap = ((-minPosition) - dimension) - i2;
            if (startGap >= i2) {
                startGap -= i2;
            }
            float bias = v5Var4.b.q(orientation);
            long gap = 0;
            if (bias > 0.0f) {
                gap = (((float) startGap) / bias) + (((float) endGap) / (1.0f - bias));
            }
            long runDimension = (((float) gap) * bias) + 0.5f + dimension + (((float) gap) * (1.0f - bias)) + 0.5f;
            long gap2 = this.d.h.f;
            return (gap2 + runDimension) - v5Var2.i.f;
        } else if (runWithStartTarget) {
            long maxPosition3 = d(this.d.h, l5Var2.f);
            long runDimension2 = this.d.h.f + dimension;
            return Math.max(maxPosition3, runDimension2);
        } else if (runWithEndTarget) {
            long minPosition2 = c(this.d.i, l5Var.f);
            long runDimension3 = (-this.d.i.f) + dimension;
            return Math.max(-minPosition2, runDimension3);
        } else {
            return (v5Var.h.f + this.d.j()) - this.d.i.f;
        }
    }
}
