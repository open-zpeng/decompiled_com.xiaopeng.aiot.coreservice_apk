package com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain;

import com.lzy.okgo.model.HttpHeaders;
import com.xiaopeng.lib.framework.netchannelmodule.http.statistic.SocketCounter;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingInputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.CountingOutputStream;
import com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketOptions;
/* loaded from: classes.dex */
public class HookPlainSocketKitKatImpl extends SocketImpl implements SocketOptions {
    private Field mAddress;
    private String mDomain;
    private Field mFd;
    private Method mHookAccept;
    private Method mHookAvailable;
    private Method mHookBind;
    private Method mHookClose;
    private Method mHookConnectHostPort;
    private Method mHookConnectInetAddrPort;
    private Method mHookConnectSocketAddrPort;
    private Method mHookCreate;
    private Method mHookGetFileDescriptor;
    private Method mHookGetInputStream;
    private Method mHookGetOutputStream;
    private Method mHookListen;
    private Method mHookSendUrgentData;
    private CountingInputStream mInputStream;
    private CountingOutputStream mOutputStream;
    private Field mPort;
    private final SocketImpl mSocketImpl;
    private final String TAG = "SocketImplHook";
    private ICollector mCollector = new ICollector() { // from class: com.xiaopeng.lib.framework.netchannelmodule.http.traffic.plain.HookPlainSocketKitKatImpl.1
        @Override // com.xiaopeng.lib.framework.netchannelmodule.http.traffic.ICollector
        public String getDomain() {
            return HookPlainSocketKitKatImpl.this.mDomain == null ? "" : HookPlainSocketKitKatImpl.this.mDomain;
        }
    };

    public HookPlainSocketKitKatImpl(SocketImpl socketImpl) {
        boolean reflected = true;
        if (socketImpl != null) {
            try {
                Class<?> clazz = socketImpl.getClass();
                this.mHookCreate = clazz.getDeclaredMethod("create", Boolean.TYPE);
                Class<?> cls = Integer.TYPE;
                this.mHookConnectHostPort = clazz.getDeclaredMethod("connect", String.class, cls);
                this.mHookConnectInetAddrPort = clazz.getDeclaredMethod("connect", InetAddress.class, cls);
                this.mHookConnectSocketAddrPort = clazz.getDeclaredMethod("connect", SocketAddress.class, cls);
                this.mHookBind = clazz.getDeclaredMethod("bind", InetAddress.class, cls);
                this.mHookListen = clazz.getDeclaredMethod("listen", cls);
                this.mHookAccept = clazz.getDeclaredMethod("accept", SocketImpl.class);
                this.mHookGetInputStream = clazz.getDeclaredMethod("getInputStream", new Class[0]);
                this.mHookGetOutputStream = clazz.getDeclaredMethod("getOutputStream", new Class[0]);
                this.mHookAvailable = clazz.getDeclaredMethod("available", new Class[0]);
                this.mHookClose = clazz.getDeclaredMethod(HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, new Class[0]);
                this.mHookCreate.setAccessible(true);
                this.mHookConnectHostPort.setAccessible(true);
                this.mHookConnectInetAddrPort.setAccessible(true);
                this.mHookConnectSocketAddrPort.setAccessible(true);
                this.mHookBind.setAccessible(true);
                this.mHookGetInputStream.setAccessible(true);
                this.mHookGetOutputStream.setAccessible(true);
                this.mHookAvailable.setAccessible(true);
                this.mHookClose.setAccessible(true);
                this.mHookSendUrgentData = clazz.getDeclaredMethod("sendUrgentData", cls);
                Method method = clazz.getMethod("getFD$", new Class[0]);
                this.mHookGetFileDescriptor = method;
                method.setAccessible(true);
                hookSuperClassMembers(clazz);
            } catch (Exception e) {
                reflected = false;
                pn.b("SocketImplHook", null, e);
            }
        }
        if (reflected) {
            this.mSocketImpl = socketImpl;
        } else {
            this.mSocketImpl = null;
        }
        ((SocketImpl) this).fd = new FileDescriptor();
    }

    private void hookSuperClassMembers(Class<?> clazz) throws NoSuchFieldException {
        Class superClazz = clazz.getSuperclass();
        if (SocketImpl.class.getName().equals(superClazz.getName())) {
            this.mAddress = superClazz.getDeclaredField("address");
            this.mPort = superClazz.getDeclaredField("port");
            this.mFd = superClazz.getDeclaredField("fd");
            this.mAddress.setAccessible(true);
            this.mPort.setAccessible(true);
            this.mFd.setAccessible(true);
        }
    }

