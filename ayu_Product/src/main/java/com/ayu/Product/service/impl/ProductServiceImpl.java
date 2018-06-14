package com.ayu.Product.service.impl;

import com.ayu.Product.repository.ProductRepository;
import com.ayu.Product.entity.ProductEntity;
import com.ayu.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAll() {
        return  productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<ProductEntity> findBySubCategory(String subCategory) {
        return productRepository.findBySubCategory(subCategory);
    }

    @Override
    public List<ProductEntity> findProductsByProductName(String productName) {
        return productRepository.findProductsByProductName(productName);
    }

    @Override
    public ProductEntity findByProductId(int productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public void delete(int productId) {
        productRepository.deleteByProductId (productId);
    }

    @Override
    public ProductEntity insert(ProductEntity productEntity) {

        return  productRepository.insert(productEntity);
    }


}