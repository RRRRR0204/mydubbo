package com.rzl.framework.protocol.http;

import com.rzl.framework.Invocation;
import com.rzl.framework.Invoker;
import com.rzl.framework.Protocol;
import com.rzl.framework.URL;
import com.rzl.framework.register.LocalRegister;
import com.rzl.framework.register.RemoteMapRegister;


public class HttpProtocol implements Protocol {
    @Override
    public void export(URL url) {
        // 本地注册
        LocalRegister.regist(url.getInterfaceName(), url.getImplClass());
        // 注册中心注册
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        // 启动Tomcat
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }
//    @Override
//    public void start(URL url) {
//        new HttpServer().start(url.getHostname(), url.getPort());
//    }
//
//    @Override
//    public String send(URL url, Invocation invocation) {
//        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
//    }
}
