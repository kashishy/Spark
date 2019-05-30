package com.example.spark;

public class APIServer {

    private String server_name;
    private String method;
    private int port;
    private String time;
    private String url;
    private String status;


    // Getter Methods

    public String getServer_name() {
        return server_name;
    }

    public String getMethod() {
        return method;
    }

    public int getPort() {
        return port;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
