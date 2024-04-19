package com.xiaopeng.base.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes.dex */
public class LogUtils {
    public static final String SEPARATOR = ",";
    public static String TAG = "";
    public static boolean isStoreExist = Environment.getExternalStorageState().equalsIgnoreCase("mounted");
    private static boolean isNeedTrace = false;
    public static boolean mLogEnable = true;

    public static void setTag(String tag) {
        TAG = tag;
    }

    public static boolean isIsNeedTrace() {
        return isNeedTrace;
    }

    public static void setIsNeedTrace(boolean isNeedTrace2) {
        isNeedTrace = isNeedTrace2;
    }

    public static void setLogEnable(boolean enable) {
        mLogEnable = enable;
    }

    public static void v(String msg) {
        if (!mLogEnable) {
            return;
        }
        doLog(2, null, msg, null, true);
    }

    public static void v(Object tag, String format) {
        if (!mLogEnable) {
            return;
        }
        doLog(2, tag, format, null, true);
    }

    public static void v(Object tag, String format, Object... args) {
        if (!mLogEnable) {
            return;
        }
        try {
            doLog(2, tag, String.format(format, args), null, true);
        } catch (Exception e) {
            d("LogUtils", "Exception == " + e.toString());
        }
    }

    public static void v(Object tag, String message, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(2, tag, message, t, true);
    }

    public static void v(Object tag, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(2, tag, "Exception occurs at", t, true);
    }

    public static void d(String msg) {
        if (!mLogEnable) {
            return;
        }
        doLog(3, null, msg, null, true);
    }

    public static void d(Object tag, String message) {
        if (!mLogEnable) {
            return;
        }
        doLog(3, tag, message, null, true);
    }

    public static void dFormat(Object tag, String message, boolean format) {
        if (!mLogEnable) {
            return;
        }
        doLog(3, tag, message, null, true, format);
    }

    public static void d(Object tag, String format, Object... args) {
        if (!mLogEnable) {
            return;
        }
        try {
            doLog(3, tag, String.format(format, args), null, true);
        } catch (Exception e) {
            d("LogUtils", "Exception == " + e.toString());
        }
    }

    public static void d(Object tag, String message, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(3, tag, message, t, true);
    }

    public static void d(Object tag, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(3, tag, "Exception occurs at", t, true);
    }

    public static void i(String msg) {
        if (!mLogEnable) {
            return;
        }
        doLog(4, null, msg, null, true);
    }

    public static void i(Object tag, String format) {
        if (!mLogEnable) {
            return;
        }
        doLog(4, tag, format, null, true);
    }

    public static void i(Object tag, String format, Object... args) {
        if (!mLogEnable) {
            return;
        }
        try {
            doLog(4, tag, String.format(format, args), null, true);
        } catch (Exception e) {
            d("LogUtils", "Exception == " + e.toString());
        }
    }

    public static void iFormat(Object tag, String message, boolean format) {
        if (!mLogEnable) {
            return;
        }
        doLog(4, tag, message, null, true, format);
    }

    public static void i(Object tag, String message, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(4, tag, message, t, true);
    }

    public static void i(Object tag, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(4, tag, "Exception occurs at", t, true);
    }

    public static void w(String msg) {
        if (!mLogEnable) {
            return;
        }
        doLog(5, null, msg, null, true);
    }

    public static void w(Object tag, String message) {
        if (!mLogEnable) {
            return;
        }
        doLog(5, tag, message, null, true);
    }

    public static void w(Object tag, String format, Object... args) {
        if (!mLogEnable) {
            return;
        }
        try {
            doLog(5, tag, String.format(format, args), null, true);
        } catch (Exception e) {
            d("LogUtils", "Exception == " + e.toString());
        }
    }

    public static void w(Object tag, String message, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(5, tag, message, t, true);
    }

    public static void w(Object tag, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(5, tag, "Exception occurs at", t, true);
    }

    public static void wFormat(Object tag, String message, boolean format) {
        if (!mLogEnable) {
            return;
        }
        doLog(5, tag, message, null, true, format);
    }

    public static void e(String msg) {
        if (!mLogEnable) {
            return;
        }
        doLog(6, null, msg, null, true);
    }

    public static void e(Object tag, String message) {
        if (!mLogEnable) {
            return;
        }
        doLog(6, tag, message, null, true);
    }

    public static void e(Object tag, String format, Object... args) {
        if (!mLogEnable) {
            return;
        }
        try {
            doLog(6, tag, String.format(format, args), null, true);
        } catch (Exception e) {
            d("LogUtils", "Exception == " + e.toString());
        }
    }

    public static void e(Object tag, String message, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(6, tag, message, t, true);
    }

