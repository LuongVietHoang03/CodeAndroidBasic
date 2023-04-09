package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlysinhvien.Adapter.GroupClassAdapter;
import com.example.quanlysinhvien.DAO.GroupClassDAO;
import com.example.quanlysinhvien.DTO.GroupClass;

import java.util.ArrayList;

public class QuanLyClass extends AppCompatActivity {
    GroupClassAdapter groupClassAdapter;
    GroupClassDAO groupClassDAO;
    ListView listViewLop;
    ArrayList<GroupClass> arrayList;
    GroupClass  currentObjClass = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_class);
        groupClassDAO = new GroupClassDAO(this);
        groupClassDAO.open();
        groupClassAdapter = new GroupClassAdapter(groupClassDAO.selectAll(),groupClassDAO);
        listViewLop = findViewById(R.id.lv_ds_thongtin);
        listViewLop.setAdapter(groupClassAdapter);


//        listViewLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(QuanLyClass.this, "hello", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
    }
}