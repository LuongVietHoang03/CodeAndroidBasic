package com.example.vidu6_listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    // Khai báo 1 danh sách để chứa sản phẩm

    ArrayList<Product> lstPrd ;

    // Khai báo một hàm construster;


    public ProductAdapter(ArrayList<Product> lstPrd) {
        this.lstPrd = lstPrd;
    }


    @Override
    public int getCount() { // trả về số luongj phần tử trong danh sách
        return lstPrd.size();
    }

    @Override
    public Object getItem(int i) { // Trar về phân từ hiện tại thứ i
        Product objProduct = lstPrd.get( i );
        return objProduct;
    }

    @Override
    public long getItemId(int i) {
        Product objProduct = lstPrd.get( i ); // Trả về  phần tử hiện tại
        return objProduct.id;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        //hàm này dùng để tùy chỉnh cách hiển thị dự liệu lên danh sach
        // Tạo một biến view đê tùy chỉnh

        View item_view;
        if(convertView == null){
            item_view = View.inflate(parent.getContext(),R.layout.item_you_list_product, null);

        }else{
            item_view = convertView;

        }
        //Lấy sản phẩm để làm việc

        Product objProduct = lstPrd.get(i);

        // ánh xạ các view của dòng vào biến

        TextView tv_name = item_view.findViewById(R.id.tv_name);


        TextView tv_price = item_view.findViewById(R.id.tv_price);

        ImageView img = item_view.findViewById(R.id.img_Prodcut);

        // Gán dữu liệu


        tv_name.setText("Tên sản phẩm" + objProduct.name);
        tv_price.setText("Giá " + objProduct.price + "");
        img.setImageResource(objProduct.img_res);

        return item_view;
    }
}
