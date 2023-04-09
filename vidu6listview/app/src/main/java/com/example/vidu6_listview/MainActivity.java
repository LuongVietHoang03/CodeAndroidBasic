package com.example.vidu6_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_product;
    ArrayList<Product> listProduct;//Khai báo danh sách sản phẩm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ view

        lv_product = findViewById(R.id.tv_product);

        //Tạo danh sách đối tượng

        listProduct = new ArrayList<Product>();
        listProduct.add( new Product(1,"SP1",200,R.drawable.anh1)    );
        listProduct.add( new Product(2,"SP2",200,R.drawable.anh1)    );
        listProduct.add( new Product(3,"SP3",200,R.drawable.anh1)    );
        listProduct.add( new Product(4,"SP4",200,R.drawable.anh1)    );
        listProduct.add( new Product(5,"SP5",200,R.drawable.anh1)    );


        // Tạo adapter

        ProductAdapter adapter = new ProductAdapter(listProduct);

        //Gắp adapter cho listView

        lv_product.setAdapter(adapter);
    }
}