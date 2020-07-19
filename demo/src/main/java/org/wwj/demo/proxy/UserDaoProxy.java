package org.wwj.demo.proxy;


/**
 * 代理对象（静态代理）
 * 代理对象，要实现与目标对象一样的接口
 */
public class UserDaoProxy implements UserDao{

    //目标对象
    private UserDao target;

    public UserDaoProxy(UserDao target){
        this.target = target;
    }


    /**
     * 在不改变目标对象的基础上，增加额外的功能代码
     * 可以用来扩展别人的代码
     *
     *
     * 开闭原则
     *
     * 开闭原则就是说对扩展开放，对修改关闭。
     * 在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。
     * 简单来说：就是为了使程序的扩展性好，易于维护和升级。
     *
     *
     * 修改了原有代码可能会影响其它地方
     */
    @Override
    public void save() {

        System.out.println("开始事务");

        //执行目标对象的方法
        target.save();


        System.out.println("提交事务");
    }
}
