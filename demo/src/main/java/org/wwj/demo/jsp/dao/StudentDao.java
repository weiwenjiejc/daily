package jsp.demo.dao;

import jsp.demo.bean.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    public List<Inf> getSelectCourse(Integer sId) {
        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        List<Inf> lists = null;
        String sql = "select id, s_id as sId, s_name as sName, c_id as cId," +
                " c_name as cName, t_id as tId, t_name as tName," +
                " sign_time as signTime, sign_status as signStatus," +
                " other_id as otherId" +
                " from inf where s_id=?";
        try {
            lists = queryRunner.query(sql, new BeanListHandler<Inf>(Inf.class), sId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lists;
    }

    public Inf getSignInf(String id) {
        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        Inf lists = null;
        String sql = "select id, s_id as sId, s_name as sName, c_id as cId," +
                " c_name as cName, t_id as tId, t_name as tName," +
                " sign_time as signTime, sign_status as signStatus," +
                " other_id as otherId" +
                " from inf where id=?";
        try {
            lists = queryRunner.query(sql, new BeanHandler<Inf>(Inf.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return lists;
    }

    public Integer updateSignInfo(SignInfo signInfo) {
        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        Integer result = null;
        String sql = "update inf set sign_status = ?," +
                " sign_time = ?," +
                " other_id = ?" +
                " where id = ?";
        try {
            Object[] params = new Object[]{
                    signInfo.getSignStatus(),
                    signInfo.getSignTime(),
                    signInfo.getAnotherStudentId(),
                    signInfo.getId()
            };
            result = queryRunner.update(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public Student getStudentInfo(Student student) {

        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        Student result = null;
        String sql = "select student_id as studentId, student_name as studentName," +
                " password, job from student where student_id = ?";
        try {
            result = queryRunner.query(sql, new BeanHandler<Student>(Student.class), student.getStudentId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
