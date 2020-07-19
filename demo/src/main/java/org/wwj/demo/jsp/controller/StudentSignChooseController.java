package jsp.demo.controller;

import jsp.demo.bean.Inf;
import jsp.demo.bean.SignInfo;
import jsp.demo.dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/student/sign/choose")
public class StudentSignChooseController extends HttpServlet {

    private StudentDao studentDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        id = id.trim();

        String signStatus = req.getParameter("signStatus");
        signStatus = signStatus.trim();

        String anotherStudentId = req.getParameter("anotherStudentId");
        if (anotherStudentId!=null){
            anotherStudentId = anotherStudentId.trim();
        }else {
            anotherStudentId = "0";
        }


        Date date = new Date();

        SignInfo signInfo = new SignInfo();
        signInfo.setId(Integer.parseInt(id));
        if (anotherStudentId!=null){
            signInfo.setAnotherStudentId(Integer.parseInt(anotherStudentId));
        }
        signInfo.setSignStatus(Integer.parseInt(signStatus));
        signInfo.setSignTime(date);
        studentDao = new StudentDao();
        Integer result = studentDao.updateSignInfo(signInfo);
        System.out.println(result);
        System.out.println("学生开始签到");
        req.setAttribute("info_msg", "签到成功");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/info.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
