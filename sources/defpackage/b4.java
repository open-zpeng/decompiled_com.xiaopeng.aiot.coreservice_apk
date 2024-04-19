package defpackage;

import defpackage.c4;
import java.util.Arrays;
/* compiled from: ArrayLinkedVariables.java */
/* renamed from: b4  reason: default package */
/* loaded from: classes.dex */
public class b4 implements c4.a {
    public static float a = 0.001f;
    public final c4 c;
    public final d4 d;
    public int b = 0;
    public int e = 8;
    public j4 f = null;
    public int[] g = new int[8];
    public int[] h = new int[8];
    public float[] i = new float[8];
    public int j = -1;
    public int k = -1;
    public boolean l = false;

    public b4(c4 arrayRow, d4 cache) {
        this.c = arrayRow;
        this.d = cache;
    }

    @Override // defpackage.c4.a
    public final void g(j4 variable, float value) {
        if (value == 0.0f) {
            b(variable, true);
        } else if (this.j == -1) {
            this.j = 0;
            this.i[0] = value;
            this.g[0] = variable.j;
            this.h[0] = -1;
            variable.t++;
            variable.a(this.c);
            this.b++;
            if (!this.l) {
                int i = this.k + 1;
                this.k = i;
                int[] iArr = this.g;
                if (i >= iArr.length) {
                    this.l = true;
                    this.k = iArr.length - 1;
                }
            }
        } else {
            int current = this.j;
            int previous = -1;
            for (int counter = 0; current != -1 && counter < this.b; counter++) {
                int[] iArr2 = this.g;
                int i2 = iArr2[current];
                int i3 = variable.j;
                if (i2 == i3) {
                    this.i[current] = value;
                    return;
                }
                if (iArr2[current] < i3) {
                    previous = current;
                }
                current = this.h[current];
            }
            int i4 = this.k;
            int availableIndice = i4 + 1;
            if (this.l) {
                int[] iArr3 = this.g;
                if (iArr3[i4] == -1) {
                    availableIndice = this.k;
                } else {
                    availableIndice = iArr3.length;
                }
            }
            int[] iArr4 = this.g;
            if (availableIndice >= iArr4.length && this.b < iArr4.length) {
                int i5 = 0;
                while (true) {
                    int[] iArr5 = this.g;
                    if (i5 < iArr5.length) {
                        if (iArr5[i5] != -1) {
                            i5++;
                        } else {
                            availableIndice = i5;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            int[] iArr6 = this.g;
            if (availableIndice >= iArr6.length) {
                availableIndice = iArr6.length;
                int i6 = this.e * 2;
                this.e = i6;
                this.l = false;
                this.k = availableIndice - 1;
                this.i = Arrays.copyOf(this.i, i6);
                this.g = Arrays.copyOf(this.g, this.e);
                this.h = Arrays.copyOf(this.h, this.e);
            }
            this.g[availableIndice] = variable.j;
            this.i[availableIndice] = value;
            if (previous != -1) {
                int[] iArr7 = this.h;
                iArr7[availableIndice] = iArr7[previous];
                iArr7[previous] = availableIndice;
            } else {
                this.h[availableIndice] = this.j;
                this.j = availableIndice;
            }
            variable.t++;
            variable.a(this.c);
            int i7 = this.b + 1;
            this.b = i7;
            if (!this.l) {
                this.k++;
            }
            int[] iArr8 = this.g;
            if (i7 >= iArr8.length) {
                this.l = true;
            }
            if (this.k >= iArr8.length) {
                this.l = true;
                this.k = iArr8.length - 1;
            }
        }
    }

    @Override // defpackage.c4.a
    public void i(j4 variable, float value, boolean removeFromDefinition) {
        float f = a;
        if (value > (-f) && value < f) {
            return;
        }
        if (this.j == -1) {
            this.j = 0;
            this.i[0] = value;
            this.g[0] = variable.j;
            this.h[0] = -1;
            variable.t++;
            variable.a(this.c);
            this.b++;
            if (!this.l) {
                int i = this.k + 1;
                this.k = i;
                int[] iArr = this.g;
                if (i >= iArr.length) {
                    this.l = true;
                    this.k = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int current = this.j;
        int previous = -1;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            int[] iArr2 = this.g;
            int idx = iArr2[current];
            int i2 = variable.j;
            if (idx == i2) {
                float[] fArr = this.i;
                float v = fArr[current] + value;
                float f2 = a;
                if (v > (-f2) && v < f2) {
                    v = 0.0f;
                }
                fArr[current] = v;
                if (v == 0.0f) {
                    if (current == this.j) {
                        this.j = this.h[current];
                    } else {
                        int[] iArr3 = this.h;
                        iArr3[previous] = iArr3[current];
                    }
                    if (removeFromDefinition) {
                        variable.d(this.c);
                    }
                    if (this.l) {
                        this.k = current;
                    }
                    variable.t--;
                    this.b--;
                    return;
                }
                return;
            }
            if (iArr2[current] < i2) {
                previous = current;
            }
            current = this.h[current];
        }
        int i3 = this.k;
        int availableIndice = i3 + 1;
        if (this.l) {
            int[] iArr4 = this.g;
            if (iArr4[i3] == -1) {
                availableIndice = this.k;
            } else {
                availableIndice = iArr4.length;
            }
        }
        int[] iArr5 = this.g;
        if (availableIndice >= iArr5.length && this.b < iArr5.length) {
            int i4 = 0;
            while (true) {
                int[] iArr6 = this.g;
                if (i4 < iArr6.length) {
                    if (iArr6[i4] != -1) {
                        i4++;
                    } else {
                        availableIndice = i4;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        int[] iArr7 = this.g;
        if (availableIndice >= iArr7.length) {
            availableIndice = iArr7.length;
            int i5 = this.e * 2;
            this.e = i5;
            this.l = false;
            this.k = availableIndice - 1;
            this.i = Arrays.copyOf(this.i, i5);
            this.g = Arrays.copyOf(this.g, this.e);
            this.h = Arrays.copyOf(this.h, this.e);
        }
        this.g[availableIndice] = variable.j;
        this.i[availableIndice] = value;
        if (previous != -1) {
            int[] iArr8 = this.h;
            iArr8[availableIndice] = iArr8[previous];
            iArr8[previous] = availableIndice;
        } else {
            this.h[availableIndice] = this.j;
            this.j = availableIndice;
        }
        variable.t++;
        variable.a(this.c);
        this.b++;
        if (!this.l) {
            this.k++;
        }
        int i6 = this.k;
        int[] iArr9 = this.g;
        if (i6 >= iArr9.length) {
            this.l = true;
            this.k = iArr9.length - 1;
        }
    }

    @Override // defpackage.c4.a
    public float f(c4 definition, boolean removeFromDefinition) {
        float value = d(definition.a);
        b(definition.a, removeFromDefinition);
        c4.a definitionVariables = definition.e;
        int definitionSize = definitionVariables.c();
        for (int i = 0; i < definitionSize; i++) {
            j4 definitionVariable = definitionVariables.h(i);
            float definitionValue = definitionVariables.d(definitionVariable);
            i(definitionVariable, definitionValue * value, removeFromDefinition);
        }
        return value;
    }

    @Override // defpackage.c4.a
    public final float b(j4 variable, boolean removeFromDefinition) {
        if (this.f == variable) {
            this.f = null;
        }
        if (this.j == -1) {
            return 0.0f;
        }
        int current = this.j;
        int previous = -1;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            int idx = this.g[current];
            if (idx == variable.j) {
                if (current == this.j) {
                    this.j = this.h[current];
                } else {
                    int[] iArr = this.h;
                    iArr[previous] = iArr[current];
                }
                if (removeFromDefinition) {
                    variable.d(this.c);
                }
                variable.t--;
                this.b--;
                this.g[current] = -1;
                if (this.l) {
                    this.k = current;
                }
                return this.i[current];
            }
            previous = current;
            current = this.h[current];
        }
        return 0.0f;
    }

    @Override // defpackage.c4.a
    public final void clear() {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            j4 variable = this.d.d[this.g[current]];
            if (variable != null) {
                variable.d(this.c);
            }
            current = this.h[current];
        }
        this.j = -1;
        this.k = -1;
        this.l = false;
        this.b = 0;
    }

    @Override // defpackage.c4.a
    public boolean e(j4 variable) {
        if (this.j == -1) {
            return false;
        }
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            if (this.g[current] == variable.j) {
                return true;
            }
            current = this.h[current];
        }
        return false;
    }

    @Override // defpackage.c4.a
    public void k() {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            float[] fArr = this.i;
            fArr[current] = fArr[current] * (-1.0f);
            current = this.h[current];
        }
    }

    @Override // defpackage.c4.a
    public void j(float amount) {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            float[] fArr = this.i;
            fArr[current] = fArr[current] / amount;
            current = this.h[current];
        }
    }

    @Override // defpackage.c4.a
    public int c() {
        return this.b;
    }

    @Override // defpackage.c4.a
    public j4 h(int index) {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            if (counter == index) {
                return this.d.d[this.g[current]];
            }
            current = this.h[current];
        }
        return null;
    }

    @Override // defpackage.c4.a
    public float a(int index) {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            if (counter == index) {
                return this.i[current];
            }
            current = this.h[current];
        }
        return 0.0f;
    }

    @Override // defpackage.c4.a
    public final float d(j4 v) {
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            if (this.g[current] == v.j) {
                return this.i[current];
            }
            current = this.h[current];
        }
        return 0.0f;
    }

    public String toString() {
        String result = "";
        int current = this.j;
        for (int counter = 0; current != -1 && counter < this.b; counter++) {
            result = ((result + " -> ") + this.i[current] + " : ") + this.d.d[this.g[current]];
            current = this.h[current];
        }
        return result;
    }
}
