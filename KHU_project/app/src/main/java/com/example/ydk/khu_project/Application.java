package com.example.ydk.khu_project;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class Application extends AppCompatActivity implements View.OnClickListener{


//    static LinkedList<Meetinginfo> meetingList= new LinkedList<Meetinginfo>();
//    String UserName=" ", meeting_name= " ";
    String str = "정보 : ";
    TextView txt_study1;
    TextView txt_study2;
    TextView txtstudy3;

    //모임 생성해주는 객체
    //MeetingAdd meetingAdd;

    Button btn_add;
    Button btn_logout;

    String TAG = "Application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);


        txt_study1 = (TextView)findViewById(R.id.txt_study1);

        //Login->App , MeetingAdd -> Add 따로 생각?
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_logout = (Button)findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(this);

        Intent intent = new Intent(this.getIntent());
        Meetinginfo meetinginfo = (Meetinginfo)intent.getSerializableExtra("Info");

        //str += meetinginfo.getMeeting_name();        //이부분 오류!!!!

        txt_study1.setText(str);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
//                Intent intent = new Intent(Application.this,MeetingAdd.class);
//                intent.putExtra("Name", UserName);
//                startActivity(intent);
                Intent intent_to_meeting_add = new Intent(Application.this  , MeetingAdd.class);
                startActivityForResult(intent_to_meeting_add,1010);
                break;

            //로그아웃 시 알림 창 띄워주기
            case R.id.btn_logout:
                //finish();
                AlertDialog.Builder dialog = new AlertDialog.Builder(Application.this);
                dialog.setTitle("알립니다!")
                        .setMessage("로그아웃을 진행합니다.")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"예 버튼 클릭",Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"아니오 버튼 클릭",Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1010 && resultCode == RESULT_OK){
        txt_study1.setText(data.getStringExtra("theme"));
        txt_study2.setText(data.getStringExtra("when"));
        }
    }
}