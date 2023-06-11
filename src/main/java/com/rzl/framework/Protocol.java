package com.rzl.framework;

/**
 * 封装协议的行为
 */
public interface Protocol {

//    public void start(URL url);
//    public String send(URL url, Invocation invocation);

    /**
     * 服务端，注册（服务导出）
     * @param url
     */
    void export(URL url);

    /**
     * 消费端，拿到对应的Invoker（服务引入）
     * @param url
     * @return
     */
    Invoker refer(URL url);
}
