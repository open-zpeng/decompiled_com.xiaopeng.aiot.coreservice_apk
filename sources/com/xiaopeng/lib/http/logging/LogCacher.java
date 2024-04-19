package com.xiaopeng.lib.http.logging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class LogCacher {
    private static final int MAX_CACHE_COUNT = 5;
    private List<Cache> mCache = new LinkedList();
    private IHandler mHandler = new LogHandler();
    private int mCacheCount = 5;

    /* loaded from: classes.dex */
    public interface IHandler {
        void handle(String str);
    }

    /* loaded from: classes.dex */
    public interface ILog {
        void code(int i);

        void end();

        void log(String str);
    }

    public ILog getLogger() {
        return new Cache(this);
    }

    public void setHandler(IHandler handler) {
        this.mHandler = handler;
    }

    public void setCacheCount(int count) {
        this.mCacheCount = count;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void end(Cache cache) {
        this.mCache.add(cache);
        if (this.mCache.size() > this.mCacheCount) {
            this.mCache.remove(0);
        }
        int i = cache.code;
        if (i > 299 || i < 0) {
            Iterator<Cache> it = this.mCache.iterator();
            while (it.hasNext()) {
                Cache c = it.next();
                for (String msg : c.msgs) {
                    this.mHandler.handle(msg);
                }
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public class LogHandler implements IHandler {
        private LogHandler() {
        }

        @Override // com.xiaopeng.lib.http.logging.LogCacher.IHandler
        public void handle(String message) {
            pn.a("HttpsUtils", message);
        }
    }

    /* loaded from: classes.dex */
    public static class Cache implements ILog {
        public int code;
        public LogCacher context;
        public List<String> msgs = new ArrayList();

        public Cache(LogCacher context) {
            this.context = context;
        }

        @Override // com.xiaopeng.lib.http.logging.LogCacher.ILog
        public void code(int code) {
            this.code = code;
        }

        @Override // com.xiaopeng.lib.http.logging.LogCacher.ILog
        public void log(String msg) {
            this.msgs.add(msg);
        }

        @Override // com.xiaopeng.lib.http.logging.LogCacher.ILog
        public void end() {
            this.context.end(this);
        }
    }
}
