package com.example.quanlysinhvien.DTO;

public class SinhVien {
    int id_student;
    String name_student;
    String ngaysinh;
    String sodienthoai;
    int id_group;
    String ten_lop;



    public static  final  String TB_NAME_STUDENTS = "tb_student";
    public static  final  String COL_ID_STUDENTS = "id_student";
    public static  final  String COL_HO_TEN = "name_student";
    public static  final  String COL_DATE = "ngaysinh";
    public static  final  String COL_SO_DIEN_THOAI = "sodienthoai";
    public static  final  String COL_ID_GROUP = "id_group";
    public static  final  String COL_NAME_GROUP = "ten_lop";

    public String getTen_lop() {
        return ten_lop;
    }

    public void setTen_lop(String ten_lop) {
        this.ten_lop = ten_lop;
    }
    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }


}
