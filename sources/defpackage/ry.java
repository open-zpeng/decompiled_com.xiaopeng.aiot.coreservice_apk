package defpackage;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/* compiled from: LoggerFactory.java */
/* renamed from: ry  reason: default package */
/* loaded from: classes.dex */
public class ry {
    public static final String a = ry.class.getName();
    public static String b = null;
    public static String c = py.class.getName();

    public static qy a(String messageCatalogName, String loggerID) {
        String loggerClassName = b;
        if (loggerClassName == null) {
            loggerClassName = c;
        }
        qy logger = b(loggerClassName, ResourceBundle.getBundle(messageCatalogName), loggerID, null);
        if (logger == null) {
            throw new MissingResourceException("Error locating the logging class", a, loggerID);
        }
        return logger;
    }

    public static qy b(String loggerClassName, ResourceBundle messageCatalog, String loggerID, String resourceName) {
        try {
            Class logClass = Class.forName(loggerClassName);
            try {
                qy logger = (qy) logClass.newInstance();
                logger.initialise(messageCatalog, loggerID, resourceName);
                return logger;
            } catch (ExceptionInInitializerError e) {
                return null;
            } catch (IllegalAccessException e2) {
                return null;
            } catch (InstantiationException e3) {
                return null;
            } catch (SecurityException e4) {
                return null;
            }
        } catch (ClassNotFoundException e5) {
            return null;
        } catch (NoClassDefFoundError e6) {
            return null;
        }
    }

    public static void c(String loggerClassName) {
        b = loggerClassName;
    }
}
