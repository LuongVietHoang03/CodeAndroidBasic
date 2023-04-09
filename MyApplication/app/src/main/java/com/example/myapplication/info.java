package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class info extends AppCompatActivity {
    TextView id_thongbao;
    EditText ed_phone;
    Button id_call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent objIntent = getIntent();
        Bundle objBundle = objIntent.getBundleExtra("Goi_hang_thong_tin");
        String email =objBundle.getString("chuoi_email");
        String password = objBundle.getString("pass");
        id_thongbao = findViewById(R.id.id_thongbao);
        ed_phone = findViewById(R.id.ed_phone);
        id_call = findViewById(R.id.id_call);
        id_thongbao.setText("Email :" +email + "\n PassWord :" +password);

        id_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone =ed_phone.getText().toString();
                Intent intent_call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent_call);
            }
        });


    }
}