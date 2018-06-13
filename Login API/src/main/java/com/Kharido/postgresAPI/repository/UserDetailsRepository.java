package com.Kharido.postgresAPI.repository;

import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity,String> {


    public UserDetailsEntity findOneByEmailId(String firstName);

}
