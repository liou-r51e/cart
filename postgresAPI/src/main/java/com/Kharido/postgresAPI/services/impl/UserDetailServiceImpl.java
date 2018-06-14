package com.Kharido.postgresAPI.services.impl;

import com.Kharido.postgresAPI.dto.UserDetail;
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
    public UserDetailsEntity findOne(String emailId) {
        return (userDetailsRepository.findOneByEmailId(emailId));
    }

    @Override
    public UserDetail save(UserDetail userDetail) {

        UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
            BeanUtils.copyProperties(userDetail, userDetailsEntity);
            userDetailsRepository.save(userDetailsEntity);
            System.out.println(userDetailsEntity.getEmailId());
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
     UserDetailsEntity userLoginDetailEntity = userDetailsRepository.findOneByEmailId(emailId);
        return userLoginDetailEntity;
    }


}
