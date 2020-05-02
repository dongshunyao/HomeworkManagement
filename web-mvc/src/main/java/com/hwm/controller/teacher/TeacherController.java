package com.hwm.controller.teacher;

import com.hwm.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/add_homework", method = RequestMethod.POST)
    public String addHomework(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String info;
        if (teacherService.addHomework(req.getParameter("title"), req.getParameter("content"))) {
            info = "添加作业成功";
        } else {
            info = "添加失败";
        }

        req.setAttribute("info", info);
        return "/return.jsp";
    }

    @RequestMapping(value = "/add_student", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String info;
        if (teacherService.addStudent(Integer.parseInt(req.getParameter("id")), req.getParameter("name"))) {
            info = "添加学生成功";
        } else {
            info = "添加失败，学号已经存在";
        }

        req.setAttribute("info", info);
        return "/return.jsp";
    }

    @RequestMapping("/homework_list")
    public String homeworkList(HttpServletRequest req) {
        req.setAttribute("list", teacherService.homeworkList());
        return "homeworkList.jsp";
    }

    @RequestMapping("/student_list")
    public String studentList(HttpServletRequest req) {
        req.setAttribute("list", teacherService.studentList());
        return "studentList.jsp";
    }

    @RequestMapping("/submit_homework_list")
    public String submitHomeworkList(HttpServletRequest req) {
        req.setAttribute("list", teacherService.submitHomeworkList(Integer.parseInt(req.getParameter("homeworkId"))));
        return "submitHomeworkList.jsp";
    }
}
