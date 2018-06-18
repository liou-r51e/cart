package com.merchant_past.MerchantDataAPI.controller;


import com.merchant_past.MerchantDataAPI.dto.MerchantData;
import com.merchant_past.MerchantDataAPI.entity.MerchantDataEntity;
import com.merchant_past.MerchantDataAPI.services.impl.MerchantDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchantData/")
public class MerchantDataController {

    @Autowired
    MerchantDataServiceImpl merchantDataService;

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<Boolean> addMerchantData(@RequestBody MerchantData merchantData) {
        MerchantData merchantData1 = merchantDataService.save(merchantData);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get/{merchantId}")
    public ResponseEntity<MerchantDataEntity> getMerchant(@PathVariable("merchantId") String merchantId) {
        MerchantDataEntity merchantData = merchantDataService.getOne(merchantId);
        return new ResponseEntity<MerchantDataEntity>(merchantData, HttpStatus.OK);
    }

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
}
