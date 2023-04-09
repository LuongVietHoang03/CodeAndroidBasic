package com.example.hoanglvph27356_th2.DTO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateDBThongTin extends SQLiteOpenHelper {
    public static final String DB_NAME = "Thongtincanhan2.db";
    public static final int DB_VERSION = 1;
    public CreateDBThongTin( Context context) {
        super(context, DB_NAME, null,  DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql_cr_tb_thong_tin = "CREATE TABLE tb_thongtin (id_canhan INTEGER NOT NULL,ho_ten TEXT NOT NULL,so_dien_thoai TEXT NOT NULL,note TEXT NOT NULL,PRIMARY KEY(id_canhan AUTOINCREMENT))";
            db.execSQL(sql_cr_tb_thong_tin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
