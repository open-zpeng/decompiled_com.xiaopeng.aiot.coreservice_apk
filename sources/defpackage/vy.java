package defpackage;

import java.io.File;
import java.io.FilenameFilter;
/* compiled from: PersistanceFileNameFilter.java */
/* renamed from: vy  reason: default package */
/* loaded from: classes.dex */
public class vy implements FilenameFilter {
    public final String a;

    public vy(String fileExtension) {
        this.a = fileExtension;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File dir, String name) {
        return name.endsWith(this.a);
    }
}
