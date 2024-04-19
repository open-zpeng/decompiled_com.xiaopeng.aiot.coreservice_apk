package defpackage;

import com.lzy.okgo.model.Progress;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* compiled from: ProgressRequestBody.java */
/* renamed from: rl  reason: default package */
/* loaded from: classes.dex */
public class rl<T> extends RequestBody {
    public RequestBody a;
    public yk<T> b;
    public c c;

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: rl$c */
    /* loaded from: classes.dex */
    public interface c {
        void uploadProgress(Progress progress);
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    /* JADX WARN: Generic types in debug info not equals: yk != com.lzy.okgo.callback.Callback<T> */
    public rl(RequestBody requestBody, yk<T> ykVar) {
        this.a = requestBody;
        this.b = ykVar;
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.a.contentType();
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.a.contentLength();
        } catch (IOException e) {
            wl.a(e);
            return -1L;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    /* JADX WARN: Generic types in debug info not equals: rl$b != com.lzy.okgo.request.base.ProgressRequestBody<T>$CountingSink */
    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        BufferedSink bufferedSink = Okio.buffer(new b(sink));
        this.a.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: rl$b */
    /* loaded from: classes.dex */
    public final class b extends ForwardingSink {
        public Progress a;

        /* JADX WARN: Generic types in debug info not equals: rl$b != com.lzy.okgo.request.base.ProgressRequestBody<T>$CountingSink */
        public b(Sink delegate) {
            super(delegate);
            Progress progress = new Progress();
            this.a = progress;
            progress.totalSize = rl.this.contentLength();
        }

        /* JADX WARN: Generic types in debug info not equals: rl$b != com.lzy.okgo.request.base.ProgressRequestBody<T>$CountingSink */
        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer source, long byteCount) throws IOException {
            super.write(source, byteCount);
            Progress.changeProgress(this.a, byteCount, new a());
        }

        /* compiled from: ProgressRequestBody.java */
        /* renamed from: rl$b$a */
        /* loaded from: classes.dex */
        public class a implements Progress.Action {
            public a() {
            }

            @Override // com.lzy.okgo.model.Progress.Action
            public void call(Progress progress) {
                if (rl.this.c != null) {
                    rl.this.c.uploadProgress(progress);
                } else {
                    rl.this.d(progress);
                }
            }
        }
    }

    /* compiled from: ProgressRequestBody.java */
    /* renamed from: rl$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Progress a;

        public a(Progress progress) {
            this.a = progress;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (rl.this.b != null) {
                rl.this.b.uploadProgress(this.a);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    public final void d(Progress progress) {
        ul.f(new a(progress));
    }

    /* JADX WARN: Generic types in debug info not equals: rl != com.lzy.okgo.request.base.ProgressRequestBody<T> */
    public void e(c interceptor) {
        this.c = interceptor;
    }
}
