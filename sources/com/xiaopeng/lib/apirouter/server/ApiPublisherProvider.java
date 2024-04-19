package com.xiaopeng.lib.apirouter.server;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
/* loaded from: classes.dex */
public class ApiPublisherProvider extends ContentProvider {
    public static Context CONTEXT;
    private AutoCodeMatcher mMatcher;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        CONTEXT = getContext();
        this.mMatcher = new AutoCodeMatcher();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String service, String arg, Bundle extras) {
        Pair<IBinder, String> pair = this.mMatcher.match(service);
        Bundle bundle = new Bundle();
        if (pair != null) {
            bundle.putBinder("binder", (IBinder) pair.first);
            bundle.putString("manifest", (String) pair.second);
        }
        return bundle;
    }

    public static void setContext(Context context) {
        CONTEXT = context;
    }

    public static void addManifestHandler(IManifestHandler manifestHandler) {
        AutoCodeMatcher.addManifestHandler(manifestHandler);
    }
}
