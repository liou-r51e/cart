package com.ayu.Product.service;


import com.ayu.Product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> findAll();
    public List<ProductEntity> findByCategory(String category);
    public List<ProductEntity> findBySubCategory(String subCategory);
    public List<ProductEntity> findProductsByProductName(String productName);
    public ProductEntity findByProductId(int productId);
    public void delete(int productId);
    public ProductEntity insert(ProductEntity productEntity);
    public void deleteAll();

}
