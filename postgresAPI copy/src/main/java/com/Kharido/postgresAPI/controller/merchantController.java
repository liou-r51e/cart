package com.Kharido.postgresAPI.controller;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.dto.MerchantLoginDetails;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.services.MerchantDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchantGateway")
public class merchantController {
    @Autowired
    MerchantDetailsService merchantDetailService;


    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<Boolean> addOrUpdateMerchant(@RequestBody MerchantDetail merchantDetail) {
        Boolean existingMerchant;
        existingMerchant = merchantDetailService.exists(merchantDetail.getMerchantId());
        if (existingMerchant == true) {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
        MerchantDetail merchantDetail1 = merchantDetailService.save(merchantDetail);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> checkMerchant(@RequestBody MerchantLoginDetails merchantLoginDetails) {
        String response = merchantDetailService.merchantLogin(merchantLoginDetails);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getMerchantDetails/{merchantId}")
    public ResponseEntity<MerchantDetailsEntity> getOneMerchant(@PathVariable("merchantId") String merchantId) {
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailService.getOneByMerchantId(merchantId);
        MerchantDetail merchantDetail = new MerchantDetail();
        BeanUtils.copyProperties(merchantDetailsEntity, merchantDetail);
        merchantDetailsEntity.setPassword("");
        return new ResponseEntity<MerchantDetailsEntity>(merchantDetailsEntity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getMerchantName/{merchantId}")
    public ResponseEntity<String> getOneMerchantName(@PathVariable("merchantId") String merchantId) {
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailService.getOneByMerchantId(merchantId);
        String merchantName = merchantDetailsEntity.getMerchantName();
        return new ResponseEntity<String>(merchantName, HttpStatus.OK);
    }

}
