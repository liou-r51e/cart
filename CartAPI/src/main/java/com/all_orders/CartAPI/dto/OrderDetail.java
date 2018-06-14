package com.all_orders.CartAPI.dto;

public class OrderDetail {

    private String sessionId;
    private String emailId;
    private int productId;
    private String merchantId;
    private int cost;
    private int quantity;
    private String status;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    @Override
    public String toString() {
        return "OrderDetail{" +
                "sessionId='" + sessionId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
