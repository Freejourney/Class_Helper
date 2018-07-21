package com.example.admin.class_helper.bean;

import cn.bmob.v3.BmobObject;

public class User_item extends BmobObject {
    private String username = null;
    private String avatar = null;
    private Boolean condition = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }
}
