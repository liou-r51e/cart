package com.Kharido.postgresAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = MerchantDetailsEntity.TABLE_NAME)

public class MerchantDetailsEntity {

    public static final String TABLE_NAME = "merchantDetails";
    private static final String ID_COLUMN = "merchantId";


    @Id
    @Column(name = MerchantDetailsEntity.ID_COLUMN)

    private String merchantId;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String storeAddress;
    private int stock;
    private int sold;
    private int numberProducts;
    private String rating;
    private int numberRatings;


    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }


    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return new Double(rating);
    }

    public void setRating(double rating) {
        this.rating = String.valueOf(rating);
    }

    public int getNumberRatings() {
        return numberRatings;
    }

    public void setNumberRatings(int numberRatings) {
        this.numberRatings = numberRatings;
    }

    @Override
    public String toString() {
        return "MerchantDetailsEntity{" +
                "merchantId='" + merchantId + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", stock=" + stock +
                ", sold=" + sold +
                ", numberProducts=" + numberProducts +
                ", rating='" + rating + '\'' +
                ", numberRatings=" + numberRatings +
                '}';
    }
}
