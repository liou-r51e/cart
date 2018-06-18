package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MerchantDetail {


    // private  String userId;
    private  String merchantId;
    private  String fullName;
    private  String password;
    private String phoneNumber;
    private String storeAddress;
    private  String address;
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

    public String getPassword() {final String hashed = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString();

        return hashed;
    }

    public void setPassword(String password) {final String hashed = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString();

        this.password=password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "MerchantDetail{" +
                "merchantId='" + merchantId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", address='" + address + '\'' +
                ", stock=" + stock +
                ", sold=" + sold +
                ", numberProducts=" + numberProducts +
                ", rating=" + rating +
                ", numberRatings=" + numberRatings +
                '}';
    }
}
