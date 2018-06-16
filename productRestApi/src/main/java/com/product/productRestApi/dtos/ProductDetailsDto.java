package com.product.productRestApi.dtos;

import java.util.List;
import java.util.Map;

public class ProductDetailsDto {

    private int productId;
    private String productName;
    private String category;
    private String subCategory;
    private String discription;
    private List<Map> attribute;
    private List<String> images;
    private List<MerchantDetailsDto> merchantDetailsDtos;



}
