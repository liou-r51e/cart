package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import com.Kharido.postgresAPI.repository.UserDetailsRepository;
import com.Kharido.postgresAPI.services.UserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public Optional<UserDetailsEntity> findOne(String emailId) {
        return (userDetailsRepository.findById(emailId));
    }

    @Override
    public UserDetail save(UserDetail userDetail) {

        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
            BeanUtils.copyProperties(userDetail, userDetailsEntity);
            userDetailsRepository.save(userDetailsEntity);
            //Todo : Phani : remove system.out.println
            System.out.println(userDetailsEntity.getEmailId());
            //Todo : Phani : what is the need of this code?
            UserDetail response = new UserDetail();
            BeanUtils.copyProperties(userDetailsEntity, response);
            return response;
    }

    @Override
    public boolean exists(String emailId) {
       return userDetailsRepository.existsById(emailId);
    }

    @Override
    public List<UserDetailsEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<UserDetailsEntity> findAll(Iterable<String> userId) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public void delete(UserDetailsEntity employee) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UserDetailsEntity> getByFirstName(String fullName) {
        return null;
    }

   @Override
    public UserDetailsEntity getOneByEmailId(String emailId) {
     UserDetailsEntity userLoginDetailEntity = userDetailsRepository.findById(emailId).get();
        return userLoginDetailEntity;
    }

    @Override
    public String userLogin(UserLoginDetails userLoginDetails) {
        if(userDetailsRepository.existsById(userLoginDetails.getEmailId())==false){

            return ("Email is not registered...");
        }

       UserDetailsEntity userLoginDetailEntity = userDetailsRepository.findById(userLoginDetails.getEmailId()).get();
        if (userLoginDetailEntity == null) {
            //Todo : Phani : remove system.out.println, use logger instead
            System.out.println("User Not Found...");
            return ("Email is not registered...");
        }
        boolean userPassWordCheck = userLoginDetailEntity.getPassword().equals(userLoginDetails.getPassword());
        if(userPassWordCheck == false)
        {
            return ("Username/Password incorrect...");
        }
        return ("true");

    }


}