    @Override // java.net.SocketImpl
    public void create(boolean stream) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookCreate) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, Boolean.valueOf(stream));
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void connect(String host, int port) throws IOException {
        Method method;
        if (this.mAddress != null) {
            pn.a("SocketImplHook", "host=" + host + ",port=" + port);
            StringBuilder sb = new StringBuilder();
            sb.append(host);
            sb.append(":");
            sb.append(host);
            this.mDomain = sb.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookConnectHostPort) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, host, Integer.valueOf(port));
            SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void connect(InetAddress address, int port) throws IOException {
        Method method;
        if (address != null) {
            pn.a("SocketImplHook", "InetAddr=" + address.toString() + ", port=" + port);
            StringBuilder sb = new StringBuilder();
            sb.append(address.getHostName());
            sb.append(":");
            sb.append(port);
            this.mDomain = sb.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookConnectInetAddrPort) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, address, Integer.valueOf(port));
            SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void connect(SocketAddress address, int timeout) throws IOException {
        Method method;
        if (address != null) {
            pn.a("SocketImplHook", "SocketAddr=" + address + ",port=" + ((SocketImpl) this).port);
            this.mDomain = address.toString();
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookConnectSocketAddrPort) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, address, Integer.valueOf(timeout));
            SocketCounter.getInstance().increaseRequest(this.mDomain, 0L);
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void bind(InetAddress host, int port) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookBind) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, host, Integer.valueOf(port));
            ((SocketImpl) this).fd = getFileDescriptor();
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void listen(int backlog) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookListen) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, Integer.valueOf(backlog));
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public void accept(SocketImpl s) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookAccept) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, s);
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketImpl
    public InputStream getInputStream() throws IOException {
        Method method;
        CountingInputStream countingInputStream = this.mInputStream;
        if (countingInputStream != null) {
            return countingInputStream;
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookGetInputStream) != null) {
            try {
                InputStream inStream = (InputStream) method.invoke(socketImpl, new Object[0]);
                CountingInputStream countingInputStream2 = new CountingInputStream(this.mCollector, inStream);
                this.mInputStream = countingInputStream2;
                countingInputStream2.setStatisticCounter(SocketCounter.getInstance());
                SocketCounter.getInstance().increaseSucceedWithSize(this.mDomain, 0L);
                return this.mInputStream;
            } catch (Exception e) {
                Throwable t = e.getCause() == null ? e : e.getCause();
                if (t instanceof IOException) {
                    throw ((IOException) t);
                }
                throw new IOException(t);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    public OutputStream getOutputStream() throws IOException {
        Method method;
        CountingOutputStream countingOutputStream = this.mOutputStream;
        if (countingOutputStream != null) {
            return countingOutputStream;
        }
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookGetOutputStream) != null) {
            try {
                OutputStream outStream = (OutputStream) method.invoke(socketImpl, new Object[0]);
                CountingOutputStream countingOutputStream2 = new CountingOutputStream(this.mCollector, outStream);
                this.mOutputStream = countingOutputStream2;
                countingOutputStream2.setStatisticCounter(SocketCounter.getInstance());
                OutputStream outStream2 = this.mOutputStream;
                return outStream2;
            } catch (Exception e) {
                Throwable t = e.getCause() == null ? e : e.getCause();
                if (t instanceof IOException) {
                    throw ((IOException) t);
                }
                throw new IOException(t);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    public int available() throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookAvailable) != null) {
            try {
                int result = ((Integer) method.invoke(socketImpl, new Object[0])).intValue();
                return result;
            } catch (Exception e) {
                Throwable t = e.getCause() == null ? e : e.getCause();
                if (t instanceof IOException) {
                    throw ((IOException) t);
                }
                throw new IOException(t);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    public void close() throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null && (method = this.mHookClose) != null) {
            try {
                method.invoke(socketImpl, new Object[0]);
                CountingInputStream countingInputStream = this.mInputStream;
                if (countingInputStream != null) {
                    countingInputStream.close();
                    this.mInputStream = null;
                }
                CountingOutputStream countingOutputStream = this.mOutputStream;
                if (countingOutputStream != null) {
                    countingOutputStream.close();
                    this.mOutputStream = null;
                    return;
                }
                return;
            } catch (Exception e) {
                Throwable t = e.getCause() == null ? e : e.getCause();
                if (t instanceof IOException) {
                    throw ((IOException) t);
                }
                throw new IOException(t);
            }
        }
        throw new RuntimeException();
    }

    @Override // java.net.SocketImpl
    public boolean supportsUrgentData() {
        return false;
    }

    @Override // java.net.SocketImpl
    public void sendUrgentData(int data) throws IOException {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookSendUrgentData) == null) {
            throw new RuntimeException();
        }
        try {
            method.invoke(socketImpl, Integer.valueOf(data));
        } catch (Exception e) {
            Throwable t = e.getCause() == null ? e : e.getCause();
            if (t instanceof IOException) {
                throw ((IOException) t);
            }
            throw new IOException(t);
        }
    }

    @Override // java.net.SocketOptions
    public void setOption(int optID, Object value) throws SocketException {
        syncWithImpl();
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl != null) {
            socketImpl.setOption(optID, value);
        }
    }

    @Override // java.net.SocketOptions
    public Object getOption(int optID) throws SocketException {
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null) {
            return null;
        }
        Object result = socketImpl.getOption(optID);
        return result;
    }

    @Override // java.net.SocketImpl
    public void shutdownInput() throws IOException {
    }

    @Override // java.net.SocketImpl
    public void shutdownOutput() throws IOException {
    }

    public FileDescriptor getFD$() {
        return getFileDescriptor();
    }

    @Override // java.net.SocketImpl
    public FileDescriptor getFileDescriptor() {
        Method method;
        SocketImpl socketImpl = this.mSocketImpl;
        if (socketImpl == null || (method = this.mHookGetFileDescriptor) == null) {
            return null;
        }
        try {
            FileDescriptor fd = (FileDescriptor) method.invoke(socketImpl, new Object[0]);
            return fd;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void syncWithImpl() {
        FileDescriptor fd = getFileDescriptor();
        if (fd == null || !fd.valid()) {
            try {
                Field field = this.mFd;
                if (field != null) {
                    field.set(this.mSocketImpl, ((SocketImpl) this).fd);
                }
                Field field2 = this.mAddress;
                if (field2 != null) {
                    field2.set(this.mSocketImpl, ((SocketImpl) this).address);
                }
                Field field3 = this.mPort;
                if (field3 != null) {
                    field3.set(this.mSocketImpl, Integer.valueOf(((SocketImpl) this).port));
                }
            } catch (IllegalAccessException ex) {
                pn.a("SocketImplHook", ex.toString());
            }
        }
    }
}
