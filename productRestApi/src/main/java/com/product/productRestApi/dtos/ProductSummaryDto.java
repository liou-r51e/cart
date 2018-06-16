package com.product.productRestApi.dtos;

import java.util.List;

public class ProductSummaryDto {

    private int productId;
    private String productName;
    private List<String> images;
    private MerchantDetailsDto merchantDetailsDto;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public MerchantDetailsDto getMerchantDetailsDto() {
        return merchantDetailsDto;
    }

    public void setMerchantDetailsDto(MerchantDetailsDto merchantDetailsDto) {
        this.merchantDetailsDto = merchantDetailsDto;
    }

    @Override
    public String toString() {
        return "ProductSummaryDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", images=" + images +
                ", merchantDetailsDto=" + merchantDetailsDto +
                '}';
    }
}
