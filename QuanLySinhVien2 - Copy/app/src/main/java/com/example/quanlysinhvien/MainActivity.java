package com.example.quanlysinhvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.TransitionManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhvien.Adapter.GroupClassAdapter;
import com.example.quanlysinhvien.DAO.GroupClassDAO;
import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.Database.CreateDBThongTin;

import java.util.ArrayList;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    GroupClassDAO groupClassDAO;
    ArrayList<GroupClass> arrayList;
    GroupClassAdapter groupClassAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDanhSachLop = findViewById(R.id.btn_list);
        Button btnThemLop = findViewById(R.id.btn_add);
        groupClassDAO = new GroupClassDAO(this);
        groupClassDAO.open();

        btnThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AddClass(Gravity.CENTER);
            }
        });
        Button btnQuanlySinhVien = findViewById(R.id.btn_quanlysinhvien);
        btnQuanlySinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),quanlysinhvienactivity.class));
            }
        });
        btnDanhSachLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),QuanLyClass.class));
            }
        });

    }


    public void AddClass(int gravity){
        final Dialog  dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_custom_dialog);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }
        EditText edtMaLop = dialog.findViewById(R.id.item_ma_lop);
        EditText edtTenLop = dialog.findViewById(R.id.item_ten_lop);
        Button   btnClose = dialog.findViewById(R.id.btn_close);
        Button   btnAddNew = dialog.findViewById(R.id.btn_addnew);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaLop.setText("");
                edtTenLop.setText("");
            }
        });
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupClass groupClass = new GroupClass();
                groupClass.setMa_lop(edtMaLop.getText().toString() );
                groupClass.setTen_lop(edtTenLop.getText().toString() );
                String ed_ma_lop = edtMaLop.getText().toString();
                String ed_name_lop = edtTenLop.getText().toString();
                if(ed_ma_lop.trim().length() == 0 || ed_name_lop.trim().length() == 0){
                    Toast.makeText(MainActivity.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return ;
                }
                long kq =  groupClassDAO.addNew(groupClass);
                if(kq > 0){
                    Toast.makeText(MainActivity.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();

            }
        });
        dialog.show();



    }

    public void AddNewClass(View view){

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        groupClassDAO.close();
    }
}