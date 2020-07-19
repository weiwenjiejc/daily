package org.wwj.demo;

/**
 * 接口例子
 */
interface Demo {
    void func(String param);

    void func();

    void func(Integer param);

    /**
     * 方法重载不看返回值
     * 方法重载不看形参名称，只看类型
     *
     * @param param1
     * @param param2
     */
    void func(String param1, String param2);
    //void func(String param2, String param1);
    //String func(String param1, String param2);

    /**
     * 重载看参数顺序
     * @param param1
     * @param param2
     */
    void func(String param1, Integer param2);

    void func(Integer param1, String param2);
}

public class DemoInterface {
}
