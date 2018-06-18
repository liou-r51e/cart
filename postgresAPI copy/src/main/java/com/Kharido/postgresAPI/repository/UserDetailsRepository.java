package com.Kharido.postgresAPI.repository;

import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity,String> {


    //Todo : Phani : this can be done by findById, since emailID is primary key
 //   public UserDetailsEntity findOneByEmailId(String emailID);

}
