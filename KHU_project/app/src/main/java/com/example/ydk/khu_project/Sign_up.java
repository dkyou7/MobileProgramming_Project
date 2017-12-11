package com.example.ydk.khu_project;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity implements  View.OnClickListener{

    Button btn_sign_up_submit;
    private EditText edit_sign_up_id, edit_sign_up_pw, edit_sign_up_pw_confirm, edit_sign_up_name;

    public String getsId() {
        return edit_sign_up_id.getText().toString();
    }

    public String getsPw() {
        return edit_sign_up_pw.getText().toString();
    }

    public String getsPwConfirm() {
        return edit_sign_up_pw_confirm.getText().toString();
    }

    public String getsName() {
        return edit_sign_up_name.getText().toString();
    }

    private String sId, sPw, sPwConfirm, sName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_sign_up_submit=(Button)findViewById(R.id.btn_sign_up_submit);
        edit_sign_up_id = (EditText)findViewById(R.id.edit_sign_up_id);
        edit_sign_up_pw = (EditText)findViewById(R.id.edit_sign_up_pw);
        edit_sign_up_name = (EditText)findViewById(R.id.edit_sign_up_name);
        edit_sign_up_pw_confirm = (EditText)findViewById(R.id.edit_sign_up_pw_confirm);
        edit_sign_up_pw_confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = edit_sign_up_pw.getText().toString();
                String confirm = edit_sign_up_pw_confirm.getText().toString();

                if(password.equals(confirm)){
                    edit_sign_up_pw.setBackgroundColor(Color.GREEN);
                    edit_sign_up_pw_confirm.setBackgroundColor(Color.GREEN);
                }
                else {
                    edit_sign_up_pw.setBackgroundColor(Color.RED);
                    edit_sign_up_pw_confirm.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        btn_sign_up_submit.setOnClickListener(this);

        sId = edit_sign_up_id.getText().toString();
        sPw = edit_sign_up_pw.getText().toString();
        sPwConfirm = edit_sign_up_pw_confirm.getText().toString();
        sName = edit_sign_up_name.getText().toString();



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sign_up_submit:
                if(getsPw().equals(getsPwConfirm())){
                    Intent intent = new Intent(this,Login.class);
                    intent.putExtra("ID",getsId());
                    intent.putExtra("PW",getsPw());
                    intent.putExtra("PW_CONFIRM",getsPwConfirm());
                    intent.putExtra("NAME",getsName());
                    startActivity(intent);
                    break;
                }
                else {
                    Toast.makeText(getApplicationContext(),"비밀번보 확인이 다릅니다",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
