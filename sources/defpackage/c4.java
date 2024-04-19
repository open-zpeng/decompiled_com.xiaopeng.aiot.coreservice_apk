package defpackage;

import defpackage.e4;
import defpackage.j4;
import java.util.ArrayList;
/* compiled from: ArrayRow.java */
/* renamed from: c4  reason: default package */
/* loaded from: classes.dex */
public class c4 implements e4.a {
    public a e;
    public j4 a = null;
    public float b = 0.0f;
    public boolean c = false;
    public ArrayList<j4> d = new ArrayList<>();
    public boolean f = false;

    /* compiled from: ArrayRow.java */
    /* renamed from: c4$a */
    /* loaded from: classes.dex */
    public interface a {
        float a(int i);

        float b(j4 j4Var, boolean z);

        int c();

        void clear();

        float d(j4 j4Var);

        boolean e(j4 j4Var);

        float f(c4 c4Var, boolean z);

        void g(j4 j4Var, float f);

        j4 h(int i);

        void i(j4 j4Var, float f, boolean z);

        void j(float f);

        void k();
    }

    public c4() {
    }

    public c4(d4 cache) {
        this.e = new b4(this, cache);
    }

    public boolean s() {
        j4 j4Var = this.a;
        return j4Var != null && (j4Var.q == j4.a.UNRESTRICTED || this.b >= 0.0f);
    }

    public String toString() {
        return z();
    }

    public String z() {
        String s = (this.a == null ? "0" : "" + this.a) + " = ";
        boolean addedVariable = false;
        if (this.b != 0.0f) {
            s = s + this.b;
            addedVariable = true;
        }
        int count = this.e.c();
        for (int i = 0; i < count; i++) {
            j4 v = this.e.h(i);
            if (v != null) {
                float amount = this.e.a(i);
                if (amount != 0.0f) {
                    String name = v.toString();
                    if (!addedVariable) {
                        if (amount < 0.0f) {
                            s = s + "- ";
                            amount *= -1.0f;
                        }
                    } else if (amount > 0.0f) {
                        s = s + " + ";
                    } else {
                        s = s + " - ";
                        amount *= -1.0f;
                    }
                    s = amount == 1.0f ? s + name : s + amount + " " + name;
                    addedVariable = true;
                }
            }
        }
        if (!addedVariable) {
            return s + "0.0";
        }
        return s;
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    public boolean t(j4 v) {
        return this.e.e(v);
    }

    public c4 i(j4 variable, int value) {
        this.a = variable;
        variable.m = value;
        this.b = value;
        this.f = true;
        return this;
    }

    public c4 m(j4 variable, int value) {
        if (value < 0) {
            this.b = value * (-1);
            this.e.g(variable, 1.0f);
        } else {
            this.b = value;
            this.e.g(variable, -1.0f);
        }
        return this;
    }

    public c4 n(j4 variableA, j4 variableB, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.b = m;
        }
        if (!inverse) {
            this.e.g(variableA, -1.0f);
            this.e.g(variableB, 1.0f);
        } else {
            this.e.g(variableA, 1.0f);
            this.e.g(variableB, -1.0f);
        }
        return this;
    }

    public c4 e(j4 error, int sign) {
        this.e.g(error, sign);
        return this;
    }

