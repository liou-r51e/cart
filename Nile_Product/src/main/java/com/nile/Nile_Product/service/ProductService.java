package com.nile.Nile_Product.service;


import com.nile.Nile_Product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> findAll();
    public List<ProductEntity> findByCategory(String category);
    public List<ProductEntity> findBySubCategory(String subCategory);
    public List<ProductEntity> findProductsByProductName(String productName);
    public ProductEntity findByProductId(int productId);
    public void delete(int productId);
    public ProductEntity insert(ProductEntity productEntity);
   // public ProductEntity insertOrUpdate(ProductEntity productEntity);
}
