package com.product_merchant_relation.InventoryAPI.services;


import com.product_merchant_relation.InventoryAPI.entity.PidMidRelationEntity;
import com.product_merchant_relation.InventoryAPI.repository.PidMidRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class PidMidRelationServicesImpl implements PidMidRelationServices {

    @Autowired
    PidMidRelationRepository pidMidRelationRepository;

    @Override
    public boolean updateInventory(String pmId, int inventory) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        pidMidRelationEntity.setInventory(inventory);

        return pidMidRelationEntity.equals(pidMidRelationRepository.save(pidMidRelationEntity));
    }

    @Override
    public boolean updateCost(String pmId, int cost) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        pidMidRelationEntity.setCost(cost);

        return pidMidRelationEntity.equals(pidMidRelationRepository.save(pidMidRelationEntity));
    }


    @Override
    public boolean deleteInventory(String pmId) {
        pidMidRelationRepository.deleteByPmId(pmId);
        return true;
    }

    @Override
    public boolean addInventory(PidMidRelationEntity pidMidRelationEntity) {
        String pmId = pidMidRelationEntity.getProductId()+pidMidRelationEntity.getMerchantId();
        pidMidRelationEntity.setPmId(pmId);
        PidMidRelationEntity pidMidRelationEntityNew = pidMidRelationRepository.save(pidMidRelationEntity);

        return pidMidRelationEntity.equals(pidMidRelationEntityNew);
    }

    @Override
    @Transactional(readOnly = true)
    public int getInventory(String pmId) {
        PidMidRelationEntity pidMidRelationEntity = pidMidRelationRepository.findById(pmId).get();
        return pidMidRelationEntity.getInventory();
    }

    @Override
    @Transactional(readOnly = true)
    public PidMidRelationEntity getPidMidRelation(String pmId) {

        return pidMidRelationRepository.findById(pmId).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PidMidRelationEntity> getAll() {
        return (List)pidMidRelationRepository.findAll();
    }

    @Override
    public List<PidMidRelationEntity> getMerchants(int productId) {
        return (List)pidMidRelationRepository.findAllByProductId(productId);
    }

    @Override
    public List<PidMidRelationEntity> getProducts(String merchantId) {
        return (List)pidMidRelationRepository.findAllByMerchantId(merchantId);
    }
}
