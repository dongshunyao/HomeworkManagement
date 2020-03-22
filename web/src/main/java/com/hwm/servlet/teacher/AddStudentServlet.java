package com.hwm.servlet.teacher;

import com.hwm.jdbc.StudentJdbc;
import com.hwm.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/add_student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Student student = new Student();
        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setName(req.getParameter("name"));

        String info;
        if (StudentJdbc.addStudent(student)) {
            info = "添加学生成功";
        } else {
            info = "添加失败，学号已经存在";
        }

        req.setAttribute("info", info);
        req.getRequestDispatcher("/return.jsp").forward(req, resp);
    }
}
