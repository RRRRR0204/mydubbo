package com.rzl.framework;

import com.rzl.framework.protocal.http.HttpClient;
import com.rzl.framework.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 消费端，动态代理
 * @param <T>
 */
public class ProxyFactory<T> {
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 这里能考虑很多机制，服务容错，超时重连等

                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")) {
                    String result = mock.replace("return:", "");
                    return result;
                }

                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                        method.getParameterTypes(), args);

//                // 1. 直接连接，最简单的方式
//                HttpClient httpClient = new HttpClient();
//                String result = httpClient.send("localhost", 8080, invocation);
//                return result;

                // 2. 注册中心 interfaceClass.getName()-----> ip + port
                List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
                URL url = LoadBalance.random(urls);

                // 可以选用不同的协议
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send(url.getHostname(), url.getPort(), invocation);

                return result;
            }
        });
    }
}
