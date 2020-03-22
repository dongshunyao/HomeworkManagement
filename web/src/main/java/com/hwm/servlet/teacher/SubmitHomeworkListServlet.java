package com.hwm.servlet.teacher;

import com.hwm.jdbc.SubmitHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/submit_homework_list")
public class SubmitHomeworkListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var list= SubmitHomeworkJdbc.select(Integer.parseInt(req.getParameter("homeworkId")));
        req.setAttribute("list",list);
        req.getRequestDispatcher("submitHomeworkList.jsp").forward(req,resp);
    }
}
