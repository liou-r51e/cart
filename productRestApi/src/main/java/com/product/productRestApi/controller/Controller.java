package com.product.productRestApi.controller;


import com.product.productRestApi.dtos.ProductSummaryDto;
import com.product.productRestApi.entity.Categories;
import com.product.productRestApi.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ProductServices productServices;

    @RequestMapping("/product")
    public ResponseEntity<Categories[]> getCategories(){


        return new ResponseEntity<Categories[]>(productServices.getCategories(),HttpStatus.OK);
    }

    @RequestMapping("product/{category}")
    public ResponseEntity<Categories> getSubcategory(@PathVariable("category") String category){


        return new ResponseEntity<Categories>(productServices.getCategories(),HttpStatus.OK);
    }

    @RequestMapping("product/{category}/{subcategory}")
    public ResponseEntity<List<ProductSummaryDto>>


}
