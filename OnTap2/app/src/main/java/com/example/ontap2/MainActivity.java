package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ontap2.Adapter.ProductAdapter;
import com.example.ontap2.DAO.ProductDAO;

public class MainActivity extends AppCompatActivity {
    ProductDAO productDAO;
    ProductAdapter productAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_themmoi = findViewById(R.id.btn_themmoisanpahm);

        productDAO = new ProductDAO(this);
        productDAO.open();
        productAdapter = new ProductAdapter(productDAO.selectAll(),productDAO);
        listView = findViewById(R.id.lv_product);
        listView.setAdapter(productAdapter);
        btn_themmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    productAdapter.ShowDiaLogAdd(MainActivity.this);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        productDAO.close();
    }
}