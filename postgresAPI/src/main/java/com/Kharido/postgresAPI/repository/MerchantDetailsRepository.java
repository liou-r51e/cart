package com.Kharido.postgresAPI.repository;

import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface MerchantDetailsRepository extends CrudRepository<MerchantDetailsEntity,String> {

    public MerchantDetailsEntity findOneByEmailId(String emailID);

}