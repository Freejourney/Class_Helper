package com.example.admin.class_helper.bean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {

    private String avatar;
    private List<ClassInfo> classes = new ArrayList<ClassInfo>();

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public List<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassInfo> classes) {
        this.classes = classes;
    }

    public void  addClass(ClassInfo aclass) {
        classes.add(aclass);
    }
}
