package com.xiaopeng.lib.apirouter;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ApiMatcher {
    private static final String PROCESS_TAG_DIVIDER = "@";
    private ConcurrentHashMap<String, RemoteOperator> mRemoteOperators = new ConcurrentHashMap<>();

    public synchronized void publishUri(UriStruct uriStruct, RemoteOperator remoteOperator) {
        RemoteOperator previous;
        String processTag = uriStruct.processTag;
        RemoteOperator previous2 = put(processTag, remoteOperator.getAuthority(), remoteOperator);
        if (previous2 != null) {
            previous2.unLinkToDeath("getAuthority");
        }
        if (!remoteOperator.getAuthority().equals(remoteOperator.getDescription()) && (previous = put(processTag, remoteOperator.getDescription(), remoteOperator)) != null) {
            previous.unLinkToDeath("getDescription");
        }
        remoteOperator.linkToDeath();
    }

    public synchronized void unpublishUri(UriStruct uriStruct) {
        RemoteOperator remoteOperator = getRemoteOperator(uriStruct);
        if (remoteOperator != null) {
            String processTag = uriStruct.processTag;
            remove(processTag, remoteOperator.getAuthority());
            if (!remoteOperator.getAuthority().equals(remoteOperator.getDescription())) {
                remove(processTag, remoteOperator.getDescription());
            }
            remoteOperator.unLinkToDeath("unpublishUri");
        }
    }

    public synchronized RemoteOperator matchRemoteOperator(UriStruct uriStruct) {
        return getRemoteOperator(uriStruct);
    }

    private RemoteOperator put(String processTag, String key, RemoteOperator operator) {
        if (!TextUtils.isEmpty(processTag)) {
            key = processTag + PROCESS_TAG_DIVIDER + key;
        }
        return this.mRemoteOperators.put(key, operator);
    }

    private void remove(String processTag, String key) {
        if (!TextUtils.isEmpty(processTag)) {
            key = processTag + PROCESS_TAG_DIVIDER + key;
        }
        this.mRemoteOperators.remove(key);
    }

    private RemoteOperator getRemoteOperator(UriStruct uriStruct) {
        Set<Map.Entry<String, RemoteOperator>> set = this.mRemoteOperators.entrySet();
        String processTag = uriStruct.processTag;
        String starts = !TextUtils.isEmpty(processTag) ? processTag + PROCESS_TAG_DIVIDER + uriStruct.applicationId + "." : uriStruct.applicationId + ".";
        String ends = "." + uriStruct.serviceName;
        for (Map.Entry<String, RemoteOperator> entry : set) {
            String key = entry.getKey();
            if (key.startsWith(starts) && key.endsWith(ends)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
