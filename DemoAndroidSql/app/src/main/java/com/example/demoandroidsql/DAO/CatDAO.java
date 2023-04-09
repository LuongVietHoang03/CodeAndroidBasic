package com.example.demoandroidsql.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.demoandroidsql.DTO.Cat;
import com.example.demoandroidsql.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class CatDAO {
    SQLiteDatabase db;
    MyDbHelper dbHelper;
    //Viết hàm khởi tạo

    public  CatDAO(Context context){
        dbHelper = new MyDbHelper(context);
        db = dbHelper.getReadableDatabase();
    }

    //-----------Viết hàm lấy danh sách dữ liệu-----------

    public ArrayList<Cat> selectAll(){
        //Khai báo danh sách rỗng
        ArrayList<Cat> listCat = new ArrayList<Cat>();
        //viết lênh lấy dữ liệu trong CSDl
        String sql_select = "SELECT * FROM tb_cat22"; // chú ý thức tự cột: id,name  0 -- 1

        Cursor c = db.rawQuery(sql_select,null);

        //kiểm tra có dữ liệu hay không
        if(c.moveToFirst()){
            //có dữ liệu

            while (!c.isAfterLast()){
                //Tạo đối tượng ghi dữ liệu
                Cat objcat = new Cat();
                objcat.setId(c.getInt(0));
                objcat.setName(c.getString(1));
                listCat.add(objcat);
                c.moveToNext();//chuyển con trỏ sang dồng tiếp theo
            }
        }
        return listCat;
    }


    //---------------Đầu vào obj cat chưa có ID-----------------------

    public long insertRow(Cat objCat){
        //Sử dung ContentValue để trền dữ liệu
        ContentValues objContent = new ContentValues();

        objContent.put("name",objCat.getName() );
        //Thực hiện lệnh insert
        return  db.insert( "tb_cat22" ,null,objContent );
        // trả về id của dòng mới them


    }
    //--------------edit: objCat phải gắn thêm id dòng muốn sửa-----------

    public int updateRow(Cat objCat){
        ContentValues objContent = new ContentValues();
        objContent.put( "name",objCat.getName() );
        //tạo ra mảng điều kiện để truyền tham số
        String [] dieu_kien = new String[] { objCat.getId() + "" };
        //Thực hiện lênh cật nhật
        return db.update("tb_cat22" ,objContent,"id = ?" ,dieu_kien);
        //hàm trả về số lượng dòng bị sửa
    }

    //--------------delete----------------------
    public  int deleteRow(Cat objCat){
        //Tạo mảng điều kiện
        String [] dieu_kien = new String[] { objCat.getId() + "" };
        return db.delete("tb_cat22" ,"id = ?" ,dieu_kien);
    }
    //Hàm lấy ra 1 dong ==> trả về objCat -- > Đầu là lầ id của dòng
    public Cat selectOne(int id){
        Cat objCat = null;//Tạo một đối tượng rỗng tránh lỗi return
        String [] dieu_kien = new String[] { id + "" };

        // Câu lệnh sql
        String sql = "SELECT id, name FROM tb_cat22 WHERE id = ? ";
        Cursor c = db.rawQuery(sql,dieu_kien);
        if(c.moveToFirst()){
            //có dữ liệu

            objCat = new Cat();
            objCat.setId( c.getInt( 0) );
            objCat.setName( c.getString( 1) );

        }
        return objCat;




    }



}
