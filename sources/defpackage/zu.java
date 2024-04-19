package defpackage;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* renamed from: zu  reason: default package */
/* loaded from: classes.dex */
public class zu<T> {
    public final int a;
    public final Object[] b;
    public Object[] c;
    public int d;

    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<T> */
    public zu(int capacity) {
        this.a = capacity;
        Object[] objArr = new Object[capacity + 1];
        this.b = objArr;
        this.c = objArr;
    }

    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<T> */
    public void b(T value) {
        int c = this.a;
        int o = this.d;
        if (o == c) {
            Object[] next = new Object[c + 1];
            this.c[c] = next;
            this.c = next;
            o = 0;
        }
        this.c[o] = value;
        this.d = o + 1;
    }

    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<T> */
    public void c(T value) {
        this.b[0] = value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0019, code lost:
        continue;
     */
    /* JADX WARN: Generic types in debug info not equals: fs != io.reactivex.Observer<? super U> */
    /* JADX WARN: Generic types in debug info not equals: zu != io.reactivex.internal.util.AppendOnlyLinkedArrayList<T> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <U> boolean a(defpackage.fs<? super U> r6) {
        /*
            r5 = this;
            java.lang.Object[] r0 = r5.b
            int r1 = r5.a
        L4:
            if (r0 == 0) goto L1f
            r2 = 0
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r4 = defpackage.dv.a(r3, r6)
            if (r4 == 0) goto L16
            r4 = 1
            return r4
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r2 = r0[r1]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r0 = r2
            goto L4
        L1f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zu.a(fs):boolean");
    }
}
