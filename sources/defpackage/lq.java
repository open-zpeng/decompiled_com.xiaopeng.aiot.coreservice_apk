package defpackage;

import android.media.AudioManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: XSoundEffectManager.java */
/* renamed from: lq  reason: default package */
/* loaded from: classes.dex */
public class lq {
    public ConcurrentHashMap<Integer, kq> a;
    public ExecutorService b;
    public boolean c;
    public ConcurrentHashMap<Integer, Boolean> d;

    /* compiled from: XSoundEffectManager.java */
    /* renamed from: lq$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final lq a = new lq();
    }

    public lq() {
        this.a = new ConcurrentHashMap<>();
        this.b = Executors.newSingleThreadExecutor();
        this.d = new ConcurrentHashMap<>();
    }

    public static lq a() {
        return b.a;
    }

    public synchronized void g(int resource) {
        int autoManagerId = j(resource);
        if (autoManagerId > 0) {
            c.a().c(autoManagerId);
        } else {
            h(resource);
        }
    }

    public final void h(final int resource) {
        this.c = false;
        this.d.put(Integer.valueOf(resource), false);
        this.b.execute(new Runnable() { // from class: fq
            @Override // java.lang.Runnable
            public final void run() {
                lq.this.c(resource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(int resource) {
        if (this.c) {
            f(String.format("play-not for destroy resource:%s", Integer.valueOf(resource)));
            return;
        }
        Boolean isRelease = this.d.get(Integer.valueOf(resource));
        if (isRelease != null && isRelease.booleanValue()) {
            f(String.format("play-not for release resource:%s", Integer.valueOf(resource)));
            return;
        }
        System.currentTimeMillis();
        kq soundEffect = this.a.get(Integer.valueOf(resource));
        if (soundEffect == null) {
            soundEffect = hq.a(resource);
            this.a.put(Integer.valueOf(resource), soundEffect);
        }
        soundEffect.play();
    }

    public final int j(int id) {
        switch (id) {
            case 2:
                return 17;
            case 3:
                return 16;
            case 4:
                return 15;
            case 5:
                return 14;
            default:
                return -1;
        }
    }

    public synchronized void i(final int resource) {
        this.d.put(Integer.valueOf(resource), true);
        this.b.execute(new Runnable() { // from class: eq
            @Override // java.lang.Runnable
            public final void run() {
                lq.this.e(resource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(int resource) {
        kq soundEffect = this.a.get(Integer.valueOf(resource));
        if (soundEffect != null) {
            soundEffect.release();
        }
        f(String.format("release resource:%s", Integer.valueOf(resource)));
    }

    public final void f(String msg) {
        rq.a("xpui-XSoundManager", msg);
    }

    /* compiled from: XSoundEffectManager.java */
    /* renamed from: lq$c */
    /* loaded from: classes.dex */
    public static class c {
        public AudioManager a;

        public c() {
        }

        /* compiled from: XSoundEffectManager.java */
        /* renamed from: lq$c$a */
        /* loaded from: classes.dex */
        public static class a {
            public static final c a = new c();
        }

        public static c a() {
            return a.a;
        }

        public final AudioManager b() {
            if (this.a == null) {
                this.a = (AudioManager) cp.a().getSystemService("audio");
            }
            return this.a;
        }

        public void c(int effectType) {
            b().playSoundEffect(effectType);
        }
    }
}
