package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button open = findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(getBaseContext(),maytinhActivity2.class);

                //Tạo đữ liệu để gửi
                String hoTen = " Nguyễn Văn A";//Có thể lấy họ tên từ editext và hàm khác;
                int tuoi = 50;

                //Tạo đối tượng bundle để đóng gói giữ liệu
                Bundle bundle = new Bundle();
                bundle.putString("chuoi_ho_ten" ,hoTen);
                bundle.putInt("so_tuoi" ,tuoi);

                //Gắn bundle vào intent(giống như giao gói hàng cho shipper)

                i.putExtra("Goi_hang_thong_tin" ,bundle);




                startActivity(i);//Gọi activity ra hoạt động
            }
        });


    }
}