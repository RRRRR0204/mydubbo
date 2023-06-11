package com.rzl.provider;

import com.rzl.framework.URL;
import com.rzl.framework.protocal.http.HttpServer;
import com.rzl.framework.register.LocalRegister;
import com.rzl.framework.register.RemoteMapRegister;
import com.rzl.provider.api.HelloService;
import com.rzl.provider.impl.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) {

        System.out.println("provider start...");

        // 本地注册
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        // 注册中心注册
        URL url = new URL("localhost", 8080);
        RemoteMapRegister.regist(HelloService.class.getName(), url);

        // tomcat，jetty，netty请求
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());

    }
}
