package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MerchantLoginDetails {

    private String merchantId;
    private String password;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        final String hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        this.password = hashed;
    }

    @Override
    public String toString() {
        return "MerchantLoginDetails{" +
                "merchantId='" + merchantId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
