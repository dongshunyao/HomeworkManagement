package com.hwm.servlet.student;

import com.hwm.jdbc.HomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/homework_list")
public class HomeworkListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var list = HomeworkJdbc.selectAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("homeworkList.jsp").forward(req, resp);
    }
}
