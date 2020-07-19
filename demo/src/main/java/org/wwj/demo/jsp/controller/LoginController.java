package jsp.demo.controller;

import jsp.demo.bean.*;
import jsp.demo.dao.StudentDao;
import jsp.demo.dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private StudentDao studentDao;

    private TeacherDao teacherDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决post中文乱码
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        password = password.trim();
        String role = req.getParameter("role");
        System.out.println("接收到的参数：" + username + password + role);
        studentDao = new StudentDao();
        teacherDao = new TeacherDao();
        role = role.trim();
        if (role.equals("teacher")) {
            username = username.trim();
            int teacherId = Integer.parseInt(username);
            Teacher teacher = new Teacher();
            teacher.setTeacherId(teacherId);

            teacher = teacherDao.getTeacherInfo(teacher);
            if (password.equals(teacher.getPassword())){
                System.out.println("教师登录成功");
                HttpSession session = req.getSession();
                session.setAttribute("teacher", teacher);
                List<TeacherCourse> teacherCourseList = teacherDao.getTeacherCourseInfo(teacher);
                if (teacherCourseList == null) {
                    System.out.println("教师教授课程为空");
                    req.setAttribute("error_msg", "教师教授课程为空");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
                    dispatcher.forward(req, resp);
                }
                //传入参数
                req.setAttribute("teacherCourseList", teacherCourseList);
            }else{
                System.out.println("密码错误,重新登录");
                req.setAttribute("login_msg","用户名或者密码错误");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }

            //请求转发
            RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher_main.jsp");
            dispatcher.forward(req, resp);
        } else {
            //请求转发
            username = username.trim();
            int studentId = Integer.parseInt(username);
            Student student = new Student();
            student.setStudentId(studentId);

            student = studentDao.getStudentInfo(student);
            HttpSession session = req.getSession();
            session.setAttribute("student", student);
            List<Inf> teacherCourseList = studentDao.getSelectCourse(studentId);
            if (teacherCourseList == null) {
                System.out.println("为空");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
                dispatcher.forward(req, resp);
            } else {
                System.out.println(teacherCourseList);
                req.setAttribute("courseList", teacherCourseList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/student_main.jsp");
                dispatcher.forward(req, resp);
            }

        }

    }
}
