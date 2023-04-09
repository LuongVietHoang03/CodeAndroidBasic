package com.example.hoanglvph27356_test01.Adapter;

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

import com.example.hoanglvph27356_test01.DAO.ProductDAO;
import com.example.hoanglvph27356_test01.DTO.Product;
import com.example.hoanglvph27356_test01.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product> listProduct;
    ProductDAO productDAO;

    public ProductAdapter(ArrayList<Product> listProduct, ProductDAO productDAO) {
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
    public View getView(int i, View  view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.list_view_product,null);

        }else{
            itemView = view;
        }
        final Product objProduct = listProduct.get( i );
        final int _index = i;

        TextView tv_id_prodcut_list = itemView.findViewById(R.id.tv_id_product_list);
        TextView tv_name_prodcut_list = itemView.findViewById(R.id.tv_name_product_list);
        TextView tv_price_prodcut_list = itemView.findViewById(R.id.tv_price_product_list);
        TextView tv_edit = itemView.findViewById(R.id.tv_edit);
        TextView tv_delete = itemView.findViewById(R.id.tv_delete);
        tv_id_prodcut_list.setText(objProduct.getId_product() + "");
        tv_name_prodcut_list.setText(objProduct.getName_product());
        tv_price_prodcut_list.setText(objProduct.getPrice_product() );

        tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Bạn có muốn xóa sản phẩm");
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setMessage("Bạn có chắc chắn muốn xóa" +objProduct.getName_product());
                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq = productDAO.deleteRow(objProduct);
                        if(kq>0){
                                listProduct.remove(_index);
                                notifyDataSetChanged();
                            Toast.makeText(viewGroup.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(viewGroup.getContext(), "Không xóa được", Toast.LENGTH_SHORT).show();
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
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProduct(objProduct,_index, viewGroup.getContext());
            }
        });
        return itemView;
    }
    public void showEditProduct(Product product, int index, Context context){
        final Dialog dialog = new Dialog(context, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.layout_dialog);

        EditText ed_name_prodcut = dialog.findViewById(R.id.ed_name_prodcut);
        ed_name_prodcut.setText(product.getName_product());
        EditText ed_price_prodcut = dialog.findViewById(R.id.ed_price_prodcut);
        ed_price_prodcut.setText(product.getPrice_product());

        Button btn_luu = dialog.findViewById(R.id.btn_addnew);
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setName_product(ed_name_prodcut.getText().toString());
                product.setPrice_product(ed_price_prodcut.getText().toString());
                int res = productDAO.updateRow(product);
                if(res>0){
                    listProduct.set(index,product);
                    notifyDataSetChanged();
                    Toast.makeText(context, "Cật nhật thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Cật nhật không thành công", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }

        });
        Button btn_cloes = dialog.findViewById(R.id.btn_close);
        btn_cloes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