    public c4 o(j4 variableA, j4 variableB, j4 slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.b = m;
        }
        if (!inverse) {
            this.e.g(variableA, -1.0f);
            this.e.g(variableB, 1.0f);
            this.e.g(slack, 1.0f);
        } else {
            this.e.g(variableA, 1.0f);
            this.e.g(variableB, -1.0f);
            this.e.g(slack, -1.0f);
        }
        return this;
    }

    public c4 p(j4 variableA, j4 variableB, j4 slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.b = m;
        }
        if (!inverse) {
            this.e.g(variableA, -1.0f);
            this.e.g(variableB, 1.0f);
            this.e.g(slack, -1.0f);
        } else {
            this.e.g(variableA, 1.0f);
            this.e.g(variableB, -1.0f);
            this.e.g(slack, 1.0f);
        }
        return this;
    }

    public c4 l(float currentWeight, float totalWeights, float nextWeight, j4 variableStartA, j4 variableEndA, j4 variableStartB, j4 variableEndB) {
        this.b = 0.0f;
        if (totalWeights == 0.0f || currentWeight == nextWeight) {
            this.e.g(variableStartA, 1.0f);
            this.e.g(variableEndA, -1.0f);
            this.e.g(variableEndB, 1.0f);
            this.e.g(variableStartB, -1.0f);
        } else if (currentWeight == 0.0f) {
            this.e.g(variableStartA, 1.0f);
            this.e.g(variableEndA, -1.0f);
        } else if (nextWeight == 0.0f) {
            this.e.g(variableStartB, 1.0f);
            this.e.g(variableEndB, -1.0f);
        } else {
            float cw = currentWeight / totalWeights;
            float nw = nextWeight / totalWeights;
            float w = cw / nw;
            this.e.g(variableStartA, 1.0f);
            this.e.g(variableEndA, -1.0f);
            this.e.g(variableEndB, w);
            this.e.g(variableStartB, -w);
        }
        return this;
    }

    public c4 h(j4 variableA, j4 variableB, int marginA, float bias, j4 variableC, j4 variableD, int marginB) {
        if (variableB == variableC) {
            this.e.g(variableA, 1.0f);
            this.e.g(variableD, 1.0f);
            this.e.g(variableB, -2.0f);
            return this;
        }
        if (bias == 0.5f) {
            this.e.g(variableA, 1.0f);
            this.e.g(variableB, -1.0f);
            this.e.g(variableC, -1.0f);
            this.e.g(variableD, 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.b = (-marginA) + marginB;
            }
        } else if (bias <= 0.0f) {
            this.e.g(variableA, -1.0f);
            this.e.g(variableB, 1.0f);
            this.b = marginA;
        } else if (bias < 1.0f) {
            this.e.g(variableA, (1.0f - bias) * 1.0f);
            this.e.g(variableB, (1.0f - bias) * (-1.0f));
            this.e.g(variableC, (-1.0f) * bias);
            this.e.g(variableD, bias * 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.b = ((-marginA) * (1.0f - bias)) + (marginB * bias);
            }
        } else {
            this.e.g(variableD, -1.0f);
            this.e.g(variableC, 1.0f);
            this.b = -marginB;
        }
        return this;
    }

    public c4 d(e4 system, int strength) {
        this.e.g(system.o(strength, "ep"), 1.0f);
        this.e.g(system.o(strength, "em"), -1.0f);
        return this;
    }

    public c4 j(j4 variableA, j4 variableC, float percent) {
        this.e.g(variableA, -1.0f);
        this.e.g(variableC, percent);
        return this;
    }

    public c4 k(j4 variableA, j4 variableB, j4 variableC, j4 variableD, float ratio) {
        this.e.g(variableA, -1.0f);
        this.e.g(variableB, 1.0f);
        this.e.g(variableC, ratio);
        this.e.g(variableD, -ratio);
        return this;
    }

    public c4 q(j4 at, j4 ab, j4 bt, j4 bb, float angleComponent) {
        this.e.g(bt, 0.5f);
        this.e.g(bb, 0.5f);
        this.e.g(at, -0.5f);
        this.e.g(ab, -0.5f);
        this.b = -angleComponent;
        return this;
    }

    public void r() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.e.k();
        }
    }

    public boolean f(e4 system) {
        boolean addedExtra = false;
        j4 pivotCandidate = g(system);
        if (pivotCandidate == null) {
            addedExtra = true;
        } else {
            x(pivotCandidate);
        }
        if (this.e.c() == 0) {
            this.f = true;
        }
        return addedExtra;
    }

    public j4 g(e4 system) {
        j4 restrictedCandidate = null;
        j4 unrestrictedCandidate = null;
        float unrestrictedCandidateAmount = 0.0f;
        float restrictedCandidateAmount = 0.0f;
        boolean unrestrictedCandidateIsNew = false;
        boolean restrictedCandidateIsNew = false;
        int currentSize = this.e.c();
        for (int i = 0; i < currentSize; i++) {
            float amount = this.e.a(i);
            j4 variable = this.e.h(i);
            if (variable.q == j4.a.UNRESTRICTED) {
                if (unrestrictedCandidate == null) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = u(variable, system);
                } else if (unrestrictedCandidateAmount > amount) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = u(variable, system);
                } else if (!unrestrictedCandidateIsNew && u(variable, system)) {
                    unrestrictedCandidate = variable;
                    unrestrictedCandidateAmount = amount;
                    unrestrictedCandidateIsNew = true;
                }
            } else if (unrestrictedCandidate == null && amount < 0.0f) {
                if (restrictedCandidate == null) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = u(variable, system);
                } else if (restrictedCandidateAmount > amount) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = u(variable, system);
                } else if (!restrictedCandidateIsNew && u(variable, system)) {
                    restrictedCandidate = variable;
                    restrictedCandidateAmount = amount;
                    restrictedCandidateIsNew = true;
                }
            }
        }
        if (unrestrictedCandidate != null) {
            return unrestrictedCandidate;
        }
        return restrictedCandidate;
    }

    public final boolean u(j4 variable, e4 system) {
        return variable.t <= 1;
    }

    public void x(j4 v) {
        j4 j4Var = this.a;
        if (j4Var != null) {
            this.e.g(j4Var, -1.0f);
            this.a.k = -1;
            this.a = null;
        }
        float amount = this.e.b(v, true) * (-1.0f);
        this.a = v;
        if (amount == 1.0f) {
            return;
        }
        this.b /= amount;
        this.e.j(amount);
    }

    @Override // defpackage.e4.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.c() == 0;
    }

    public void B(e4 system, c4 definition, boolean removeFromDefinition) {
        float value = this.e.f(definition, removeFromDefinition);
        this.b += definition.b * value;
        if (removeFromDefinition) {
            definition.a.d(this);
        }
        if (e4.c && this.a != null && this.e.c() == 0) {
            this.f = true;
            system.k = true;
        }
    }

    public void A(e4 system, j4 variable, boolean removeFromDefinition) {
        if (variable == null || !variable.n) {
            return;
        }
        float value = this.e.d(variable);
        this.b += variable.m * value;
        this.e.b(variable, removeFromDefinition);
        if (removeFromDefinition) {
            variable.d(this);
        }
        if (e4.c && this.e.c() == 0) {
            this.f = true;
            system.k = true;
        }
    }

    public void C(e4 system, j4 variable, boolean removeFromDefinition) {
        if (variable == null || !variable.u) {
            return;
        }
        float value = this.e.d(variable);
        this.b += variable.w * value;
        this.e.b(variable, removeFromDefinition);
        if (removeFromDefinition) {
            variable.d(this);
        }
        this.e.i(system.x.d[variable.v], value, removeFromDefinition);
        if (e4.c && this.e.c() == 0) {
            this.f = true;
            system.k = true;
        }
    }

    public final j4 w(boolean[] avoid, j4 exclude) {
        float value = 0.0f;
        j4 pivot = null;
        j4 pivotSlack = null;
        float valueSlack = 0.0f;
        int currentSize = this.e.c();
        for (int i = 0; i < currentSize; i++) {
            float currentValue = this.e.a(i);
            if (currentValue < 0.0f) {
                j4 v = this.e.h(i);
                if ((avoid == null || !avoid[v.j]) && v != exclude) {
                    if (1 != 0) {
                        j4.a aVar = v.q;
                        if ((aVar == j4.a.SLACK || aVar == j4.a.ERROR) && currentValue < value) {
                            value = currentValue;
                            pivot = v;
                        }
                    } else {
                        j4.a aVar2 = v.q;
                        if (aVar2 == j4.a.SLACK) {
                            if (currentValue < valueSlack) {
                                valueSlack = currentValue;
                                pivotSlack = v;
                            }
                        } else if (aVar2 == j4.a.ERROR && currentValue < value) {
                            value = currentValue;
                            pivot = v;
                        }
                    }
                }
            }
        }
        if (1 != 0) {
            return pivot;
        }
        return pivot != null ? pivot : pivotSlack;
    }

    public j4 v(j4 exclude) {
        return w(null, exclude);
    }

    @Override // defpackage.e4.a
    public j4 a(e4 system, boolean[] avoid) {
        return w(avoid, null);
    }

    @Override // defpackage.e4.a
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    @Override // defpackage.e4.a
    public void c(e4.a row) {
        if (row instanceof c4) {
            c4 copiedRow = (c4) row;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < copiedRow.e.c(); i++) {
                j4 var = copiedRow.e.h(i);
                float val = copiedRow.e.a(i);
                this.e.i(var, val, true);
            }
        }
    }

    @Override // defpackage.e4.a
    public void b(j4 error) {
        float weight = 1.0f;
        int i = error.l;
        if (i == 1) {
            weight = 1.0f;
        } else if (i == 2) {
            weight = 1000.0f;
        } else if (i == 3) {
            weight = 1000000.0f;
        } else if (i == 4) {
            weight = 1.0E9f;
        } else if (i == 5) {
            weight = 1.0E12f;
        }
        this.e.g(error, weight);
    }

    @Override // defpackage.e4.a
    public j4 getKey() {
        return this.a;
    }

    public void D(e4 system) {
        if (system.q.length == 0) {
            return;
        }
        boolean done = false;
        while (!done) {
            int currentSize = this.e.c();
            for (int i = 0; i < currentSize; i++) {
                j4 variable = this.e.h(i);
                if (variable.k != -1 || variable.n || variable.u) {
                    this.d.add(variable);
                }
            }
            int size = this.d.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    j4 variable2 = this.d.get(i2);
                    if (variable2.n) {
                        A(system, variable2, true);
                    } else if (!variable2.u) {
                        B(system, system.q[variable2.k], true);
                    } else {
                        C(system, variable2, true);
                    }
                }
                this.d.clear();
            } else {
                done = true;
            }
        }
        if (e4.c && this.a != null && this.e.c() == 0) {
            this.f = true;
            system.k = true;
        }
    }
}
