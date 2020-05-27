package com.hwm.model;

import lombok.Data;

import java.util.Date;

@Data
public class SubmitHomework {
    private int id;
    private int studentId;
    private int homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private Date createTime;
}
