package jsp.demo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyC3P0 {

    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static DataSource getDataSource(){

        return comboPooledDataSource;
    }

    public static void main(String[] args) {
        System.out.println(getDataSource());
    }
}
