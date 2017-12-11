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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_sign_up_submit = (Button) findViewById(R.id.btn_sign_up_submit);
        edit_sign_up_id = (EditText) findViewById(R.id.edit_sign_up_id);
        edit_sign_up_pw = (EditText) findViewById(R.id.edit_sign_up_pw);
        edit_sign_up_name = (EditText) findViewById(R.id.edit_sign_up_name);
        edit_sign_up_pw_confirm = (EditText) findViewById(R.id.edit_sign_up_pw_confirm);
        edit_sign_up_pw_confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = edit_sign_up_pw.getText().toString();
                String confirm = edit_sign_up_pw_confirm.getText().toString();

                if (password.equals(confirm)) {
                    edit_sign_up_pw.setBackgroundColor(Color.GREEN);
                    edit_sign_up_pw_confirm.setBackgroundColor(Color.GREEN);
                } else {
                    edit_sign_up_pw.setBackgroundColor(Color.RED);
                    edit_sign_up_pw_confirm.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        btn_sign_up_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sign_up_submit:
                if(edit_sign_up_id.getText().toString().length() == 0 || edit_sign_up_name.getText().toString().length() ==0){
                    Toast.makeText(Sign_up.this,"이메일 입력해주세요!", Toast.LENGTH_SHORT).show();
                    edit_sign_up_id.requestFocus();
                    return;
                }
                else if(!edit_sign_up_pw.getText().toString().equals(edit_sign_up_pw_confirm.getText().toString())){
                    Toast.makeText(this,"비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    edit_sign_up_pw_confirm.setText("");
                    edit_sign_up_pw.setText("");
                    edit_sign_up_pw.requestFocus();
                    return;
                }
                Intent result = new Intent();
                result.putExtra("email",edit_sign_up_id.getText().toString());
                result.putExtra("pw",edit_sign_up_pw.getText().toString());
                setResult(RESULT_OK,result);
                finish();
                break;
        }
    }
}
