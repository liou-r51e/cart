package com.Kharido.postgresAPI.controller;

import com.Kharido.postgresAPI.dto.MerchantDetail;
import com.Kharido.postgresAPI.dto.MerchantLoginDetails;
import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.services.impl.MerchantDetailServiceImpl;
import com.Kharido.postgresAPI.services.impl.UserDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login_Signup")
public class UserDetailController {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    MerchantDetailServiceImpl merchantDetailService;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<Boolean> addOrUpdateUser(@RequestBody UserDetail userDetail) {
        System.out.println(userDetail);

        Boolean bool;
        bool = userDetailService.exists(userDetail.getEmailId());
        if (bool == true) {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);

        }
        UserDetail userDetail1 = userDetailService.save(userDetail);
        bool = userDetail.getFullName().equals(userDetail1.getFullName());

        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/check")
    public ResponseEntity<Boolean> checkUser(@RequestBody UserLoginDetails userLoginDetails) {
        System.out.println("Inside checkUser, userName: " + userLoginDetails.getEmailId() + ", password: " + userLoginDetails.getPassword());
        UserDetailsEntity userLoginDetailEntity = userDetailService.getOneByEmailId(userLoginDetails.getEmailId());
        if (userLoginDetailEntity == null) {
            System.out.println("User Not Found !");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        boolean result = userLoginDetailEntity.getPassword().equals(userLoginDetails.getPassword());
        System.out.println("Password Matched: " + result);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserDetails/{emailId}")
    public ResponseEntity<UserDetailsEntity> getOneUser(@PathVariable("emailId") String emailId) {
        UserDetailsEntity userDetailsEntity = userDetailService.getOneByEmailId(emailId);
        UserDetail userDetail = new UserDetail();
//
//            if (userDetailsEntity.get() == null) {
//                return new ResponseEntity<UserDetailsEntity>("", HttpStatus.OK);
//            }
        BeanUtils.copyProperties(userDetailsEntity, userDetail);
        userDetailsEntity.setPassword("");
        return new ResponseEntity<UserDetailsEntity>(userDetailsEntity, HttpStatus.OK);
    }

    //!!----MERCHANT CONTROLLERS---------!!

    @RequestMapping(method = RequestMethod.POST, value = "/addMerchant")
    public ResponseEntity<Boolean> addOrUpdateMerchant(@RequestBody MerchantDetail merchantDetail) {
        System.out.println(merchantDetail);

        Boolean bool;
        bool = merchantDetailService.exists(merchantDetail.getEmailId());
        if (bool == true) {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);

        }
        MerchantDetail merchantDetail1 = merchantDetailService.save(merchantDetail);
        bool = merchantDetail.getFullName().equals(merchantDetail1.getFullName());

        return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkMerchant")
    public ResponseEntity<Boolean> checkMerchant(@RequestBody MerchantLoginDetails merchantLoginDetails) {
        System.out.println("Inside checkUser, userName: " + merchantLoginDetails.getEmailId() + ", password: " + merchantLoginDetails.getPassword());
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailService.getOneByEmailId(merchantLoginDetails.getEmailId());
        if (merchantDetailsEntity == null) {
            System.out.println("User Not Found !");
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        boolean result = merchantDetailsEntity.getPassword().equals(merchantLoginDetails.getPassword());
        System.out.println("Password Matched: " + result);
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getMerchantDetails/{emailId}")
    public ResponseEntity<MerchantDetailsEntity> getOneMerchant(@PathVariable("emailId") String emailId) {
        MerchantDetailsEntity merchantDetailsEntity = merchantDetailService.getOneByEmailId(emailId);
        MerchantDetail merchantDetail = new MerchantDetail();
//
//            if (userDetailsEntity.get() == null) {
//                return new ResponseEntity<UserDetailsEntity>("", HttpStatus.OK);
//            }
        BeanUtils.copyProperties(merchantDetailsEntity, merchantDetail);
        merchantDetailsEntity.setPassword("");
        return new ResponseEntity<MerchantDetailsEntity>(merchantDetailsEntity, HttpStatus.OK);
    }



}
