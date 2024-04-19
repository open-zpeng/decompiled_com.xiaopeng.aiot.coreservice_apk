package defpackage;

import java.io.File;
import java.io.FileFilter;
/* compiled from: PersistanceFileFilter.java */
/* renamed from: uy  reason: default package */
/* loaded from: classes.dex */
public class uy implements FileFilter {
    public final String a;

    public uy(String fileExtension) {
        this.a = fileExtension;
    }

    @Override // java.io.FileFilter
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(this.a);
    }
}
