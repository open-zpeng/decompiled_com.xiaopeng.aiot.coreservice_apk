package defpackage;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* compiled from: ViewParentCompat.java */
/* renamed from: ja  reason: default package */
/* loaded from: classes.dex */
public final class ja {
    public static boolean f(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof x9) {
            return ((x9) parent).p(child, target, nestedScrollAxes, type);
        }
        if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return parent.onStartNestedScroll(child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                    return false;
                }
            } else if (parent instanceof z9) {
                return ((z9) parent).onStartNestedScroll(child, target, nestedScrollAxes);
            } else {
                return false;
            }
        }
        return false;
    }

    public static void e(ViewParent parent, View child, View target, int nestedScrollAxes, int type) {
        if (parent instanceof x9) {
            ((x9) parent).h(child, target, nestedScrollAxes, type);
        } else if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScrollAccepted(child, target, nestedScrollAxes);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e);
                }
            } else if (parent instanceof z9) {
                ((z9) parent).onNestedScrollAccepted(child, target, nestedScrollAxes);
            }
        }
    }

    public static void g(ViewParent parent, View target, int type) {
        if (parent instanceof x9) {
            ((x9) parent).i(target, type);
        } else if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onStopNestedScroll(target);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStopNestedScroll", e);
                }
            } else if (parent instanceof z9) {
                ((z9) parent).onStopNestedScroll(target);
            }
        }
    }

    public static void d(ViewParent parent, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (parent instanceof y9) {
            ((y9) parent).n(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
            return;
        }
        consumed[0] = consumed[0] + dxUnconsumed;
        consumed[1] = consumed[1] + dyUnconsumed;
        if (parent instanceof x9) {
            ((x9) parent).o(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        } else if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScroll", e);
                }
            } else if (parent instanceof z9) {
                ((z9) parent).onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
            }
        }
    }

    public static void c(ViewParent parent, View target, int dx, int dy, int[] consumed, int type) {
        if (parent instanceof x9) {
            ((x9) parent).j(target, dx, dy, consumed, type);
        } else if (type == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    parent.onNestedPreScroll(target, dx, dy, consumed);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedPreScroll", e);
                }
            } else if (parent instanceof z9) {
                ((z9) parent).onNestedPreScroll(target, dx, dy, consumed);
            }
        }
    }

    public static boolean a(ViewParent parent, View target, float velocityX, float velocityY, boolean consumed) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedFling(target, velocityX, velocityY, consumed);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedFling", e);
                return false;
            }
        } else if (parent instanceof z9) {
            return ((z9) parent).onNestedFling(target, velocityX, velocityY, consumed);
        } else {
            return false;
        }
    }

    public static boolean b(ViewParent parent, View target, float velocityX, float velocityY) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return parent.onNestedPreFling(target, velocityX, velocityY);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        } else if (parent instanceof z9) {
            return ((z9) parent).onNestedPreFling(target, velocityX, velocityY);
        } else {
            return false;
        }
    }
}
