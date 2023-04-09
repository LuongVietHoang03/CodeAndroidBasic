package com.example.ontap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ontap3.Adapter.ProductAdapter;
import com.example.ontap3.DAO.ProductDAO;

public class MainActivity extends AppCompatActivity {
    ProductDAO productDAO;
    ProductAdapter productAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_themmoisanpham= findViewById(R.id.btn_themmoi);
        productDAO = new ProductDAO(this);
        productDAO.open();
        productAdapter = new ProductAdapter(productDAO.selectAll(),productDAO);
        listView = findViewById(R.id.lv_danh_sach);
        listView.setAdapter(productAdapter);
        btn_themmoisanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productAdapter.showDiaLogAdd(MainActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        productDAO.close();
    }
}