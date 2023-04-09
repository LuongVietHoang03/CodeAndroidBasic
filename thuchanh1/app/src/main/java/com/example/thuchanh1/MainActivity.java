package com.example.thuchanh1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvhoTen,tvDienThoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvhoTen = findViewById(R.id.tv_hoten);
        tvDienThoai = findViewById(R.id.tv_dienthoai);

        tvhoTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viết dòng lệnh thông báo
                String ten = tvhoTen.getText().toString();//lấy text trên màn hình
                Toast.makeText(MainActivity.this, "xin chào" +ten, Toast.LENGTH_LONG).show();
                //gắn text cho ô tv họ tên
                tvhoTen.setText("hãy bấm số điện thoại");
            }
        });

        tvDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dt = tvDienThoai.getText().toString();
                //tạo insert để gọi điện
                Intent intent_call = new Intent(Intent.ACTION_CALL, Uri.parse("tel" + dt));
                startActivity(intent_call);
            }
        });

    }
}