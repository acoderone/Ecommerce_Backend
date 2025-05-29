package com.Ecommerce.Ecommerce.dto;

public class ProductResponseDTO {

    private String item_name;
    private String description;
    private Integer price;
    private String category;
    private Integer quantity;

    public ProductResponseDTO(String item_name, String description, Integer price, String category, Integer quantity) {

        this.item_name = item_name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public ProductResponseDTO() {

    }



    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
