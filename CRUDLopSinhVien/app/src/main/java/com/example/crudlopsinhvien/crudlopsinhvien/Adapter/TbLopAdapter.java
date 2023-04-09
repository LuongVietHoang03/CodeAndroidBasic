package com.example.crudlopsinhvien.crudlopsinhvien.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crudlopsinhvien.R;
import com.example.crudlopsinhvien.crudlopsinhvien.DTO.TbLop;

import java.util.ArrayList;

public class TbLopAdapter extends BaseAdapter {
    final ArrayList<TbLop> tbLopArrayList;

    public TbLopAdapter(ArrayList<TbLop> tbLopArrayList) {
        this.tbLopArrayList = tbLopArrayList;
    }

    @Override
    public int getCount() {
        return tbLopArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return tbLopArrayList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return tbLopArrayList.get( i ).getId_lop();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view  == null){
            //Tình huongs chưa có view
            itemView = View.inflate(viewGroup.getContext() , R.layout.custom_list_item_lop,null);
        }else{
            itemView = view;
        }
        // Gán dữ liệu cho phần tử trên view
        //Lấy thông tin từng phần tử trong danh sách
        TbLop tbLop = tbLopArrayList.get( i );
        //tham chiếu các textView trong custom_list_item_lop
        TextView tv_id_lop = itemView.findViewById(R.id.tv_id_lop);
        TextView tv_ten_lop = itemView.findViewById(R.id.tv_ten_lop);
        TextView tv_nganh = itemView.findViewById(R.id.tv_nganh);

        tv_id_lop.setText(tbLop.getId_lop() + "");
        tv_ten_lop.setText(tbLop.getTen_lop());
        tv_nganh.setText(tbLop.getNganh());


        return itemView;
    }
}
