package com.hwm.service.teacher;

import com.hwm.mapper.HomeworkMapper;
import com.hwm.mapper.StudentMapper;
import com.hwm.mapper.SubmitHomeworkMapper;
import com.hwm.model.Homework;
import com.hwm.model.Student;
import com.hwm.model.SubmitHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private HomeworkMapper homeworkMapper;
    private StudentMapper studentMapper;
    private SubmitHomeworkMapper submitHomeworkMapper;

    @Autowired
    public TeacherService(HomeworkMapper homeworkMapper, StudentMapper studentMapper, SubmitHomeworkMapper submitHomeworkMapper) {
        this.homeworkMapper = homeworkMapper;
        this.studentMapper = studentMapper;
        this.submitHomeworkMapper = submitHomeworkMapper;
    }

    public List<Homework> homeworkList() {
        return homeworkMapper.selectAll();
    }

    public List<Student> studentList() {
        return studentMapper.selectAll();
    }

    public List<SubmitHomework> submitHomeworkList(int homeworkId) {
        return submitHomeworkMapper.select(homeworkId);
    }

    public boolean addStudent(int id, String name) {
        return studentMapper.addStudent(id, name);
    }

    public boolean addHomework(String title, String content) {
        return homeworkMapper.addHomework(title, content);
    }
}
