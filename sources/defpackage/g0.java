package defpackage;
/* compiled from: TwilightCalculator.java */
/* renamed from: g0  reason: default package */
/* loaded from: classes.dex */
public class g0 {
    public static g0 a;
    public long b;
    public long c;
    public int d;

    public static g0 b() {
        if (a == null) {
            a = new g0();
        }
        return a;
    }

    public void a(long time, double latitude, double longitude) {
        float daysSince2000 = ((float) (time - 946728000000L)) / 8.64E7f;
        float meanAnomaly = (0.01720197f * daysSince2000) + 6.24006f;
        double trueAnomaly = meanAnomaly + (Math.sin(meanAnomaly) * 0.03341960161924362d) + (Math.sin(2.0f * meanAnomaly) * 3.4906598739326E-4d) + (Math.sin(3.0f * meanAnomaly) * 5.236000106378924E-6d);
        double solarLng = 1.796593063d + trueAnomaly + 3.141592653589793d;
        double arcLongitude = (-longitude) / 360.0d;
        float n = (float) Math.round((daysSince2000 - 9.0E-4f) - arcLongitude);
        double trueAnomaly2 = meanAnomaly;
        double solarTransitJ2000 = 9.0E-4f + n + arcLongitude + (Math.sin(trueAnomaly2) * 0.0053d) + (Math.sin(2.0d * solarLng) * (-0.0069d));
        double solarDec = Math.asin(Math.sin(solarLng) * Math.sin(0.4092797040939331d));
        double latRad = 0.01745329238474369d * latitude;
        double cosHourAngle = (Math.sin(-0.10471975803375244d) - (Math.sin(latRad) * Math.sin(solarDec))) / (Math.cos(latRad) * Math.cos(solarDec));
        if (cosHourAngle >= 1.0d) {
            this.d = 1;
            this.b = -1L;
            this.c = -1L;
        } else if (cosHourAngle <= -1.0d) {
            this.d = 0;
            this.b = -1L;
            this.c = -1L;
        } else {
            float hourAngle = (float) (Math.acos(cosHourAngle) / 6.283185307179586d);
            this.b = Math.round((hourAngle + solarTransitJ2000) * 8.64E7d) + 946728000000L;
            long round = Math.round((solarTransitJ2000 - hourAngle) * 8.64E7d) + 946728000000L;
            this.c = round;
            if (round >= time || this.b <= time) {
                this.d = 1;
            } else {
                this.d = 0;
            }
        }
    }
}
