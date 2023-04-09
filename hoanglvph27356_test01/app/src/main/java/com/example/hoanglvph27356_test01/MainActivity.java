package com.example.hoanglvph27356_test01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hoanglvph27356_test01.Adapter.ProductAdapter;
import com.example.hoanglvph27356_test01.DAO.ProductDAO;
import com.example.hoanglvph27356_test01.DTO.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ProductDAO productDAO;
    ArrayList<Product> arrayList;
    Button btn_ThemMoiSanPham;
    ProductAdapter productAdapter;
    ListView listViewProduct;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ThemMoiSanPham = findViewById(R.id.btn_ThemMoiSanPham);

        productDAO = new ProductDAO(this);
        productDAO.open();
        arrayList = productDAO.selectAll();
        productAdapter = new ProductAdapter(productDAO.selectAll(),productDAO);
        listViewProduct = findViewById(R.id.lv_info_product);
        listViewProduct.setAdapter(productAdapter);
        btn_ThemMoiSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewProdcut(Gravity.CENTER);

            }
        });

    }
    public void AddNewProdcut(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog);
        Window window = dialog.getWindow();
        if(window == null){
            return ;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        WindowManager.LayoutParams windowattributes =window.getAttributes();
        windowattributes.gravity = gravity;
        window.setAttributes(windowattributes);
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }
        EditText ed_name_product = dialog.findViewById(R.id.ed_name_prodcut);
        EditText ed_price_product = dialog.findViewById(R.id.ed_price_prodcut);
        Button btn_close = dialog.findViewById(R.id.btn_close);
        Button btn_AddNew = dialog.findViewById(R.id.btn_addnew);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btn_AddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setName_product(ed_name_product.getText().toString());
                product.setPrice_product(ed_price_product.getText().toString());
                String edNameProduct =ed_name_product.getText().toString();
                String edPriceProduct =ed_price_product.getText().toString();

                long kq = productDAO.AddNew(product);
                if(kq > 0){


                    arrayList.clear();
                    arrayList.addAll(productDAO.selectAll());
                    productAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        productDAO.close();
    }
}