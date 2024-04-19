package defpackage;

import android.text.TextUtils;
import com.tencent.mars.xlog.Log;
import com.xiaopeng.base.BaseApplication;
import com.xiaopeng.base.log.LogUtils;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IBizHelper;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.http.server.ServerBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: RxHttpsHelper.java */
/* renamed from: vm  reason: default package */
/* loaded from: classes.dex */
public class vm {
    public static bs<ServerBean> h(final String url, final long uid, final Map<String, Object> params, final boolean encodeBody, final String[] ids, final String otpToken) {
        return new xm(bs.e(new Callable() { // from class: rm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return vm.g(params, encodeBody, uid, ids, url, otpToken);
            }
        }));
    }

    public static /* synthetic */ es g(Map params, boolean encodeBody, long uid, String[] ids, String url, String otpToken) throws Exception {
        String body = null;
        if (params != null) {
            if (encodeBody) {
                body = e(params);
            } else {
                body = an.c(params);
            }
        }
        if (body == null) {
            body = "{}";
        }
        long realUid = uid;
        String uidStr = null;
        if (realUid == -1) {
            realUid = un.a();
        }
        if (realUid != -1) {
            uidStr = String.valueOf(realUid);
            Log.d("RxHttpsHelper", "post() uidStr =" + uidStr);
        }
        Log.d("RxHttpsHelper", "post() called with: body =" + body);
        IBizHelper bizHelper = BaseApplication.b().bizHelper().post(url, body);
        Log.d("RxHttpsHelper", "post() called with: url =" + url);
        if (ids != null && ids.length > 0) {
            bizHelper.customTokensForAuth(ids);
        }
        if (otpToken != null && !TextUtils.isEmpty(otpToken)) {
            HashMap<String, String> optMap = new HashMap<>();
            optMap.put("otp", otpToken);
            bizHelper.needAuthorizationInfo(optMap);
        } else {
            bizHelper.needAuthorizationInfo();
        }
        bizHelper.enableSecurityEncoding();
        if (!TextUtils.isEmpty(uidStr)) {
            bizHelper.uid(uidStr);
        }
        bizHelper.appId("xp_xmart_android");
        IRequest request = bizHelper.buildWithSecretKey(f());
        Log.d("RxHttpsHelper", "post() called with: url = [" + url + "], uidStr = [" + uidStr + "], params = [" + params + "], encodeBody = [" + encodeBody + "], tokenIds = [" + Arrays.toString(ids) + "]");
        return new ym(request);
    }

    public static String f() {
        int env_type = sm.a();
        LogUtils.e("RxHttpsHelper", "getXpAppSecret, env_type = " + env_type);
        if (env_type == 0) {
            return "grywtjs52h6v6w8u";
        }
        return "42p07nrwtxvaahg3";
    }

    public static bs<ServerBean> d(String url, Map<String, Object> params) {
        return a(url, -1L, params);
    }

    public static bs<ServerBean> a(String url, long uid, Map<String, Object> params) {
        return b(url, uid, params, false);
    }

    public static bs<ServerBean> b(String url, long uid, Map<String, Object> params, boolean encodeBody) {
        return c(url, uid, params, encodeBody, null);
    }

    public static bs<ServerBean> c(String url, long uid, Map<String, Object> params, boolean encodeBody, String[] tokenIds) {
        return new wm(h(url, uid, params, encodeBody, tokenIds, null));
    }

    public static String e(Map<String, Object> param) {
        try {
            Map<String, String> postParam = new HashMap<>(1);
            postParam.put("sData", Security.encode(an.c(param)));
            return an.c(postParam);
        } catch (Throwable var2) {
            var2.printStackTrace();
            return null;
        }
    }
}
