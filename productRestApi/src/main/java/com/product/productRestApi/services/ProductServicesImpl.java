package com.product.productRestApi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productRestApi.entity.AllNames;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.httpSend.HttpURLConnectionExample;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductServicesImpl implements ProductServices{


    ObjectMapper objectMapper = new ObjectMapper();

    String IP = "http://localhost:8095/product/";

    AllNames allNames = new AllNames();


    JavaType listtype = objectMapper.getTypeFactory().constructCollectionType(List.class,ProductDetailEntity.class);



    @Override
    public List<String> getCategories() {
        //System.out.println(Arrays.asList(AllNames.categories));
        return Arrays.asList(allNames.categories);
    }

    @Override
    public List<String> getSubcategories(String category) {
        return Arrays.asList(allNames.subCategories.get(category));
    }

    @Override
    public List<ProductDetailEntity> getProducts(String name, int type) {
        if(type==0) {//get all products by category
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductsByCategory/"+ name);

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
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductsBySubCategory/"+name);

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
            responseURL = HttpURLConnectionExample.sendGet(IP+"getProductDetailsById/"+String.valueOf(productId));
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
