package com.Kharido.postgresAPI.controller;

import com.Kharido.postgresAPI.services.impl.MerchantDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchantData/")
public class MerchantDataController {

    @Autowired
    MerchantDataServiceImpl merchantDataService;

    @RequestMapping(method = RequestMethod.GET, value = "product/add/{merchantId}/{product}")
    public ResponseEntity<Boolean> productAdd(@PathVariable("merchantId") String merchantId, @PathVariable("product") int product) {
        Boolean response = merchantDataService.addProduct(merchantId, product);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "product/decrease/{merchantId}/{product}")
    public ResponseEntity<Boolean> productDecrease(@PathVariable("merchantId") String merchantId, @PathVariable("product") int product) {
        Boolean response = merchantDataService.decreaseProduct(merchantId, product);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "stock/add/{merchantId}/{stock}")
    public ResponseEntity<Boolean> stockAdd(@PathVariable("merchantId") String merchantId, @PathVariable("stock") int stock) {
        Boolean response = merchantDataService.addStock(merchantId, stock);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "stock/decrease/{merchantId}/{stock}")
    public ResponseEntity<Boolean> stockDecrease(@PathVariable("merchantId") String merchantId, @PathVariable("stock") int stock) {
        Boolean response = merchantDataService.decreaseStock(merchantId, stock);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "sold/add/{merchantId}/{sold}")
    public ResponseEntity<Boolean> soldAdd(@PathVariable("merchantId") String merchantId, @PathVariable("sold") int sold) {
        Boolean response = merchantDataService.addSold(merchantId, sold);
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "ratingCount/{merchantId}")
    public ResponseEntity<Integer> getNumberOfRating(@PathVariable("merchantId") String merchantId) {
        int ratingCount = merchantDataService.getNumberOfRatings(merchantId);
        return new ResponseEntity<Integer>(ratingCount, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "rating/{merchantId}")
    public ResponseEntity<Double> getRating(@PathVariable("merchantId") String merchantId) {
        Double rating = merchantDataService.getRating(merchantId);
        return new ResponseEntity<Double>(rating, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "addReview/{merchantId}/{rating}")
    public ResponseEntity<Boolean> addReview(@PathVariable("merchantId") String merchantId, @PathVariable("rating") int rating) {
        Boolean checkSucess = merchantDataService.addReview(merchantId, rating);
        return new ResponseEntity<Boolean>(checkSucess, HttpStatus.OK);
    }



}
