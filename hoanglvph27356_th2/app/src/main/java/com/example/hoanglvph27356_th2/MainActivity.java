package com.example.hoanglvph27356_th2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hoanglvph27356_th2.Adapter.TbThongTinAdapter;
import com.example.hoanglvph27356_th2.DAO.TbthongtinDAO;
import com.example.hoanglvph27356_th2.DTO.CreateDBThongTin;
import com.example.hoanglvph27356_th2.DTO.TbThongTin;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed_name,ed_so_dien_thoai,ed_note;
    TbthongtinDAO tbthongtinDAO;
    TbThongTinAdapter tbThongTinAdapter;
    ListView listViewThongTin;
    ArrayList<TbThongTin> arrayList;
    TbThongTin currentObjThongTin = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        CreateDBThongTin createDBThongTin = new CreateDBThongTin(this);
//        createDBThongTin.getWritableDatabase();
        ed_name = findViewById(R.id.ed_ho_ten);
        ed_so_dien_thoai = findViewById(R.id.ed_so_dien_thoai);
        ed_note = findViewById(R.id.ed_note);

        tbthongtinDAO = new TbthongtinDAO(this);
        tbthongtinDAO.open();//gọi hàm kết nối cơ sở dữ liệu
        arrayList = tbthongtinDAO.GetAll();
        tbThongTinAdapter = new TbThongTinAdapter(arrayList);
        listViewThongTin = findViewById(R.id.lv_ds_thongtin);
        listViewThongTin.setAdapter(tbThongTinAdapter);
        listViewThongTin.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                currentObjThongTin = arrayList.get( position );
                ed_name.setText(currentObjThongTin.getHo_ten());
                ed_so_dien_thoai.setText(currentObjThongTin.getSo_dien_thoai());
                ed_note.setText(currentObjThongTin.getNote());
                return false;
            }
        });



    }
    //tạo sự kiện click thêm mới
    public void ClickAddRow(View view){
        TbThongTin tbThongTin = new TbThongTin();
        tbThongTin.setHo_ten( ed_name.getText().toString() );
        tbThongTin.setSo_dien_thoai( ed_so_dien_thoai.getText().toString() );
        tbThongTin.setNote( ed_note.getText().toString() );
        long kq = tbthongtinDAO.AddNew(tbThongTin);
        if(kq > 0 ){
            Toast.makeText(this, "Thêm mới thành công" + kq, Toast.LENGTH_SHORT).show();
            arrayList.clear();
            arrayList.addAll(tbthongtinDAO.GetAll());
            tbThongTinAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "Thêm mới thất bại" + kq, Toast.LENGTH_SHORT).show();
        }


    }
    public void updateRow(View view){
        String ho_ten_new = ed_name.getText().toString();
        String so_dien_thoai_new = ed_so_dien_thoai.getText().toString();
        String note_new = ed_note.getText().toString();
        if(currentObjThongTin != null && !currentObjThongTin.getHo_ten().equalsIgnoreCase(ho_ten_new) ||
                !currentObjThongTin.getSo_dien_thoai().equalsIgnoreCase(so_dien_thoai_new)||
                !currentObjThongTin.getNote().equalsIgnoreCase(note_new)){
            currentObjThongTin.setHo_ten(ho_ten_new);
            currentObjThongTin.setSo_dien_thoai(so_dien_thoai_new);
            currentObjThongTin.setNote(note_new);
            int res = tbthongtinDAO.Update(currentObjThongTin);
            if(res > 0 ){
                ed_name.setText("");
                ed_so_dien_thoai.setText("");
                ed_note.setText("");
                arrayList.clear();
                arrayList.addAll(tbthongtinDAO.GetAll());
                tbThongTinAdapter.notifyDataSetChanged();;
                Toast.makeText(this, "Cật nhật thành công", Toast.LENGTH_SHORT).show();
                currentObjThongTin = null;
            }else{
                Toast.makeText(this, "Lỗi không cật nhật được ", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Không có thây đổi để cật nhật", Toast.LENGTH_SHORT).show();
        }




    }
    public void deleteRow(View view){
            if(currentObjThongTin != null){
                int res = tbthongtinDAO.Delete(currentObjThongTin);
                if(res > 0){
                    ed_name.setText("");
                    ed_so_dien_thoai.setText("");
                    ed_note.setText("");
                    arrayList.clear();
                    arrayList.addAll(tbthongtinDAO.GetAll());
                    tbThongTinAdapter.notifyDataSetChanged();;
                    Toast.makeText(this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                    currentObjThongTin = null;

                }else{
                    Toast.makeText(this, "Lỗi xóa", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Hãy bấm giữ một bản ghi trước khi xóa", Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tbthongtinDAO.close();
    }
}