package com.product.productRestApi.entity;


import java.util.List;
import java.util.Map;

public class ProductDetailEntity {

    private String productId;
    private String productName;
    private String category;
    private String subCategory;
    private String discription;
    private List<Map> attribute;
    private List<String> images;

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Map> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Map> attribute) {
        this.attribute = attribute;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}