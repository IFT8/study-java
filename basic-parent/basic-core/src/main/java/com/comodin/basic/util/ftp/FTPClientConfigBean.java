package com.comodin.basic.util.ftp;

@SuppressWarnings({"WeakerAccess", "unused"})
public class FTPClientConfigBean {
    private String host;
    private int port = 21;
    private String username;
    private String password;
    private boolean binaryTransfer = true;
    private boolean passiveMode = true;
    private String encoding = "UTF8";
    private int clientTimeout = 500;
    private int bufferSize = 1024;


    public FTPClientConfigBean(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    public FTPClientConfigBean(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public FTPClientConfigBean(String host, int port, String username, String password, String encoding) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.encoding = encoding;
    }

    public FTPClientConfigBean(String host, int port, String username, String password, boolean binaryTransfer, boolean passiveMode, String encoding, int clientTimeout, int bufferSize) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.binaryTransfer = binaryTransfer;
        this.passiveMode = passiveMode;
        this.encoding = encoding;
        this.clientTimeout = clientTimeout;
        this.bufferSize = bufferSize;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBinaryTransfer() {
        return binaryTransfer;
    }

    public void setBinaryTransfer(boolean binaryTransfer) {
        this.binaryTransfer = binaryTransfer;
    }

    public boolean isPassiveMode() {
        return passiveMode;
    }

    public void setPassiveMode(boolean passiveMode) {
        this.passiveMode = passiveMode;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public int getClientTimeout() {
        return clientTimeout;
    }

    public void setClientTimeout(int clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }
}
