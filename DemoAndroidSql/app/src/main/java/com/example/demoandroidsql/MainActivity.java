package com.example.demoandroidsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demoandroidsql.DAO.CatDAO;
import com.example.demoandroidsql.DTO.Cat;
import com.example.demoandroidsql.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String TAG = "zzzzzzzzzzzz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCat = findViewById(R.id.btnCat);
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chạy activity

                Intent i = new Intent( getBaseContext(), categoryactivity.class);

                startActivity( i );

            }
        });



//        //thử nhiệm MyDBHelper
//
////        MyDbHelper dbHelper = new MyDbHelper(this);
////
////        dbHelper.getWritableDatabase();//Phải gét write thì mới tạo được sdds
//
//        //==========Thử nhiệm DAO
//        CatDAO catDAO = new CatDAO(this);
//
//        ArrayList<Cat> listCat = catDAO.selectAll();
//        //GHi log để kiểm tra kết quả lấy dữ liệu:
//        Log.d(TAG,"onCreate: số lượng dòng =" +listCat.size() );
//        //in ds tên thì dùng for
//        for(int i = 0 ; i <listCat.size(); i++){
//            Cat objCat = listCat.get(i);
//
//            Log.d(TAG,"onCreate: Tên Cat = " +objCat.getName() );
        }


    }
