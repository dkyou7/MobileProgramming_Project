package com.example.ydk.khu_project;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ydk on 2017. 12. 4..
 */

public class MeetingAdd extends AppCompatActivity implements View.OnClickListener,Serializable {

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

    private Button btn_meeting_count;
    private Button btn_theme;
    private TextView txt_when_view;
    private TextView txt_theme_view;
    final int selectedItem[] ={0};
    final List<String> list = new ArrayList<String>();


    final String[] theme_select = new String[]{"Health","IT/Computer","Study","Project"};   //테마 설정
    final String[] items = new String[]{"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};   //요일 설정


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

        edit_meeting_name = (EditText) findViewById(R.id.edit_meeting_name);

        btn_meeting_count = (Button) findViewById(R.id.btn_meeting_count);
        btn_meeting_count.setOnClickListener(this);
        btn_theme = (Button) findViewById(R.id.btn_meeting_theme);
        btn_theme.setOnClickListener(this);
        txt_theme_view = (TextView) findViewById(R.id.txt_theme_view);
        txt_when_view = (TextView) findViewById(R.id.txt_when_view);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_meeting_theme:

                AlertDialog.Builder dialog1 = new AlertDialog.Builder(MeetingAdd.this);
                dialog1.setTitle("모임의 성격을 선택해주세요.")
                        .setSingleChoiceItems(theme_select, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedItem[0] = which;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                txt_theme_view.setText(theme_select[selectedItem[0]]);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MeetingAdd.this, "취소 버튼 클릭", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog1.create();
                dialog1.show();
                break;
            //매주 언제 모일 것인지 선택하게 한다.
            case R.id.btn_meeting_count:

                AlertDialog.Builder dialog = new AlertDialog.Builder(MeetingAdd.this);
                dialog.setTitle("매주 언제 모이시겠어요?")
                        .setMultiChoiceItems(
                                items
                                , new boolean[]{false, false, false, false, false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            list.add(items[which]);
                                        } else {
                                            list.remove(items[which]);
                                        }
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String selectedItem = "";
                                for (String item : list) {
                                    selectedItem += item + ", ";
                                }
                                txt_when_view.setText(selectedItem);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MeetingAdd.this, "취소 버튼 클릭", Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();

                break;

            //제출하기
            case R.id.btn_submit:
                Intent submit = new Intent();
                submit.putExtra("theme",theme_select[selectedItem[0]].toString());
                submit.putExtra("when",items.toString());
                setResult(RESULT_OK,submit);
                finish();
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
}
