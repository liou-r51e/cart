package com.ayu.Product.service.impl;

import com.ayu.Product.controller.HttpURLConnectionE;
import com.ayu.Product.dto.ProductSolr;
import com.ayu.Product.repository.ProductRepository;
import com.ayu.Product.entity.ProductEntity;
import com.ayu.Product.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ObjectMapper objectMapper = new ObjectMapper();

    String IP = "localhost:8983/solr/techproducts/update/json";


    JavaType listtype = objectMapper.getTypeFactory().constructCollectionType(List.class,ProductEntity.class);

    @Autowired
    ProductRepository productRepository;
    static int count = 0;

    private int getCount(){
        if(count==0){
            count = productRepository.findAll ().size ();
        }
        return count;
    }


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

       // List<ProductEntity> productDTOS = productRepository.findAll ();
        productEntity.setProductId (getCount () +1);
        count++;
        ProductEntity productEntity1 = productRepository.insert(productEntity);
    /*   String responseUrl = null;
        try {

            ProductSolr productSolr = new ProductSolr ();
            productSolr.setId ( String.valueOf (productEntity1.getProductId (  ) ));
            productSolr.setProductId ( productEntity1.getProductId () );
            productSolr.setImages ( productEntity1.getImages ());
            productSolr.setCategory ( productEntity1.getCategory () );
            productSolr.setSubCategory (productEntity1.getSubCategory ());
            productSolr.setDiscription ( productEntity1.getDiscription () );
            productSolr.setProductName ( productEntity1.getProductName () );

            String postString = objectMapper.writeValueAsString ( productSolr );
            responseUrl = HttpURLConnectionE.sendPost ( IP,"["+postString+"]" );
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        }*/
        return  productEntity1;
    }

    @Override
    public void deleteAll(){
        productRepository.deleteAll();
    }

    @Override
    public List<ProductEntity> insertAll(List<ProductEntity> productEntities) {
        List<ProductEntity> productEntitiesNew = new ArrayList<> (  );
        for (ProductEntity productEntity:productEntities) {
            productEntitiesNew.add(insert ( productEntity ));

        }
        return productEntitiesNew;
    }


}