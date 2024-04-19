package defpackage;

import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.AndroidRuntimeException;
import defpackage.kq;
import java.io.IOException;
/* compiled from: SoundEffectPool.java */
/* renamed from: iq  reason: default package */
/* loaded from: classes.dex */
public class iq extends gq {
    public int b;
    public int c;
    public SoundPool d;
    public kq.a e;
    public boolean f;

    public iq(jq soundEffectResource) {
        super(soundEffectResource);
        h("constructor");
        switch (soundEffectResource.a()) {
            case 0:
                this.e = new b();
                break;
            case 1:
                this.e = new c();
                break;
        }
        d();
    }

    public final void d() {
        h("init");
        this.d = c();
        g();
    }

    @Override // defpackage.kq
    public void play() {
        h("play");
        SoundPool soundPool = this.d;
        if (soundPool != null) {
            this.f = true;
            int i = this.b;
            if (i == 0) {
                g();
                return;
            } else {
                this.c = soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
                return;
            }
        }
        d();
    }

    @Override // defpackage.kq
    public void release() {
        h("release");
        SoundPool soundPool = this.d;
        if (soundPool != null) {
            soundPool.release();
            this.d = null;
        }
    }

    public final SoundPool c() {
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
        attrBuilder.setLegacyStreamType(this.a.c());
        h("createSoundPool mSoundID : " + this.b + ",StreamType " + this.a.c());
        builder.setAudioAttributes(attrBuilder.build());
        return builder.build();
    }

    public final void g() {
        kq.a aVar = this.e;
        if (aVar != null) {
            this.b = aVar.a(this.a);
            h("load mSoundID : " + this.b);
        } else {
            h("load mISoundLoader is null");
        }
        this.d.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: dq
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                iq.this.f(soundPool, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(SoundPool soundPool, int sampleId, int status) {
        h("load onLoadComplete--,sampleId:" + sampleId + ",status:" + status);
        if (this.f) {
            this.f = false;
            play();
        }
    }

    public final void h(String msg) {
        rq.a("xpui-SoundEffectPool", msg);
    }

    /* compiled from: SoundEffectPool.java */
    /* renamed from: iq$b */
    /* loaded from: classes.dex */
    public class b implements kq.a {
        public b() {
        }

        @Override // defpackage.kq.a
        public int a(jq resource) {
            if (iq.this.d != null) {
                AssetFileDescriptor fd = null;
                try {
                    fd = cp.a().getAssets().openFd(iq.this.a.b());
                    iq iqVar = iq.this;
                    iqVar.h("LoaderAssets--resource:" + resource + ",path:" + iq.this.a.b() + ", is success");
                } catch (IOException e) {
                    iq iqVar2 = iq.this;
                    iqVar2.h("LoaderAssets--resource:" + resource + ",path:" + iq.this.a.b() + ", is error");
                    e.printStackTrace();
                }
                try {
                    return iq.this.d.load(fd, 1);
                } catch (AndroidRuntimeException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            iq iqVar3 = iq.this;
            iqVar3.h("LoaderAssets--resource:" + resource + ",mSoundPool is null");
            return 0;
        }
    }

    /* compiled from: SoundEffectPool.java */
    /* renamed from: iq$c */
    /* loaded from: classes.dex */
    public class c implements kq.a {
        public c() {
        }

        @Override // defpackage.kq.a
        public int a(jq resource) {
            if (iq.this.d != null) {
                return iq.this.d.load(iq.this.a.b(), 1);
            }
            iq iqVar = iq.this;
            iqVar.h("LoaderSystem--resource:" + resource + ",mSoundPool is null");
            return 0;
        }
    }
}
