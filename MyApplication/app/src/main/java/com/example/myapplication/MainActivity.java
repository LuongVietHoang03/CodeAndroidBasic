package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   EditText email,password;
   TextView vkq;
   Button btn_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.id_email);
        password = findViewById(R.id.id_pass);
        btn_sign = findViewById(R.id.btn_sign);
        vkq = findViewById(R.id.vkq);

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getBaseContext(),info.class);
                String email1 = email.getText().toString();
                String pass1 = password.getText().toString();
                String emailCheck = "admin@gmail.com";
                String passCheck = "123";

                if(email1.equalsIgnoreCase(emailCheck)  && pass1.equalsIgnoreCase(passCheck)){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("chuoi_email" ,emailCheck);
                    bundle.putString("pass" ,passCheck);
                    i.putExtra("Goi_hang_thong_tin",bundle);
                    startActivity(i);


                }else{
                    vkq.setText("Sai thông Tin Đăng nhập");
                }

            }
        });



    }
}