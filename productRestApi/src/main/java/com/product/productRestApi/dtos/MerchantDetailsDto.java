package com.product.productRestApi.dtos;

public class MerchantDetailsDto {

    // private  String userId;
    private  String merchantId;
    private  String fullName;
    private String phoneNumber;
    private String storeAddress;



    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    @Override
    public String toString() {
        return "MerchantDetailsDto{" +
                "merchantId='" + merchantId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                '}';
    }
}
