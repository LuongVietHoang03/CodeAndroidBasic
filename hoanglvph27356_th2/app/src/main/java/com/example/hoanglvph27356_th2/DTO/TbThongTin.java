package com.example.hoanglvph27356_th2.DTO;

public class TbThongTin {
    int id_canhan;
    String ho_ten;
    String so_dien_thoai;
    String note;


    public static final String TB_NAME = "tb_thongtin";
    public static final String COL_NAME_ID = "id_canhan";
    public static final String COL_NAME_HO_TEN = "ho_ten";
    public static final String COL_NAME_SO_DIEN_THOAI = "so_dien_thoai";
    public static final String COL_NAME_NOTE = "note";


    public TbThongTin() {
    }

    public int getId_canhan() {
        return id_canhan;
    }

    public void setId_canhan(int id_canhan) {
        this.id_canhan = id_canhan;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
