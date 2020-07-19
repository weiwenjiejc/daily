package jsp.demo.controller;

import jsp.demo.bean.Inf;
import jsp.demo.dao.StudentDao;
import jsp.demo.dao.TeacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/sign")
public class TeacherSignController extends HttpServlet {

    private StudentDao studentDao;
    private TeacherDao teacherDao;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        id = id.trim();
        int idInt = Integer.parseInt(id);
        studentDao = new StudentDao();
        Inf inf = studentDao.getSignInf(id);
        System.out.println(inf);
        req.setAttribute("signInf",inf);

        System.out.println("学生开始签到");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/student_sign.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
