package defpackage;

import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import defpackage.nv;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.android.service.MqttService;
/* compiled from: MqttConnection.java */
/* renamed from: ov  reason: default package */
/* loaded from: classes.dex */
public class ov implements ew {
    public String a;
    public String b;
    public fw c;
    public gw d;
    public String e;
    public MqttService i;
    public String r;
    public String f = null;
    public cw g = null;
    public lv h = null;
    public volatile boolean j = true;
    public boolean k = true;
    public volatile boolean l = false;
    public Map<zv, String> m = new HashMap();
    public Map<zv, jw> n = new HashMap();
    public Map<zv, String> o = new HashMap();
    public Map<zv, String> p = new HashMap();
    public PowerManager.WakeLock q = null;
    public wv s = null;

    public String o() {
        return this.a;
    }

    public String n() {
        return this.b;
    }

    /* compiled from: MqttConnection.java */
    /* renamed from: ov$d */
    /* loaded from: classes.dex */
    public class d extends cw {
        public ay p;

        public d(String serverURI, String clientId, fw persistence, mw pingSender) throws iw {
            super(serverURI, clientId, persistence, pingSender, null);
            this.p = new ay();
        }

        public void H(xv listener) throws iw {
            qw qwVar = this.g;
            if (qwVar != null && qwVar.B()) {
                ow token = new ow(b());
                token.i(listener);
                token.j(null);
                this.g.H(this.p, token);
            }
        }
    }

    public ov(MqttService service, String serverURI, String clientId, fw persistence, String clientHandle) {
        this.c = null;
        this.i = null;
        this.r = null;
        this.a = serverURI;
        this.i = service;
        this.b = clientId;
        this.c = persistence;
        this.e = clientHandle;
        this.r = getClass().getCanonicalName() + " " + clientId + " on host " + serverURI;
    }

