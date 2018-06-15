package com.product.productRestApi.services;

import com.product.productRestApi.entity.ProductDetailEntity;

import java.util.List;

public interface ProductServices {

    public List<String> getCategories();
    public List<String> getSubcategories(String category);
    public List<ProductDetailEntity> getProducts(String name,int type);
    public ProductDetailEntity getProductDetails(int productId);
    public List<ProductDetailEntity> getAllProducts();
    public ProductDetailEntity addProduct(ProductDetailEntity productDetailEntity);
    public boolean deleteByProductId(int productId);


}
