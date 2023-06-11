package com.rzl.framework.protocol.http;

import com.rzl.framework.Invocation;
import com.rzl.framework.Invoker;
import com.rzl.framework.URL;

public class HttpInvoker implements Invoker {
    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
