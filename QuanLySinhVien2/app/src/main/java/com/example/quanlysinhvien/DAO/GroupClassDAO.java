package com.example.quanlysinhvien.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;

import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.DTO.SinhVien;
import com.example.quanlysinhvien.Database.CreateDBThongTin;

import java.util.ArrayList;

public class GroupClassDAO {
    SQLiteDatabase db;
    CreateDBThongTin createDBThongTin;
    EditText ed_name_student,ed_ngaysinh,ed_so_dien_thoai;


    public GroupClassDAO(Context context){
        createDBThongTin = new CreateDBThongTin(context);
    }

    public void open(){
        db = createDBThongTin.getWritableDatabase();
    }
    public void close(){
        createDBThongTin.close();
    }

    public long addNew(GroupClass groupClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(GroupClass.COL_MA_LOP,groupClass.getMa_lop());
        contentValues.put(GroupClass.COL_NAME_LOP,groupClass.getTen_lop());
        long res = db.insert(GroupClass.TB_NAME,null,contentValues);
        return  res;
    }
    public int deleteRow(GroupClass groupClass){
            return db.delete(GroupClass.TB_NAME,"id_group = " + groupClass.getId_group(),null);
    }
//    public GroupClass selectOne(int id ){
//        GroupClass objGroupClass = new GroupClass();
////        String[] args = new String[]{ id + ""};
//        String[] columns = new String[]{"*"};
//        Cursor c = db.query(GroupClass.TB_NAME,columns,null,null,null,null,null);
//        if( c.moveToFirst() ){
//            objGroupClass.setId_group( c.getInt(0));
//            objGroupClass.setMa_lop( c.getString(1));
//            objGroupClass.setTen_lop( c.getString(2));
//
//        }
//        return objGroupClass;
//    }
    public ArrayList<GroupClass> selectAll(){
        ArrayList<GroupClass> listGroupClass  = new ArrayList<GroupClass>();
        String[] ds_cot = new String[]{GroupClass.COL_ID,GroupClass.COL_MA_LOP,GroupClass.COL_NAME_LOP};
        Cursor cursor = db.query(GroupClass.TB_NAME,ds_cot,null,null,null,null,null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                GroupClass objGroupClass = new GroupClass();
                objGroupClass.setId_group( cursor.getInt(0));
                objGroupClass.setMa_lop( cursor.getString(1));
                objGroupClass.setTen_lop( cursor.getString(2));
                listGroupClass.add(objGroupClass);
                cursor.moveToNext();
            }
        }
        return  listGroupClass;

    }
    public long addNewStudent(SinhVien sinhVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SinhVien.COL_HO_TEN,sinhVien.getName_student());
        contentValues.put(SinhVien.COL_ID_GROUP,sinhVien.getTen_lop());
        contentValues.put(SinhVien.COL_DATE,sinhVien.getNgaysinh());
        contentValues.put(SinhVien.COL_SO_DIEN_THOAI,sinhVien.getSodienthoai());
        long res  = db.insert(SinhVien.TB_NAME_STUDENTS,null,contentValues);
        return res;

    }
    public ArrayList<SinhVien> GetAllSinhVien(){
        ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
        String[] ds_cot_sinhvien = new String[]{SinhVien.COL_ID_STUDENTS,SinhVien.COL_ID_GROUP,SinhVien.COL_HO_TEN,SinhVien.COL_DATE,SinhVien.COL_SO_DIEN_THOAI};
        Cursor cursor = db.query(SinhVien.TB_NAME_STUDENTS,ds_cot_sinhvien,null,null,null,null,null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                SinhVien objSinhVien = new SinhVien();
                objSinhVien.setId_student(cursor.getInt(0));
                objSinhVien.setTen_lop(cursor.getString(1));
                objSinhVien.setName_student(cursor.getString(2));
                objSinhVien.setNgaysinh(cursor.getString(3));
                objSinhVien.setSodienthoai(cursor.getString(4));
                listSinhVien.add(objSinhVien);
                cursor.moveToNext();
            }

        }
        return listSinhVien;
    }
    public int Update(SinhVien sinhVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SinhVien.COL_HO_TEN,sinhVien.getName_student());

        contentValues.put(SinhVien.COL_DATE,sinhVien.getNgaysinh());
        contentValues.put(SinhVien.COL_SO_DIEN_THOAI,sinhVien.getSodienthoai());
        int res = db.update(SinhVien.TB_NAME_STUDENTS,contentValues,"id_student = " + sinhVien.getId_student(),null);
        return res;
    }
    public int Delete(SinhVien sinhVien){
        return db.delete(SinhVien.TB_NAME_STUDENTS,"id_student = " + sinhVien.getId_student(),null);
    }


}
