package org.wwj.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 为目标对象生成代理对象
 * 使用动态代理
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){

        Class<?> targetClass = target.getClass();
        Class<?>[] interfaces = targetClass.getInterfaces();
        ClassLoader classLoader = targetClass.getClassLoader();
        Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("开启事务");

                        //执行目标对象方法
                        Object invoke = method.invoke(target, args);

                        System.out.println("提交事务");

                        return invoke;
                    }
                });

        return proxyInstance;

    }

}
