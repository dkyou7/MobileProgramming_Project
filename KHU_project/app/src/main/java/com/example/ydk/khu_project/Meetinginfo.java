package com.example.ydk.khu_project;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.ydk.khu_project.User;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by USER on 2017-12-03.
 */

public class Meetinginfo extends AppCompatActivity implements Serializable{

    private String Meeting_name;
    private DatePickerDialog start_dlg;
    private DatePickerDialog end_dlg;
    private RadioButton Radio;
    private CheckBox Checkbox;

    public Meetinginfo(String name, DatePickerDialog s_date, DatePickerDialog e_date, RadioButton rbtn, CheckBox ch){
        Meeting_name = name;
        start_dlg = s_date;
        end_dlg = e_date;
        Radio = rbtn;
        Checkbox = ch;
    }
    public String getMeeting_name() {
        return Meeting_name;
    }

    public DatePickerDialog getStart_dlg() {
        return start_dlg;
    }

    public DatePickerDialog getEnd_dlg() {
        return end_dlg;
    }

    public RadioButton getRadio() {
        return Radio;
    }

    public CheckBox getCheckbox() {
        return Checkbox;
    }


}
