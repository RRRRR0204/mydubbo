package com.rzl.framework.protocol.http;

import com.rzl.framework.Invocation;
import com.rzl.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 处理http请求，使用jdk的序列化和反序列化
 */
public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        // 处理请求req

        try {
            // 拿到invocation对象
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            // 拿到对应的方法，执行方法
            String interfaceName = invocation.getInterfaceName();
            Class classImpl = LocalRegister.get(interfaceName);
            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String) method.invoke(classImpl.newInstance(), invocation.getParams());

            // 返回
            IOUtils.write(result, resp.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
