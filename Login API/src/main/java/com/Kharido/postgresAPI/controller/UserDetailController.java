package com.Kharido.postgresAPI.controller;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.services.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {

@Autowired
    UserDetailServiceImpl userDetailService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ResponseEntity<String> addOrUpdateEmployee(@RequestBody UserDetail userDetail) {
        System.out.println(userDetail);

        UserDetail userDetail1 = userDetailService.save(userDetail);
        return new ResponseEntity<String>(userDetail1.getFullName(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/check")
    public ResponseEntity<String> checkUser(@RequestBody UserLoginDetails userLoginDetails){
        System.out.println("Inside checkUser, userName: " + userLoginDetails.getEmailId() + ", password: " + userLoginDetails.getPassword());
        UserDetailsEntity userLoginDetailEntity = userDetailService.getOneByEmailId(userLoginDetails.getEmailId());
        if (userLoginDetailEntity == null) {
            System.out.println("User Not Found !");
            return new ResponseEntity<String>(String.valueOf(false),HttpStatus.OK);
        }
        boolean result = userLoginDetailEntity.getPassword().equals(userLoginDetails.getPassword());
        System.out.println("Password Matched: " + result);
        return new ResponseEntity<String>(String.valueOf(result),HttpStatus.OK);
    }





}
