package com.example.crudlopsinhvien.crudlopsinhvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.crudlopsinhvien.crudlopsinhvien.DTO.TbLop;
import com.example.crudlopsinhvien.crudlopsinhvien.createDBSinhVien;

import java.util.ArrayList;

public class TbLopDao {
    SQLiteDatabase database;
    createDBSinhVien createDBSinhVien;

    public TbLopDao(Context context) {
        createDBSinhVien = new createDBSinhVien(context);
    }
    public void open(){
        database = createDBSinhVien.getWritableDatabase();

    }
    public void close(){
        createDBSinhVien.close();
    }

    public long ClickAddRow(TbLop tbLop){
        //tạo đối tượng contentvalues để làm phương tiện gửi dữ liệu cho database
        //giống như bundle cho intent

        ContentValues contentValues = new ContentValues();
        contentValues.put(TbLop.COL_NAME_TEN_LOP, tbLop.getTen_lop());
        contentValues.put(TbLop.COL_NAME_NGANH,tbLop.getNganh());
        //GỌi hàm insert  để thêm dữ liệu vào bảng
        long res  = database.insert(TbLop.TB_NAME,null,contentValues);
        return res;

    }
    public ArrayList<TbLop> GetAll(){
        //1. tạo một danh sách chứa
        ArrayList<TbLop> dsLop = new ArrayList<TbLop>();

        //Khai báo danh sách cột để lấy dữ liệu
         String [] danh_sach_cot_de_lay_du_lieu = new String[]{TbLop.COL_NAME_ID,TbLop.COL_NAME_TEN_LOP, TbLop.COL_NAME_NGANH};

         //2. Tạo đối tượng con trở để đọc dữ liêuk

        Cursor cursor = database.query(TbLop.TB_NAME,danh_sach_cot_de_lay_du_lieu,null,null,null,null,null);
        cursor.moveToFirst();//Đưa con trỏ về đầu kết quả
        while (!cursor.isAfterLast()){
            //lấy thông tin từng cột in vào biến
            int id = cursor.getInt(0);
            String ten_lop = cursor.getString(1);
            String nganh = cursor.getString(2);
            //tạo đối tượng  thông tin để gắn lơp thông tin vào
            TbLop tbLop = new TbLop();
            tbLop.setId_lop(id);
            tbLop.setTen_lop(ten_lop);
            tbLop.setNganh(nganh);
            //thêm danh sách
            dsLop.add(tbLop);

            //sau khi thêm xong con trỏ chỉ xuống phầm tiếp theo
            cursor.moveToNext();



        }
            return  dsLop;
    }

}
