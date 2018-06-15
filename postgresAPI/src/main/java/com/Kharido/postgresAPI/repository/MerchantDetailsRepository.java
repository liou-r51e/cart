package com.Kharido.postgresAPI.repository;

import com.Kharido.postgresAPI.entity.MerchantDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDetailsRepository extends CrudRepository<MerchantDetailsEntity,String> {

    //public MerchantDetailsEntity findOneByMerchantId(String merchantID);

}
