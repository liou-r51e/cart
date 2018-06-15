package com.product.productRestApi.services;

import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;
import com.product.productRestApi.entity.ProductDetailEntity;

import java.util.List;

public interface ProductServices {

    public Categories[] getCategories();
    public List<ProductDetailEntity> getProducts();
    public List<ProductDetailEntity> getProducts(Categories categories);
    public List<ProductDetailEntity> getProducts(String subcategory,int type);
    public ProductDetailEntity getProductDetails(int productId);
    public List<ProductDetailEntity> getAllProducts();


}
