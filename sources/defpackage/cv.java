package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExceptionHelper.java */
/* renamed from: cv  reason: default package */
/* loaded from: classes.dex */
public final class cv {
    public static final Throwable a = new a();

    public static RuntimeException d(Throwable error) {
        if (error instanceof Error) {
            throw ((Error) error);
        }
        if (error instanceof RuntimeException) {
            return (RuntimeException) error;
        }
        return new RuntimeException(error);
    }

    public static <T> boolean a(AtomicReference<Throwable> field, Throwable exception) {
        Throwable current;
        Throwable update;
        do {
            current = field.get();
            if (current == a) {
                return false;
            }
            if (current == null) {
                update = exception;
            } else {
                update = new ps(current, exception);
            }
        } while (!field.compareAndSet(current, update));
        return true;
    }

    public static <T> Throwable b(AtomicReference<Throwable> field) {
        Throwable current = field.get();
        Throwable th = a;
        if (current != th) {
            return field.getAndSet(th);
        }
        return current;
    }

    public static String c(long timeout, TimeUnit unit) {
        return "The source did not signal an event for " + timeout + " " + unit.toString().toLowerCase() + " and has been terminated.";
    }

    /* compiled from: ExceptionHelper.java */
    /* renamed from: cv$a */
    /* loaded from: classes.dex */
    public static final class a extends Throwable {
        public a() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }
}
