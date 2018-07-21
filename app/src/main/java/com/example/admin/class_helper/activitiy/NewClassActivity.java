package com.example.admin.class_helper.activitiy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.class_helper.R;
import com.example.admin.class_helper.bean.ClassInfo;
import com.example.admin.class_helper.model.UserModel;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

public class NewClassActivity extends Activity {
    private EditText et_classname;
    private TextView tv_teachername;
    private EditText et_studentnumber;
    private EditText et_place;
    private EditText et_classtime;
    private Button btn_create_newclass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newclass);
        initview();
        initdata();
    }

    private void initdata() {
        tv_teachername.setText(UserModel.getUserInstance().getCurrentUser().getUsername().toString());
    }


    private void initview() {
        et_classname = findViewById(R.id.classname_et);
        tv_teachername = findViewById(R.id.teachername_et);
        et_studentnumber = findViewById(R.id.studentnumber_et);
        et_place = findViewById(R.id.place_et);
        et_classtime = findViewById(R.id.classtime_et);
        btn_create_newclass = findViewById(R.id.create_newclass_btn);
        btn_create_newclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassInfo newclass = new ClassInfo( et_classname.getText().toString(),
                                                    tv_teachername.getText().toString(),
                                                    et_studentnumber.getText().toString(),
                                                    et_place.getText().toString(),
                                                    et_classtime.getText().toString());
                newclass.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(NewClassActivity.this, "课程创建成功", Toast.LENGTH_LONG);
                        } else {
                            Toast.makeText(NewClassActivity.this, e.getMessage(), Toast.LENGTH_LONG);
                        }
                    }
                });
            }
        });
    }
}
