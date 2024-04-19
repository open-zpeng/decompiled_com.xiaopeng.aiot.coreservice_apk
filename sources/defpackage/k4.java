package defpackage;

import com.xiaopeng.libconfig.ipc.AccountConfig;
import defpackage.c4;
import java.util.Arrays;
/* compiled from: SolverVariableValues.java */
/* renamed from: k4  reason: default package */
/* loaded from: classes.dex */
public class k4 implements c4.a {
    public static float a = 0.001f;
    public final int b = -1;
    public int c = 16;
    public int d = 16;
    public int[] e = new int[16];
    public int[] f = new int[16];
    public int[] g = new int[16];
    public float[] h = new float[16];
    public int[] i = new int[16];
    public int[] j = new int[16];
    public int k = 0;
    public int l = -1;
    public final c4 m;
    public final d4 n;

    public k4(c4 row, d4 cache) {
        this.m = row;
        this.n = cache;
        clear();
    }

    @Override // defpackage.c4.a
    public int c() {
        return this.k;
    }

    @Override // defpackage.c4.a
    public j4 h(int index) {
        int count = this.k;
        if (count == 0) {
            return null;
        }
        int j = this.l;
        for (int i = 0; i < count; i++) {
            if (i == index && j != -1) {
                return this.n.d[this.g[j]];
            }
            j = this.j[j];
            if (j == -1) {
                break;
            }
        }
        return null;
    }

