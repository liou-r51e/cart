package com.all_orders.CartAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = OrderDetailEntity.TABLE_NAME)
    public class OrderDetailEntity {

        public static final String TABLE_NAME = "allOrdersDb";
        private static final String ID_COLUMN = "sessionId";


        @Id
        @Column(name = OrderDetailEntity.ID_COLUMN)

        private String sessionId;
        private String emailId;
        private int productId;
        private String merchantId;
        private double cost;
        private int quantity;
        private String status;

        @Override
        public String toString() {
            return "OrderDetailEntity{" +
                    "sessionId='" + sessionId + '\'' +
                    ", emailId='" + emailId + '\'' +
                    ", productId=" + productId +
                    ", merchantId='" + merchantId + '\'' +
                    ", cost=" + cost +
                    ", quantity=" + quantity +
                    ", status='" + status + '\'' +
                    '}';
        }

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getIdColumn() {
            return ID_COLUMN;
        }

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

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
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
    }


