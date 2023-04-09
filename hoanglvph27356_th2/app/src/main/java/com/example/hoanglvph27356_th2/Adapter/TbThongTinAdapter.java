package com.example.hoanglvph27356_th2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hoanglvph27356_th2.DTO.TbThongTin;
import com.example.hoanglvph27356_th2.R;

import java.util.ArrayList;

public class TbThongTinAdapter extends BaseAdapter {
    final ArrayList<TbThongTin> tbThongTinArrayList;

    public TbThongTinAdapter(ArrayList<TbThongTin> tbThongTinArrayList) {
        this.tbThongTinArrayList = tbThongTinArrayList;
    }

    @Override
    public int getCount() {
        return tbThongTinArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return tbThongTinArrayList.get( i );
    }

    @Override
    public long getItemId(int i) {
        return tbThongTinArrayList.get( i ).getId_canhan();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;

        if (view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.custom_list_item_thongtin,null);
        }else{
            itemView = view;
        }
        TbThongTin tbThongTin = tbThongTinArrayList.get( i );
        TextView tv_id_thongtin = itemView.findViewById(R.id.tv_id_thongtin);
        TextView tv_id_ho_ten = itemView.findViewById(R.id.tv_ho_ten);
        TextView tv_id_so_dien_thoai = itemView.findViewById(R.id.tv_so_dien_thoai);
        TextView tv_id_note = itemView.findViewById(R.id.tv_note);

        tv_id_thongtin.setText( tbThongTin.getId_canhan() + "");
        tv_id_ho_ten.setText( tbThongTin.getHo_ten());
        tv_id_so_dien_thoai.setText( tbThongTin.getSo_dien_thoai());
        tv_id_note.setText( tbThongTin.getNote());


        return itemView;
    }
}
