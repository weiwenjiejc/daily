package jsp.demo.controller;

import jsp.demo.bean.Inf;
import jsp.demo.bean.Student;
import jsp.demo.bean.Teacher;
import jsp.demo.bean.TeacherCourse;
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

@WebServlet("/refresh/student")
public class RefreshStudentController extends HttpServlet {

    private StudentDao studentDao;

    private TeacherDao teacherDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            HttpSession session = req.getSession();
            Student student = (Student) session.getAttribute("student");
        studentDao = new StudentDao();
            List<Inf> teacherCourseList = studentDao.getSelectCourse(student.getStudentId());
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
