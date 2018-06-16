package com.product_merchant_relation.InventoryAPI.repository;

import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PidMidRelationRepository extends CrudRepository<PidMidRelationEntity,String> {

    //public PidMidRelationEntity save(PidMidRelationEntity pidMidRelationEntity);
    public void deleteByPmId(String pmId);
    public List<PidMidRelationEntity> findAllByMerchantId(String merchantId);
    public List<PidMidRelationEntity> findAllByProductId(int productId);



}
