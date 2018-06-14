package com.product_merchant_relation.InventoryAPI.repository;

import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface PidMidRelationRepository extends CrudRepository<PidMidRelationEntity,String> {

    //public PidMidRelationEntity save(PidMidRelationEntity pidMidRelationEntity);
    public void deleteByPmId(String pmId);




}
