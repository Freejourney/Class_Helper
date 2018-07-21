package com.example.admin.class_helper.bean;

import cn.bmob.v3.BmobObject;

public class ClassInfo extends BmobObject {
    private String subject;
    private String teacher;
    private String number;
    private String place;
    private String classtime;

    public ClassInfo(String subject, String teacher, String number, String place, String classtime) {
        this.subject = subject;
        this.teacher = teacher;
        this.number = number;
        this.place = place;
        this.classtime = classtime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }
}
