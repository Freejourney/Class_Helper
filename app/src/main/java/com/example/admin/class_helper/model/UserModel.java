package com.example.admin.class_helper.model;

import android.text.TextUtils;

import com.example.admin.class_helper.bean.ClassInfo;
import com.example.admin.class_helper.bean.User;
import com.example.admin.class_helper.util.Constants;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;



public class UserModel {
    private static UserModel userInstance;

    public static UserModel getUserInstance() {
        if (null == userInstance) {
            userInstance = new UserModel();
        }
        return  userInstance;
    }

    public void register(String username, String password, String confirmpassword, final LogInListener listener) {
        if (TextUtils.isEmpty(username)) {
            listener.done(null, new BmobException(Constants.CODE_N, "用户名不能为空"));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.done(null, new BmobException(Constants.CODE_N,  "密码不能为空"));
            return;
        }
        if (TextUtils.isEmpty(confirmpassword)) {
            listener.done(null, new BmobException(Constants.CODE_N, "请输入确认密码"));
            return;
        }
        if (!password.equals(confirmpassword)) {
            listener.done(null, new BmobException(Constants.CODE_NE, "密码不一致，请重新输入"));
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    listener.done(null, null);
                } else {
                    listener.done(null, e);
                }
            }
        });
    }

    public void login(String username, String password, final LogInListener listener) {
        if (TextUtils.isEmpty(username)) {
            listener.done(null, new BmobException(Constants.CODE_N, "请填写用户名"));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.done(null, new BmobException(Constants.CODE_N, "请输入密码"));
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    listener.done(getCurrentUser(), null);
                } else {
                    listener.done(user, e);
                }
            }
        });
    }

    public void  joinclass(ClassInfo classinfo) {
        getUserInstance().getCurrentUser().addClass(classinfo);
    }

    public void logout() {
        BmobUser.logOut();
    }

    public User getCurrentUser() {
        return BmobUser.getCurrentUser(User.class);
    }
}
