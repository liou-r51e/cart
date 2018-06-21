package com.ayu.Product.controller;

import com.ayu.Product.dto.ProductDTO;
import com.ayu.Product.entity.ProductEntity;
import com.ayu.Product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController  {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByCategory/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable("category") String category){

        List<ProductEntity> productEntityList = productService.findByCategory(category);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        }
        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getProductsBySubCategory/{subCategory}")
    public ResponseEntity<List<ProductDTO>> getProductsBySubCategory(@PathVariable("subCategory") String subCategory){

        List<ProductEntity> productEntityList = productService.findBySubCategory(subCategory);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        }
        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getProductsByProductName/{productname}")
    public ResponseEntity<List<ProductDTO>> getProductsByProductName(@PathVariable("productname") String productName){

        List<ProductEntity> productEntityList = productService.findProductsByProductName (productName);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        }
        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getProductDetailsById/{productId}")
    public ResponseEntity<?> getProductDetailsById(@PathVariable("productId") int productId){
        ProductEntity productEntity = productService.findByProductId(productId);
        if(productEntity == null){
            return new ResponseEntity<String>("No data found", HttpStatus.OK);
        }
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productEntity, productDTO);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ResponseEntity<List<ProductDTO>> getAll(){

        List<ProductEntity> productEntityList = productService.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            productDTOS.add(productDTO);
        }
        return new ResponseEntity<List<ProductDTO>>(productDTOS, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{productId}")
    public ResponseEntity<Boolean>  delete(@PathVariable("productId") int productId){

        productService.delete(productId);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO){

        ProductEntity productEntity = new ProductEntity ();
        BeanUtils.copyProperties(productDTO, productEntity);
        productEntity = productService.insert (productEntity);
        BeanUtils.copyProperties ( productEntity,productDTO );
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertAll")
    public ResponseEntity<List<ProductDTO>> insertAll(@RequestBody List<ProductDTO> productDTOs){
        List<ProductDTO> productDTOsNew = new ArrayList<>();
        for (ProductDTO i:productDTOs) {
            ProductDTO j = new ProductDTO();
            ProductEntity productEntity = new ProductEntity ();
            BeanUtils.copyProperties(i, productEntity);
            productEntity = productService.insert (productEntity);
            BeanUtils.copyProperties ( productEntity,j );
            productDTOsNew.add(j);
        }
        return new ResponseEntity<>(productDTOsNew, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET,value="/deleteAll")
    public ResponseEntity<Boolean> deleteAll(){
        productService.deleteAll();
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
