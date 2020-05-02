package com.hwm.controller.student;

import com.hwm.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/homework_list")
    public String homeworkList(HttpServletRequest req) {
        req.setAttribute("list", studentService.homeworkList());
        return "homeworkList.jsp";
    }

    @RequestMapping(value = "/submit_homework", method = RequestMethod.GET)
    public String submitHomeworkPage(HttpServletRequest req) {
        req.setAttribute("homework", studentService.homework(Integer.parseInt(req.getParameter("homeworkId"))));
        return "submitHomework.jsp";
    }

    @RequestMapping(value = "/submit_homework", method = RequestMethod.POST)
    public String submitHomeworkForm(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String info = "提交作业失败，请检查输入";
        if (studentService.submitHomework(Integer.parseInt(req.getParameter("studentId")),
                Integer.parseInt(req.getParameter("homeworkId")),
                req.getParameter("homeworkTitle"),
                req.getParameter("homeworkContent"))) {
            info = "提交作业成功";
        }

        req.setAttribute("info", info);
        return "/return.jsp";
    }
}
