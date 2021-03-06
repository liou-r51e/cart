package com.Kharido.postgresAPI.services;

import com.Kharido.postgresAPI.dto.UserDetail;
import com.Kharido.postgresAPI.entity.UserDetailsEntity;

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

    public UserDetailsEntity getOneByEmailId(String firstName);

    //public List<UserLoginDetailEntity> getByFirstNameAndLastName(String firstName, String lastName);
}
