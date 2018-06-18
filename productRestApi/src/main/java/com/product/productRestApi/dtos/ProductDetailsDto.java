package com.product.productRestApi.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDetailsDto {

    private int productId;
    private String productName;
    private String category;
    private String subCategory;
    private String discription;
    private List<Map> attribute;
    private List<String> images;
    private List<Integer> cost = new ArrayList<>();
    private List<MerchantDetailsDto> merchantDetailsDtos;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
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

    public List<MerchantDetailsDto> getMerchantDetailsDtos() {
        return merchantDetailsDtos;
    }

    public void setMerchantDetailsDtos(List<MerchantDetailsDto> merchantDetailsDtos) {
        this.merchantDetailsDtos = merchantDetailsDtos;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ProductDetailsDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", discription='" + discription + '\'' +
                ", attribute=" + attribute +
                ", images=" + images +
                ", cost=" + cost +
                ", merchantDetailsDtos=" + merchantDetailsDtos +
                '}';
    }
}
