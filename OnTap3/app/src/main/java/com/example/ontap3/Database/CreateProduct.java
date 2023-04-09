package com.example.ontap3.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CreateProduct  extends SQLiteOpenHelper {
    static final String DB_NAME = "product1.db";
    static final int DB_VISION = 1;
    public CreateProduct(Context context) {
        super(context, DB_NAME, null, DB_VISION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_product = "CREATE TABLE tb_product (id_product INTEGER NOT NULL,name_product TEXT NOT NULL,price_product TEXT NOT NULL,PRIMARY KEY(id_product AUTOINCREMENT))";
        db.execSQL(sql_product);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
