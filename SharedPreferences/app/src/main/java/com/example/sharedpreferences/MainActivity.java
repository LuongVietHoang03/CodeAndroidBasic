package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;//Khai báo thuộc tính cấp llass để sử dụng chung trong các hảm
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // khỏi tạo biến
        sharedPreferences = getSharedPreferences("user_account", Context.MODE_PRIVATE);

    }

    public void SaveSharedPref(View view){
        //Khởi tạo biến editor để thực hiện thao tác ghi vào sharedperf
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hoTen","Nguyễn Văn A");
        editor.putString("email","nguyenvana@gmail.com");
        editor.commit();
    }
    public void RedSharedPref(View view){
        String user = sharedPreferences.getString("hoTen","");
        String email = sharedPreferences.getString("email","");
        Toast.makeText(getBaseContext(), "Họ và tên :" + user + "Email" + email, Toast.LENGTH_SHORT).show();

    }
}