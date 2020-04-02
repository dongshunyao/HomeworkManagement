package com.hwm.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date createTime;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
