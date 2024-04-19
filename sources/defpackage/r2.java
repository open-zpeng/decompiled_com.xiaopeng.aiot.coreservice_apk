package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ResourcesWrapper.java */
/* renamed from: r2  reason: default package */
/* loaded from: classes.dex */
public class r2 extends Resources {
    public final Resources a;

    public r2(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = resources;
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int id) throws Resources.NotFoundException {
        return this.a.getText(id);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int id, int quantity) throws Resources.NotFoundException {
        return this.a.getQuantityText(id, quantity);
    }

    @Override // android.content.res.Resources
    public String getString(int id) throws Resources.NotFoundException {
        return this.a.getString(id);
    }

    @Override // android.content.res.Resources
    public String getString(int id, Object... formatArgs) throws Resources.NotFoundException {
        return this.a.getString(id, formatArgs);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int id, int quantity, Object... formatArgs) throws Resources.NotFoundException {
        return this.a.getQuantityString(id, quantity, formatArgs);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int id, int quantity) throws Resources.NotFoundException {
        return this.a.getQuantityString(id, quantity);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int id, CharSequence def) {
        return this.a.getText(id, def);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int id) throws Resources.NotFoundException {
        return this.a.getTextArray(id);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int id) throws Resources.NotFoundException {
        return this.a.getStringArray(id);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int id) throws Resources.NotFoundException {
        return this.a.getIntArray(id);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int id) throws Resources.NotFoundException {
        return this.a.obtainTypedArray(id);
    }

    @Override // android.content.res.Resources
    public float getDimension(int id) throws Resources.NotFoundException {
        return this.a.getDimension(id);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int id) throws Resources.NotFoundException {
        return this.a.getDimensionPixelOffset(id);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int id) throws Resources.NotFoundException {
        return this.a.getDimensionPixelSize(id);
    }

    @Override // android.content.res.Resources
    public float getFraction(int id, int base, int pbase) {
        return this.a.getFraction(id, base, pbase);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int id) throws Resources.NotFoundException {
        return this.a.getDrawable(id);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int id, Resources.Theme theme) throws Resources.NotFoundException {
        return this.a.getDrawable(id, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int id, int density) throws Resources.NotFoundException {
        return this.a.getDrawableForDensity(id, density);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int id, int density, Resources.Theme theme) {
        return this.a.getDrawableForDensity(id, density, theme);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int id) throws Resources.NotFoundException {
        return this.a.getMovie(id);
    }

    @Override // android.content.res.Resources
    public int getColor(int id) throws Resources.NotFoundException {
        return this.a.getColor(id);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int id) throws Resources.NotFoundException {
        return this.a.getColorStateList(id);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int id) throws Resources.NotFoundException {
        return this.a.getBoolean(id);
    }

    @Override // android.content.res.Resources
    public int getInteger(int id) throws Resources.NotFoundException {
        return this.a.getInteger(id);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int id) throws Resources.NotFoundException {
        return this.a.getLayout(id);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int id) throws Resources.NotFoundException {
        return this.a.getAnimation(id);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int id) throws Resources.NotFoundException {
        return this.a.getXml(id);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int id) throws Resources.NotFoundException {
        return this.a.openRawResource(id);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int id, TypedValue value) throws Resources.NotFoundException {
        return this.a.openRawResource(id, value);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int id) throws Resources.NotFoundException {
        return this.a.openRawResourceFd(id);
    }

    @Override // android.content.res.Resources
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.a.getValue(id, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.a.getValueForDensity(id, density, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws Resources.NotFoundException {
        this.a.getValue(name, outValue, resolveRefs);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        return this.a.obtainAttributes(set, attrs);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        super.updateConfiguration(config, metrics);
        Resources resources = this.a;
        if (resources != null) {
            resources.updateConfiguration(config, metrics);
        }
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String name, String defType, String defPackage) {
        return this.a.getIdentifier(name, defType, defPackage);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int resid) throws Resources.NotFoundException {
        return this.a.getResourceName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int resid) throws Resources.NotFoundException {
        return this.a.getResourcePackageName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int resid) throws Resources.NotFoundException {
        return this.a.getResourceTypeName(resid);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int resid) throws Resources.NotFoundException {
        return this.a.getResourceEntryName(resid);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        this.a.parseBundleExtras(parser, outBundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        this.a.parseBundleExtra(tagName, attrs, outBundle);
    }
}
