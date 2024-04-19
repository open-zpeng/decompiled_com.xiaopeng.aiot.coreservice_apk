package com.xiaopeng.lib.framework.netchannelmodule.http.tracing;

import android.os.Process;
import android.text.TextUtils;
import brave.ErrorParser;
import brave.Tracer;
import brave.Tracing;
import brave.internal.handler.ZipkinFinishedSpanHandler;
import brave.sampler.Sampler;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
/* loaded from: classes.dex */
public class TracingHolder {
    private static final float DEFAULT_SAMPLE_RATE = 0.1f;
    private static final String KEY_SAMPLE_RATE = "logan_sample_rate";
    private static final String TAG = "Tracer";
    private ErrorParser mErrorParser;
    private ZipkinFinishedSpanHandler mHandler;
    private float mSampleRate;
    private Sampler mSampler;
    private Tracer mTracer;
    private Tracing mTracing;

    /* loaded from: classes.dex */
    public static final class HOLDER {
        private static TracingHolder INSTANCE = new TracingHolder();

        private HOLDER() {
        }
    }

    private TracingHolder() {
        this.mSampleRate = tn.b(GlobalConfig.getApplicationContext()).a(KEY_SAMPLE_RATE, DEFAULT_SAMPLE_RATE);
        pn.a(TAG, "init TracingHolder, mSampleRate:" + this.mSampleRate);
        this.mSampler = Sampler.create(this.mSampleRate);
        this.mErrorParser = new ErrorParser();
        String serviceName = GlobalConfig.getApplicationContext().getPackageName();
        String ip = "Client-" + un.c();
        int port = Process.myPid();
        this.mHandler = new ZipkinFinishedSpanHandler(new TracingReporter(), this.mErrorParser, serviceName, ip, port);
        buildTracer();
    }

    private void buildTracer() {
        this.mTracing = Tracing.newBuilder().errorParser(this.mErrorParser).sampler(this.mSampler).addFinishedSpanHandler(this.mHandler).build();
        this.mTracer = Tracing.currentTracer();
    }

    public static TracingHolder getInstance() {
        return HOLDER.INSTANCE;
    }

    public Tracer getTracer() {
        return this.mTracer;
    }

    public Sampler getSampler() {
        return this.mSampler;
    }

    public void updateSampleRate(String sampleRateStr) {
        if (TextUtils.isEmpty(sampleRateStr)) {
            return;
        }
        try {
            Float sampleRate = Float.valueOf(sampleRateStr);
            if (this.mSampleRate != sampleRate.floatValue()) {
                pn.a(TAG, "update rate from:" + this.mSampleRate + " to:" + sampleRate);
                this.mSampleRate = sampleRate.floatValue();
                this.mSampler = Sampler.create(sampleRate.floatValue());
                tn.b(GlobalConfig.getApplicationContext()).g(KEY_SAMPLE_RATE, sampleRate.floatValue());
                Tracing tracing = this.mTracing;
                if (tracing != null) {
                    tracing.close();
                }
                buildTracer();
            }
        } catch (Exception e) {
            pn.s(TAG, "invalid header rate:" + sampleRateStr);
        }
    }
}
