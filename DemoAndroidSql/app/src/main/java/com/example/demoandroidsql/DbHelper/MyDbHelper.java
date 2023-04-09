package com.example.demoandroidsql.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "crud_product";
    static final  int DB_VERSION = 1;

    //Viết hàm khời tạo(Tự viết)

    public MyDbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Các câu lệnh tạo bảng viết ở đây
        String sql_create_tb_cat = "CREATE TABLE tb_cat22 (id INTEGER NOT NULL,name TEXT NOT NULL UNIQUE,PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_create_tb_cat);

        String sql_create_tb_product ="CREATE TABLE tb_product ( id INTEGER NOT NULL, name TEXT NOT NULL, price NUMERIC DEFAULT 0, img_res INTEGER, id_cat INTEGER, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_create_tb_product);

        String sql_insert_into ="INSERT INTO tb_cat22 (name) VALUES('Hàng điện tử'),('Hàng gia dụng')";
        db.execSQL(sql_insert_into);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
