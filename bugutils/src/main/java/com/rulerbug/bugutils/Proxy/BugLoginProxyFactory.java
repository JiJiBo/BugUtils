package com.rulerbug.bugutils.Proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BugLoginProxyFactory {
    public static <T> Object getProxy(final T t) {
        Object obj = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (isLogin()) {
                    Object o = method.invoke(t, args);
                    return o;
                } else {
                    toLogin();
                    return null;
                }

            }
        });
        return obj;
    }

    public static void toLogin() {

    }

    public static boolean isLogin() {
        return false;
    }
}
