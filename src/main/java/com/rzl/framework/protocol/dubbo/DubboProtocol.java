package com.rzl.framework.protocol.dubbo;

import com.rzl.framework.Invocation;
import com.rzl.framework.Protocol;
import com.rzl.framework.URL;

public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {
        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        return new NettyClient<>().send(url.getHostname(), url.getPort(), invocation);
    }
}
