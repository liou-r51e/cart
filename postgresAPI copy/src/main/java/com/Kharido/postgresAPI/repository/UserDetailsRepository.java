package com.Kharido.postgresAPI.repository;

import com.Kharido.postgresAPI.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity,String> {

}
