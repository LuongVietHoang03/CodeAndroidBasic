package com.example.hoanglvph27356_test01.DTO;

public class Product {
    int id_product;
    String name_product;
    String price_product;

    public static final String TB_NAME_PRODUCT = "tb_product";
    public static final String COL_ID_PRODCUT = "id_product";
    public static final String COL_NAME_PRODCUT = "name_product";
    public static final String COL_PRICE_PRODCUT = "price_product";


    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getPrice_product() {
        return price_product;
    }

    public void setPrice_product(String price_product) {
        this.price_product = price_product;
    }
}
