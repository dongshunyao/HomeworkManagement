package com.hwm.servlet.teacher;

import com.hwm.jdbc.StudentJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/student_list")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var list = StudentJdbc.selectAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("studentList.jsp").forward(req, resp);
    }
}
