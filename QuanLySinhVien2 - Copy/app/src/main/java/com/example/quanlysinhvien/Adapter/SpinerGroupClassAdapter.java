package com.example.quanlysinhvien.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.R;

import java.util.ArrayList;

public class SpinerGroupClassAdapter extends BaseAdapter {
    ArrayList<GroupClass> listGroupClass;

    public SpinerGroupClassAdapter(ArrayList<GroupClass> listGroupClass) {
        this.listGroupClass = listGroupClass;
    }

    @Override
    public int getCount() {
        return listGroupClass.size();
    }

    @Override
    public Object getItem(int i) {
        GroupClass objGroup = listGroupClass.get( i );
        return objGroup;
    }

    @Override
    public long getItemId(int i) {
        GroupClass objGroup = listGroupClass.get(i);
        return objGroup.getId_group();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate( viewGroup.getContext(), R.layout.custom_list_spinner,null);
        }else{
            itemView = view;
        }

        GroupClass objGroup = listGroupClass.get( i );
        final  int _index = i;
        TextView tv_id_spiner = itemView.findViewById(R.id.tv_id_spiner);
        TextView tv_name_spiner = itemView.findViewById(R.id.tv_name_spiner);

        tv_id_spiner.setText( objGroup.getId_group() + "");
        tv_name_spiner.setText(objGroup.getTen_lop());

        return itemView;
    }
}
