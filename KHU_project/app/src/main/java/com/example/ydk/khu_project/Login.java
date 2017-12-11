package com.example.ydk.khu_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class Login extends AppCompatActivity implements View.OnClickListener{

    static LinkedList<User> userList = new LinkedList<User>();

    String UserId="";
    String UserPW="";
    String UserName="";

    Button btn_sign_up;
    Button btn_login;
    EditText et_id;
    EditText et_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = (EditText)findViewById(R.id.et_id);
        et_pw=(EditText)findViewById(R.id.et_pw);
        btn_sign_up = (Button)findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(this);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        Intent intent = new Intent(this.getIntent());
        UserId += intent.getStringExtra("ID");
        UserPW += intent.getStringExtra("PW");
        UserName += intent.getStringExtra("NAME");

        User user = new User(UserId,UserPW,UserName);
        userList.add(user);
    }

    public  void onClick(View v){
        switch (v.getId()){
            case R.id.btn_sign_up:
                Intent intent = new Intent(this, Sign_up.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
//                int i;
//                for (i=0 ; i<userList.size();i++) {
//                    if (userList.get(i).getid().equals(et_id.getText().toString()) && userList.get(i).getpassword().equals(et_pw.getText().toString())) {
//                        Intent intent2 = new Intent(this, Application.class);
//                        intent2.putExtra("ID", userList.get(i).getid());
//                        intent2.putExtra("PW", userList.get(i).getpassword());
//                        intent2.putExtra("NAME", userList.get(i).getname());
//                        startActivity(intent2);
//                        Toast.makeText(getApplicationContext(), userList.get(i).getname() + "님 환영합니다", Toast.LENGTH_LONG).show();
//                    }
//                }
//                if(i==userList.size()){
//                    Toast.makeText(getApplicationContext(),"잘못된 로그인 정보입니다.",Toast.LENGTH_LONG).show();
//                }
//                break;
                Intent intent_to_application = new Intent(this, Application.class);
                startActivity(intent_to_application);
        }

    }

}
