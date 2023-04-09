package com.example.crudlopsinhvien.crudlopsinhvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class createDBSinhVien extends SQLiteOpenHelper {
    public static final String DB_NAME = "QlSV.db";
    public static final int DB_VERSION = 1;
    public createDBSinhVien( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_cr_tb_lop = "CREATE TABLE tb_lop (id_lop INTEGER NOT NULL,ten_lop TEXT NOT NULL,nganh INTEGER NOT NULL,PRIMARY KEY(id_lop AUTOINCREMENT))";
        db.execSQL(sql_cr_tb_lop);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
