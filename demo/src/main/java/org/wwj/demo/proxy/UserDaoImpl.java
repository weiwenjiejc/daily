package org.wwj.demo.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("---执行SQL语句---");
    }
}
