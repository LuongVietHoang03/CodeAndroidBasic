package com.example.ontap2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ontap2.DTO.Product;
import com.example.ontap2.Database.CreateProduct;

import java.util.ArrayList;

public class ProductDAO  {
    SQLiteDatabase db;
    CreateProduct createProduct;

    public ProductDAO(Context context) {
        createProduct = new CreateProduct(context);
    }
    public void open(){
        db = createProduct.getWritableDatabase();
    }
    public void close(){
        createProduct.close();
    }
    public long AddNew(Product product){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Product.COL_NAME_PRODUCT,product.getName_product());
        contentValues.put(Product.COL_PRICE_PRODUCT,product.getPrice_product());
        long res = db.insert(Product.TB_NAME_PRODUCT,null,contentValues);
        return res;
    }
    public int updateRow(Product product){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Product.COL_NAME_PRODUCT,product.getName_product());
        contentValues.put(Product.COL_PRICE_PRODUCT,product.getPrice_product());
        int res = db.update(Product.TB_NAME_PRODUCT,contentValues,"id_product  = ? ",new String[]{product.getId_product() + ""});
        return res;
    }
    public int deleteRow(Product product){
        int res = db.delete(Product.TB_NAME_PRODUCT,"id_product = ?",new String[]{product.getId_product() +  ""});
        return  res;
    }

    public ArrayList<Product> selectAll(){
        ArrayList<Product> arrayList  = new ArrayList<Product>();
        String[] ds_cot =new String[]{ "*" };
        Cursor cursor =db.query(Product.TB_NAME_PRODUCT,ds_cot,null,null,null,null,null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Product objProduct = new Product();
                objProduct.setId_product(cursor.getInt(0));
                objProduct.setName_product(cursor.getString(1));
                objProduct.setPrice_product(cursor.getString(2));
                arrayList.add(objProduct);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }

}
