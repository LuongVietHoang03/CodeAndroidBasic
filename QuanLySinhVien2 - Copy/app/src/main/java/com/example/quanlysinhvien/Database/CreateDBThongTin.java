package com.example.quanlysinhvien.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class CreateDBThongTin extends SQLiteOpenHelper {
    static final String DB_NAME = "groupclass6.db";
    static final int DB_VERSION = 1;
    public CreateDBThongTin( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_class  = "CREATE TABLE tb_class (id_group INTEGER NOT NULL,ten_lop TEXT NOT NULL,ma_lop TEXT NOT NULL,PRIMARY KEY(id_group AUTOINCREMENT))";
        db.execSQL(sql_class);

        sql_class = "CREATE TABLE tb_student (id_student INTEGER NOT NULL,name_student TEXT NOT NULL UNIQUE,ngaysinh TEXT NOT NULL,sodienthoai TEXT NOT NULL UNIQUE,id_group INTEGER NOT NULL,PRIMARY KEY(id_student AUTOINCREMENT))";
                db.execSQL(sql_class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
