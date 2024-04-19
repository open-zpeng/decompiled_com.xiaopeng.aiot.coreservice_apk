package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Calendar;
/* compiled from: TwilightManager.java */
/* renamed from: h0  reason: default package */
/* loaded from: classes.dex */
public class h0 {
    public static h0 a;
    public final Context b;
    public final LocationManager c;
    public final a d = new a();

    /* compiled from: TwilightManager.java */
    /* renamed from: h0$a */
    /* loaded from: classes.dex */
    public static class a {
        public boolean a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;
    }

    public static h0 a(Context context) {
        if (a == null) {
            Context context2 = context.getApplicationContext();
            a = new h0(context2, (LocationManager) context2.getSystemService(RequestParameters.SUBRESOURCE_LOCATION));
        }
        return a;
    }

    public h0(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    public boolean d() {
        a state = this.d;
        if (e()) {
            return state.a;
        }
        Location location = b();
        if (location != null) {
            f(location);
            return state.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(11);
        return hour < 6 || hour >= 22;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location coarseLoc = null;
        Location fineLoc = null;
        int permission = o7.b(this.b, "android.permission.ACCESS_COARSE_LOCATION");
        if (permission == 0) {
            coarseLoc = c("network");
        }
        int permission2 = o7.b(this.b, "android.permission.ACCESS_FINE_LOCATION");
        if (permission2 == 0) {
            fineLoc = c("gps");
        }
        return (fineLoc == null || coarseLoc == null) ? fineLoc != null ? fineLoc : coarseLoc : fineLoc.getTime() > coarseLoc.getTime() ? fineLoc : coarseLoc;
    }

    public final Location c(String provider) {
        try {
            if (this.c.isProviderEnabled(provider)) {
                return this.c.getLastKnownLocation(provider);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    public final boolean e() {
        return this.d.f > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long nextUpdate;
        long nextUpdate2;
        a state = this.d;
        long now = System.currentTimeMillis();
        g0 calculator = g0.b();
        calculator.a(now - 86400000, location.getLatitude(), location.getLongitude());
        long yesterdaySunset = calculator.b;
        calculator.a(now, location.getLatitude(), location.getLongitude());
        boolean isNight = calculator.d == 1;
        long todaySunrise = calculator.c;
        long todaySunset = calculator.b;
        calculator.a(86400000 + now, location.getLatitude(), location.getLongitude());
        long tomorrowSunrise = calculator.c;
        if (todaySunrise == -1 || todaySunset == -1) {
            nextUpdate = now + 43200000;
        } else {
            if (now > todaySunset) {
                nextUpdate2 = 0 + tomorrowSunrise;
            } else if (now > todaySunrise) {
                nextUpdate2 = 0 + todaySunset;
            } else {
                nextUpdate2 = 0 + todaySunrise;
            }
            nextUpdate = nextUpdate2 + 60000;
        }
        state.a = isNight;
        state.b = yesterdaySunset;
        state.c = todaySunrise;
        state.d = todaySunset;
        state.e = tomorrowSunrise;
        state.f = nextUpdate;
    }
}
