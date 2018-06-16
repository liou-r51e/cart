package com.cart.orders.CartTransactionApi.dtos;

public class OrderDetailsDto {
    private int sessionId;
    private String merchantId;
    private int productId;
    private int cost;
    private String emailId;
    private int quantity;
    private String status;
    private String additionalStatus;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdditionalStatus() {
        return additionalStatus;
    }

    public void setAdditionalStatus(String additionalStatus) {
        this.additionalStatus = additionalStatus;
    }

    @Override
    public String toString() {
        return "OrderDetailsDto{" +
                "sessionId=" + sessionId +
                ", merchantId='" + merchantId + '\'' +
                ", productId=" + productId +
                ", cost=" + cost +
                ", emailId='" + emailId + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", additionalStatus='" + additionalStatus + '\'' +
                '}';
    }
}
