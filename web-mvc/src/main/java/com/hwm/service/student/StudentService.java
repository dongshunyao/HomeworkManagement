package com.hwm.service.student;

import com.hwm.mapper.HomeworkMapper;
import com.hwm.mapper.StudentMapper;
import com.hwm.mapper.SubmitHomeworkMapper;
import com.hwm.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private HomeworkMapper homeworkMapper;
    private StudentMapper studentMapper;
    private SubmitHomeworkMapper submitHomeworkMapper;

    @Autowired
    public StudentService(HomeworkMapper homeworkMapper, StudentMapper studentMapper, SubmitHomeworkMapper submitHomeworkMapper) {
        this.homeworkMapper = homeworkMapper;
        this.studentMapper = studentMapper;
        this.submitHomeworkMapper = submitHomeworkMapper;
    }

    public List<Homework> homeworkList() {
        return homeworkMapper.selectAll();
    }

    public Homework homework(int homeworkId) {
        return homeworkMapper.select(homeworkId);
    }

    public boolean submitHomework(int studentId, int homeworkId, String homeworkTitle, String homeworkContent) {
        if (studentMapper.select(studentId) != null) {
            return submitHomeworkMapper.addSubmitHomework(studentId, homeworkId, homeworkTitle, homeworkContent);
        }
        return false;
    }
}
