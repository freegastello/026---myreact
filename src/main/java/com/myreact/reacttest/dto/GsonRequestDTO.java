package com.myreact.reacttest.dto;

public class GsonRequestDTO {
    private String id_product;
    private String qty_product;

    public GsonRequestDTO() {
    }

    public GsonRequestDTO(String id_product, String qty_product) {
        this.id_product = id_product;
        this.qty_product = qty_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public void setQty_product(String qty_product) {
        this.qty_product = qty_product;
    }

    public String getId_product() {
        return id_product;
    }

    public String getQty_product() {
        return qty_product;
    }

    @Override
    public String toString() {
        return "GsonRequestDTO{" +
                "id_product='" + id_product + '\'' +
                ", qty_product='" + qty_product + '\'' +
                '}';
    }
}
