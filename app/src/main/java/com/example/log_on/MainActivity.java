package com.example.log_on;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_account;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    private void initView() {
        et_account =  findViewById(R.id.zhanghao);
        et_password =  findViewById(R.id.mima);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }




    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:

                String account = et_account.getText().toString().trim();
                String password = et_password.getText().toString();

                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "请输入QQ账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

                boolean isSaveSuccess = SPSaveQQ.saveUserInfo(this, account, password);
                if (isSaveSuccess) {
                    Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}