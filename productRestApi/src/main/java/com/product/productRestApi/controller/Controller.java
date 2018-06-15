package com.product.productRestApi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.services.ProductServices;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    ProductServices productServices;

    @RequestMapping("/product")
    public ResponseEntity<Categories[]> getCategories(){


        return new ResponseEntity<Categories[]>(productServices.getCategories(),HttpStatus.OK);
    }
/*
    @RequestMapping("product/{category}")
    public ResponseEntity<Categories> getSubcategory(@PathVariable("category") String category){


        return new ResponseEntity<Categories>(productServices.getCategories(),HttpStatus.OK);
    }
*/
/*
    @RequestMapping("product/{category}/{subcategory}")
    public ResponseEntity<String> getSubCategoryList(@PathVariable("category") String category,@PathVariable("subcategory") String subcategory){
        return new ResponseEntity<String>(productServices.getProducts("sd",1),HttpStatus.OK);

    }
*/

    @RequestMapping("/details/{productId}")
    public ResponseEntity<ProductDetailsDto> getDetails(@PathVariable("productId") int productId){
        ProductDetailEntity productDetailEntity = productServices.getProductDetails(productId);
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        BeanUtils.copyProperties(productDetailEntity,productDetailsDto);
        return new ResponseEntity<ProductDetailsDto>(productDetailsDto,HttpStatus.OK);
    }

    @RequestMapping("/getAll")
    public ResponseEntity<List<ProductSummaryDto>> getAll(){
        List<ProductDetailEntity> productDetailEntities = productServices.getAllProducts();
        List<ProductSummaryDto> productSummaryDtos=null;
        for (ProductDetailEntity i:productDetailEntities) {
            ProductSummaryDto j = new ProductSummaryDto();
            BeanUtils.copyProperties(i,j);
            productSummaryDtos.add(j);
        }
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos,HttpStatus.OK);
    }

/*
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ProductDetailEntity n = new ProductDetailEntity();
            System.out.println(objectMapper.writeValueAsString(n));
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class,ProductDetailEntity.class);
            ProductDetailEntity n1 = objectMapper.readValue(objectMapper.writeValueAsString(n),type);
            System.out.println(n1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

}
