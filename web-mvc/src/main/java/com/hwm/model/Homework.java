package com.hwm.model;

import lombok.Data;

import java.util.Date;

@Data
public class Homework {
    private int id;
    private String title;
    private String content;
    private Date createTime;
}
