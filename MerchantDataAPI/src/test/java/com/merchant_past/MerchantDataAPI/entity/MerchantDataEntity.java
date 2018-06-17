package com.merchant_past.MerchantDataAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = MerchantDataEntity.TABLE_NAME)
public class MerchantDataEntity {
    public static final String TABLE_NAME = "merchantPast";
    private static final String ID_COLUMN = "merchantId";

    @Id
    @Column(name = MerchantDataEntity.ID_COLUMN)

    private String merchantId;
    private int stock;
    private int sold;
    private int numberProducts;
    private double rating;
    private int numberRatings;

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
        return "MerchantDataEntity{" +
                "merchantId='" + merchantId + '\'' +
                ", stock=" + stock +
                ", sold=" + sold +
                ", numberProducts=" + numberProducts +
                ", rating=" + rating +
                ", numberRatings=" + numberRatings +
                '}';
    }
}
