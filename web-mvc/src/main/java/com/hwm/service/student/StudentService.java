package com.hwm.service.student;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.jdbc.StudentJdbc;
import com.hwm.jdbc.SubmitHomeworkJdbc;
import com.hwm.model.Homework;
import com.hwm.model.SubmitHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private HomeworkJdbc homeworkJdbc;
    private StudentJdbc studentJdbc;
    private SubmitHomeworkJdbc submitHomeworkJdbc;

    @Autowired
    public StudentService(HomeworkJdbc homeworkJdbc, StudentJdbc studentJdbc, SubmitHomeworkJdbc submitHomeworkJdbc) {
        this.homeworkJdbc = homeworkJdbc;
        this.studentJdbc = studentJdbc;
        this.submitHomeworkJdbc = submitHomeworkJdbc;
    }

    public List<Homework> homeworkList() {
        return homeworkJdbc.selectAll();
    }

    public Homework homework(int homeworkId) {
        return homeworkJdbc.select(homeworkId);
    }

    public boolean submitHomework(int studentId, int homeworkId, String homeworkTitle, String homeworkContent) {
        var submitHomework = new SubmitHomework();

        submitHomework.setStudentId(studentId);
        submitHomework.setHomeworkId(homeworkId);
        submitHomework.setHomeworkTitle(homeworkTitle);
        submitHomework.setHomeworkContent(homeworkContent);

        if (studentJdbc.select(submitHomework.getStudentId()) != null) {
            return submitHomeworkJdbc.addSubmitHomework(submitHomework);
        }
        return false;
    }
}
