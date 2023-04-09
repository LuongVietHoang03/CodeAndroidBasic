package com.example.baitapwebview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText ed_hoTen,ed_email,ed_sodienthoai,ed_gioithieu;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("Thongtincanhan", Context.MODE_PRIVATE);
        ed_email = findViewById(R.id.ed_email);
        ed_hoTen = findViewById(R.id.ed_hoTen);
        ed_sodienthoai = findViewById(R.id.ed_sodienthoai);
        ed_gioithieu = findViewById(R.id.ed_gioithieu);
        btn_add = findViewById(R.id.btn_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String hoten = ed_hoTen.getText().toString();
                String email = ed_email.getText().toString();
                String sodienthoai = ed_sodienthoai.getText().toString();
                String gioithieu = ed_gioithieu.getText().toString();
                if(hoten.isEmpty() ||email.isEmpty()||sodienthoai.isEmpty()||gioithieu.isEmpty()){
                    Toast.makeText(MainActivity.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                editor.putString("hoTen",hoten);
                editor.putString("email",email);
                editor.putString("sodienthoai",sodienthoai);
                editor.putString("gioithieu",gioithieu);
                editor.commit();
                Toast.makeText(MainActivity.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(getBaseContext(),MainActivity2.class);
                startActivity(intent);
            }

        });



    }

    }
