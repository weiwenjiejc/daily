package org.wwj.demo.proxy;

public class StaticProxy {

    public static void main(String[] args) {

        //目标对象
        UserDao target = new UserDaoImpl();


        //代理对象
        UserDao proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
