package defpackage;

import defpackage.c4;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: PriorityGoalRow.java */
/* renamed from: i4  reason: default package */
/* loaded from: classes.dex */
public class i4 extends c4 {
    public int g;
    public j4[] h;
    public j4[] i;
    public int j;
    public b k;
    public d4 l;

    /* compiled from: PriorityGoalRow.java */
    /* renamed from: i4$b */
    /* loaded from: classes.dex */
    public class b {
        public j4 a;
        public i4 b;

        public b(i4 row) {
            this.b = row;
        }

        public void b(j4 variable) {
            this.a = variable;
        }

        public boolean a(j4 other, float value) {
            if (this.a.h) {
                boolean empty = true;
                for (int i = 0; i < 9; i++) {
                    float[] fArr = this.a.p;
                    fArr[i] = fArr[i] + (other.p[i] * value);
                    if (Math.abs(fArr[i]) < 1.0E-4f) {
                        this.a.p[i] = 0.0f;
                    } else {
                        empty = false;
                    }
                }
                if (empty) {
                    i4.this.G(this.a);
                    return false;
                }
                return false;
            }
            for (int i2 = 0; i2 < 9; i2++) {
                float strength = other.p[i2];
                if (strength != 0.0f) {
                    float v = value * strength;
                    if (Math.abs(v) < 1.0E-4f) {
                        v = 0.0f;
                    }
                    this.a.p[i2] = v;
                } else {
                    this.a.p[i2] = 0.0f;
                }
            }
            return true;
        }

        public final boolean c() {
            for (int i = 8; i >= 0; i--) {
                float value = this.a.p[i];
                if (value > 0.0f) {
                    return false;
                }
                if (value < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(j4 other) {
            for (int i = 8; i >= 0; i--) {
                float comparedValue = other.p[i];
                float value = this.a.p[i];
                if (value != comparedValue) {
                    return value < comparedValue;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.a.p, 0.0f);
        }

        public String toString() {
            String result = "[ ";
            if (this.a != null) {
                for (int i = 0; i < 9; i++) {
                    result = result + this.a.p[i] + " ";
                }
            }
            return result + "] " + this.a;
        }
    }

    @Override // defpackage.c4, defpackage.e4.a
    public void clear() {
        this.j = 0;
        this.b = 0.0f;
    }

    public i4(d4 cache) {
        super(cache);
        this.g = 128;
        this.h = new j4[128];
        this.i = new j4[128];
        this.j = 0;
        this.k = new b(this);
        this.l = cache;
    }

    @Override // defpackage.c4, defpackage.e4.a
    public boolean isEmpty() {
        return this.j == 0;
    }

    @Override // defpackage.c4, defpackage.e4.a
    public j4 a(e4 system, boolean[] avoid) {
        int pivot = -1;
        for (int i = 0; i < this.j; i++) {
            j4 variable = this.h[i];
            if (!avoid[variable.j]) {
                this.k.b(variable);
                if (pivot == -1) {
                    if (this.k.c()) {
                        pivot = i;
                    }
                } else if (this.k.d(this.h[pivot])) {
                    pivot = i;
                }
            }
        }
        if (pivot == -1) {
            return null;
        }
        return this.h[pivot];
    }

    @Override // defpackage.c4, defpackage.e4.a
    public void b(j4 error) {
        this.k.b(error);
        this.k.e();
        error.p[error.l] = 1.0f;
        F(error);
    }

    public final void F(j4 variable) {
        int i;
        int i2 = this.j + 1;
        j4[] j4VarArr = this.h;
        if (i2 > j4VarArr.length) {
            j4[] j4VarArr2 = (j4[]) Arrays.copyOf(j4VarArr, j4VarArr.length * 2);
            this.h = j4VarArr2;
            this.i = (j4[]) Arrays.copyOf(j4VarArr2, j4VarArr2.length * 2);
        }
        j4[] j4VarArr3 = this.h;
        int i3 = this.j;
        j4VarArr3[i3] = variable;
        int i4 = i3 + 1;
        this.j = i4;
        if (i4 > 1 && j4VarArr3[i4 - 1].j > variable.j) {
            int i5 = 0;
            while (true) {
                i = this.j;
                if (i5 >= i) {
                    break;
                }
                this.i[i5] = this.h[i5];
                i5++;
            }
            Arrays.sort(this.i, 0, i, new a());
            for (int i6 = 0; i6 < this.j; i6++) {
                this.h[i6] = this.i[i6];
            }
        }
        variable.h = true;
        variable.a(this);
    }

    /* compiled from: PriorityGoalRow.java */
    /* renamed from: i4$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<j4> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(j4 variable1, j4 variable2) {
            return variable1.j - variable2.j;
        }
    }

    public final void G(j4 variable) {
        for (int i = 0; i < this.j; i++) {
            if (this.h[i] == variable) {
                int j = i;
                while (true) {
                    int i2 = this.j;
                    if (j < i2 - 1) {
                        j4[] j4VarArr = this.h;
                        j4VarArr[j] = j4VarArr[j + 1];
                        j++;
                    } else {
                        this.j = i2 - 1;
                        variable.h = false;
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.c4
    public void B(e4 system, c4 definition, boolean removeFromDefinition) {
        j4 goalVariable = definition.a;
        if (goalVariable == null) {
            return;
        }
        c4.a rowVariables = definition.e;
        int currentSize = rowVariables.c();
        for (int i = 0; i < currentSize; i++) {
            j4 solverVariable = rowVariables.h(i);
            float value = rowVariables.a(i);
            this.k.b(solverVariable);
            if (this.k.a(goalVariable, value)) {
                F(solverVariable);
            }
            this.b += definition.b * value;
        }
        G(goalVariable);
    }

    @Override // defpackage.c4
    public String toString() {
        String result = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.j; i++) {
            j4 v = this.h[i];
            this.k.b(v);
            result = result + this.k + " ";
        }
        return result;
    }
}
