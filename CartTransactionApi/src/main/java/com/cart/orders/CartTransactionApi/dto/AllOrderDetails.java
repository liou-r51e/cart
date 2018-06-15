package com.cart.orders.CartTransactionApi.dto;

public class AllOrderDetails {
    private String sessionId;
    private String merchantId;
    private String productId;
    private String cost;
    private String emailId;
    private String quantity;
    private String status;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AllOrderDetails{" +
                "sessionId='" + sessionId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", productId='" + productId + '\'' +
                ", cost='" + cost + '\'' +
                ", emailId='" + emailId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
