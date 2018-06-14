package com.nile.Nile_Product.service.impl;

import com.nile.Nile_Product.entity.ProductEntity;
import com.nile.Nile_Product.repository.ProductRepository;
import com.nile.Nile_Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       /*ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(8);
        productEntity.setProductName("Styleville.in Women's Striped Regular Fit Top");
        productEntity.setCategory("Women's Fashion");
        productEntity.setSubCategory("Sirts,Tops and Tees");

        List<Map> attrib = new ArrayList<Map>();
        Map<String, String> attribute = new HashMap<String, String>();
        attribute.put("Color", "Pink");
        attribute.put("Size", "Large");
        attribute.put("Type", "Long Sleeve and Round-Neck");
        //attribute.put("Color", "white");
        attribute.put("Materials", "100%Rayon");
        attrib.add(attribute);

        productEntity.setAttribute(attrib);
        productEntity.setDiscription("This is discription");


        List<String> img = new ArrayList<String>();
        img.add("Image 1");
        img.add("Image 2");
        img.add("Image 3");
        productEntity.setImages(img);*/


        return  productRepository.insert(productEntity);
    }


}