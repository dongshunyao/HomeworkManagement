package com.hwm.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private int id;
    private String name;
    private Date createTime;
}
