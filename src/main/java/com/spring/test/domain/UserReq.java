package com.spring.test.domain;

import java.io.Serializable;
import java.util.Date;

public class UserReq implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private Integer type;
    private Date ctime;

    public Date getCtime() {
        return ctime;
    }

    public   void  setCtime(Date ctime ) {
        this.ctime = ctime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
