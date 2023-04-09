package com.example.demoandroidsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.demoandroidsql.Adapter.CategoryAdapter;
import com.example.demoandroidsql.DAO.CatDAO;
import com.example.demoandroidsql.DTO.Cat;

public class categoryactivity extends AppCompatActivity {
    ListView lv_cat;
    CategoryAdapter adapter;
    CatDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryactivity);

        lv_cat = findViewById(R.id.lv_cat);

        dao = new CatDAO(this);

        Log.d("zzzzzzzz" ,"Oncreate số lượng dòng category = " + dao.selectAll().size() );

        //thử nhiệm DAO Them moi

        Cat objCat = new Cat();

        objCat.setName("Dòng thêm mới 777777777");

        long new_id = dao.insertRow( objCat);
        Log.d("zzzzzzzzzzzzzzzz","onCreate ID mới thêm = " + new_id );


        //tạo adapter

        adapter = new CategoryAdapter( dao.selectAll() );

        lv_cat.setAdapter( adapter );
    }
}