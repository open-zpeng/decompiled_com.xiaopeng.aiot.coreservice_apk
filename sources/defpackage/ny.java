package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MultiByteArrayInputStream.java */
/* renamed from: ny  reason: default package */
/* loaded from: classes.dex */
public class ny extends InputStream {
    public byte[] a;
    public int b;
    public int d;
    public byte[] f;
    public int g;
    public int h;
    public int i = 0;

    public ny(byte[] bytesA, int offsetA, int lengthA, byte[] bytesB, int offsetB, int lengthB) {
        this.a = bytesA;
        this.f = bytesB;
        this.b = offsetA;
        this.g = offsetB;
        this.d = lengthA;
        this.h = lengthB;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int result;
        int i = this.i;
        int i2 = this.d;
        if (i < i2) {
            result = this.a[this.b + i];
        } else if (i < this.h + i2) {
            result = this.f[(this.g + i) - i2];
        } else {
            return -1;
        }
        if (result < 0) {
            result += IRadioController.TEF663x_PCHANNEL;
        }
        this.i = i + 1;
        return result;
    }
}
