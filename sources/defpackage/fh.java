package defpackage;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* renamed from: fh  reason: default package */
/* loaded from: classes.dex */
public final class fh extends lh {
    public static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    public Object b;

    public fh(Boolean bool) {
        h(bool);
    }

    public fh(Number number) {
        h(number);
    }

    public fh(String str) {
        h(str);
    }

    public static boolean i(fh fhVar) {
        Object obj = fhVar.b;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public static boolean k(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fh.class != obj.getClass()) {
            return false;
        }
        fh fhVar = (fh) obj;
        if (this.b == null) {
            return fhVar.b == null;
        } else if (i(this) && i(fhVar)) {
            return m().longValue() == fhVar.m().longValue();
        } else {
            Object obj2 = this.b;
            if ((obj2 instanceof Number) && (fhVar.b instanceof Number)) {
                double doubleValue = m().doubleValue();
                double doubleValue2 = fhVar.m().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(fhVar.b);
        }
    }

    public void h(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            dg.b((obj instanceof Number) || k(obj));
        }
        this.b = obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.b == null) {
            return 31;
        }
        if (i(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean j() {
        return this.b instanceof Boolean;
    }

    public String l() {
        return s() ? m().toString() : j() ? r().toString() : (String) this.b;
    }

    public Number m() {
        Object obj = this.b;
        return obj instanceof String ? new ig((String) this.b) : (Number) obj;
    }

    public double n() {
        return s() ? m().doubleValue() : Double.parseDouble(l());
    }

    public int o() {
        return s() ? m().intValue() : Integer.parseInt(l());
    }

    public long p() {
        return s() ? m().longValue() : Long.parseLong(l());
    }

    public boolean q() {
        return j() ? r().booleanValue() : Boolean.parseBoolean(l());
    }

    public Boolean r() {
        return (Boolean) this.b;
    }

    public boolean s() {
        return this.b instanceof Number;
    }

    public boolean t() {
        return this.b instanceof String;
    }
}
