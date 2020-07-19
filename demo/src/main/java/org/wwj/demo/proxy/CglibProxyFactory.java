package org.wwj.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * (对UserDao在内存中动态构建一个子类 对象)
 */
public class CglibProxyFactory implements MethodInterceptor {

    //维护一个目标对象
    private Object target;

    public CglibProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){

        //工具类
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(target.getClass());

        //设置回调函数
        enhancer.setCallback(this);

        //创建子类
        Object subclass = enhancer.create();

        return subclass;

    }
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {

        System.out.println("开启事务");

        //执行目标对象的方法
        Object invoke = method.invoke(target, args);

        System.out.println("提交事务");

        return invoke;
    }
}
