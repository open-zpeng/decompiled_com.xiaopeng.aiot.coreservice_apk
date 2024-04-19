package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* compiled from: CompositeException.java */
/* renamed from: ps  reason: default package */
/* loaded from: classes.dex */
public final class ps extends RuntimeException {
    public final List<Throwable> a;
    public final String b;
    public Throwable d;

    /* compiled from: CompositeException.java */
    /* renamed from: ps$b */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(Object obj);
    }

    public ps(Throwable... exceptions) {
        this(exceptions == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(exceptions));
    }

    public ps(Iterable<? extends Throwable> errors) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<Throwable> localExceptions = new ArrayList<>();
        if (errors != null) {
            for (Throwable ex : errors) {
                if (ex instanceof ps) {
                    linkedHashSet.addAll(((ps) ex).b());
                } else if (ex != null) {
                    linkedHashSet.add(ex);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        localExceptions.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(localExceptions);
        this.a = unmodifiableList;
        this.b = unmodifiableList.size() + " exceptions occurred. ";
    }

    public List<Throwable> b() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.d == null) {
            Throwable localCause = new a();
            Set<Throwable> seenCauses = new HashSet<>();
            Throwable chain = localCause;
            Iterator<Throwable> it = this.a.iterator();
            while (it.hasNext()) {
                Throwable e = it.next();
                if (!seenCauses.contains(e)) {
                    seenCauses.add(e);
                    List<Throwable> listOfCauses = c(e);
                    for (Throwable child : listOfCauses) {
                        if (seenCauses.contains(child)) {
                            e = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            seenCauses.add(child);
                        }
                    }
                    try {
                        chain.initCause(e);
                    } catch (Throwable th) {
                    }
                    chain = d(chain);
                }
            }
            this.d = localCause;
        }
        return this.d;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream s) {
        e(new c(s));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter s) {
        e(new d(s));
    }

    public final void e(b s) {
        StackTraceElement[] stackTrace;
        StringBuilder b2 = new StringBuilder(128);
        b2.append(this);
        b2.append('\n');
        for (StackTraceElement myStackElement : getStackTrace()) {
            b2.append("\tat ");
            b2.append(myStackElement);
            b2.append('\n');
        }
        int i = 1;
        for (Throwable ex : this.a) {
            b2.append("  ComposedException ");
            b2.append(i);
            b2.append(" :\n");
            a(b2, ex, "\t");
            i++;
        }
        s.a(b2.toString());
    }

    public final void a(StringBuilder b2, Throwable ex, String prefix) {
        StackTraceElement[] stackTrace;
        b2.append(prefix);
        b2.append(ex);
        b2.append('\n');
        for (StackTraceElement stackElement : ex.getStackTrace()) {
            b2.append("\t\tat ");
            b2.append(stackElement);
            b2.append('\n');
        }
        if (ex.getCause() != null) {
            b2.append("\tCaused by: ");
            a(b2, ex.getCause(), "");
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: ps$c */
    /* loaded from: classes.dex */
    public static final class c extends b {
        public final PrintStream a;

        public c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // defpackage.ps.b
        public void a(Object o) {
            this.a.println(o);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: ps$d */
    /* loaded from: classes.dex */
    public static final class d extends b {
        public final PrintWriter a;

        public d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // defpackage.ps.b
        public void a(Object o) {
            this.a.println(o);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: ps$a */
    /* loaded from: classes.dex */
    public static final class a extends RuntimeException {
        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    public final List<Throwable> c(Throwable ex) {
        List<Throwable> list = new ArrayList<>();
        Throwable root = ex.getCause();
        if (root == null || root == ex) {
            return list;
        }
        while (true) {
            list.add(root);
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                break;
            }
            root = cause;
        }
        return list;
    }

    public Throwable d(Throwable e) {
        Throwable root = e.getCause();
        if (root == null || e == root) {
            return e;
        }
        while (true) {
            Throwable cause = root.getCause();
            if (cause == null || cause == root) {
                break;
            }
            root = cause;
        }
        return root;
    }
}
