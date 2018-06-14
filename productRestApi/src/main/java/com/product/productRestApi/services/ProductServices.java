package com.product.productRestApi.services;

import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;

import java.util.List;

public interface ProductServices {

    public Categories[] getCategories();
    public List<ProductSummaryDto> getProducts();
    public List<ProductSummaryDto> getProducts(Categories categories);
    public List<ProductSummaryDto> getProducts(String subcategory);
    public ProductDetailsDto getProductDetails(int productId);


}
