package org.wwj.demo.aop.service;


import org.springframework.stereotype.Service;

@Service
public class AopDemoServiceImpl implements AopDemoService {


    public void fun1(){
        System.out.println("fun1");
    }
}
