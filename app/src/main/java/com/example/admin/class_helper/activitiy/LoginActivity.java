package com.example.admin.class_helper.activitiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.class_helper.model.UserModel;
import com.example.admin.class_helper.R;
import com.example.admin.class_helper.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText et_account;
    private EditText et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Handler handler =new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                User user = UserModel.getUserInstance().getCurrentUser();
                if (user == null) {

                }else{
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 0);
        initview();
    }

    private void initview() {
        et_account = findViewById(R.id.account_et);
        et_password = findViewById(R.id.password_et);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                login();
                break;
            case R.id.register_btn:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;
        }
    }

    private void login() {

        UserModel.getUserInstance().login(et_account.getText().toString(), et_password.getText().toString(), new LogInListener() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败，请检查网络连接", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
