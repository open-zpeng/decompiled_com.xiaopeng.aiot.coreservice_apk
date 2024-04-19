package defpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: DateUtils.java */
/* renamed from: nn  reason: default package */
/* loaded from: classes.dex */
public class nn {
    public static SimpleDateFormat a = new SimpleDateFormat("MM.dd");
    public static SimpleDateFormat b = new SimpleDateFormat("yyyy.MM");
    public static SimpleDateFormat c = new SimpleDateFormat("MM.dd");
    public static SimpleDateFormat d = new SimpleDateFormat("MM月dd日");
    public static SimpleDateFormat e = new SimpleDateFormat("yyyy年MM月dd日");
    public static SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
    public static SimpleDateFormat g = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat h = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat j = new SimpleDateFormat("yyMMddHHmmss");
    public static SimpleDateFormat k = new SimpleDateFormat("yyyy/MM/dd");
    public static SimpleDateFormat l = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    public static SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    public static SimpleDateFormat n = new SimpleDateFormat("yyyyMMdd_HHmmss");
    public static SimpleDateFormat o = new SimpleDateFormat("dd MMM yyyy");
    public static SimpleDateFormat p = new SimpleDateFormat("dd.MMM yyyy");
    public static SimpleDateFormat q = new SimpleDateFormat("dd MMM");
    public static SimpleDateFormat r = new SimpleDateFormat("dd.MMM");
    public static SimpleDateFormat s = new SimpleDateFormat("E,dd MMM");
    public static SimpleDateFormat t = new SimpleDateFormat("E,dd.MMM");

    public static synchronized String c(long date) {
        String format;
        synchronized (nn.class) {
            format = k.format(Long.valueOf(date));
        }
        return format;
    }

    public static synchronized String b(long date) {
        String format;
        synchronized (nn.class) {
            format = n.format(Long.valueOf(date));
        }
        return format;
    }

    public static synchronized long a(String dateStr) {
        long stamp;
        synchronized (nn.class) {
            stamp = 0;
            try {
                Date date = n.parse(dateStr);
                stamp = date.getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        return stamp;
    }
}
