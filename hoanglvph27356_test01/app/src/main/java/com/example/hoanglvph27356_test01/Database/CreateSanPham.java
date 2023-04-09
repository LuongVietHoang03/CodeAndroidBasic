package com.example.hoanglvph27356_test01.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateSanPham extends SQLiteOpenHelper {
    static final  String DB_NAME = "dbproduct.db";
    static final  int DB_VERSION = 1;
    public CreateSanPham( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_prodcut = "CREATE TABLE tb_product (id_product INTEGER NOT NULL,name_product TEXT NOT NULL,price_product TEXT NOT NULL,PRIMARY KEY(id_product AUTOINCREMENT))";
        db.execSQL(sql_prodcut);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
