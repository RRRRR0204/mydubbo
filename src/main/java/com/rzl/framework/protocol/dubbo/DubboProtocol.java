package com.rzl.framework.protocol.dubbo;

import com.rzl.framework.Invocation;
import com.rzl.framework.Invoker;
import com.rzl.framework.Protocol;
import com.rzl.framework.URL;
import com.rzl.framework.register.LocalRegister;
import com.rzl.framework.register.RemoteMapRegister;

public class DubboProtocol implements Protocol {
    @Override
    public void export(URL url) {
        LocalRegister.regist(url.getInterfaceName(), url.getImplClass());
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new DubboInvoker(url);
    }


//    @Override
//    public void start(URL url) {
//        new NettyServer().start(url.getHostname(), url.getPort());
//    }
//
//    @Override
//    public String send(URL url, Invocation invocation) {
//        return new NettyClient<>().send(url.getHostname(), url.getPort(), invocation);
//    }
}
