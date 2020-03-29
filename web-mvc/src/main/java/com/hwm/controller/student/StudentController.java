package com.hwm.controller.student;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.jdbc.SubmitHomeworkJdbc;
import com.hwm.model.SubmitHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/homework_list")
    public String homeworkList(HttpServletRequest req) {
        var list = HomeworkJdbc.selectAll();
        req.setAttribute("list", list);
        return "homeworkList.jsp";
    }

    @RequestMapping(value = "/submit_homework", method = RequestMethod.GET)
    public String submitHomeworkPage(HttpServletRequest req) {
        var homework = HomeworkJdbc.select(Integer.parseInt(req.getParameter("homeworkId")));
        req.setAttribute("homework", homework);
        return "submitHomework.jsp";
    }

    @RequestMapping(value = "/submit_homework", method = RequestMethod.POST)
    public String submitHomeworkForm(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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
        return "/return.jsp";
    }
}
