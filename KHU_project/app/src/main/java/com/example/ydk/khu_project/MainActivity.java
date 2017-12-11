package com.example.ydk.khu_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_go=(Button)findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
        //Intent intent = getIntent();    //MeetingAdd에서 보낸 정보를 받아온다
        //String id = intent.getStringExtra("입력한 스터디 이름");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_go:
                Intent intent_to_login = new Intent(MainActivity.this, Login.class);
                startActivity(intent_to_login);
                break;

        }

    }
}
