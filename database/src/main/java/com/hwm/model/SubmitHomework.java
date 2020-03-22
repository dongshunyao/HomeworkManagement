package com.hwm.model;

import java.util.Date;

public class SubmitHomework {
    private int id;
    private int studentId;
    private int homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private Date createTime;

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
