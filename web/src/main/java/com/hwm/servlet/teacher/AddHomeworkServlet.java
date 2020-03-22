package com.hwm.servlet.teacher;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/add_homework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Homework homework = new Homework();
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));

        String info;
        if (HomeworkJdbc.addHomework(homework)) {
            info = "添加作业成功";
        } else {
            info = "添加失败";
        }

        req.setAttribute("info", info);
        req.getRequestDispatcher("/return.jsp").forward(req, resp);
    }
}
