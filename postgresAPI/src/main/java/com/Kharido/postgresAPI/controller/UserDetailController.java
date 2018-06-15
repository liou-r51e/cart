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
//Todo : Phani : URL mapping avoid _
@RequestMapping("/userGateway")
public class UserDetailController {

    @Autowired
    UserDetailServiceImpl userDetailService;



    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<Boolean> addOrUpdateUser(@RequestBody UserDetail userDetail) {
        System.out.println(userDetail);

        //Todo : Phani : what does bool mean in the current code context?
        Boolean existingUser;
        existingUser = userDetailService.exists(userDetail.getEmailId());
        if (existingUser == true) {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);

        }
        UserDetail userDetail1 = userDetailService.save(userDetail);
        //Todo : Phani : why is the boolean check required ? you can always return true in this case

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> checkUser(@RequestBody UserLoginDetails userLoginDetails) {
        //Todo : Phani : remove system.out.println, user logger instead
        System.out.println("Inside checkUser, userName: " + userLoginDetails.getEmailId() + ", password: " + userLoginDetails.getPassword());
        //Todo : Phani : should not pass entity to controller in this case!!


       String response =  userDetailService.userLogin(userLoginDetails);
        System.out.println(response);
return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUserDetails/{emailId}")
    public ResponseEntity<UserDetailsEntity> getOneUser(@PathVariable("emailId") String emailId) {
        UserDetailsEntity userDetailsEntity = userDetailService.getOneByEmailId(emailId);
        UserDetail userDetail = new UserDetail();
        //Todo : Phani : remove commented code
//
//            if (userDetailsEntity.get() == null) {
//                return new ResponseEntity<UserDetailsEntity>("", HttpStatus.OK);
//            }
        BeanUtils.copyProperties(userDetailsEntity, userDetail);
        userDetailsEntity.setPassword("");
        return new ResponseEntity<UserDetailsEntity>(userDetailsEntity, HttpStatus.OK);
    }

    //Todo : Phani : move all this code out to a different controller
    //!!----MERCHANT CONTROLLERS---------!!

}
