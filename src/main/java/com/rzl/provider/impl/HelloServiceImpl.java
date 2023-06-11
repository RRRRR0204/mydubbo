package com.rzl.provider.impl;

import com.rzl.provider.api.HelloService;

/**
 * 接口实现类
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String userName) {
        return "Hello " + userName;
    }
}
