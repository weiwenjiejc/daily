package org.wwj.demo.proxy;

/**
 * cglib动态代理
 */
public class CglibDynamicProxy {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDaoImpl();

        System.out.println("目标对象："+target);
        System.out.println(target.getClass());

        //代理对象
        UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();
        System.out.println("代理对象："+proxy);
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
