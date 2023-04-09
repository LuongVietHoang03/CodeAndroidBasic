package com.example.ontap3.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.ontap3.DAO.ProductDAO;
import com.example.ontap3.DTO.Product;
import com.example.ontap3.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ProductDAO productDAO;
    ArrayList<Product> listProduct;

    public ProductAdapter(ArrayList<Product> listProduct,ProductDAO productDAO) {
        this.listProduct = listProduct;
        this.productDAO = productDAO;

    }



    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int i) {
        Product product = listProduct.get( i );
        return product;
    }

    @Override
    public long getItemId(int i) {
        Product product = listProduct.get( i );
        return product.getId_product();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.list_view,null);
        }else{
            itemView = view;
        }
        final Product product = listProduct.get( i );
        final int _index = i;

        TextView tv_id_product = itemView.findViewById(R.id.tv_id_list_view);
        TextView tv_name_product = itemView.findViewById(R.id.tv_name_list_view);
        TextView tv_price_product = itemView.findViewById(R.id.tv_price_list_view);
        TextView tv_edit = itemView.findViewById(R.id.tv_edit);
        TextView tv_delete = itemView.findViewById(R.id.tv_delete);
        tv_id_product.setText(product.getId_product() + "");
        tv_name_product.setText(product.getName_product());
        tv_price_product.setText(product.getPrice_product());
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDiaLogEdit(product,_index, viewGroup.getContext());
            }
        });
        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Bạn có muốn xóa");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Bạn có chắc chắn muốn xóa " + product.getName_product());
                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int ks = productDAO.deleteRow(product);
                        if(ks  > 0){
                            listProduct.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(viewGroup.getContext(),      "Xóa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(viewGroup.getContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });
        return itemView;
    }
    public void showDiaLogAdd(Context context){
        final Dialog dialog = new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setTitle("Thêm mới sản phẩm");
        EditText ed_name_product = dialog.findViewById(R.id.ed_name);
        EditText ed_price_product = dialog.findViewById(R.id.ed_price);
        Button btn_luu = dialog.findViewById(R.id.btn_luu);
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setName_product(ed_name_product.getText().toString());
                product.setPrice_product(ed_price_product.getText().toString());
                long res = productDAO.AddNew(product);
                if(res > 0){
                listProduct.clear();
                listProduct.addAll(productDAO.selectAll());
                notifyDataSetChanged();
                    Toast.makeText(context, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Thêm mới không thành công", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();


            }
        });
        dialog.show();
    }
    public void ShowDiaLogEdit(Product product,int index,Context context){
        final Dialog dialog = new Dialog(context, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_layout);
        EditText ed_name_product = dialog.findViewById(R.id.ed_name);
        ed_name_product.setText(product.getName_product());

        EditText ed_price_product = dialog.findViewById(R.id.ed_price);
        ed_price_product.setText(product.getPrice_product());
        Button btn_luu = dialog.findViewById(R.id.btn_luu);
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setName_product(ed_name_product.getText().toString());
                product.setPrice_product(ed_price_product.getText().toString());
                int res = productDAO.updateRow(product);
                if(res > 0){
                    listProduct.set(index,product);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Sửa không thành công", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
