package jsp.demo.dao;

import jsp.demo.bean.Inf;
import jsp.demo.bean.SignInfo;
import jsp.demo.bean.Teacher;
import jsp.demo.bean.TeacherCourse;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TeacherDao {
    public Teacher getTeacherInfo(Teacher teacher) {

        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        Teacher result = null;
        String sql = "select teacher_id as teacherId, teacher_name as teacherName," +
                " password from teacher where teacher_id = ?";
        try {
            result = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class), teacher.getTeacherId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<TeacherCourse> getTeacherCourseInfo(Teacher teacher) {
        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        List<TeacherCourse> result = null;
        String sql = "select id, teacher_id as teacherId, teacher_name as teacherName," +
                " course_id as courseId, course_name as courseName" +
                " from teacher_course where teacher_id = ?";
        try {
            result = queryRunner.query(sql, new BeanListHandler<TeacherCourse>(TeacherCourse.class), teacher.getTeacherId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<SignInfo> getCourseSignStudent(int courseId) {
        QueryRunner queryRunner = new QueryRunner(MyC3P0.getDataSource());
        List<SignInfo> result = null;
        String sql = "select id, s_id as studentId, s_name as studentName, c_id as courseId," +
                " c_name as courseName, t_id as teacherId, t_name as teacherName," +
                " sign_time as signTime, sign_status as signStatus," +
                " other_id as anotherStudentId" +
                " from inf where c_id = ?";
        try {
            result = queryRunner.query(sql, new BeanListHandler<SignInfo>(SignInfo.class), courseId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
