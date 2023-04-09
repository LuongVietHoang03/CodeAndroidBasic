package com.example.demoandroidsql.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoandroidsql.DTO.Cat;
import com.example.demoandroidsql.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    ArrayList<Cat> listCat;

    public CategoryAdapter(ArrayList<Cat> listCat) {
        this.listCat = listCat;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int i) {
        Cat objCat = listCat.get( i );
        return objCat;
    }

    @Override
    public long getItemId(int i) {
        Cat objCat = listCat.get( i );
        return objCat.getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //1.Tạo view Dòng mới

        View row;
        if(view == null){
            row = View.inflate(viewGroup.getContext(), R.layout.dong_the_loai,null);

        }else{
            row = view;//view là tham số của hàm getView,
        }
        //Ánh sạ các trang trong dòng
        TextView tv_id = row.findViewById(R.id.tv_id);
        TextView tv_name = row.findViewById(R.id.tv_name);
        TextView tv_edit = row.findViewById(R.id.tv_edit);
        TextView tv_delete = row.findViewById(R.id.tv_delete);

        //3. gán dữ liệu

        Cat objCat = listCat.get( i );
        tv_id.setText( objCat.getId() + "");
        tv_name.setText( objCat.getName()) ;

        //4.trả về row

        return row;
    }
}
