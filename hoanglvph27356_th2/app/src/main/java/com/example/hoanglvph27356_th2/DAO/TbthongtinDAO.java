package com.example.hoanglvph27356_th2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoanglvph27356_th2.DTO.CreateDBThongTin;
import com.example.hoanglvph27356_th2.DTO.TbThongTin;

import java.util.ArrayList;

public class TbthongtinDAO {
    SQLiteDatabase database;
    CreateDBThongTin createDBThongTin;

    public  TbthongtinDAO(Context context){
        createDBThongTin = new CreateDBThongTin(context);
    }
    public  void open(){
        database = createDBThongTin.getWritableDatabase();
    }
    public void close(){
        createDBThongTin.close();
    }
    //Thêm mới đối tượng
    public long AddNew(TbThongTin tbThongTin){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TbThongTin.COL_NAME_HO_TEN,tbThongTin.getHo_ten());
        contentValues.put(TbThongTin.COL_NAME_SO_DIEN_THOAI,tbThongTin.getSo_dien_thoai());
        contentValues.put(TbThongTin.COL_NAME_NOTE,tbThongTin.getNote());
        long res = database.insert(TbThongTin.TB_NAME,null,contentValues);
        return res;
    }
    public  int Update(TbThongTin tbThongTin){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TbThongTin.COL_NAME_HO_TEN,tbThongTin.getHo_ten());
        contentValues.put(TbThongTin.COL_NAME_SO_DIEN_THOAI,tbThongTin.getSo_dien_thoai());
        contentValues.put(TbThongTin.COL_NAME_NOTE,tbThongTin.getNote());
        int res = database.update(TbThongTin.TB_NAME,contentValues,"id_canhan = " +tbThongTin.getId_canhan(),null);
        return  res;


    }
        //Lấy danh sách cát cột dữ liệ để in ra màn hình
    public ArrayList<TbThongTin> GetAll(){
        ArrayList<TbThongTin> dsthongtin = new ArrayList<TbThongTin>();

        String[] danh_sach_cot_lay_du_lieu = new String[]{TbThongTin.COL_NAME_ID,TbThongTin.COL_NAME_HO_TEN,TbThongTin.COL_NAME_SO_DIEN_THOAI,TbThongTin.COL_NAME_NOTE};
        Cursor cursor = database.query(TbThongTin.TB_NAME,danh_sach_cot_lay_du_lieu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String ho_ten = cursor.getString(1);
            String so_dien_thoai = cursor.getString(2);
            String note = cursor.getString(3);
            TbThongTin tbThongTin = new TbThongTin();
            tbThongTin.setId_canhan(id);
            tbThongTin.setHo_ten(ho_ten);
            tbThongTin.setSo_dien_thoai(so_dien_thoai);
            tbThongTin.setNote(note);
            dsthongtin.add(tbThongTin);
            cursor.moveToNext();


        }
        return dsthongtin;
    }
    // Xóa 1 đối tượng
    public int Delete(TbThongTin tbThongTin){
        return  database.delete(TbThongTin.TB_NAME,"id_canhan = " + tbThongTin.getId_canhan()  ,null );

    }
}
