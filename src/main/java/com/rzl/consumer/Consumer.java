package com.rzl.consumer;

import com.rzl.framework.Invocation;
import com.rzl.framework.ProxyFactory;
import com.rzl.framework.protocal.http.HttpClient;
import com.rzl.provider.api.HelloService;

public class Consumer {
    public static void main(String[] args) {
        System.out.println("consumer start...");

//        // 打包一个请求成invocation，然后发起调用
//        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello",
//                new Class[]{String.class}, new Object[]{"rzl"});
//        HttpClient httpClient = new HttpClient();
//        String result = httpClient.send("localhost", 8080, invocation);

        // 使用动态代理的方式
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("rzl12345");


        System.out.println(result);
    }
}