    public void h(gw options, String invocationContext, String activityToken) {
        this.d = options;
        this.f = activityToken;
        if (options != null) {
            this.k = options.o();
        }
        if (this.d.o()) {
            this.i.f.d(this.e);
        }
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "Connecting {" + this.a + "} as {" + this.b + "}");
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", invocationContext);
        resultBundle.putString("MqttService.callbackAction", "connect");
        try {
            if (this.c == null) {
                File myDir = null;
                if (0 != 0 || (myDir = this.i.getDir("MqttConnection", 0)) != null) {
                    this.c = new ty(myDir.getAbsolutePath());
                } else {
                    resultBundle.putString("MqttService.errorMessage", "Error! No external and internal storage available");
                    resultBundle.putSerializable("MqttService.exception", new lw());
                    this.i.k(this.e, uv.ERROR, resultBundle);
                    return;
                }
            }
            xv listener = new a(resultBundle, resultBundle);
            if (this.g == null) {
                this.h = new lv(this.i, this);
                d dVar = new d(this.a, this.b, this.c, this.h);
                this.g = dVar;
                dVar.C(this);
                this.i.traceDebug("MqttConnection", "Do Real connect!");
                x(true);
                this.g.r(this.d, invocationContext, listener);
            } else if (this.l) {
                this.i.traceDebug("MqttConnection", "myClient != null and the client is connecting. Connect return directly.");
                MqttService mqttService2 = this.i;
                mqttService2.traceDebug("MqttConnection", "Connect return:isConnecting:" + this.l + ".disconnected:" + this.j);
            } else if (!this.j) {
                this.i.traceDebug("MqttConnection", "myClient != null and the client is connected and notify!");
                m(resultBundle);
            } else {
                this.i.traceDebug("MqttConnection", "myClient != null and the client is not connected");
                this.i.traceDebug("MqttConnection", "Do Real connect!");
                x(true);
                this.g.r(this.d, invocationContext, listener);
            }
        } catch (Exception e2) {
            MqttService mqttService3 = this.i;
            mqttService3.traceError("MqttConnection", "Exception occurred attempting to connect: " + e2.getMessage());
            x(false);
            p(resultBundle, e2);
        }
    }

    /* compiled from: MqttConnection.java */
    /* renamed from: ov$a */
    /* loaded from: classes.dex */
    public class a extends e {
        public final /* synthetic */ Bundle c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Bundle resultBundle, Bundle bundle) {
            super(ov.this, resultBundle, null);
            this.c = bundle;
        }

        @Override // defpackage.ov.e, defpackage.xv
        public void onSuccess(bw asyncActionToken) {
            ov.this.m(this.c);
            ov.this.i.traceDebug("MqttConnection", "connect success!");
        }

        @Override // defpackage.ov.e, defpackage.xv
        public void onFailure(bw asyncActionToken, Throwable exception) {
            this.c.putString("MqttService.errorMessage", exception.getLocalizedMessage());
            this.c.putSerializable("MqttService.exception", exception);
            MqttService mqttService = ov.this.i;
            mqttService.traceError("MqttConnection", "connect fail, call connect to reconnect.reason:" + exception.getMessage());
            ov.this.l(this.c);
        }
    }

    public final void m(Bundle resultBundle) {
        e();
        this.i.k(this.e, uv.OK, resultBundle);
        i();
        x(false);
        this.j = false;
        v();
    }

    @Override // defpackage.ew
    public void connectComplete(boolean reconnect, String serverURI) {
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.callbackAction", "connectExtended");
        resultBundle.putBoolean("MqttService.reconnect", reconnect);
        resultBundle.putString("MqttService.serverURI", serverURI);
        this.i.k(this.e, uv.OK, resultBundle);
    }

    public final void l(Bundle resultBundle) {
        e();
        this.j = true;
        x(false);
        this.i.k(this.e, uv.ERROR, resultBundle);
        v();
    }

    public final void p(Bundle resultBundle, Exception e2) {
        resultBundle.putString("MqttService.errorMessage", e2.getLocalizedMessage());
        resultBundle.putSerializable("MqttService.exception", e2);
        this.i.k(this.e, uv.ERROR, resultBundle);
    }

    public final void i() {
        Iterator<nv.a> a2 = this.i.f.a(this.e);
        while (a2.hasNext()) {
            nv.a msgArrived = a2.next();
            Bundle resultBundle = r(msgArrived.a(), msgArrived.b(), msgArrived.getMessage());
            resultBundle.putString("MqttService.callbackAction", "messageArrived");
            this.i.k(this.e, uv.OK, resultBundle);
        }
    }

    public final Bundle r(String messageId, String topic, jw message) {
        Bundle result = new Bundle();
        result.putString("MqttService.messageId", messageId);
        result.putString("MqttService.destinationName", topic);
        result.putParcelable("MqttService.PARCEL", new tv(message));
        return result;
    }

    public void g() {
        this.i.traceDebug("MqttConnection", "close()");
        try {
            cw cwVar = this.g;
            if (cwVar != null) {
                cwVar.q(true);
                this.g = null;
            }
        } catch (iw e2) {
            p(new Bundle(), e2);
        }
    }

    public void j(String invocationContext, String activityToken) {
        this.i.traceDebug("MqttConnection", "disconnect()");
        this.j = true;
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", invocationContext);
        resultBundle.putString("MqttService.callbackAction", "disconnect");
        cw cwVar = this.g;
        if (cwVar != null && cwVar.y()) {
            xv listener = new e(this, resultBundle, null);
            try {
                this.g.v(invocationContext, listener);
                this.h.stop();
            } catch (Exception e2) {
                p(resultBundle, e2);
            }
        } else {
            resultBundle.putString("MqttService.errorMessage", "not connected");
            this.i.traceError("disconnect", "not connected");
            this.i.k(this.e, uv.ERROR, resultBundle);
        }
        gw gwVar = this.d;
        if (gwVar != null && gwVar.o()) {
            this.i.f.d(this.e);
        }
        v();
    }

    public void k(String invocationContext, String activityToken) {
        this.i.traceDebug("MqttConnection", "disconnect()");
        this.j = true;
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", invocationContext);
        resultBundle.putString("MqttService.callbackAction", "disconnect");
        cw cwVar = this.g;
        if (cwVar != null && cwVar.y()) {
            new e(this, resultBundle, null);
            try {
                this.g.w(10000L, 5000L, false);
                this.h.stop();
            } catch (Exception e2) {
                p(resultBundle, e2);
            }
        } else {
            resultBundle.putString("MqttService.errorMessage", "not connected");
            this.i.traceError("disconnect", "not connected");
            this.i.k(this.e, uv.ERROR, resultBundle);
        }
        gw gwVar = this.d;
        if (gwVar != null && gwVar.o()) {
            this.i.f.d(this.e);
        }
        v();
    }

    public void f(String activityToken) {
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.callbackAction", "send");
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", null);
        cw cwVar = this.g;
        if (cwVar != null && cwVar.y()) {
            xv listener = new e(this, resultBundle, null);
            try {
                cw cwVar2 = this.g;
                if (cwVar2 instanceof d) {
                    ((d) cwVar2).H(listener);
                    return;
                }
                return;
            } catch (Exception e2) {
                p(resultBundle, e2);
                return;
            }
        }
        resultBundle.putString("MqttService.errorMessage", "not connected");
        this.i.traceError("send", "not connected");
        this.i.k(this.e, uv.ERROR, resultBundle);
    }

    public boolean q() {
        cw cwVar = this.g;
        return cwVar != null && cwVar.y();
    }

    public zv t(String topic, jw message, String invocationContext, String activityToken) {
        wv wvVar;
        zv sendToken;
        Exception e2;
        zv sendToken2;
        Exception e3;
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.callbackAction", "send");
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", invocationContext);
        cw cwVar = this.g;
        if (cwVar != null && cwVar.y()) {
            xv listener = new e(this, resultBundle, null);
            try {
                sendToken2 = this.g.z(topic, message, invocationContext, listener);
            } catch (Exception e4) {
                sendToken2 = null;
                e3 = e4;
            }
            try {
                y(topic, message, sendToken2, invocationContext, activityToken);
                return sendToken2;
            } catch (Exception e5) {
                e3 = e5;
                p(resultBundle, e3);
                return sendToken2;
            }
        } else if (this.g != null && (wvVar = this.s) != null && wvVar.b()) {
            xv listener2 = new e(this, resultBundle, null);
            try {
                sendToken = this.g.z(topic, message, invocationContext, listener2);
            } catch (Exception e6) {
                sendToken = null;
                e2 = e6;
            }
            try {
                y(topic, message, sendToken, invocationContext, activityToken);
                return sendToken;
            } catch (Exception e7) {
                e2 = e7;
                p(resultBundle, e2);
                return sendToken;
            }
        } else {
            Log.i("MqttConnection", "Client is not connected, so not sending message");
            resultBundle.putString("MqttService.errorMessage", "not connected");
            this.i.traceError("send", "not connected");
            this.i.k(this.e, uv.ERROR, resultBundle);
            return null;
        }
    }

    public void z(String topic, int qos, String invocationContext, String activityToken) {
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "subscribe({" + topic + "}," + qos + ",{" + invocationContext + "}, {" + activityToken + "}");
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.callbackAction", "subscribe");
        resultBundle.putString("MqttService.activityToken", activityToken);
        resultBundle.putString("MqttService.invocationContext", invocationContext);
        cw cwVar = this.g;
        if (cwVar != null && cwVar.y()) {
            xv listener = new e(this, resultBundle, null);
            try {
                this.g.F(topic, qos, invocationContext, listener);
                return;
            } catch (Exception e2) {
                p(resultBundle, e2);
                return;
            }
        }
        resultBundle.putString("MqttService.errorMessage", "not connected");
        this.i.traceError("subscribe", "not connected");
        this.i.k(this.e, uv.ERROR, resultBundle);
    }

    @Override // defpackage.dw
    public void connectionLost(Throwable why) {
        MqttService mqttService = this.i;
        StringBuilder sb = new StringBuilder();
        sb.append("connectionLost(");
        sb.append(why == null ? "" : why.getMessage());
        sb.append(")");
        mqttService.traceDebug("MqttConnection", sb.toString());
        this.j = true;
        try {
            if (!this.d.n()) {
                this.g.v(null, new b());
            } else {
                this.h.a(100L);
            }
        } catch (Exception e2) {
            MqttService mqttService2 = this.i;
            mqttService2.traceDebug("MqttConnection", "disconnect fail, exception:" + e2);
        }
        Bundle resultBundle = new Bundle();
        resultBundle.putString("MqttService.callbackAction", "onConnectionLost");
        if (why != null) {
            resultBundle.putString("MqttService.errorMessage", why.getMessage());
            if (why instanceof iw) {
                resultBundle.putSerializable("MqttService.exception", why);
            }
            resultBundle.putString("MqttService.exceptionStack", Log.getStackTraceString(why));
        }
        this.i.k(this.e, uv.OK, resultBundle);
        v();
    }

    /* compiled from: MqttConnection.java */
    /* renamed from: ov$b */
    /* loaded from: classes.dex */
    public class b implements xv {
        public b() {
        }

        @Override // defpackage.xv
        public void onSuccess(bw asyncActionToken) {
            ov.this.i.traceDebug("MqttConnection", "disconnect onSuccess");
        }

        @Override // defpackage.xv
        public void onFailure(bw asyncActionToken, Throwable exception) {
            MqttService mqttService = ov.this.i;
            mqttService.traceDebug("MqttConnection", "disconnect onFailure, exception:" + exception);
        }
    }

    @Override // defpackage.dw
    public void deliveryComplete(zv messageToken) {
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "deliveryComplete(" + messageToken + ")");
        jw message = this.n.remove(messageToken);
        if (message != null) {
            String topic = this.m.remove(messageToken);
            String activityToken = this.o.remove(messageToken);
            String invocationContext = this.p.remove(messageToken);
            Bundle resultBundle = r(null, topic, message);
            if (activityToken != null) {
                resultBundle.putString("MqttService.callbackAction", "send");
                resultBundle.putString("MqttService.activityToken", activityToken);
                resultBundle.putString("MqttService.invocationContext", invocationContext);
                this.i.k(this.e, uv.OK, resultBundle);
            }
            resultBundle.putString("MqttService.callbackAction", "messageDelivered");
            this.i.k(this.e, uv.OK, resultBundle);
        }
    }

    @Override // defpackage.dw
    public void messageArrived(String topic, jw message) throws Exception {
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "messageArrived(" + topic + ",{" + message.toString() + "})");
        String messageId = this.i.f.c(this.e, topic, message);
        Bundle resultBundle = r(messageId, topic, message);
        resultBundle.putString("MqttService.callbackAction", "messageArrived");
        resultBundle.putString("MqttService.messageId", messageId);
        this.i.k(this.e, uv.OK, resultBundle);
    }

    public final void y(String topic, jw msg, zv messageToken, String invocationContext, String activityToken) {
        this.m.put(messageToken, topic);
        this.n.put(messageToken, msg);
        this.o.put(messageToken, activityToken);
        this.p.put(messageToken, invocationContext);
    }

    public final void e() {
        if (this.q == null) {
            PowerManager pm = (PowerManager) this.i.getSystemService("power");
            this.q = pm.newWakeLock(1, this.r);
        }
        this.q.acquire();
    }

    public final void v() {
        PowerManager.WakeLock wakeLock = this.q;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.q.release();
        }
    }

    /* compiled from: MqttConnection.java */
    /* renamed from: ov$e */
    /* loaded from: classes.dex */
    public class e implements xv {
        public final Bundle a;

        public /* synthetic */ e(ov x0, Bundle x1, a x2) {
            this(x1);
        }

        public e(Bundle resultBundle) {
            this.a = resultBundle;
        }

        @Override // defpackage.xv
        public void onSuccess(bw asyncActionToken) {
            ov.this.i.k(ov.this.e, uv.OK, this.a);
        }

        @Override // defpackage.xv
        public void onFailure(bw asyncActionToken, Throwable exception) {
            this.a.putString("MqttService.errorMessage", exception.getLocalizedMessage());
            this.a.putSerializable("MqttService.exception", exception);
            ov.this.i.k(ov.this.e, uv.ERROR, this.a);
        }
    }

    public void s() {
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "start offline. disconnected:" + this.j + " cleanSession:" + this.k);
        if (!this.j && !this.k) {
            Exception e2 = new Exception("Android offline");
            connectionLost(e2);
        }
    }

    public synchronized void u() {
        MqttService mqttService = this.i;
        mqttService.traceDebug("MqttConnection", "start reconnect, disconnected:" + this.j + " cleanSession:" + this.k);
        if (this.g == null) {
            this.i.traceError("MqttConnection", "Reconnect myClient = null. Will not do reconnect");
        } else if (this.l) {
            this.i.traceDebug("MqttConnection", "The client is connecting. Reconnect return directly.");
        } else if (!this.i.s()) {
            this.i.traceDebug("MqttConnection", "The network is not reachable. Will not do reconnect");
        } else {
            if (this.d.n()) {
                this.i.traceDebug("MqttConnection", "Requesting Automatic reconnect using New Java AC");
                Bundle resultBundle = new Bundle();
                resultBundle.putString("MqttService.activityToken", this.f);
                resultBundle.putString("MqttService.invocationContext", null);
                resultBundle.putString("MqttService.callbackAction", "connect");
                try {
                    this.g.A();
                } catch (iw ex) {
                    Log.e("MqttConnection", "Exception occurred attempting to reconnect: " + ex.getMessage());
                    x(false);
                    p(resultBundle, ex);
                }
                return;
            }
            if (this.j && !this.k) {
                this.i.traceDebug("MqttConnection", "Do Real Reconnect!");
                Bundle resultBundle2 = new Bundle();
                resultBundle2.putString("MqttService.activityToken", this.f);
                resultBundle2.putString("MqttService.invocationContext", null);
                resultBundle2.putString("MqttService.callbackAction", "connect");
                try {
                    xv listener = new c(resultBundle2, resultBundle2);
                    this.g.r(this.d, null, listener);
                    x(true);
                } catch (iw e2) {
                    MqttService mqttService2 = this.i;
                    mqttService2.traceError("MqttConnection", "Cannot reconnect to remote server." + e2.getMessage());
                    x(false);
                    p(resultBundle2, e2);
                } catch (Exception e3) {
                    MqttService mqttService3 = this.i;
                    mqttService3.traceError("MqttConnection", "Cannot reconnect to remote server." + e3.getMessage());
                    x(false);
                    iw newEx = new iw(6, e3.getCause());
                    p(resultBundle2, newEx);
                }
            }
            return;
        }
    }

    /* compiled from: MqttConnection.java */
    /* renamed from: ov$c */
    /* loaded from: classes.dex */
    public class c extends e {
        public final /* synthetic */ Bundle c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Bundle resultBundle, Bundle bundle) {
            super(ov.this, resultBundle, null);
            this.c = bundle;
        }

        @Override // defpackage.ov.e, defpackage.xv
        public void onSuccess(bw asyncActionToken) {
            ov.this.i.traceDebug("MqttConnection", "Reconnect Success!");
            ov.this.i.traceDebug("MqttConnection", "DeliverBacklog when reconnect.");
            ov.this.m(this.c);
        }

        @Override // defpackage.ov.e, defpackage.xv
        public void onFailure(bw asyncActionToken, Throwable exception) {
            this.c.putString("MqttService.errorMessage", exception.getLocalizedMessage());
            this.c.putSerializable("MqttService.exception", exception);
            ov.this.i.k(ov.this.e, uv.ERROR, this.c);
            ov.this.l(this.c);
        }
    }

    public final synchronized void x(boolean isConnecting) {
        this.l = isConnecting;
    }

    public void w(wv bufferOpts) {
        this.s = bufferOpts;
        this.g.B(bufferOpts);
    }
}
