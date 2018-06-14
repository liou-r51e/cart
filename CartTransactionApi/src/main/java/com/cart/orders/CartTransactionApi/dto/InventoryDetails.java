package com.cart.orders.CartTransactionApi.dto;

public class InventoryDetails {

    private String pmId;
    private String merchantId;
    private int productId;
    private int cost;
    private int inventory;

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
    public String toString() {
        return "InventoryDetails{" +
                "pmId='" + pmId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", productId=" + productId +
                ", cost=" + cost +
                ", inventory=" + inventory +
                '}';
    }
}
