package com.product.productRestApi.controller;


import com.product.productRestApi.dtos.ProductDetailsDto;
import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.ProductDetailEntity;
import com.product.productRestApi.services.ProductServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServices productServices;

    @RequestMapping("/categories")
    public ResponseEntity<List<String>> getCategories(){
        List<String> categories = productServices.getCategories();
        return new ResponseEntity<List<String>>(categories,HttpStatus.OK);
    }



    @RequestMapping("categories/{category}")
    public ResponseEntity<List<String>> getSubcategories(@PathVariable("category") String category){
        List<String> subCategories = productServices.getSubcategories(category);
        return new ResponseEntity<List<String>>(subCategories,HttpStatus.OK);
    }

    @RequestMapping("product/{category}")
    public ResponseEntity<List<ProductSummaryDto>> getProductsByCategory(@PathVariable("category") String category){
        List<ProductSummaryDto> productSummaryDtos = new ArrayList<>();
        List<ProductDetailEntity> productDetailEntities = productServices.getProducts(category,0);
        for (ProductDetailEntity productDetailEntity:productDetailEntities) {
            ProductSummaryDto productSummaryDto = new ProductSummaryDto();
            BeanUtils.copyProperties(productDetailEntity,productSummaryDto);
            productSummaryDtos.add(productSummaryDto);
        }
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos,HttpStatus.OK);
    }

    @RequestMapping("product/{category}/{subcategory}")
    public ResponseEntity<List<ProductSummaryDto>> getSubcategory(@PathVariable("category") String category,@PathVariable("subcategory") String subcategory){
        List<ProductSummaryDto> productSummaryDtos = new ArrayList<>();
        List<ProductDetailEntity> productDetailEntities = productServices.getProducts(subcategory,1);
        for (ProductDetailEntity productDetailEntity:productDetailEntities) {
            ProductSummaryDto productSummaryDto = new ProductSummaryDto();
            BeanUtils.copyProperties(productDetailEntity,productSummaryDto);
            productSummaryDtos.add(productSummaryDto);
        }
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos,HttpStatus.OK);
    }

/*
    @RequestMapping("product/{category}/{subcategory}")
    public ResponseEntity<String> getSubCategoryList(@PathVariable("category") String category,@PathVariable("subcategory") String subcategory){
        return new ResponseEntity<String>(productServices.getProducts("sd",1),HttpStatus.OK);

    }
*/

    @RequestMapping("/product/details/{productId}")
    public ResponseEntity<ProductDetailsDto> getDetails(@PathVariable("productId") int productId){
        ProductDetailEntity productDetailEntity = productServices.getProductDetails(productId);
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        BeanUtils.copyProperties(productDetailEntity,productDetailsDto);
        return new ResponseEntity<ProductDetailsDto>(productDetailsDto,HttpStatus.OK);
    }

    @RequestMapping("/product/getAll")
    public ResponseEntity<List<ProductSummaryDto>> getAll(){
        List<ProductDetailEntity> productDetailEntities = productServices.getAllProducts();
        List<ProductSummaryDto> productSummaryDtos= new ArrayList<>();
        for (ProductDetailEntity i:productDetailEntities) {
            ProductSummaryDto j = new ProductSummaryDto();
            BeanUtils.copyProperties(i,j);
            productSummaryDtos.add(j);
            //System.out.println(productSummaryDtos);
        }
        return new ResponseEntity<List<ProductSummaryDto>>(productSummaryDtos,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insert")
    public ResponseEntity<ProductDetailsDto> addProduct(@RequestBody ProductDetailsDto productDetailsDto){
        ProductDetailEntity productDetailEntity = null;
        ProductDetailsDto productDetailsDtoNew = null;

        BeanUtils.copyProperties(productDetailsDto,productDetailEntity);
        productDetailEntity = productServices.addProduct(productDetailEntity);
        BeanUtils.copyProperties(productDetailEntity,productDetailsDtoNew);
        return new ResponseEntity<>(productDetailsDtoNew,HttpStatus.OK);
    }

    @RequestMapping("/delete/{productId}")
    public ResponseEntity<Boolean> deleteByProductId(@PathVariable("productId") int productId){
        return new ResponseEntity<>(productServices.deleteByProductId(productId),HttpStatus.OK);
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
