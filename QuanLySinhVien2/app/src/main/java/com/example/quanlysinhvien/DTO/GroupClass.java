package com.example.quanlysinhvien.DTO;

public class GroupClass {
    int id_group;

    String ma_lop;
    String ten_lop;
    public static final String TB_NAME = "tb_class";
    public static final String COL_ID = "id_group";
    public static final String COL_MA_LOP = "ma_lop";
    public static final String COL_NAME_LOP = "ten_lop";

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getTen_lop() {
        return ten_lop;
    }

    public void setTen_lop(String ten_lop) {
        this.ten_lop = ten_lop;
    }

    public String getMa_lop() {
        return ma_lop;
    }

    public void setMa_lop(String ma_lop) {
        this.ma_lop = ma_lop;
    }
}
