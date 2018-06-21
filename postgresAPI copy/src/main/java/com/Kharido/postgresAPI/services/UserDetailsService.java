package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.dto.UserLoginDetails;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserDetailsService {

    public Optional<UserDetailsEntity> findOne(String userId);

    public UserDetail save(UserDetail userDetail);

    public boolean exists(String userId);

    public List<UserDetailsEntity> findAll();

    public Iterable<UserDetailsEntity> findAll(Iterable<String> userId);

    public long count();

    public void delete(String userId);

    public void delete(UserDetailsEntity employee);

    public void deleteAll();

    public List<UserDetailsEntity> getByFirstName(String fullName);

    public UserDetailsEntity getOneByEmailId(String emailId);

    public String userLogin(UserLoginDetails userDetail);

    public int emailValidation(String emailId);

    public Boolean updateAddress(String emailId, String address);

    //public List<UserLoginDetailEntity> getByFirstNameAndLastName(String firstName, String lastName);
}
