package com.rzl.provider;

import com.rzl.framework.Protocol;
import com.rzl.framework.ProtocolFactory;
import com.rzl.framework.URL;
import com.rzl.framework.protocol.http.HttpServer;
import com.rzl.framework.register.LocalRegister;
import com.rzl.framework.register.RemoteMapRegister;
import com.rzl.provider.api.HelloService;
import com.rzl.provider.impl.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) {

        System.out.println("provider start...");

//        // 本地注册
//        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
//
//        // 将协议信息加入URL中
//        String protocolName = System.getProperty("protocolName");
//
//        // 注册中心注册
//        URL url = new URL(protocolName,"localhost", 8080);
//        RemoteMapRegister.regist(HelloService.class.getName(), url);

        // tomcat，jetty，netty请求
        // 可以选用不同的协议
//        HttpServer httpServer = new HttpServer();
//        httpServer.start(url.getHostname(), url.getPort());
//        String protocolName = System.getProperty("protocolName");


        String protocolName = System.getProperty("protocolName");

        URL url = new URL(protocolName,"localhost", 8080, HelloService.class.getName(), HelloServiceImpl.class);
        Protocol protocol = ProtocolFactory.getProtocol(protocolName);
        protocol.export(url);
    }
}
