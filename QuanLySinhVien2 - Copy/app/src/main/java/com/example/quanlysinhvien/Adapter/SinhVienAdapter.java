package com.example.quanlysinhvien.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.DTO.SinhVien;
import com.example.quanlysinhvien.R;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    final ArrayList<SinhVien> sinhVienArrayList;

    public SinhVienAdapter(ArrayList<SinhVien> sinhVienArrayList) {
        this.sinhVienArrayList = sinhVienArrayList;
    }

    @Override
    public int getCount() {
        return sinhVienArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        SinhVien  objSinhVien = sinhVienArrayList.get( i );
        return objSinhVien;
    }

    @Override
    public long getItemId(int i) {
        SinhVien  objSinhVien = sinhVienArrayList.get( i );
        return objSinhVien.getId_student();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.custom_list_danh_sach,null);
        }else{
            itemView = view;
        }
        final int index_sv = i;
//        final Spinner spinner_group = itemView.findViewById(R.id.tv_name_spiner);
        SinhVien sinhVien =  sinhVienArrayList.get( i );
        TextView tv_id_student = itemView.findViewById(R.id.tv_id_thong_tin);
//        TextView tv_spiner_list = itemView.findViewById(R.id.tv_name_spiner);
        TextView tv_name = itemView.findViewById(R.id.tv_name);
        TextView tv_ngaysinh = itemView.findViewById(R.id.tv_ngaysinh);
        TextView tv_sodienthoai = itemView.findViewById(R.id.tv_so_dien_thoai);
        TextView tv_spiner = itemView.findViewById(R.id.tv_spiner_listview);

        tv_id_student.setText(sinhVien.getId_student() + "");
        tv_spiner.setText(sinhVien.getTen_lop());
        tv_name.setText(sinhVien.getName_student());
        tv_ngaysinh.setText(sinhVien.getNgaysinh());
        tv_sodienthoai.setText(sinhVien.getSodienthoai());



        return itemView;
    }
}
