package com.Kharido.postgresAPI.controller;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.services.impl.UserDetailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userGateway")
public class UserDetailController {
    private int otp;
    UserDetail userDetail;

    @Autowired
    UserDetailServiceImpl userDetailService;


    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<Boolean> addOrUpdateUser(@RequestBody UserDetail userDetail) {
        Boolean existingUser;
        existingUser = userDetailService.exists(userDetail.getEmailId());
        if (existingUser == true) {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
        otp = userDetailService.emailValidation(userDetail.getEmailId());
        System.out.println(otp);
        this.userDetail = userDetail;
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register/otp/{number}")
    public ResponseEntity<Boolean> OTP(@PathVariable("number") String number) {

        if (Integer.parseInt(number) == this.otp) {
            UserDetail userDetail1 = userDetailService.save(this.userDetail);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> checkUser(@RequestBody UserLoginDetails userLoginDetails) {
        //Todo : Phani : remove system.out.println, user logger instead
        System.out.println("Inside checkUser, userName: " + userLoginDetails.getEmailId() + ", password: " + userLoginDetails.getPassword());
        //Todo : Phani : should not pass entity to controller in this case!!
        String response = userDetailService.userLogin(userLoginDetails);
        //   System.out.println(response);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserDetails/{emailId}")
    public ResponseEntity<UserDetailsEntity> getOneUser(@PathVariable("emailId") String emailId) {
        UserDetailsEntity userDetailsEntity = userDetailService.getOneByEmailId(emailId);
        UserDetail userDetail = new UserDetail();
        BeanUtils.copyProperties(userDetailsEntity, userDetail);
        userDetailsEntity.setPassword("");
        return new ResponseEntity<UserDetailsEntity>(userDetailsEntity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserName/{emailId}")
    public ResponseEntity<String> getOneMerchantName(@PathVariable("emailId") String emailId) {
        UserDetailsEntity userDetailsEntity = userDetailService.getOneByEmailId(emailId);
        String userName = userDetailsEntity.getFullName();
        return new ResponseEntity<String>(userName, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/updateAddress/{emailId}/{address}")
    public ResponseEntity<Boolean> updateUser(@PathVariable("emailId") String emailId, @PathVariable("emailId") String address) {
        Boolean addressChange = userDetailService.updateAddress(emailId, address);
        return new ResponseEntity<Boolean>(addressChange, HttpStatus.OK);
    }

}
