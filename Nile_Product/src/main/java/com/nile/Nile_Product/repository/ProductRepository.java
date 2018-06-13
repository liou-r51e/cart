package com.nile.Nile_Product.repository;

import com.nile.Nile_Product.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity , String> {

    public List<ProductEntity> findByCategory(String category);
    public ProductEntity findByProductId(String productId);
    public ProductEntity deleteById();
}
