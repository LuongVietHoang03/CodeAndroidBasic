package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class maytinhActivity2 extends AppCompatActivity {
    EditText ed_soa ,ed_sob;
    Button btnTong;
    TextView vkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maytinh2);

        //Lấy dữ liệu trong intent
        Intent objIntent = getIntent();
        Bundle objBundle = objIntent.getBundleExtra("Goi_hang_thong_tin");
        String hoTen = objBundle.getString("chuoi_ho_ten");
        int tuoi = objBundle.getInt("so_tuoi");

        //Gắn vào text viêw
        TextView tv_thong_tin = findViewById(R.id.tv_thong_tin);
        tv_thong_tin.setText("HỌ tên " + hoTen + "\n Tuổi " + tuoi);







        ed_soa = findViewById(R.id.ed_soa);
        ed_sob = findViewById(R.id.ed_sob);
        btnTong = findViewById(R.id.btnTong);
        vkq = findViewById(R.id.vkq);
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double so_a = Double.parseDouble(ed_soa.getText().toString() );
                double so_b = Double.parseDouble(ed_sob.getText().toString() );
                double tong = so_a + so_b;
                // convert tong sang String
                String tong2 = Double.toString(tong);

                //thông báo kq
                Toast.makeText(maytinhActivity2.this, "Tổng" + tong, Toast.LENGTH_SHORT).show();
                //In ra man hình
                vkq.setText(tong2);
            }
        });
    }
}