package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import defpackage.a9;
import defpackage.s7;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: TypefaceCompatApi29Impl.java */
/* renamed from: f8  reason: default package */
/* loaded from: classes.dex */
public class f8 extends g8 {
    @Override // defpackage.g8
    public a9.b h(a9.b[] fonts, int style) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.g8
    public Typeface d(Context context, InputStream is) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.g8
    public Typeface c(Context context, CancellationSignal cancellationSignal, a9.b[] fonts, int style) {
        FontFamily.Builder familyBuilder = null;
        ContentResolver resolver = context.getContentResolver();
        try {
            int length = fonts.length;
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i < length) {
                    a9.b font = fonts[i];
                    try {
                        ParcelFileDescriptor pfd = resolver.openFileDescriptor(font.d(), "r", cancellationSignal);
                        if (pfd != null) {
                            try {
                                Font.Builder weight = new Font.Builder(pfd).setWeight(font.e());
                                if (!font.f()) {
                                    i2 = 0;
                                }
                                Font platformFont = weight.setSlant(i2).setTtcIndex(font.c()).build();
                                if (familyBuilder == null) {
                                    familyBuilder = new FontFamily.Builder(platformFont);
                                } else {
                                    familyBuilder.addFont(platformFont);
                                }
                                pfd.close();
                            } catch (Throwable th) {
                                try {
                                    pfd.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                                break;
                            }
                        } else if (pfd != null) {
                            pfd.close();
                        }
                    } catch (IOException e) {
                    }
                    i++;
                } else if (familyBuilder == null) {
                    return null;
                } else {
                    FontStyle defaultStyle = new FontStyle((style & 1) != 0 ? 700 : 400, (style & 2) != 0 ? 1 : 0);
                    return new Typeface.CustomFallbackBuilder(familyBuilder.build()).setStyle(defaultStyle).build();
                }
            }
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // defpackage.g8
    public Typeface b(Context context, s7.b familyEntry, Resources resources, int style) {
        FontFamily.Builder familyBuilder = null;
        try {
            s7.c[] a = familyEntry.a();
            int length = a.length;
            int i = 0;
            while (true) {
                int i2 = 1;
                if (i >= length) {
                    break;
                }
                s7.c entry = a[i];
                try {
                    Font.Builder weight = new Font.Builder(resources, entry.b()).setWeight(entry.e());
                    if (!entry.f()) {
                        i2 = 0;
                    }
                    Font platformFont = weight.setSlant(i2).setTtcIndex(entry.c()).setFontVariationSettings(entry.d()).build();
                    if (familyBuilder == null) {
                        familyBuilder = new FontFamily.Builder(platformFont);
                    } else {
                        familyBuilder.addFont(platformFont);
                    }
                } catch (IOException e) {
                }
                i++;
            }
            if (familyBuilder == null) {
                return null;
            }
            FontStyle defaultStyle = new FontStyle((style & 1) != 0 ? 700 : 400, (style & 2) != 0 ? 1 : 0);
            return new Typeface.CustomFallbackBuilder(familyBuilder.build()).setStyle(defaultStyle).build();
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // defpackage.g8
    public Typeface e(Context context, Resources resources, int id, String path, int style) {
        try {
            Font font = new Font.Builder(resources, id).build();
            FontFamily family = new FontFamily.Builder(font).build();
            return new Typeface.CustomFallbackBuilder(family).setStyle(font.getStyle()).build();
        } catch (Exception e) {
            return null;
        }
    }
}
