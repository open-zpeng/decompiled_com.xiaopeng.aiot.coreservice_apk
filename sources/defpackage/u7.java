package defpackage;

import java.lang.reflect.Array;
/* compiled from: GrowingArrayUtils.java */
/* renamed from: u7  reason: default package */
/* loaded from: classes.dex */
public final class u7 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] b(T[] array, int currentSize, T element) {
        if (currentSize + 1 > array.length) {
            ?? r0 = (Object[]) Array.newInstance(array.getClass().getComponentType(), c(currentSize));
            System.arraycopy(array, 0, r0, 0, currentSize);
            array = r0;
        }
        array[currentSize] = element;
        return array;
    }

    public static int[] a(int[] array, int currentSize, int element) {
        if (currentSize + 1 > array.length) {
            int[] newArray = new int[c(currentSize)];
            System.arraycopy(array, 0, newArray, 0, currentSize);
            array = newArray;
        }
        array[currentSize] = element;
        return array;
    }

    public static int c(int currentSize) {
        if (currentSize <= 4) {
            return 8;
        }
        return currentSize * 2;
    }
}
