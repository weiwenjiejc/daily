package org.wwj.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author wei
 * @Description: 切面类Demo，切面是通知和切点的结合，通知和切点共同定义了切面的全部内容。
 *   			因为通知定义的是切面的"要做什么"和"在何时做"，而切点定义的是切面的"在何地做"。
 * @date 2020-7-10
 */

/*@Aspect
@Component*/
public class DemoAspect {


    void before(){
        System.out.println("before");
    }

    public void around() {
        System.out.println("around");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    public void after() {
        System.out.println("after");
    }

    public void afterReturning() {
        System.out.println("afterReturning");
    }
}
