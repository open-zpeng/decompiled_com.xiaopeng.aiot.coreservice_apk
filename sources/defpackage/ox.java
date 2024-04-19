package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: WebSocketHandshake.java */
/* renamed from: ox  reason: default package */
/* loaded from: classes.dex */
public class ox {
    public InputStream a;
    public OutputStream b;
    public String c;
    public String d;
    public int e;

    public ox(InputStream input, OutputStream output, String uri, String host, int port) {
        this.a = input;
        this.b = output;
        this.c = uri;
        this.d = host;
        this.e = port;
    }

    public void a() throws IOException {
        byte[] key = new byte[16];
        System.arraycopy(UUID.randomUUID().toString().getBytes(), 0, key, 0, 16);
        String b64Key = kx.b(key);
        d(b64Key);
        c(b64Key);
    }

    public final void d(String key) throws IOException {
        try {
            String path = "/mqtt";
            URI srvUri = new URI(this.c);
            if (srvUri.getRawPath() != null && !srvUri.getRawPath().isEmpty()) {
                path = srvUri.getRawPath();
                if (srvUri.getRawQuery() != null && !srvUri.getRawQuery().isEmpty()) {
                    path = String.valueOf(path) + "?" + srvUri.getRawQuery();
                }
            }
            PrintWriter pw = new PrintWriter(this.b);
            pw.print("GET " + path + " HTTP/1.1\r\n");
            int i = this.e;
            if (i != 80 && i != 443) {
                pw.print("Host: " + this.d + ":" + this.e + "\r\n");
            } else {
                pw.print("Host: " + this.d + "\r\n");
            }
            pw.print("Upgrade: websocket\r\n");
            pw.print("Connection: Upgrade\r\n");
            pw.print("Sec-WebSocket-Key: " + key + "\r\n");
            pw.print("Sec-WebSocket-Protocol: mqtt\r\n");
            pw.print("Sec-WebSocket-Version: 13\r\n");
            String userInfo = srvUri.getUserInfo();
            if (userInfo != null) {
                pw.print("Authorization: Basic " + kx.a(userInfo) + "\r\n");
            }
            pw.print("\r\n");
            pw.flush();
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public final void c(String key) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(this.a));
        ArrayList responseLines = new ArrayList();
        String line = in.readLine();
        if (line == null) {
            throw new IOException("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
        }
        while (!line.equals("")) {
            responseLines.add(line);
            line = in.readLine();
        }
        Map headerMap = b(responseLines);
        String connectionHeader = (String) headerMap.get("connection");
        if (connectionHeader == null || connectionHeader.equalsIgnoreCase("upgrade")) {
            throw new IOException("WebSocket Response header: Incorrect connection header");
        }
        String upgradeHeader = (String) headerMap.get("upgrade");
        if (upgradeHeader == null || !upgradeHeader.toLowerCase().contains("websocket")) {
            throw new IOException("WebSocket Response header: Incorrect upgrade.");
        }
        String secWebsocketProtocolHeader = (String) headerMap.get("sec-websocket-protocol");
        if (secWebsocketProtocolHeader == null) {
            throw new IOException("WebSocket Response header: empty sec-websocket-protocol");
        }
        if (!headerMap.containsKey("sec-websocket-accept")) {
            throw new IOException("WebSocket Response header: Missing Sec-WebSocket-Accept");
        }
        try {
            f(key, (String) headerMap.get("sec-websocket-accept"));
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e.getMessage());
        } catch (mx e2) {
            throw new IOException("WebSocket Response header: Incorrect Sec-WebSocket-Key");
        }
    }

    public final Map b(ArrayList headers) {
        Map headerMap = new HashMap();
        for (int i = 1; i < headers.size(); i++) {
            String headerPre = (String) headers.get(i);
            String[] header = headerPre.split(":");
            headerMap.put(header[0].toLowerCase(), header[1]);
        }
        return headerMap;
    }

    public final void f(String key, String accept) throws NoSuchAlgorithmException, mx {
        byte[] sha1Bytes = e(String.valueOf(key) + WebSocketProtocol.ACCEPT_MAGIC);
        String encodedSha1Bytes = kx.b(sha1Bytes).trim();
        if (!encodedSha1Bytes.equals(accept.trim())) {
            throw new mx();
        }
    }

    public final byte[] e(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        return result;
    }
}
