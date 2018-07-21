package com.example.admin.class_helper.bean;

import cn.bmob.v3.BmobObject;

public class Flag extends BmobObject {
    private int flag;   //1表示可签到
    private String subject = null;

    public Flag(int flag, String subject) {
        this.flag = flag;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
