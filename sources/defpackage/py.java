package defpackage;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/* compiled from: JSR47Logger.java */
/* renamed from: py  reason: default package */
/* loaded from: classes.dex */
public class py implements qy {
    public Logger a = null;
    public ResourceBundle b = null;
    public ResourceBundle c = null;
    public String d = null;
    public String e = null;
    public String f = null;

    @Override // defpackage.qy
    public void initialise(ResourceBundle logMsgCatalog, String loggerID, String resourceContext) {
        this.c = this.b;
        this.e = resourceContext;
        this.f = loggerID;
        this.a = Logger.getLogger(loggerID);
        this.b = logMsgCatalog;
        this.c = logMsgCatalog;
        this.d = logMsgCatalog.getString("0");
    }

    @Override // defpackage.qy
    public void setResourceName(String logContext) {
        this.e = logContext;
    }

    @Override // defpackage.qy
    public boolean isLoggable(int level) {
        return this.a.isLoggable(d(level));
    }

    @Override // defpackage.qy
    public void severe(String sourceClass, String sourceMethod, String msg, Object[] inserts) {
        b(1, sourceClass, sourceMethod, msg, inserts, null);
    }

    @Override // defpackage.qy
    public void warning(String sourceClass, String sourceMethod, String msg) {
        b(2, sourceClass, sourceMethod, msg, null, null);
    }

    @Override // defpackage.qy
    public void warning(String sourceClass, String sourceMethod, String msg, Object[] inserts) {
        b(2, sourceClass, sourceMethod, msg, inserts, null);
    }

    public void b(int level, String sourceClass, String sourceMethod, String msg, Object[] inserts, Throwable thrown) {
        Level julLevel = d(level);
        if (this.a.isLoggable(julLevel)) {
            c(julLevel, sourceClass, sourceMethod, this.d, this.b, msg, inserts, thrown);
        }
    }

    @Override // defpackage.qy
    public void fine(String sourceClass, String sourceMethod, String msg) {
        e(5, sourceClass, sourceMethod, msg, null, null);
    }

    @Override // defpackage.qy
    public void fine(String sourceClass, String sourceMethod, String msg, Object[] inserts) {
        e(5, sourceClass, sourceMethod, msg, inserts, null);
    }

    @Override // defpackage.qy
    public void fine(String sourceClass, String sourceMethod, String msg, Object[] inserts, Throwable ex) {
        e(5, sourceClass, sourceMethod, msg, inserts, ex);
    }

    @Override // defpackage.qy
    public void finer(String sourceClass, String sourceMethod, String msg) {
        e(6, sourceClass, sourceMethod, msg, null, null);
    }

    public void e(int level, String sourceClass, String sourceMethod, String msg, Object[] inserts, Throwable ex) {
        Level julLevel = d(level);
        boolean isJULLoggable = this.a.isLoggable(julLevel);
        if (isJULLoggable) {
            c(julLevel, sourceClass, sourceMethod, this.d, this.c, msg, inserts, ex);
        }
    }

    public final String a(ResourceBundle messageCatalog, String msg) {
        try {
            String message = messageCatalog.getString(msg);
            return message;
        } catch (MissingResourceException e) {
            return msg;
        }
    }

    public final void c(Level julLevel, String sourceClass, String sourceMethod, String catalogName, ResourceBundle messageCatalog, String msg, Object[] inserts, Throwable thrown) {
        String formattedWithArgs = msg;
        if (msg.indexOf("=====") == -1) {
            formattedWithArgs = MessageFormat.format(a(messageCatalog, msg), inserts);
        }
        LogRecord logRecord = new LogRecord(julLevel, String.valueOf(this.e) + ": " + formattedWithArgs);
        logRecord.setSourceClassName(sourceClass);
        logRecord.setSourceMethodName(sourceMethod);
        logRecord.setLoggerName(this.f);
        if (thrown != null) {
            logRecord.setThrown(thrown);
        }
        this.a.log(logRecord);
    }

    public final Level d(int level) {
        switch (level) {
            case 1:
                Level julLevel = Level.SEVERE;
                return julLevel;
            case 2:
                Level julLevel2 = Level.WARNING;
                return julLevel2;
            case 3:
                Level julLevel3 = Level.INFO;
                return julLevel3;
            case 4:
                Level julLevel4 = Level.CONFIG;
                return julLevel4;
            case 5:
                Level julLevel5 = Level.FINE;
                return julLevel5;
            case 6:
                Level julLevel6 = Level.FINER;
                return julLevel6;
            case 7:
                Level julLevel7 = Level.FINEST;
                return julLevel7;
            default:
                return null;
        }
    }
}
