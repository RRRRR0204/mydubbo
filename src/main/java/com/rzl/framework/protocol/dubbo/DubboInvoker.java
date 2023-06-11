package com.rzl.framework.protocol.dubbo;

import com.rzl.framework.Invocation;
import com.rzl.framework.Invoker;
import com.rzl.framework.URL;

public class DubboInvoker implements Invoker {
    private URL url;

    public DubboInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        return new NettyClient<>().send(url.getHostname(), url.getPort(), invocation);
    }
}
