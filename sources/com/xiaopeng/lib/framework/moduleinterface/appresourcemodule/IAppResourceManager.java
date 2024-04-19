package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
/* loaded from: classes.dex */
public interface IAppResourceManager {

    /* loaded from: classes.dex */
    public interface IResourceObserver {
        void onChange(String str, AppResourceResponse appResourceResponse);
    }

    boolean addResource(AppResourceRequest appResourceRequest);

    bs<AppResourceResponse> addResourceObSource(AppResourceRequest appResourceRequest);

    void checkUpdate(String str);

    bs<AppResourceResponse> checkUpdateObSource(String str);

    bs<AppResourceResponse> clearResourceObSource();

    void clearResources();

    boolean deleteResource(String str);

    bs<AppResourceResponse> deleteResourceObSource(String str);

    AssetFileDescriptor getFileDescriptor(String str);

    bs<AssetFileDescriptor> getFileDescriptorObSource(String str);

    Uri getFullUri(String str);

    bs<Uri> getFullUrlObSource(String str);

    Status getStatus(String str);

    bs<Status> getStatusObSource(String str);

    void subscribeChanges(IResourceObserver iResourceObserver);

    void unSubscribeChanges(IResourceObserver iResourceObserver);

    /* loaded from: classes.dex */
    public enum UpdatePolicy {
        LOCAL(0),
        SYNC(1),
        ASYNC(2);
        
        public final int mId;

        public int id() {
            return this.mId;
        }

        UpdatePolicy(int id) {
            this.mId = id;
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_REGISTER(0),
        NOT_AUTH(1),
        NOT_AVAILABLE(2),
        OK(3),
        ERROR(4);
        
        public final int mId;

        public int id() {
            return this.mId;
        }

        Status(int id) {
            this.mId = id;
        }
    }
}
