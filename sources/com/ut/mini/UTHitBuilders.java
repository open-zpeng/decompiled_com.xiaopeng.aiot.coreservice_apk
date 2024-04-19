package com.ut.mini;

import android.text.TextUtils;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UTHitBuilders {

    /* loaded from: classes.dex */
    public static class UTHitBuilder {
        public static final String FIELD_ARG1 = "_field_arg1";
        public static final String FIELD_ARG2 = "_field_arg2";
        public static final String FIELD_ARG3 = "_field_arg3";
        public static final String FIELD_ARGS = "_field_args";
        public static final String FIELD_EVENT_ID = "_field_event_id";
        public static final String FIELD_PAGE = "_field_page";
        private Map<String, String> y;

        public UTHitBuilder() {
            HashMap hashMap = new HashMap();
            this.y = hashMap;
            if (!hashMap.containsKey(FIELD_PAGE)) {
                this.y.put(FIELD_PAGE, "UT");
            }
        }

        public UTHitBuilder setProperty(String aKey, String aValue) {
            if (!TextUtils.isEmpty(aKey) && aValue != null) {
                if (this.y.containsKey(aKey)) {
                    this.y.remove(aKey);
                }
                this.y.put(aKey, aValue);
            } else {
                vj.a("setProperty", "key is null or key is empty or value is null,please check it!");
            }
            return this;
        }

        public UTHitBuilder setProperties(Map<String, String> aProperties) {
            if (aProperties != null) {
                this.y.putAll(aProperties);
            }
            return this;
        }

        public String getProperty(String aKey) {
            if (aKey != null && this.y.containsKey(aKey)) {
                return this.y.get(aKey);
            }
            return null;
        }

        public Map<String, String> build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.y);
            if (a(hashMap)) {
                e(hashMap);
                d(hashMap);
                if (hashMap.containsKey(LogField.EVENTID.toString())) {
                    return hashMap;
                }
                return null;
            }
            return null;
        }

        private static boolean a(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(null)) {
                    map.remove(null);
                }
                if (map.containsKey("")) {
                    map.remove("");
                }
                if (map.containsKey(LogField.PAGE.toString())) {
                    vj.a("checkIlleagleProperty", "IlleaglePropertyKey(PAGE) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.EVENTID.toString())) {
                    vj.a("checkIlleagleProperty", "IlleaglePropertyKey(EVENTID) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG1.toString())) {
                    vj.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG1) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG2.toString())) {
                    vj.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG2) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else if (map.containsKey(LogField.ARG3.toString())) {
                    vj.a("checkIlleagleProperty", "IlleaglePropertyKey(ARG3) is setted when you call the method setProperty or setProperties ,please use another key to replace it!");
                    return false;
                } else {
                    return true;
                }
            }
            return true;
        }

        private static void d(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey(FIELD_PAGE)) {
                    map.remove(FIELD_PAGE);
                    map.put(LogField.PAGE.toString(), map.get(FIELD_PAGE));
                }
                if (map.containsKey(FIELD_ARG1)) {
                    map.remove(FIELD_ARG1);
                    map.put(LogField.ARG1.toString(), map.get(FIELD_ARG1));
                }
                if (map.containsKey(FIELD_ARG2)) {
                    map.remove(FIELD_ARG2);
                    map.put(LogField.ARG2.toString(), map.get(FIELD_ARG2));
                }
                if (map.containsKey(FIELD_ARG3)) {
                    map.remove(FIELD_ARG3);
                    map.put(LogField.ARG3.toString(), map.get(FIELD_ARG3));
                }
                if (map.containsKey(FIELD_ARGS)) {
                    map.remove(FIELD_ARGS);
                    map.put(LogField.ARGS.toString(), map.get(FIELD_ARGS));
                }
                if (map.containsKey(FIELD_EVENT_ID)) {
                    map.remove(FIELD_EVENT_ID);
                    map.put(LogField.EVENTID.toString(), map.get(FIELD_EVENT_ID));
                }
            }
        }

        private static void e(Map<String, String> map) {
            if (map != null) {
                LogField logField = LogField.PAGE;
                if (map.containsKey(logField.toString())) {
                    map.remove(logField.toString());
                }
                LogField logField2 = LogField.EVENTID;
                if (map.containsKey(logField2.toString())) {
                    map.remove(logField2.toString());
                }
                LogField logField3 = LogField.ARG1;
                if (map.containsKey(logField3.toString())) {
                    map.remove(logField3.toString());
                }
                LogField logField4 = LogField.ARG2;
                if (map.containsKey(logField4.toString())) {
                    map.remove(logField4.toString());
                }
                LogField logField5 = LogField.ARG3;
                if (map.containsKey(logField5.toString())) {
                    map.remove(logField5.toString());
                }
                LogField logField6 = LogField.ARGS;
                if (map.containsKey(logField6.toString())) {
                    map.remove(logField6.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UTCustomHitBuilder extends UTHitBuilder {
        public UTCustomHitBuilder(String aEventLabel) {
            if (!TextUtils.isEmpty(aEventLabel)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, aEventLabel);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "19999");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTCustomHitBuilder setDurationOnEvent(long aDuration) {
            if (aDuration < 0) {
                aDuration = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + aDuration);
            return this;
        }

        public UTCustomHitBuilder setEventPage(String aPage) {
            if (!TextUtils.isEmpty(aPage)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, aPage);
            }
            return this;
        }

        @Override // com.ut.mini.UTHitBuilders.UTHitBuilder
        public Map<String, String> build() {
            Map<String, String> build = super.build();
            if (build != null) {
                LogField logField = LogField.PAGE;
                String str = build.get(logField.toString());
                LogField logField2 = LogField.ARG1;
                String str2 = build.get(logField2.toString());
                if (str2 != null) {
                    build.remove(logField2.toString());
                    build.remove(logField.toString());
                    Map<String, String> a = ck.a(build);
                    a.put(logField2.toString(), str2);
                    a.put(logField.toString(), str);
                    return a;
                }
            }
            return build;
        }
    }

    /* loaded from: classes.dex */
    public static class UTPageHitBuilder extends UTHitBuilder {
        public UTPageHitBuilder(String aPageName) {
            if (!TextUtils.isEmpty(aPageName)) {
                super.setProperty(UTHitBuilder.FIELD_PAGE, aPageName);
            }
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2001");
            super.setProperty(UTHitBuilder.FIELD_ARG3, "0");
        }

        public UTPageHitBuilder setReferPage(String aReferPage) {
            if (!TextUtils.isEmpty(aReferPage)) {
                super.setProperty(UTHitBuilder.FIELD_ARG1, aReferPage);
            }
            return this;
        }

        public UTPageHitBuilder setDurationOnPage(long aDuration) {
            if (aDuration < 0) {
                aDuration = 0;
            }
            super.setProperty(UTHitBuilder.FIELD_ARG3, "" + aDuration);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class UTControlHitBuilder extends UTHitBuilder {
        public UTControlHitBuilder(String aControlName) {
            if (TextUtils.isEmpty(aControlName)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            if (TextUtils.isEmpty(currentPageName)) {
                throw new IllegalArgumentException("Please call in at PageAppear and PageDisAppear.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, currentPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, currentPageName + "_" + aControlName);
        }

        public UTControlHitBuilder(String aPageName, String aControlName) {
            if (TextUtils.isEmpty(aControlName)) {
                throw new IllegalArgumentException("Control name can not be empty.");
            }
            if (TextUtils.isEmpty(aPageName)) {
                throw new IllegalArgumentException("Page name can not be empty.");
            }
            super.setProperty(UTHitBuilder.FIELD_PAGE, aPageName);
            super.setProperty(UTHitBuilder.FIELD_EVENT_ID, "2101");
            super.setProperty(UTHitBuilder.FIELD_ARG1, aPageName + "_" + aControlName);
        }
    }
}
