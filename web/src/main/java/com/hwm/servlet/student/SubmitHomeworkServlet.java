package com.hwm.servlet.student;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.jdbc.SubmitHomeworkJdbc;
import com.hwm.model.SubmitHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/submit_homework")
public class SubmitHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var homework = HomeworkJdbc.select(Integer.parseInt(req.getParameter("homeworkId")));
        req.setAttribute("homework", homework);
        req.getRequestDispatcher("submitHomework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        var submitHomework = new SubmitHomework();
        submitHomework.setStudentId(Integer.parseInt(req.getParameter("studentId")));
        submitHomework.setHomeworkId(Integer.parseInt(req.getParameter("homeworkId")));
        submitHomework.setHomeworkTitle(req.getParameter("homeworkTitle"));
        submitHomework.setHomeworkContent(req.getParameter("homeworkContent"));

        String info;
        if (SubmitHomeworkJdbc.addSubmitHomework(submitHomework)) {
            info = "提交作业成功";
        } else {
            info = "提交作业失败，请检查输入";
        }

        req.setAttribute("info", info);
        req.getRequestDispatcher("/return.jsp").forward(req, resp);
    }
}
