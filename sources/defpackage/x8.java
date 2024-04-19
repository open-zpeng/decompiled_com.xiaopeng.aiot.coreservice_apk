package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.provider.FontsContractCompat;
import defpackage.a9;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: FontProvider.java */
/* renamed from: x8  reason: default package */
/* loaded from: classes.dex */
public class x8 {
    public static final Comparator<byte[]> a = new a();

    public static a9.a d(Context context, y8 request, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = e(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return a9.a.a(1, null);
        }
        a9.b[] fonts = f(context, request, providerInfo.authority, cancellationSignal);
        return a9.a.a(0, fonts);
    }

    public static ProviderInfo e(PackageManager packageManager, y8 request, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = request.e();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (!info.packageName.equals(request.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + request.f());
        } else {
            PackageInfo packageInfo = packageManager.getPackageInfo(info.packageName, 64);
            List<byte[]> signatures = a(packageInfo.signatures);
            Collections.sort(signatures, a);
            List<List<byte[]>> requestCertificatesList = c(request, resources);
            for (int i = 0; i < requestCertificatesList.size(); i++) {
                List<byte[]> requestSignatures = new ArrayList<>(requestCertificatesList.get(i));
                Collections.sort(requestSignatures, a);
                if (b(signatures, requestSignatures)) {
                    return info;
                }
            }
            return null;
        }
    }

    public static a9.b[] f(Context context, y8 request, String authority, CancellationSignal cancellationSignal) {
        int i;
        int resultCode;
        int idColumnIndex;
        Uri fileUri;
        ArrayList<FontsContractCompat.FontInfo> result = new ArrayList<>();
        Uri uri = new Uri.Builder().scheme("content").authority(authority).build();
        Uri fileBaseUri = new Uri.Builder().scheme("content").authority(authority).appendPath("file").build();
        Cursor cursor = null;
        try {
            String[] projection = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            boolean z = true;
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(uri, projection, "query = ?", new String[]{request.g()}, null, cancellationSignal);
                i = 0;
            } else {
                i = 0;
                cursor = context.getContentResolver().query(uri, projection, "query = ?", new String[]{request.g()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int resultCodeColumnIndex = cursor.getColumnIndex("result_code");
                result = new ArrayList<>();
                int weight = cursor.getColumnIndex("_id");
                int fileIdColumnIndex = cursor.getColumnIndex("file_id");
                int ttcIndexColumnIndex = cursor.getColumnIndex("font_ttc_index");
                int weightColumnIndex = cursor.getColumnIndex("font_weight");
                int italicColumnIndex = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    if (resultCodeColumnIndex != -1) {
                        resultCode = cursor.getInt(resultCodeColumnIndex);
                    } else {
                        resultCode = i;
                    }
                    int ttcIndex = ttcIndexColumnIndex != -1 ? cursor.getInt(ttcIndexColumnIndex) : i;
                    if (fileIdColumnIndex == -1) {
                        long id = cursor.getLong(weight);
                        idColumnIndex = weight;
                        fileUri = ContentUris.withAppendedId(uri, id);
                    } else {
                        idColumnIndex = weight;
                        long id2 = cursor.getLong(fileIdColumnIndex);
                        fileUri = ContentUris.withAppendedId(fileBaseUri, id2);
                    }
                    int weight2 = weightColumnIndex != -1 ? cursor.getInt(weightColumnIndex) : 400;
                    boolean italic = (italicColumnIndex == -1 || cursor.getInt(italicColumnIndex) != z) ? false : z;
                    int ttcIndex2 = resultCodeColumnIndex;
                    result.add(a9.b.a(fileUri, ttcIndex, weight2, italic, resultCode));
                    resultCodeColumnIndex = ttcIndex2;
                    weight = idColumnIndex;
                    i = 0;
                    z = true;
                }
            }
            return (a9.b[]) result.toArray(new a9.b[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static List<List<byte[]>> c(y8 request, Resources resources) {
        if (request.b() != null) {
            return request.b();
        }
        int resourceId = request.c();
        return s7.c(resources, resourceId);
    }

    /* compiled from: FontProvider.java */
    /* renamed from: x8$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] l, byte[] r) {
            if (l.length != r.length) {
                return l.length - r.length;
            }
            for (int i = 0; i < l.length; i++) {
                if (l[i] != r[i]) {
                    return l[i] - r[i];
                }
            }
            return 0;
        }
    }

    public static boolean b(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals(signatures.get(i), requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<byte[]> a(Signature[] signatures) {
        List<byte[]> shaList = new ArrayList<>();
        for (Signature signature : signatures) {
            shaList.add(signature.toByteArray());
        }
        return shaList;
    }
}
