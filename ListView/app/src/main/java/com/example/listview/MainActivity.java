package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv_color;
    //Khai bảo mảng dữ liếu
    String [] mang_mau_sac = {"Xanh","Đỏ","Tím","Vàng"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ

        lv_color = findViewById(R.id.lv_color);

        //tạo adapter
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,mang_mau_sac);


        lv_color.setAdapter(adapter);

    }
}