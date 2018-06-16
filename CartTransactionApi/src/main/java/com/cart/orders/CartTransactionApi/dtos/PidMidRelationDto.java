package com.cart.orders.CartTransactionApi.dtos;

public class PidMidRelationDto {

    private String pmId;
    private String merchantId;
    private int productId;
    private int cost;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PidMidRelationDto{" +
                "pmId='" + pmId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", productId=" + productId +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                '}';
    }
}
