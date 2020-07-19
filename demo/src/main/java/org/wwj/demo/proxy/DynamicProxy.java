package org.wwj.demo.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicProxy {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDaoImpl();

        System.out.println("目标对象："+target);
        System.out.println(target.getClass());

        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象："+proxy);
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
