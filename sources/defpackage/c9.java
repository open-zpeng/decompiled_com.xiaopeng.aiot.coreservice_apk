package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;
/* compiled from: PrecomputedTextCompat.java */
/* renamed from: c9  reason: default package */
/* loaded from: classes.dex */
public class c9 implements Spannable {
    public static final Object a = new Object();
    public static Executor b = null;
    public final Spannable d;
    public final a f;
    public final PrecomputedText g;

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: c9$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final TextPaint a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;
        public final PrecomputedText.Params e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: c9$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0003a {
            public final TextPaint a;
            public TextDirectionHeuristic b;
            public int c;
            public int d;

            public C0003a(TextPaint paint) {
                this.a = paint;
                int i = Build.VERSION.SDK_INT;
                if (i >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (i >= 18) {
                    this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.b = null;
                }
            }

            public C0003a b(int strategy) {
                this.c = strategy;
                return this;
            }

            public C0003a c(int frequency) {
                this.d = frequency;
                return this;
            }

            public C0003a d(TextDirectionHeuristic textDir) {
                this.b = textDir;
                return this;
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.d);
            }
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint paint, TextDirectionHeuristic textDir, int strategy, int frequency) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e = new PrecomputedText.Params.Builder(paint).setBreakStrategy(strategy).setHyphenationFrequency(frequency).setTextDirection(textDir).build();
            } else {
                this.e = null;
            }
            this.a = paint;
            this.b = textDir;
            this.c = strategy;
            this.d = frequency;
        }

        public a(PrecomputedText.Params wrapped) {
            this.a = wrapped.getTextPaint();
            this.b = wrapped.getTextDirection();
            this.c = wrapped.getBreakStrategy();
            this.d = wrapped.getHyphenationFrequency();
            this.e = Build.VERSION.SDK_INT >= 29 ? wrapped : null;
        }

        public TextPaint e() {
            return this.a;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public boolean a(a other) {
            int i = Build.VERSION.SDK_INT;
            if ((i < 23 || (this.c == other.b() && this.d == other.c())) && this.a.getTextSize() == other.e().getTextSize() && this.a.getTextScaleX() == other.e().getTextScaleX() && this.a.getTextSkewX() == other.e().getTextSkewX()) {
                if ((i < 21 || (this.a.getLetterSpacing() == other.e().getLetterSpacing() && TextUtils.equals(this.a.getFontFeatureSettings(), other.e().getFontFeatureSettings()))) && this.a.getFlags() == other.e().getFlags()) {
                    if (i >= 24) {
                        if (!this.a.getTextLocales().equals(other.e().getTextLocales())) {
                            return false;
                        }
                    } else if (i >= 17 && !this.a.getTextLocale().equals(other.e().getTextLocale())) {
                        return false;
                    }
                    return this.a.getTypeface() == null ? other.e().getTypeface() == null : this.a.getTypeface().equals(other.e().getTypeface());
                }
                return false;
            }
            return false;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof a) {
                a other = (a) o;
                if (a(other)) {
                    return Build.VERSION.SDK_INT < 18 || this.b == other.d();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return f9.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 21) {
                return f9.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 18) {
                return f9.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (i >= 17) {
                return f9.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            return f9.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.a.getTextSize());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                sb.append(", letterSpacing=" + this.a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            }
            if (i >= 24) {
                sb.append(", textLocale=" + this.a.getTextLocales());
            } else if (i >= 17) {
                sb.append(", textLocale=" + this.a.getTextLocale());
            }
            sb.append(", typeface=" + this.a.getTypeface());
            if (i >= 26) {
                sb.append(", variationSettings=" + this.a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText b() {
        Spannable spannable = this.d;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public a a() {
        return this.f;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object what, int start, int end, int flags) {
        if (what instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.setSpan(what, start, end, flags);
        } else {
            this.d.setSpan(what, start, end, flags);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object what) {
        if (what instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.removeSpan(what);
        } else {
            this.d.removeSpan(what);
        }
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int start, int end, Class<T> type) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.g.getSpans(start, end, type);
        }
        return (T[]) this.d.getSpans(start, end, type);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object tag) {
        return this.d.getSpanStart(tag);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object tag) {
        return this.d.getSpanEnd(tag);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object tag) {
        return this.d.getSpanFlags(tag);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int start, int limit, Class type) {
        return this.d.nextSpanTransition(start, limit, type);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.d.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        return this.d.charAt(index);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int start, int end) {
        return this.d.subSequence(start, end);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.d.toString();
    }
}
