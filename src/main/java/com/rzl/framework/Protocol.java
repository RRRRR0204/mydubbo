package com.rzl.framework;

public interface Protocol {
    public void start(URL url);
    public String send(URL url, Invocation invocation);
}