    public static void e(Object tag, Throwable t) {
        if (!mLogEnable) {
            return;
        }
        doLog(6, tag, "Exception occurs at", t, true);
    }

    public static void eFormat(Object tag, String message, boolean format) {
        if (!mLogEnable) {
            return;
        }
        doLog(6, tag, message, null, true, format);
    }

    public static void log(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        if (!mLogEnable) {
            return;
        }
        doLog(logLevel, tag, message, t, needStackTrace);
    }

    private static void doLog(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace) {
        doLog(logLevel, tag, message, t, needStackTrace, false);
    }

    private static void doLog(int logLevel, Object tag, String message, Throwable t, boolean needStackTrace, boolean format) {
        StackTraceElement[] stackTraceElements;
        StackTraceElement element = null;
        if (needStackTrace && (stackTraceElements = Thread.currentThread().getStackTrace()) != null && stackTraceElements.length > 5) {
            element = stackTraceElements[5];
        }
        String tagStr = getTag(tag);
        if (format) {
            message = formatJson(message);
        }
        String msg = getLogInfo(tagStr, element, message, t);
        logByLevel(tagStr, logLevel, msg);
    }

    public static String formatJson(String msg) {
        String message;
        if (TextUtils.isEmpty(msg)) {
            return "";
        }
        String msg2 = msg.trim();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (msg2.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg2);
                message = jsonObject.toString(2);
            } else if (msg2.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg2);
                message = jsonArray.toString(2);
            } else {
                return msg2;
            }
            stringBuilder.append("\n");
            stringBuilder.append(message);
            stringBuilder.append("\n");
            return stringBuilder.toString();
        } catch (JSONException e) {
            return msg2;
        }
    }

    private static void logByLevel(String tag, int logLevel, String msg) {
        try {
            qm.h(logLevel, msg, tag, qm.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLogInfo(String tagStr, StackTraceElement stackTraceElement, String msg, Throwable t) {
        StringBuilder logInfoStringBuilder = new StringBuilder();
        if (stackTraceElement != null) {
            String threadName = Thread.currentThread().getName();
            long threadID = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            String fileName = stackTraceElement.getFileName();
            logInfoStringBuilder.append("[");
            if (isIsNeedTrace()) {
                logInfoStringBuilder.append("threadId=");
                logInfoStringBuilder.append(threadID);
                logInfoStringBuilder.append(SEPARATOR);
                logInfoStringBuilder.append(threadName);
                logInfoStringBuilder.append(SEPARATOR);
            }
            if (fileName != null && !fileName.startsWith(tagStr)) {
                logInfoStringBuilder.append("at ");
                logInfoStringBuilder.append(fileName);
                logInfoStringBuilder.append(":");
            }
            logInfoStringBuilder.append(lineNumber);
            logInfoStringBuilder.append("]");
        }
        logInfoStringBuilder.append(msg);
        if (t != null) {
            logInfoStringBuilder.append('\n');
            logInfoStringBuilder.append(Log.getStackTraceString(t));
        }
        return logInfoStringBuilder.toString();
    }

    public static String getLoggerInfo(StackTraceElement stackTraceElement, String msg, Throwable t) {
        StringBuilder logInfoStringBuilder = new StringBuilder();
        if (stackTraceElement != null) {
            Thread.currentThread().getName();
            Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            String fileName = stackTraceElement.getFileName();
            if (!TextUtils.isEmpty(fileName)) {
                logInfoStringBuilder.append("[");
                String newFileName = fileName.replace(".java", "");
                logInfoStringBuilder.append(newFileName);
                logInfoStringBuilder.append(":");
                logInfoStringBuilder.append(lineNumber);
                logInfoStringBuilder.append("]");
            }
        }
        logInfoStringBuilder.append(msg);
        if (t != null) {
            logInfoStringBuilder.append('\n');
            logInfoStringBuilder.append(Log.getStackTraceString(t));
        }
        return logInfoStringBuilder.toString();
    }

    private static String getTag(Object obj) {
        StringBuilder stringBuilder = new StringBuilder(TAG);
        if (obj == null) {
            return stringBuilder.toString();
        }
        if (obj instanceof String) {
            stringBuilder.append((String) obj);
        } else if (obj instanceof Class) {
            stringBuilder.append(((Class) obj).getSimpleName());
        } else {
            stringBuilder.append(obj.getClass().getSimpleName());
        }
        return stringBuilder.toString();
    }

    public static void uncaughtException(Throwable t) {
        if (!isStoreExist || t == null) {
            return;
        }
        StringWriter sw = new StringWriter();
        sw.write("\n");
        t.printStackTrace(new PrintWriter(sw));
        try {
            qm.h(6, sw.toString(), TAG, "uncaught_exception");
            qm.b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
