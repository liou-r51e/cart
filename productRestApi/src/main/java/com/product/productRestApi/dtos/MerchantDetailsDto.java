package com.product.productRestApi.dtos;

public class MerchantDetailsDto {

    // private  String userId;
    private  String merchantId;
    private  String fullName;
    private String phoneNumber;
    private String storeAddress;
    private int stock;
    private int sold;
    private int numberProducts;
    private double rating;
    private int numberRatings;



    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(int numberProducts) {
        this.numberProducts = numberProducts;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberRatings() {
        return numberRatings;
    }

    public void setNumberRatings(int numberRatings) {
        this.numberRatings = numberRatings;
    }

    @Override
    public String toString() {
        return "MerchantDetailsDto{" +
                "merchantId='" + merchantId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", stock=" + stock +
                ", sold=" + sold +
                ", numberProducts=" + numberProducts +
                ", rating=" + rating +
                ", numberRatings=" + numberRatings +
                '}';
    }
}
