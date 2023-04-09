package com.example.crudlopsinhvien;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.crudlopsinhvien.crudlopsinhvien.Adapter.TbLopAdapter;
import com.example.crudlopsinhvien.crudlopsinhvien.DAO.TbLopDao;
import com.example.crudlopsinhvien.crudlopsinhvien.DTO.TbLop;
import com.example.crudlopsinhvien.crudlopsinhvien.createDBSinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed_ten_lop,ed_nganh;
    TbLopDao tbLopDao;
    TbLopAdapter tbLopAdapter;
    ListView listViewLop;
    ArrayList<TbLop> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_ten_lop = findViewById(R.id.ed_ten_lop);
        ed_nganh = findViewById(R.id.ed_nganh);

        tbLopDao = new TbLopDao(this);
        tbLopDao.open();

        //Lấy danh sách từ cơ sở dữ liệu
        arrayList = tbLopDao.GetAll();
        tbLopAdapter = new TbLopAdapter(arrayList);
        listViewLop = findViewById(R.id.lv_ds_lop);
        listViewLop.setAdapter(tbLopAdapter);



    }
    public void ClickAddRow(View view){
        TbLop tbLop = new TbLop();
        tbLop.setTen_lop( ed_ten_lop.getText().toString() );
        tbLop.setNganh( ed_nganh.getText().toString() );
        long kq = tbLopDao.ClickAddRow(tbLop);
        if( kq > 0 ){
            Toast.makeText(this, "Thêm mới thành công" + kq, Toast.LENGTH_SHORT).show();
            arrayList.clear();
            arrayList.addAll(tbLopDao.GetAll());
            tbLopAdapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "Thêm mới thất bại" + kq, Toast.LENGTH_SHORT).show();
        }

    }
    public void UpdateRow(View view){

    }
    public void DeleteRow(View view){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tbLopDao.close();
    }
}