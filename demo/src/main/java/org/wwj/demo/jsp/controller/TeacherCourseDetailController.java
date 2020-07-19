package jsp.demo.controller;

import jsp.demo.bean.Inf;
import jsp.demo.bean.SignInfo;
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

@WebServlet("/teacher/course/detail")
public class TeacherCourseDetailController extends HttpServlet {

    //private StudentDao studentDao;
    private TeacherDao teacherDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String courseId = req.getParameter("courseId");
        courseId = courseId.trim();
        int courseIdInt = Integer.parseInt(courseId);
        //studentDao = new StudentDao();
        teacherDao = new TeacherDao();

        List<SignInfo> signInfoList = teacherDao.getCourseSignStudent(courseIdInt);
        if (signInfoList!=null){
            System.out.println(signInfoList);
            req.setAttribute("signInfoList",signInfoList);
            System.out.println("教师进入课程详情界面");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/teacher_course_detail.jsp");
            dispatcher.forward(req, resp);
        }else {
            req.setAttribute("error_msg","出错了");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
