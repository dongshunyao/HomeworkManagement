package com.hwm.controller.student;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.jdbc.StudentJdbc;
import com.hwm.jdbc.SubmitHomeworkJdbc;
import com.hwm.model.Student;
import com.hwm.model.SubmitHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/student")
public class StudentController {
    private HomeworkJdbc homeworkJdbc;
    private StudentJdbc studentJdbc;
    private SubmitHomeworkJdbc submitHomeworkJdbc;

    @Autowired
    public StudentController(HomeworkJdbc homeworkJdbc, StudentJdbc studentJdbc, SubmitHomeworkJdbc submitHomeworkJdbc) {
        this.homeworkJdbc = homeworkJdbc;
        this.studentJdbc = studentJdbc;
        this.submitHomeworkJdbc = submitHomeworkJdbc;
    }

    @RequestMapping("/homework_list")
    public String homeworkList(HttpServletRequest req) {
        var list = homeworkJdbc.selectAll();
        req.setAttribute("list", list);
        return "homeworkList.jsp";
    }

    @RequestMapping(value = "/submit_homework", method = RequestMethod.GET)
    public String submitHomeworkPage(HttpServletRequest req) {
        var homework = homeworkJdbc.select(Integer.parseInt(req.getParameter("homeworkId")));
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

        String info = "提交作业失败，请检查输入";
        if (studentJdbc.select(submitHomework.getStudentId()) != null) {
            if (submitHomeworkJdbc.addSubmitHomework(submitHomework)) {
                info = "提交作业成功";
            }
        }

        req.setAttribute("info", info);
        return "/return.jsp";
    }
}
