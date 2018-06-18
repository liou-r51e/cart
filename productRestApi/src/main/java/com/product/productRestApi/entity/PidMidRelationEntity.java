package com.product.productRestApi.entity;

import java.util.Objects;

public class PidMidRelationEntity {

    private String pmId;
    private int productId;
    private String merchantId;
    private int cost;
    private int inventory;



    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PidMidRelationEntity that = (PidMidRelationEntity) o;
        return productId == that.productId &&
                cost == that.cost &&
                inventory == that.inventory &&
                Objects.equals(merchantId, that.merchantId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, merchantId, cost, inventory);
    }
}