    @Override // defpackage.c4.a
    public float a(int index) {
        int count = this.k;
        int j = this.l;
        for (int i = 0; i < count; i++) {
            if (i == index) {
                return this.h[j];
            }
            j = this.j[j];
            if (j == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // defpackage.c4.a
    public boolean e(j4 variable) {
        return p(variable) != -1;
    }

    public int p(j4 variable) {
        int[] iArr;
        if (this.k == 0 || variable == null) {
            return -1;
        }
        int id = variable.j;
        int key = this.e[id % this.d];
        if (key == -1) {
            return -1;
        }
        if (this.g[key] == id) {
            return key;
        }
        while (true) {
            iArr = this.f;
            if (iArr[key] == -1 || this.g[iArr[key]] == id) {
                break;
            }
            key = iArr[key];
        }
        if (iArr[key] != -1 && this.g[iArr[key]] == id) {
            return iArr[key];
        }
        return -1;
    }

    @Override // defpackage.c4.a
    public float d(j4 variable) {
        int index = p(variable);
        if (index != -1) {
            return this.h[index];
        }
        return 0.0f;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int count = this.k;
        for (int i = 0; i < count; i++) {
            j4 v = h(i);
            if (v != null) {
                int index = p(v);
                String str2 = (str + v + " = " + a(i) + " ") + "[p: ";
                String str3 = (this.i[index] != -1 ? str2 + this.n.d[this.g[this.i[index]]] : str2 + AccountConfig.FaceIDRegisterAction.ORIENTATION_NONE) + ", n: ";
                str = (this.j[index] != -1 ? str3 + this.n.d[this.g[this.j[index]]] : str3 + AccountConfig.FaceIDRegisterAction.ORIENTATION_NONE) + "]";
            }
        }
        return str + " }";
    }

    @Override // defpackage.c4.a
    public void clear() {
        int count = this.k;
        for (int i = 0; i < count; i++) {
            j4 v = h(i);
            if (v != null) {
                v.d(this.m);
            }
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            this.g[i2] = -1;
            this.f[i2] = -1;
        }
        for (int i3 = 0; i3 < this.d; i3++) {
            this.e[i3] = -1;
        }
        this.k = 0;
        this.l = -1;
    }

    public final void o() {
        int size = this.c * 2;
        this.g = Arrays.copyOf(this.g, size);
        this.h = Arrays.copyOf(this.h, size);
        this.i = Arrays.copyOf(this.i, size);
        this.j = Arrays.copyOf(this.j, size);
        this.f = Arrays.copyOf(this.f, size);
        for (int i = this.c; i < size; i++) {
            this.g[i] = -1;
            this.f[i] = -1;
        }
        this.c = size;
    }

    public final void l(j4 variable, int index) {
        int[] iArr;
        int hash = variable.j % this.d;
        int[] iArr2 = this.e;
        int key = iArr2[hash];
        if (key == -1) {
            iArr2[hash] = index;
        } else {
            while (true) {
                iArr = this.f;
                if (iArr[key] == -1) {
                    break;
                }
                key = iArr[key];
            }
            iArr[key] = index;
        }
        this.f[index] = -1;
    }

    public final void r(j4 variable) {
        int[] iArr;
        int hash = variable.j % this.d;
        int[] iArr2 = this.e;
        int key = iArr2[hash];
        if (key == -1) {
            return;
        }
        int id = variable.j;
        if (this.g[key] == id) {
            int[] iArr3 = this.f;
            iArr2[hash] = iArr3[key];
            iArr3[key] = -1;
            return;
        }
        while (true) {
            iArr = this.f;
            if (iArr[key] == -1 || this.g[iArr[key]] == id) {
                break;
            }
            key = iArr[key];
        }
        int currentKey = iArr[key];
        if (currentKey != -1 && this.g[currentKey] == id) {
            iArr[key] = iArr[currentKey];
            iArr[currentKey] = -1;
        }
    }

    public final void m(int index, j4 variable, float value) {
        this.g[index] = variable.j;
        this.h[index] = value;
        this.i[index] = -1;
        this.j[index] = -1;
        variable.a(this.m);
        variable.t++;
        this.k++;
    }

    public final int n() {
        for (int i = 0; i < this.c; i++) {
            if (this.g[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public final void q(int index, j4 variable, float value) {
        int availableSlot = n();
        m(availableSlot, variable, value);
        if (index == -1) {
            this.i[availableSlot] = -1;
            if (this.k <= 0) {
                this.j[availableSlot] = -1;
            } else {
                this.j[availableSlot] = this.l;
                this.l = availableSlot;
            }
        } else {
            this.i[availableSlot] = index;
            int[] iArr = this.j;
            iArr[availableSlot] = iArr[index];
            iArr[index] = availableSlot;
        }
        int[] iArr2 = this.j;
        if (iArr2[availableSlot] != -1) {
            this.i[iArr2[availableSlot]] = availableSlot;
        }
        l(variable, availableSlot);
    }

    @Override // defpackage.c4.a
    public void g(j4 variable, float value) {
        float f = a;
        if (value > (-f) && value < f) {
            b(variable, true);
        } else if (this.k == 0) {
            m(0, variable, value);
            l(variable, 0);
            this.l = 0;
        } else {
            int index = p(variable);
            if (index != -1) {
                this.h[index] = value;
                return;
            }
            if (this.k + 1 >= this.c) {
                o();
            }
            int count = this.k;
            int previousItem = -1;
            int j = this.l;
            for (int i = 0; i < count; i++) {
                int[] iArr = this.g;
                int i2 = iArr[j];
                int i3 = variable.j;
                if (i2 == i3) {
                    this.h[j] = value;
                    return;
                }
                if (iArr[j] < i3) {
                    previousItem = j;
                }
                j = this.j[j];
                if (j == -1) {
                    break;
                }
            }
            q(previousItem, variable, value);
        }
    }

    @Override // defpackage.c4.a
    public float b(j4 v, boolean removeFromDefinition) {
        int index = p(v);
        if (index == -1) {
            return 0.0f;
        }
        r(v);
        float value = this.h[index];
        if (this.l == index) {
            this.l = this.j[index];
        }
        this.g[index] = -1;
        int[] iArr = this.i;
        if (iArr[index] != -1) {
            int[] iArr2 = this.j;
            iArr2[iArr[index]] = iArr2[index];
        }
        int[] iArr3 = this.j;
        if (iArr3[index] != -1) {
            iArr[iArr3[index]] = iArr[index];
        }
        this.k--;
        v.t--;
        if (removeFromDefinition) {
            v.d(this.m);
        }
        return value;
    }

    @Override // defpackage.c4.a
    public void i(j4 v, float value, boolean removeFromDefinition) {
        float f = a;
        if (value > (-f) && value < f) {
            return;
        }
        int index = p(v);
        if (index == -1) {
            g(v, value);
            return;
        }
        float[] fArr = this.h;
        fArr[index] = fArr[index] + value;
        float f2 = fArr[index];
        float f3 = a;
        if (f2 > (-f3) && fArr[index] < f3) {
            fArr[index] = 0.0f;
            b(v, removeFromDefinition);
        }
    }

    @Override // defpackage.c4.a
    public float f(c4 def, boolean removeFromDefinition) {
        float value = d(def.a);
        b(def.a, removeFromDefinition);
        k4 definition = (k4) def.e;
        int definitionSize = definition.c();
        int i = definition.l;
        int j = 0;
        int i2 = 0;
        while (j < definitionSize) {
            int[] iArr = definition.g;
            if (iArr[i2] != -1) {
                float definitionValue = definition.h[i2];
                j4 definitionVariable = this.n.d[iArr[i2]];
                i(definitionVariable, definitionValue * value, removeFromDefinition);
                j++;
            }
            i2++;
        }
        return value;
    }

    @Override // defpackage.c4.a
    public void k() {
        int count = this.k;
        int j = this.l;
        for (int i = 0; i < count; i++) {
            float[] fArr = this.h;
            fArr[j] = fArr[j] * (-1.0f);
            j = this.j[j];
            if (j == -1) {
                return;
            }
        }
    }

    @Override // defpackage.c4.a
    public void j(float amount) {
        int count = this.k;
        int j = this.l;
        for (int i = 0; i < count; i++) {
            float[] fArr = this.h;
            fArr[j] = fArr[j] / amount;
            j = this.j[j];
            if (j == -1) {
                return;
            }
        }
    }
}
