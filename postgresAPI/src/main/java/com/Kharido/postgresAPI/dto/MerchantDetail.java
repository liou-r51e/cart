package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MerchantDetail {


    // private  String userId;
    private  String emailId;
    private  String fullName;
    private  String password;
    private String phoneNumber;
    private String storeAddress;
    private  String address;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {final String hashed = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString();

        return hashed;
    }

    public void setPassword(String password) {final String hashed = Hashing.sha256()
            .hashString(password, StandardCharsets.UTF_8)
            .toString();

        this.password=password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MerchantDetail{" +
                "emailId='" + emailId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
