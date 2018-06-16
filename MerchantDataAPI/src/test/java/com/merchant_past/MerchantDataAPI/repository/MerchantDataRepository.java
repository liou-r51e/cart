package com.merchant_past.MerchantDataAPI.repository;

import com.merchant_past.MerchantDataAPI.entity.MerchantDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDataRepository extends CrudRepository<MerchantDataEntity,String>  {
}
