package com.product.productRestApi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productRestApi.entity.AllNames;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.httpSend.HttpURLConnectionExample;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductServicesImpl implements ProductServices{


    ObjectMapper objectMapper = new ObjectMapper();

    String IP = "http://10.177.7.77:8080/product/";

    Class<?> l;

    {
        try {
            l = Class.forName("com.product.productRestApi.entity.ProductDetailEntity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    JavaType listtype = objectMapper.getTypeFactory().constructCollectionType(List.class,ProductDetailEntity.class);



    @Override
    public List<String> getCategories() {
        return Arrays.asList(AllNames.categories);
    }

    @Override
    public List<String> getSubcategories(String category) {
        return Arrays.asList(AllNames.subCategories.get(category));
    }

    @Override
    public List<ProductDetailEntity> getProducts(String name, int type) {
        if(type==0) {//get all products by category
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductByCategory/"+ name);

                productDetailEntities = objectMapper.readValue(responseUrl,listtype);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return productDetailEntities;
        }
        else if(type==1) {//get all products by suCategory
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductBySubCategory/"+name);

                productDetailEntities = objectMapper.readValue(responseUrl,listtype);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return productDetailEntities;
        }

        return null;
    }

    @Override
    public ProductDetailEntity getProductDetails(int productId) {
        String responseURL=null;
        ProductDetailEntity responseObj=null;
        try {
            responseURL = HttpURLConnectionExample.sendGet(IP+"getProductById/"+String.valueOf(productId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            responseObj = objectMapper.readValue(responseURL,ProductDetailEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseObj;
    }

    @Override
    public List<ProductDetailEntity> getAllProducts() {
        //all  product
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getAll");

                productDetailEntities = objectMapper.readValue(responseUrl,listtype);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return productDetailEntities;

    }

    @Override
    public ProductDetailEntity addProduct(ProductDetailEntity productDetailEntity) {
        ProductDetailEntity productDetailEntitynew = null;
        String responseUrl = null;

        try {
            String urlParameters = objectMapper.writeValueAsString(productDetailEntity);
            responseUrl = HttpURLConnectionExample.sendPost(IP+"insert",urlParameters);
            productDetailEntitynew = objectMapper.readValue(responseUrl,listtype);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetailEntitynew;
    }

    @Override
    public boolean deleteByProductId(int productId) {
        try {
            HttpURLConnectionExample.sendGet(IP+"delete/"+String.valueOf(productId));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
