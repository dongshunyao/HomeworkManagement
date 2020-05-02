package com.hwm.service.teacher;

import com.hwm.jdbc.HomeworkJdbc;
import com.hwm.jdbc.StudentJdbc;
import com.hwm.jdbc.SubmitHomeworkJdbc;
import com.hwm.model.Homework;
import com.hwm.model.Student;
import com.hwm.model.SubmitHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private HomeworkJdbc homeworkJdbc;
    private StudentJdbc studentJdbc;
    private SubmitHomeworkJdbc submitHomeworkJdbc;

    @Autowired
    public TeacherService(HomeworkJdbc homeworkJdbc, StudentJdbc studentJdbc, SubmitHomeworkJdbc submitHomeworkJdbc) {
        this.homeworkJdbc = homeworkJdbc;
        this.studentJdbc = studentJdbc;
        this.submitHomeworkJdbc = submitHomeworkJdbc;
    }

    public List<Homework> homeworkList() {
        return homeworkJdbc.selectAll();
    }

    public List<Student> studentList() {
        return studentJdbc.selectAll();
    }

    public List<SubmitHomework> submitHomeworkList(int homeworkId) {
        return submitHomeworkJdbc.select(homeworkId);
    }

    public boolean addStudent(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);

        return studentJdbc.addStudent(student);
    }

    public boolean addHomework(String title, String content) {
        Homework homework = new Homework();
        homework.setTitle(title);
        homework.setContent(content);

        return homeworkJdbc.addHomework(homework);
    }
}
