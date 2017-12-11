package com.example.ydk.khu_project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydk on 2017. 12. 4..
 */

public class MeetingAdd extends AppCompatActivity implements View.OnClickListener,Serializable,CompoundButton.OnCheckedChangeListener {

    Button btn_start_date, btn_end_date;
    Button btn_submit;
    Button btn_back;
    EditText edit_meeting_name; //모임 이름 설정해주는 것
    TextView txt_start, txt_end;    //날자 시작일과 종료일
    RadioGroup radioGroup_theme;   //기간과 테마 라디오 그룹
    RadioButton radiobtn_theme;

    DatePickerDialog start_dlg;
    DatePickerDialog end_dlg;
    //매주 무슨 요일날 모일 것인가
    TextView tv1;
    CheckBox checkbox_sunday, checkbox_monday, checkbox_tuesday, checkbox_wednesday,
            checkbox_thursday, checkbox_friday, checkbox_saturday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_add);
        btn_start_date = (Button) findViewById(R.id.btn_start_date);
        btn_start_date.setOnClickListener(this);
        btn_end_date = (Button) findViewById(R.id.btn_end_date);
        btn_end_date.setOnClickListener(this);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        txt_start = (TextView) findViewById(R.id.txt_start);
        txt_end = (TextView) findViewById(R.id.txt_end);

        radioGroup_theme = (RadioGroup) findViewById(R.id.radiogroup_type_set);

        //선택한 테마 라디오버튼의 ID값을 반환한다.
        radiobtn_theme = (RadioButton) findViewById(radioGroup_theme.getCheckedRadioButtonId());

        edit_meeting_name = (EditText) findViewById(R.id.edit_meeting_name);

        //체크박스 설정
        checkbox_sunday = (CheckBox) findViewById(R.id.checkbox_sunday);
        checkbox_monday = (CheckBox) findViewById(R.id.checkbox_monday);
        checkbox_tuesday = (CheckBox) findViewById(R.id.checkbox_tuesday);
        checkbox_wednesday = (CheckBox) findViewById(R.id.checkbox_wednesday);
        checkbox_thursday = (CheckBox) findViewById(R.id.checkbox_thursday);
        checkbox_friday = (CheckBox) findViewById(R.id.checkbox_friday);
        checkbox_saturday = (CheckBox) findViewById(R.id.checkbox_saturday);

        //리스너 설정을 setonclicklistener 이 아니라 이걸로 해줘야 해요~
        checkbox_sunday.setOnCheckedChangeListener(this);
        checkbox_monday.setOnCheckedChangeListener(this);
        checkbox_tuesday.setOnCheckedChangeListener(this);
        checkbox_wednesday.setOnCheckedChangeListener(this);
        checkbox_thursday.setOnCheckedChangeListener(this);
        checkbox_friday.setOnCheckedChangeListener(this);
        checkbox_saturday.setOnCheckedChangeListener(this);
        tv1 = (TextView) findViewById(R.id.txt_view);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:   // TODO: 2017. 12. 4. 객체 넘기기
                Meetinginfo meetinginfo = new Meetinginfo(edit_meeting_name.getText().toString(),
                        start_dlg,end_dlg,radiobtn_theme,checkbox_monday);
                Intent intent = new Intent(this, Application.class);
                intent.putExtra("Info", meetinginfo);

                startActivityForResult(intent,100);

                break;
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_start_date:
                DatePickerDialog.OnDateSetListener StartDateSetListener =
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                txt_start.setText(i + " / " + (i1 + 1) + " /" + i2);
                            }
                        };
                start_dlg = new DatePickerDialog(this, StartDateSetListener, 2017, 12, 3);
                start_dlg.show();
                break;
            case R.id.btn_end_date:
                DatePickerDialog.OnDateSetListener EndDateSetListener =
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                txt_end.setText(i + " / " + (i1 + 1) + " /" + i2);
                            }
                        };
                end_dlg = new DatePickerDialog(this, EndDateSetListener, 2017, 12, 25);
                end_dlg.show();
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String result = " ";

        if (checkbox_sunday.isChecked()) {
            result += checkbox_sunday.getText().toString();
        }
        if (checkbox_monday.isChecked()) {
            result += checkbox_monday.getText().toString();
        }
        if (checkbox_tuesday.isChecked()) {
            result += checkbox_tuesday.getText().toString();
        }
        if (checkbox_wednesday.isChecked()) {
            result += checkbox_wednesday.getText().toString();
        }
        if (checkbox_thursday.isChecked()) {
            result += checkbox_thursday.getText().toString();
        }
        if (checkbox_friday.isChecked()) {
            result += checkbox_friday.getText().toString();
        }
        if (checkbox_saturday.isChecked()) {
            result += checkbox_saturday.getText().toString();
        }

        tv1.setText("원하는 요일 :" + result);
    }
}

