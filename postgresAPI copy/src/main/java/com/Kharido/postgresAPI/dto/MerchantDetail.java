package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MerchantDetail {

    private String merchantId;
    private String merchantName;
    private String password;
    private String phoneNumber;
    private String storeAddress;
    private String address;
    private int stock;
    private int sold;
    private int numberProducts;
    private String rating;
    private int numberRatings;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        final String hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        this.password = password;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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
                ", merchantName='" + merchantName + '\'' +
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
