package com.example.quanlysinhvien.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.quanlysinhvien.DAO.GroupClassDAO;
import com.example.quanlysinhvien.DTO.GroupClass;
import com.example.quanlysinhvien.R;

import java.util.ArrayList;

public class GroupClassAdapter extends BaseAdapter {
    ArrayList<GroupClass> listGroupClass;
    GroupClassDAO groupClassDAO;
    ListView listViewLop;

    public GroupClassAdapter(ArrayList<GroupClass> listGroupClass, GroupClassDAO groupClassDAO) {
        this.listGroupClass = listGroupClass;
        this.groupClassDAO = groupClassDAO;
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
        GroupClass objGroup = listGroupClass.get( i );
        return objGroup.getId_group();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        if(view == null){
            itemView = View.inflate( viewGroup.getContext(), R.layout.custom_quan_ly_class,null);

        }else{
            itemView = view;
        }
        final GroupClass objGroup  = listGroupClass.get(i);
        final int _index = i;

        TextView tv_id = itemView.findViewById(R.id.tv_id_class);
        TextView tv_ma_class = itemView.findViewById(R.id.tv_id_ma_lop);
        TextView tv_name_class = itemView.findViewById(R.id.tv_ten_lop);
        TextView tv_del = itemView.findViewById(R.id.tv_del);


        tv_id.setText( objGroup.getId_group() + "");
        tv_ma_class.setText( objGroup.getMa_lop() );
        tv_name_class.setText(objGroup.getTen_lop());


        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(viewGroup.getContext());
                builder.setTitle("Xóa lớp?");
                builder.setMessage("Có chắc chắn muốn xóa nhóm : " + objGroup.getTen_lop());
                builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int kq = groupClassDAO.deleteRow(objGroup);
                        if(kq>0){
                            listGroupClass.remove(_index);
                            notifyDataSetChanged();
                            Toast.makeText(viewGroup.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(viewGroup.getContext(), "Không xóa được", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); // đóng dialog
                    }
                });



                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });



        return itemView;
    }
}
