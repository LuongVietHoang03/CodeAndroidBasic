package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlysinhvien.Adapter.GroupClassAdapter;
import com.example.quanlysinhvien.Adapter.SinhVienAdapter;
import com.example.quanlysinhvien.Adapter.SpinerGroupClassAdapter;
import com.example.quanlysinhvien.DAO.GroupClassDAO;
import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.DTO.SinhVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class quanlysinhvienactivity extends AppCompatActivity {
    EditText ed_hoten,ed_ngaysinh,ed_sodienthoai;
    GroupClassDAO groupClassDAO;
    ListView listViewSinhVien;
    SinhVienAdapter sinhVienAdapter;
    GroupClassAdapter groupClassAdapter;
    ArrayList<SinhVien> arrayList;
    SinhVien curentObjLop = null;
    Spinner spinner;

//    Spinner spinner;
//    GroupClassDAO groupClassDAO = new GroupClassDAO(this)  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlysinhvienactivity);
//        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<GroupClass> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,groupClassDAO.selectOne());
//        spinner.setAdapter(adapter);
        ed_hoten = findViewById(R.id.ed_ten_sinh_vien);
        ed_ngaysinh = findViewById(R.id.ed_ngay_sinh);
        ed_sodienthoai = findViewById(R.id.ed_so_dien_thoai);
        groupClassDAO = new GroupClassDAO(this);
        groupClassDAO.open();
        arrayList = groupClassDAO.GetAllSinhVien();
        sinhVienAdapter = new SinhVienAdapter(arrayList);
        listViewSinhVien = findViewById(R.id.lv_ds_thongtinsinhvien);
        listViewSinhVien.setAdapter(sinhVienAdapter);

        listViewSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                curentObjLop = arrayList.get( position );
                ed_hoten.setText( curentObjLop.getName_student());
                ed_ngaysinh.setText( curentObjLop.getNgaysinh());
                ed_sodienthoai.setText( curentObjLop.getSodienthoai());
                Toast.makeText(quanlysinhvienactivity.this, "Chọn thành công", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        final Spinner spinner_group_class = findViewById(R.id.spinner);
        SpinerGroupClassAdapter adapter = new SpinerGroupClassAdapter(groupClassDAO.selectAll());
        spinner_group_class.setAdapter(adapter);



        TextView tv_sodienthoai = findViewById(R.id.tv_so_dien_thoai);



    }
    public void ClickAddRow(View view){
        SinhVien sinhvien = new SinhVien();
        String hoTen = ed_hoten.getText().toString();
        String ngaySinh = ed_ngaysinh.getText().toString();
        String soDienThoai = ed_sodienthoai.getText().toString();
        final Spinner spinner_class =findViewById(R.id.spinner);
        double checkSoDienThoai;

        if(hoTen.trim().length() == 0 || ngaySinh.trim().length() == 0 ||soDienThoai.trim().length() == 0){
            Toast.makeText(this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/mm/yyyy");
        Date d = null;
        try{
            d = sdf.parse(ngaySinh);
        } catch (ParseException e) {
            Toast.makeText(this, "Ngày tháng không đúng định dạng", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }
        try{
            checkSoDienThoai = Double.parseDouble(soDienThoai);
        } catch (NumberFormatException e){
            Toast.makeText(this, "Số điện thoại phải là số", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return;
        }
        if(!(soDienThoai.trim().length() >= 9 && soDienThoai.trim().length() <= 10)){
            Toast.makeText(this, "Độ dài của số điện thoại từ 9-10 số", Toast.LENGTH_SHORT).show();
            return;
        }



        sinhvien.setName_student(hoTen.trim());
        sinhvien.setNgaysinh(ngaySinh.trim());
        sinhvien.setSodienthoai(soDienThoai.trim());
        GroupClass objGroupClass = (GroupClass) spinner_class.getSelectedItem();
        sinhvien.setTen_lop(objGroupClass.getTen_lop());

        long kq  = groupClassDAO.addNewStudent(sinhvien);
        if(kq > 0 ){
            arrayList.clear();
            arrayList.addAll(groupClassDAO.GetAllSinhVien());
            sinhVienAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
        }
    }
    public void editRow(View view){
        String ho_ten_new = ed_hoten.getText().toString();
        String ngaysinh_new = ed_ngaysinh.getText().toString();
        String sodienthoai_new = ed_sodienthoai.getText().toString();
        if(curentObjLop != null && !curentObjLop.getName_student().equalsIgnoreCase(ho_ten_new)
                ||!curentObjLop.getNgaysinh().equalsIgnoreCase(ngaysinh_new)||
                !curentObjLop.getSodienthoai().equalsIgnoreCase(sodienthoai_new)){
            curentObjLop.setName_student(ho_ten_new);
            curentObjLop.setNgaysinh(ngaysinh_new);
            curentObjLop.setSodienthoai(sodienthoai_new);
            int res = groupClassDAO.Update(curentObjLop);
            if(res > 0 ){
                ed_hoten.setText("");
                ed_ngaysinh.setText("");
                ed_sodienthoai.setText("");
                arrayList.clear();
                arrayList.addAll(groupClassDAO.GetAllSinhVien());
                sinhVienAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Cật nhật thành công", Toast.LENGTH_SHORT).show();
                curentObjLop = null;
            }else{
                Toast.makeText(this, "Lỗi không cật nhật được ", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Không có thay đổi để cật nhật", Toast.LENGTH_SHORT).show();
        }

    }
    public void deleteRow(View view){
        if(curentObjLop != null){
            int res = groupClassDAO.Delete(curentObjLop);
            if(res > 0){
                ed_hoten.setText("");
                ed_sodienthoai.setText("");
                ed_ngaysinh.setText("");
                arrayList.clear();
                arrayList.addAll(groupClassDAO.GetAllSinhVien());
                sinhVienAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                curentObjLop = null;

            }else{
                Toast.makeText(this, "Lỗi xóa", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Bấm giữ một bản ghi trước khi xóa", Toast.LENGTH_SHORT).show();
        }

    }
    public void CallSoDienThoai(View view){
        TextView tv_sdt= findViewById(R.id.tv_so_dien_thoai);
        String call = tv_sdt.getText().toString();
        Intent ii = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + call));
        startActivity( ii );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        groupClassDAO.close();
    }
}