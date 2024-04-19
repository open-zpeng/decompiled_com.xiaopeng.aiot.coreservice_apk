package com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.lzy.okgo.model.HttpHeaders;
import com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http.IRequest;
import com.xiaopeng.lib.framework.netchannelmodule.common.GlobalConfig;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.GetRequestAdapter;
import com.xiaopeng.lib.framework.netchannelmodule.http.okgoadapter.PostRequestAdapter;
import com.xiaopeng.lib.framework.netchannelmodule.http.xmart.bizapi.BizConstants;
import com.xiaopeng.lib.http.IrdetoUtils;
import com.xiaopeng.lib.http.Security;
import com.xiaopeng.lib.security.xmartv1.XmartV1Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class BizRequestBuilder {
    private static final String EMPTY_BODY = "";
    private static final String NETWORK_TYPE_2G = "2G";
    private static final String NETWORK_TYPE_3G = "3G";
    private static final String NETWORK_TYPE_4G = "4G";
    private static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";
    private static final String NETWORK_TYPE_WIFI = "WIFI";
    private static final String TAG = "BizRequestBuilder";
    private static final List<String> sBasicBizHeaders = Arrays.asList("XP-Appid", BizConstants.HEADER_CLIENT, BizConstants.HEADER_CLIENT_ENCODING, BizConstants.HEADER_CLIENT_TYPE, BizConstants.HEADER_ENCRYPTION_TYPE, BizConstants.HEADER_NONCE, BizConstants.HEADER_UID, BizConstants.HEADER_AUTHORIZATION);
    private static Gson sGson = new Gson();
    private String mAppId;
    private String mBody;
    private int mEncryptionType;
    private Map<String, String> mExtAuthorizationInfo;
    private BizConstants.METHOD mMethod;
    private boolean mNeedAuthorizationInfo;
    private IRequest mRequest;
    private String mSecretKey;
    private String[] mTokensForAuthorization;
    private String mUid;

    private BizRequestBuilder() {
        this.mUid = null;
        this.mAppId = BizConstants.APPID_CDU;
        this.mBody = "";
        this.mSecretKey = null;
        this.mNeedAuthorizationInfo = false;
        this.mTokensForAuthorization = Security.TOKEN_ALL;
        this.mExtAuthorizationInfo = null;
    }

    public BizRequestBuilder(IRequest request, BizConstants.METHOD method) {
        this.mUid = null;
        this.mAppId = BizConstants.APPID_CDU;
        this.mBody = "";
        this.mSecretKey = null;
        this.mNeedAuthorizationInfo = false;
        this.mTokensForAuthorization = Security.TOKEN_ALL;
        this.mExtAuthorizationInfo = null;
        this.mRequest = request;
        this.mMethod = method;
        this.mEncryptionType = 0;
    }

    public BizRequestBuilder body(String jsonBody) {
        this.mBody = jsonBody;
        return this;
    }

    public BizRequestBuilder enableIrdetoEncoding() {
        this.mEncryptionType = 1;
        return this;
    }

    public BizRequestBuilder enableSecurityEncoding() {
        this.mEncryptionType = Security.getActiveEncryptionType().getValue();
        return this;
    }

    public BizRequestBuilder needAuthorizationInfo(Map<String, String> extParams) {
        this.mNeedAuthorizationInfo = true;
        this.mExtAuthorizationInfo = extParams;
        return this;
    }

    public BizRequestBuilder appId(String value) {
        this.mAppId = value;
        return this;
    }

    public BizRequestBuilder uid(String value) {
        this.mUid = value;
        return this;
    }

    public BizRequestBuilder setExtHeader(String header, String value) {
        if (header.startsWith(BizConstants.HEADER_PREFIX)) {
            this.mRequest.headers(header, value);
        }
        return this;
    }

    public BizRequestBuilder customTokensForAuth(String[] tokens) {
        this.mTokensForAuthorization = tokens;
        return this;
    }

    public IRequest build(String secretKey) {
        if (secretKey != null) {
            this.mSecretKey = secretKey;
        } else {
            this.mSecretKey = BizConstants.CAR_SECRET;
        }
        for (String item : sBasicBizHeaders) {
            String value = bizHeaderValue(item);
            if (value != null) {
                this.mRequest.headers(item, value);
            }
        }
        String xpSignature = generateSignature();
        this.mRequest.headers(BizConstants.HEADER_SIGNATURE, xpSignature);
        if (this.mMethod == BizConstants.METHOD.POST) {
            if (TextUtils.isEmpty(this.mBody)) {
                this.mBody = "{}";
            }
            this.mRequest.headers("Content-Type", "application/json");
            this.mRequest.uploadJson(this.mBody);
        }
        return this.mRequest;
    }

    private String getAuthorization() {
        if (this.mNeedAuthorizationInfo) {
            String xpSignature = generateSignature();
            Map<String, String> map = new HashMap<>(1);
            map.put(BizConstants.AUTHORIZATION_XPSIGN, xpSignature);
            Map<String, String> map2 = this.mExtAuthorizationInfo;
            if (map2 != null) {
                for (String key : map2.keySet()) {
                    map.put(key, this.mExtAuthorizationInfo.get(key));
                }
            }
            try {
                if (this.mEncryptionType == 1) {
                    return IrdetoUtils.buildTokenData(this.mTokensForAuthorization, sGson.toJson(map).getBytes());
                }
                return Security.buildTokenData(this.mTokensForAuthorization, sGson.toJson(map).getBytes());
            } catch (NullPointerException exception) {
                pn.f(TAG, "getAuthorization fail : " + exception);
                return null;
            }
        }
        return null;
    }

    private static String getSignParameters(HttpHeaders headers, String url) {
        String value;
        List<String> keyList = new ArrayList<>(headers.headersMap.keySet());
        Uri uri = Uri.parse(url);
        Set<String> paramKeys = uri.getQueryParameterNames();
        keyList.addAll(paramKeys);
        Collections.sort(keyList);
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < keyList.size(); index++) {
            String key = keyList.get(index);
            if (paramKeys.contains(key) || key.startsWith(BizConstants.HEADER_PREFIX)) {
                if (headers.headersMap.containsKey(key)) {
                    if (co.g() && !TextUtils.isEmpty(uri.getQueryParameter(key))) {
                        throw new RuntimeException("Duplicate keys in header and parameters!");
                    }
                    value = headers.headersMap.get(key);
                    key = key.toUpperCase();
                } else {
                    value = uri.getQueryParameter(key);
                }
                if (!TextUtils.isEmpty(value)) {
                    if (builder.length() > 0) {
                        builder.append('&');
                    }
                    builder.append(key + "=" + value);
                }
            }
        }
        return builder.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String bizHeaderValue(String header) {
        char c;
        switch (header.hashCode()) {
            case -1913874489:
                if (header.equals("XP-Appid")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1901900614:
                if (header.equals(BizConstants.HEADER_NONCE)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1700294693:
                if (header.equals(BizConstants.HEADER_UID)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -576067417:
                if (header.equals(BizConstants.HEADER_CLIENT_TYPE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 366551663:
                if (header.equals(BizConstants.HEADER_ENCRYPTION_TYPE)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 800782916:
                if (header.equals(BizConstants.HEADER_AUTHORIZATION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 852785248:
                if (header.equals(BizConstants.HEADER_CLIENT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1042155584:
                if (header.equals(BizConstants.HEADER_CLIENT_ENCODING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                String result = this.mAppId;
                return result;
            case 1:
                String result2 = getAuthorization();
                return result2;
            case 2:
                String result3 = generateXpClient();
                return result3;
            case 3:
                return BizConstants.CLIENT_ENCODING_NONE;
            case 4:
                return BizConstants.CLIENT_TYPE_CDU;
            case 5:
                String result4 = String.valueOf(this.mEncryptionType);
                return result4;
            case 6:
                String result5 = String.valueOf(System.currentTimeMillis());
                return result5;
            case 7:
                String result6 = this.mUid;
                return result6;
            default:
                return null;
        }
    }

    private String generateXpClient() {
        String model = Cdo.a();
        String model2 = TextUtils.isEmpty(model) ? "" : model.toUpperCase().replaceAll(" ", "");
        StringBuilder builder = new StringBuilder();
        builder.append("di=" + getHardwareId() + ";");
        builder.append("pn=" + GlobalConfig.getApplicationName() + ";");
        builder.append("ve=" + co.e() + ";");
        builder.append("br=Xiaopeng;");
        builder.append("mo=" + model2 + ";");
        builder.append("st=1;");
        builder.append("sv=" + co.e() + ";");
        builder.append("nt=" + getNetworkType() + ";");
        builder.append("t=" + System.currentTimeMillis() + ";");
        if (Cdo.c()) {
            builder.append("ln=en;");
        }
        return builder.toString();
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            int v = b & 255;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private String generateSignature() {
        String method = this.mMethod.getValue();
        HttpHeaders headers = getRequestHeaders();
        String parameter = getSignParameters(headers, this.mRequest.getUrl());
        try {
            String md5 = TextUtils.isEmpty(this.mBody) ? "" : qn.a(this.mBody);
            Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
            byte[] secretBytes = this.mSecretKey.getBytes(XmartV1Constants.UTF8_ENCODING);
            hmacSHA256.init(new SecretKeySpec(secretBytes, 0, secretBytes.length, "HmacSHA256"));
            String signedOrigin = method + '&' + parameter + '&' + md5;
            pn.a(TAG, "generateSignature origin:" + signedOrigin);
            byte[] sha256Encode = hmacSHA256.doFinal((method + '&' + parameter + '&' + md5).getBytes(XmartV1Constants.UTF8_ENCODING));
            if (this.mEncryptionType == 0) {
                String signed = bytesToHexString(sha256Encode);
                return signed;
            }
            String signed2 = Security.parseByte2HexStr(sha256Encode).toLowerCase();
            return signed2;
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpHeaders getRequestHeaders() {
        IRequest iRequest = this.mRequest;
        if (iRequest instanceof GetRequestAdapter) {
            return ((GetRequestAdapter) iRequest).getHeaders();
        }
        if (iRequest instanceof PostRequestAdapter) {
            return ((PostRequestAdapter) iRequest).getHeaders();
        }
        return null;
    }

    private String getNetworkType() {
        Context context = GlobalConfig.getApplicationContext();
        int networkType = rn.a(context);
        switch (networkType) {
            case 1:
                return NETWORK_TYPE_2G;
            case 2:
                return NETWORK_TYPE_3G;
            case 3:
                return NETWORK_TYPE_4G;
            case 10:
                return NETWORK_TYPE_WIFI;
            default:
                return NETWORK_TYPE_UNKNOWN;
        }
    }

    private String getHardwareId() {
        String hardwareId = co.c();
        if (co.g() && TextUtils.isEmpty(hardwareId)) {
            throw new RuntimeException("Invalid hardware ID.");
        }
        return hardwareId;
    }
}
