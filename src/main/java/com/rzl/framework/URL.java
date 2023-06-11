package com.rzl.framework;

import java.io.Serializable;

/**
 * 封装要注册的信息
 */
public class URL implements Serializable {
    private String protocol;
    private String hostname;
    private Integer port;

    public URL(String protocol, String hostname, Integer port) {
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
