package com.example.admin.class_helper.activitiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.class_helper.model.UserModel;
import com.example.admin.class_helper.R;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class RegisterActivity extends Activity {
    private EditText et_username;
    private EditText et_password;
    private EditText et_confirmpassword;
    private Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initview();
    }


    private void initview() {
        et_username = findViewById(R.id.r_username_et);
        et_password = findViewById(R.id.r_password_et);
        et_confirmpassword = findViewById(R.id.passwordconfirm_et);

        btn_register = findViewById(R.id.r_register_btn);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel.getUserInstance().register(et_username.getText().toString(), et_password.getText().toString(), et_confirmpassword.getText().toString(), new LogInListener() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if (e == null) {
                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });

            }
        });
    }
}
