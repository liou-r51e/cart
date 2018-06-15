package com.product.productRestApi.services;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.httpSend.HttpURLConnectionExample;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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
    public Categories[] getCategories() {
        //List<Categories> lc = Categories.values();
        return null;
    }

    @Override
    public List<ProductDetailEntity> getProducts() {
        return null;
    }

    @Override
    public List<ProductDetailEntity> getProducts(Categories categories) {
        return null;
    }

    @Override
    public List<ProductDetailEntity> getProducts(String subcategory, int type) {
        if(type==0) {//category
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductByCategory/"+subcategory);

                productDetailEntities = objectMapper.readValue(responseUrl,listtype);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return productDetailEntities;
        }
        else if(type==1) {//category
            List<ProductDetailEntity> productDetailEntities=null;
            String responseUrl = null;
            try {
                responseUrl = HttpURLConnectionExample.sendGet(IP+"getProductBySubCategory/"+subcategory);

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
}
