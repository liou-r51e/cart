package com.ayu.Product.repository;

import com.ayu.Product.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity , String> {

    public List<ProductEntity> findByCategory(String category);
    public List<ProductEntity> findBySubCategory(String subCategory);
    public ProductEntity findByProductId(int productId);
    public void deleteByProductId(int productId);
    public List<ProductEntity> findProductsByProductName(String productName);
}
